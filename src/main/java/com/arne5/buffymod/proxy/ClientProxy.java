package com.arne5.buffymod.proxy;

import com.arne5.buffymod.EntityTestWithAI;
import net.minecraft.client.model.ModelBiped;

import com.arne5.buffymod.EntityTest;
import com.arne5.buffymod.RenderTest;
import cpw.mods.fml.client.registry.RenderingRegistry;
public class ClientProxy extends CommonProxy
	{
		@Override
		public void registerRenderers()
		{    //render model with class foryour new mob
			RenderingRegistry.registerEntityRenderingHandler(EntityTest.class, new RenderTest(new ModelBiped(), 0.5F));
			RenderingRegistry.registerEntityRenderingHandler(EntityTestWithAI.class,new RenderTest(new ModelBiped(),0.5f));
		}
	}
