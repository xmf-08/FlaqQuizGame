package com.example.flagquizgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        btn_Asia.setOnClickListener {
            val intent = Intent(this@MainActivity, Play::class.java)
            intent.putExtra("cals", 0)
            startActivity(intent)
        }
        btn_Europe.setOnClickListener {
            val intent = Intent(this@MainActivity, Play::class.java)
            intent.putExtra("cals", 1)
            startActivity(intent)
        }
        btn_NorthAmerica.setOnClickListener {
            val intent = Intent(this@MainActivity, Play::class.java)
            intent.putExtra("cals", 2)
            startActivity(intent)
        }
        btn_SouthAmerica.setOnClickListener {
            val intent = Intent(this@MainActivity, Play::class.java)
            intent.putExtra("cals", 3)
            startActivity(intent)
        }
        btn_Africa.setOnClickListener {
            val intent = Intent(this@MainActivity, Play::class.java)
            intent.putExtra("cals", 4)
            startActivity(intent)
        }
        btn_Australia.setOnClickListener {
            val intent = Intent(this@MainActivity, Play::class.java)
            intent.putExtra("cals", 5)
            startActivity(intent)
        }
    }
}