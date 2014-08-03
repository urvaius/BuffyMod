package com.arne5.buffymod.proxy;

import net.minecraft.client.model.ModelBiped;

import com.arne5.buffymod.EntityTest;
import com.arne5.buffymod.RenderTest;
import cpw.mods.fml.client.registry.RenderingRegistry;
public class ClientProxy extends CommonProxy
	{
		@Override
		public void registerRenderers() {
			RenderingRegistry.registerEntityRenderingHandler(EntityTest.class, new RenderTest(new ModelBiped(), 0.5F));

		}
	}
