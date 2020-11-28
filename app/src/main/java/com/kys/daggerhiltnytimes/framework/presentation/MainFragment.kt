package com.kys.daggerhiltnytimes.framework.presentation

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.kys.daggerhiltnytimes.R
import com.kys.daggerhiltnytimes.business.domain.models.Result
import com.kys.daggerhiltnytimes.business.domain.state.DataState
import com.kys.daggerhiltnytimes.framework.presentation.MainStateEvent.GetResultsEvent
import com.kys.daggerhiltnytimes.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainFragment
constructor(
    private val someString: String
) : Fragment(R.layout.fragment_main), ResultsAdapter.ResultsItemListener {

    private val TAG: String = "AppDebug"

    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: ResultsAdapter
    private var navController: NavController? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        subscribeObservers()
        viewModel.setStateEvent(GetResultsEvent)
        navController = Navigation.findNavController(view)
        Log.d(TAG, "MainFragment: ${someString}")
    }

    private fun initRecyclerView() {
        adapter = ResultsAdapter(this)
        rvResults.layoutManager = LinearLayoutManager(requireContext())
        rvResults.adapter = adapter
    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            when (dataState) {
                is DataState.Success<List<Result>> -> {
                    displayProgressBar(false)
                    displayResults(dataState.data)
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        })
    }

    private fun displayError(message: String?) {
        if (message != null) text.text = message else text.text = "Unknown error."
    }

    private fun displayResults(results: List<Result>) {

        if (!results.isNullOrEmpty()) adapter.setItems(ArrayList(results))
    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        progress_bar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }

    override fun onClickedResult(detail: String, url: String) {

        Log.e(
            "MainFragment",
            "onClickedResult : $detail"
        )

        if (!TextUtils.isEmpty(detail)) { // add one more param

            val articleDetail = ArticleDetail(detail, url)
            val bundle = bundleOf(
                "recipient" to "TempR",
                "article" to articleDetail
            )
            navController!!.navigate(R.id.action_mainFragment_to_detailFragment, bundle)
        }
    }
}