package com.example.ucp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Ucp(modifier: Modifier = Modifier) {
    var Name by remember { mutableStateOf("") }
    var NoTelp by remember { mutableStateOf("") }
    var memilihJK by remember { mutableStateOf("") }

    var Namesv by remember { mutableStateOf("") }
    var NoTelpsv by remember { mutableStateOf("") }
    var memilihJKsv by remember { mutableStateOf("") }

    val JK = listOf("Laki-Laki", "Pempuan")

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Cyan)
            .padding(15.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Halo,"
                )
                ElevatedCard() {

                }
            }
            Box(
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ppp),
                    contentDescription = "", modifier = Modifier.size(150.dp)
                        .clip(CircleShape)
                )
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Yuk Lengkapi Data Dirimu !")

        TextField(
            modifier = Modifier.fillMaxWidth().padding(7.dp),
            value = Name,
            onValueChange = { Name = it },
            label = { Text("Name") },
            placeholder = { Text("Masukkan Nama") }
        )

        TextField(
            modifier = Modifier.fillMaxWidth().padding(7.dp),
            value = NoTelp,
            onValueChange = { NoTelp = it },
            label = { Text("No Telepon") },
            placeholder = { Text("Masukkan No Telepon") }
        )

        Row {
            JK.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    RadioButton(
                        selected = memilihJK == item,
                        onClick = {
                            memilihJK = item
                        }
                    )
                    Text(item)
                }
            }
            ElevatedButton(onClick = {
                Namesv = Name
                NoTelpsv = NoTelp
                memilihJKsv = memilihJK
            }) {
                Text("Submit")
            }
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.LightGray),
            ) {
                DetailSurat(judul = "Name", isi = Namesv)
                DetailSurat(judul = "No Telepon", isi = NoTelpsv)
                DetailSurat(judul = "jenis kelamin", isi = memilihJKsv)
            }
        }
    }
}

@Composable
fun DetailSurat(
    judul: String, isi: String
){
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
    ){
        Text(text = judul,
            modifier = Modifier.weight(0.8f))
        Text(text = ":",
            modifier = Modifier.weight(0.2f))
        Text(text = isi,
            modifier = Modifier.weight(2f))
    }
}