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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        CatsMakingLemonadeApp()
    }
}


@Composable
fun LemonadeHeader(modifier: Modifier) {
    Row(modifier = modifier
        .fillMaxWidth()
        .background(Color.Cyan, RectangleShape)) {
        Text(
            text = "Cats making Lemonade (not for you though)",
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Composable
fun CatsMakingLemonadeApp() {
    var level by remember { mutableStateOf(1)}
    var lemonSqueezedAmount by remember { mutableStateOf(
        (2..4).random()
    )}
    val imageResource = when(level) {
        1 -> R.drawable.cat_lemon_tree
        2 -> R.drawable.cat_lemon
        3 -> R.drawable.cat_drink
        else -> R.drawable.cat_more
    }

    val imageDescription = when(level) {
        1 -> "Whiskers here is trying (& failing) to get the best lemons. Pick them for her by clicking the photo."
        2 -> "Wiggles is a cat and seems to be disturbed by the idea of her doing any work. Click the image $lemonSqueezedAmount times to milk them juicy lemons for her"
        3 -> "Sushi is enjoying roasting in the sun. Click the image to ensure she stays hydrated with that fresh lemonade."
        else -> "Muffin is not happy all the lemonade is gone. Click the image to make some moar before she murders you in your sleep."
    }

    Column() {
        LemonadeHeader(modifier = Modifier)
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val image = painterResource(id = imageResource)
            TextButton(
                onClick = {
                    when(level) {
                        1, 3 -> level += 1
                        2 -> if(lemonSqueezedAmount == 0) {
                            level += 1
                        } else {
                            lemonSqueezedAmount -= 1
                        }
                        else -> level = 1
                    }
                }
            ) {
                Image(
                    painter = image,
                    contentDescription = imageDescription,
                    modifier = Modifier
                        .width(200.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Text(lemonSqueezedAmount.toString())
            Text(imageDescription)
        }


    }


}
