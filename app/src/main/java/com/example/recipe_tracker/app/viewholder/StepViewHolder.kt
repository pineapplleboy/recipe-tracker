package com.example.recipe_tracker.app.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe_tracker.databinding.StepCardBinding
import com.example.recipe_tracker.domain.model.Step

class StepViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    private val binding = StepCardBinding.bind(view)
    private var id: Int? = null

    fun bind(step: Step) = with(binding) {

        id = step.id

        stepNum.text = "Step ${id}"
        stepText.text = step.text
    }
}