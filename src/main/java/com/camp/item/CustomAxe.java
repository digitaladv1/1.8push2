package com.camp.item;
 
import com.example.examplemod.cm;
 



import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
 
public class CustomAxe extends ItemAxe{
 
    public final String name = "CustomAxe";
     
    protected CustomAxe(ToolMaterial material) {
        super(material);
        this.setUnlocalizedName(this.name);
        this.setCreativeTab(cm.tabIke);
        // TODO Auto-generated constructor stub
    }
    
    
    public void onItemUse(World worldIn, BlockPos pos, Entity entityIn) {
        // TODO Auto-generated method stub
        //super.onItemUse(stack, playerIn, worldIn, pos, side, hitX, hitY, hitZ);
        if ((entityIn.ridingEntity == null) && (entityIn.riddenByEntity == null) && ((entityIn instanceof EntityPlayerMP)))
        {
               EntityPlayerMP player = (EntityPlayerMP) entityIn;
                
               MinecraftServer mServer = MinecraftServer.getServer();
               if (player.timeUntilPortal > 0)
               {
                     player.timeUntilPortal = 10;
               }
               else if (player.dimension != 2)
               {
                     player.timeUntilPortal = 10;
                
                     player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 2, cm.teleporterCustom);
               }
               else
               {
                     player.timeUntilPortal = 10;
                     player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, cm.teleporterSurface);
               }
        }
    }
 
}