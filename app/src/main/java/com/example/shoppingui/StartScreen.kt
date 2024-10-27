package com.example.shoppingui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun StartScreen(navController: NavController) {

    var loginButtonTextColor by remember { mutableStateOf( Color.Black ) } // storing login button text color into state
    var loginButtonColor by remember{ mutableStateOf( Color.White) } // storing login button color into state

    var signUpButtonTextColor by remember { mutableStateOf( Color.Black ) } // storing signUp button text color into state
    var signUpButtonColor by remember{ mutableStateOf( Color.White) } // storing signUp button color into stat

    var guestTextColor by remember{ mutableStateOf( Color.White ) }

    // for full screen
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFCF9FFF),
                        Color(0xFF93E9BE)
                    ),
                    startY = 500f
                )
            )
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent)
        )
        {
            // for image
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.45f)
                    .background(color = Color.Transparent),
                contentAlignment = Alignment.BottomCenter
            )
            {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.shopping), // importing image
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(180.dp)
                            .width(180.dp)
                    )

                    Spacer(modifier = Modifier.height(5.dp)) // creating some space

                    Text(
                        text = "SwiftCart",
                        style = TextStyle(
                            fontSize = 35.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        ),
                    )
                }
            }
            // for buttons and the lower text
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 60.dp, bottom = 50.dp, start = 20.dp, end = 20.dp),
                contentAlignment = Alignment.TopCenter
            )
            {
                // for placing vertically
                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Transparent)
                )
                {
                    // for the buttons
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.75f)
                        .background(color = Color.Transparent)
                    )
                    {
                        // button details
                        val buttonDetails = mapOf(
                            "Login" to "loginScreen",
                            "Sign Up" to "signUpScreen"
                        )
                        // for placing vertically
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.Transparent)
                        )
                        {
                            buttonDetails.forEach {
                                var buttonColor : Color
                                var buttonTextColor : Color
                                if(it.key == "Login")
                                {
                                    buttonColor = loginButtonColor
                                    buttonTextColor = loginButtonTextColor

                                }
                                else
                                {
                                    buttonColor = signUpButtonColor
                                    buttonTextColor = signUpButtonTextColor
                                }
                                Button(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(50.dp)
                                        .padding(),
                                    onClick = {
                                        if(it.key == "Login")
                                        {
                                            loginButtonColor = if( loginButtonColor == Color.White) Color.Transparent else Color.White
                                            loginButtonTextColor = if( loginButtonTextColor == Color.Black) Color.White else Color.Black

                                        }
                                        else
                                        {
                                            signUpButtonColor= if( signUpButtonColor == Color.White) Color.Transparent else Color.White
                                            signUpButtonTextColor = if( loginButtonTextColor == Color.Black) Color.White else Color.Black

                                        }
                                        navController.navigate(it.value)
                                              }, // passing the navigate string and changing color
                                    shape = RoundedCornerShape(12.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
                                )
                                {
                                    Text(
                                        text = it.key, // passing the button title
                                        style = TextStyle(
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = buttonTextColor,
                                        )
                                    )
                                }
                                Spacer(modifier = Modifier.height(15.dp)) // creating space
                            }
                        }
                    }
                    // for the clickable text
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Transparent),
                        contentAlignment = Alignment.BottomCenter
                    )
                    {
                        Text(text = "Continue as a guest?",
                            style = TextStyle(
                                fontSize = 18.sp,
                                color = guestTextColor,
                                fontWeight = FontWeight.Medium
                            ),
                            modifier = Modifier
                                .clickable(onClick = {
                                    guestTextColor = if(guestTextColor == Color.White) Color.Gray else Color.White
                                    navController.navigate("shoppingHomeScreen/User")
                                    },
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            )
                        )
                    }
                }
            }
        }
    }
}