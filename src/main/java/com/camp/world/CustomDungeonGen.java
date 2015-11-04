package com.camp.world;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class CustomDungeonGen implements IWorldGenerator
{
public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
{
switch (world.provider.getDimensionId())
{
case -1: generateNether(world, random, chunkX*16, chunkZ*16);
case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
}
}
private void generateSurface(World world, Random rand, int chunkX, int chunkZ)
{
CustomDungeon tree = new CustomDungeon();

for(int x = 0;x<2;x++)
{
int i = chunkX + rand.nextInt(16);
int k = chunkZ + rand.nextInt(16);
int j = world.getHeight();
tree.generate(world, rand, new BlockPos(i, k, j));
}

}
private void generateNether(World world, Random random, int blockX, int blockZ)
{
}
}