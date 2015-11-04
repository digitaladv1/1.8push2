package com.camp.world;
 
import java.util.Random;
 

import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
 

import com.camp.block.BlockManager;

 
public class CustomWorldGenerator implements IWorldGenerator{
    /*
     *  Generate will be called each time a 16x16 chunk is generated
     *  Be careful how much code you add here - it gets slow very quickly!
     * 
     */
 
 
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
 
        // Check what dimension is being generated
        switch(world.provider.getDimensionId()){
        case -1:
            // Dim -1 Nether
            break;
        case 0:
            // Dim 0 Surface
            generateSurface(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
            break;
        case 1:
            // Dim 1 End
            break;
        case 2:
            // Custom Dimension with id 2
            generateCustom(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
            break;
        }
 
  
 
    }
 
    public static WorldGenMinable oreGen = new WorldGenMinable (BlockManager.splatoonBlock.getDefaultState(), 4);
 
    public void generateSurface(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
        // Code called to generate surface blocks
 
        // For loop runs 5 times - this will be how many chances to generate a vein of our ore we'll have
        for (int i = 0; i < 5; i++){
            // Randomize coordinates for ore starting position
 
            int startX = chunkX*16 + random.nextInt(16);
            // Vertical position - this sets how deep down your ore will generate. Lower numbers are deeper
            int startY = random.nextInt(16) + 50;
            int startZ = chunkZ *16 + random.nextInt(16);
 
            // Store the coordinates in a BlockPos
            BlockPos start = new BlockPos(startX, startY, startZ);
 
 
            // Create a new WorldGenMinable with custom block. This will create and place an ore vein    .
            (new WorldGenMinable(BlockManager.splatoonBlock.getDefaultState(), random.nextInt(5) + 1)).generate(world, random, start);
            // If you want to specify a special block type that your ore must start in use this instead:
            //oreGen.generate(world, random, start);
             
             
        }
 
    }
 
    public void generateCustom(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
    	 
        // Stuff to do in the custom dimension
 //chance of spawning
        if(random.nextInt(3)==0){
            int startX = chunkX *16 + random.nextInt(16);
            // Vertical position - get the top of the world
            int startY = world.getActualHeight()-1;
            int startZ = chunkZ *16 + random.nextInt(16);
 
            BlockPos pos = new BlockPos(startX, startY, startZ);
 
            while(world.getBlockState(pos) == Blocks.air.getDefaultState()){
                pos = pos.down();
                // go down until we find something that isn't air.
            }
             
             // set blocks
            world.setBlockState(pos, Blocks.obsidian.getDefaultState());
            for(int i = 0 ; i < 10; i++){
                world.setBlockState(pos.up(i), Blocks.obsidian.getDefaultState());
            }
        }
         //chance of spawning
        if(random.nextInt(1)== 0){
            // Building Generation
             
           // int startX = chunkX *16 + random.nextInt(16);
            // Vertical position - get the top of the world
            //int startY = world.getActualHeight()-1;
           // int startZ = chunkZ *16 + random.nextInt(16);
        	
        	int startX = 0;
        	int startY = 100;
        	int startZ = 0;
 
            BlockPos pos = new BlockPos(startX, startY, startZ);
 
            while(world.getBlockState(pos) == Blocks.air.getDefaultState()){
                pos = pos.down();
                // go down until we find something that isn't air.
            }
             
            startY = pos.getY();
             
            // set blocks
             
            //layer 1 - set each block to planks.
            int y = 0;
            for(int x = 0; x<5; x++){
                for(int z=0; z<6; z++){
                    pos = new BlockPos(startX + x, startY + y, startZ + z);
                    world.setBlockState(pos, Blocks.planks.getDefaultState());
                }
            }
            // layer 2-4 set outside edges to bricks, leave a gap for a door.
            for(y = 1; y< 4; y++){
                for(int x = 0; x<5; x++){
                    for(int z=0; z<6; z++){
                        pos = new BlockPos(startX + x, startY + y, startZ + z);
                        if(y< 3 && z == 3 && x == 0){
                            // Leave gap for door
                            world.setBlockState(pos, Blocks.air.getDefaultState());
                        }
                        else if(x == 0 || x == 4){
                            // Set edge blocks to brick
                            world.setBlockState(pos, Blocks.brick_block.getDefaultState());        
                        }
                        else if(z == 0 || z == 5){
                            // Set edge blocks to brick 
                            world.setBlockState(pos, Blocks.brick_block.getDefaultState());
                        }
                        else{
                            // Leave other blocks as air
                            world.setBlockState(pos, Blocks.air.getDefaultState());
                        }
                    }
                }
            }
            // layer 5
            for(int x = 0; x<5; x++){
                for(int z=0; z<6; z++){
                    pos = new BlockPos(startX + x, startY + y, startZ + z);
                    world.setBlockState(pos, Blocks.planks.getDefaultState());
                }
            }
        }
    }
}