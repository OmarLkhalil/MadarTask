package com.omarlkhalil.madartask.views.display_users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.omarlkhalil.madartask.databinding.FragmentDisplayAllUsersBinding
import com.omarlkhalil.presentation.viewmodel.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class DisplayAllUsersFragment : Fragment() {

    private val displayViewModel by viewModels<UsersViewModel>()
    private lateinit var binding: FragmentDisplayAllUsersBinding
    private lateinit var usersAdapter: ItemUsersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDisplayAllUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeUsers()
        displayViewModel.retrieveAllUsersFromLocalDB()
    }

    private fun setupRecyclerView() {
        usersAdapter = ItemUsersAdapter()
        binding.rvUsers.apply {
            adapter = usersAdapter
        }
    }

    private fun observeUsers() {
        lifecycleScope.launchWhenStarted {
            displayViewModel.retrieveAllUsersFromResponse.collect { users ->
                if (users.isEmpty()) {
                    binding.tvEmptyState.visibility = View.VISIBLE
                    binding.rvUsers.visibility = View.GONE
                } else {
                    binding.tvEmptyState.visibility = View.GONE
                    binding.rvUsers.visibility = View.VISIBLE
                    usersAdapter.submitList(users)
                }
            }
        }
    }
}
