package com.example.part3.chapter5.mvvm.repository

import com.example.part3.chapter5.mvvm.model.Image
import io.reactivex.Single

interface ImageRepository {

    fun getRandomImage() : Single<Image>
}