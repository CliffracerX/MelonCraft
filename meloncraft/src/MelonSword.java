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

public class MelonSword extends Item {

        private String itemTexFile;
		private int damageDone;

		public MelonSword(int id, String TF, int dura, int DD) {
                super(id);
                
                // Constructor Configuration
                maxStackSize = 1;
                this.itemTexFile=TF;
                this.damageDone=DD;
                setCreativeTab(MelonCraft.MelonTab);
                this.setMaxDamage(dura);
        }
		
	    public int func_82803_g()
	    {
	        return this.damageDone;
	    }

	    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	    {
	        if (par2Block.blockID == Block.web.blockID)
	        {
	            return 15.0F;
	        }
	        else
	        {
	            Material material = par2Block.blockMaterial;
	            return material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.pumpkin ? 1.0F : 1.5F;
	        }
	    }
	    
	    public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving)
	    {
	    	par1ItemStack.damageItem(1, par3EntityLiving);
	        return true;
	    }
	    
	    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLiving par7EntityLiving)
	    {
	        if ((double)Block.blocksList[par3].getBlockHardness(par2World, par4, par5, par6) != 0.0D)
	        {
	            par1ItemStack.damageItem(2, par7EntityLiving);
	        }

	        return true;
	    }
        
        public void func_94581_a(IconRegister iconRegister)
        {
                 iconIndex = iconRegister.func_94245_a("MelonCraft:"+this.itemTexFile);
        }

        public int getDamageVsEntity(Entity par1Entity)
        {
            return this.damageDone;
        }

        @SideOnly(Side.CLIENT)

        /**
         * Returns True is the item is renderer in full 3D when hold.
         */
        public boolean isFull3D()
        {
            return true;
        }

        /**
         * returns the action that specifies what animation to play when the items is being used
         */
        public EnumAction getItemUseAction(ItemStack par1ItemStack)
        {
            return EnumAction.block;
        }

        /**
         * How long it takes to use or consume an item
         */
        public int getMaxItemUseDuration(ItemStack par1ItemStack)
        {
            return 72000;
        }

        /**
         * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
         */
        public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
        {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
            return par1ItemStack;
        }
}