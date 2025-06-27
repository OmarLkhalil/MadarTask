package com.omarlkhalil.domain.usecase

import com.omarlkhalil.domain.entity.MadarUser
import com.omarlkhalil.domain.repo.UsersRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface DeleteUserUseCase {
    suspend operator fun invoke(user: MadarUser): Flow<Int>
}

internal class DeleteUserUseCaseImpl @Inject constructor(
    private val repo: UsersRepo
) : DeleteUserUseCase {
    override suspend fun invoke(user: MadarUser): Flow<Int> {
        return repo.deleteUser(user)
    }
}