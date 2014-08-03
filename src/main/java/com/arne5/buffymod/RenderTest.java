package com.arne5.buffymod;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

/**
 * Created by urvaius on 8/2/14.
 */
public class RenderTest extends RenderBiped
	{

		private static final ResourceLocation textureLocation = new ResourceLocation(BuffyMod.MODID + ":" + "textures/models/entityTest.png");

		public RenderTest(ModelBiped model, float shadowSize) {
			super(model, shadowSize);
		}

		@Override
		protected ResourceLocation getEntityTexture(Entity par1Entity)
			{
				return textureLocation;
			}
	}
