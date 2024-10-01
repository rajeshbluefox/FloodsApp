package com.org.livemarket.adminModule.competitions

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.org.livemarket.R
import com.org.livemarket.databinding.ActivityAdminHomeBinding
import com.org.livemarket.databinding.ActivityCompDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CompDetailsAdminActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCompDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}