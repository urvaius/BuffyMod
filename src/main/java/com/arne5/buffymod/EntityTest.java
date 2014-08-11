package com.arne5.buffymod;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by urvaius on 8/2/14.
 */
public class EntityTest extends EntityMob
	{

		public EntityTest(World par1World)
		{
			super(par1World);






		}


		@Override
		protected void applyEntityAttributes()
			{


				super.applyEntityAttributes();
				this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
				this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
				this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0D);
				this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
				this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
			}

	}
