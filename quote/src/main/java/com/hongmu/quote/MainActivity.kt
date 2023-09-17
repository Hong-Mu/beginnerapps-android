package com.hongmu.quote

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hongmu.quote.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textQuote.text = listOf(
            "큰 목표를 이루고 싶으면 허락을 구하지 마라.",
            "상황을 가장 잘 활용하는 사람이 가장 좋은 상황을 맞는다.",
            "창조적인 삶을 살려면 내가 틀릴지도 모른다는 공포를 버려야 한다.",
            "일반적인 것을 잃을 위험을 감수하지 않으면 평범한 것에 만족해야 한다.",
            "신뢰의 이유는 안전하거나 확실해서가 아니라, 위험을 감수할 용의가 있어서이다.",
            "한 가지 생각을 선택하라. 그 생각을 당신의 삶으로 만들어라. 그걸 생각하고, 꿈꾸고, 그에 기반해서 살아가라. 당신의 몸의 모든 부분, 뇌, 근육, 신경을 그 생각으로 가득 채우고 다른 생각은 다 내버려둬라. 이것이 성공하는 방법이다.",
            "추구할 수 있는 용기가 있다면 우리의 모든 꿈은 이뤄질 수 있다.",
            "기다리는 사람에게 좋은 일이 생기지만, 찾아나서는 사람에게는 더 좋은 일이 생긴다.",
            "늘 하던 대로 하면 늘 얻던 것을 얻는다.",
        ).random()

        binding.btnList.setOnClickListener {
            startActivity(Intent(this, QuoteListActivity::class.java))
        }
    }
}