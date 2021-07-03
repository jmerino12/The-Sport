package com.jmb.thesport.data.model.response


import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("dateEvent")
    val dateEvent: String,
    @SerializedName("dateEventLocal")
    val dateEventLocal: String,
    @SerializedName("idAPIfootball")
    val idAPIfootball: String,
    @SerializedName("idAwayTeam")
    val idAwayTeam: String,
    @SerializedName("idEvent")
    val idEvent: String,
    @SerializedName("idHomeTeam")
    val idHomeTeam: String,
    @SerializedName("idLeague")
    val idLeague: String,
    @SerializedName("idSoccerXML")
    val idSoccerXML: String,
    @SerializedName("intAwayScore")
    val intAwayScore: String,
    @SerializedName("intAwayShots")
    val intAwayShots: String,
    @SerializedName("intHomeScore")
    val intHomeScore: String,
    @SerializedName("intHomeShots")
    val intHomeShots: String,
    @SerializedName("intRound")
    val intRound: String,
    @SerializedName("intSpectators")
    val intSpectators: String,
    @SerializedName("strAwayFormation")
    val strAwayFormation: String,
    @SerializedName("strAwayGoalDetails")
    val strAwayGoalDetails: String,
    @SerializedName("strAwayLineupDefense")
    val strAwayLineupDefense: String,
    @SerializedName("strAwayLineupForward")
    val strAwayLineupForward: String,
    @SerializedName("strAwayLineupGoalkeeper")
    val strAwayLineupGoalkeeper: String,
    @SerializedName("strAwayLineupMidfield")
    val strAwayLineupMidfield: String,
    @SerializedName("strAwayLineupSubstitutes")
    val strAwayLineupSubstitutes: String,
    @SerializedName("strAwayRedCards")
    val strAwayRedCards: String,
    @SerializedName("strAwayTeam")
    val strAwayTeam: String,
    @SerializedName("strAwayYellowCards")
    val strAwayYellowCards: String,
    @SerializedName("strBanner")
    val strBanner: String,
    @SerializedName("strCity")
    val strCity: String,
    @SerializedName("strCountry")
    val strCountry: String,
    @SerializedName("strDescriptionEN")
    val strDescriptionEN: String,
    @SerializedName("strEvent")
    val strEvent: String,
    @SerializedName("strEventAlternate")
    val strEventAlternate: String,
    @SerializedName("strFanart")
    val strFanart: String,
    @SerializedName("strFilename")
    val strFilename: String,
    @SerializedName("strHomeFormation")
    val strHomeFormation: String,
    @SerializedName("strHomeGoalDetails")
    val strHomeGoalDetails: String,
    @SerializedName("strHomeLineupDefense")
    val strHomeLineupDefense: String,
    @SerializedName("strHomeLineupForward")
    val strHomeLineupForward: String,
    @SerializedName("strHomeLineupGoalkeeper")
    val strHomeLineupGoalkeeper: String,
    @SerializedName("strHomeLineupMidfield")
    val strHomeLineupMidfield: String,
    @SerializedName("strHomeLineupSubstitutes")
    val strHomeLineupSubstitutes: String,
    @SerializedName("strHomeRedCards")
    val strHomeRedCards: String,
    @SerializedName("strHomeTeam")
    val strHomeTeam: String,
    @SerializedName("strHomeYellowCards")
    val strHomeYellowCards: String,
    @SerializedName("strLeague")
    val strLeague: String,
    @SerializedName("strLocked")
    val strLocked: String,
    @SerializedName("strMap")
    val strMap: String,
    @SerializedName("strOfficial")
    val strOfficial: String,
    @SerializedName("strPoster")
    val strPoster: String,
    @SerializedName("strPostponed")
    val strPostponed: String,
    @SerializedName("strResult")
    val strResult: String,
    @SerializedName("strSeason")
    val strSeason: String,
    @SerializedName("strSport")
    val strSport: String,
    @SerializedName("strSquare")
    val strSquare: String,
    @SerializedName("strStatus")
    val strStatus: String,
    @SerializedName("strTVStation")
    val strTVStation: String,
    @SerializedName("strThumb")
    val strThumb: String,
    @SerializedName("strTime")
    val strTime: String,
    @SerializedName("strTimeLocal")
    val strTimeLocal: String,
    @SerializedName("strTimestamp")
    val strTimestamp: String,
    @SerializedName("strTweet1")
    val strTweet1: String,
    @SerializedName("strTweet2")
    val strTweet2: String,
    @SerializedName("strTweet3")
    val strTweet3: String,
    @SerializedName("strVenue")
    val strVenue: String,
    @SerializedName("strVideo")
    val strVideo: String
)