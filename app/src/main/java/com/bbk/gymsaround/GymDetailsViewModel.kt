package com.bbk.gymsaround

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GymDetailsViewModel(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    val state = mutableStateOf<Gym?>(null)
    var networkAvailable by mutableStateOf(true)
    private var apiService: GymsApiService

    private val errorHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
        networkAvailable = false
    }

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://cairo-gyms-b75ca-default-rtdb.firebaseio.com/")
            .build()

        apiService = retrofit.create(GymsApiService::class.java)

        val gymId = savedStateHandle.get<Int>("gym_id") ?: 0
        getGym(gymId)
    }

    private fun getGym(id: Int) {
        viewModelScope.launch(errorHandler) {
            val gym = getGymFromRemoteDB(id)
            state.value = gym
        }
    }

    private suspend fun getGymFromRemoteDB(id: Int) = withContext(Dispatchers.IO) {
        apiService.getGym(id).values.first()
    }
}