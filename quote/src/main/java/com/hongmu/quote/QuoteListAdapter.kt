package com.hongmu.quote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class QuoteListAdapter(var list: List<String>) : BaseAdapter() {
    override fun getCount() = list.size

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        if(convertView == null) {
            convertView = LayoutInflater.from(parent?.context).inflate(R.layout.item_quote, parent, false)
        }

        convertView?.findViewById<TextView>(R.id.text_quote)?.setText(list[position])

        return convertView!!
    }
}