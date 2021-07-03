package com.jmb.thesport.data.model.response

import com.google.gson.annotations.SerializedName


data class Teams(
    @SerializedName("teams")
    val teams: List<Team>
)