package com.camp.item;
 
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.example.examplemod.cm;
 
public class CustomItem extends Item {
 
public static final String name = "CustomItem";
 
    public CustomItem(){
        super();
         
 
        this.setUnlocalizedName(this.name);
        
        this.setCreativeTab(cm.tabIke);
 
         
    }
    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn,
            World worldIn, BlockPos pos, EnumFacing side, float hitX,
            float hitY, float hitZ) {
         
        worldIn.createExplosion(playerIn, pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 100.0f, true);
         
         
         
        return super.onItemUse(stack, playerIn, worldIn, pos, side, hitX, hitY, hitZ);
    }
}