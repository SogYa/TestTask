package ru.sogya.work.testtask.data.model

import ru.sogya.work.testtask.domain.model.MenuItemDomain

data class MenuItemData(
    override val name: String,
    override val description: String,
    override val cost: Int,
    override val imageUri: String,
): MenuItemDomain{
    constructor():this("","",0,"")
}