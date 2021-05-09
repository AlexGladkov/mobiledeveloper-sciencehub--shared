package ru.gladkov.sciencehub.androidApp.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.gladkov.sciencehub.androidApp.domain.mapper.NewDetailsMapper
import ru.gladkov.sciencehub.androidApp.domain.models.HubbleNewDetails
import ru.gladkov.sciencehub.shared.di.EngineSDK
import ru.gladkov.sciencehub.shared.features.hubble.hubble

class DetailsViewModel : ViewModel() {

    private val mapper = NewDetailsMapper()
    private val _error: MutableLiveData<String> = MutableLiveData("")
    val error: LiveData<String> = _error

    private val _detail: MutableLiveData<HubbleNewDetails> = MutableLiveData()
    val detail: LiveData<HubbleNewDetails> = _detail

    fun getNew(newId: String?) {
        viewModelScope.launch {
            newId?.let {
                try {
                    EngineSDK.hubble.hubbleRepository
                        .getNew(newId)
                        .let { response -> mapper.transform(response) }
                        .let { new ->
                            _detail.value = new
                        }
                } catch (e: Exception) {
                    _error.value = e.message
                }
            } ?: run {
                _error.value = "ID новости не найден"
            }
        }
    }
}
