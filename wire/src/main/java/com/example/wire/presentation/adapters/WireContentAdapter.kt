package com.example.wire.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.wire.R
import com.example.wire.databinding.WireItemBinding
import com.example.wire.presentation.data.presentation.WireItem

class WireContentAdapter(
    private val onItemClicked: (String) -> Unit,
    private val glide: RequestManager
) : ListAdapter<WireItem, WireContentViewHolder>(WireItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WireContentViewHolder {
        val binding = WireItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WireContentViewHolder(binding, glide).apply {
            this.itemView.setOnClickListener { onItemClicked.invoke(currentList[adapterPosition].id) }
        }
    }

    override fun onBindViewHolder(holder: WireContentViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun onViewRecycled(holder: WireContentViewHolder) {
        super.onViewRecycled(holder)

        holder.unBind()
    }

}

class WireContentViewHolder(
    private val binding: WireItemBinding,
    private val glide: RequestManager
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(wireItem: WireItem) {
        with(binding) {
            wireItemTitle.text = wireItem.title
            if (wireItem.previewImage != null) {
                glide.load(wireItem.previewImage)
                    .into(wirePreviewImage)
            } else {
                glide.load(R.drawable.empty_preview)
                    .into(wirePreviewImage)
            }
        }
    }

    fun unBind() {
        glide.clear(binding.wirePreviewImage)
    }
}

class WireItemDiffUtil : DiffUtil.ItemCallback<WireItem>() {
    override fun areItemsTheSame(oldItem: WireItem, newItem: WireItem) =
        oldItem.title == newItem.title

    override fun areContentsTheSame(oldItem: WireItem, newItem: WireItem) = oldItem == newItem

}
