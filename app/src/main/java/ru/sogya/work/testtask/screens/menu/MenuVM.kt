package ru.sogya.work.testtask.screens.menu

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.sogya.work.testtask.domain.usecase.GetCategoryUseCase
import ru.sogya.work.testtask.domain.usecase.GetMenuUseCase
import javax.inject.Inject

@HiltViewModel
class MenuVM @Inject constructor(
    private val getCategoryUseCase: GetCategoryUseCase,
    private val getMenuUseCase: GetMenuUseCase
): ViewModel() {
    fun getMenuLiveData() = getMenuUseCase()

    fun getCategoryLiveData() = getCategoryUseCase()
}