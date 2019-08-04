package com.johncodeos.pulltorefreshexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class Items_RVAdapter(private var itemsCells: ArrayList<String?>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemsCells.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolder = holder as ItemViewHolder
        itemViewHolder.itemView.itemtextview.text = itemsCells[position]
    }


}