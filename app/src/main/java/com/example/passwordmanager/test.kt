package com.example.passwordmanager

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType

// to solve textfield doubt
//https://stackoverflow.com/questions/74136796/jetpack-compose-textfield-not-updating-when-typing-a-new-character#:~:text=The%20TextField%20will%20not%20be,first%20HelloContent%20composable%20like%20this.
//@Composable
//fun test(viewModel: PassViewModel){
//    val a="hahah"
//    var x=true
//    if(x){
//        viewModel.onWebStateChange(a)
//    }
//
//
//    Column {
//        TextField(value =viewModel.webState , onValueChange = {viewModel.onWebStateChange(it)})
//        Text(text = viewModel.webState)
//    }
//}

@Composable
fun test(viewModel: PassViewModel){
    var a by remember {
        mutableStateOf("")
    }
    val b="hahah"
    var x=true
    LaunchedEffect(x){
        if(x){
            a= b
        }
    }



//    Column {
//        TextField(value = a , onValueChange ={a=it})
//        Text(text = viewModel.webState)
//    }
}