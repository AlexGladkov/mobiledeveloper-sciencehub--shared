package ru.gladkov.sciencehub.androidApp.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.gladkov.sciencehub.androidApp.domain.mapper.NewsMapper
import ru.gladkov.sciencehub.androidApp.domain.models.HubbleNew
import ru.gladkov.sciencehub.shared.di.EngineSDK
import ru.gladkov.sciencehub.shared.features.hubble.hubble

class NewsViewModel : ViewModel() {
    init {
        fetchNews()
    }

    private val newsMapper = NewsMapper()
    private val _error: MutableLiveData<String> = MutableLiveData("")
    val error: LiveData<String> = _error

    private val _news: MutableLiveData<List<HubbleNew>> = MutableLiveData(emptyList())
    val news: LiveData<List<HubbleNew>> = _news

    private fun fetchNews() {
        viewModelScope.launch {
            try {
                EngineSDK.hubble.hubbleRepository
                    .fetchNews()
                    .map { response -> newsMapper.transform(response) }
                    .let { list ->
                        _news.value = list
                    }
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }
}