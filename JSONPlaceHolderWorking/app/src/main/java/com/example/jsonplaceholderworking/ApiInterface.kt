package com.example.jsonplaceholderworking

import com.example.jsonplaceholderworking.data.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    
    @GET("/users")
    suspend fun getUserData(): Response<List<User>>
}
