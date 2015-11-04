package com.camp.item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import com.example.examplemod.cm;

public class CustomArmor extends ItemArmor{
	public final String name;
	public CustomArmor (ArmorMaterial material, int renderIndex, int armorType, String name) {
		super(material, renderIndex, armorType);
		this.name = name;
		this.setUnlocalizedName(cm.MODID + "_" + name);
		this.setCreativeTab(cm.tabIke);
		
	}
	private boolean nightVision(EntityPlayer playerIn)
    {

	ItemStack itemstack = playerIn.inventory.armorInventory[3];

    while (itemstack != null && itemstack.getItem() == ItemManager.customHelmet)
    {
    	int duration = 20*60;
    	
    	playerIn.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), duration, 10));
        return true;
    }
	return true;
    
    }
    
public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
	if(slot == 2){
		return "cm:textures/models/armor/custom_armor_layer_2.png";
	}
	return "cm:textures/models/armor/custom_armor_layer_1.png";
	}
}