package com.example.passwordmanager

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [password::class],
    version = 1,
    exportSchema = false
)
abstract class PassDatabase : RoomDatabase(){
    abstract fun passDao() : PassDao
}