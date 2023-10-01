package com.hongmu.mangoplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.hongmu.mangoplate.databinding.ActivityJoinBinding

class JoinActivity : AppCompatActivity() {
    private val binding by lazy { ActivityJoinBinding.inflate(layoutInflater) }
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        auth = Firebase.auth

        binding.btnJoin.setOnClickListener {
            auth.createUserWithEmailAndPassword(
                binding.inputEmail.text.toString(),
                binding.inputPassword.text.toString()
            ).addOnCompleteListener { task ->
                if(task.isSuccessful) {
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}