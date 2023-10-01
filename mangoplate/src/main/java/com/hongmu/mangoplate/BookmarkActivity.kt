package com.hongmu.mangoplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.hongmu.mangoplate.databinding.ActivityBookmarkBinding

class BookmarkActivity : AppCompatActivity() {
    private val binding by lazy { ActivityBookmarkBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = RestaurantAdapter(listOf())
        binding.recyclerView.adapter = adapter

        val ref = Firebase.database.getReference("bookmarks").child(Firebase.auth.currentUser!!.uid)
        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                adapter.list = snapshot.children.map {
                    it.getValue(RestaurantModel::class.java)!!
                }.toList()
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}