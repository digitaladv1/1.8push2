package com.camp.block;
 
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.example.examplemod.cm;
 
public class SplatoonBlock extends Block {
 
    public static final String name = "SplatoonBlock";
     
    public SplatoonBlock() {
        super(Material.rock);
        this.setUnlocalizedName(this.name);
        this.setCreativeTab(cm.tabIke);
        
    }
    public boolean canProvidePower()
    {
        return true;
    }
 
    public int isProvidingWeakPower(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
    {
        return 150;
    }
    
    
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(BlockManager.splatoonBlock);
    }
    
    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon)
    {
        return this == net.minecraft.init.Blocks.emerald_block || this == net.minecraft.init.Blocks.gold_block || this == net.minecraft.init.Blocks.diamond_block || this == net.minecraft.init.Blocks.iron_block  || this == Blocks.air || this == Blocks.dirt|| this == Blocks.stone || this == BlockManager.splatoonBlock;
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos)
    {
        return Item.getItemFromBlock(BlockManager.splatoonBlock);
    }

    protected ItemStack createStackedBlock(IBlockState state)
    {
        return new ItemStack(BlockManager.splatoonBlock);
    }
}