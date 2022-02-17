package com.example.rachtr_task

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.*

interface ApiInterface {

    @POST("UserLogin")
    fun getData(@Body requestBody:RequestClass): Call<pojo>
}