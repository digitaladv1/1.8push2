package com.camp.entity;

import java.util.Calendar;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.biome.BiomeGenBase;

import com.camp.item.ItemManager;

public class CustomMob extends EntitySpider {
	public static boolean yt = true;
	private float heightOffset = 0.5F;
    /** ticks until heightOffset is randomized */
    private int heightOffsetUpdateTime;
	
	public CustomMob(World par1World) {
		super(par1World);
		this.setSize(1.0f, 2.0f);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, 0.3d));
		this.tasks.addTask(2, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(5, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityBlaze.class, 1.0D, true));
        
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityVillager.class, false));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityBlaze.class, false));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, false));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
		this.isImmuneToFire = true;
		this.tasks.addTask(3, new EntityAITempt(this, 1.0d, Items.apple, false));
		this.canPickUpLoot();
		this.dimension = -1;
		this.dimension = 0;
		this.dimension = 1;
		this.isAirBorne = true;
	//this.setSize(10f, 20f);
		this.canBePushed();
		this.addSpawn(CustomMob.class, 1000, 1, 5, EnumCreatureType.CREATURE, BiomeGenBase.plains, BiomeGenBase.taigaHills, BiomeGenBase.taiga, BiomeGenBase.forest, BiomeGenBase.extremeHills);
		this.getActivePotionEffect(Potion.moveSpeed);
		this.getActivePotionEffect(Potion.confusion);
		this.getActivePotionEffect(Potion.waterBreathing);
		this.limbSwing = 1.0f;
		this.hitByEntity(getLastAttacker());
		this.getHeldItem(Items.stone_sword);
		this.spawnExplosionParticle();
		//this.setSize(this.width * 6.0F, this.height * 6.0F);
		this.setSize(1.0f, 1.0f);
		/*public void setChild(boolean par1;
	    {
	        this.getDataWatcher().updateObject(12, Byte.valueOf((byte)(par1 ? 1 : 0)));
	        if (this.worldObj != null && !this.worldObj.isRemote)
	        {
	            IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
	            iattributeinstance.removeModifier(babySpeedBoostModifier);
	            if (par1)
	            {
	                iattributeinstance.applyModifier(babySpeedBoostModifier);
	            }
	        }
	        this.func_142017_o(par1);
	    }*/
		
		
		
		// this.isDead()= true;
		// this.findPlayerToAttack()=true;

	}
	
	protected void addRandomArmor()
    {
      
    }

    protected void func_180481_a(DifficultyInstance p_180481_1_)
    {
        super.func_180481_a(p_180481_1_);
        this.setCurrentItemOrArmor(0, new ItemStack(Items.bow));
    }

    public IEntityLivingData func_180482_a(DifficultyInstance p_180482_1_, IEntityLivingData p_180482_2_)
    {
        p_180482_2_ = super.func_180482_a(p_180482_1_, p_180482_2_);

        if (this.worldObj.provider instanceof WorldProviderHell && this.getRNG().nextInt(5) > 0)
        {
         //   this.tasks.addTask(4, this.aiAttackOnCollide);
           // this.setSkeletonType(1);
            this.setCurrentItemOrArmor(0, new ItemStack(Items.stone_sword));
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
        }
        else
        {
           // this.tasks.addTask(4, this.aiArrowAttack);
            this.func_180481_a(p_180482_1_);
            this.func_180483_b(p_180482_1_);
        }

        this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * p_180482_1_.getClampedAdditionalDifficulty());

        if (this.getEquipmentInSlot(4) == null)
        {
            Calendar calendar = this.worldObj.getCurrentDate();

            if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.rand.nextFloat() < 0.25F)
            {
                this.setCurrentItemOrArmor(4, new ItemStack(this.rand.nextFloat() < 0.1F ? Blocks.lit_pumpkin : Blocks.pumpkin));
                this.equipmentDropChances[4] = 0.0F;
            }
        }

        return p_180482_2_;
    }
    
    public IEntityLivingData func_180482_a1(DifficultyInstance p_180482_1_, IEntityLivingData p_180482_2_)
    {
        Object p_180482_2_1 = super.func_180482_a(p_180482_1_, p_180482_2_);

       // if (this.worldObj.rand.nextInt(1) == 0)
        if (yt = true){
        {
            EntitySkeleton entityskeleton = new EntitySkeleton(this.worldObj);
            entityskeleton.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
            entityskeleton.func_180482_a(p_180482_1_, (IEntityLivingData)null);
            this.worldObj.spawnEntityInWorld(entityskeleton);
            entityskeleton.mountEntity(this);
        }

        if (p_180482_2_1 == null)
        {
            p_180482_2_1 = new EntitySpider.GroupData();

            if (this.worldObj.getDifficulty() == EnumDifficulty.HARD && this.worldObj.rand.nextFloat() < 0.1F * p_180482_1_.getClampedAdditionalDifficulty())
            {
                ((EntitySpider.GroupData)p_180482_2_1).func_111104_a(this.worldObj.rand);
            }
        }

        if (p_180482_2_1 instanceof EntitySpider.GroupData)
        {
            int i = ((EntitySpider.GroupData)p_180482_2_1).field_111105_a;

            if (i > 0 && Potion.potionTypes[i] != null)
            {
                this.addPotionEffect(new PotionEffect(i, Integer.MAX_VALUE));
            }
        }

        return (IEntityLivingData)p_180482_2_1;}
		return p_180482_2_;
    }
	
	public boolean isChild() {
		return true;
	}
	
	public void fall(float distance, float damageMultiplier) {
		if(distance > 10f)
		{
			this.heal(10f);
			
		}
	}
	private void getHeldItem(Item ironsword) {
		// TODO Auto-generated method stub
		
	}
	private void addSpawn(Class<CustomMob> class1, int i, int j, int k,
			EnumCreatureType creature, BiomeGenBase plains,
			BiomeGenBase taigahills, BiomeGenBase taiga, BiomeGenBase forest,
			BiomeGenBase extremehills) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dropFewItems(boolean recentlyHit, int lootLevel) {
	    int quantity = this.rand.nextInt(4) + 1;
	 
	    for (int i = 0; i < quantity; i++) {
	        if (this.isBurning()) {
	            this.dropItem(ItemManager.lightningOrb, 1);
	        }
	        else {
	            Item drop = (ItemManager.customShovel);
	            this.dropItem(drop, 1);
	        }
	    }
	 
	}
	public boolean canBreathUnderwater(){
		return true;
	}
	ItemStack goldStackApple = new ItemStack(Items.golden_apple,1);
	public void dropRareDrop(int par1) {
		//this.setDamage(Items.golden_apple, 1);
		//this.dropItem(Items.iron_ingot, 1);
		this.entityDropItem(new ItemStack(Items.golden_apple, 1,1),.5f);
		//this.dropItem(Items.apple,1);//.setDamage(goldStackApple, 1));//(goldStackApple);//(Items.golden_apple,1,(short)1);
		//this.dropItem(Items.gold_ingot,8);
		
	}
	protected void updateAITasks()
    {
       

        --this.heightOffsetUpdateTime;

        if (this.heightOffsetUpdateTime <= 0)
        {
            this.heightOffsetUpdateTime = 100;
            this.heightOffset = 0.5F + (float)this.rand.nextGaussian() * 3.0F;
        }

        EntityLivingBase entitylivingbase = this.getAttackTarget();

        if (entitylivingbase != null && entitylivingbase.posY + (double)entitylivingbase.getEyeHeight() > this.posY + (double)this.getEyeHeight() + (double)this.heightOffset)
        {
            this.motionY += (1.30000001192092896D - this.motionY) * 1.30000001192092896D;
            this.isAirBorne = true;
        }

        super.updateAITasks();
    }



	
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(1.0d);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
				.setBaseValue(5.0d);
		this.getEntityAttribute(SharedMonsterAttributes.followRange)
				.setBaseValue(15.0);

	}

	public boolean isAIEnabled() {
		return true;
	}
	
	@Override
	protected String getLivingSound()
    {
        return "cm:mob.bigCat.howl"; // It uses sounds.json file to randomize and adds 1, 2 or 3 and .ogg
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
	@Override
	protected String getHurtSound()
    {
        return "cm:mob.bigCat.hurt"; // It uses sounds.json file to randomize and adds 1, 2 or 3 and .ogg
    }

    /**
     * Returns the sound this mob makes on death.
     */
	@Override
    protected String getDeathSound()
    {
        return "cm.sounds.mob.bigCat.death";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("cm:mob.bigCat.step", 0.15F, 1.0F);
    }

}