package repo.entity

import net.minecraft.entity.EntityType
import net.minecraft.entity.data.DataTracker
import net.minecraft.entity.data.TrackedData
import net.minecraft.entity.data.TrackedDataHandlerRegistry
import net.minecraft.entity.vehicle.AbstractMinecartEntity
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.world.World

class PriceCartEntity(type: EntityType<out PriceCartEntity>, world: World) : AbstractMinecartEntity(type, world) {

    companion object {
        val PRICE: TrackedData<Int> = DataTracker.registerData(
            PriceCartEntity::class.java,
            TrackedDataHandlerRegistry.INTEGER
        )
    }

    override fun initDataTracker(builder: DataTracker.Builder) {
        super.initDataTracker(builder)
        builder.add(PRICE, 0)
    }

    var price: Int
        get() = dataTracker.get(PRICE)
        set(value) { dataTracker.set(PRICE, value) }

    override fun asItem(): Item {
        return Items.MINECART
    }

    override fun getMinecartType(): AbstractMinecartEntity.Type {
        return AbstractMinecartEntity.Type.CHEST
    }
}