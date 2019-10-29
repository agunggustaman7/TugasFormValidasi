package com.example.myapplication.Utils

import android.content.Context
import android.content.SharedPreferences

class local {

    companion object{
        const val NAME = "com.example.myapplication.Utils"
        const val PRIVATE_MODE = 0
        const val LOCALE = "locale"

        fun saveLocale(context: Context, id:String){
            val sharedPreferences: SharedPreferences = context.getSharedPreferences(NAME, PRIVATE_MODE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(LOCALE, id)
            editor.apply()
        }

        fun getLocale(context: Context) : String {
           return context.getSharedPreferences(NAME, PRIVATE_MODE).getString(LOCALE, "en")!!
        }


    }
}