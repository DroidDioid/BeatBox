package ru.tim.beatbox

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import ru.tim.beatbox.SeekBarViewModel.progress as playbackSpeed

//var playbackSpeed = 1.0f

class SoundViewModel(private val beatBox: BeatBox) : BaseObservable() {

    //val title: MutableLiveData<String> = MutableLiveData()

    var sound: Sound? = null
        set(sound) {
            field = sound
            notifyChange()
            //title.postValue(sound?.name)
        }

    @get:Bindable
    val title: String?
        get() = sound?.name

    fun onButtonClicked() {
        sound?.let {
            beatBox.play(it, playbackSpeed)
        }
    }
}