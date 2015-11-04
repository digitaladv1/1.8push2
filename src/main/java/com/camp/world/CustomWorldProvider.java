package com.camp.world;
 
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderFlat;
 
public class CustomWorldProvider extends WorldProvider{
 
    @Override
    public String getDimensionName() {
        // TODO Auto-generated method stub
        return "CustomLand";
    }
 
    @Override
    public String getInternalNameSuffix() {
        // TODO Auto-generated method stub
        return "custom";
    }
 
    public double getMovementFactor()
    {
        return 8.0;
    }
     
     
    public IChunkProvider createChunkGenerator(){
        return new CustomChunkProvider(worldObj, this.getSeed(), true, this.worldObj.getWorldInfo().getGeneratorOptions());
    }
}
     
     
 
 
