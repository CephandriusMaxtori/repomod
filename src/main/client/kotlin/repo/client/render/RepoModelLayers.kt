package repo.client.render

import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.util.Identifier
import com.repo.RepoMod

object RepoModelLayers {
    val PRICE_CART_LAYER = EntityModelLayer(Identifier.of(RepoMod.MOD_ID, "repo_cart"), "main")
}