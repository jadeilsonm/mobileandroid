package com.example.pokedex.models

data class Paginate(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<PokemonPreview>
)