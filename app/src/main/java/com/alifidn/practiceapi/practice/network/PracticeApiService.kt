package com.alifidn.practiceapi.practice.network

import com.alifidn.practiceapi.practice.data.PracticeUserResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface PracticeApiService {
    @GET("users")
    fun getListPracticeUser() : Call<ArrayList<PracticeUserResponseItem>>
}