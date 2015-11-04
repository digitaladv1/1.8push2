package com.camp;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class IkeTab extends CreativeTabs{

	public IkeTab(String label){
		super(label);
		this.setBackgroundImageName("ike.png");
		
	}
	
	@Override public Item getTabIconItem(){
		return Items.written_book;
	}
	

}
