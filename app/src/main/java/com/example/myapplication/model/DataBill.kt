package com.example.myapplication.model

import java.text.DecimalFormat

data class DataBill(
    val paymentAmount : Number,
    val accountTo : String,
    val ref1 : String,
    val ref2 : String,
    val ref3 : String
) {
}

