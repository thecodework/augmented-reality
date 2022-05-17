package com.thecodework.augmentedreality

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    private lateinit var tvView: Button
    private lateinit var tvHorse: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initializer()
        setListener()
    }

    private fun initializer() {
        Utils.changeStatusBar(this@HomeActivity, R.color.lowpink)
        tvView = findViewById(R.id.tvView)
        tvHorse = findViewById(R.id.tvHorse)
    }

    private fun setListener() {
        tvView.setOnClickListener {
            model("astro/astronaut.glb")
        }
        tvHorse.setOnClickListener {
            model("astro/horse.glb")
        }
    }

    private fun model(model: String) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("model", model)
        startActivity(intent)
    }


}