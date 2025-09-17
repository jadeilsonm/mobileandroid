package com.example.fragment.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragment.R
import com.example.fragment.databinding.FragmentButtonBinding

private const val ARG_PARAM1 = "text"

/**
 * A simple [Fragment] subclass.
 * Use the [Button.newInstance] factory method to
 * create an instance of this fragment.
 */
class Button : Fragment() {

    private var _binding: FragmentButtonBinding? = null
    private val binding get() = _binding!!
    private var text: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = FragmentButtonBinding.bind(view)

        text = arguments?.getString(ARG_PARAM1) ?: "Button"
        binding.button2.text = text
        Log.i("FRAGMENT_BUTTON", "onViewCreated")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("FRAGMENT_BUTTON", "onCreateView")
        return inflater.inflate(R.layout.fragment_button, container, false)
    }

    override fun onStart() {
        super.onStart()
        Log.i("FRAGMENT_BUTTON", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("FRAGMENT_BUTTON", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("FRAGMENT_BUTTON", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("FRAGMENT_BUTTON", "onStop")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.i("FRAGMENT_BUTTON", "onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("FRAGMENT_BUTTON", "onDetach")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.i("FRAGMENT_BUTTON", "onDestroyView")
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment Button.
         */
        @JvmStatic
        fun newInstance(param1: String) =
            Button().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}