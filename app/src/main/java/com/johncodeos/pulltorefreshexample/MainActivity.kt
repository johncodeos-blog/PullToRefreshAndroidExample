package com.johncodeos.pulltorefreshexample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var itemsCells: ArrayList<String?>
    lateinit var adapter: Items_RVAdapter

    var refreshTimes = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //** Set the data for our ArrayList
        setItemsData(refreshTimes)

        //** Set the adapter of the RecyclerView
        setAdapter()

        //** Set the Layout Manager of the RecyclerView
        setRVLayoutManager()

        //** Set the colors of the Pull To Refresh View
        itemsswipetorefresh.setProgressBackgroundColorSchemeColor(ContextCompat.getColor(this, R.color.colorPrimary))
        itemsswipetorefresh.setColorSchemeColors(Color.WHITE)


        itemsswipetorefresh.setOnRefreshListener {
            itemsCells.clear()
            refreshTimes =+ refreshTimes + 5
            setItemsData(refreshTimes)
            adapter = Items_RVAdapter(itemsCells)
            itemsrv.adapter = adapter
            itemsswipetorefresh.isRefreshing = false
        }
    }



    private fun setItemsData(moreData: Int) {
        itemsCells = ArrayList()
        for (i in 0..20+moreData) {
            itemsCells.add("Item $i")
        }
    }

    private fun setAdapter() {
        adapter = Items_RVAdapter(itemsCells)
        adapter.notifyDataSetChanged()
        itemsrv.adapter = adapter
    }

    private fun setRVLayoutManager() {
        val mLayoutManager = LinearLayoutManager(itemsrv.context)
        //**Shows the latest item of the RecyclerView first.
        mLayoutManager.reverseLayout = true
        mLayoutManager.stackFromEnd = true
        //**
        itemsrv.layoutManager = mLayoutManager
        itemsrv.setHasFixedSize(true)
    }
}
