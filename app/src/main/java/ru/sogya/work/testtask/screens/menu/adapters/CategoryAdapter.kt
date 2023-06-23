package ru.sogya.work.testtask.screens.menu.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import ru.sogya.work.testtask.R
import ru.sogya.work.testtask.data.model.CategoryItemData
import ru.sogya.work.testtask.domain.model.CategoryItemDomain

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    private val categoryList = arrayListOf<CategoryItemDomain>(
        CategoryItemData(id = 0, title = "Пицца"),
        CategoryItemData(id = 0, title = "Пицца"),
        CategoryItemData(id = 0, title = "Пицца"),
        CategoryItemData(id = 0, title = "Пицца"),
        CategoryItemData(id = 0, title = "Пицца"),
        CategoryItemData(id = 0, title = "Пицца")
    )

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryButton: Button = itemView.findViewById(R.id.categoryButton)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categoryItem = categoryList[position]
        holder.apply {
            categoryButton.text = categoryItem.title
            if (position == 0){
                categoryButton.setBackgroundColor(Color.parseColor("#33FD3A69"))
                categoryButton.setTextColor(Color.parseColor("#FFFD3A69"))
            }

        }
    }
}