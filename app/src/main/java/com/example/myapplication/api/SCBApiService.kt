package com.example.myapplication.api

import com.example.myapplication.model.TokenModel
import com.example.myapplication.model.data.ExampleData


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SCBApiService {
    @POST("v1/oauth/token")
    fun getToken(@Body exampleData: ExampleData): Call<TokenModel>
}