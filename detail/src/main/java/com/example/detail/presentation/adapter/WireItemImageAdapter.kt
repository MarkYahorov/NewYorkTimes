package com.example.detail.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.detail.databinding.WireItemImageLayoutBinding

class WireItemImageAdapter(private val glide: RequestManager) :
    ListAdapter<String, WireItemImageHolder>(WireItemImageDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WireItemImageHolder {
        val binding = WireItemImageLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return WireItemImageHolder(binding, glide)
    }

    override fun onBindViewHolder(holder: WireItemImageHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun onViewRecycled(holder: WireItemImageHolder) {
        super.onViewRecycled(holder)

        holder.unBind()
    }
}

class WireItemImageHolder(
    private val binding: WireItemImageLayoutBinding,
    private val glide: RequestManager
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(path: String) {
        glide.load(path)
            .into(binding.imageView)
    }

    fun unBind() {
        glide.clear(binding.imageView)
    }

}

class WireItemImageDiffUtils : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
}