package com.example.praktikum7androidlive.ui.jenisbarang

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.praktikum7androidlive.databinding.ActivityJenisbarangPostBinding
import com.example.praktikum7androidlive.model.JenisbarangData

class JenisbarangPostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJenisbarangPostBinding
    private val viewModel: JenisbarangViewModel by lazy {
        ViewModelProvider(this).get(JenisbarangViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJenisbarangPostBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btSimpanJenisbarangPost.visibility = View.VISIBLE
        binding.btSimpanJenisbarangPost.setOnClickListener{

            val idJenisbarang = binding.etIdJenisbarang.text.toString()
            val namaJenisBarang = binding.etNamajenisbarang.text.toString()
            val jenisBarangData = JenisbarangData(idJenisbarang,namaJenisBarang)


            binding.btSimpanJenisbarangPost.visibility = View.INVISIBLE

            viewModel.create(jenisBarangData)
            viewModel.createResponse.observe(this,{
                binding.btSimpanJenisbarangPost.visibility = View.VISIBLE
            })


        }
    }
}