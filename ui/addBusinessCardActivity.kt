package br.com.dio.bussinescard.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.dio.bussinescard.R
import br.com.dio.bussinescard.app
import br.com.dio.bussinescard.data.BusinessCard
import br.com.dio.bussinescard.databinding.ActivityAddBusinessCardActivyBinding

class addBusinessCardActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityAddBusinessCardActivyBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as app).repository) }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.btnClose.setOnClickListener {
            finish()
        }
        binding.btnConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                nome = binding.tilNome.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_sucess, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}