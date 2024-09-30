package com.org.livemarket.loginModule.supportFunctions

import android.content.Context
import com.org.livemarket.databinding.ActivityLoginBinding

class SupportFunctions(val context: Context,
                       private val loginBinding: ActivityLoginBinding,
                       private val listener: (userName: String,password: String) -> Unit)
{

}