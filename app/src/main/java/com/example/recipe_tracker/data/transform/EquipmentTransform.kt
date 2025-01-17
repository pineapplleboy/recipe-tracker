package com.example.recipe_tracker.data.transform

import com.example.recipe_tracker.data.model.EquipmentDTO
import com.example.recipe_tracker.domain.model.Equipment

fun EquipmentDTO.toDomainModel(): Equipment{

    return Equipment(
        id = this.id,
        name = this.name,
        localizedName = this.localizedName,
        image = this.image
    )
}