package com.camp.block;
 
import com.example.examplemod.cm;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
 
public class SmashBlock extends Block {
 
    public static final String name = "SmashBlock";
     
    public SmashBlock() {
        super(Material.barrier);
        this.setUnlocalizedName(this.name);
        this.slipperiness = 1.5f;
        this.setLightLevel(1.0f);
        this.setCreativeTab(cm.tabIke);
        
    }
    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }
    
}