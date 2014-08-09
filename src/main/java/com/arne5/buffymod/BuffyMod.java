package com.arne5.buffymod;

import com.arne5.buffymod.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

import java.util.Random;


@Mod(modid = BuffyMod.MODID, version = BuffyMod.VERSION)
public class BuffyMod
	{
		public static final String MODID = "buffymod";
		public static final String VERSION = "1.0";

		@SidedProxy(clientSide="com.arne5.buffymod.proxy.ClientProxy", serverSide="com.arne5.buffymod.proxy.CommonProxy")
		public static CommonProxy proxy;


		@Mod.Instance(MODID)
		public static BuffyMod instance;
		public static Block blockTest;
		public static Item itemTest;

		//stake items
		public static Item woodStake;
		int woodStakeID = 500;

		public static CreativeTabs tabBuffyMod = new CreativeTabsBuffyMod("BuffyMod");
		@Mod.EventHandler
		public void preInit(FMLPreInitializationEvent event)
			{
				// some example code
				System.out.println("DIRT BLOCK >> "+ Blocks.dirt.getUnlocalizedName());



				blockTest = new BlockTest().setBlockName("blockTest");
				itemTest = new ItemTest().setUnlocalizedName("itemTest").setTextureName(BuffyMod.MODID + ":" + "itemTest");

				//this is working with woodStake Class
				//here is the base new item dont have to do the one below texture nam is in class
				//woodStake = new woodStake(woodStakeID,Item.ToolMaterial.WOOD).setUnlocalizedName("woodStake").setCreativeTab(CreativeTabs.tabCombat).setTextureName(BuffyMod.MODID + ":" +"woodStake");
				woodStake = new woodStake(woodStakeID,Item.ToolMaterial.WOOD).setUnlocalizedName("woodStake").setCreativeTab(CreativeTabs.tabCombat);
				//then register it. dont need the substing part i guess check on later
				GameRegistry.registerItem(itemTest, itemTest.getUnlocalizedName().substring(5));
				//GameRegistry.registerItem(woodStake, woodStake.getUnlocalizedName().substring(5));
				//for wood stake not sure of unlocalized or this one
				GameRegistry.registerItem(woodStake,"woodStake");




				//call entity
				registerEntity(EntityTest.class, "entityTest");

				GameRegistry.registerBlock(blockTest, blockTest.getUnlocalizedName().substring(5));

				//reggister rendering fo rmobs
				proxy.registerRenderers();


			}

			//to make it easier to register entities and make new ones
		public static void registerEntity(Class entityClass, String name)
			{
				int entityID = EntityRegistry.findGlobalUniqueEntityId();
				long seed = name.hashCode();
				Random rand = new Random(seed);
				int primaryColor = rand.nextInt() * 16777215;
				int secondaryColor = rand.nextInt() * 16777215;

				EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
				EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);
				EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primaryColor, secondaryColor));
			}

	}
