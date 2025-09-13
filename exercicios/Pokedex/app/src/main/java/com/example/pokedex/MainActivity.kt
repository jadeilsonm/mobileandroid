package com.example.pokedex

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.pokedex.models.MainViewModel
import androidx.lifecycle.Observer
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.pokedex.models.Paginate
import com.example.pokedex.models.PokemonPreview
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var result: Paginate
    private var current = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservers()

        mainViewModel.fetch()

        val btnLeft = binding.button
        btnLeft.setOnClickListener {
            if (current != 0) {
                current -= 1
                if (current < result.results.size - 1) {
                    val pokemon = result.results[current]
                    this.setValueInView(pokemon)
                }
            }
        }

        val btnRigth = binding.button2
        btnRigth.setOnClickListener {
            if (current < result.results.size - 1) {
                current += 1
                val pokemon = result.results[current]
                this.setValueInView(pokemon)
            }
        }

    }

    private fun setupObservers() {
        mainViewModel.pokemon.observe(this, Observer { pokemons ->
            pokemons?.let {
                println("Pokemons recebidos na Activity: ${pokemons.count}")
                this.result = pokemons
                val pokemon = pokemons.results[current]
                this.setValueInView(pokemon)

                if (pokemons.count == 0) {
                    println("Not Found")
                }
            }
        })
    }

    private fun setValueInView(pokemon: PokemonPreview) {
        val id = pokemon.url.removeSuffix("/").split("/").last()
        val name = binding.textView2
        name.text = pokemon.name

        val img = binding.imageView

        val imgUlr = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"

        Picasso.get()
            .load(imgUlr)
            .into(img)

        img.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)

            intent.putExtra("NAME", pokemon.name)

            startActivity(intent)
        }
    }
}