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

public class HiddenBlock extends Block
{
    private final boolean isOn;
    public static final String name = "HiddenBlock";
    public static final String nameOn = "PoweredHiddenBlock";

    public HiddenBlock(boolean isOn)
    {
    	//this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
        super(Material.barrier);
        this.isOn = isOn;
        this.setCreativeTab(cm.tabIke);
        this.setResistance(6000001.0F);
        this.translucent = true;
       // this.blockMaterial.setReplaceable();
        if(this.isOn){
        	this.setUnlocalizedName(nameOn);
        }
        if(!this.isOn){
        	this.setUnlocalizedName(name);
        }
        

        if (isOn)
        {
            
        	this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
            
        }
        if (!isOn){
        	this.setBlockBounds(1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F);
        }
        
        
    }
    public boolean isFullCube()
    {
        return false;
    }
    
    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return -1;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * Returns the default ambient occlusion value based on block opacity
     */
    @SideOnly(Side.CLIENT)
    public float getAmbientOcclusionLightValue()
    {
        return 1.0F;
    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            if (this.isOn && !worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, BlockManager.hiddenBlock.getDefaultState(), 2);
            }
            else if (!this.isOn && worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, BlockManager.poweredHiddenBlock.getDefaultState(), 2);
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
                worldIn.setBlockState(pos, BlockManager.poweredHiddenBlock.getDefaultState(), 2);
            }
        }
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            if (this.isOn && !worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, BlockManager.hiddenBlock.getDefaultState(), 2);
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
        return Item.getItemFromBlock(BlockManager.hiddenBlock);
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos)
    {
        return Item.getItemFromBlock(BlockManager.hiddenBlock);
    }

    protected ItemStack createStackedBlock(IBlockState state)
    {
        return new ItemStack(BlockManager.hiddenBlock);
    }
}