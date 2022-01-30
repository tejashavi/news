package com.jasbir.news.data.remote.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Myapi {


    @FormUrlEncoded
    @POST("login")
    fun userlogin(
        @Field("email") email: String,
        @Field("password") pass: String

    ): Call<ResponseBody>

    companion object{
        operator fun invoke() : Myapi {

            return Retrofit.Builder()
                .baseUrl("https://api.simplifiedcoding.in/course-apis/mvvm/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Myapi::class.java)
        }
    }
}