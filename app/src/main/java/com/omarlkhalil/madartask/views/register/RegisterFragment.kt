package com.omarlkhalil.madartask.views.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.omarlkhalil.domain.entity.MadarUser
import com.omarlkhalil.domain.utils.isValidName
import com.omarlkhalil.madartask.databinding.FragmentRegisterBinding
import com.omarlkhalil.presentation.viewmodel.UsersViewModel
import com.omarlkhalil.madartask.R
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
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDropdowns()
        setListeners()
        observeInsertUserResponse()
    }

    /** Set click listeners */
    private fun setListeners() {
        binding.btnSignUp.setOnClickListener {
            if (validateInputs()) {
                val user = MadarUser(
                    id = Random.nextInt(1, 1000),
                    name = binding.etName.fetchText(),
                    jobtitle = binding.etJobtitle.fetchText(),
                    age = binding.etAge.fetchText().toIntOrNull() ?: 0,
                    gender = binding.etGender.fetchText()
                )
                registerViewModel.insertUserToLocalDB(user)
            }
        }

        // Show dropdown on click
        (binding.etAge as? AutoCompleteTextView)?.setOnClickListener {
            (it as AutoCompleteTextView).showDropDown()
        }
        (binding.etGender as? AutoCompleteTextView)?.setOnClickListener {
            (it as AutoCompleteTextView).showDropDown()
        }
    }

    /** Setup dropdown adapters */
    private fun setupDropdowns() {
        val ageList = (18..60).map { it.toString() }
        val genderList = listOf("Male", "Female")

        val ageAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, ageList)
        val genderAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, genderList)

        (binding.etAge as? AutoCompleteTextView)?.setAdapter(ageAdapter)
        (binding.etGender as? AutoCompleteTextView)?.setAdapter(genderAdapter)
    }

    /** Validate all inputs */
    private fun validateInputs(): Boolean {
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


    /** Observe insert user response */
    private fun observeInsertUserResponse() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            registerViewModel.insertUserResponse.collect { result ->
                when {
                    result > 0 -> {
                        showToast("User registered successfully with ID: $result")
                        findNavController().navigate(R.id.displayAllUsersFragment)
                    }

                    result != -1L -> {
                        showToast("Failed to register user")
                    }
                }
                registerViewModel.resetInsertUserResponse()
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}


fun AppCompatEditText.fetchText(): String {
    return this.text.toString().trim()
}

fun AutoCompleteTextView.fetchText(): String {
    return this.text.toString().trim()
}