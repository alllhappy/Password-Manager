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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
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
val scope= rememberCoroutineScope()
    var w by remember {
        mutableStateOf("")
    }
    var u by remember {
        mutableStateOf("")
    }
    var p by remember {
        mutableStateOf("")
    }
    if(id!=0){ /// Updating
        val passwd = viewModel.getaPassword(id).collectAsState(initial = password(0, "", "", ""))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
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
                        text = "Update Password Screen",
                        modifier = Modifier.padding(8.dp),
                        fontSize = 20.sp,
                    )
                }
            }
            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            Text(text = "Current Website : ${passwd.value.Website}", color = Color.White)
            OutlinedTextField(value =w,
                onValueChange ={
                    w=it
                },
                placeholder = { Text(text ="Updated Website")},
                modifier = Modifier.padding(8.dp),
                textStyle = TextStyle(Color.White)
            )
            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            Text(text = "Current Username : ${passwd.value.Username}",color = Color.White)
            OutlinedTextField(value =u,
                onValueChange ={
                    u=it
                },
                placeholder = { Text(text ="Updated Username")},
                modifier = Modifier.padding(8.dp),
                textStyle = TextStyle(Color.White)
            )
            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            Text(text = "Current Password : ${passwd.value.pass}",color = Color.White)
            OutlinedTextField(value =p,
                onValueChange ={
                    p=it
                },
                placeholder = { Text(text ="Updated Password")},
                modifier = Modifier.padding(8.dp),
                textStyle = TextStyle(Color.White)
            )

            Spacer(modifier = Modifier.padding(vertical = 12.dp))

            Button(onClick = { /*navigate back to savedPasswordsScreen and append the input items in list*/
                viewModel.updatePassword(password(id,w,u,p))
                scope.launch {
                    navController.navigate("savedPasswords")
                }
            })
            {
                Text(text = "update")
            }
    }
    }
    else{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
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
                        text = "add Password Screen",
                        modifier = Modifier.padding(8.dp),
                        fontSize = 20.sp,
                    )
                }
            }
            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            OutlinedTextField(value =w,
                onValueChange ={
                    w=it
                },
                placeholder = { Text(text ="Website")},
                modifier = Modifier.padding(8.dp),
                textStyle = TextStyle(Color.White)
            )
            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            OutlinedTextField(value =u,
                onValueChange ={
                    u=it
                },
                placeholder = { Text(text ="Username")},
                modifier = Modifier.padding(8.dp),
                textStyle = TextStyle(Color.White)
            )
            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            OutlinedTextField(value =p,
                onValueChange ={
                    p=it
                },
                placeholder = { Text(text ="Password")},
                modifier = Modifier.padding(8.dp),
                textStyle = TextStyle(Color.White)
            )

            Spacer(modifier = Modifier.padding(vertical = 12.dp))

            Button(onClick = { /*navigate back to savedPasswordsScreen and append the input items in list*/
                viewModel.addPassword(password(id,w,u,p))
                scope.launch {
                    navController.navigate("savedPasswords")
                }
            })
            {
                Text(text = "add")
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun preview(){
    val navController = rememberNavController()
    inputDetailsScreen(0, viewModel(),navController)
}



