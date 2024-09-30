package com.org.livemarket.zSharedPreference

import android.content.Context
import com.org.livemarket.zConstants.Constants

object LoginData {
    private const val PREFS_NAME = "MedicalRepresentativeLoginData"

    fun putUserLoginStatus(context: Context, value: Boolean) {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean(Constants.LOGIN_STATUS, value).apply()
    }

    fun getUserLoginStatus(context: Context): Boolean {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPref.getBoolean(Constants.LOGIN_STATUS, false)
    }

    fun saveUserName(context: Context, value: String) {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(Constants.USER_NAME, value).apply()
    }

    fun getUserName(context: Context): String {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPref.getString(Constants.USER_NAME, "EMPTY")?:"EMPTY"
    }

    fun saveUserId(context: Context, value: Int) {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putInt(Constants.REP_USER_ID, value).apply()
    }

    fun getUserId(context: Context): Int {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPref.getInt(Constants.REP_USER_ID, -1)
    }

    fun saveRepresentativeId(context: Context, value: Int) {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putInt(Constants.USER_PHONE, value).apply()
    }

    fun getRepresentativeId(context: Context): Int {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPref.getInt(Constants.USER_PHONE, -1)
    }

    fun saveRepresentativeType(context: Context, value: Int) {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putInt(Constants.REP_TYPE, value).apply()
    }

    fun getRepresentativeType(context: Context): Int {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPref.getInt(Constants.REP_TYPE, -1)
    }

    fun saveUserLandMark(context: Context, value: String) {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(Constants.USER_LANDMARK, value).apply()
    }

    fun getUserLandMark(context: Context): String {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPref.getString(Constants.USER_LANDMARK, "EMPTY")?:"EMPTY"
    }

    fun saveUserContact(context: Context, value: String) {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(Constants.USER_CONTACT, value).apply()
    }

    fun getUserContact(context: Context): String {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPref.getString(Constants.USER_CONTACT, "EMPTY")?:"EMPTY"
    }

    fun saveUserPhoto(context: Context, value: String) {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(Constants.USER_PHOTO, value).apply()
    }

    fun getUserPhoto(context: Context): String {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPref.getString(Constants.USER_PHOTO, "EMPTY")?:"EMPTY"
    }

    fun saveLoopByteURL(context: Context, value: String) {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(Constants.LOOPBYTE_URL, value).apply()
    }

    fun getLoopByteURL(context: Context): String {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPref.getString(Constants.LOOPBYTE_URL, "EMPTY")?:"EMPTY"
    }

    fun saveServerURL(context: Context, value: String) {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(Constants.BFS_URL, value).apply()
    }

    fun getServerURL(context: Context): String {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPref.getString(Constants.BFS_URL, "EMPTY")?:"EMPTY"
    }

    fun clear(context: Context) {
        val sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.clear().apply()
    }
}
