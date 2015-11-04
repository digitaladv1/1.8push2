package com.camp.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.example.examplemod.cm;

public class LightningOrb extends Item{
	
	public static final String name = "LightningOrb";
	 
    public LightningOrb(){
        super();
         
 
        this.setUnlocalizedName(this.name);
		this.setCreativeTab(cm.tabIke);
		
		
	}
	
	
	public boolean onItemUse(ItemStack stack, EntityLivingBase target, EntityLivingBase owner) {
	    Entity bolt = new EntityLightningBolt(owner.worldObj, target.posX, target.posY, target.posZ);
	    owner.worldObj.addWeatherEffect(bolt);
	    return true;
	}


	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn,
			World worldIn, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ) {
		// TODO Auto-generated method stub
		Entity bolt = new EntityLightningBolt(worldIn, pos.getX(), pos.getY(), pos.getZ());
	    playerIn.worldObj.addWeatherEffect(bolt);
	    return true;
	}


	

}
