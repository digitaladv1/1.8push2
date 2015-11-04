package com.camp.block;

import java.util.Random;

import com.camp.item.ItemManager;
import com.example.examplemod.cm;
import com.ibm.icu.impl.duration.TimeUnit;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TestBlock extends Block{
	
public static final String name = "TestBlock";

	protected TestBlock() {
		super(Material.glass);
		this.setCreativeTab(cm.tabIke);
		this.setLightLevel(2.0f);
		this.setLightLevel(3.0f);
		this.translucent=true;
		//this.setLightLevel(1);
		this.lightOpacity=0;
	//	this.setLightOpacity(0);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 16.0F, 16F, 16.0F);
		this.setStepSound(SLIME_SOUND);
		this.setUnlocalizedName(name);
		//this.
	}
	public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean isFullCube()
    {
        return false;
    }
    public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
    {
        this.setBlockBoundsFromMeta(0);
    }

    protected void setBlockBoundsFromMeta(int meta)
    {
        byte b0 = 0;
        float f = (float)(1 * (1 + b0)) / 16.0F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
    }
	public Block setLightLevel(float value)
    {
        this.lightValue = (int)(30.0F * value);
        return this;
    }
	
	/**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		
		worldIn.spawnParticle(EnumParticleTypes.LAVA, 1, 1, 1, 1.5, 1.5, 1.5, new int[0]);
    	//worldIn.spawnEntityInWorld(new EntityExpBottle(worldIn, playerIn));
		//worldIn.getStarBrightness(p_72880_1_)
    	worldIn.spawnEntityInWorld(new EntityExpBottle(worldIn, playerIn));
    	//worldIn.spawnEntityInWorld(new EntityPotion(worldIn, playerIn, 6).setPotionDamage(Potion.heal.getId()));
    	int duration = 20*60;
    	float ham1=playerIn.getMaxHealth();
    	float ham2=playerIn.getHealth();
    	float ham=ham1-ham2;
    	playerIn.heal(ham);
    	//playerIn.
    	playerIn.extinguish();
        //playerIn.addPotionEffect(new PotionEffect(Potion.heal.getId(), duration, 10));
        playerIn.addPotionEffect(new PotionEffect(Potion.saturation.getId(), duration, 10));
        float eye = playerIn.eyeHeight;
        eye++;
        //playerIn.eyeHeight=eye;
        if (playerIn.getName().equals("trainboy2019"))
        {
        	playerIn.entityDropItem(new ItemStack(ItemManager.trainboyItem), 3);
        	//playerIn.dropItem(new ItemStack(Items.apple, 1), true, false);
        	try {
        	    Thread.sleep(100);
        	} catch(InterruptedException ex) {
        	    Thread.currentThread().interrupt();
        	}
        	playerIn.dropItem(new ItemStack(Items.apple, 1), true, false);
        	try {
        	    Thread.sleep(100);
        	} catch(InterruptedException ex) {
        	    Thread.currentThread().interrupt();
        	}
        	playerIn.dropItem(new ItemStack(Items.apple, 1), true, false);
        	try {
        	    Thread.sleep(100);
        	} catch(InterruptedException ex) {
        	    Thread.currentThread().interrupt();
        	}
        }
       // playerIn.setSpawnPoint(pos, true);
        return true;
    }

}
