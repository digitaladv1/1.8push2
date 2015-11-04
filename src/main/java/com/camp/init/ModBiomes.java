package com.camp.init;

//import com.choonster.testmod3.config.Config;
import com.camp.biome.*;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

import static net.minecraftforge.common.BiomeDictionary.Type.*;

public class ModBiomes {
	public static CustomBiome firestone;
	public static BiomeGenDesertTest desertTest;

	public static void registerBiomes() {
		firestone = reigsterBiome(new CustomBiome(50), BiomeManager.BiomeType.WARM, 1000, FOREST, SANDY, BEACH);
		desertTest = reigsterBiome(new BiomeGenDesertTest(51), BiomeManager.BiomeType.DESERT, 1000, HOT, JUNGLE, SANDY);
	}

	private static <T extends BiomeGenBase> T reigsterBiome(T biome, BiomeManager.BiomeType biomeType, int weight, BiomeDictionary.Type... types) {
		BiomeDictionary.registerBiomeType(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(biome, weight));
		BiomeManager.addSpawnBiome(desertTest);
		BiomeManager.addSpawnBiome(firestone);
		return biome;
	}
}