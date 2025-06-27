package com.omarlkhalil.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omarlkhalil.domain.entity.MadarUser
import com.omarlkhalil.domain.usecase.DeleteUserUseCase
import com.omarlkhalil.domain.usecase.InsertUserUseCase
import com.omarlkhalil.domain.usecase.RetriveAllUsersUseCase
import com.omarlkhalil.domain.usecase.RetriveUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UsersViewModel @Inject constructor(
    private val retrieveUsersUseCase: RetriveUsersUseCase,
    private val retrieveAllUsersUseCase: RetriveAllUsersUseCase,
    private val insertUserUseCase: InsertUserUseCase,
    private val deleteUserUseCase: DeleteUserUseCase
) : ViewModel() {

    private val _retrieveUserFromResponse = MutableStateFlow<MadarUser>(MadarUser(id = 0))
    val retrieveUserFromResponse: StateFlow<MadarUser> = _retrieveUserFromResponse.asStateFlow()

    fun retrieveUserFromLocalDB(userId: Int) {
        launchUsersCoroutinesScope {
            retrieveUsersUseCase.invoke(userId).collect {
                _retrieveUserFromResponse.emit(it)
            }
        }
    }

    private val _retrieveAllUsersFromResponse = MutableStateFlow<List<MadarUser>>(emptyList())
    val retrieveAllUsersFromResponse: StateFlow<List<MadarUser>> = _retrieveAllUsersFromResponse.asStateFlow()

    fun retrieveAllUsersFromLocalDB() {
        launchUsersCoroutinesScope {
            retrieveAllUsersUseCase.invoke().collect{
                _retrieveAllUsersFromResponse.emit(it)
            }
        }
    }

    private val _insertUserResponse = MutableStateFlow<Long>(-1)
    val insertUserResponse: StateFlow<Long> = _insertUserResponse.asStateFlow()

    fun insertUserToLocalDB(user: MadarUser) {
        launchUsersCoroutinesScope {
            insertUserUseCase.invoke(user).collect {
                _insertUserResponse.emit(it)
            }
        }
    }


    private val _deleteUserResponse = MutableStateFlow<Int>(0)
    val deleteUserResponse: StateFlow<Int> = _deleteUserResponse.asStateFlow()

    fun deleteUserFromLocalDB(user: MadarUser) {
        launchUsersCoroutinesScope {
            deleteUserUseCase.invoke(user).collect {
                _deleteUserResponse.emit(it)
            }
        }
    }

    fun resetInsertUserResponse() {
        _insertUserResponse.value = -1
    }


    private fun launchUsersCoroutinesScope(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                block()
            } catch (throwable: Throwable) {
                Log.e("USERS_VIEWMODEL_DEFAULT", throwable.message.orEmpty())
            }
        }
    }
}