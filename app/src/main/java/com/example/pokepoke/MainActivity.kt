package com.example.pokepoke

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokepoke.ui.theme.PokepokeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokepokeTheme {
                // A surface container using the 'background' color from the theme
                ContentView()
            }
        }
    }
}
    
@Composable
fun ContentView() {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
            Scaffold(
                backgroundColor = Color.White,
                topBar = { MyAppBar() }
            ) {
                Text("안녕하세요")
            }
        }
}
    
@Composable
fun MyAppBar() {
        TopAppBar(elevation = 18.dp,
            modifier = Modifier.height(58.dp)
        ) {
            Text(text = stringResource(id = R.string.app_name),
                modifier = Modifier.padding(8.dp)
                    .align(Alignment.CenterVertically),
                fontSize = 18.sp,
                fontWeight = FontWeight.Black,
            )

        }
    }

@Preview(showBackground = true)
@Composable
fun DefaultPreView() {
    PokepokeTheme {
        ContentView()
    }
}