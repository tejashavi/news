package com.jasbir.news.data.remote.network


import com.jasbir.news.data.remote.response.News
import com.jasbir.news.data.remote.response.SampleModel
import io.reactivex.Single
import retrofit2.http.*


interface NetworkService {


    @FormUrlEncoded
    @POST(EndPoints.userlogin)
    fun queryMobileLogin(
        @Field("email") email: String,
        @Field("password") pass: String
    ): Single<SampleModel>

    @GET(EndPoints.headline)
    fun queryNews(
        @Header("Authorization") api : String,
        @Query("country") country: String
    ): Single<News>

/*
    companion object {
        operator fun invoke(): NetworkService{
            return Retrofit.Builder().baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NetworkService::class.java)
        }
    }*/

}