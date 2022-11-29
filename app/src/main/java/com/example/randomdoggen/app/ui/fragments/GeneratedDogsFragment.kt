package com.example.randomdoggen.app.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.randomdoggen.MainApplication
import com.example.randomdoggen.app.adapter.GeneratedDogsAdapter
import com.example.randomdoggen.app.viewmodel.RandomDogViewModel
import com.example.randomdoggen.app.viewmodel.ViewModelFactory
import com.example.randomdoggen.databinding.FragmentGeneratedDogsBinding

class GeneratedDogsFragment : Fragment() {

    private var _binding: FragmentGeneratedDogsBinding? = null
    private val binding get() = _binding!!

    //Adapter
    private lateinit var myAdapter: GeneratedDogsAdapter

    //ViewModel
    private val randomDogViewModel: RandomDogViewModel by viewModels {
        ViewModelFactory((context?.applicationContext as MainApplication).randomDogRepo)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGeneratedDogsBinding.inflate(layoutInflater)
        myAdapter = GeneratedDogsAdapter()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvDogsCachedList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.rvDogsCachedList.adapter = myAdapter

        randomDogViewModel.readAllDogs.observe(viewLifecycleOwner) {
            Log.d("List Adapter", "List: $it")
            myAdapter.getDogs(it)
        }

        binding.tvClearDogs.setOnClickListener {
            randomDogViewModel.deleteAllDogs()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}