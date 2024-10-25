package com.example.passwordmanager

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
abstract class PassDao {

    @Insert()
    abstract suspend fun addPassword(passEntity : password)

    @Query("Select * from `password-table`")
    abstract fun getAllPassword() : Flow<List<password>>

    @Query("Select * from `password-table` where id=:id")
    abstract fun getaPassword(id :Int) : Flow<password>

    @Update
    abstract suspend fun updatePassword(passEntity: password)

    @Delete
    abstract suspend fun deletePassword(passEntity: password)
}