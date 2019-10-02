package com.example.myapplication.api

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("resourceOwnerId", "l750ef3bc617274236962e9075f64cb06f")
                .addHeader("requestUId", "12345")
                .addHeader("accept-language", "EN")
                .build()
        )
    }
}