package com.comparador.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.comparador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.comparador.observe(this){
            binding.resultado.text = "${it.resultado}"
        }

        binding.button.setOnClickListener {
            mainViewModel.comparar(binding.cuadroDeTexto1.text.toString(),binding.cuadroDeTexto2.text.toString())
        }

    }
}