package cliffracerx.mods.meloncraft.src;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MelonPickaxe extends Item
{
    private String texture;
    private float speed;
    private int dura;
    int tier;
    public MelonPickaxe(int id, String tex, int tier, int durability, float speed)
    {
        super(id);
        this.setUnlocalizedName(tex);
        this.setTextureName("MelonCraft:"+tex);
        this.texture=tex;
        this.tier=tier;
        this.dura=durability;
        this.speed=speed;
        this.setMaxDamage(this.dura);
    }

    @Override
    public CreativeTabs getCreativeTab()
    {
        return MelonCraft.tab;
    }
    
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        if(par2Block instanceof MelonBlockStone)
        {
            return this.speed;
        }
        else
        return 1.0F;
    }
    
    @SideOnly(Side.CLIENT)

    /**
     * Returns True is the item is renderer in full 3D when held.
     */
    public boolean isFull3D()
    {
        return true;
    }
    
    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase)
    {
        if ((double)Block.blocksList[par3].getBlockHardness(par2World, par4, par5, par6) != 0.0D)
        {
            par1ItemStack.damageItem(1, par7EntityLivingBase);
        }

        return true;
    }
}