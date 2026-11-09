package com.example.citytour.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.citytour.audio.EstadoAudio

// Botones
@Composable
fun ControlesAudio(
    estado: EstadoAudio,
    onPlay: () -> Unit,
    onPausa: () -> Unit,
    onStop: () -> Unit,
    onVolumen: (Float) -> Unit
) {
    var volumen by remember { mutableFloatStateOf(1f) }

    val textoEstado = when (estado) {
        EstadoAudio.DETENIDO -> "Estado: detenido"
        EstadoAudio.REPRODUCIENDO -> "Estado: reproduciendo"
        EstadoAudio.PAUSADO -> "Estado: en pausa"
    }

    Column {
        Text(
            text = textoEstado,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = onPlay) { Text("Play") }
            Button(onClick = onPausa) { Text("Pausa") }
            Button(onClick = onStop) { Text("Stop") }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Volumen")
        Slider(
            value = volumen,
            onValueChange = {
                volumen = it
                onVolumen(it)
            }
        )
    }
}
