package com.camp.block;
 
import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCommandBlock;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
 
 
public class BlockManager {
 
	public static final Set<Block> blocks = new HashSet<>();

    public static SplatoonBlock splatoonBlock;
    /*public static ColoredWood coloredWood;
    public static IBlockState coloredWoodBlack;
    public static IBlockState coloredWoodGreen;
    public static IBlockState coloredWoodMagenta;
    public static IBlockState coloredWoodOrange;
    public static IBlockState coloredWoodBrown;
    public static IBlockState coloredWoodCyan;
    public static IBlockState coloredWoodGrey;
    public static IBlockState coloredWoodPink;
    public static IBlockState coloredWoodLime;
    public static IBlockState coloredWoodLightBlue;
    public static IBlockState coloredWoodPurple;
    public static IBlockState coloredWoodYellow;
    public static IBlockState coloredWoodRed;
    public static IBlockState coloredWoodSilver;
    public static IBlockState coloredWoodBlue;
    public static IBlockState coloredWoodWhite;*/
    public static OreBlock oreBlock;
    public static TestBlock testBlock;
    public static OneTimeBlock oneTimeBlock;
    public static TrampolineBlock trampolineBlock;
    public static SmashBlock smashBlock;
    public static CustomPortalBlock customPortalBlock;
    public static BlockCommandBlock commandBlock;
    public static CustomBarrier customBarrier;
    public static BlockDragonEgg dragonEgg;
    public static DeathBlock deathBlock;
    public static ChoonsterBlock choonsterBlock;
    public static CustomSponge customSponge;
    public static BlockPig blockPig;
    public static AmericanOre AmericanOre;
    public static SlipperyBlock slipperyBlock;
    public static SlipperyBlock poweredSlipperyBlock;
    public static HiddenBlock hiddenBlock;
    public static HiddenBlock poweredHiddenBlock;
    public static SpecialBlock specialBlock;
  //  public static BlockProperties propertyBlock;
   // public static BluestoneWire bluestoneWire;
    public static CustomCake customCake;
   // public static BlockProperties bitBlock;
    public static BitBlock mario;
    public static BitBlock modernMario;
    public static BitBlock superMario;
    public static BitBlock modernSuperMario;
    public static BitBlock fireMario;
    public static BitBlock modernFireMario;
    public static BitBlock wierdMario;
    public static BitBlock modernWierdMario;
    public static BitBlock luigi;
    public static BitBlock modernLuigi;
    public static BitBlock superLuigi;
    public static BitBlock modernSuperLuigi;
    public static BitBlock fireLuigi;
    public static BitBlock modernFireLuigi;
    public static BitBlock wierdLuigi;
    public static BitBlock modernWierdLuigi;
    public static BitBlock peach;
    public static BitBlock toad;
    public static BitBlock bowser;
    public static BlockProperties propertyBlock;
    public static BitBlock bitBlock;
     
    public static void mainRegistry() {
        initializeBlock();
        registerBlock();
    }
 
    public static void initializeBlock() {
    	/*coloredWood = new ColoredWood();
    	coloredWoodWhite = new ColoredWood().getStateFromMeta(0);
    	coloredWoodOrange = new ColoredWood().getStateFromMeta(1);
    	coloredWoodMagenta = new ColoredWood().getStateFromMeta(2);
    	coloredWoodGreen = new ColoredWood().getStateFromMeta(13);
    	coloredWoodBrown = new ColoredWood().getStateFromMeta(12);
    	coloredWoodCyan = new ColoredWood().getStateFromMeta(9);
    	coloredWoodGrey = new ColoredWood().getStateFromMeta(7);
    	coloredWoodPink = new ColoredWood().getStateFromMeta(6);
    	coloredWoodLime = new ColoredWood().getStateFromMeta(5);
    	coloredWoodLightBlue = new ColoredWood().getStateFromMeta(3);
    	coloredWoodPurple = new ColoredWood().getStateFromMeta(10);
    	coloredWoodYellow = new ColoredWood().getStateFromMeta(4);
    	coloredWoodRed = new ColoredWood().getStateFromMeta(14);
    	coloredWoodSilver = new ColoredWood().getStateFromMeta(8);
    	coloredWoodBlue = new ColoredWood().getStateFromMeta(11);
    	coloredWoodBlack = new ColoredWood().getStateFromMeta(15);*/
    //	propertyBlock= new BlockProperties("property_block", Material.rock, 50, 50);
    	customCake = new CustomCake();
    	oreBlock = new OreBlock();
    	testBlock = new TestBlock();
    	hiddenBlock = new HiddenBlock(false);
    	poweredHiddenBlock = new HiddenBlock(true);
    	slipperyBlock = new SlipperyBlock(false);
    	poweredSlipperyBlock = new SlipperyBlock(true);
    	oneTimeBlock = new OneTimeBlock(Material.barrier);
    	AmericanOre = new AmericanOre();
    	customSponge = new CustomSponge();
    	trampolineBlock = new TrampolineBlock();
    	choonsterBlock = new ChoonsterBlock();
        splatoonBlock = new SplatoonBlock();
        smashBlock = new SmashBlock();
        customPortalBlock = new CustomPortalBlock();
        commandBlock = (BlockCommandBlock) new BlockCommandBlock().setCreativeTab(CreativeTabs.tabRedstone);
        customBarrier = new CustomBarrier();
        dragonEgg = (BlockDragonEgg) new BlockDragonEgg().setCreativeTab(CreativeTabs.tabMisc);
        deathBlock = new DeathBlock();
        blockPig = new BlockPig();
        specialBlock = new SpecialBlock();
        bitBlock = registerBlock(new BitBlock());
        
       // bluestoneWire= new BluestoneWire();
        /*mario = new BitBlock(0);
        modernMario = new BitBlock(1);
        superMario = new BitBlock(2);
        modernSuperMario = new BitBlock(3);
        fireMario = new BitBlock(4);
        modernFireMario = new BitBlock(5);
        wierdMario = new BitBlock(6);
        modernWierdMario = new BitBlock(7);
        luigi = new BitBlock(8);
        modernLuigi = new BitBlock(9);
        superLuigi = new BitBlock(10);
        modernSuperLuigi = new BitBlock(11);
        fireLuigi = new BitBlock(12);
        modernFireLuigi = new BitBlock(13);
        wierdLuigi = new BitBlock(14);
        modernWierdLuigi = new BitBlock(15);
        peach = new BitBlock(16);
        toad = new BitBlock(17);
        bowser = new BitBlock(18);*/
    }
 
