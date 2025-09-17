package com.example.fragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.fragment.databinding.ActivityMainBinding
import com.example.fragment.fragment.Button
import com.example.fragment.fragment.ImgFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val btn1 = binding.button
        val btn2 = binding.button3
        val btn3 = binding.button4

        btn1.setOnClickListener {
            setOnFragment(Button(), "Voltar", "text")
        }
        btn2.setOnClickListener {
            setOnFragment(ImgFragment(), "https://gratisography.com/wp-content/uploads/2024/11/gratisography-augmented-reality-1170x780.jpg", "param1")
        }
        btn3.setOnClickListener {
            setOnFragment(Button(), "Limpar", "text")
        }
    }

    private fun setOnFragment(fragment : Fragment, arg: String? = null, argName: String? = null) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        if (arg != null && argName != null) {
            val bundle = bundleOf(argName to arg)
            fragment.arguments = bundle
        }
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}