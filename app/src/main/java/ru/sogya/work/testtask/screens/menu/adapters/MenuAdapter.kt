package ru.sogya.work.testtask.screens.menu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.sogya.work.testtask.R
import ru.sogya.work.testtask.app.App
import ru.sogya.work.testtask.domain.model.MenuItemDomain

class MenuAdapter : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {
    private val menuList = arrayListOf<MenuItemDomain>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImageView: ImageView = itemView.findViewById(R.id.itemImageVIew)
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descTextView)
        val addButton: TextView = itemView.findViewById(R.id.addButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.menu_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menuItem = menuList[position]
        holder.nameTextView.text = menuItem.name
        holder.descriptionTextView.text = menuItem.description
        holder.addButton.text = "от ${menuItem.cost} р."
        Glide.with(App.getAppContext())
            .load(menuItem.imageUri)
            .placeholder(R.color.white)
            .into(holder.itemImageView)
    }

    fun updateMenuList(newMenuList: List<MenuItemDomain>) {
        menuList.clear()
        notifyItemChanged(1)
        menuList.addAll(newMenuList)
        notifyItemRangeChanged(0, menuList.size)
    }
}