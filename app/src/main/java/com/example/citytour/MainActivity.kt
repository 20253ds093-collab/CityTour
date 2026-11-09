package com.example.citytour

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.citytour.audio.ReproductorAudio
import com.example.citytour.ui.screens.MonumentoScreen

class MainActivity : ComponentActivity() {

    private lateinit var reproductor: ReproductorAudio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Se crea el reproductor con el audio
        reproductor = ReproductorAudio(this, R.raw.historia_monumento)

        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize().systemBarsPadding()) {
                    MonumentoScreen(reproductor)
                }
            }
        }
    }

    // Si la app pasa a segundo plano, se pausa el audio
    override fun onPause() {
        super.onPause()
        reproductor.pausar()
    }

    // Se libera la memoria del reproductor al cerrar la pantalla
    override fun onDestroy() {
        super.onDestroy()
        reproductor.liberar()
    }
}
