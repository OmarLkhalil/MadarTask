package com.omarlkhalil.domain.repo

import com.omarlkhalil.domain.entity.MadarUser
import kotlinx.coroutines.flow.Flow

interface UsersRepo {
    suspend fun getUserById(userId: Int): Flow<MadarUser>

    suspend fun insertUser(user: MadarUser): Flow<Long >

    suspend fun getAllUsers(): Flow<List<MadarUser>>

    suspend fun deleteUser(user: MadarUser): Flow<Int >
}