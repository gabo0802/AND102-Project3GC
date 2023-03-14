package com.example.projext3flixterp1

import com.google.gson.annotations.SerializedName

class NowShowingMovie {

    @SerializedName("rank")
    var rank = 0

    @JvmField
    @SerializedName("title")
    var title: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("poster_path")
    var imageURL: String? = null
}