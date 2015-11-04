package com.camp.item;
 
import com.example.examplemod.cm;
 

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
 
public class CustomShovel extends ItemSpade{
 
    public final String name = "CustomShovel";
     
    protected CustomShovel(ToolMaterial material) {
        super(material);
        this.setUnlocalizedName(this.name);
        this.setCreativeTab(cm.tabIke);
        // TODO Auto-generated constructor stub
    }
    public boolean onItemUse(ItemStack stack, Entity entityIn,
            World worldIn, BlockPos pos, EnumFacing side, float hitX,
            float hitY, float hitZ) {
         
    	
            entityIn.travelToDimension(0);
        
         
         
         
        return super.onItemUse(stack, (EntityPlayer) entityIn, worldIn, pos, side, hitX, hitY, hitZ);
    }
 
}