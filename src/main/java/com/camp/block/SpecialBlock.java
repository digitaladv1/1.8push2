package com.camp.block;

import java.util.Calendar;

import com.camp.item.ItemManager;
import com.example.examplemod.cm;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;


public class SpecialBlock extends Block{
	private boolean birthday = false;
	public static final String name= "SpecialBlock";
	public World worldObj;
	private boolean me = false;
	public EntityPlayer playerIn;
	
	
	protected SpecialBlock() {
		super(Material.rock);
		this.setCreativeTab(cm.tabIke);
		
	}
	public boolean isOpaqueCube()
    {
        return false;
    }

	{
		Calendar today = Calendar.getInstance();

		//int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);
		int day = today.get(Calendar.DATE);

		//System.out.println(year +"-" +(month +1) +"-" +day);

		//today.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

		//year = today.get(Calendar.YEAR);
		month = today.get(Calendar.MONTH);
		day = today.get(Calendar.DATE);
		month++;

		//System.out.println(year +"-" +(month +1) +"-" +day);


    //if (calendar.get(2) + 1 == 10 && calendar.get(5) == 11)
		if (month==10&&day==11)
    {
		this.setLightLevel(1f);
		this.setLightOpacity(0);
		birthday=true;
    	//worldObj.spawnParticle(EnumParticleTypes.REDSTONE, 2, 2, 2, 1.5, 3.5, 1.5, new int[0]);
    	
    }
		else{
			birthday=false;
		}
	}
	

	/**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		
		if(playerIn.getName().equals("trainboy2019")){
			me = true;
		}
		else{
			me=false;
		}
		
		
		if(birthday=true&&me==true){
			playerIn.capabilities.disableDamage=true;
			playerIn.addChatComponentMessage(new ChatComponentText("HAPPY BIRTHDAY IKE!"));
		}
		else if(birthday=true&&me==false){
			//playerIn.inventory.addItemStackToInventory(new ItemStack(ItemManager.));
			playerIn.addChatComponentMessage(new ChatComponentText("HAPPY BIRTHDAY TRAINBOY2019!"));
		}
		return birthday;
		
        
       
    }

}
