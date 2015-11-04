package com.camp.item;
 
import com.example.examplemod.cm;
 
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;
 
public class CustomHoe extends ItemHoe{
 
    public final String name = "CustomHoe";
     
    protected CustomHoe(ToolMaterial material) {
        super(material);
        this.setUnlocalizedName(this.name);
        this.setCreativeTab(cm.tabIke);
        // TODO Auto-generated constructor stub
    }
     
 
}