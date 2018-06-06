package com.vagapov.amir.firstkotlinapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.vagapov.amir.firstkotlinapp.R
import com.vagapov.amir.firstkotlinapp.model.CoinCap
import kotlinx.android.synthetic.main.item_coin.view.*

class CoinAdapter : RecyclerView.Adapter<MyViewHolder>() {

    var data: List<CoinCap>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
            ///comment for branch 1.0
        }

    fun newMethodToVersionOne() {

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        data?.get(position)?.let { coin ->
            holder.view.tvName.text = coin.name
            holder.view.tvSymbol.text = coin.symbol
            holder.view.tvPrice.text = "$${coin.price_usd}"
            holder.view.tvPriceChange.text = if (coin.percent_change_24h > 0)
                "+${coin.percent_change_24h}"
            else
                "${coin.percent_change_24h}%"
        }
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent, false))
    }
}