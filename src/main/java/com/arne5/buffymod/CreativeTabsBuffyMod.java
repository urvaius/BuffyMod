package com.arne5.buffymod;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

/**
 * Created by urvaius on 8/2/14.
 */
public class CreativeTabsBuffyMod extends CreativeTabs
	{

		public CreativeTabsBuffyMod(String tabLabel)
			{
				super(tabLabel);
			}

		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
			{
				return Item.getItemFromBlock(Blocks.dirt);
			}

	}
