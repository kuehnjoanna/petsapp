package com.example.adoptapetapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.adoptapetapp.R
import com.example.adoptapetapp.WauWauViewModel
import com.example.adoptapetapp.databinding.FragmentPetSearchBinding

class PetSearchFragment : Fragment()  {
    private lateinit var binding: FragmentPetSearchBinding
    private val viewModel: WauWauViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPetSearchBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = Datasource.data
        val itemClickedCallback: (Pet) -> Unit  = {
            viewModel.selectedPetItem(it)

            findNavController().navigate(PetSearchFragmentDirections.actionPetSearchFragmentToDogProfileFragment())
        }

        viewModel.pets.observe(viewLifecycleOwner) {
            val adapter = PetAdapter(viewModel.pets.value!!, itemClickedCallback)
            binding.petsRV.adapter = adapter

            binding.maleSearch.setOnClickListener {
                viewModel.filterPets("m")
                binding.femaleSearch.isChecked = false
                binding.maleSearch.setOnClickListener {
                    binding.maleSearch.isChecked = false
                    viewModel.resetFilter()
                }

            }

            binding.femaleSearch.setOnClickListener {
                viewModel.filterPets("f")
                binding.maleSearch.isChecked = false
                binding.femaleSearch.setOnClickListener {
                    binding.femaleSearch.isChecked = false
                    viewModel.resetFilter()
                }
            }

            binding.puppySearch.setOnClickListener {
                viewModel.filterPetsAge(1)
                binding.adultSearch.isChecked = false
                binding.seniorSearch.isChecked = false
                binding.puppySearch.setOnClickListener{
                    binding.puppySearch.isChecked = false
                    viewModel.resetFilter()
                }
            }
            binding.adultSearch.setOnClickListener {
                viewModel.filterAdultsPetsAge()

                binding.puppySearch.isChecked = false
                binding.seniorSearch.isChecked = false
                binding.adultSearch.setOnClickListener{
                    binding.adultSearch.setOnClickListener {
                        viewModel.resetFilter()
                        binding.adultSearch.isChecked = false
                    }

                }
            }
            binding.seniorSearch.setOnClickListener {
                viewModel.filterSeniorPetsAge()
                binding.puppySearch.isChecked = false
                binding.adultSearch.isChecked = false
                binding.seniorSearch.setOnClickListener {
                    binding.seniorSearch.isChecked = false
                    viewModel.resetFilter()
                }
            }
        }
    }

}