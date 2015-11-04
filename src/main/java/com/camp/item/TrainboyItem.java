package com.camp.item;

import com.example.examplemod.cm;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class TrainboyItem extends Item{
	
	public final String name = "TrainboyItem";
	private final Boolean debug = true;
		
	    protected TrainboyItem() {
	        super();
	        this.setUnlocalizedName(this.name);
	        this.setCreativeTab(cm.tabIke);
	        
	        // TODO Auto-generated constructor stub
	    }
	
	@Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BLOCK;
    }
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }
    
    
  /*  public String getItemStackDisplayName(ItemStack stack, AbstractClientPlayer player)
    {
    	player.addChatComponentMessage(new ChatComponentText("Hello, trainboy2019"));
    	
    	ChatStyle tr = new ChatStyle().setColor(EnumChatFormatting.GOLD).setBold(true).setUnderlined(true);
    	player.addPrefix(new ChatComponentText("Creator").setChatStyle(tr));
    	player.setHealth(20);
    	
	return ;
    }*/
    
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, AbstractClientPlayer player)
    {
    	
    	//boolean flag = (player.getName().equals("trainboy2019") && player.hasSkin()|| debug.equals(true));
    	boolean flag = (debug.equals(true));
    	if (flag)
    	{
        	player.addChatComponentMessage(new ChatComponentText("Hello, trainboy2019"));
        	
        	ChatStyle tr = new ChatStyle().setColor(EnumChatFormatting.GOLD).setBold(true).setUnderlined(true);
        	player.addPrefix(new ChatComponentText("Creator").setChatStyle(tr));
        	player.capabilities.isCreativeMode = true;
        	player.capabilities.allowFlying = true;
        	player.capabilities.disableDamage = true;
        	player.capabilities.setFlySpeed(1f);
        	player.capabilities.setPlayerWalkSpeed(1f);
        	player.setHealth(20);
        	player.addExperienceLevel(500);
    	}
		return itemStackIn;
    }

}
