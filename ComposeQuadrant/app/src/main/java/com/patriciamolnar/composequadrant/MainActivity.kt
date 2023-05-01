package com.patriciamolnar.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.patriciamolnar.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateLayout()
                }
            }
        }
    }
}

@Composable
fun CreateLayout(modifier: Modifier = Modifier) {
    Column(modifier = modifier.border(2.dp, Color.Cyan)) {
        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            Column(
                modifier = modifier
                    .background(color = Color.Green, shape = RectangleShape)
                    .weight(1F)
            ) {
                Text(text = "Text composable")
                Text(text = "Displays text and follows Material Design guidelines.\n")
            }

            Column(
                modifier = modifier
                    .background(color = Color.Yellow, shape = RectangleShape)
                    .weight(1F)
            ) {
                Text(text = "Image composable\n")
                Text(text = "Creates a composable that lays out and draws a given Painter class object.\"")
            }
        }
        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            CreateTile(
                title = "Row composable",
                description = "A layout composable that places its children in a horizontal sequence.",
                color = Color.Cyan,
                modifier = modifier.weight(1F)
            )
            CreateTile(
                title = "Column composable",
                description = "A layout composable that places its children in a vertical sequence.",
                color = Color.LightGray,
                modifier = modifier.weight(1F)
            )
        }
    }
}

@Composable
fun CreateTile(
    title: String,
    description: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.background(color = color, shape = RectangleShape)
    ) {
        Text(text = title)
        Text(text = description)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        CreateLayout()
    }
}