package com.kys.daggerhiltnytimes.framework.presentation

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.kys.daggerhiltnytimes.R
import com.kys.daggerhiltnytimes.business.domain.models.Result
import com.kys.daggerhiltnytimes.databinding.ItemResultBinding

class ResultsAdapter(private val listener: ResultsItemListener) :
    RecyclerView.Adapter<ResultsViewHolder>() {

    interface ResultsItemListener {
        fun onClickedResult(detail: String, url: String)
    }

    private val items = ArrayList<Result>()

    fun setItems(items: ArrayList<Result>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultsViewHolder {
        val binding: ItemResultBinding =
            ItemResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResultsViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ResultsViewHolder, position: Int) =
        holder.bind(items[position])
}

class ResultsViewHolder(
    private val itemBinding: ItemResultBinding,
    private val listener: ResultsAdapter.ResultsItemListener
) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var result: Result

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Result) {

        this.result = item
        itemBinding.tvTitle.text = item.title
        itemBinding.tvDetail.text =
            """${item.section}"""//"""${item.section} - ${item.subsection}"""

        if (!item.media.isNullOrEmpty()) {
            Glide.with(itemBinding.root).load(item.media[0].media_metadata[0].url).transform(CircleCrop()).into(itemBinding.ivStandard)

            Log.e(
                "Adapter",
                "For index : " + adapterPosition + " --> url : " + item.media[0].media_metadata[0].url
            )
            Log.e(
                "Adapter",
                "For index : " + adapterPosition + " --> title : " + item.title
            )
        } else {
            Log.e(
                "Adapter",
                "Else For index : " + adapterPosition + " --> title : " + item.title
            )
            Glide.with(itemBinding.root).load(R.drawable.ic_image_default).transform(CircleCrop()).into(itemBinding.ivStandard)
        }
    }

    override fun onClick(v: View?) {
        Log.e(
            "Adapter",
            "OnClick: " + adapterPosition + " --> abstract : " + result.abstract_detail
        )

        listener.onClickedResult(
            result.abstract_detail,
            if (!result.media.isNullOrEmpty()) result.media[0].media_metadata[1].url else ""
        )
    }
}

