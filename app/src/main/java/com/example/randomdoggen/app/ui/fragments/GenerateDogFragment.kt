package com.example.randomdoggen.app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import com.example.randomdoggen.MainApplication
import com.example.randomdoggen.app.viewmodel.ViewModelFactory
import com.example.randomdoggen.app.viewmodel.RandomDogViewModel
import com.example.randomdoggen.databinding.FragmentGenerateDogBinding

class GenerateDogFragment : Fragment() {

    //ViewModel
    private val randomDogViewModel: RandomDogViewModel by viewModels {
        ViewModelFactory(
            (context?.applicationContext as MainApplication).randomDogRepo
        )
    }

    private var _binding: FragmentGenerateDogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGenerateDogBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            tvGenerate.setOnClickListener {
                randomDogViewModel.generateRandomDog()
                randomDogViewModel.randomDog.observe(viewLifecycleOwner) {
                    //TODO: Add progress bar while image is being loaded.
                    ivImage.load(it.message)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}