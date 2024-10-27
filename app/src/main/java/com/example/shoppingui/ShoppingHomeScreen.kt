package com.example.shoppingui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.LinkAnnotation
import coil.compose.AsyncImage
import kotlinx.coroutines.delay
import java.net.URI
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


@Composable
fun ShoppingHomeScreen(navController: NavController, firstName: String)
{
    // for placing everything vertically
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFF5F5F5))
        .padding(top = 30.dp, start = 20.dp, end = 20.dp)
        .verticalScroll(rememberScrollState())
    )
    {
        // for app bar
        AppBar(firstName = firstName)

        // for search bar
        SearchBarAndIcon()

        Spacer(modifier = Modifier.height(20.dp)) // creating space

        // for the circular cards
        CircularQueueCards()

        Spacer(modifier = Modifier.height(25.dp)) // creating space

        SwipableOptions() // for swipable options

        Spacer(modifier = Modifier.height(25.dp)) // creating space

        ShoppingImages(navController = navController) // for the shopping app images
    }
}

// function for the top app bar
@Composable
fun AppBar(firstName: String)
{
    val context = LocalContext.current // context

    // for the image icon and the name
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(85.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
        )
    {
        // for the option image
        Card(colors = CardDefaults.cardColors(Color.White),
            shape = CircleShape,
            modifier = Modifier
                .size(40.dp)
                .clickable{
                    Toast.makeText(context,
                        "Feature will be coming soon...",
                        Toast.LENGTH_SHORT
                    ).show()
                },
            elevation = CardDefaults.cardElevation(8.dp)
        )
        {
            Box(modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            )
            {
                // for the option icon
                Image(
                    painter = painterResource(id = R.drawable.option_icon),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(25.dp)
                )
            }
        }

        // for the show text
        Column(modifier = Modifier
            .fillMaxSize()
            .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            // for the hello named text
            Text(
                text = buildAnnotatedString {
                    append(text = "Hi! ")
                    withStyle(
                        style = SpanStyle(
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFF007F)
                        )
                    )
                    {
                        append(text = firstName)
                    }
                },
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
            )
            // for the let's shop text
            Text(
                text = "Let's shop!",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
            )
        }

        // for the profile image
        Card(colors = CardDefaults.cardColors(Color.White),
            shape = CircleShape,
            modifier = Modifier
                .size(40.dp)
                .clickable{
                    Toast.makeText(context,
                        "Feature will be coming soon...",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            ,
            elevation = CardDefaults.cardElevation(8.dp)
        )
        {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            )
            {
                // for the option icon
                Image(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(25.dp)
                )
            }
        }
    }
}

