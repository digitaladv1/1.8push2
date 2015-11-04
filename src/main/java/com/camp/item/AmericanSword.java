package com.camp.item;
 
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.stats.StatList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings.GameType;

import com.example.examplemod.cm;
import com.google.common.collect.Multimap;
 
public class AmericanSword extends ItemSword{
	
	
	
 
    public final String name = "AmericanSword";
  //  public static String message = "Test";
    //IChatComponent appendText("Test");

    //public static Boolean op = false;
    public static int op = 0;
     
    protected AmericanSword(ToolMaterial material) {
        super(material);
        this.setUnlocalizedName(this.name);
        this.setCreativeTab(cm.tabIke);
        
        // TODO Auto-generated constructor stub
    }
    @Override
    public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        {
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new 
        		AttributeModifier("Weapon modifier", 100, 0));
        return multimap;
        }
    }
    
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityPlayer playerIn, int timeLeft)
    {
    	EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack);
    	EnchantmentHelper.getEnchantmentLevel(Enchantment.smite.effectId, stack);
    	EnchantmentHelper.getEnchantmentLevel(Enchantment.baneOfArthropods.effectId, stack);
    	EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, stack);
        int j = 20;
        net.minecraftforge.event.entity.player.ArrowLooseEvent event = new net.minecraftforge.event.entity.player.ArrowLooseEvent(playerIn, stack, j);
        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return;
        j = event.charge;

        boolean flag = playerIn.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;

        if (flag || playerIn.inventory.hasItem(ItemManager.americanIngot))
        {
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if ((double)f < 0.1D)
            {
                return;
            }

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            EntityArrow entityarrow = new EntityArrow(worldIn, playerIn, f * 2.0F);

            if (f == 1.0F)
            {
            	
            	entityarrow.setIsCritical(true);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);

            if (k > 0)
            {
                entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
            }

            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);

            if (l > 0)
            {
                entityarrow.setKnockbackStrength(l);
            }
            
            int m = EnchantmentHelper.getEnchantmentLevel(Enchantment.aquaAffinity.effectId, stack);

            if (m > 0)
            {
                entityarrow.noClip=true;
            }
            
            int n = EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, stack);

            if (n > 0)
            {
                entityarrow.setIsCritical(true);
            }
            
            int o = EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, stack);

            if (o > 0)
            {
                entityarrow.setDamage(entityarrow.getDamage() * (double)k * 0.5D + 0.5D);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack) > 0)
            {
                entityarrow.setFire(100);
            }

            stack.damageItem(1, playerIn);
            worldIn.playSoundAtEntity(playerIn, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (flag)
            {
                entityarrow.canBePickedUp = 2;
                playerIn.addChatComponentMessage(new ChatComponentText("Test Flag"));
            }
            else
            {
            	playerIn.addChatComponentMessage(new ChatComponentText("Test Else"));
            	playerIn.inventory.consumeInventoryItem(ItemManager.americanIngot);
                playerIn.inventory.addItemStackToInventory(new ItemStack(ItemManager.americanIngot));
            }
            /*if (flag)
            {
                entityarrow.canBePickedUp = 2;
            }
            else if(playerIn.inventory.hasItem(ItemManager.americanIngot)&&playerIn.inventory.hasItem(ItemManager.lightningOrb))
            {
            	playerIn.addExhaustion(-10);
            	
            	while(playerIn.getHealth() < (playerIn.getMaxHealth()-0.5)){
            		playerIn.heal(0.5f);
            	}
            	entityarrow.canBePickedUp = 2;
            }
            else
            {
            	playerIn.attackEntityFrom(DamageSource.generic, 1.0F);
            }*/

            playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);

            if (!worldIn.isRemote)
            {
                worldIn.spawnEntityInWorld(entityarrow);
            }
        }
    }
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
        return stack;
    }
    
    @Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }
    
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        net.minecraftforge.event.entity.player.ArrowNockEvent event = new net.minecraftforge.event.entity.player.ArrowNockEvent(playerIn, itemStackIn);
        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return event.result;

        if (playerIn.capabilities.isCreativeMode || playerIn.inventory.hasItem(ItemManager.americanIngot))
        {
            playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
        }

        return itemStackIn;
    }
    
    
    
    
    /*public ItemStack onItemUse(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
    	if(op==0&&playerIn.capabilities.isCreativeMode==false){
    	playerIn.capabilities.allowEdit=false;
    	playerIn.capabilities.allowFlying=true;
    	playerIn.capabilities.disableDamage=true;
    	op=1;
    	}
    	if(op==1&&playerIn.capabilities.isCreativeMode==false){
        	playerIn.capabilities.allowEdit=true;
        	playerIn.capabilities.allowFlying=false;
        	playerIn.capabilities.disableDamage=false;
        	op=0;
        	}
    	else{
    		return null;
    	}
    	return itemStackIn;
    	
    }*/
    /*@Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
      super.onUpdate(stack, world, entity, par4, par5);
      EntityPlayer player = (EntityPlayer) entity;
      EntityPlayerMP playerMP = (EntityPlayerMP)event.player;
      ItemStack equipped = player.getCurrentEquippedItem();
      if(equipped == stack&&playerMP.theItemInWorldManager.getGameType() != GameType.CREATIVE || playerMP.theItemInWorldManager.getGameType() != GameType.SPECTATOR) ) {
    	player.capabilities.allowEdit=false;
      	player.capabilities.allowFlying=true;
      	player.capabilities.disableDamage=true;
      }
      else{
    	  player.capabilities.allowEdit=true;
        	player.capabilities.allowFlying=false;
        	player.capabilities.disableDamage=false;
      }
    }*/
    
    
    
   // ((EntityPlayerMP) player).playerNetServerHandler.sendPacket(new S39PacketPlayerAbilities(player.capabilities));

/*if(playerIn.capabilities.allowFlying = false){
    playerIn.capabilities.allowFlying = true;
    // playerIn.capabilities.isCreativeMode = true;
    playerIn.capabilities.disableDamage = true;
	}
	else if(playerIn.capabilities.allowFlying=true && playerIn.capabilities.allowEdit==true&&playerIn.capabilities.isCreativeMode==false){
		playerIn.capabilities.allowFlying = false;
     // playerIn.capabilities.isCreativeMode = true;
     playerIn.capabilities.disableDamage = false;*/

    /*public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
    	if(op=false){
    		playerIn.noClip=true;
            playerIn.capabilities.disableDamage=true;
            playerIn.capabilities.allowFlying=true;
            playerIn.capabilities.isFlying=true;
            op=true;
    	}
    	else if(op=true){
    	playerIn.noClip=false;
        playerIn.capabilities.disableDamage=false;
        playerIn.capabilities.allowFlying=false;
        playerIn.capabilities.isFlying=false;
        op=false;
    	}
    	playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
        return itemStackIn;
    }
    */
    /*public boolean onItemRightClick(ItemStack stack, EntityPlayer playerIn,
            World worldIn, BlockPos pos, EnumFacing side, float hitX,
            float hitY, float hitZ) {
    	
        }*/
    
    
    
    	
    	
    
} 
 
