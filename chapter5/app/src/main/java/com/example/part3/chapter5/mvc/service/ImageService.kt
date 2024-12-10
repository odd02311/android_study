package com.example.part3.chapter5.mvc.service

import com.example.part3.chapter5.mvc.model.ImageResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ImageService {

    @Headers("Authorization: Client-ID zuwabrW5-T8HUl81iMTraBGwdTb4ZCljzKHpRQAf_Vg")
    @GET("photos/random")
    fun getRandomImage() : Call<ImageResponse>

    @Headers("Authorization: Client-ID zuwabrW5-T8HUl81iMTraBGwdTb4ZCljzKHpRQAf_Vg")
    @GET("photos/random")
    fun getRandomImageRX() : Single<ImageResponse>
}