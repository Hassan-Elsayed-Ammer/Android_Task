package com.example.android_task.network

import com.example.android_task.model.ApiResponse
import com.example.android_task.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getUsersList(
        @Query("page") page:Int
    ): ApiResponse

}