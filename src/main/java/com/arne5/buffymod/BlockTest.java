package com.arne5.buffymod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

/**
 * Created by urvaius on 8/2/14.
 */
public class BlockTest extends Block
	{
		@SideOnly(Side.CLIENT)
		protected IIcon blockIcon;

		protected BlockTest() {
			super(Material.ground);
			this.setCreativeTab(BuffyMod.tabBuffyMod);
			//simple single texutre in texutres.blocks
			//this.setBlockTextureName(BuffyMod.MODID + ":" + "blockTest") ;


		}


		@SideOnly(Side.CLIENT)
		@Override
		public void registerBlockIcons(IIconRegister p_149651_1_)
			{
				blockIcon = p_149651_1_.registerIcon(BuffyMod.MODID + ":" + this.getUnlocalizedName().substring(5));
			}

		@SideOnly(Side.CLIENT)
		@Override
		public IIcon getIcon(int p_149691_1_, int p_149691_2_)
			{
				return blockIcon;
			}

	}
