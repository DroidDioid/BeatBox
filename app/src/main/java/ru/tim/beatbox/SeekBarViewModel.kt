package ru.tim.beatbox

import android.util.Log
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.ViewModel

object SeekBarViewModel : BaseObservable() {

    private const val MAX_PROGRESS = 100f
    private const val MAX_SPEED = 2.0f
    private const val MIN_SPEED = 0.5f

    @Bindable
    var progress: Float = 1f
        set(progress) {
            field = progress * (MAX_SPEED - MIN_SPEED) / MAX_PROGRESS + MIN_SPEED
        }

    fun getOnSeekBarChangeListener() = object : OnSeekBarChangeListener {

        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            this@SeekBarViewModel.progress = progress.toFloat()
            notifyChange()
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {}

        override fun onStopTrackingTouch(seekBar: SeekBar?) {}

    }
}