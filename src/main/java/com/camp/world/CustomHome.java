package com.camp.world;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockTorch;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.StructureVillagePieces.Village;

public class CustomHome extends Village{
	Random randomGenerator = new Random();
	int number = randomGenerator.nextInt(2);
	
	private static final String __OBFID = "CL_00000517";
	private static IBlockState array[];
	//private static String allBlocks[]();
    public CustomHome() {
    	
    }

    public CustomHome(StructureVillagePieces.Start p_i45571_1_, int p_i45571_2_, Random p_i45571_3_, StructureBoundingBox p_i45571_4_, EnumFacing p_i45571_5_)
    {
        super();
        //number=0;
        //new House4Garden();
    	array = new IBlockState[2];
    	array[0] = Blocks.enchanting_table.getDefaultState();
    	array[1] = Blocks.prismarine.getStateFromMeta(1);
        this.coordBaseMode = p_i45571_5_;
        this.boundingBox = p_i45571_4_;
    }	
	public static class House4Garden extends StructureVillagePieces.Village
    {
        private boolean isRoofAccessible;
        private static final String __OBFID = "CL_00000523";

        public House4Garden() {}

        public House4Garden(StructureVillagePieces.Start p_i45566_1_, int p_i45566_2_, Random p_i45566_3_, StructureBoundingBox p_i45566_4_, EnumFacing p_i45566_5_)
        {
            super(p_i45566_1_, p_i45566_2_);
            this.coordBaseMode = p_i45566_5_;
            this.boundingBox = p_i45566_4_;
            this.isRoofAccessible = p_i45566_3_.nextBoolean();
            
        }

        /**
         * (abstract) Helper method to write subclass data to NBT
         */
        protected void writeStructureToNBT(NBTTagCompound p_143012_1_)
        {
            super.writeStructureToNBT(p_143012_1_);
            p_143012_1_.setBoolean("Terrace", this.isRoofAccessible);
        }

        /**
         * (abstract) Helper method to read subclass data from NBT
         */
        protected void readStructureFromNBT(NBTTagCompound p_143011_1_)
        {
            super.readStructureFromNBT(p_143011_1_);
            //this.isRoofAccessible = p_143011_1_.getBoolean("Terrace");
            this.isRoofAccessible = true;
        }

        public static CustomHome func_175858_a(StructureVillagePieces.Start p_175858_0_, List p_175858_1_, Random p_175858_2_, int p_175858_3_, int p_175858_4_, int p_175858_5_, EnumFacing p_175858_6_, int p_175858_7_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175858_3_, p_175858_4_, p_175858_5_, 0, 0, 0, 5, 6, 5, p_175858_6_);
            return StructureComponent.findIntersecting(p_175858_1_, structureboundingbox) != null ? null : new CustomHome(p_175858_0_, p_175858_7_, p_175858_2_, structureboundingbox, p_175858_6_);
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
        {
            if (this.field_143015_k < 0)
            {
                this.field_143015_k = this.getAverageGroundLevel(worldIn, p_74875_3_);

                if (this.field_143015_k < 0)
                {
                    return true;
                }

                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 6 - 1, 0);
                
            }
            
            

            this.func_175804_a(worldIn, p_74875_3_, 0, 0, 0, 4, 0, 4, Blocks.prismarine.getDefaultState(), Blocks.prismarine.getDefaultState(), false);
            this.func_175804_a(worldIn, p_74875_3_, 0, 4, 0, 4, 4, 4, Blocks.prismarine.getStateFromMeta(2), Blocks.prismarine.getStateFromMeta(2), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 4, 1, 3, 4, 3, Blocks.prismarine.getStateFromMeta(1), Blocks.prismarine.getStateFromMeta(1), false);
            this.func_175811_a(worldIn, Blocks.prismarine.getDefaultState(), 0, 1, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.prismarine.getDefaultState(), 0, 2, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.prismarine.getDefaultState(), 0, 3, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.prismarine.getDefaultState(), 4, 1, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.prismarine.getDefaultState(), 4, 2, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.prismarine.getDefaultState(), 4, 3, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.prismarine.getDefaultState(), 0, 1, 4, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.prismarine.getDefaultState(), 0, 2, 4, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.prismarine.getDefaultState(), 0, 3, 4, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.prismarine.getDefaultState(), 4, 1, 4, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.prismarine.getDefaultState(), 4, 2, 4, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.prismarine.getDefaultState(), 4, 3, 4, p_74875_3_);
            this.func_175804_a(worldIn, p_74875_3_, 0, 1, 1, 0, 3, 3, Blocks.prismarine.getStateFromMeta(1), Blocks.prismarine.getStateFromMeta(1), false);
            this.func_175804_a(worldIn, p_74875_3_, 4, 1, 1, 4, 3, 3, Blocks.prismarine.getStateFromMeta(1), Blocks.prismarine.getStateFromMeta(1), false);
            this.func_175804_a(worldIn, p_74875_3_, 1, 1, 4, 3, 3, 4, Blocks.prismarine.getStateFromMeta(1), Blocks.prismarine.getStateFromMeta(1), false);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 0, 2, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 2, 2, 4, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.glass_pane.getDefaultState(), 4, 2, 2, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.prismarine.getStateFromMeta(1), 1, 1, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.prismarine.getStateFromMeta(1), 1, 2, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.prismarine.getStateFromMeta(1), 1, 3, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.prismarine.getStateFromMeta(1), 2, 3, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.prismarine.getStateFromMeta(1), 3, 3, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.prismarine.getStateFromMeta(1), 3, 2, 0, p_74875_3_);
            this.func_175811_a(worldIn, Blocks.prismarine.getStateFromMeta(1), 3, 1, 0, p_74875_3_);

