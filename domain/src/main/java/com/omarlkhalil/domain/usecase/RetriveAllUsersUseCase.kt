package com.omarlkhalil.domain.usecase

import com.omarlkhalil.domain.entity.MadarUser
import com.omarlkhalil.domain.repo.UsersRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface RetriveAllUsersUseCase {
    suspend operator fun invoke(): Flow<List<MadarUser>>
}

class RetriveAllUsersUseCaseImpl @Inject constructor(private val repo: UsersRepo) :
    RetriveAllUsersUseCase {
    override suspend fun invoke(): Flow<List<MadarUser>> {
        return repo.getAllUsers()
    }
}