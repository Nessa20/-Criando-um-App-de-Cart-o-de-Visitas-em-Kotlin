package br.com.dio.bussinescard.ui

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.dio.bussinescard.app
import br.com.dio.bussinescard.databinding.ActivityAddBusinessCardActivyBinding
import br.com.dio.bussinescard.databinding.ActivityMainBinding
import br.com.dio.bussinescard.util.Image

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as app).repository)
    }

    private val adapter by lazy { BusinessCardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllBusinessCard()
        insertListener()
    }
    private fun insertListener() {
        binding.fab.setOnClickListener {
            val intent = Intent(this@MainActivity, ActivityAddBusinessCardActivyBinding::class.java)
            startActivity(intent)
        }
        adapter.listenerShare = { card ->
            Image.share(this@MainActivity, card)
        }
    }

    private fun getAllBusinessCard() {
        mainViewModel.getAll().observe(this) { businessCards ->
            adapter.submitList(businessCards)
        }
    }
}