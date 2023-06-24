package ru.sogya.work.testtask.data.repository.firebase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase
import ru.sogya.work.testtask.data.model.CategoryItemData
import ru.sogya.work.testtask.data.model.MenuItemData
import ru.sogya.work.testtask.domain.model.CategoryItemDomain
import ru.sogya.work.testtask.domain.model.MenuItemDomain
import ru.sogya.work.testtask.domain.repository.FirebaseRepository
import ru.sogya.work.testtask.domain.utils.Constants

class FirebaseRepositoryImpl : FirebaseRepository {
    private val firestoreDB = Firebase.firestore
    private val categoryLiveData = MutableLiveData<List<CategoryItemDomain>>()
    private val menuLiveData = MutableLiveData<List<MenuItemDomain>>()

    override fun getCategory(): LiveData<List<CategoryItemDomain>> {
        firestoreDB.collection(Constants.FIRESTORE_CATEGORY).orderBy("id", Query.Direction.ASCENDING).get()
            .addOnSuccessListener { documents->
                val categoryItemList = arrayListOf<CategoryItemDomain>()
//                val categoryItem = categorySnapshot?.documents?.map {
//                    CategoryItemData(
//                        0,
//                        it["title"] as String
//                    )
//                }
//                categoryItem?.let { categoryLiveData.postValue(categoryItem) }
                for(document in documents){
                    val categoryItemData = document.toObject<CategoryItemData>()
                    categoryItemList.add(categoryItemData)
                }
                categoryLiveData.postValue(categoryItemList.toList())
            }
        return getCategoryLiveData()
    }

    override fun getMenu(): LiveData<List<MenuItemDomain>> {
        val menuItemList = arrayListOf<MenuItemDomain>()
        firestoreDB.collection(Constants.FIRESTORE_MENU)
            .get()
            .addOnSuccessListener {documents ->
//                val menuItem = menuSnapshot?.documents?.map {
//                    MenuItemData(
//                        it["name"] as String,
//                        it["description"] as String,
//                        it["cost"] as Int,
//                        it["imageUri"] as String
//                    )
//                }
//                menuItem?.let { menuLiveData.postValue(menuItem) }
                for(document in documents){
                    val menuItemData = document.toObject<MenuItemData>()
                    menuItemList.add(menuItemData)
                }
                menuLiveData.postValue(menuItemList.toList())
            }

        return getMenuLiveData()
    }

    private fun getMenuLiveData(): LiveData<List<MenuItemDomain>> = menuLiveData
    private fun getCategoryLiveData(): LiveData<List<CategoryItemDomain>> = categoryLiveData
}