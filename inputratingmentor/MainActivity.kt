package com.example.inputratingmentor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inputratingmentor.ui.theme.InputRatingMentorTheme
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InputRatingMentorTheme {
                var inputComment by remember {
                    mutableStateOf("")
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .drawBehind {
                            // Setting the angle in radians
                            val angleRad = 60f / 180f * 3.14f

                            // Fractional x
                            val x = cos(angleRad).toFloat()

                            // Fractional y
                            val y = sin(angleRad).toFloat()

                            // Set the Radius and offset as shown below
                            val radius = sqrt(size.width.pow(2) + size.height.pow(2)) / 2f
                            val offset = center + Offset(x * radius, y * radius)

                            // Setting the exact offset
                            val exactOffset = Offset(
                                x = min(offset.x.coerceAtLeast(0f), size.width),
                                y = size.height - min(
                                    offset.y.coerceAtLeast(0f),
                                    size.height
                                )
                            )

                            // Draw a rectangle with the above values
                            drawRect(
                                brush = Brush.linearGradient(
                                    colors = listOf(
                                        Color(0xFFFFFFFF),
                                        Color(0xFFB2D1FF), // Warna 2: Biru Muda (#B2D1FF)
                                        Color(0xFFB2D1FF), // Warna 2: Biru Muda (#B2D1FF)
                                        Color(0xFF0065FF), // Warna 1: Biru (#0065FF)
                                    ),
                                    start = Offset(size.width, size.height) - exactOffset,
                                    end = exactOffset
                                ),
                                size = size
                            )
                        }
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 20.dp, end = 20.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(top = 25.dp, bottom = 25.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.arrow_back),
                                contentDescription = null
                            )
                            Text(
                                text = "Review",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 14.dp)
                            )
                        }
                        Column {
                            Row (
                                modifier = Modifier
                                    .background(
                                        color = Color(0xFFEAEAEA),
                                        shape = RoundedCornerShape(corner = CornerSize(10.dp))
                                    )
                                    .border(1.dp, Color(0xF222222))
                                    .padding(horizontal = 7.dp, vertical = 30.dp)
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ){
                                Box(
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .background(Color.Green)
                                ){
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                    )
                                }

                                Spacer(modifier = Modifier.width(20.dp))
                                Column {
                                    Text(text = "Arif Rama Putra Sa’id", fontSize = 12.sp)
                                    Text(
                                        text = "Fakultas Ilmu Komputer",
                                        fontSize = 12.sp,
                                        lineHeight = 15.sp,
                                        modifier = Modifier.padding(top = 8.dp, bottom = 6.dp)
                                    )
                                    Row (
                                        verticalAlignment = Alignment.CenterVertically
                                    ){
                                        Image(painter = painterResource(id = R.drawable.love), contentDescription = null)
                                        Spacer(modifier = Modifier.width(5.dp))
                                        Text(text = "4.3 / 5", fontSize = 10.sp)
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(25.dp))

                            Column (
                                modifier = Modifier
                                    .background(
                                        color = Color(0xFFEAEAEA),
                                        shape = RoundedCornerShape(corner = CornerSize(10.dp))
                                    )
                                    .border(1.dp, Color(0xF222222))
                                    .padding(horizontal = 20.dp, vertical = 30.dp)
                                    .fillMaxWidth()
//                                    .height(350.dp)
                            ){
                                Text(
                                    text = "Comment",
                                    fontSize = 18.sp,
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )

                                Spacer(modifier = Modifier.height(25.dp))
                                Column (
                                    modifier = Modifier
                                        .background(
                                            Color.White,
                                            shape = RoundedCornerShape(
                                                corner = CornerSize(
                                                    10.dp
                                                )
                                            )
                                        )
                                        .padding(vertical = 15.dp, horizontal = 20.dp)
                                        .fillMaxWidth()
                                ){
                                    Row (
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.padding(bottom = 8.dp)
                                    ){
                                        Box(
                                            modifier = Modifier
                                                .clip(CircleShape)
                                                .background(Color.Green)
                                                .size(30.dp)
                                        ){
                                            Image(
                                                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                                contentDescription = null,
                                                contentScale = ContentScale.Crop,
                                            )
                                        }
                                        Text(
                                            text = "Aziz Purnomo",
                                            modifier = Modifier.padding(start = 8.dp)
                                        )
                                    }
                                    LazyRow(
                                        modifier = Modifier.padding(vertical = 14.dp)
                                    ){
                                        items(5){
                                            Image(painter = painterResource(id = R.drawable.love), contentDescription = null)
                                        }
                                    }

                                    OutlinedTextField(
                                        value = inputComment,
                                        onValueChange = {text ->
                                            inputComment = text
                                        },
                                        placeholder = {
                                            Text(text = "Type here", fontSize = 12.sp)
                                        },
                                        modifier = Modifier
                                            .background(
                                            Color.Transparent,
                                            shape = RoundedCornerShape(corner = CornerSize(10.dp))
                                            )
                                            .height(200.dp),
                                        textStyle = TextStyle(fontSize = 12.sp)
                                    )
                                }
                                Button(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier.padding(top = 16.dp)
                                ) {
                                    Text(text = "Add Comment")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    InputRatingMentorTheme {
//        Greeting("Android")
//    }
//}