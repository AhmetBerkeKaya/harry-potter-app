package com.ahmetberkekekaya.harrypotterapp.data.remote

import com.ahmetberkekekaya.harrypotterapp.data.model.Character
import retrofit2.http.GET

interface ApiService {
    @GET("api/characters")
    suspend fun getCharacters(): List<Character>
}
