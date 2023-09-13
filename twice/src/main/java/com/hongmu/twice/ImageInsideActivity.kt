package com.hongmu.twice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class ImageInsideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_inside)

        val data = intent.getStringExtra("data")
        // Toast.makeText(this, data, Toast.LENGTH_SHORT).show()

        val resourceId = when(data) {
            "1" -> R.id.image_1
            "2" -> R.id.image_2
            "3" -> R.id.image_3
            "4" -> R.id.image_4
            "5" -> R.id.image_5
            "6" -> R.id.image_6
            "7" -> R.id.image_7
            "8" -> R.id.image_8
            "9" -> R.id.image_9
            else -> R.id.image_1
        }

        val image = findViewById<ImageView>(R.id.memberImage)
        image.setImageResource(resourceId)
    }
}