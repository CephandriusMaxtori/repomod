package com.repo.client

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
import net.minecraft.client.render.entity.MinecartEntityRenderer
import net.minecraft.client.render.entity.model.EntityModelLayers

object RepoModClient : ClientModInitializer {
	override fun onInitializeClient() {
		EntityRendererRegistry.register(RepoMod.REPO_CART_TYPE) { context ->
			MinecartEntityRenderer(context, EntityModelLayers.CHEST_MINECART)
		}
	}
}