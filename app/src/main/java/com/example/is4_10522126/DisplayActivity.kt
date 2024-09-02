package com.example.is4_10522126

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val profileImage = findViewById<ImageView>(R.id.profileImage)
        val tvNama = findViewById<TextView>(R.id.tvNama)
        val tvUsia = findViewById<TextView>(R.id.tvUsia)
        val tvJabatan = findViewById<TextView>(R.id.tvJabatan)
        val tvKeahlian = findViewById<TextView>(R.id.tvKeahlian)
        val tvGender = findViewById<TextView>(R.id.tvGender)

        val intent = intent
        val nama = intent.getStringExtra("NAMA")
        val usia = intent.getStringExtra("USIA")
        val jabatan = intent.getStringExtra("JABATAN")
        val keahlianProgramming = intent.getBooleanExtra("KEAHLIAN_PROGRAMMING", false)
        val keahlianDatabase = intent.getBooleanExtra("KEAHLIAN_DATABASE", false)
        val keahlianNetworking = intent.getBooleanExtra("KEAHLIAN_NETWORKING", false)
        val gender = intent.getStringExtra("GENDER")

        tvNama.text = "$nama"
        tvUsia.text = "$usia"
        tvJabatan.text = "$jabatan"

        val keahlianList = mutableListOf<String>()
        if (keahlianProgramming) keahlianList.add("Programming")
        if (keahlianDatabase) keahlianList.add("Database")
        if (keahlianNetworking) keahlianList.add("Networking")
        tvKeahlian.text = "${keahlianList.joinToString(", ")}"

        tvGender.text = "$gender"
        if (gender.equals("Female", ignoreCase = true)) {
            profileImage.setImageResource(R.drawable.femalepic)
        }
    }
}