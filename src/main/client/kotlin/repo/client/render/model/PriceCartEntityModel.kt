package repo.client.render.model

import net.minecraft.client.model.*
import net.minecraft.client.render.entity.model.EntityModelPartNames
import net.minecraft.client.render.entity.model.MinecartEntityModel
import com.repo.entity.RepoCartEntity

class PriceCartEntityModel(root: ModelPart) : MinecartEntityModel<RepoCartEntity>(root) {
    private val goldPile: ModelPart = root.getChild("gold_pile")

    companion object {
        fun getTexturedModelData(): TexturedModelData {
            val modelData = MinecartEntityModel.getModelData() // Get base minecart parts
            val modelPartData = modelData.root
            
            // Add your custom "gold_pile" part here
            modelPartData.addChild(
                "gold_pile",
                ModelPartBuilder.create().uv(0, 0).cuboid(-7.0f, -9.0f, -7.0f, 14.0f, 2.0f, 14.0f),
                ModelTransform.NONE
            )
            return TexturedModelData.of(modelData, 64, 32)
        }
    }

    override fun setAngles(
        entity: RepoCartEntity,
        limbAngle: Float,
        limbDistance: Float,
        animationProgress: Float,
        headYaw: Float,
        headPitch: Float
    ) {
        super.setAngles(entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch)
        
        // Dynamic Model Logic: Only show the gold pile if price is high
        this.goldPile.visible = entity.price > 100
    }
}