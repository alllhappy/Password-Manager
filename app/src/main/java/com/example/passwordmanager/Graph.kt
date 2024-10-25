package com.example.passwordmanager

import android.content.Context
import androidx.room.Room
import com.example.passwordmanager.PassDatabase
import com.example.passwordmanager.PasswordRepository


object Graph {
    lateinit var database: PassDatabase
    val passwordRepository by lazy {
        PasswordRepository(passDao = database.passDao())
    }
    fun provide(context: Context){
//        database=Room.databaseBuilder(context,PassDatabase:: class.java,"passwords.db").build()
        database= Room.databaseBuilder(context, PassDatabase::class.java,"passwords.db").build()
    }
}

