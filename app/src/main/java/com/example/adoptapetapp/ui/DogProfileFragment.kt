package com.example.adoptapetapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.adoptapetapp.R
import com.example.adoptapetapp.databinding.FragmentDogProfileBinding

class DogProfileFragment : Fragment() {

    private lateinit var binding: FragmentDogProfileBinding
    private val viewModel: WauWauViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDogProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nameTV = binding.nameTV.text.toString()

        viewModel.selectedPetItem.observe(viewLifecycleOwner) {
            binding.dogPhotoIV.setImageResource(it.picture)
            binding.dogAgeTV.text = it.age.toString()
            binding.dogGenderTV.text = it.gender
            binding.nameTV.text = it.name
            binding.dogDescriptionTV.text = it.description

            val nameTV = it.name
            binding.writeMessageBTN.setOnClickListener {
                findNavController().navigate(
                    DogProfileFragmentDirections.actionDogProfileFragmentToMessageFragment(
                        nameTV
                    )
                )
            }
            binding.favAddBTN.setOnClickListener {
                if (!viewModel.favorites.value!!.contains(viewModel.selectedPetItem.value) && !viewModel.selectedPetItem.value!!.isClicked) {
                    viewModel.addPetToFav()
                    binding.favAddBTN.isSelected = true
                    viewModel.selectedPetItem.value!!.isClicked = true
                } else if (viewModel.favorites.value!!.contains(viewModel.selectedPetItem.value) && viewModel.selectedPetItem.value!!.isClicked) {
                    viewModel.selectedPetItem.value!!.isClicked = false
                    viewModel.removePetFromFav()
                    binding.favAddBTN.isSelected = false
                }
            }

            if (viewModel.selectedPetItem.value!!.isClicked) {
                binding.favAddBTN.isSelected = true
            }

            binding.shareProfileBTN.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                val chooser = Intent.createChooser(intent, null)
                startActivity(chooser)
            }
        }


    }
}