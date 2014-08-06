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



			//this will act like a mob now
			this.tasks.addTask(1, new EntityAISwimming(this));
			this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2D, true));
			this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
			this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
			this.tasks.addTask(5, new EntityAILookIdle(this));

			this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
			this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));




		}

		//adds your custom ai to mob
		public boolean isAIEnabled()
			{
				return true;
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
