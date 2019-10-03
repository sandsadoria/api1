package com.example.myapplication.model




import com.example.myapplication.model.data.Data
import com.example.myapplication.model.data.StatusModel


data class TokenModel (

    val status : StatusModel,
    val data : Data

){

}