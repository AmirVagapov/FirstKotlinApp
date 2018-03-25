package com.vagapov.amir.firstkotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.vagapov.amir.firstkotlinapp.adapter.CoinAdapter
import com.vagapov.amir.firstkotlinapp.api.ServerGenerator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class MainActivity : AppCompatActivity() {

    private lateinit var adapter : CoinAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager=LinearLayoutManager(this)
        adapter = CoinAdapter()
        recyclerView.adapter = adapter

        loadData()
    }

    private fun loadData() {
        (launch(UI) {
            try {
                adapter.data=ServerGenerator.getApi().loadData(20).await()
            }catch (ex:Exception){
                Toast.makeText(this@MainActivity, ex.localizedMessage, Toast.LENGTH_LONG).show()
            }
        })
    }
}
