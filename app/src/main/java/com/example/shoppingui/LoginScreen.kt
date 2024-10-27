package com.example.shoppingui

import android.content.Context
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import kotlinx.coroutines.delay

// verified accounts details
val verifiedAccounts = mapOf(
    "soumyajeetdas5@gmail.com" to listOf("soumya123", "Soumya"),
    "mtanusree491@gmail.com" to listOf("tanusree123", "Tanusree"),
)

@Composable
fun LoginScreen(navController: NavController) {

    var emailAddressValue by remember { mutableStateOf("") } // storing email value in state
    var passwordValue by remember { mutableStateOf("") } // storing password value in state

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
        HeaderSection(
            emailAddressValue = emailAddressValue,
            onEmailValueChange = {emailAddressValue = it},
            passwordValue = passwordValue,
            onPasswordValueChange = {passwordValue = it},
            navController = navController,
            boldedTitleText = "Welcome,",
            bottomTitleText = "Glad to see you!"
            ) // calling app header section

        // calling app footer section
        FooterSection(navController = navController,
            linedText = "Or Login with",
            unHighlightedText = "Don't have an account?",
            highlightedText = " Sign Up Now",
            navigateString = "signUpScreen"
            )
    }
}


// function for header section of the app
@Composable
fun HeaderSection(
    emailAddressValue : String,
    onEmailValueChange : (String) -> Unit,
    passwordValue : String,
    onPasswordValueChange : (String) -> Unit,
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
            .fillMaxHeight(0.6f)
            .background(color = Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    )
    {
        // for the title headings
        AppTitle(boldedText = boldedTitleText, bottomText = bottomTitleText )

        Spacer(modifier = Modifier.height(30.dp)) // for creating extra space

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

        Spacer(modifier = Modifier.height(20.dp)) // creating extra space

        // forget password text
        Text(text = "Forgot Password?",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 16.sp,
                textAlign = TextAlign.End
            ),
            modifier = Modifier
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick =   {
                        // navigating to  sign up screen
                        Toast.makeText(
                            context,
                            "This feature will coming soon...",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )
                .align(alignment = AbsoluteAlignment.Right) // for placing into right side
        )

        Spacer(modifier = Modifier.height(35.dp)) // for creating extra space

        // for the Login button calling the Login Button function
        LoginButton(
            emailAddressValue = emailAddressValue,
            context = context,
            passwordValue = passwordValue,
            verifiedAccounts = verifiedAccounts,
            navController = navController
        )
    }
}

// function for the footer section of the ui
@Composable
fun FooterSection(navController: NavController,
                  linedText : String,
                  highlightedText: String,
                  unHighlightedText: String,
                  navigateString: String
                  ) {
    // for placing vertically
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Transparent)
            .padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        // for the login with text
        LoginWithText(linedText) // placing the text by calling LoginWithText()

        Spacer(modifier = Modifier.height(30.dp)) // creating space

        // map of button information
        val imageButtonDetails = mapOf(
            0.5f to R.drawable.google_logo,
            1f to R.drawable.facebook_logo
        )

        // for placing the button horizontally
        Row()
        {
            imageButtonDetails.forEach {
                ImageButtonMaker(it.key, it.value)
                Spacer(modifier = Modifier.width(10.dp)) // for creating space between buttons
            }
        }

        // sign up now text
        BottomText(navController = navController,
            unHighlightedText = unHighlightedText,
            highlightedText = highlightedText,
            navigateString = navigateString
            )
    }
}

