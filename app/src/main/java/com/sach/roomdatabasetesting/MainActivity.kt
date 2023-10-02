package com.sach.roomdatabasetesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sach.roomdatabasetesting.ui.theme.RoomDatabaseTestingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomDatabaseTestingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MainScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Add Note", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp)
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))
            OutlinedTextField(value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Medium),
                singleLine = true,
                label = {
                    Text(
                        text = stringResource(R.string.str_title)
                    )
                })
            Spacer(modifier = Modifier.padding(top = 18.dp))
            OutlinedTextField(value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Medium),
                singleLine = false,
                maxLines = 4,
                label = {
                    Text(
                        text = stringResource(R.string.str_description)
                    )
                })
            Spacer(modifier = Modifier.padding(top = 28.dp))
            OutlinedButton(
                onClick = { },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(),
                shape = RoundedCornerShape(8.dp)

            ) {
                Text(text = "Save Details")
            }

        }

    }
}
