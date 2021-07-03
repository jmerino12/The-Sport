package com.jmb.thesport.domain.network

import com.google.gson.GsonBuilder
import com.jmb.thesport.data.model.response.Events
import com.jmb.thesport.data.model.response.Teams
import com.jmb.thesport.util.Const
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * Created by Jonathan Meriño Bolivar on 2/07/2021.
 */
private const val IDIOMA = "Spanish"

interface Service {

    @GET("search_all_teams.php")
    suspend fun getTeams(@Query("l") nameTeam: String): Teams

    @GET("searchevents.php")
    suspend fun getEvents(@Query("e") nameTeam: String): Events
}

object NetWork {
    val webService by lazy {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        Retrofit.Builder().baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(httpClient.build())
            .build().create(Service::class.java)
    }
}



