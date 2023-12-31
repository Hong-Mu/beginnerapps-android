package com.hongmu.diet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MemoAdapter(var list: List<MainActivity.MemoModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var convertView = p1
        if(convertView == null) {
            convertView = LayoutInflater.from(p2?.context).inflate(R.layout.item_memo, p2, false)
        }
        convertView!!.findViewById<TextView>(R.id.text_date).text = list[p0].date
        convertView.findViewById<TextView>(R.id.text_title).text = list[p0].memo
        return convertView
    }
}