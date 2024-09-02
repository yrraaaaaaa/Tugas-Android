package com.example.is4_10522126

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class ProfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val imgPhoto: ImageView = findViewById(R.id.imgPhoto)
        val tvNama: TextView = findViewById(R.id.tvNama)
        val tvNim: TextView = findViewById(R.id.tvNim)
        val tvKelas: TextView = findViewById(R.id.tvKelas)
        val tvUsia: TextView = findViewById(R.id.tvUsia)

        tvNama.text = "Nuraisah"
        tvNim.text = "10522126"
        tvKelas.text = "IS-4"
        tvUsia.text = "20"

    }
}