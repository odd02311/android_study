package com.example.part3.chapter5.mvvm.repository

import com.example.part3.chapter5.mvc.service.RetrofitManager
import com.example.part3.chapter5.mvvm.model.Image
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ImageRepositoryImpl: ImageRepository  {


    override fun getRandomImage() = RetrofitManager.imageService.getRandomImageRX()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .flatMap { item ->
            Single.just(Image(item.urls.regular, item.color))
        }


}