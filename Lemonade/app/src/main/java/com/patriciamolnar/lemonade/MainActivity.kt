package com.patriciamolnar.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontStyle

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
    val lemonadeIcon = painterResource(id = R.drawable.iconmonstr_lemonade)
    val headerPadding = 12.dp

    Column(modifier = modifier
        .fillMaxWidth()
        .background(color = Color(0xFF102119), RectangleShape)) {
        Row(modifier = modifier.padding(headerPadding), horizontalArrangement = Arrangement.Center) {
            Text(
                color = Color.Yellow,
                fontSize = 30.sp,
                text = stringResource(R.string.header_title)
            )
            Icon(
                painter = lemonadeIcon,
                contentDescription = null,
                tint = Color.Yellow,
                modifier = modifier.size(35.dp)
            )
        }
        Text(
            color = Color(0xFFBDDBB9),
            text = stringResource(R.string.header_subtitle),
            textAlign = TextAlign.End,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(
                bottom = headerPadding, start = headerPadding, end = headerPadding
            ).fillMaxWidth()
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

    Column(modifier = Modifier.background(color = Color(0xFF34614C))) {
        LemonadeHeader(modifier = Modifier)
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val borderWidth = 4.dp
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
                        .border(
                            BorderStroke(borderWidth, Color.Yellow),
                            RoundedCornerShape(20.dp)
                        )
                        .padding(4.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = imageDescription,
                textAlign = TextAlign.Center,
                color = Color(0xFFBDDBB9),
                fontSize = 16.sp
            )
        }


    }


}
