package com.repo.entity

import net.minecraft.entity.EntityType
import net.minecraft.entity.data.DataTracker
import net.minecraft.entity.data.TrackedData
import net.minecraft.entity.data.TrackedDataHandlerRegistry
import net.minecraft.entity.vehicle.AbstractMinecartEntity
import net.minecraft.entity.vehicle.AbstractMinecartEntity.Type
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.world.World

class RepoCartEntity(type: EntityType<out RepoCartEntity>, world: World) : AbstractMinecartEntity(type, world) {

    companion object {
        // Register the price as tracked data to sync server -> client
        val PRICE: TrackedData<Int> = DataTracker.registerData(RepoCartEntity::class.java, TrackedDataHandlerRegistry.INTEGER)
    }

    override fun initDataTracker(builder: DataTracker.Builder) {
        super.initDataTracker(builder)
        builder.add(PRICE, 0)
    }

    var price: Int
        get() = this.getDataTracker().get(PRICE) // Use getter method explicitly
        set(value) = this.getDataTracker().set(PRICE, value)

    override fun asItem(): Item {
        return Items.MINECART 
    }

    override fun getMinecartType(): AbstractMinecartEntity.Type {
        return AbstractMinecartEntity.Type.CHEST
    }
}