package com.camp.item;
 
import com.example.examplemod.cm;
 
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
 
public class CustomSword extends ItemSword{
 
    public final String name = "CustomSword";
     
    protected CustomSword(ToolMaterial material) {
        super(material);
        this.setUnlocalizedName(this.name);
        this.setCreativeTab(cm.tabIke);
        // TODO Auto-generated constructor stub
    }
     
 
}