package ru.sogya.work.testtask.domain.usecase

import ru.sogya.work.testtask.domain.repository.FirebaseRepository

class GetMenuUseCase(private val firebaseRepository: FirebaseRepository) {
    operator fun invoke() = firebaseRepository.getMenu()
}