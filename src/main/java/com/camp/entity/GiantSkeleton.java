package com.camp.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class GiantSkeleton extends EntitySkeleton{

	public GiantSkeleton(World worldIn) {
		super(worldIn);
		this.setSize(this.width * 6.0F * 16, this.height * 6.0F * 8);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(500);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(256);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.10);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(100);
    }
	 /**
     * Return this skeleton's type.
     */
    public int getSkeletonType()
    {
        return 0;
    }

    /**
     * Set this skeleton's type.
     */
    public void setSkeletonType(int p_82201_1_)
    {
        this.dataWatcher.updateObject(13, Byte.valueOf((byte)p_82201_1_));
        this.isImmuneToFire = p_82201_1_ == 1;

        if (p_82201_1_ == 1)
        {
            this.setSize(0.72F, 2.535F);
        }
        else
        {
            this.setSize(0.6F, 1.95F);
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound tagCompund)
    {
        super.readEntityFromNBT(tagCompund);

        if (tagCompund.hasKey("SkeletonType", 99))
        {
            byte b0 = tagCompund.getByte("SkeletonType");
            this.setSkeletonType(b0);
        }

        this.setCombatTask();
    }

}
