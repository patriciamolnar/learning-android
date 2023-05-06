package com.patriciamolnar.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.patriciamolnar.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun GenerateNameAndPhoto(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth().offset(y = (-30).dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val image = painterResource(id = R.drawable._1db000a2312a89d9d28c9e2901108c3)
        Image(
            painter = image, contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(height = 30.dp))
        Text(
            text = "Sir Licks-a-Lot",
            color = Color.White,
            fontSize = 45.sp
        )
        Text(
            text = "Head of Human Training and Obedience (HHOT)",
            color = Color.White,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 10.dp)
        )
    }
}

@Composable
fun GenerateDetails(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        GenerateDetailCard(
            Icons.Default.Email,
            "Email Icon",
            "go.away@hhot.meow"
        )
        GenerateDetailCard(
            Icons.Default.Phone,
            "Phone Icon",
            "Don't call unless you're dying"
        )
        GenerateDetailCard(
            Icons.Default.Home,
            "Website Icon",
            "www.hhot.meow"
        )
    }
}

@Composable
fun GenerateDetailCard(
    icon: ImageVector,
    iconDescription: String,
    text: String
) {
    Row() {
        Icon(
            imageVector = icon,
            contentDescription = iconDescription,
            tint = Color.White,
            modifier = Modifier.size(30.dp)
        )
        // gap between icon and text
        Spacer(modifier = Modifier.width(width = 6.dp))
        Text(
            color = Color.White,
            text = text,
            fontSize = 20.sp
        )
    }
}

// useful info: https://semicolonspace.com/jetpack-compose-icons/?utm_content=cmp-true

@Composable
fun Greeting(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(color = Color(0xFF991b1b))
            .fillMaxHeight(1F).fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        GenerateNameAndPhoto()
        GenerateDetails()
        Text(
            modifier = Modifier.fillMaxWidth().offset(y = 120.dp),
            color = Color(0xFFfbe9e9),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            text = "@pmcoding"
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        Greeting()
    }
}