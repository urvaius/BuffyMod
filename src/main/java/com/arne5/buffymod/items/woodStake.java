package com.arne5.buffymod.items;

import com.google.common.collect.Multimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

/**
 * Created by urvaius on 8/5/14.
 */
public class woodStake extends ItemSword
	{

		public woodStake(int id, Item.ToolMaterial mat)
			{
				super(mat);


			}
		@SideOnly(Side.CLIENT)
		public void registerIcons(IIconRegister reg)
			{
				//location of files texture
				this.itemIcon = reg.registerIcon("buffymod:woodStake");
			}

	}
