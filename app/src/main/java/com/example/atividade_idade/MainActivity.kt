package com.example.atividade_idade

import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import android.widget.Button
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.atividade_idade.ui.theme.AtividadeidadeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            AtividadeidadeTheme() {

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    IdadeScreen()

                }

            }

        }
    }
}

@Composable
fun IdadeScreen() {

    var idade by remember {
        mutableStateOf(178)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(

            text = " Qual é a sua idade?",
            fontSize = 32.sp,
            color= Color(0,0,255)
        )

        Text(

            text = " $idade",
            fontSize = 48.sp,


            )


        Spacer(modifier = Modifier.height(20.dp))

        Row (
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Button (
                onClick = {
                    if (idade > 0)
                        idade--
                }
            ) {
                Text("-")
            }

            Button (
                onClick = {
                    if (idade < 180)
                    idade++
                }
            ) {
                Text("+")
            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = if (idade < 18)
                "Você é MENOR de idade"
            else
                "Você é MAIOR de idade",

            fontSize = 30.sp,
            color = if(idade<18) {
                Color(255,0,0)
            } else {
                Color(0,0,255)
            }

        )

    }
}
