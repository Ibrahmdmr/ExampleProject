package com.example.jsonplaceholderworking.data.repo

import com.example.jsonplaceholderworking.ApiInterface
import com.example.jsonplaceholderworking.di.AppModule

class ApiHelper(var apiInterface: ApiInterface) {
    suspend fun getUserData() = apiInterface.getUserData()
}