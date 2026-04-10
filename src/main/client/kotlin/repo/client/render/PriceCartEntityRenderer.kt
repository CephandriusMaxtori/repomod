package repo.client.render

import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MinecartEntityRenderer
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.text.Text
import com.repo.entity.RepoCartEntity
import repo.client.render.model.PriceCartEntityModel
import repo.client.render.RepoModelLayers.PRICE_CART_LAYER

class PriceCartEntityRenderer(context: EntityRendererFactory.Context) : 
    MinecartEntityRenderer<RepoCartEntity>(context, PRICE_CART_LAYER) {

    override fun render(
        entity: RepoCartEntity,
        yaw: Float,
        tickDelta: Float,
        matrices: MatrixStack,
        vertexConsumers: VertexConsumerProvider,
        light: Int
    ) {
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light)

        // Render the dynamic price label
        val priceText = Text.literal("Price: $${entity.price}")
        renderPriceLabel(entity, priceText, matrices, vertexConsumers, light)
    }

    private fun renderPriceLabel(
        entity: RepoCartEntity,
        text: Text,
        matrices: MatrixStack,
        vertexConsumers: VertexConsumerProvider,
        light: Int
    ) {
        val d = dispatcher.getSquaredDistanceToCamera(entity)
        if (d <= 4096.0) { // Only render if reasonably close
            val height = entity.height + 0.5f
            matrices.push()
            matrices.translate(0.0, height.toDouble(), 0.0)
            
            // Use the protected renderLabelIfPresent logic or custom text rendering
            // Here we use the standard name tag rendering style
            this.renderLabelIfPresent(entity, text, matrices, vertexConsumers, light, tickDelta = 0f)
            
            matrices.pop()
        }
    }
}