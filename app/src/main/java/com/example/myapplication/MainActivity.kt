package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.api.SCBManager
import com.example.myapplication.api.SCBManager2
import com.example.myapplication.model.*
import com.example.myapplication.model.data.Data
import com.example.myapplication.model.data.ExampleData
import kotlinx.android.synthetic.main.activity_main.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testApi()
    }

    fun setView(url : String) {
        btnGotoDeepLink.setOnClickListener {
//            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("scbeasysim://purchase/a45378dc-b99b-4805-87af-9474fa9b689d")))
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }
    }

    fun testApi() {

        val token = ExampleData("l750ef3bc617274236962e9075f64cb06f" , "b7aa4f8c3fad4c10ae8bca6a6f1830c8")
        SCBManager().createService().getToken(token).enqueue(object : Callback<TokenModel> {
            override fun onFailure(call: Call<TokenModel>, t: Throwable) {
                println("FAILED ! $t")
            }
            override fun onResponse(call: Call<TokenModel>, response: Response<TokenModel>) {

                response.body()?.apply {
                   val globalVar = response.body()!!.data.accessToken;
                    deep(globalVar)
                }
            }})
    }

    fun deep(token : String){
        val deep = DeeplinkData(TransType.valueOf("PURCHASE") , arrayOf("BP"), DataBill(100.00,"872654590872450","12352214234","12345","PTF"))
        SCBManager2(token).createServiceDeep().postDeep(deep).enqueue(object : Callback<TkModel> {
            override fun onFailure(call: Call<TkModel>, t: Throwable) {

                println("sand > FAILED ! $t")

            }
            override fun onResponse(call: Call<TkModel>, response: Response<TkModel>) {
                response.body()?.apply {
                    setView(response.body()!!.data.deeplinkUrl+"?callback_url=findpay://call")
                    println("sand > ${response.body()}")
                }
            } })
    }


}
