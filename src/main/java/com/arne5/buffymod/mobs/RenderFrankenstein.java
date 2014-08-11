package com.arne5.buffymod.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

/**
 * Created by urvaius on 8/10/14.
 */

public class RenderFrankenstein extends RenderLiving
	{

	private static final ResourceLocation Frankenstein = new ResourceLocation("buffymod:textures/models/frankensteinskin.png");

	public RenderFrankenstein(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);

	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {

		//return null;
		return Frankenstein;
	}

}