// function for the search bar and the side icon
@Composable
fun SearchBarAndIcon()
{
    val context = LocalContext.current // context
    var searchValue by remember { mutableStateOf("") } // storing the search value inside the state

    // for placing horizontally
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    )
    {
        Card(modifier = Modifier
            .height(46.5.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(16.dp)
        )
        {
            // for the search bar
            TextField(
                placeholder = {
                    Text(
                        "Search products",
                        style = TextStyle(
                            fontSize = 12.sp,
                        )
                    )
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    focusedPlaceholderColor = Color.LightGray,
                    unfocusedPlaceholderColor = Color.LightGray,
                    focusedTrailingIconColor = Color.Transparent,
                    unfocusedTrailingIconColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                textStyle = TextStyle(
                    fontSize = 12.5.sp,
                    color = Color.Black
                ),
                singleLine = true,
                value = searchValue,
                onValueChange = {
                    searchValue = it
                },
                modifier = Modifier
                    .weight(1f)
            )
        }

        Spacer(modifier = Modifier.width(10.dp)) // creating some space

        // for the adjust icon
        Card(colors = CardDefaults.cardColors(Color(0xFFFF8DA1)),
            modifier = Modifier
                .size(46.5.dp)
                .align(alignment = Alignment.CenterVertically)
                .clickable{
                    Toast.makeText(context,
                        "Feature will be coming soon...",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            ,
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        )
        {
            Box(modifier = Modifier
                .fillMaxSize(),
                contentAlignment = Alignment.Center
                )
            {
                Image(
                    painter = painterResource(id = R.drawable.settings_adjust),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        }
    }
}

// function for the swipe cards
@Composable
fun CircularQueueCards() {
    // list of all swipe card images
    val imagesForSwipeCards = listOf(
        R.drawable.banner_1,
        R.drawable.banner_2,
        R.drawable.banner_3,
        R.drawable.banner_4
    )

    var index by remember { mutableIntStateOf(0) } // storing index value in state

    var image by remember { mutableIntStateOf(imagesForSwipeCards[0]) }  // storing the first image

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(shape = RoundedCornerShape(35.dp))
    ) {
        // Placing the image
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Define function to update the image index
        val changeImage: (Boolean) -> Unit = { forward: Boolean ->
            index = if (forward) {
                (index + 1) % imagesForSwipeCards.size
            } else {
                if (index > 0) index - 1 else imagesForSwipeCards.size - 1
            }
            image = imagesForSwipeCards[index]
        }

        // Automatic image change every 5 seconds
        LaunchedEffect(Unit) {
            while (true) {
                delay(2000) // Change interval as needed
                changeImage(true)
            }
        }

        // Placing clickable areas horizontally
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            // Left-click area to go to the previous image
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.5f)
                    .background(color = Color.Transparent)
                    .clickable(
                        indication = null, // hiding click effect
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = { changeImage(false) } // go to previous image
                    )
            )

            // Right-click area to go to the next image
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .background(color = Color.Transparent)
                    .clickable(
                        indication = null, // hiding click effect
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = { changeImage(true) } // go to next image
                    )
            )
        }
    }
}


// function for the swipe options
@Composable
fun SwipableOptions()
{
    // storing selected option as null to store the options
    var selectedOption by remember { mutableStateOf<String?>(null) }

    // list of all options
    val options = listOf(
        "All" ,
        "Popular",
        "Recent",
        "Recommend",
        "Trending",
        "Featured"
    )

    // for placing horizontally
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(30.dp)
        .horizontalScroll(rememberScrollState()),
    )
    {
        // placing the options
        options.forEach { label ->
            Box(modifier = Modifier
                .fillMaxHeight()
                .clip(shape = RoundedCornerShape(20.dp))
                .background(color = if(selectedOption == label) Color(0xFFFF8DA1) else Color.LightGray)
                    .clickable(onClick = {
                    selectedOption = label
                }
                ),
                contentAlignment = Alignment.Center
            )
            {
                Text(text = "     $label     ",
                    style = TextStyle(
                        fontSize = 15.sp,
                        color = if(selectedOption == label) Color.White else Color.DarkGray,
                        )
                    )
            }
            // creating space
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

// function for the all images
@Composable
fun ShoppingImages(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize())
    {
        // chunked will break the list into two item sub lists
        ImageUrls.urls.keys.chunked(2).forEach { chunkedImage ->

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(15.dp)
                )
            {
                chunkedImage.forEach { image ->
                    val image: String = image
                    val encodedImage = URLEncoder.encode(image, StandardCharsets.UTF_8.toString())
                    val title: String = ImageUrls.urls[image]?.get(0).toString()
                    val price: Int = ImageUrls.urls[image]?.get(1) as Int
                    val description: String = ImageUrls.urls[image]?.get(2).toString()

                    // for image and texts
                    Box(modifier = Modifier
                        .weight(1f)
                        .height(270.dp)
                        .clickable(
                            onClick = {
                                navController.navigate("shoppingImageZoom/$encodedImage/$title/$price/$description")
                            }
                        )
                    )
                    {
                        // for image
                        Card(
                            shape = RoundedCornerShape(40.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(230.dp)

                        )
                        {
                            AsyncImage(
                                model = image,
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )

                        }
                        Column(modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Bottom){
                            // for text
                            Text(
                                text = "     $title",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                            )
                            Text(text = "      ₹${price}",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    color = Color.DarkGray,
                                    fontWeight = FontWeight.Normal
                                ),
                                )
                        }
                    }
                }

            }
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}