    private static <T extends Block> T registerBlock(T block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName().replaceFirst("tile.", ""));
		blocks.add(block);
		return block;
	}

    
    public static void registerBlock() {
    	/*GameRegistry.registerBlock(mario, mario.name+"0");
    	GameRegistry.registerBlock(modernMario, modernMario.name+"1");
    	GameRegistry.registerBlock(superMario, superMario.name+"2");
    	GameRegistry.registerBlock(modernSuperMario, modernSuperMario.name+"3");
    	GameRegistry.registerBlock(fireMario, fireMario.name+"4");
    	GameRegistry.registerBlock(modernFireMario, modernFireMario.name+"5");
    	GameRegistry.registerBlock(wierdMario, wierdMario.name+"6");
    	GameRegistry.registerBlock(modernWierdMario, modernWierdMario.name+"7");
    	GameRegistry.registerBlock(luigi, luigi.name+"8");
    	GameRegistry.registerBlock(modernLuigi, modernLuigi.name+"9");
    	GameRegistry.registerBlock(superLuigi, superLuigi.name+"10");
    	GameRegistry.registerBlock(modernSuperLuigi, modernSuperLuigi.name+"11");
    	GameRegistry.registerBlock(fireLuigi, fireLuigi.name+"12");
    	GameRegistry.registerBlock(modernFireLuigi, modernFireLuigi.name+"13");
    	GameRegistry.registerBlock(wierdLuigi, wierdLuigi.name+"14");
    	GameRegistry.registerBlock(modernWierdLuigi, modernWierdLuigi.name+"15");
    	GameRegistry.registerBlock(peach, peach.name+"16");
    	GameRegistry.registerBlock(toad, toad.name+"17");
    	GameRegistry.registerBlock(bowser, bowser.name+"18");*/
    	GameRegistry.registerBlock(customCake, customCake.name);
    	GameRegistry.registerBlock(oreBlock, oreBlock.name);
    //	GameRegistry.registerBlock(coloredWood, ColoredWood.name);
    	//GameRegistry.registerBlock(propertyBlock = new BlockProperties("block_properties"), ItemBlockMeta.class, "block_properties");
    	GameRegistry.registerBlock(testBlock, testBlock.name);
   // 	GameRegistry.registerBlock(poweredHiddenBlock, poweredHiddenBlock.nameOn);
    //	GameRegistry.registerBlock(hiddenBlock, hiddenBlock.name);
    	GameRegistry.registerBlock(poweredSlipperyBlock, poweredSlipperyBlock.nameOn);
    	GameRegistry.registerBlock(slipperyBlock, slipperyBlock.name);
    	GameRegistry.registerBlock(oneTimeBlock, oneTimeBlock.name);
    	GameRegistry.registerBlock(AmericanOre, AmericanOre.name);
        GameRegistry.registerBlock(splatoonBlock, splatoonBlock.name);
        GameRegistry.registerBlock(trampolineBlock, trampolineBlock.name);
        GameRegistry.registerBlock(smashBlock, smashBlock.name);
        GameRegistry.registerBlock(customPortalBlock, customPortalBlock.name);
        GameRegistry.registerBlock(deathBlock, deathBlock.name);
        GameRegistry.registerBlock(choonsterBlock, choonsterBlock.name);
        GameRegistry.registerBlock(blockPig, blockPig.name);
        GameRegistry.registerBlock(specialBlock, specialBlock.name);
       // GameRegistry.registerBlock(bitBlock, bitBlock.name);
        
       // GameRegistry.registerBlock(bluestoneWire, bluestoneWire.name);
//        GameRegistry.registerBlock(commandBlock, "CommandBlock");
  //      GameRegistry.registerBlock(customBarrier, "CustomBarrier");
    //    GameRegistry.registerBlock(dragonEgg, "DragonEgg");
        
        
       // GameRegistry.registerBlock(propertyBlock = new BlockProperties("block_properties", Material.rock, 50, 50), ItemBlockMeta.class, "block_properties");



        
    }
 
}