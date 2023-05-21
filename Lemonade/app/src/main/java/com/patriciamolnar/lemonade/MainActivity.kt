package com.patriciamolnar.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.patriciamolnar.lemonade.ui.theme.LemonadeTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CatsMakingLemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeHeader(modifier: Modifier) {
    Row(modifier = modifier
        .fillMaxWidth()
        .background(Color.Cyan, RectangleShape)) {
        Text(
            text = "Cats making Lemonade",
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Composable
fun CatsMakingLemonadeApp() {
    var level by remember { mutableStateOf(1)}
    Column() {
        LemonadeHeader(modifier = Modifier)
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val image = painterResource(id = R.drawable.cat_lemon_tree)
            TextButton(
                onClick = { level = 2 },

            ) {
                Image(
                    painter = image,
                    contentDescription = "Cat picking some lemons",
                    modifier = Modifier
                        .width(200.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
            }
            Text(text = level.toString())
            Spacer(modifier = Modifier.height(30.dp))
            Text("Click image to help cat get some lemons")
        }


    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        CatsMakingLemonadeApp()
    }
}