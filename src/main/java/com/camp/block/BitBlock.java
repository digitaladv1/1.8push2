package com.camp.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BitBlock extends Block implements IMetaBlockName {
		
		public static final PropertyEnum VARIANT = PropertyEnum.create("variant", BitBlock.EnumType.class);
	    private static final String __OBFID = "CL_00000317";
	    public static final String name = "BitBlock";
	    
	    

	    public BitBlock()
	    {
	    	
	        super(Material.rock);
	        this.setUnlocalizedName(name);
	        //this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BitBlock.EnumType.OldMario));
	        this.setDefaultState(getBlockState().getBaseState().withProperty(VARIANT, BitBlock.EnumType.OldMario));
	        this.setCreativeTab(CreativeTabs.tabBlock);
	    }

	    

	    /**
	     * Get the damage value that this Block should drop
	     */
	    public int damageDropped(IBlockState state)
	    {
	        return ((BitBlock.EnumType)state.getValue(VARIANT)).getMetadata();
	    }

	    /**
	     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	     */
	    /*@SideOnly(Side.CLIENT)
	    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	    {
	    	BitBlock.EnumType[] aenumtype = BitBlock.EnumType.values();
	        int i = aenumtype.length;

	        for (int j = 0; j < i; ++j)
	        {
	        	BitBlock.EnumType enumtype = aenumtype[j];
	            list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
	        }
	    }*/
	    
	    @SideOnly(Side.CLIENT)
	    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	    {
	        list.add(new ItemStack(itemIn, 1, 0));
	        list.add(new ItemStack(itemIn, 1, 1));
	        list.add(new ItemStack(itemIn, 1, 2));
	        list.add(new ItemStack(itemIn, 1, 3));
	        list.add(new ItemStack(itemIn, 1, 4));
	        list.add(new ItemStack(itemIn, 1, 5));
	        list.add(new ItemStack(itemIn, 1, 6));
	        list.add(new ItemStack(itemIn, 1, 7));
	        list.add(new ItemStack(itemIn, 1, 8));
	        list.add(new ItemStack(itemIn, 1, 9));
	        list.add(new ItemStack(itemIn, 1, 10));
	        list.add(new ItemStack(itemIn, 1, 11));
	        list.add(new ItemStack(itemIn, 1, 12));
	        list.add(new ItemStack(itemIn, 1, 13));
	        list.add(new ItemStack(itemIn, 1, 14));
	        list.add(new ItemStack(itemIn, 1, 15));
	//        list.add(new ItemStack(itemIn, 1, 16));
	  //      list.add(new ItemStack(itemIn, 1, 17));
	    //    list.add(new ItemStack(itemIn, 1, 18));
	    }

	    
	    
	   /* *//**
	     * Convert the given metadata into a BlockState for this Block
	     **//*
	    public IBlockState getStateFromMeta(int meta)
	    {
	        return this.getDefaultState().withProperty(VARIANT, BitBlock.EnumType.byMetadata(meta));
	    }

	    *//**
	     * Convert the BlockState into the correct metadata value
	     *//*
	     *
	     */
	    public int getMetaFromState(IBlockState state)
	    {
	        return ((BitBlock.EnumType)state.getValue(VARIANT)).getMetadata();
	    }
	    
	    

	    

	    /*protected BlockState createBlockState()
	    {
	        return new BlockState(this, new IProperty[] {VARIANT});
	    }*/
	    
	  /*  public enum EnumType implements IStringSerializable {
	        WHITE(0, "white"),
	        BLACK(1, "black");

	        private int ID;
	        private String name;
	        
	        private EnumType(int ID, String name) {
	            this.ID = ID;
	            this.name = name;
	        }
	        
	        @Override
	        public String getName() {
	            return name;
	        }

	        public int getID() {
	            return ID;
	        }
	        
	        
	        @Override
	        public String toString() {
	            return getName();
	        }
		    
		    
		    @Override
		    protected BlockState createBlockState() {
		        return new BlockState(this, new IProperty[] { TYPE });
		    }
	        
	    }
	    
	    
	    @Override
	    public IBlockState getStateFromMeta(int meta) {
	        return getDefaultState().withProperty(TYPE, meta == 0 ? EnumType.WHITE : EnumType.BLACK);
	    }

	    @Override
	    public int getMetaFromState(IBlockState state) {
	        EnumType type = (EnumType) state.getValue(TYPE);
	        return type.getID();
	    }
	    
	    @Override
	    public int damageDropped(IBlockState state) {
	        return getMetaFromState(state);
	    }
	    
	    @Override
	    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
	        list.add(new ItemStack(itemIn, 1, 0)); //Meta 0
	        list.add(new ItemStack(itemIn, 1, 1)); //Meta 1
	    }
	    
	    
	    @Override
	    public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos) {
	        return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
	    }
	    
	    */

	    public static enum EnumType implements IStringSerializable
	    {
	        OldMario(0, "mario"),
	        NewMario(1, "modernMario"),
	        OldMarioBig(2, "superMario"),
	        NewMarioBig(3, "modernSuperMario"),
	        OldMarioFire(4, "fireMario"),
	        NewMarioFire(5, "modernFireMario"),
	        OldMarioWierd(6, "wierdMario"),
	    	NewMarioWierd(7, "modernWierdMario"),
	    	OldLuigi(8, "luigi"),
	    	NewLuigi(9, "modernLuigi"),
	    	OldLuigiBig(10, "superLuigi"),
	    	NewLuigiBig(11, "modernSuperLuigi"),
	    	OldLuigiFire(12, "fireLuigi"),
	    	NewLuigiFire(13, "modernFireLuigi"),
	    	OldLuigiWierd(14, "wierdLuigi"),
	    	NewLuigiWierd(15, "modernWierdLuigi"),;
//	    	Peach(16, "peach"),
	//    	Toad(17, "toad"),
	  //  	Bowser(18, "bowser"),;
	        /** Array of the Block's BlockStates */
	        private static final BitBlock.EnumType[] META_LOOKUP = new BitBlock.EnumType[values().length];
	        /** The BlockState's metadata. */
	        private int meta;
	        /** The EnumType's name. */
	        private final String name;
	        private final String unlocalizedName;
	        

	        private static final String __OBFID = "CL_00002058";

	        private EnumType(int meta, String name)
	        {
	            this(meta, name, name);
	        }

	        private EnumType(int meta, String name, String unlocalizedName)
	        {
	            this.meta = meta;
	            this.name = name;
	            this.unlocalizedName = unlocalizedName;
	        }

	        /**
	         * Returns the EnumType's metadata value.
	         */
	        public int getMetadata()
	        {
	            return this.meta;
	        }

	        public String toString()
	        {
	            return this.name;
	        }

	        /**
	         * Returns an EnumType for the BlockState from a metadata value.
	         */
	        public static BitBlock.EnumType byMetadata(int meta)
	        {
	            if (meta < 0 || meta >= META_LOOKUP.length)
	            {
	                meta = 0;
	            }

	            return META_LOOKUP[meta];
	        }

	        public String getName()
	        {
	            return this.name;
	        }

	        public String getUnlocalizedName()
	        {
	            return this.unlocalizedName;
	        }

	        static
	        {
	            BitBlock.EnumType[] var0 = values();
	            int var1 = var0.length;

	            for (int var2 = 0; var2 < var1; ++var2)
	            {
	            	BitBlock.EnumType var3 = var0[var2];
	                META_LOOKUP[var3.getMetadata()] = var3;
	            }
	        }
	        
	    }

	@Override
	public String getSpecialName(ItemStack stack) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/*protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {VARIANT});
    }*/
	
	
	
	
	
	
	
	public int getDamageValue(World worldIn, BlockPos pos)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        return iblockstate.getBlock().getMetaFromState(iblockstate) & 3;
    }
	
	
	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, VARIANT);
	}

	

	@Override
	public IBlockState getStateFromMeta(int meta) {
	//	.EnumType.int facingIndex = meta & 7; // Extract the facing index (lowest three bits)
		//EnumFacing facing = EnumFacing.getFront(facingIndex); // Convert it to the corresponding EnumFacing

		//boolean lit = (meta & 8) != 0; // Extract the lit state (highest bit)

		return getDefaultState().cycleProperty(VARIANT);
	}
	
	
	
	
	

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		IBlockState newState;

		if (playerIn.isSneaking()) {
			newState = state.cycleProperty(VARIANT); // Cycle the facing (down -> up -> north -> south -> west -> east -> down)
		} else {
			newState = state.cycleProperty(VARIANT); // Cycle the lit state (true -> false -> true)
		}

		worldIn.setBlockState(pos, newState);

		return true;
	}
	

	public BitBlock setBlockName(String string) {
		// TODO Auto-generated method stub
		return this;
	}

}
