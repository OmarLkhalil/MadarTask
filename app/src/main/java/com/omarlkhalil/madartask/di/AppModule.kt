package com.omarlkhalil.madartask.di

import com.omarlkhalil.data.dao.UsersDao
import com.omarlkhalil.data.repo.UsersRepoImpl
import com.omarlkhalil.domain.repo.UsersRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideUserRepo(usersDao: UsersDao): UsersRepo {
        return UsersRepoImpl(usersDao)
    }
}