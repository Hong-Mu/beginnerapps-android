package com.hongmu.mangoplate

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app
import com.hongmu.mangoplate.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    private val binding by lazy { ActivityWebViewBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val ref = Firebase.database.getReference("bookmarks").child(Firebase.auth.currentUser!!.uid)
        val model = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("model", RestaurantModel::class.java)!!
        } else {
            intent.getParcelableExtra("model")!!
        }


        binding.webView.loadUrl(model.url)
        binding.textSave.setOnClickListener {
            ref.push()
                .setValue(model)
        }
    }
}