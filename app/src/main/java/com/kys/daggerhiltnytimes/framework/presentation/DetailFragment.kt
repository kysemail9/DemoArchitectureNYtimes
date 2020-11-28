package com.kys.daggerhiltnytimes.framework.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.kys.daggerhiltnytimes.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class DetailFragment
constructor(
    private val someString: String
) : Fragment(R.layout.fragment_detail) {

    private val TAG: String = "AppDebug"
    lateinit var recipient: String
    lateinit var articleDetail: ArticleDetail


    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments!!.getString("recipient").toString()
        articleDetail = arguments!!.getParcelable("article")!!
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "DetailFragment: ${someString}")
        setView();
    }

    private fun setView() {

        val detail = articleDetail!!.detail
        val url = articleDetail!!.url
        Log.e("DetailFragment", "abstract : $detail")
        tvAbstract.text = detail

        if (url.isNotEmpty()) {
            Glide.with(this)
                .load(url)
                .into(ivMain)
        } else {
            Glide.with(this)
                .load(R.drawable.ic_image_default)
                .into(ivMain)
        }
    }
}