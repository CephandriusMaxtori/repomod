package com.repo

import com.repo.entity.RepoCartEntity
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object RepoMod : ModInitializer {
    const val MOD_ID = "repo"

    val REPO_CART_TYPE: EntityType<RepoCartEntity> = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(MOD_ID, "repo_cart"),
        FabricEntityTypeBuilder.create(SpawnGroup.MISC, ::RepoCartEntity)
            .dimensions(EntityDimensions.fixed(0.98f, 0.7f))
            .build()
    )

    override fun onInitialize() {
        println("R.E.P.O. Mod Initialized!")
    }
}