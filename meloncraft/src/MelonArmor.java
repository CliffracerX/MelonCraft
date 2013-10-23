package meloncraft.src;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockDispenser;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.IArmorTextureProvider;

public class MelonArmor extends ItemArmor implements IArmorTextureProvider
{
    /**
     * Texture of armor as a item.
     */
    private String tex;
    /**
     * Texture of armor on a entity.
     */
    private String entTex;

    public MelonArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, String tex, String entTex)
    {
        super(par1, par2EnumArmorMaterial, par4, par4);
        this.setCreativeTab(MelonCraft.MelonTab);
        this.tex=tex;
        this.entTex=entTex;
    }
    
    public String getArmorTextureFile(ItemStack par1)
    {
        if (this.armorType==0 || this.armorType==1 || this.armorType==3)
        {
        	return "/meloncraft/texes/"+this.entTex+"_1.png";
        }
        if(this.armorType==2)
        {
        	return "/meloncraft/texes/"+this.entTex+"_2.png";
        }
        return "/"+this.entTex+"_2.png";
    }
    
    public void func_94581_a(IconRegister iconRegister)
    {
             iconIndex = iconRegister.func_94245_a("MelonCraft:"+this.tex);
    }
}
