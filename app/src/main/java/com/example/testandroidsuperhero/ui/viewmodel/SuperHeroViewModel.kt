package com.example.testandroidsuperhero.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testandroidsuperhero.components.Event
import com.example.testandroidsuperhero.data.model.SuperHero
import com.example.testandroidsuperhero.repository.SuperHeroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SuperHeroViewModel @Inject constructor(
    private val superHeroRepository:SuperHeroRepository
) : ViewModel() {
    private val mutableList = MutableLiveData<MutableList<SuperHero>>()
    //private val superHeroRepository = SuperHeroRepository()
    private val statusMessage = MutableLiveData<Event<String>>()
    val isLoading = MutableLiveData<Boolean>()
    val message : LiveData<Event<String>>
        get() = statusMessage

    fun fetchSuperHeroData():LiveData<MutableList<SuperHero>>{
        if (mutableList.value?.size == null){
            viewModelScope.launch {
                isLoading.postValue(true)
                val response = superHeroRepository.fetchSuperHeroData()?.data?.results
                val listData = mutableListOf<SuperHero>()
                if (!response.isNullOrEmpty()) {
                    response.forEach {
                        listData.add(SuperHero(it.id, it.name, ("${it.thumbnail.path}.${it.thumbnail.extension}")))
                    }
                    isLoading.postValue(false)
                }else{
                    statusMessage.value = Event("AH OCURRIDO UN ERROR AL OBTENER LOS DATOS")
                }
                mutableList.value = listData
            }
        }else{
            return mutableList
        }
        return mutableList
    }
}