package com.bbk.gymsaround

import retrofit2.http.GET

interface GymsApiService {
    @GET("gyms.json")
    suspend fun getGyms(): List<Gym>
}