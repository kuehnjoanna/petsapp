package com.example.adoptapetapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.adoptapetapp.R
class InboxFragment : Fragment()  {
    private lateinit var binding: FragmentInboxBinding
    private val viewModel: WauWauViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInboxBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val data = Datasource.messages
        val itemClickedCallback: (Message) -> Unit = {
            viewModel.selectedMessageItem(it)
            findNavController().navigate(InboxFragmentDirections.actionInboxFragmentToMessageDetailFragment())
        }
        val adapter2 = MessageAdapter( viewModel.messages.value!!, itemClickedCallback)
        binding.inboxRV.adapter = adapter2


    }
}