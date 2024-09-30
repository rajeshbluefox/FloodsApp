package com.org.livemarket

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.org.livemarket.zCommonFuntions.CallIntent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkLoginStatusandNavigate()
    }

    private fun checkLoginStatusandNavigate() {
        Handler(Looper.getMainLooper()).postDelayed({

            CallIntent.goToLoginActivityandKillMe(this, true, this)


        }, 2000)
    }
}