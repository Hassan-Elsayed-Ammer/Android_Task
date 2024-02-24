package com.example.android_task.repository


import com.example.android_task.network.ApiService
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: ApiService
) {
    suspend fun getUsersList(page: Int) = api.getUsersList(page)

}


