package com.omarlkhalil.data.di

import android.content.Context
import androidx.room.Room
import com.omarlkhalil.data.dao.UsersDao
import com.omarlkhalil.data.datasource.local.UsersDatabase
import com.omarlkhalil.data.repo.UsersRepoImpl
import com.omarlkhalil.domain.repo.UsersRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): UsersDatabase {
        return Room.databaseBuilder(context, UsersDatabase::class.java, "users_database")
            .fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideUsersDao(database: UsersDatabase): UsersDao = database.usersDao()

}