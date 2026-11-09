package com.example.citytour.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.citytour.R
import com.example.citytour.audio.ReproductorAudio
import com.example.citytour.ui.components.CarruselImagenes
import com.example.citytour.ui.components.ControlesAudio

@Composable
fun MonumentoScreen(reproductor: ReproductorAudio) {
    // Imágenes del carrusel
    val imagenes = listOf(
        R.drawable.monumento_1,
        R.drawable.monumento_2,
        R.drawable.monumento_3
    )

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "CityTour - Monumento histórico",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(12.dp))

        CarruselImagenes(imagenes = imagenes)

        Spacer(modifier = Modifier.height(16.dp))

        ControlesAudio(
            estado = reproductor.estado,
            onPlay = { reproductor.reproducir() },
            onPausa = { reproductor.pausar() },
            onStop = { reproductor.detener() },
            onVolumen = { reproductor.cambiarVolumen(it) }
        )
    }
}
