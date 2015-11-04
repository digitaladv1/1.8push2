package com.camp.block;

import java.util.Random;

import com.example.examplemod.cm;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
//import java.time.

public class SlipperyBlock extends Block
{
    private final boolean isOn;
    public static final String name = "SlipperyBlock";
    public static final String nameOn = "PoweredSlipperyBlock";

    public SlipperyBlock(boolean isOn)
    {
        super(Material.redstoneLight);
        this.isOn = isOn;
        this.setCreativeTab(cm.tabIke);
        if(this.isOn){
        	this.setUnlocalizedName(nameOn);
        }
        if(!this.isOn){
        	this.setUnlocalizedName(name);
        }
        

        if (isOn)
        {
            this.slipperiness=1.2f;
            
        }
        if (!isOn){
        	this.slipperiness=0;
        }
    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            if (this.isOn && !worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, BlockManager.slipperyBlock.getDefaultState(), 2);
            }
            else if (!this.isOn && worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, BlockManager.poweredSlipperyBlock.getDefaultState(), 2);
            }
        }
    }

    /**
     * Called when a neighboring block changes.
     */
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        if (!worldIn.isRemote)
        {
            if (this.isOn && !worldIn.isBlockPowered(pos))
            {
                worldIn.scheduleUpdate(pos, this, 4);
            }
            else if (!this.isOn && worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, BlockManager.poweredSlipperyBlock.getDefaultState(), 2);
            }
        }
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            if (this.isOn && !worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, BlockManager.slipperyBlock.getDefaultState(), 2);
            }
        }
    }

    /**
     * Get the Item that this Block should drop when harvested.
     *  
     * @param fortune the level of the Fortune enchantment on the player's tool
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(BlockManager.slipperyBlock);
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos)
    {
        return Item.getItemFromBlock(BlockManager.slipperyBlock);
    }

    protected ItemStack createStackedBlock(IBlockState state)
    {
        return new ItemStack(BlockManager.slipperyBlock);
    }
}