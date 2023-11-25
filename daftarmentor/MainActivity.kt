package com.example.daftarmentor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.daftarmentor.ui.theme.DaftarMentorTheme
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaftarMentorTheme {
                var riwayat = arrayOf(1,2,3,4)
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .drawBehind {
                            // Setting the angle in radians
                            val angleRad = 90f / 180f * 3.14f

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
//                        .background(
//                            brush = Brush.verticalGradient(
//                                colors = listOf(
//                                    Color(0xFF0065FF), // Warna 1: Biru (#0065FF)
//                                    Color(0xFFB2D1FF), // Warna 2: Biru Muda (#B2D1FF)
//                                    Color(0xFFFFFFFF)
//                                )
//                            )
//                        )
                            .padding(start = 20.dp, end = 20.dp)
                    ){
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(top = 25.dp)
                        ){
                            Image(painter = painterResource(id = R.drawable.arrow_back), contentDescription = null)
                            Text(
                                text = "Rekayasa Perangkat Lunak",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 14.dp)
                            )
                        }
                        Text(
                            text = "Menampilkan Mentor Rekayasa Perangkat Lunak:",
                            modifier = Modifier
                                .alpha(0.5f)
                                .padding(top = 25.dp, bottom = 20.dp),
                            fontSize = 12.sp,
                        )
                        MentorListView(riwayat = riwayat)
//                        LazyColumn(
//                            modifier = Modifier
//                                .fillMaxWidth(),
//                            horizontalAlignment = Alignment.CenterHorizontally
//                        ){
//                            items(riwayat){currentRiwayat ->
//                                Row (
//                                    modifier = Modifier
//                                        .background(
//                                            color = Color(0xFFEAEAEA),
//                                            shape = RoundedCornerShape(corner = CornerSize(10.dp))
//                                        )
//                                        .border(1.dp, Color(0xF222222   ))
//                                        .padding(horizontal = 7.dp, vertical = 11.dp),
//                                    verticalAlignment = Alignment.CenterVertically
//                                ){
//                                    Box(
//                                        modifier = Modifier
//                                            .clip(CircleShape)
//                                            .background(Color.Green)
//                                    ){
//                                        Image(
//                                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
//                                            contentDescription = null,
//                                            contentScale = ContentScale.Crop,
//                                            modifier = Modifier
//                                        )
//                                    }
//
//                                    Spacer(modifier = Modifier.width(7.dp))
//                                    Column {
//                                        Text(text = "Arif Rama Putra Sa’id", fontSize = 18.sp, fontWeight = FontWeight.Medium)
//                                        Text(
//                                            text = "Jaringan Saraf Tiruan - Fakultas Ilmu Komputer",
//                                            fontSize = 12.sp,
//                                            lineHeight = 15.sp,
//                                            modifier = Modifier.padding(top = 8.dp, bottom = 6.dp)
//                                        )
//                                        Row (
//                                            verticalAlignment = Alignment.CenterVertically
//                                        ){
//                                            Image(painter = painterResource(id = R.drawable.love), contentDescription = null)
//                                            Spacer(modifier = Modifier.width(5.dp))
//                                            Text(text = "4.3 / 5", fontSize = 10.sp)
//                                        }
//
//                                        Spacer(modifier = Modifier.height(8.dp))
//
//                                        Button(
//                                            onClick = { /*TODO*/ },
//                                            colors = ButtonDefaults.buttonColors(
//                                                containerColor = Color.Transparent
//                                            ),
//                                            contentPadding = PaddingValues(0.dp),
//                                            modifier = Modifier.height(15.dp),
//                                            shape = RoundedCornerShape(0.dp)
//                                        ) {
//                                            Text(text = "Rating & Review",
//                                                fontSize = 12.sp,
////                                            style = TextStyle(
////                                                color = Color(0xF1C58B4)
////                                            )
//                                                color = Color.Black,
//                                            )
//                                            Spacer(modifier = Modifier.width(5.dp))
//
//                                            Image(
//                                                painter = painterResource(id = R.drawable.to_rating_page_button),
//                                                contentDescription = null,
//                                            )
//                                        }
//                                    }
//                                }
//                                Spacer(modifier = Modifier.height(15.dp))
//                            }
//                        }
                    }
                }
            }
        }
    }
}
//
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
//    DaftarMentorTheme {
//        Greeting("Android")
//    }
//}

@Composable
fun MentorListView(riwayat: Array<Int>){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        items(riwayat){currentRiwayat ->
            Row (
                modifier = Modifier
                    .background(
                        color = Color(0xFFEAEAEA),
                        shape = RoundedCornerShape(corner = CornerSize(10.dp))
                    )
                    .border(1.dp, Color(0xF222222))
                    .padding(horizontal = 7.dp, vertical = 11.dp),
                verticalAlignment = Alignment.CenterVertically
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

                Spacer(modifier = Modifier.width(7.dp))
                Column {
                    Text(text = "Arif Rama Putra Sa’id", fontSize = 18.sp, fontWeight = FontWeight.Medium)
                    Text(
                        text = "Jaringan Saraf Tiruan - Fakultas Ilmu Komputer",
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

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier.height(15.dp),
                        shape = RoundedCornerShape(0.dp)
                    ) {
                        Text(text = "Rating & Review",
                            fontSize = 12.sp,
                            color = Color.Black,
                        )
                        Spacer(modifier = Modifier.width(5.dp))

                        Image(
                            painter = painterResource(id = R.drawable.to_rating_page_button),
                            contentDescription = null,
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}