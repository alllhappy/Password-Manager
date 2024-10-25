package com.example.passwordmanager

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PassViewModel(
    private val passRepository : PasswordRepository = Graph.passwordRepository
) : ViewModel() {
    var webState =  mutableStateOf("")
    var userState by mutableStateOf("")
    var passState by mutableStateOf("")


    fun onWebStateChange(newString:String){
        webState.value = newString
    }

    fun onUserStateChange(newString:String){
        userState = newString
    }
    fun onPassStateChange(newString:String){
        passState = newString
    }

    lateinit var getAllPassword: Flow<List<password>>

    init {
        viewModelScope.launch {
            getAllPassword= passRepository.getAllPassword()
        }
    }

    fun getaPassword(id :Int): Flow<password>{
        return passRepository.getaPassword(id)
    }

    fun addPassword(passEntity : password){
        viewModelScope.launch(Dispatchers.IO) {
            passRepository.addPassword(passEntity)
        }
    }

    fun updatePassword(passEntity: password){
        viewModelScope.launch (Dispatchers.IO){
            passRepository.updatePassword(passEntity)
        }
    }

    fun deletePassword(passEntity: password){
        viewModelScope.launch ( Dispatchers.IO ){
            passRepository.deletePassword(passEntity)
        }
    }
}