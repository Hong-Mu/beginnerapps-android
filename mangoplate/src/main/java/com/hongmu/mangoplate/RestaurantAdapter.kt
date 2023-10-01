package com.hongmu.mangoplate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hongmu.mangoplate.databinding.ItemRestaurantBinding

class RestaurantAdapter(var list: List<RestaurantModel>) : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>(){

    var onClickListener: OnClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = ItemRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            onClickListener?.onClick(it, position)
        }
    }

    inner class RestaurantViewHolder(val binding: ItemRestaurantBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RestaurantModel) {
            binding.textTitle.text = item.name

            Glide.with(binding.root)
                .load(item.imageUrl)
                .into(binding.imageRestaurant)

        }
    }

    interface OnClickListener {
        fun onClick(view: View, position: Int)
    }

}