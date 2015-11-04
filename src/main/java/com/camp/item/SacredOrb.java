package com.camp.item;

import com.example.examplemod.cm;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class SacredOrb extends Item{
	
	public static final String name = "FireOrb";
	 
    public SacredOrb(){
        super();
         
 
        this.setUnlocalizedName(this.name);
		this.setCreativeTab(cm.tabIke);
		
		
	}
	
    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer player, int par4) {
    }



    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        ArrowNockEvent event = new ArrowNockEvent(player, itemStack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled()) {
            return event.result;
        }

        if (player.capabilities.isCreativeMode || player.inventory.hasItem(Items.fire_charge)) {
            player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        }

        return itemStack;
    }

    /**
     * Called each tick while using an item.
     *
     * @param stack The Item being used
     * @param player The Player using the item
     * @param count The amount of time in tick the item has been used for
     * continuously
     */
    public void onUsingItemTick(ItemStack itemStack, EntityPlayer player, int count) {
        if (count % 10 != 0) {
            return;
        }
        World world = player.worldObj;
        ArrowNockEvent event = new ArrowNockEvent(player, itemStack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled()) {
            return;
        }

        if (player.capabilities.isCreativeMode || player.inventory.hasItem(Items.fire_charge)) {
            player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        }

        int j = this.getMaxItemUseDuration(itemStack) - 1;

        ArrowLooseEvent eventAr = new ArrowLooseEvent(player, itemStack, j);
        MinecraftForge.EVENT_BUS.post(eventAr);

        boolean flag = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, itemStack) > 0;

        if (flag || player.inventory.hasItem(Items.fire_charge)) {
            double yaw = Math.toRadians(player.rotationYaw);
            double pitch = Math.toRadians(player.rotationPitch);

            double xDirection = -Math.sin(yaw) * Math.cos(pitch);
            double yDirection = -Math.sin(pitch);
            double zDirection = Math.cos(yaw) * Math.cos(pitch);

            double x = player.posX + xDirection * 2;
            double y = player.posY + 1.5 + yDirection;
            double z = player.posZ + zDirection * 2;

            EntityLargeFireball fireball = new EntityLargeFireball(world, x, y, z, xDirection, yDirection, zDirection);

            

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, itemStack) > 0) {
                fireball.setFire(100);
            }

            itemStack.damageItem(1, player);
           

            if (!flag) {
                player.inventory.consumeInventoryItem(Items.fire_charge);
            }

            if (!world.isRemote) {
                world.spawnEntityInWorld(fireball);
            }
        }
    }
	

}
