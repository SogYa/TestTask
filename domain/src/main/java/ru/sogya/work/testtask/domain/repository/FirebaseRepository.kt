package ru.sogya.work.testtask.domain.repository

import androidx.lifecycle.LiveData
import ru.sogya.work.testtask.domain.model.CategoryItemDomain
import ru.sogya.work.testtask.domain.model.MenuItemDomain

interface FirebaseRepository {
    fun getCategory(): LiveData<List<CategoryItemDomain>>

    fun getMenu(): LiveData<List<MenuItemDomain>>
}