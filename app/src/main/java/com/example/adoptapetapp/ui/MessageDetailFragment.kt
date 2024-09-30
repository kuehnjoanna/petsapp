package com.example.adoptapetapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.adoptapetapp.R
import com.example.adoptapetapp.databinding.FragmentMessageDetailBinding


class MessageDetailFragment : Fragment()  {
    private lateinit var binding: FragmentMessageDetailBinding
    private val viewModel: WauWauViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMessageDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.selectedMessageItem.observe(viewLifecycleOwner) {
            binding.messagedetailHeadlineTV.text = it.title
            binding.content.text = it.content

            binding.deleteBTN.setOnClickListener {
                viewModel.removeMessageFromInbox()
                findNavController().navigate(R.id.inboxFragment)
            }


        }

    }}}