package com.example.praktikum3_state_235150207111065jonathansalim

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import com.example.praktikum3_state_235150207111065jonathansalim.ui.theme.Praktikum3_State_235150207111065JonathanSalimTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Praktikum3_State_235150207111065JonathanSalimTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CounterApp()
        Spacer(modifier = Modifier.height(20.dp))
        ColorToggleBox()
        Spacer(modifier = Modifier.height(20.dp))
        ProfileCard()
    }
}

@Composable
fun CounterApp() {
    var count by remember { mutableStateOf(0) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Jumlah: $count", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Button(onClick = { if (count > 0) count-- }) {
                Text("Kurang (–)")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = { count++ }) {
                Text("Tambah (+)")
            }
        }
    }
}


@Composable
fun ColorToggleBox() {
    var isRed by remember { mutableStateOf(true) }
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(if (isRed) Color.Red else Color.Green)
            .clickable { isRed = !isRed },
        contentAlignment = Alignment.Center
    ) {
        Text("Ganti Warna", color = Color.White, fontSize = 18.sp)
    }
}

@Composable

fun ProfileCard() {
    var isFollowed by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Foto profil pakai Image
        Image(
            painter = painterResource(R.drawable.profil), // ganti dengan drawable kamu
            contentDescription = "Foto Profil",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Nama
        Text(
            text = "Nama: Jonathan Salim",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Deskripsi
        Text("Mahasiswa Teknik Informatika")

        Spacer(modifier = Modifier.height(12.dp))

        // Tombol Follow/Unfollow
        Button(onClick = { isFollowed = !isFollowed }) {
            Text(if (isFollowed) "Unfollow" else "Follow")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Indikator teks
        Text(
            if (isFollowed) "Anda mengikuti akun ini"
            else "Anda belum mengikuti akun ini"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Praktikum3_State_235150207111065JonathanSalimTheme {
        MainScreen()
    }
}
