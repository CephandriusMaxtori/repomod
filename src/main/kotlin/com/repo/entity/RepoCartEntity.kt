package com.repo.entity

import net.minecraft.entity.EntityType
import net.minecraft.entity.ItemEntity
import net.minecraft.entity.vehicle.ChestMinecartEntity
import net.minecraft.util.math.Box
import net.minecraft.world.World

class RepoCartEntity(type: EntityType<out RepoCartEntity>, world: World) :
    ChestMinecartEntity(type, world) {

    override fun tick() {
        super.tick()

        // Only run logic on the server side every 5 ticks to save performance
        if (!this.world.isClient && this.isAlive && this.age % 5 == 0) {
            val area = Box(this.pos.subtract(3.0, 1.0, 3.0), this.pos.add(3.0, 2.0, 3.0))

            // Look for items nearby
            val items = this.world.getEntitiesByClass(ItemEntity::class.java, area) { true }

            for (item in items) {
                // Pull items toward the center of the cart
                val pullVec = this.pos.add(0.0, 0.5, 0.0).subtract(item.pos).normalize().multiply(0.2)
                item.velocity = pullVec
            }
        }
    }
}