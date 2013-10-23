package meloncraft.src;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.world.World;

public class ItemMiniMWS extends Item
{
	private int clr;
	private String tex;
    public ItemMiniMWS(int par1, String text, int color)
    {
        super(par1);
        this.clr=color;
        this.tex=text;
        this.setCreativeTab(MelonCraft.MelonTab);
    }
    
    public void func_94581_a(IconRegister iconRegister)
    {
             iconIndex = iconRegister.func_94245_a("MelonCraft:"+this.tex);
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (par3World.isRemote)
        {
            return true;
        }
        else
        {
            int var11 = par3World.getBlockId(par4, par5, par6);
            par4 += Facing.offsetsXForSide[par7];
            par5 += Facing.offsetsYForSide[par7];
            par6 += Facing.offsetsZForSide[par7];
            double var12 = 0.0D;

            if (par7 == 1 && Block.blocksList[var11] != null && Block.blocksList[var11].getRenderType() == 11)
            {
                var12 = 0.5D;
            }

            for(int i=par1ItemStack.stackSize; i>0; i-=1)
            {
            	Entity entity = spawnCreature(par3World, par1ItemStack.getItemDamage(), (double)par4 + 0.5D, (double)par5 + var12, (double)par6 + 0.5D);

                if (entity != null)
                {
                    if (entity instanceof EntityLiving && par1ItemStack.hasDisplayName())
                    {
                        ((EntityLiving)entity).func_94058_c(par1ItemStack.getDisplayName());
                    }

                    if (!par2EntityPlayer.capabilities.isCreativeMode)
                    {
                        --par1ItemStack.stackSize;
                    }
                }
            }
            return true;
        }
    }

    /**
     * Spawns the creature specified by the egg's type in the location specified by the last three parameters.
     * Parameters: world, entityID, x, y, z.
     */
    public Entity spawnCreature(World par0World, int par1, double par2, double par4, double par6)
    {    	
    	System.out.println("Yay, spawned a MelonWoolSoldier");
    	EntityMiniMelonwoolSoldier var1 = new EntityMiniMelonwoolSoldier(par0World);
    	var1.setColor(this.clr);
    	var1.setPosition(par2, par4, par6);
        par0World.spawnEntityInWorld(var1);
        return var1;
    }
}
