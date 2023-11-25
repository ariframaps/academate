package com.example.formmentor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.formmentor.ui.theme.FormMentorTheme
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormMentorTheme {
                var name by remember {
                    mutableStateOf("")
                }
                var course by remember {
                    mutableStateOf("")
                }
                var experience by remember {
                    mutableStateOf("")
                }
                var motivation by remember {
                    mutableStateOf("")
                }
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .drawBehind {
                            // Setting the angle in radians
                            val angleRad = 60f / 180f * 3.14f

                            // Fractional x
                            val x = kotlin.math
                                .cos(angleRad)
                                .toFloat()

                            // Fractional y
                            val y = kotlin.math
                                .sin(angleRad)
                                .toFloat()

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
                    Column (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp),
                    ){
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(vertical = 25.dp)
                        ){
                            Image(painter = painterResource(id = R.drawable.arrow_back), contentDescription = null)
                            Text(
                                text = "Be a Mentor",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 14.dp)
                            )
                        }
                        Column (
                            modifier = Modifier
//                                .height(50.dp)
                                .background(
                                    Color.White.copy(alpha = .5f),
                                    shape = RoundedCornerShape(corner = CornerSize(10.dp))
                                )
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp, vertical = 30.dp)

                        ){
                            Column {
                                Text(
                                    text = "Nama Lengkap",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold,
                                )
                                OutlinedTextField(
                                    value = name,
                                    onValueChange = {text ->
                                        name = text
                                    },
                                    modifier = Modifier
                                        .background(Color.Transparent)
                                        .fillMaxWidth()
                                        .padding(top = 8.dp),
                                    placeholder = { Text(
                                        text = "Nama Lengkap", fontSize = 12.sp) },
                                    textStyle = TextStyle(
                                        fontSize = 12.sp
                                    ),
                                )
                            }
                            Spacer(modifier = Modifier.height(30.dp))
                            Column {
                                Text(
                                    text = "Mata Kuliah yang Ingin Diajarkan",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold,

                                    )
                                OutlinedTextField(
                                    value = course,
                                    onValueChange = {text ->
                                        course = text
                                    },
                                    modifier = Modifier
                                        .background(Color.Transparent)
                                        .fillMaxWidth()
                                        .padding(top = 8.dp),
                                    placeholder = { Text(
                                        text = "Mata Kuliah", fontSize = 12.sp) },
                                    textStyle = TextStyle(
                                        fontSize = 12.sp
                                    ),
                                )
                            }
                            Spacer(modifier = Modifier.height(30.dp))

                            Column {
                                Text(
                                    text = "Pengalaman",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold,

                                    )
                                OutlinedTextField(
                                    value = experience,
                                    onValueChange = {text ->
                                        experience = text
                                    },
                                    modifier = Modifier
                                        .background(Color.Transparent)
                                        .fillMaxWidth()
                                        .padding(top = 8.dp),
                                    placeholder = { Text(
                                        text = "Deskripsi singkat pengalaman yang relevan", fontSize = 12.sp) },
                                    textStyle = TextStyle(
                                        fontSize = 12.sp
                                    ),
                                )
                            }
                            Spacer(modifier = Modifier.height(30.dp))

                            Column {
                                Text(
                                    text = "Motivasi",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold,

                                    )
                                OutlinedTextField(
                                    value = motivation,
                                    onValueChange = {text ->
                                        motivation = text
                                    },
                                    modifier = Modifier
                                        .background(Color.Transparent)
                                        .fillMaxWidth()
                                        .padding(top = 8.dp),
                                    placeholder = { Text(
                                        text = "Alasan tertarik menjadi mentor", fontSize = 12.sp)},
                                    textStyle = TextStyle(
                                        fontSize = 12.sp
                                    ),
                                )
                            }
                            Spacer(modifier = Modifier.height(30.dp))

                            Row (
                                verticalAlignment = Alignment.Top
                            ){
                                Checkbox(
                                    checked = false,
                                    onCheckedChange = {  }
                                )
                                Text(
                                    text = "Dengan mengajukan formulir ini, saya menyatakan bahwa informasi yang saya berikan adalah benar.",
                                    fontSize = 12.sp,
                                    lineHeight = 15.sp,
                                    color = Color.Black.copy(alpha = .5f)
                                )
                            }
                            Spacer(modifier = Modifier.height(30.dp))

                            Button(
                                onClick = { /*TODO*/ },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(text = "Submit")
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
//    FormMentorTheme {
//        Greeting("Android")
//    }
//}