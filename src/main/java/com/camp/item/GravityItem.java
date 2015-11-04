package com.camp.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class GravityItem extends Item{
	public static boolean on = false;
	public final String name="GravityItem";
	
	
	public void onItenUse(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
		if(on=false){
			on=true;
		}
		else if(on=true){
			on=false;
		}
    }
	
	public void on(World worldIn, BlockPos pos, IBlockState state, Entity entityIn){
		while(on=true){
	
		entityIn.motionY=1.0F;
		entityIn.fallDistance=0F;
    }
		
	}
}

