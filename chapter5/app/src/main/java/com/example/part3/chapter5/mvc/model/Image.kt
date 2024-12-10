package com.example.part3.chapter5

data class ImageResponse(
    val id: String,
    val urls: UrlResponse,
    val color: String,
)

data class UrlResponse(
    val raw : String, // 원본 이미지
    val full: String,
    val regular : String,
    val small: String,
    val thumb : String,
)