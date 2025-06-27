package com.omarlkhalil.domain.usecase

import com.omarlkhalil.domain.entity.MadarUser
import com.omarlkhalil.domain.repo.UsersRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface InsertUserUseCase {
    suspend operator fun invoke(user: MadarUser): Flow<Long>
}


internal class InsertUserUseCaseImpl @Inject constructor(
    private val repo: UsersRepo
) : InsertUserUseCase {
    override suspend fun invoke(user: MadarUser): Flow<Long> {
        return repo.insertUser(user)
    }
}