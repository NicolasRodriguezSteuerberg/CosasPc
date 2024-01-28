package com.nsteuerberg.room.views

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nsteuerberg.room.viewmodels.UserViewModel

@Composable
fun Inicio(viewModel: UserViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "start") {
        composable("start") {
            LoginScreen(navController, viewModel)
        }
        composable("register") {
            RegisterScreen(navController, viewModel)
        }
        composable("logged") {
            LoggedScreen(navController, viewModel)
        }
        /*Si le quisiermamos mandar parametros
        composable("logged/{user_name}/{password}", arguments = listOf(
            navArgument("user_name") {type = NavType.StringType},
            navArgument("password") {type = NavType.StringType},
        ){
            LoguedScreen(
                navController,
                viewModel,
                it.arguments!!.getString("user_name"), // no puede ser vacio
                it.arguments?.getString("password") // puede ser vacio
            )
        }
         */
    }
}