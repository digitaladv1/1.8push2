package com.camp.item;

import com.example.examplemod.cm;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

public class AmericanIngot extends Item{
	public static final String name = "AmericanIngot";
	
	protected AmericanIngot() {
        super();
        this.setCreativeTab(cm.tabIke);
        this.setUnlocalizedName(this.name);
		}
}
