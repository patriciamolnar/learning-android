package com.patriciamolnar.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.patriciamolnar.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

/**
 * Google's solution:
 * https://github.com/google-developer-training/basic-android-kotlin-compose-training-practice-problems/blob/main/Unit%201/Pathway%203/ComposeArticle/app/src/main/java/com/example/composearticle/MainActivity.kt
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ShowTutorial(
                        stringResource(R.string.tutorial_title),
                        stringResource(R.string.tutorial_intro),
                        stringResource(R.string.tutorial_content)
                    )
                }
            }
        }
    }
}

@Composable
fun ShowTutorial(title: String, intro: String, content: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)

    Column {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = modifier.padding(16.dp)
        )
        Text(
            text = intro,
            modifier = modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.body1
        )
        Text(
            text = content,
            style = MaterialTheme.typography.body1,
            modifier = modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }

}

@Preview(showBackground = true, showSystemUi = true, name = "Compose Tutorial")
@Composable
fun DefaultPreview() {
    JetpackComposeTutorialTheme {
        ShowTutorial(
            stringResource(R.string.tutorial_title),
            stringResource(R.string.tutorial_intro),
            stringResource(R.string.tutorial_content)
        )
    }
}