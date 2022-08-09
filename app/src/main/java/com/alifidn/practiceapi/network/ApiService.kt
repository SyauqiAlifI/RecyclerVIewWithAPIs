package com.alifidn.practiceapi.network

import com.alifidn.practiceapi.data.MainItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @GET("users")
    @Headers("authorization: token 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")
    fun getListUser() : Call<ArrayList<MainItem>>
}