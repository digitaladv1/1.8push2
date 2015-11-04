package com.camp.item;
 
import com.example.examplemod.cm;
 
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
 
public class CustomPickaxe extends ItemPickaxe{
 
    public final String name = "CustomPickaxe";
     
    protected CustomPickaxe(ToolMaterial material) {
        super(material);
        this.setUnlocalizedName(this.name);
        this.setCreativeTab(cm.tabIke);
        // TODO Auto-generated constructor stub
    }
     
 
}