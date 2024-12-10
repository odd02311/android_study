package com.example.part3.chapter5.mvp.repository

interface ImageRepository {

    fun getRandomImage(callback: Callback)

    interface Callback {
        fun loadImage(url: String, color:String)
    }
}