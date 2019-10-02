package com.example.myapplication.model


import com.example.myapplication.model.data.Data

import com.example.myapplication.model.data.StatusModel
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize



data class TkModel (
    @SerializedName("status")
    val status : StatusModel?,

    @SerializedName("data")
    val data1 : Data?

)