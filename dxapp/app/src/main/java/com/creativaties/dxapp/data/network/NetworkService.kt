package com.creativaties.dxapp.data.network


import com.creativaties.dxapp.data.model.News
import com.creativaties.dxapp.data.model.SampleModel
import io.reactivex.Single
import okhttp3.MultipartBody
import okhttp3.RequestBody
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

}