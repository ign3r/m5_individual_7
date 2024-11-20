package com.example.m5individual7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.m5individual7.ui.theme.M5Individual7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            M5Individual7Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content(innerPadding)
                }
            }
        }
    }
}

@Composable
fun Content(paddingValues: PaddingValues) {

    var boton by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EspacioGrande()
        Titulo("¡Bienvenidos!")
        EspacioNormal()
        TextoNormal("Ignacio")
        EspacioNormal()


        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){

            Button(onClick = { boton=!boton },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue) ) {

                if (!boton){Text(text="Mostrar imagen",
                    color=Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    modifier= Modifier
                        .padding(horizontal = 30.dp)
                        .fillMaxWidth()
                )}
                else{
                    Text(text="Ocultar imagen",
                    color=Color.Gray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    modifier= Modifier
                        .padding(horizontal = 30.dp)
                        .fillMaxWidth())
                }
                }


        }
        EspacioGrande()

        if(boton){
            Image(painter = painterResource(id = R.drawable.imagen1), 
                contentDescription = "Test Imagen",
                modifier = Modifier.size(300.dp))
        }
    }
}


@Composable
fun Titulo(texto : String) {
    Text(
        text =texto,
        color= Color.Black,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        textAlign = TextAlign.Center,
        modifier= Modifier
            .background(Color.White)
            .padding(horizontal = 30.dp)
            .fillMaxWidth()
    )
}
@Composable
fun TextoNormal(texto : String){
    Text(
        text = texto,
        color = Color.Black,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(Color.White)
            .padding(horizontal = 30.dp)
            .fillMaxWidth()
        
    )
}

@Composable
fun EspacioNormal(){
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun EspacioGrande(){
    Spacer(modifier=Modifier.height(60.dp))
}




