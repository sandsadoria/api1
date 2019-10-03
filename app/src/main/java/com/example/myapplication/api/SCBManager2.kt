package com.example.myapplication.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SCBManager2 {
    var token : String;
    var client = OkHttpClient();
    constructor(token : String) {
        this.token = token;
        this.client = OkHttpClient.Builder().addInterceptor(HeaderDeep(token)).build()
    }

        val BASE_SCB_API = "https://api.partners.scb/partners/sandbox/"





    fun createServiceDeep(): SCBApiService =
        Retrofit.Builder()
            .baseUrl(BASE_SCB_API)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client).build()
            .run { create(SCBApiService::class.java) }
}