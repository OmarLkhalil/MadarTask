package com.omarlkhalil.domain.di

import com.omarlkhalil.domain.usecase.DeleteUserUseCase
import com.omarlkhalil.domain.usecase.DeleteUserUseCaseImpl
import com.omarlkhalil.domain.usecase.InsertUserUseCase
import com.omarlkhalil.domain.usecase.InsertUserUseCaseImpl
import com.omarlkhalil.domain.usecase.RetriveAllUsersUseCase
import com.omarlkhalil.domain.usecase.RetriveAllUsersUseCaseImpl
import com.omarlkhalil.domain.usecase.RetriveUsersUseCase
import com.omarlkhalil.domain.usecase.RetriveUsersUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    @ViewModelScoped
    internal fun provideInsertUserUseCase(
        impl: InsertUserUseCaseImpl
    ): InsertUserUseCase = impl


    @Provides
    @ViewModelScoped
    internal fun provideRetrieveUserUseCase(
        impl: RetriveUsersUseCaseImpl
    ): RetriveUsersUseCase = impl


    @Provides
    @ViewModelScoped
    internal fun provideRetrieveAllUserUseCase(
        impl: RetriveAllUsersUseCaseImpl
    ): RetriveAllUsersUseCase = impl


    @Provides
    @ViewModelScoped
    internal fun provideDeleteUserUseCase(
        impl: DeleteUserUseCaseImpl
    ): DeleteUserUseCase = impl


}