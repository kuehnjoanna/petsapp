package com.example.adoptapetapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.adoptapetapp.databinding.FragmentLoginStartBinding

class LoginStartFragment : Fragment() {
    private lateinit var binding: FragmentLoginStartBinding

    private val viewModel: WauWauViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginStartBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginBTN.setOnClickListener {
            if (!binding.emailET.text.isNullOrEmpty() && !binding.loginBTN.text.isNullOrEmpty() && binding.emailET.text.contains("@")&&binding.emailET.text.contains(".")) {

                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
            }else{
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("All of the fields must be filled")

                builder.setPositiveButton("ok") { _, _ ->


                }


                builder.show()
            }
        }
    }
    /* shicken an google etc
        binding.shareProfileBTN.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val chooser = Intent.createChooser(intent, null)
            startActivity(chooser)
        }

     */
}