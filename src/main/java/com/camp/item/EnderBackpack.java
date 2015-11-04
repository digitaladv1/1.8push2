package com.camp.item;

import com.example.examplemod.cm;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EnderBackpack extends Item{
	public static final String name="EnderBackpack";
	private ItemStack itemInUse;
	
	public EnderBackpack(){
        super();
        this.setUnlocalizedName(this.name);
		this.setCreativeTab(cm.tabIke);
		
		
	}
	
	@Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.DRINK;
    }
    
    
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
    	//boolean openGui = true;
    	InventoryEnderChest inventoryenderchest = playerIn.getInventoryEnderChest();
    	playerIn.displayGUIChest(inventoryenderchest);
    	//if(Minecraft.getMinecraft().thePlayer.gui)
    	//boolean gui = Minecraft.getMinecraft().currentScreen.doesGuiPauseGame();
    	//gui = false;
    	ItemStack ender = playerIn.inventory.getCurrentItem();
    	
    	
    	
       // object = new InventoryLargeChest("container.chestDouble", (TileEntityChest)tileentity1, (ILockableContainer)object);

        return itemStackIn;
    }
    //boolean openGui = false;

}
