package com.example.testandroidsuperhero.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testandroidsuperhero.components.Event
import com.example.testandroidsuperhero.data.model.SuperHeroInfo
import com.example.testandroidsuperhero.repository.SuperHeroInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SuperHeroInfoViewModel @Inject constructor(
    private val superHeroInfoRepository:SuperHeroInfoRepository
): ViewModel() {
    //private val superHeroInfoRepository = SuperHeroInfoRepository()

    private val statusMessage = MutableLiveData<Event<String>>()
    val message : LiveData<Event<String>>
        get() = statusMessage

    fun fetchSuperHeroById(id: Int): MutableLiveData<SuperHeroInfo>{
        val mutableListInfo = MutableLiveData<SuperHeroInfo>()
        var name: String
        var description: String
        var comics = ""
        var series = ""
        var stories = ""
        var events = ""
        var urls = ""
        viewModelScope.launch {
            val response = superHeroInfoRepository.fetchSuperHeroById(id)?.data?.results
            if (!response.isNullOrEmpty()) {
                response.forEach { it ->
                    name = it.name
                    description = it.description
                    it.comics.items.forEach {
                        comics += "◆ ${it.name}\n" //Url: ${it.resourceURI}
                    }
                    it.series.items.forEach {
                        series += "◆ ${it.name}\n" //${it.resourceURI}
                    }
                    it.stories.items.forEach {
                        stories += "◆ ${it.name}\n" //${it.type} ${it.resourceURI}
                    }
                    it.events.items.forEach {
                        events += "◆ ${it.name}\n" // ${it.resourceURI}
                    }
                    it.urls.forEach {
                        urls += "◆ ${it.url}\n" //${it.type}
                    }
                    mutableListInfo.postValue(SuperHeroInfo(name, description, comics, series, stories, events, urls))
                }
            }else{
                statusMessage.value = Event("AH OCURRIDO UN ERROR AL OBTENER LOS DATOS")
            }
        }
        return mutableListInfo
    }
}