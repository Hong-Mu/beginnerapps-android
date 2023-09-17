package com.hongmu.trot

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hongmu.trot.databinding.ItemSongBinding

class SongListAdapter(val list: List<String>) : RecyclerView.Adapter<SongListAdapter.SongListViewHolder>() {
    inner class SongListViewHolder(val binding: ItemSongBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(title: String) {
            binding.textTitle.text = title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongListViewHolder {
        val binding = ItemSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SongListViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: SongListViewHolder, position: Int) {
        holder.bind(list[position])
    }
}