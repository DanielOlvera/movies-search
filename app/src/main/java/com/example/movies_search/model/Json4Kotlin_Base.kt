package com.example.movies_search.model

import com.google.gson.annotations.SerializedName

data class Json4Kotlin_Base (

	@SerializedName("Search") val search : List<Search>,
	@SerializedName("totalResults") val totalResults : Int,
	@SerializedName("Response") val response : Boolean
)