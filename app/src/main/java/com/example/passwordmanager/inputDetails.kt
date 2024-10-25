package com.example.passwordmanager

import androidx.annotation.RestrictTo
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun inputDetailsScreen( id: Int,viewModel: PassViewModel,navController: NavController){

/*
    val scope= rememberCoroutineScope()
    if(id!=0){// use update

        val passwd=viewModel.getaPassword(id).collectAsState(initial = password(0,"","",""))
        var pass:password by remember {
            mutableStateOf(password(id,passwd.value.Website,passwd.value.Username,passwd.value.pass))
        }


        inputDetailsUi(Password =pass , func = { viewModel.updatePassword(pass) }, BMessage ="Update" , navController =navController,scope )
    }
    else{ // use add
        var pass:password by remember {
            mutableStateOf(password(id,"","",""))
        }
        inputDetailsUi(Password = pass, func = { viewModel.addPassword(pass) }, BMessage ="Add" , navController =navController,scope )
    }




}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun preview(){
    val navController = rememberNavController()
    inputDetailsScreen(0, viewModel(),navController)
}

@Composable
fun inputDetailsUi(Password:password,func:()->Unit,BMessage:String,navController: NavController,scope: CoroutineScope){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Box(modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(55.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row {
                IconButton(onClick = { /*navigate back to savedPassword screen*/ navController.navigate("savedPasswords") }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription ="Back button" )
                }
                Spacer(modifier = Modifier.padding(horizontal = 20.dp))
                Text(
                    text = "$BMessage Password Screen",
                    modifier = Modifier.padding(8.dp),
                    fontSize = 20.sp,
                )
            }
        }
        Spacer(modifier = Modifier.padding(vertical = 12.dp))
        OutlinedTextField(value =Password.Website ,
            onValueChange ={
               Password=Password.copy(Website = it)
            },
            placeholder = { Text(text ="Website")},
            modifier = Modifier.padding(8.dp)
        )
        OutlinedTextField(value = ,
            onValueChange ={Password.Username=it},
            placeholder = { Text(text ="Username")},
            modifier = Modifier.padding(8.dp)
        )
        OutlinedTextField(value =Password.pass ,
            onValueChange ={Password.pass=it},
            placeholder = { Text(text ="password")},
            modifier = Modifier.padding(8.dp)
        )


        Spacer(modifier = Modifier.padding(vertical = 12.dp))

        Button(onClick = { /*navigate back to savedPasswordsScreen and append the input items in list*/
            func()
            scope.launch {
                navController.navigate("savedPasswords")
            }
        })
        {
            Text(text = "$BMessage")
        }
    }

 */
}


