package meloncraft.src;

import java.util.Iterator;
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
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapData;

public class MelonBottle extends Item {

        private String itemTexFile;
        private int potionEffect;
        private int type;
		public MelonBottle(int id, String TF, int stackSize, int i, int type) {
                super(id);
                
                // Constructor Configuration
                maxStackSize = stackSize;
                this.itemTexFile=TF;
                this.potionEffect=i;
                this.type=type;
                setCreativeTab(MelonCraft.MelonTab);
                setUnlocalizedName("genericItem");
        }
        
        public void func_94581_a(IconRegister iconRegister)
        {
                 iconIndex = iconRegister.func_94245_a("MelonCraft:"+this.itemTexFile);
        }

        public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
        {
        	if(this.type!=0)
        	{
            if (!par3EntityPlayer.capabilities.isCreativeMode)
            {
                --par1ItemStack.stackSize;
            }

            if (!par2World.isRemote)
            {
            	par3EntityPlayer.addPotionEffect(new PotionEffect(this.potionEffect, 20*30, 0));
            }

            if (!par3EntityPlayer.capabilities.isCreativeMode)
            {
                if (par1ItemStack.stackSize <= 0)
                {
                    return new ItemStack(MelonCraft.emptyMelBot);
                }

                par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(MelonCraft.emptyMelBot));
            }
        	}
            return par1ItemStack;
        }
        
        /**
         * How long it takes to use or consume an item
         */
        public int getMaxItemUseDuration(ItemStack par1ItemStack)
        {
            return 32;
        }

        /**
         * returns the action that specifies what animation to play when the items is being used
         */
        public EnumAction getItemUseAction(ItemStack par1ItemStack)
        {
            return EnumAction.drink;
        }

        /**
         * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
         * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
         */
        public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
        {
            return false;
        }
        
        public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
        {
        	if(this.type==0)
        	{
            MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, true);

            if (movingobjectposition == null)
            {
                return par1ItemStack;
            }
            else
            {
                if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
                {
                    int i = movingobjectposition.blockX;
                    int j = movingobjectposition.blockY;
                    int k = movingobjectposition.blockZ;

                    if (!par2World.canMineBlock(par3EntityPlayer, i, j, k))
                    {
                        return par1ItemStack;
                    }

                    if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
                    {
                        return par1ItemStack;
                    }

                    if (par2World.getBlockId(i, j, k) == MelonCraft.melonjuice.blockID)
                    {
                        --par1ItemStack.stackSize;

                        if (par1ItemStack.stackSize <= 0)
                        {
                            return new ItemStack(MelonCraft.melBotNMJ);
                        }

                        if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(MelonCraft.melBotNMJ)))
                        {
                            par3EntityPlayer.dropPlayerItem(new ItemStack(MelonCraft.melBotNMJ.itemID, 1, 0));
                        }
                    }
                    if (par2World.getBlockId(i, j, k) == MelonCraft.redMJ.blockID)
                    {
                        --par1ItemStack.stackSize;

                        if (par1ItemStack.stackSize <= 0)
                        {
                            return new ItemStack(MelonCraft.melBotRMJ);
                        }

                        if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(MelonCraft.melBotRMJ)))
                        {
                            par3EntityPlayer.dropPlayerItem(new ItemStack(MelonCraft.melBotRMJ.itemID, 1, 0));
                        }
                    }
                    if (par2World.getBlockId(i, j, k) == MelonCraft.greenMJ.blockID)
                    {
                        --par1ItemStack.stackSize;

                        if (par1ItemStack.stackSize <= 0)
                        {
                            return new ItemStack(MelonCraft.melBotGMJ);
                        }

                        if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(MelonCraft.melBotGMJ)))
                        {
                            par3EntityPlayer.dropPlayerItem(new ItemStack(MelonCraft.melBotGMJ.itemID, 1, 0));
                        }
                    }
                    if (par2World.getBlockId(i, j, k) == MelonCraft.blueMJ.blockID)
                    {
                        --par1ItemStack.stackSize;

                        if (par1ItemStack.stackSize <= 0)
                        {
                            return new ItemStack(MelonCraft.melBotBMJ);
                        }

                        if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(MelonCraft.melBotBMJ)))
                        {
                            par3EntityPlayer.dropPlayerItem(new ItemStack(MelonCraft.melBotBMJ.itemID, 1, 0));
                        }
                    }



                }

                return par1ItemStack;
            }
        }
        	else
        	{
        		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
            return par1ItemStack;
        	}
        }

}