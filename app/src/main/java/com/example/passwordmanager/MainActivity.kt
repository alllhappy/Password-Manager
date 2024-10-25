package com.example.passwordmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.passwordmanager.ui.theme.PasswordManagerTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PasswordManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    passApp()
//                    test(viewModel())

                }
            }
        }
    }
}
@Composable
fun passApp(viewModel : PassViewModel= viewModel()){
    // use nav to control the screens. all screens will have seperate files
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination ="savedPasswords"){
        composable("login") {
            loginScreen {
                navController.navigate("savedPasswords")  // we are passing the parameter what that function should do
            }
        }
        composable("savedPasswords"
            ) {
            savedPasswordScreen(viewModel,navController)
        }

        composable("inputDetails/{id}",
            arguments = listOf(
                navArgument("id"){
                    type= NavType.IntType
                    defaultValue=0
                    nullable=false
                }
            )

            ) {
                val id= if(it.arguments != null) it.arguments!!.getInt("id") else 0
                inputDetailsScreen(id,viewModel,navController = navController )
        }


        }
    }