package com.example.movies_search.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.movies_search.model.Base
import com.example.movies_search.model.Search
import com.example.movies_search.model.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {

    private val serviceSetterGetter = MutableLiveData<List<Search>>()

    fun getSearchApiCallList(apiKey: String, movie: String): MutableLiveData<List<Search>> {

        val call = RetrofitClient.apiInterface.getSearch(apiKey, movie)

        call?.enqueue(object: Callback<Base> {

            override fun onResponse(
                call: Call<Base?>,
                response: Response<Base?>
            ) {
                // TODO("Not yet implemented")
                Log.d("Dang", "Response: ${response.body().toString()}")

                val movies = response.body()!!.search

                serviceSetterGetter.value = movies
            }

            override fun onFailure(call: Call<Base?>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.e("Dang", "$t")
            }
        })

        return serviceSetterGetter
    }
}