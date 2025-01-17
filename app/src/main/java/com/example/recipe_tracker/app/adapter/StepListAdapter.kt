package com.example.recipe_tracker.app.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.recipe_tracker.R
import com.example.recipe_tracker.app.viewholder.StepViewHolder
import com.example.recipe_tracker.domain.model.Step

class StepListAdapter : ListAdapter<Step, StepViewHolder>(DIFF) {

    private companion object {
        val DIFF = object : DiffUtil.ItemCallback<Step>() {
            override fun areItemsTheSame(oldItem: Step, newItem: Step): Boolean {
                return oldItem.number == newItem.number
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: Step, newItem: Step): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StepViewHolder {
        return StepViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.step_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: StepViewHolder, position: Int) {
        val element = getItem(position)
        holder.bind(element)
    }
}