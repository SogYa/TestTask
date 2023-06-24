package ru.sogya.work.testtask.screens.menu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ru.sogya.work.testtask.R

class HintsAdapter : RecyclerView.Adapter<HintsAdapter.ViewHolder>() {
    private val hintsList = arrayListOf(
        R.drawable.hint_one,
        R.drawable.hint_two,
        R.drawable.hint_three
    )

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hintImageView: ImageView = itemView.findViewById(R.id.hintImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.hint_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hintsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hintItem = hintsList[position]
        holder.apply {
            hintImageView.setImageResource(hintItem)
        }
    }
}