package com.org.livemarket.zCommonFuntions

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.org.livemarket.loginModule.LoginActivity

object CallIntent {

    fun goToLoginActivityandKillMe(context: Context, killMe: Boolean, activity: Activity) {
        val intent = Intent(context, LoginActivity::class.java)
        context.startActivity(intent)
        if (killMe) activity.finish()
    }



}
