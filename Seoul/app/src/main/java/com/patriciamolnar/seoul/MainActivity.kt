package com.patriciamolnar.seoul

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.patriciamolnar.seoul.ui.theme.SeoulTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SeoulTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SeoulToDoApp()
                }
            }
        }
    }
}
@Composable
fun SeoulToDoApp(modifier: Modifier = Modifier) {
    Column() {
        SeoulHeader()
        SeoulAttractionImage()
        SeoulAttractionInformation()
    }
}

/*
*   # fix layout
*   # add custom font
*   # fix colour scheme
* */
@Composable
fun SeoulHeader(modifier: Modifier = Modifier) {
    Row(modifier = modifier
        .fillMaxWidth()
        .background(Color(0xFF0045A1)),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = "Seoul",
            modifier = modifier.padding(
                start = 10.dp,
                top = 10.dp,
                bottom = 10.dp
            ),
            style = MaterialTheme.typography.titleLarge.copy(
                shadow = Shadow(
                    color = Color(0xFF002c66),
                    offset = Offset(x = 4f, y = 4f),
                    blurRadius = 0.5f
                )
            ),
            color = Color.White,
            fontSize = 40.sp,

        )
        Text(
            text = "•",
            color = Color(0xFF99c5ff),
            fontSize = 40.sp,
            modifier = modifier.padding(bottom = 10.dp, start = 10.dp, end = 6.dp),
            style = MaterialTheme.typography.bodyLarge.copy(
                shadow = Shadow(
                    color = Color(0xFF002c66),
                    offset = Offset(x = 4f, y = 4f),
                    blurRadius = 0.25f
                )
            )
        )
        Text(
            text = "Top Attractions",
            modifier = modifier.padding(vertical = 20.dp),
            color = Color.White,
            fontSize = 20.sp,
            style = MaterialTheme.typography.bodyLarge.copy(
                shadow = Shadow(
                    color = Color(0xFF002c66),
                    offset = Offset(x = 4f, y = 4f),
                    blurRadius = 0.25f
                )
            )
        )
    }
}

@Composable
fun SeoulAttractionImage() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Image(
            painter = painterResource(id = R.drawable.pexels_vishnu_murali_11997115),
            contentDescription = null,
            modifier = Modifier.padding(20.dp)
        )
    }
}

@Composable
fun SeoulAttractionInformation() {
    Column() {
        Text(text = "Here's the name")
        Text(text = "Seoul, blablab, 3")
        Text(text = "Price: $1")
        Text(text = "Some short description")
    }
}

@Composable
fun SeoulNavigation() {

}

//private fun getImage(index: Int) {
//    when(index) {
//        0 -> R.drawable.pexels_ann_ost_14105898
//        else -> R.drawable.pexels_jakob_jin_12273121
//    }
//}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    SeoulTheme {
        SeoulToDoApp()
    }
}