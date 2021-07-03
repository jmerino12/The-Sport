package com.jmb.thesport.repository

import com.jmb.thesport.data.model.response.Events
import com.jmb.thesport.data.model.response.Teams
import com.jmb.thesport.domain.network.NetWork
import com.jmb.thesport.util.Resource

/**
 * Created by Jonathan Meriño Bolivar on 2/07/2021.
 */
class HomeRepository {

    suspend fun getAllTeams(nombreEquipo: String): Resource<Teams> {
        return Resource.Success(NetWork.webService.getTeams(nombreEquipo))
    }

    suspend fun getEvents(nombreEquipo: String): Resource<Events> {
        return Resource.Success(NetWork.webService.getEvents(nombreEquipo))
    }
}