package com.example.flagquizgame

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_starter.*

class starter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starter)

//        val mediaPlay = MediaPlayer.create(this, R.raw.feel)
//        mediaPlay.start()

        start_txt.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
//        A.setOnClickListener{
//            val intent = Intent(this, A::class.java)
//            startActivity(intent)
//        }
    }
}