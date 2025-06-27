package com.omarlkhalil.madartask.views.display_users

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.omarlkhalil.presentation.viewmodel.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue


@AndroidEntryPoint
class DisplayAllUsersFragment : Fragment() {

    private val displayViewModel by viewModels<UsersViewModel>()


}