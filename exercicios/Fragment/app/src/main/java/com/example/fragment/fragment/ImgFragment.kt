package com.example.fragment.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragment.R
import com.example.fragment.databinding.FragmentImgBinding
import com.squareup.picasso.Picasso

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [ImgFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ImgFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentImgBinding? = null
    private val binding get() = _binding!!
    private var param1: String? = null

    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = FragmentImgBinding.bind(view)

        param1 = arguments?.getString(ARG_PARAM1)
        val img = binding.imageView
        img.contentDescription = "imagem"

        if (param1 != null) {
            Log.i("Arg", param1 ?: "null")
            Picasso
                .get()
                .load("https://gratisography.com/wp-content/uploads/2024/11/gratisography-augmented-reality-1170x780.jpg")
                .into(img)
        }
        Log.i("FRAGMENT_IMG", "onViewCreated")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("FRAGMENT_IMG", "onCreateView")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_img, container, false)
    }

    override fun onStart() {
        super.onStart()
        Log.i("FRAGMENT_IMG", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("FRAGMENT_IMG", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("FRAGMENT_IMG", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("FRAGMENT_IMG", "onStop")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.i("FRAGMENT_IMG", "onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("FRAGMENT_IMG", "onDetach")
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.i("FRAGMENT_IMG", "onDestroyView")
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment ImgFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            ImgFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}