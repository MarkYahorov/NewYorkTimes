package com.example.wire.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.wire.R
import com.example.wire.databinding.WireCategoryBinding
import com.example.wire.presentation.data.presentation.WireCategory

class WireCategoryAdapter(private val onItemClicked: (String) -> Unit) :
    ListAdapter<WireCategory, WireCategoryViewHolder>(WireDiffUtils()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WireCategoryViewHolder {
        val binding =
            WireCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WireCategoryViewHolder(binding).apply {
            itemView.setOnClickListener {
                onItemClicked.invoke(currentList[adapterPosition].section)
            }
        }
    }

    override fun onBindViewHolder(holder: WireCategoryViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}

class WireCategoryViewHolder(private val binding: WireCategoryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(category: WireCategory) {
        with(binding) {
            wireCategoryName.text = category.name
            if (category.isSelected) {
                wireCategoryName.setTextColor(root.context.resources.getColor(R.color.white))
                root.setCardBackgroundColor(root.context.resources.getColor(R.color.selected_color))
            } else {
                wireCategoryName.setTextColor(root.context.resources.getColor(R.color.black))
                root.setCardBackgroundColor(root.context.resources.getColor(R.color.white))
            }
        }
    }
}

class WireDiffUtils : DiffUtil.ItemCallback<WireCategory>() {
    override fun areItemsTheSame(oldItem: WireCategory, newItem: WireCategory) =
        oldItem.isSelected == newItem.isSelected

    override fun areContentsTheSame(oldItem: WireCategory, newItem: WireCategory) =
        oldItem == newItem
}