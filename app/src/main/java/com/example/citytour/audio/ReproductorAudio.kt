package com.example.citytour.audio

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

enum class EstadoAudio { DETENIDO, REPRODUCIENDO, PAUSADO }

class ReproductorAudio(context: Context, recursoAudio: Int) {

    // El audio se carga desde res/raw
    private var mediaPlayer: MediaPlayer? = MediaPlayer.create(context, recursoAudio)

    // Al cambiar el estado, la pantalla se actualiza sola
    var estado by mutableStateOf(EstadoAudio.DETENIDO)
        private set

    init {
        // Cuando el audio termina, el estado vuelve a detenido
        mediaPlayer?.setOnCompletionListener { estado = EstadoAudio.DETENIDO }
    }

    fun reproducir() {
        val mp = mediaPlayer ?: return
        if (estado != EstadoAudio.REPRODUCIENDO) {
            mp.start()
            estado = EstadoAudio.REPRODUCIENDO
        }
    }

    fun pausar() {
        val mp = mediaPlayer ?: return
        if (estado == EstadoAudio.REPRODUCIENDO) {
            mp.pause()
            estado = EstadoAudio.PAUSADO
        }
    }

    fun detener() {
        val mp = mediaPlayer ?: return
        if (estado != EstadoAudio.DETENIDO) {
            mp.stop()
            try {
                mp.prepare()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            estado = EstadoAudio.DETENIDO
        }
    }

    fun cambiarVolumen(volumen: Float) {
        mediaPlayer?.setVolume(volumen, volumen)
    }

    fun liberar() {
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
