package repo.entity

import net.minecraft.item.Item

class PriceCartEntity(type: EntityType<out PriceCartEntity>, world: World) : AbstractMinecartEntity(type, world) {

    companion object {
        // Register the price as tracked data to sync server -> client
        val PRICE: TrackedData<Int> = DataTracker.registerData(PriceCartEntity::class.java, TrackedDataHandlerRegistry.INTEGER)
    }

    override fun initDataTracker(builder: DataTracker.Builder) {
        super.initDataTracker(builder)
        builder.add(PRICE, 0)
    }

    var price: Int
        get() = dataTracker.get(PRICE)
        set(value) = dataTracker.set(PRICE, value)

    override fun asItem(): Item {
        return Items.MINECART // Change to your custom item if applicable
    }

    override fun getMinecartType(): Type {
        // You can return a custom type here if you registered one, 
        // or use CHEST if you want similar behavior.
        return Type.CHEST 
    }
}