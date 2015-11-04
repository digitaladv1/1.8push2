package com.camp.block;

import java.util.Random;

import com.camp.item.ItemManager;
import com.example.examplemod.cm;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class OreBlock extends Block {
	public static final String name = "OreBlock";
	Random rand = new Random();

	int n = rand.nextInt(6) + 1;
	//5 is the maximum and the 1 is our minimum 
	private Item drop;
	private int meta;
	private int least_quantity;
	private int most_quantity;
     
	protected OreBlock() {
		super(Material.rock);
        this.setUnlocalizedName(this.name);
        this.setCreativeTab(cm.tabIke);
        
    }
	public boolean isOpaqueCube()
	    {
	        return false;
	    }

	  public boolean isFullCube()
	    {
	        return true;
	    }
	    
	  private Item itemDropped = null;
	  private int quantityDropped = 0;
	  

	  	public Item getItemDropped(int metadata, Random random, int fortune)
	  	{
	  		ItemStack dropApple = new ItemStack(Items.golden_apple);
	  		dropApple.setItemDamage(1);
	  		int drop = random.nextInt(8);
	          
	              if (drop == 0)
	              {
	                itemDropped = dropApple.getItem();
	              }
	          
	              else if (drop == 1)
	              {
	                 itemDropped = Items.diamond;
	              }
	              
	              else if (drop == 2)
	              {
	                 itemDropped = Items.gold_ingot;
	              }
	          
	              else if (drop == 3)
	              {
	                 itemDropped = Items.iron_ingot;
	              }
	          
	             else if (drop == 4)
	             {
	                 itemDropped = Items.emerald;
	             }
	          
	             else if (drop == 5)
	             {
	                 itemDropped = Items.redstone;
	             }
	          
	             else if (drop == 6)
	             {
	                 itemDropped = Items.coal;
	             }
	          
	             else
	             {
	                 itemDropped = ItemManager.americanIngot;
	             }
	          
	          return itemDropped;
	  	}

	  	public int quantityDropped(int meta, int fortune, Random random)
	  	{
	  		ItemStack dropApple = new ItemStack(Items.golden_apple);
	  		dropApple.setItemDamage(1);
	  		if(itemDropped == dropApple.getItem())
	  		{
	  			quantityDropped = 1;
	  		}
	  		else if(itemDropped == Items.diamond)
	  		{
	  			quantityDropped = 2;
	  		}
	  		else if(itemDropped == Items.gold_ingot)
	  		{
	  			quantityDropped = 7;
	  		}
	  		else if(itemDropped == Items.iron_ingot)
	  		{
	  			quantityDropped = 5;
	  		}
	  		else if(itemDropped == Items.redstone)
	  		{
	  			quantityDropped = 20;
	  		}
	  		else if(itemDropped == Items.coal)
	  		{
	  			quantityDropped = 10;
	  		}
	  		else if(itemDropped == Items.emerald)
	  		{
	  			quantityDropped = 3;
	  		}
	  		else
	  		{
	  			quantityDropped = 1;
	  		}
	  		
	  		return quantityDropped;
	  	}
	
}

