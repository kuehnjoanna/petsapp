package com.example.adoptapetapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.adoptapetapp.R
import com.example.adoptapetapp.WauWauViewModel

class FavoritesFragment<FragmentFavoritesBinding> : Fragment() {

    private lateinit var binding: FragmentFavoritesBinding
    private val viewModel: WauWauViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavoritesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = Datasource.favorites

        val itemClickedCallback: (Pet) -> Unit  = {
            viewModel.selectedPetItem(it)

            findNavController().navigate(FavoritesFragmentDirections.actionFavoritesFragment2ToDogProfileFragment())
        }
        val adapter = PetAdapter(viewModel.favorites.value!!, itemClickedCallback)
        binding.favPetsRV.adapter = adapter

    }

}