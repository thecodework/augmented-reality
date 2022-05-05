package com.thecodework.augmentedreality

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    private lateinit var tvView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initializer()
        setListener()
    }

    private fun initializer() {
        Utils.changeStatusBar(this@HomeActivity, R.color.lowpink)
        tvView = findViewById(R.id.tvView)
    }

    private fun setListener() {
        tvView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


}