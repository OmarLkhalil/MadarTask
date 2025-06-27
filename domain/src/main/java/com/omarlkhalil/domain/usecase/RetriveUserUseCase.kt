package com.omarlkhalil.domain.usecase

import com.omarlkhalil.domain.entity.MadarUser
import com.omarlkhalil.domain.repo.UsersRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface RetriveUsersUseCase {
    suspend operator fun invoke(userId: Int): Flow<MadarUser>
}

class RetriveUsersUseCaseImpl @Inject constructor(private val repo: UsersRepo) :
    RetriveUsersUseCase {
    override suspend fun invoke(userId: Int): Flow<MadarUser> {
        return repo.getUserById(userId)
    }
}