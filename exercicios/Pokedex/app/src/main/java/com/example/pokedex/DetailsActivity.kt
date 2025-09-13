package com.example.pokedex

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.pokedex.databinding.ActivityDetailsBinding
import com.example.pokedex.models.DetailsViewModel
import com.example.pokedex.models.Pokemon
import com.squareup.picasso.Picasso
import kotlin.getValue

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    private val detailsViewModel: DetailsViewModel by viewModels()
    private lateinit var namePokemon: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        namePokemon = intent.getStringExtra("NAME").toString()

        val title = binding.textView3
        title.text = namePokemon

        setupObservers()

        detailsViewModel.fetch(namePokemon)
    }

    private fun setupObservers() {
        detailsViewModel.pokemon.observe(this, Observer { pokemon ->
            pokemon?.let {
                println("Pokemon recebido na Activity")
                this.setValueInView(pokemon)
            }
        })
    }

    private fun setValueInView(pokemon: Pokemon) {
        val id = pokemon.id
        val name = binding.textView3
        name.text = pokemon.name.uppercase()

        val img = binding.imageView2

        val imgUlr =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"

        Picasso.get()
            .load(imgUlr)
            .into(img)

        val hp = binding.progressBar
        val attack = binding.progressBar2
        val df = binding.progressBar3
        val sAttack = binding.progressBar4
        val sDf = binding.progressBar5

        pokemon.stats.forEach { stat ->
            when (stat.stat.name) {
                "hp" -> hp.progress = stat.base_stat
                "attack" -> attack.progress = stat.base_stat
                "defense" -> df.progress = stat.base_stat
                "special-attack" -> sAttack.progress = stat.base_stat
                "special-defense" -> sDf.progress = stat.base_stat
                else -> null
            }
        }
    }
}