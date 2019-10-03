package com.example.myapplication.api

import okhttp3.Interceptor
import okhttp3.Response

class HeaderDeep : Interceptor{

    var token : String;
    constructor(token : String) {
        this.token = token
    }


    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("authorization" , "Bearer $token" )
                .addHeader("resourceOwnerId", "l750ef3bc617274236962e9075f64cb06f")
                .addHeader("requestUId", "12345")
                .addHeader("channel","scbeasy")
                .addHeader("accept-language", "EN")
                .build()
        )
    }
}