package com.example.pokedex

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pokedex.models.MainViewModel
import androidx.lifecycle.Observer
import com.example.pokedex.models.Paginate
import com.example.pokedex.models.PokemonPreview
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var result: Paginate
    private var current = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupObservers()

        mainViewModel.fetch()

        val btnLeft = findViewById<Button>(R.id.button)
        btnLeft.setOnClickListener {
            if (current != 0) {
                current -= 1
                if (current < result.results.size - 1) {
                    val pokemon = result.results[current]
                    this.setValueInView(pokemon)
                }
            }
        }

        val btnRigth = findViewById<Button>(R.id.button2)
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
        val name = findViewById<TextView>(R.id.textView2)
        name.text = pokemon.name

        val img = findViewById<ImageView>(R.id.imageView)

        val imgUlr = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"

        Picasso.get()
            .load(imgUlr)
            .into(img)
    }
}