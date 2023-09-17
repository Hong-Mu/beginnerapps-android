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

class Signer3Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_signer3, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = SongListAdapter(listOf(
            "가인 노래 1",
            "가인 노래 2",
            "가인 노래 3",
            "가인 노래 4",
        ))
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        val image1 = view.findViewById<ImageView>(R.id.image1)
        image1.setOnClickListener {
            findNavController().navigate(R.id.action_signer3Fragment_to_signer1Fragment)
        }

        val image2 = view.findViewById<ImageView>(R.id.image2)
        image2.setOnClickListener {
            findNavController().navigate(R.id.action_signer3Fragment_to_signer1Fragment)
        }
        return view
    }
}