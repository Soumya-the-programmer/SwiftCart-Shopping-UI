package com.example.shoppingui

import android.content.Context
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SignUpScreen(navController: NavController, )
{
    var emailAddressValue by remember { mutableStateOf("") } // storing email value in state
    var passwordValue by remember { mutableStateOf("") } // storing password value in state
    var conPasswordValue by remember { mutableStateOf("") } // storing confirm password value in state
    var firstNameValue by remember { mutableStateOf("") } // storing the first name value in state

    Column(
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
            .padding(start = 20.dp, end = 20.dp, bottom = 50.dp)
    )
    {
        SignUpHeaderSection(
            firstNameValue = firstNameValue,
            firstNameValueChange = {firstNameValue = it},
            emailAddressValue = emailAddressValue,
            onEmailValueChange = {emailAddressValue = it},
            passwordValue = passwordValue,
            onPasswordValueChange = {passwordValue = it},
            confirmPasswordValue = conPasswordValue,
            onConfirmPasswordValueChange = {conPasswordValue = it},
            navController = navController,
            boldedTitleText = "Create Account",
            bottomTitleText = "to get started now!"
        ) // calling app header section

        FooterSection(navController = navController,
            linedText = "Or Sign Up with",
            unHighlightedText = "Already have an account?",
            highlightedText = " Login Now",
            navigateString = "loginScreen"
            ) // calling app footer section
    }
}

@Composable
fun SignUpHeaderSection(
    firstNameValue : String,
    firstNameValueChange : (String) -> Unit,
    emailAddressValue : String,
    onEmailValueChange : (String) -> Unit,
    passwordValue : String,
    onPasswordValueChange : (String) -> Unit,
    confirmPasswordValue : String,
    onConfirmPasswordValueChange : (String) -> Unit,
    navController: NavController,
    boldedTitleText : String,
    bottomTitleText : String
)
{
    val context = LocalContext.current // context

    // for placing title, text fields vertically
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.7f)
            .background(color = Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    )
    {
        // for the title headings
        AppTitle(boldedText = boldedTitleText, bottomText = bottomTitleText )

        Spacer(modifier = Modifier.height(30.dp)) // for creating extra space

        // First Name text field
        InputFields(
            label = "First Name",
            value = firstNameValue,
            onValueChange = firstNameValueChange,
            keyBoardType = KeyboardType.Text,
            keyboardVisual = VisualTransformation.None
        )

        Spacer(modifier = Modifier.height(15.dp)) // for creating extra space

        // Email Address text field
        InputFields(
            label = "Email Address",
            value = emailAddressValue,
            onValueChange = onEmailValueChange,
            keyBoardType = KeyboardType.Email,
            keyboardVisual = VisualTransformation.None
        )

        Spacer(modifier = Modifier.height(15.dp)) // for creating extra space

        // Password text field
        InputFields(
            label = "Password",
            value = passwordValue,
            onValueChange = onPasswordValueChange,
            keyBoardType = KeyboardType.Password,
            keyboardVisual = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(15.dp)) // for creating extra space

        // Password text field
        InputFields(
            label = "Confirm Password",
            value = confirmPasswordValue,
            onValueChange = onConfirmPasswordValueChange,
            keyBoardType = KeyboardType.Password,
            keyboardVisual = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(40.dp)) // creating extra space

        // sign up button
        SignUpButton(navController = navController,
            firstNameValue = firstNameValue,
            emailAddressValue = emailAddressValue,
            passwordValue = passwordValue,
            confirmPasswordValue = confirmPasswordValue,
            context = context
            )
    }
}

@Composable
fun SignUpButton(navController: NavController,
                 firstNameValue: String,
                 emailAddressValue: String,
                 passwordValue: String,
                 confirmPasswordValue: String,
                 context : Context
                 )
{
    var buttonColor by remember { mutableStateOf(Color.White) } // storing the button color in state
    var buttonTextColor by remember { mutableStateOf(Color.Black)} // storing text color in state

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(),
        onClick = {
            // checking if name entry blank or not
            if(firstNameValue.trim() != "") {
                // checking if email entry blank or not
                if (emailAddressValue.trim() == "")
                    Toast.makeText(
                        context,
                        "❌ Enter your email first",
                        Toast.LENGTH_SHORT
                    ).show()
                else
                // checking if email format is valid or not
                    if (Patterns.EMAIL_ADDRESS.matcher(emailAddressValue).matches()) {
                        if (emailAddressValue in verifiedAccounts) {
                            Toast.makeText(
                                context,
                                "Account already exists!",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            // checking if the password field is empty
                            if (passwordValue.trim() == "") {
                                Toast.makeText(
                                    context,
                                    "❌ Set your password!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                if (confirmPasswordValue.trim() == "")
                                    Toast.makeText(
                                        context,
                                        "❌ Confirm your password!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                else {
                                    // checking password and confirm password matches or not
                                    if (passwordValue.trim() == confirmPasswordValue.trim()) {
                                        buttonColor = if (buttonColor == Color.White)
                                            Color.Transparent else Color.White

                                        buttonTextColor = if (buttonTextColor == Color.Black)
                                            Color.White else Color.Black

                                        navController.navigate("shoppingHomeScreen/${firstNameValue.trim().replaceFirstChar { it.uppercase() }}")
                                    } else {
                                        Toast.makeText(
                                            context,
                                            "❌ Both passwords should be same!",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                            }
                        }
                    } else {
                        Toast.makeText(
                            context,
                            "❌ Email is not valid!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
            }
            else
                Toast.makeText(
                    context,
                    "❌ Enter your name!",
                    Toast.LENGTH_SHORT
                ).show()
        },
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
    )
    {
        Text(
            text = "Sign Up",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = buttonTextColor,
            )
        )
    }
}