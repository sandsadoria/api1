package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.api.SCBManager
import com.example.myapplication.model.TokenModel
import com.example.myapplication.model.data.ExampleData
import kotlinx.android.synthetic.main.activity_main.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setView()
        testApi()
    }

    fun setView() {
        btnGotoDeepLink.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("scbeasysim://purchase/a45378dc-b99b-4805-87af-9474fa9b689d")))
        }
    }

    fun testApi() {

        val ex = ExampleData("l750ef3bc617274236962e9075f64cb06f" , "b7aa4f8c3fad4c10ae8bca6a6f1830c8")
        SCBManager().createService().getToken(ex).enqueue(object : Callback<TokenModel> {

            override fun onFailure(call: Call<TokenModel>, t: Throwable) {

                println("sand > FAILED ! $t")

            }

            override fun onResponse(call: Call<TokenModel>, response: Response<TokenModel>) {

                response.body()?.apply {
                    println("sand > have data2")
                    println("sand > code status "+ response.code() )
                    println("sand > body "+ response.body().toString() )
                }


            }

        })

        val ex1 = ExampleData("l750ef3bc617274236962e9075f64cb06f" , "b7aa4f8c3fad4c10ae8bca6a6f1830c8")
        SCBManager().createService().getToken(ex).enqueue(object : Callback<TokenModel> {

            override fun onFailure(call: Call<TokenModel>, t: Throwable) {

                println("sand > FAILED ! $t")

            }

            override fun onResponse(call: Call<TokenModel>, response: Response<TokenModel>) {

                response.body()?.apply {
                    println("sand > have data2")
                    println("sand > code status "+ response.code() )
                    println("sand > body "+ response.body().toString() )
                }


            }

        })

    }
}
