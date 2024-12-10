package com.example.part3.chapter5.mvp

interface MvpContractor {

    interface View {

        fun showImage(url: String, color: String)

        fun showImageCountText(count: Int)
    }

    interface Presenter {

        fun attachView(view: View)

        fun detachView()

        fun loadRandomImage()

    }
}