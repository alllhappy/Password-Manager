package com.example.passwordmanager


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun savedPasswordScreen(viewModel : PassViewModel,navController: NavController){
    var context= LocalContext.current
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
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Your Saved Passwords",
                modifier = Modifier.padding(8.dp),
                fontSize = 20.sp,
            )
         }

        Box(Modifier.fillMaxSize())
        {
            val passwords= viewModel.getAllPassword.collectAsState(initial = listOf())

            LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                            .background(Color.Yellow)
                      )
                {

                    items(passwords.value){  /// passsing dummy object from password.kt
                    item->
                    passCompsable(password = item, updateFunc = {
                        val id=item.id
                        navController.navigate("inputDetails/$id") },
                        deleteFunc = {
                            viewModel.deletePassword(item)
                            Toast.makeText(context,"item deleted",Toast.LENGTH_SHORT).show()
                        })

                    }
                }
            FloatingActionButton(onClick = { /* add password function */
                    navController.navigate("inputDetails/0") },
                    modifier = Modifier.padding(top = 620.dp, start = 300.dp, end = 8.dp, bottom = 8.dp))
                {
                    Icon(imageVector = Icons.Default.Add, contentDescription =" add" )
                }

        }

    }

}




// password Composable
@Composable
fun passCompsable(password: password,updateFunc:()->Unit,deleteFunc:()-> Unit ,modifier :Modifier=Modifier){
    var expanded = remember { mutableStateOf(false) }
    Box (modifier = Modifier
        .background(Color.Yellow)
        .padding(8.dp)
        .width(300.dp))
    {
        Column(
//                modifier = Modifier.fillMaxSize()
        ) {
            Row (
                modifier=Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = "Website: ${password.Website}", modifier = Modifier.padding(4.dp))

                //dropDownmenu
                IconButton(onClick = { expanded.value=true },modifier= Modifier
                    .height(25.dp)
                    .width(25.dp)
                    .padding(4.dp)) {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription ="More options" )

                        DropdownMenu(expanded = expanded.value,
                            onDismissRequest = { expanded.value=false }) {
                            DropdownMenuItem(text = { Text(text = "Update") }, onClick = { updateFunc() })
                            DropdownMenuItem(text = { Text(text = "Delete") }, onClick = { deleteFunc() })
                    }
                }

            }
            Text(text = "Username: ${password.Username}",modifier = Modifier.padding(4.dp))
            Text(text = "Password:${password.pass}",modifier = Modifier.padding(4.dp))

        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun savedPasswordsPreview(){
    val navController = rememberNavController()
    savedPasswordScreen(PassViewModel(),navController)
}

fun updateFunc(){

}
fun deleteFunc(){

}