            if (this.func_175807_a(worldIn, 2, 0, -1, p_74875_3_).getBlock().getMaterial() == Material.air && this.func_175807_a(worldIn, 2, -1, -1, p_74875_3_).getBlock().getMaterial() != Material.air)
            {
                this.func_175811_a(worldIn, Blocks.quartz_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.quartz_stairs, 3)), 2, 0, -1, p_74875_3_);
            }

            this.func_175804_a(worldIn, p_74875_3_, 1, 1, 1, 3, 3, 3, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);

            if (this.isRoofAccessible)
            {
                this.func_175811_a(worldIn, Blocks.nether_brick_fence.getDefaultState(), 0, 5, 0, p_74875_3_);
                this.func_175811_a(worldIn, Blocks.nether_brick_fence.getDefaultState(), 1, 5, 0, p_74875_3_);
                this.func_175811_a(worldIn, Blocks.nether_brick_fence.getDefaultState(), 2, 5, 0, p_74875_3_);
                this.func_175811_a(worldIn, Blocks.nether_brick_fence.getDefaultState(), 3, 5, 0, p_74875_3_);
                this.func_175811_a(worldIn, Blocks.nether_brick_fence.getDefaultState(), 4, 5, 0, p_74875_3_);
                this.func_175811_a(worldIn, Blocks.nether_brick_fence.getDefaultState(), 0, 5, 4, p_74875_3_);
                this.func_175811_a(worldIn, Blocks.nether_brick_fence.getDefaultState(), 1, 5, 4, p_74875_3_);
                this.func_175811_a(worldIn, Blocks.nether_brick_fence.getDefaultState(), 2, 5, 4, p_74875_3_);
                this.func_175811_a(worldIn, Blocks.nether_brick_fence.getDefaultState(), 3, 5, 4, p_74875_3_);
                this.func_175811_a(worldIn, Blocks.nether_brick_fence.getDefaultState(), 4, 5, 4, p_74875_3_);
                this.func_175811_a(worldIn, Blocks.nether_brick_fence.getDefaultState(), 4, 5, 1, p_74875_3_);
                this.func_175811_a(worldIn, Blocks.nether_brick_fence.getDefaultState(), 4, 5, 2, p_74875_3_);
                this.func_175811_a(worldIn, Blocks.nether_brick_fence.getDefaultState(), 4, 5, 3, p_74875_3_);
                this.func_175811_a(worldIn, Blocks.nether_brick_fence.getDefaultState(), 0, 5, 1, p_74875_3_);
                this.func_175811_a(worldIn, Blocks.nether_brick_fence.getDefaultState(), 0, 5, 2, p_74875_3_);
                this.func_175811_a(worldIn, Blocks.nether_brick_fence.getDefaultState(), 0, 5, 3, p_74875_3_);
            }

            int i;

            if (this.isRoofAccessible)
            {
                i = this.getMetadataWithOffset(Blocks.ladder, 3);
                this.func_175811_a(worldIn, Blocks.ladder.getStateFromMeta(i), 3, 1, 3, p_74875_3_);
                this.func_175811_a(worldIn, Blocks.ladder.getStateFromMeta(i), 3, 2, 3, p_74875_3_);
                this.func_175811_a(worldIn, Blocks.ladder.getStateFromMeta(i), 3, 3, 3, p_74875_3_);
                this.func_175811_a(worldIn, Blocks.ladder.getStateFromMeta(i), 3, 4, 3, p_74875_3_);
            }

            this.func_175811_a(worldIn, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode), 2, 3, 1, p_74875_3_);

            for (i = 0; i < 5; ++i)
            {
                for (int j = 0; j < 5; ++j)
                {
                    this.clearCurrentPositionBlocksUpwards(worldIn, j, 6, i, p_74875_3_);
                    this.func_175808_b(worldIn, Blocks.prismarine.getDefaultState(), j, -1, i, p_74875_3_);
                }
            }

            this.spawnVillagers(worldIn, p_74875_3_, 1, 1, 2, 1);
            return true;
        }
    }
	@Override
	public boolean addComponentParts(World worldIn, Random p_74875_2_,
			StructureBoundingBox p_74875_3_) {
		// TODO Auto-generated method stub
		return false;
	}

}
