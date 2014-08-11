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
import net.minecraftforge.common.util.EnumHelper;
import com.arne5.buffymod.items.woodStake;

import java.util.Random;


@Mod(modid = BuffyMod.MODID, version = BuffyMod.VERSION)
public class BuffyMod
	{
		public static final String MODID = "buffymod";
		public static final String VERSION = "1.0";

		@SidedProxy(clientSide="com.arne5.buffymod.proxy.ClientProxy", serverSide="com.arne5.buffymod.proxy.CommonProxy")
		public static CommonProxy proxy;
		//custom material for wood stake and others
		/*//The first number in the brakets is the harvest level.
		Level 0 (gold and wood) can't mine iron ore...
		Level 1 (stone) can't mine gold ore...
		Level 2 (iron) can't mine obsidian.
		Level 3 (diamond) can mine every breakable block.
		The second number of uses of the Material.
		wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32
		The third number is the strength against blocks.
		wood = 2.0F, stone = 4.0F, iron = 6.0F, diamond = 8.0F, gold 12.0F
		The fourth number is the damage against entities.
		wood = 0.0F, stone = 1.0F, iron = 2.0F, diamond = 3.0F, gold 0.0F
		The last number is enchantability factor of the Material.
			wood = 15, stone = 5, iron = 14, diamond = 10, gold 22*/


		@Mod.Instance(MODID)
		public static BuffyMod instance;
		public static Block blockTest;
		public static Item itemTest;

		//stake items
		public static Item woodStake;
		int woodStakeID = 500;
		public static final Item.ToolMaterial WoodStakeMaterial = EnumHelper.addToolMaterial("WoodStakeMaterial", 0, 250, 5.0F, 3.0F, 22);


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
				woodStake = new woodStake(woodStakeID,WoodStakeMaterial).setUnlocalizedName("woodStake").setCreativeTab(CreativeTabs.tabCombat);
				//GameRegistry.registerItem(woodStake, woodStake.getUnlocalizedName().substring(5));
				//for wood stake not sure of unlocalized or this one
				GameRegistry.registerItem(woodStake,"woodStake");

				//then register it. dont need the substing part i guess check on later
				GameRegistry.registerItem(itemTest, itemTest.getUnlocalizedName().substring(5));

				//create woodstake in a recipe  make it have s special item to make it later on
				GameRegistry.addShapedRecipe(new ItemStack(BuffyMod.woodStake, 1), new Object[]{" C ", " C ", " C ", 'C', Items.stick});



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
