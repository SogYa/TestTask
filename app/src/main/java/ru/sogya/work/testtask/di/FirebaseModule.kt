package ru.sogya.work.testtask.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.sogya.work.testtask.domain.repository.FirebaseRepository
import ru.sogya.work.testtask.domain.usecase.GetCategoryUseCase
import ru.sogya.work.testtask.domain.usecase.GetMenuUseCase

@Module
@InstallIn(ViewModelComponent::class)
class FirebaseModule {

    @Provides
    fun provideGetCategoryUseCase(firebaseRepository: FirebaseRepository) =
        GetCategoryUseCase(firebaseRepository)

    @Provides
    fun provideGetMenuUseCase(firebaseRepository: FirebaseRepository) =
        GetMenuUseCase(firebaseRepository)
}