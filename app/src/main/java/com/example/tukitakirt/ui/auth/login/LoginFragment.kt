package com.example.tukitakirt.ui.auth.login
import RequestUserLogin
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tukitakirt.R
import com.example.tukitakirt.base.BaseFragment
import com.example.tukitakirt.databinding.FragmentLoginBinding
import com.example.tukitakirt.utils.ErrorMessage
import com.example.tukitakirt.utils.SuccessMessage
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

//cs-2-1
@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {


    //CS-18

    private  val viewModel: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //CS-30 for save the login data

        val user = FirebaseAuth.getInstance().currentUser
        user?.let {
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        viewModel.responseLogin.observe(viewLifecycleOwner) {
            when (it) {
                SuccessMessage -> {
                    Toast.makeText(requireContext(), SuccessMessage, Toast.LENGTH_LONG)
                        .show()

                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)

                }

                ErrorMessage -> {
                    Toast.makeText(requireContext(), ErrorMessage, Toast.LENGTH_LONG)
                        .show()
                }

                else -> {
                    Toast.makeText(requireContext(), it, Toast.LENGTH_LONG)
                        .show()
                }

            }


        }

//cs-19-1
        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()

            login(email, password)


        }

//cs-19-2
        binding.registerTextView.setOnClickListener {

            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)


        }


    }

    private fun login(email: String, password: String) {


        val request = RequestUserLogin(email = email, password = password)
        viewModel.login(request)


    }


}