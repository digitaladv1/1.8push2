package com.camp.world.gen;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;


//import com.bedrockminer.tutorial.block.ModBlocks;
import com.camp.block.BlockManager;

public class ModWorldGen implements IWorldGenerator {

	
	private WorldGenerator gen_overworldAmerica;

	public ModWorldGen() {
		this.gen_overworldAmerica = new WorldGenMinable((IBlockState) BlockManager.AmericanOre, 15);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.getDimensionId()) {
		case 0: //Overworld
			this.runGenerator(this.gen_overworldAmerica, world, random, chunkX * 16, chunkZ * 16, 35, 0, 64);
			//this.runGenerator(this.gen_multi_ore, world, random, chunkX * 16, chunkZ * 16, 10, 0, 16);
			break;
		case -1: //Nether

			break;
		case 1: //End
			
			break;
		}
	}

	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
    	if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
    		throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

    	int heightDiff = maxHeight - minHeight;
    	for (int i = 0; i < chancesToSpawn; i ++) {
    		int x = chunk_X + rand.nextInt(16);
    		int y = minHeight + rand.nextInt(heightDiff);
    		int z = chunk_Z + rand.nextInt(16);
    		generator.generate(world, rand, null);
    	}
    }
}