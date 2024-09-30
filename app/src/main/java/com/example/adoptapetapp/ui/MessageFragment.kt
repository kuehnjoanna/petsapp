package com.example.adoptapetapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.adoptapetapp.R
import com.example.adoptapetapp.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {
    private lateinit var binding: FragmentMessageBinding
    val args: MessageFragmentArgs by navArgs()
    private val viewModel: WauWauViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMessageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.nameOfTheDogTV.text = args.nameTV
        binding.sendFormBTN.setOnClickListener {
            val yourName = binding.nameET.text.toString()

            val content =
                "Form sent:\n name of the dog: ${args.nameTV} \n Your name: ${yourName}\n Adress: ${binding.addressET.text.toString()}\n Why are you interested in this dog?: ${binding.whyET.editableText.toString()}\n Garden?: ${binding.gardenET.text}\n Children?: ${binding.childrenET.text} \n Other animals?: ${binding.otherAnimalsET.text}"

            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Bitte Bestätigen")

            builder.setPositiveButton("Ja") { _, _ ->
                Toast.makeText(
                    context,
                    "Form sent, you can find it in your Inbox",
                    Toast.LENGTH_SHORT
                ).show()
                viewModel.messages.observe(viewLifecycleOwner) {
                    viewModel.addMessageToInbox(Message(args.nameTV, content))
                }

            }

            builder.setNegativeButton("Nein") { _, _ ->

            }

            builder.show()
        }

    }


}