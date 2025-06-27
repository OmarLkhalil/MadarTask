package com.omarlkhalil.madartask.views.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.omarlkhalil.domain.entity.MadarUser
import com.omarlkhalil.domain.utils.isValidEmailAddress
import com.omarlkhalil.domain.utils.isValidName
import com.omarlkhalil.madartask.databinding.FragmentRegisterBinding
import com.omarlkhalil.presentation.viewmodel.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random


@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private val registerViewModel by viewModels<UsersViewModel>()
    private lateinit var binding: FragmentRegisterBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnCreateAccountClick()
        insertUserListener()
    }

    private fun setOnCreateAccountClick() {
        binding.btnSignUp.setOnClickListener {
            if (validateUser()) {
                registerViewModel.insertUserToLocalDB(
                    MadarUser(
                        id = Random(999).nextInt(),
                        name = binding.etName.fetchText(),
                        jobtitle = binding.etJobtitle.fetchText(),
                        age = binding.etAge.fetchText().toIntOrNull() ?: 0,
                        gender = binding.etGender.fetchText()
                    )
                )
            }
        }
    }

    private fun validateUser(): Boolean {
        val name = binding.etName.fetchText()
        val jobTitle = binding.etJobtitle.fetchText()
        val age = binding.etAge.fetchText()
        val gender = binding.etGender.fetchText()

        if (!name.isValidName()) {
            binding.etName.error = "Name is required"
            return false
        }
        if (age.isEmpty()) {
            binding.etAge.error = "Age is required"
            return false
        }

        if (jobTitle.isEmpty()) {
            binding.etJobtitle.error = "Job title is required"
            return false
        }
        if (gender.isEmpty()) {
            binding.etGender.error = "Gender is required"
            return false
        }

        return true
    }


    private fun insertUserListener(){
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            registerViewModel.insertUserResponse.collect { result ->
                if (result > 0) {
                    Toast.makeText(
                        requireContext(),
                        "User registered successfully with ID: $result",
                        Toast.LENGTH_SHORT
                    ).show()
                    registerViewModel.resetInsertUserResponse()
                } else if (result.toInt() != -1) {
                    Toast.makeText(
                        requireContext(),
                        "Failed to register user",
                        Toast.LENGTH_SHORT
                    ).show()
                    registerViewModel.resetInsertUserResponse()
                }
            }
        }
    }

}

fun AppCompatEditText.fetchText(): String {
    return this.text.toString().trim()
}