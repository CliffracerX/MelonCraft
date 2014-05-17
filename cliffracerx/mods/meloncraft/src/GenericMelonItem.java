package cliffracerx.mods.meloncraft.src;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GenericMelonItem extends Item
{
    private String texture;

    public GenericMelonItem(int id, String tex)
    {
        super(id);
        this.setUnlocalizedName(tex);
        this.setTextureName("MelonCraft:"+tex);
        this.texture=tex;
    }

    @Override
    public CreativeTabs getCreativeTab()
    {
        return MelonCraft.tab;
    }
}