package com.johncodeos.pulltorefreshexample

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainActivity : AppCompatActivity() {

    private lateinit var itemsCells: ArrayList<String?>
    private lateinit var adapter: ItemsRVAdapter
    private lateinit var itemsRv: RecyclerView
    private var refreshTimes = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set the data for our ArrayList
        setItemsData(refreshTimes)

        itemsRv = findViewById(R.id.items_rv)

        // Set the adapter of the RecyclerView
        setAdapter()

        // Set the Layout Manager of the RecyclerView
        setRVLayoutManager()

        // Set the colors of the Pull To Refresh View
        val itemsSwipeToRefresh = findViewById<SwipeRefreshLayout>(R.id.items_swipe_to_refresh)
        itemsSwipeToRefresh.setProgressBackgroundColorSchemeColor(ContextCompat.getColor(this, R.color.colorPrimary))
        itemsSwipeToRefresh.setColorSchemeColors(Color.WHITE)


        itemsSwipeToRefresh.setOnRefreshListener {
            itemsCells.clear()
            refreshTimes = +refreshTimes + 5
            setItemsData(refreshTimes)
            adapter = ItemsRVAdapter(itemsCells)
            itemsRv.adapter = adapter
            itemsSwipeToRefresh.isRefreshing = false
        }
    }


    private fun setItemsData(moreData: Int) {
        itemsCells = ArrayList()
        for (i in 0..20 + moreData) {
            itemsCells.add("Item $i")
        }
    }

    private fun setAdapter() {
        adapter = ItemsRVAdapter(itemsCells)
        adapter.notifyDataSetChanged()
        itemsRv.adapter = adapter
    }

    private fun setRVLayoutManager() {
        val mLayoutManager = LinearLayoutManager(itemsRv.context)
        //**Shows the latest item of the RecyclerView first.
        mLayoutManager.reverseLayout = true
        mLayoutManager.stackFromEnd = true
        //**
        itemsRv.layoutManager = mLayoutManager
        itemsRv.setHasFixedSize(true)
    }
}
