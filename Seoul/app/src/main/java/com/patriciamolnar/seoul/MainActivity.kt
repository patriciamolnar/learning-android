package com.patriciamolnar.seoul

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        .background(Color(0xFF0045A1))) {
        Text(
            text = "Seoul",
            modifier = modifier.padding(20.dp)
        )
        Text(
            text = "Top 10 attractions",
            modifier = modifier.padding(20.dp)
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
            painter = painterResource(id = R.drawable.pexels_jakob_jin_12273121),
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