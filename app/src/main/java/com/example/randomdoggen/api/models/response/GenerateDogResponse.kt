package com.example.randomdoggen.api.models.response


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GenerateDogResponse(
    @Json(name = "message")
    val message: String?,
    @Json(name = "status")
    val status: String?
)