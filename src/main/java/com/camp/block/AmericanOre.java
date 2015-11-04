package com.camp.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import com.camp.item.ItemManager;
import com.example.examplemod.cm;

public class AmericanOre extends Block {
	public static final String name = "AmericanOre";
	private Item drop;
	private int meta;
	private int least_quantity;
	private int most_quantity;
     
	protected AmericanOre() {
		super(Material.rock);
        this.setUnlocalizedName(this.name);
        this.setCreativeTab(cm.tabIke);
        
        }
	public Item getItemDropped(int meta, Random random, int fortune) {
		return ItemManager.americanIngot;
	}

	public int quantityDropped(int meta, int fortune, Random random) {
		if (this.least_quantity >= this.most_quantity)
			return this.least_quantity;
		return this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
	}
	
}

