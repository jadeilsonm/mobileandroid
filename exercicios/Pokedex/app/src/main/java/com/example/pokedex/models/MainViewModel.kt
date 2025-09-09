package com.example.pokedex.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.services.APICliente
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _pokemon = MutableLiveData<Paginate>()

    val pokemon: LiveData<Paginate> = _pokemon

    fun fetch() {
        viewModelScope.launch {
            try {
                val response = APICliente.instance.getPokemons()
                if (response.isSuccessful) {
                    _pokemon.value = response.body()
                } else {
                    print("Error in request")
                }
            } catch (e: Exception) {
                println("Request failed: ${e.message}")
            }
        }
    }
}