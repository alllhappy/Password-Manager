package com.example.passwordmanager

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "password-table")
data class password(
    @PrimaryKey(autoGenerate = true)
    val id :Int=0,
    @ColumnInfo("website")
    var Website : String="" ,
    @ColumnInfo("username")
    var Username : String="" ,
    @ColumnInfo("pass")
    var pass : String="")

object DummyPasswords{
    val passlist= listOf<password>(
        password(Website = "Google.com", Username = "abc@gmail.com",pass ="123456"),
        password(Website = "Facebook.com", Username = "hahah",pass ="123"),
        password(Website = "insta.com", Username = "aakaka",pass ="12345689")
    )
}