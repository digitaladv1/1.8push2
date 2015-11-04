package com.camp.biome;
 
import java.util.ArrayList;
import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.structure.MapGenVillage;

import com.camp.Logger;
 
//import com.camp.entity.CustomMob;
 
public class CustomBiome extends BiomeGenBase {
	private boolean logged = true;
 
    public CustomBiome(int id) {
        super(id);
        this.setColor(0x12034e);
        // TODO Auto-generated constructor stub
        this.fillerBlock = Blocks.obsidian.getStateFromMeta(1);
        this.topBlock = Blocks.soul_sand.getDefaultState();
        this.waterColorMultiplier = 0x9b30ff;
        
        this.theBiomeDecorator.treesPerChunk = 8;
        this.theBiomeDecorator.generateLakes = true;
        net.minecraftforge.common.BiomeManager.strongHoldBiomes.add(this);
        
        
    }
    
    @SuppressWarnings("unchecked")
    public static void addVillageBiome(BiomeGenBase biome, boolean canSpawn)
    {
        if (!MapGenVillage.villageSpawnBiomes.contains(biome))
        {
            ArrayList<BiomeGenBase> biomes = new ArrayList<BiomeGenBase>(MapGenVillage.villageSpawnBiomes);
            biomes.add(biome);
            MapGenVillage.villageSpawnBiomes = biomes;
        }
    }
	
	
    @Override
	public void genTerrainBlocks(World worldIn, Random random, ChunkPrimer chunkPrimer, int x, int z, double stoneNoise) {
		super.genTerrainBlocks(worldIn, random, chunkPrimer, x, z, stoneNoise);

		if (!logged) {
			logged = true;
			Logger.info("Generating desert test at %d,%d", x, z);
		}
	}
	
	public static void addSpawnBiome(BiomeGenBase biome)
    {
        if (!WorldChunkManager.allowedBiomes.contains(biome))
        {
            WorldChunkManager.allowedBiomes.add(biome);
        }
    }
 
 
}