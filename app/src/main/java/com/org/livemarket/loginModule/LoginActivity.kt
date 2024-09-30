package com.org.livemarket.loginModule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.org.livemarket.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializations()
    }

    private fun initializations() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}