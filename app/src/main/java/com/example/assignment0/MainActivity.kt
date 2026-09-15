package com.example.assignment0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment0.ui.theme.Assignment0Theme

import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Black
            ) {
                DecisionScreen()
            }
        }
    }
}

@Composable
fun DecisionScreen() {
    var resultMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "\"You miss 100% of the shots you don't take. - Wayne Gretzky\"\n- Michael Scott",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            modifier = Modifier.padding(bottom = 24.dp),
            fontStyle = FontStyle.Italic,

        )

        Text(
            text = "Press a button to see if Michael summons you to this restaurant...",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color.LightGray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ElevatedButton(
                text = "YESH!",
                onClick = {
                    val roll = (1..100).random()
                    resultMessage = if (roll <= 50) {
                        "YESH!"
                    } else {
                        "NOH"
                    }
                },
                modifier = Modifier.weight(1f).padding(horizontal = 1.dp)
            )

            ElevatedButton(
                text = "Maybe-ish?",
                onClick = {
                    val roll = (1..100).random()
                    resultMessage = if (roll <= 25) {
                        "YESH!"
                    } else {
                        "NOH"
                    }
                },
                modifier = Modifier.weight(1f).padding(horizontal = 1.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            ElevatedButton(
                text = "No.. God, please No!",
                onClick = {
                    val roll = (1..100).random()
                    resultMessage = if (roll <= 10) {
                        "YESH!"
                    } else {
                        "NOH"
                    }
                },
                modifier = Modifier.weight(1f).padding(horizontal = 80.dp)
            )
        }
        Text(
            text = resultMessage,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(top = 24.dp)
        )
    }
}


@Composable
fun ElevatedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.elevatedButtonColors(
            contentColor = Color.Black
        )
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )
    }
}
