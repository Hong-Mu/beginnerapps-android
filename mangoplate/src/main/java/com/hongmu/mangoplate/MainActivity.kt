package com.hongmu.mangoplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.hongmu.mangoplate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = RestaurantAdapter(
            listOf(
                RestaurantModel(
                    "https://mp-seoul-image-production-s3.mangoplate.com/sources/web/restaurants/361258/47875_1547431886257?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=50",
                    "모찌방",
                    "https://www.mangoplate.com/restaurants/2u-4-3abGwI4",
                ),
                RestaurantModel(
                    "https://mp-seoul-image-production-s3.mangoplate.com/705256_1563230541781542.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=50",
                    "희카롱",
                    "https://www.mangoplate.com/restaurants/MrqU4Wa9eMP0",
                ),
                RestaurantModel(
                    "https://mp-seoul-image-production-s3.mangoplate.com/413935/f_jwqs1ufrzqvb.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=50",
                    "더피자스탠드",
                    "https://www.mangoplate.com/restaurants/epqUkC49M9R5",
                ),
                RestaurantModel(
                    "https://mp-seoul-image-production-s3.mangoplate.com/237003/797961_1685592023227_47265?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=50",
                    "명랑회관",
                    "https://www.mangoplate.com/restaurants/vAGwdLA9j1IM",
                ),
                RestaurantModel(
                    "https://mp-seoul-image-production-s3.mangoplate.com/73312/627630_1513313863731_9353?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=50",
                    "카토멘",
                    "https://www.mangoplate.com/restaurants/FSAXn4cFvA",
                ),
                RestaurantModel(
                    "https://mp-seoul-image-production-s3.mangoplate.com/sources/web/restaurants/361258/47875_1547431886257?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=50",
                    "모찌방",
                    "https://www.mangoplate.com/restaurants/2u-4-3abGwI4",
                ),
                RestaurantModel(
                    "https://mp-seoul-image-production-s3.mangoplate.com/705256_1563230541781542.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=50",
                    "희카롱",
                    "https://www.mangoplate.com/restaurants/MrqU4Wa9eMP0",
                ),
                RestaurantModel(
                    "https://mp-seoul-image-production-s3.mangoplate.com/413935/f_jwqs1ufrzqvb.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=50",
                    "더피자스탠드",
                    "https://www.mangoplate.com/restaurants/epqUkC49M9R5",
                ),
                RestaurantModel(
                    "https://mp-seoul-image-production-s3.mangoplate.com/237003/797961_1685592023227_47265?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=50",
                    "명랑회관",
                    "https://www.mangoplate.com/restaurants/vAGwdLA9j1IM",
                ),
                RestaurantModel(
                    "https://mp-seoul-image-production-s3.mangoplate.com/73312/627630_1513313863731_9353?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=50",
                    "카토멘",
                    "https://www.mangoplate.com/restaurants/FSAXn4cFvA",
                ),
            )
        )

        adapter.onClickListener = object : RestaurantAdapter.OnClickListener {
            override fun onClick(view: View, position: Int) {
                startActivity(Intent(this@MainActivity, WebViewActivity::class.java).apply {
                    putExtra("model", adapter.list[position])
                })
            }
        }
        binding.rvRestaurant.adapter = adapter

        binding.btnSignOut.setOnClickListener {
            Firebase.auth.signOut()
            finish()
        }

        binding.btnBookmarks.setOnClickListener {
            startActivity(Intent(this, BookmarkActivity::class.java))
        }
    }
}