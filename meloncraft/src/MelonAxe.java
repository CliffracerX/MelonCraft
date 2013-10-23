package meloncraft.src;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapData;

public class MelonAxe extends Item {

        private String itemTexFile;
        private float speed;
        private int dura;

		public MelonAxe(int id, String TF, int durab, float spd) {
                super(id);
                
                // Constructor Configuration
                this.dura=durab;
                this.speed=spd;
                maxStackSize = 1;
                this.itemTexFile=TF;
                this.setMaxDamage(this.dura);
                setCreativeTab(MelonCraft.MelonTab);
                setUnlocalizedName("genericItem");
        }
        
        public void func_94581_a(IconRegister iconRegister)
        {
                 iconIndex = iconRegister.func_94245_a("MelonCraft:"+this.itemTexFile);
        }

        public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	    {
        	if(par2Block==MelonCraft.melonLog || par2Block==MelonCraft.melonPlanks || par2Block==MelonCraft.melCraftTable || par2Block==MelonCraft.dyeLog)
	        {
	            return this.speed;
	        }
        	else
        	return 1.0F;
	    }
        
        @SideOnly(Side.CLIENT)

        /**
         * Returns True is the item is renderer in full 3D when hold.
         */
        public boolean isFull3D()
        {
            return true;
        }
        
        public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLiving par7EntityLiving)
	    {
	        if ((double)Block.blocksList[par3].getBlockHardness(par2World, par4, par5, par6) != 0.0D)
	        {
	            par1ItemStack.damageItem(1, par7EntityLiving);
	        }

	        return true;
	    }
}