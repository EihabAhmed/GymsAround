package com.bbk.gymsaround

import retrofit2.Call
import retrofit2.http.GET

interface GymsApiService {
    @GET("gyms.json")
    fun getGyms(): Call<List<Gym>>
}