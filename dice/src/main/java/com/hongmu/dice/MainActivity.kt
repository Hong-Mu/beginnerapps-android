package com.hongmu.dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.hongmu.dice.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnRoll.setOnClickListener {
            Toast.makeText(this, "주사위 GO! ", Toast.LENGTH_SHORT).show()

            binding.image1.setDice(Random.nextInt(1, 7))
            binding.image2.setDice(Random.nextInt(1, 7))
        }
    }

    private fun ImageView.setDice(n: Int) {
        this.setImageResource(when(n) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        })
    }
}