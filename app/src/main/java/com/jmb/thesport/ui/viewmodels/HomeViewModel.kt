package com.jmb.thesport.ui.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.jmb.thesport.data.model.response.Teams
import com.jmb.thesport.repository.HomeRepository
import com.jmb.thesport.util.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * Created by Jonathan Meriño Bolivar on 2/07/2021.
 */
const val TAG = "LoginViewModel"

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val equipo = MutableLiveData<String>()

    init {
        setLiga("Spanish La Liga")
    }

    fun setLiga(tragoName: String) {
        equipo.value = tragoName
    }

    private val homeRepo = HomeRepository()
    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


    private val _statusResource = MutableLiveData<Resource<Teams>>()
    val statusResource: LiveData<Resource<Teams>>
        get() = _statusResource


    fun getTeams(nombreEquipo: String) {
        uiScope.launch {
            _statusResource.value = Resource.Loading()
            try {
                _statusResource.value = homeRepo.getAllTeams(nombreEquipo)
            } catch (e: Exception) {
                _statusResource.value = Resource.Failure(e)
            }
        }
    }

    fun getTeamsEmit(nombreEquipo: String) = liveData(Dispatchers.IO) {
        try {
            emit(homeRepo.getAllTeams(nombreEquipo))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun getEventos(nombreEquipo: String) = liveData(Dispatchers.IO) {
        try {
            emit(homeRepo.getEvents(nombreEquipo))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    val fetchLigaList = equipo.distinctUntilChanged().switchMap { nombreLiga ->
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                emit(homeRepo.getAllTeams(nombreLiga))
            } catch (e: Exception) {
                emit(Resource.Failure(e))
            }
        }
    }


    class Factory(private val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return HomeViewModel(application) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel -  err ")
        }
    }


}
