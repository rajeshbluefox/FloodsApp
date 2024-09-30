package com.org.livemarket.zCommonFuntions

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object UtilFunctions{
    fun showToast(context: Context,message: String)
    {
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
    }

    fun getCurrentDateTime(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val currentDate = Date()
        return dateFormat.format(currentDate)
    }

    fun getTodayDate(): String {
        val myFormat1 = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(myFormat1)
        return sdf.format(Date())
    }

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }

}