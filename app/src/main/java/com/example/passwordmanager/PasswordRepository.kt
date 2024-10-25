package com.example.passwordmanager

import kotlinx.coroutines.flow.Flow

class PasswordRepository(private  val passDao: PassDao){
    suspend fun addPassword(passEntity: password){
            passDao.addPassword(passEntity)
    }
    fun getAllPassword() : Flow<List<password>> = passDao.getAllPassword()

    fun getaPassword(id:Int) : Flow<password> = passDao.getaPassword(id)

    suspend fun updatePassword(passEntity: password){
        passDao.updatePassword(passEntity)
    }

    suspend fun deletePassword(passEntity: password){
        passDao.deletePassword(passEntity)
    }

}