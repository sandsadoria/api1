package com.example.myapplication.model

data class DeeplinkData (
   val transactionType : TransType,
   val transactionSubType : Array<String>,
   val billPayment : DataBill
)