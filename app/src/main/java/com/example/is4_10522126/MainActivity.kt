package com.example.is4_10522126

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etNama: EditText
    private lateinit var etUsia: EditText
    private lateinit var spinnerJabatan: Spinner
    private lateinit var cbProgramming: CheckBox
    private lateinit var cbDatabase: CheckBox
    private lateinit var cbNetworking: CheckBox
    private lateinit var rgGender: RadioGroup
    private lateinit var btnSimpan: Button
    private lateinit var btnProfil: Button
    private lateinit var selectedJabatan: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNama = findViewById(R.id.etNama)
        etUsia = findViewById(R.id.etUsia)
        spinnerJabatan = findViewById(R.id.spinnerJabatan)
        cbProgramming = findViewById(R.id.cbProgramming)
        cbDatabase = findViewById(R.id.cbDatabase)
        cbNetworking = findViewById(R.id.cbNetworking)
        rgGender = findViewById(R.id.rgGender)
        btnSimpan = findViewById(R.id.btnSimpan)
        btnProfil = findViewById(R.id.btnProfil)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.jabatan_array,
            R.layout.spinner_selected_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerJabatan.adapter = adapter

        spinnerJabatan.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedJabatan = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        btnSimpan.setOnClickListener {
            val intent = Intent(this, DisplayActivity::class.java)
            intent.putExtra("NAMA", etNama.text.toString())
            intent.putExtra("USIA", etUsia.text.toString())
            intent.putExtra("JABATAN", selectedJabatan)
            intent.putExtra("KEAHLIAN_PROGRAMMING", cbProgramming.isChecked)
            intent.putExtra("KEAHLIAN_DATABASE", cbDatabase.isChecked)
            intent.putExtra("KEAHLIAN_NETWORKING", cbNetworking.isChecked)
            val selectedGenderId = rgGender.checkedRadioButtonId
            if (selectedGenderId != -1) {
                val selectedGender = findViewById<RadioButton>(selectedGenderId).text.toString()
                intent.putExtra("GENDER", selectedGender)
            }
            startActivity(intent)
        }

        btnProfil.setOnClickListener {
            val intent = Intent(this, ProfilActivity::class.java)
            startActivity(intent)
        }
    }
}