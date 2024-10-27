package com.example.shoppingui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.navArgument
import java.net.URLDecoder
import java.nio.charset.StandardCharsets


class MainActivity : ComponentActivity() // MainActivity class
{
    override fun onCreate(savedInstanceState : Bundle?) // main activity creation
    {
        super.onCreate(savedInstanceState) // calling parent class's onCreate()
        // full filling the status bar with app screen
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(Color.Transparent.toArgb(), Color.White.toArgb())
        )
        setContent() // main content goes here
        {
            AppNavController()
        }
    }
}

@Composable
fun AppNavController() // function to define all navigation's
{
    val navController = rememberNavController() // navController class instance creation
    NavHost( // navigation will be defined here
        navController = navController, // passing the rememberNavController class instance
        startDestination = "startScreen" // start screen defining
    )
    {
        // start screen
        composable("startScreen")
        {
            StartScreen(navController)
        }

        // login screen
        composable("loginScreen")
        {
            LoginScreen(navController)
        }

        // sign up screen
        composable(route = "signUpScreen")
        {
            SignUpScreen(navController)
        }

        // shopping home screen
        composable(route = "shoppingHomeScreen/{firstName}",
            arguments = listOf(navArgument("firstName"){ type = NavType.StringType }
            )
        )
        { backStackEntry ->
            val firstName = backStackEntry.arguments?.getString("firstName")
            ShoppingHomeScreen(
                navController,
                firstName = firstName!!
            )
        }
        // shopping image zoom function
        composable(route = "shoppingImageZoom/{image}/{title}/{price}/{description}",
            arguments = listOf(navArgument("image"){ type = NavType.StringType },
                navArgument("title"){ type = NavType.StringType },
                navArgument("price"){ type = NavType.IntType },
                navArgument("description"){ type = NavType.StringType}
                )
            )
        {backStackEntry ->
            val image = URLDecoder.decode(backStackEntry.arguments?.getString("image"), StandardCharsets.UTF_8.toString())
            val title = backStackEntry.arguments?.getString("title")
            val price = backStackEntry.arguments?.getInt("price")
            val description = backStackEntry.arguments?.getString("description")

            // passing the arguments
            ShoppingImageZoom(
                navController = navController,
                image = image!!,
                title = title!!,
                price = price!!,
                description = description!!
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview()
{
    StartScreen(rememberNavController())
}