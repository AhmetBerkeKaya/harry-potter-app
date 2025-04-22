package com.ahmetberkekekaya.harrypotterapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmetberkekekaya.harrypotterapp.data.model.Character
import com.ahmetberkekekaya.harrypotterapp.data.remote.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters: StateFlow<List<Character>> = _characters

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            try {
                val response = ApiClient.apiService.getCharacters()
                _characters.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Bir hata oluştu: ${e.localizedMessage}"
            }
        }
    }
}

