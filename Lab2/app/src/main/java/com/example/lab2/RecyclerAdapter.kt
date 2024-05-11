package com.example.lab2

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(
    private val shoppingListItems: MutableList<Product>
) : RecyclerView.Adapter<RecyclerAdapter.ShoppingListItemViewHolder>() {

    class ShoppingListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingListItemViewHolder {
        return ShoppingListItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_products,
                parent,
                false
            )
        )
    }

    fun setIngredients(ingredients: ArrayList<Product>) {
        shoppingListItems.removeAll { true }
        shoppingListItems.addAll(ingredients)
    }
    fun addTodo(shoppingListItem: Product) {
        shoppingListItems.add(shoppingListItem)
        notifyItemInserted(shoppingListItems.size - 1)
    }

    fun deleteDoneTodos() {
        shoppingListItems.removeAll { shoppingListItem ->
            shoppingListItem.isChecked
        }
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean) {
        if(isChecked) {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: ShoppingListItemViewHolder, position: Int) {
        val curTodo = shoppingListItems[position]
        holder.itemView.apply {
            val tvTitle = this.findViewById<TextView>(R.id.tvTodoTitle)
            tvTitle.text = curTodo.title;
            val cbDone = this.findViewById<CheckBox>(R.id.cbDone);
            cbDone.isChecked = curTodo.isChecked
            toggleStrikeThrough(tvTitle, curTodo.isChecked)
            cbDone.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeThrough(tvTitle, isChecked)
                curTodo.isChecked = !curTodo.isChecked
            }
        }
    }

    override fun getItemCount(): Int {
        return shoppingListItems.size
    }
}