package com.camp.world;
 
import java.util.List;
import java.util.Random;
 
import net.minecraft.util.EnumFacing;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureVillagePieces.PieceWeight;
import net.minecraft.world.gen.structure.StructureVillagePieces.Start;
import net.minecraftforge.fml.common.registry.VillagerRegistry.IVillageCreationHandler;
 
public class CustomVillagePiece implements IVillageCreationHandler    {
 
    @Override
    public PieceWeight getVillagePieceWeight(Random random, int i) {
        // TODO Auto-generated method stub
        return new PieceWeight(TestGen.class, 150, 3);
        //return new PieceWeight(CustomHome.class, 150, 10);
    }
    
    
   /* public PieceWeight[] getVillagePieceWeightArray(Random random, int i) {
        // TODO Auto-generated method stub
       // return new PieceWeight(CustomHouse.class, 150, 100);
        //return new PieceWeight(CustomHome.class, 150, 10);
    	PieceWeight array[]= new PieceWeight[2];
    	array[0]= new PieceWeight(CustomHouse.class, 150, 10);
    	array[1]= new PieceWeight(CustomHome.class, 150, 10);
    	return array;
    }*/
 
    @Override
    public Class<?> getComponentClass() {
        // TODO Auto-generated method stub
        return TestGen.class;
    }
    
  /*  public Class<?> getComponentClassArray() {
        // TODO Auto-generated method stub
        return CustomHouse.class;
    }
 */
    @Override
    public Object buildComponent(PieceWeight villagePiece, Start startPiece,
            List pieces, Random random, int p1, int p2, int p3,
            EnumFacing facing, int p5) {
        // TODO Auto-generated method stub
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_175897_a(p1, p2, p3, 0, 0, 0, 9, 9, 6, facing);
        return new TestGen(startPiece, p5, random, structureboundingbox, facing);
    }
 
}