package com.camp.world;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.StructureVillagePieces.Village;
import net.minecraftforge.fml.common.registry.FMLControlledNamespacedRegistry;
import net.minecraftforge.fml.common.registry.GameData;

public class CustomHouse extends Village{
	Random randomGenerator = new Random();
	int number = randomGenerator.nextInt(2);
	
	private static final String __OBFID = "CL_00000517";
	private static IBlockState array[];
	//private static String allBlocks[]();
    public CustomHouse() {
    	
    }

    public CustomHouse(StructureVillagePieces.Start p_i45571_1_, int p_i45571_2_, Random p_i45571_3_, StructureBoundingBox p_i45571_4_, EnumFacing p_i45571_5_)
    {
        super(p_i45571_1_, p_i45571_2_);
        //number=0;
    	array = new IBlockState[2];
    	array[0] = Blocks.enchanting_table.getDefaultState();
    	array[1] = Blocks.prismarine.getStateFromMeta(1);
        this.coordBaseMode = p_i45571_5_;
        this.boundingBox = p_i45571_4_;
    }

    public static CustomHouse func_175850_a(StructureVillagePieces.Start p_175850_0_, List p_175850_1_, Random p_175850_2_, int p_175850_3_, int p_175850_4_, int p_175850_5_, EnumFacing p_175850_6_, int p_175850_7_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p_175850_3_, p_175850_4_, p_175850_5_, 0, 0, 0, 9, 9, 6, p_175850_6_);
        return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_175850_1_, structureboundingbox) == null ? new CustomHouse(p_175850_0_, p_175850_7_, p_175850_2_, structureboundingbox, p_175850_6_) : null;
    }

    public boolean addComponentParts(World worldIn, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if (this.field_143015_k < 0)
        {
            this.field_143015_k = this.getAverageGroundLevel(worldIn, p_74875_3_);

            if (this.field_143015_k < 0)
            {
                return true;
            }

            this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 9 - 1, 0);
        }

        this.func_175804_a(worldIn, p_74875_3_, 1, 1, 1, 7, 5, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
        this.func_175804_a(worldIn, p_74875_3_, 0, 0, 0, 8, 0, 5, Blocks.quartz_block.getDefaultState(), Blocks.quartz_block.getDefaultState(), false);
        this.func_175804_a(worldIn, p_74875_3_, 0, 5, 0, 8, 5, 5, Blocks.quartz_block.getDefaultState(), Blocks.quartz_block.getDefaultState(), false);
        this.func_175804_a(worldIn, p_74875_3_, 0, 6, 1, 8, 6, 4, Blocks.quartz_block.getDefaultState(), Blocks.quartz_block.getDefaultState(), false);
        this.func_175804_a(worldIn, p_74875_3_, 0, 7, 2, 8, 7, 3, Blocks.quartz_block.getDefaultState(), Blocks.quartz_block.getDefaultState(), false);
        int i = this.getMetadataWithOffset(Blocks.nether_brick_stairs, 3);
        int j = this.getMetadataWithOffset(Blocks.nether_brick_stairs, 2);
        int k;
        int l;

        for (k = -1; k <= 2; ++k)
        {
            for (l = 0; l <= 8; ++l)
            {
                this.func_175811_a(worldIn, Blocks.nether_brick_stairs.getStateFromMeta(i), l, 6 + k, k, p_74875_3_);
                this.func_175811_a(worldIn, Blocks.nether_brick_stairs.getStateFromMeta(j), l, 6 + k, 5 - k, p_74875_3_);
            }
        }

        this.func_175804_a(worldIn, p_74875_3_, 0, 1, 0, 0, 1, 5, Blocks.quartz_block.getDefaultState(), Blocks.quartz_block.getDefaultState(), false);
        this.func_175804_a(worldIn, p_74875_3_, 1, 1, 5, 8, 1, 5, Blocks.quartz_block.getDefaultState(), Blocks.quartz_block.getDefaultState(), false);
        this.func_175804_a(worldIn, p_74875_3_, 8, 1, 0, 8, 1, 4, Blocks.quartz_block.getDefaultState(), Blocks.quartz_block.getDefaultState(), false);
        this.func_175804_a(worldIn, p_74875_3_, 2, 1, 0, 7, 1, 0, Blocks.quartz_block.getDefaultState(), Blocks.quartz_block.getDefaultState(), false);
        this.func_175804_a(worldIn, p_74875_3_, 0, 2, 0, 0, 4, 0, Blocks.quartz_block.getDefaultState(), Blocks.quartz_block.getDefaultState(), false);
        this.func_175804_a(worldIn, p_74875_3_, 0, 2, 5, 0, 4, 5, Blocks.quartz_block.getDefaultState(), Blocks.quartz_block.getDefaultState(), false);
        this.func_175804_a(worldIn, p_74875_3_, 8, 2, 5, 8, 4, 5, Blocks.quartz_block.getDefaultState(), Blocks.quartz_block.getDefaultState(), false);
        this.func_175804_a(worldIn, p_74875_3_, 8, 2, 0, 8, 4, 0, Blocks.quartz_block.getDefaultState(), Blocks.quartz_block.getDefaultState(), false);
        this.func_175804_a(worldIn, p_74875_3_, 0, 2, 1, 0, 4, 4, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
        this.func_175804_a(worldIn, p_74875_3_, 1, 2, 5, 7, 4, 5, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
        this.func_175804_a(worldIn, p_74875_3_, 8, 2, 1, 8, 4, 4, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
        this.func_175804_a(worldIn, p_74875_3_, 1, 2, 0, 7, 4, 0, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
        this.func_175811_a(worldIn, Blocks.iron_bars.getDefaultState(), 4, 2, 0, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.iron_bars.getDefaultState(), 5, 2, 0, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.iron_bars.getDefaultState(), 6, 2, 0, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.iron_bars.getDefaultState(), 4, 3, 0, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.iron_bars.getDefaultState(), 5, 3, 0, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.iron_bars.getDefaultState(), 6, 3, 0, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.iron_bars.getDefaultState(), 0, 2, 2, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.iron_bars.getDefaultState(), 0, 2, 3, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.iron_bars.getDefaultState(), 0, 3, 2, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.iron_bars.getDefaultState(), 0, 3, 3, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.iron_bars.getDefaultState(), 8, 2, 2, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.iron_bars.getDefaultState(), 8, 2, 3, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.iron_bars.getDefaultState(), 8, 3, 2, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.iron_bars.getDefaultState(), 8, 3, 3, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.iron_bars.getDefaultState(), 2, 2, 5, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.iron_bars.getDefaultState(), 3, 2, 5, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.iron_bars.getDefaultState(), 5, 2, 5, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.iron_bars.getDefaultState(), 6, 2, 5, p_74875_3_);
        this.func_175804_a(worldIn, p_74875_3_, 1, 4, 1, 7, 4, 1, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
        this.func_175804_a(worldIn, p_74875_3_, 1, 4, 4, 7, 4, 4, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
        this.func_175804_a(worldIn, p_74875_3_, 1, 3, 4, 7, 3, 4, Blocks.bookshelf.getDefaultState(), Blocks.bookshelf.getDefaultState(), false);
        this.func_175811_a(worldIn, Blocks.nether_brick.getDefaultState(), 7, 1, 4, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.nether_brick_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.nether_brick_stairs, 0)), 7, 1, 3, p_74875_3_);
        k = this.getMetadataWithOffset(Blocks.nether_brick_stairs, 3);
        this.func_175811_a(worldIn, Blocks.nether_brick_stairs.getStateFromMeta(k), 6, 1, 4, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.nether_brick_stairs.getStateFromMeta(k), 5, 1, 4, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.nether_brick_stairs.getStateFromMeta(k), 4, 1, 4, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.nether_brick_stairs.getStateFromMeta(k), 3, 1, 4, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.nether_brick_fence.getDefaultState(), 6, 1, 3, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.wooden_pressure_plate.getDefaultState(), 6, 2, 3, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.nether_brick_fence.getDefaultState(), 4, 1, 3, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.wooden_pressure_plate.getDefaultState(), 4, 2, 3, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.enchanting_table.getDefaultState(), 7, 1, 1, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.air.getDefaultState(), 1, 1, 0, p_74875_3_);
        this.func_175811_a(worldIn, Blocks.air.getDefaultState(), 1, 2, 0, p_74875_3_);
        this.func_175810_a(worldIn, p_74875_3_, p_74875_2_, 1, 1, 0, EnumFacing.getHorizontal(this.getMetadataWithOffset(Blocks.oak_door, 1)));

        if (this.func_175807_a(worldIn, 1, 0, -1, p_74875_3_).getBlock().getMaterial() == Material.air && this.func_175807_a(worldIn, 1, -1, -1, p_74875_3_).getBlock().getMaterial() != Material.air)
        {
            this.func_175811_a(worldIn, Blocks.quartz_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.quartz_stairs, 3)), 1, 0, -1, p_74875_3_);
        }

        for (l = 0; l < 6; ++l)
        {
            for (int i1 = 0; i1 < 9; ++i1)
            {
                this.clearCurrentPositionBlocksUpwards(worldIn, i1, 9, l, p_74875_3_);
                this.func_175808_b(worldIn, Blocks.nether_brick.getDefaultState(), i1, -1, l, p_74875_3_);
            }
        }

        this.spawnVillagers(worldIn, p_74875_3_, 2, 1, 2, 1);
        return true;
    }

    protected int func_180779_c(int p_180779_1_, int p_180779_2_)
    {
        return 1;
    }
}
