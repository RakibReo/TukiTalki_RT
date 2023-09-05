package com.example.tukitakirt.ui.auth.registration
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tukitakirt.base.BaseFragment
import com.example.tukitakirt.data.register.RequestUserRegister
import com.example.tukitakirt.databinding.FragmentRegisterBinding
import com.example.tukitakirt.utils.DummyImgLink
import com.example.tukitakirt.utils.errorMessage
import com.example.tukitakirt.utils.successMessage
import dagger.hilt.android.AndroidEntryPoint

//cs-13

@AndroidEntryPoint

//cs-2-2
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private val viewModel: RegisterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.responseRegistration.observe(viewLifecycleOwner) {
            when (it) {
                successMessage -> {
                    Toast.makeText(requireContext(), successMessage, Toast.LENGTH_LONG)
                        .show()

                }
                errorMessage -> {
                    Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_LONG)
                        .show()
                }

                else -> {
                    Toast.makeText(requireContext(), it, Toast.LENGTH_LONG)
                        .show()
                }

            }


        }


        binding.registerButton.setOnClickListener {
            binding.apply {
                val name = nameEditText.text.toString()
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                val confirmPassword = confirmPasswordEditText.text.toString()

                val request = RequestUserRegister(
                    name = name,
                    email = email,
                    password = password,
                    createdAt = System.currentTimeMillis(),
                    image = DummyImgLink)
                viewModel.registration(request)

            }


        }

        binding.loginTextView.setOnClickListener {

            findNavController().popBackStack()


        }





        super.onViewCreated(view, savedInstanceState)
    }






}