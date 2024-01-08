package com.nsteuerberg.a1

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nsteuerberg.a1.ui.theme._1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(200, 100, 50)
                ) {
                    Artist()
                }
            }
        }
    }
}
@Composable
fun Artist(){
    Column (modifier = Modifier.border(BorderStroke(0.dp,Color.Red))){
        Row(modifier = Modifier.padding(30.dp, 20.dp)){
            Column {
                Box(modifier = Modifier.size(80.dp,70.dp)){
                    Image(
                        painter = painterResource(id = R.drawable.dino_icon),
                        contentDescription = "${stringResource(id = R.string.iconDescription)}",
                        modifier = Modifier
                            .width(70.dp)
                            .height(70.dp)
                            .clip(CircleShape)
                            .background(Color(100, 100, 100))
                            .padding(10.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.verification_icon),
                        contentDescription = "${stringResource(id = R.string.iconDescription)}",
                        modifier = Modifier
                            .padding(55.dp,40.dp,5.dp,10.dp)
                    )
                }
            }
            Column(modifier = Modifier.padding(10.dp,0.dp)){
                Text(
                    text = "Dino Seto",
                    fontSize = 26.sp
                )
                Text(
                    text = stringResource(id = R.string.time),
                    color = Color.Gray
                )
            }
        }

        Row (modifier = Modifier.fillMaxWidth().padding(5.dp,0.dp,5.dp,0.dp), horizontalArrangement = Arrangement.Center){
                Image(
                    painter = painterResource(id = R.drawable.paisaje),
                    contentDescription = "Imagen",
                    modifier = Modifier
                        .size(350.dp)
                )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _1Theme {
        Artist()
    }
}