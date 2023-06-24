package ru.sogya.work.testtask.data.model

import ru.sogya.work.testtask.domain.model.CategoryItemDomain

data class CategoryItemData(
    override val id: Int,
    override val title: String
) : CategoryItemDomain{
    constructor():this(0,"")
}
