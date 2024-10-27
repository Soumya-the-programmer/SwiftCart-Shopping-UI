package com.example.shoppingui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun ShoppingImageZoom(navController: NavController,
                      image : String,
                      title : String,
                      description : String,
                      price : Int
)
{
    // for placing everything vertically
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
    )
    {
        // for the image
        Card(modifier = Modifier
            .fillMaxHeight(0.65f)
            .fillMaxWidth(),
            shape = RoundedCornerShape(35.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        )
        {
            // getting image from url
            AsyncImage(model = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
                )
        }

        Spacer(modifier = Modifier.height(30.dp)) // adding some space

        // for the title and price
        TitleAndPrice(title = title, price = price)

        // description
        Text(text = description,
            style =TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            ),
            modifier = Modifier
                .padding(20.dp)
                .align(alignment = Alignment.Start)
            )

        // buy and cart icons
        BuyAndCart()
    }
}

// function for app title and prices
@Composable
fun TitleAndPrice(title: String, price: Int)
{
    // for the title and price
    Row(modifier = Modifier
        .padding(start = 20.dp, end = 20.dp)
        .fillMaxWidth()
        .height(25.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        // for the title
        Text(text = title,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            ),
            modifier = Modifier.align(Alignment.CenterVertically)
        )

        // for the price
        Text(text = "₹$price",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            ),
            modifier = Modifier.align(alignment = Alignment.CenterVertically)
        )
    }
}

// function for buy and cart
@Composable
fun BuyAndCart()
{
    val context = LocalContext.current // context creation

    Row(modifier = Modifier
        .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
        .fillMaxSize(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        // buy now button
        Button(modifier = Modifier
            .height(85.dp)
            .width(240.dp)
            ,
            onClick = {
            Toast.makeText(context,
                "Feature will be coming soon...",
                Toast.LENGTH_SHORT
                ).show()
            },
            colors = ButtonDefaults.buttonColors(Color(0xFFFF8DA1)),
            shape = RoundedCornerShape(40.dp)
        )
        {
            Text(text = "Buy Now",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
        }

        // cart button
        Button(modifier = Modifier
            .size(75.dp)
            ,
            onClick = {
                Toast.makeText(context,
                    "Feature will be coming soon...",
                    Toast.LENGTH_SHORT
                ).show()
            },
            colors = ButtonDefaults.buttonColors(Color(0xffE0E0E0)),
            shape = CircleShape
        )
        {
            Image(painter = painterResource(id = R.drawable.shopping_cart),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier.size(25.dp).align(alignment = Alignment.CenterVertically)
            )
        }
    }
}