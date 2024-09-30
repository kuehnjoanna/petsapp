package com.example.adoptapetapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.adoptapetapp.R
import com.example.adoptapetapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    //for homescreen
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: WauWauViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.infoBox.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToPetSearchFragment())
        }


    }
}