package com.arne5.buffymod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;


@Mod(modid = BuffyMod.MODID, version = BuffyMod.VERSION)
public class BuffyMod
	{
		public static final String MODID = "buffymod";
		public static final String VERSION = "1.0";

		public static Block blockTest;
		public static Item itemTest;
		public static CreativeTabs tabBuffyMod = new CreativeTabsBuffyMod("BuffyMod");
		@Mod.EventHandler
		public void preInit(FMLPreInitializationEvent event)
			{
				// some example code
				System.out.println("DIRT BLOCK >> "+ Blocks.dirt.getUnlocalizedName());

				blockTest = new BlockTest().setBlockName("blockTest");
				itemTest = new ItemTest().setUnlocalizedName("itemTest").setTextureName(BuffyMod.MODID + ":" + "itemTest");

				GameRegistry.registerItem(itemTest, itemTest.getUnlocalizedName().substring(5));
				GameRegistry.registerBlock(blockTest, blockTest.getUnlocalizedName().substring(5));



			}
	}
