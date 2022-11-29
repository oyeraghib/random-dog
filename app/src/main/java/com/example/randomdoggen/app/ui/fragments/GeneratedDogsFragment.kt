package com.example.randomdoggen.app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.randomdoggen.app.adapter.GeneratedDogsAdapter
import com.example.randomdoggen.databinding.FragmentGeneratedDogsBinding

class GeneratedDogsFragment : Fragment() {

    private var _binding: FragmentGeneratedDogsBinding? = null
    private val binding get() = _binding!!

    //Adapter
    private lateinit var myAdapter: GeneratedDogsAdapter

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

        binding.rvDogsCachedList.adapter = myAdapter

        //Retrieving
        val list = mutableListOf<String>()
        list.add("https://images.dog.ceo/breeds/affenpinscher/n02110627_3286.jpg")
        list.add("https://images.dog.ceo/breeds/mastiff-english/2.jpg")
        myAdapter.getDogs(list)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}