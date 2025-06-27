package com.omarlkhalil.data.repo

import com.omarlkhalil.data.dao.UsersDao
import com.omarlkhalil.domain.entity.MadarUser
import com.omarlkhalil.domain.repo.UsersRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Repository for managing user data.
 *
 * This repository provides methods to insert, delete, and retrieve user information
 * from the local database using the UsersDao.
 *
 * @property usersDao The DAO for accessing user data in the local database.
 */
class UsersRepoImpl @Inject constructor(
    private val usersDao: UsersDao
) : UsersRepo {

    override suspend fun getUserById(userId: Int): Flow<MadarUser> {
        return flow {
            emit(usersDao.getUserById(userId))
        }
    }

    override suspend fun insertUser(user: MadarUser): Flow<Long> {
        return flow {
            emit(usersDao.insertUser(user))
        }
    }

    override suspend fun getAllUsers(): Flow<List<MadarUser>> {
        return flow {
            emit(usersDao.getAllUsers())
        }
    }

    override suspend fun deleteUser(user: MadarUser): Flow<Int> {
        return flow {
            emit(usersDao.deleteUser(user))
        }
    }

}