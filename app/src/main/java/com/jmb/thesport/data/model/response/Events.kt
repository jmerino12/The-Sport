package com.jmb.thesport.data.model.response


import com.google.gson.annotations.SerializedName

data class Events(
    @SerializedName("event")
    val event: List<Event>
)