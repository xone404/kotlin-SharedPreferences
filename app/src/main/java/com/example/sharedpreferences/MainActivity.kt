package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("notedate",Context.MODE_PRIVATE)

        binding.btnKirim.setOnClickListener{
            val ketik = binding.etText.text.toString()
            val shareEdit = sharedPreferences.edit()
            shareEdit.putString("ketik", ketik)
            shareEdit.apply()
            Toast.makeText(this, "Terkirim", Toast.LENGTH_SHORT).show()
            binding.etText.text.clear()
        }
        binding.btnTampil.setOnClickListener{
            val kalimat = sharedPreferences.getString("ketik","")
            binding.tvText.text ="$kalimat"
        }

    }
}