package com.camp.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.camp.block.BlockManager;

public class OrangeWorldGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimensionId()){
			case 0: generateOverworld(random, world, chunkX * 16, chunkZ * 16); break;
			case 1: generateEnd(random, world, chunkX * 16, chunkZ * 16); break;
			case -1: generateNether(random, world, chunkX * 16, chunkZ * 16); break;
			default: generateOverworld(random, world, chunkX * 16, chunkZ * 16);
		}
		
	}

	private void generateOverworld(Random random, World world, int x, int z) {
		//addOresOverworld(Block to spawn <BlockManager.***>, world, random, x, z, minVainSize, maxVainSize, chanceToSpawn, minY, maxY);
		
		addOresOverworld(BlockManager.AmericanOre, world, random, x, z, 3, 10, 20, 8, 20);
	}

	private void generateEnd(Random random, World world, int x, int z) {
		//addOresEnd(Block to spawn <BlockManager.***>, world, random, x, z, minVainSize, maxVainSize, chanceToSpawn, minY, maxY);
		
	}

	private void generateNether(Random random, World world, int x, int z) {
		//addOresNether(Block to spawn <BlockManager.***>, world, random, x, z, minVainSize, maxVainSize, chanceToSpawn, minY, maxY);
		
	}
	
	
    /**
    *
    * This method adds our block to the world.
    * It randomizes the coordinates, and does that as many times, as defined in spawnChance.
    * Then it gives all the params to WorldGenMinable, which handles the replacing of the ores for us.
    *
    * @param block The block you want to spawn
    * @param world The world
    * @param random The Random
    * @param blockXPos the blockXpos of a chunk
    * @param blockZPos the blockZpos of a chunk
    * @param minVeinSize min vein
    * @param maxVeinSize max vein
    * @param chancesToSpawn the chance to spawn. Usually around 2
    * @param minY lowest point to spawn
    * @param maxY highest point to spawn
    */

   public void addOresOverworld(Block block, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY )
   {
       WorldGenMinable minable = new WorldGenMinable(null, maxY);
       for(int i = 0; i < chancesToSpawn; i++)
       {
           int posX = blockXPos + random.nextInt(16);
           int posY = minY + random.nextInt(maxY - minY);
           int posZ = blockZPos + random.nextInt(16);
          // minable.generate(world, random, null);
       }
   }
   
   
   public void addOresEnd(Block block, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY )
   {
	   WorldGenMinable minable = new WorldGenMinable(null, maxY);
       for(int i = 0; i < chancesToSpawn; i++)
       {
           int posX = blockXPos + random.nextInt(16);
           int posY = minY + random.nextInt(maxY - minY);
           int posZ = blockZPos + random.nextInt(16);
          // minable.generate(world, random, null);
       }
   }
   
   public void addOresNether(Block block, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY )
   {
	   WorldGenMinable minable = new WorldGenMinable(null, maxY);
       for(int i = 0; i < chancesToSpawn; i++)
       {
           int posX = blockXPos + random.nextInt(16);
           int posY = minY + random.nextInt(maxY - minY);
           int posZ = blockZPos + random.nextInt(16);
         //  minable.generate(world, random, null);
       }
   }

}
