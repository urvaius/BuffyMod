package com.arne5.buffymod;

import com.arne5.buffymod.mobs.ModelFrankensteinMob;
import com.arne5.buffymod.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;

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
				woodStake = new com.arne5.buffymod.items.woodStake(woodStakeID,Item.ToolMaterial.WOOD).setUnlocalizedName("woodStake").setCreativeTab(CreativeTabs.tabCombat);
				//then register it. dont need the substing part i guess check on later
				GameRegistry.registerItem(itemTest, itemTest.getUnlocalizedName().substring(5));
				//GameRegistry.registerItem(woodStake, woodStake.getUnlocalizedName().substring(5));
				//for wood stake not sure of unlocalized or this one
				GameRegistry.registerItem(woodStake,"woodStake");
				//create woodstake in a recipe  make it have s special item to make it later on
				GameRegistry.addShapedRecipe(new ItemStack(BuffyMod.woodStake, 1), new Object[]{" C ", " C "," C ", 'C', Items.stick});



				//call entities
				//registerEntity1(ModelFrankensteinMob.class, "Frankenstein");
				//register teh frankenstein differently with registerfrank class
				registerFrank(ModelFrankensteinMob.class, "Frankenstein", 0xeaeae8, 0xc99a13);
				//try to spawn
				//addSpawn(ModelFrankensteinMob.class, 10,1, 3,BiomeGenBase.birchForest );

				//addSpawn(ModelFrankensteinMob.class,10,1,3,BiomeGenBase.getBiome(p_i45377_1_));
				//cant get that constructor to work do this for now just for forest testing spawn
				//EntityRegistry.addSpawn(ModelFrankensteinMob.class, 10, 1, 5, EnumCreatureType.creature, BiomeGenBase.forest);
				//EntityRegistry.addSpawn(ModelFrankensteinMob.class, 20, 5, 10, EnumCreatureType.creature, BiomeGenBase.plains);
				//EntityRegistry.addSpawn(ModelFrankensteinMob.class, 100, 4, 4, EnumCreatureType.monster);
				//EntityRegistry.addSpawn(ModelFrankensteinMob.class, 100, 4, 4, EnumCreatureType.creature);
				EntityRegistry.addSpawn(ModelFrankensteinMob.class, 100, 4, 4, EnumCreatureType.monster,BiomeGenBase.beach,BiomeGenBase.coldBeach,BiomeGenBase.coldTaiga,BiomeGenBase.coldTaigaHills, BiomeGenBase.desert,BiomeGenBase.desertHills,BiomeGenBase.extremeHills,BiomeGenBase.jungleHills,BiomeGenBase.savanna, BiomeGenBase.extremeHills, BiomeGenBase.forest,BiomeGenBase.birchForestHills, BiomeGenBase.jungle, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.taigaHills,BiomeGenBase.birchForest);






				//register entities
				registerEntity1(EntityTestWithAI.class, "entityTestWithAI");
				//try to spawn this one too frankis not working
				//EntityRegistry.addSpawn(EntityTestWithAI.class,100,4,4,EnumCreatureType.creature,BiomeGenBase.beach,BiomeGenBase.coldBeach,BiomeGenBase.coldTaiga,BiomeGenBase.coldTaigaHills, BiomeGenBase.desert,BiomeGenBase.desertHills,BiomeGenBase.extremeHills,BiomeGenBase.jungleHills,BiomeGenBase.savanna, BiomeGenBase.extremeHills, BiomeGenBase.forest,BiomeGenBase.birchForestHills, BiomeGenBase.jungle, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.taigaHills,BiomeGenBase.birchForest);



				registerEntity1(EntityTest.class, "entityTest");

				GameRegistry.registerBlock(blockTest, blockTest.getUnlocalizedName().substring(5));

				//register rendering for mobs
				proxy.registerRenderers();


			}


		private void registerFrank(Class<ModelFrankensteinMob> entityClass, String entityName,
		                            int bkEggColor, int fgEggColor) {
			int id = EntityRegistry.findGlobalUniqueEntityId();

			EntityRegistry.registerGlobalEntityID(entityClass, entityName, id);
			EntityList.entityEggs.put(Integer.valueOf(id), new EntityList.EntityEggInfo(id, bkEggColor, fgEggColor));
		}




			//to make it easier to register entities and make new ones these are test ones and proably ok
		public static void registerEntity1(Class entityClass, String name)
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
