package com.hongmu.trot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Signer2Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_signer2, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = SongListAdapter(listOf(
            "영웅 노래 1",
            "영웅 노래 2",
            "영웅 노래 3",
            "영웅 노래 4",
        ))
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        val image1 = view.findViewById<ImageView>(R.id.image1)
        image1.setOnClickListener {
            findNavController().navigate(R.id.action_signer2Fragment_to_signer1Fragment)
        }

        val image3 = view.findViewById<ImageView>(R.id.image3)
        image3.setOnClickListener {
            findNavController().navigate(R.id.action_signer2Fragment_to_signer3Fragment)
        }
        return view
    }
}