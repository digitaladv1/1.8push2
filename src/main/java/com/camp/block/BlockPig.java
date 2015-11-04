package com.camp.block;

import java.util.Random;

import com.example.examplemod.cm;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPig extends Block{
	
	public static final String name = "BlockPig";
	protected BlockPig() {
		super(Material.clay);
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(this.name);
		this.setCreativeTab(cm.tabIke);
	}
	 /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 3;
    }

    /**
     * Get the Item that this Block should drop when harvested.
     *  
     * @param fortune the level of the Fortune enchantment on the player's tool
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.porkchop;
    }
	

	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        double d0 = (double)pos.getX();
        double d1 = (double)pos.getY();
        double d2 = (double)pos.getZ();
//mob.pig.death
        
                {
                    worldIn.playSound(d0 + 0.5D, d1 + 0.5D, d2 + 0.5D, "mob.pig.say", rand.nextFloat() * 0.25F + 0.75F, rand.nextFloat() * -10.0F + 0.5F, false);
                }
                {
                    worldIn.playSound(d0 + 0.5D, d1 + 0.5D, d2 + 0.5D, "mob.pig.say", rand.nextFloat() * 0.25F + 0.75F, rand.nextFloat() * 10.0F + 0.5F, false);
                }
               /* {
                    worldIn.playSound(d0 + 0.5D, d1 + 0.5D, d2 + 0.5D, "mob.pig.death", rand.nextFloat() * 0.25F + 0.75F, rand.nextFloat() * 1.0F + 0.5F, false);
                }
            */
            }
	
        
    }


