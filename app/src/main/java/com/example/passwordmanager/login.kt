package com.example.passwordmanager

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun loginScreen(navigationToSecondScreen: () -> Unit){
    val loginid = remember { mutableStateOf("") }
    val pass = remember { mutableStateOf("") }
    val context=LocalContext.current
    val Case=remember{ mutableStateOf(0)}
    val txt=TextStyle(Color.White)


    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        )

    {
        Box(modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth().height(55.dp),
            contentAlignment = Alignment.Center
            ) {
            Text(
                text = "Login Screen",
                modifier = Modifier.padding(8.dp),
                fontSize = 20.sp,
            )
        }

        Spacer(modifier = Modifier.padding(150.dp))

        OutlinedTextField(value = loginid.value,
                onValueChange ={
                loginid.value=it
            },
            placeholder = {
                Text(text = "Enter your email address")
            },
            modifier = Modifier.padding(8.dp),
            textStyle = txt
        )

        OutlinedTextField(value = pass.value,
            onValueChange ={
                pass.value=it
            },
            placeholder = {
                Text(text = "Enter your password")
            },
            modifier = Modifier.padding(8.dp),
            visualTransformation = PasswordVisualTransformation(),
            textStyle = txt
        )

        Button(onClick = {
            Case.value=validate(loginid.value,pass.value)
            when(Case.value){
                1 ->navigationToSecondScreen()
                    //Toast.makeText(context,"Access Granted",Toast.LENGTH_SHORT).show();
                2 ->  Toast.makeText(context,"Password Incorrect",Toast.LENGTH_SHORT).show()
                3 -> Toast.makeText(context,"User not Found",Toast.LENGTH_SHORT).show()
            }
                         },
            modifier = Modifier.padding(12.dp)
        )
        {
            Text(text = "Login",
                )
        }
    }
}
fun validate (inputMail : String, inputPass : String): Int {
    var case =0
    if(inputMail =="test@admin.com"){
        if(inputPass=="12345678"){
            // access granted
            case=1
//            Toast.makeText(LocalContext.current,"Access Granted",Toast.LENGTH_SHORT).show()
        }
        else{
            // password is incorrect
            case=2
//            Toast.makeText(LocalContext.current,"Password Incorrect",Toast.LENGTH_SHORT).show()

        }
    }
    else{
        //  mssg- this email is not registered
        case=3
//        Toast.makeText(LocalContext.current,"User not Found",Toast.LENGTH_SHORT).show()
    }
return case
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun loginPreview(){
    loginScreen({})
}