// button for creating the Login button
@Composable
fun LoginButton(
    emailAddressValue: String,
    context : Context,
    passwordValue : String,
    verifiedAccounts : Map<String, List<String>>,
    navController: NavController
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
            // checking empty value or not
            if (emailAddressValue.trim() == "") {
                Toast.makeText(
                    context,
                    "❌ Email address can't be blank!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // checking if email format is valid or not
                if (Patterns.EMAIL_ADDRESS.matcher(emailAddressValue.trim()).matches()) {

                    // checking if the password field is empty
                    if (passwordValue.trim() == "") {
                        Toast.makeText(
                            context,
                            "❌ Enter your password!",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {

                        // checking if the email is verified (exists in verifiedAccounts)
                        if (emailAddressValue.trim() in verifiedAccounts.keys) {

                            // checking if the password matches the one in verifiedAccounts
                            if (passwordValue == verifiedAccounts[emailAddressValue.trim()]?.get(0)) {
                                buttonColor = if (buttonColor == Color.White)
                                    Color.Transparent else Color.White

                                buttonTextColor = if (buttonTextColor == Color.Black)
                                    Color.White else Color.Black

                                val firstNameValue = verifiedAccounts[emailAddressValue.trim()]?.get(1)

                                navController.navigate("shoppingHomeScreen/${firstNameValue?.trim()}")
                            } else {
                                Toast.makeText(
                                    context,
                                    "❌ Password not matched!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            Toast.makeText(
                                context,
                                "❌ Entered email is not verified!",
                                Toast.LENGTH_SHORT
                            ).show()
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

        },
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
    )
    {
        Text(
            text = "Login",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = buttonTextColor,
            )
        )
    }
}

// function to create text fields
@Composable
fun InputFields(label: String,
                value: String,
                onValueChange : (String) -> Unit,
                keyBoardType : KeyboardType,
                keyboardVisual : VisualTransformation
                )
{
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(12.dp))
    )
    {
        // inserting text field
        TextField(
            value = value,
            label = {
                Text(text = label)
            },
            onValueChange = onValueChange,
            textStyle = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            ),
            keyboardOptions = KeyboardOptions ( keyboardType = keyBoardType),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White.copy(alpha = 0.2f),
                unfocusedContainerColor = Color.White.copy(alpha = 0.2f),
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            visualTransformation = keyboardVisual,
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        )
    }
}

// function to create Image buttons
@Composable
fun ImageButtonMaker(width : Float, image : Int)
{
    val context = LocalContext.current // content

    Card(shape = RoundedCornerShape(12.dp),
        modifier = Modifier
        .fillMaxWidth(width)
        .height(50.dp)
        .clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
        ) {
            Toast.makeText(context, "This feature is yet to be launched", Toast.LENGTH_SHORT).show()
        },
        colors = CardDefaults.cardColors(Color.White)
    )
    {
        Box(modifier = Modifier
            .clip(shape = RoundedCornerShape(12.dp))
            .fillMaxSize(),
            contentAlignment = Alignment.Center)
        {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
            )
        }
    }
}

// function for the Login with text
@Composable
fun LoginWithText(givenText : String, )
{
    // for the design
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(20.dp),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        // line creation
        HorizontalDivider(
            modifier = Modifier
                .weight(1f),
            thickness = 1.dp,
            color = Color.White
        )

        // for the text
        Text(
            "  $givenText   ",
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
        )

        // line creation
        HorizontalDivider(
            modifier = Modifier
                .weight(1f),
            thickness = 1.dp,
            color = Color.White
        )
    }
}

// function for the app title
@Composable
fun AppTitle(boldedText : String, bottomText: String)
{
    // for welcome
    Text(
        text = boldedText,
        style = TextStyle(
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    )
    // for glad to see you text
    Text(
        text = bottomText,
        style = TextStyle(
            fontSize = 34.sp,
            color = Color.White
        )
    )
}

// function for the sign up now text
@Composable
fun BottomText(navController: NavController,
               unHighlightedText : String,
               highlightedText : String,
               navigateString : String
               )
{
    // storing the text color in the state
    var colorText by remember { mutableStateOf(Color.White) }

    Row(modifier = Modifier
        .fillMaxSize(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    )
    {
        // for the Don't have an account text
        Text(text = unHighlightedText,
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal
            )
        )
        //  for the sign up text
        Text(text = highlightedText,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = colorText,
                fontSize = 16.sp),
            modifier = Modifier
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick =   {
                        colorText = if (colorText == Color.White) Color.Gray else Color.White
                        // navigating to  sign up screen
                        navController.navigate(navigateString)
                    }
                )
        )
    }
}
