package com.example.jsonplaceholderworking.data.repo


import com.example.jsonplaceholderworking.ApiInterface
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UserRepository @Inject internal constructor(var apiHelper: ApiInterface) {
    suspend fun getUserData() = apiHelper.getUserData()
}