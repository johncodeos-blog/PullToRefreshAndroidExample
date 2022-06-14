package com.johncodeos.pulltorefreshexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsRVAdapter(private var itemsCells: ArrayList<String?>) :
    RecyclerView.Adapter<ItemsRVAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemsRVAdapter.ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemsCells.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val itemTextView = holder.itemView.findViewById<TextView>(R.id.item_text_view)
        itemTextView.text = itemsCells[position]
    }


}