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
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapData;

public class MelonWandItem extends Item {

        private String itemTexFile;
        private int wandType;
		public MelonWandItem(int id, String TF, int stackSize, int WT) {
                super(id);
                
                // Constructor Configuration
                maxStackSize = stackSize;
                this.itemTexFile=TF;
                this.wandType=WT;
                setCreativeTab(MelonCraft.MelonTab);
                setUnlocalizedName("genericItem");
        }
        
        public void func_94581_a(IconRegister iconRegister)
        {
                 iconIndex = iconRegister.func_94245_a("MelonCraft:"+this.itemTexFile);
        }
        
        public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
        {
        	if(this.wandType==0 || this.wandType==1)
        	{
            if (par7 == 0)
            {
                --par5;
            }

            if (par7 == 1)
            {
                ++par5;
            }

            if (par7 == 2)
            {
                --par6;
            }

            if (par7 == 3)
            {
                ++par6;
            }

            if (par7 == 4)
            {
                --par4;
            }

            if (par7 == 5)
            {
                ++par4;
            }

            if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
            {
                return false;
            }
            else
            {
                int i1 = par3World.getBlockId(par4, par5, par6);

                if (i1 == 0)
                {
                    par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                    par3World.func_94575_c(par4, par5, par6, Block.fire.blockID);
                }

                par1ItemStack.damageItem(1, par2EntityPlayer);
                return true;
            }
        	}
			return true;
        }

        public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
        {               
        if (!world.isRemote)
        {
        	if(this.wandType==0)
        	{
                                         Vec3 look = entityplayer.getLookVec();
                                         EntityFireball fireball = new EntitySmallFireball(world, entityplayer, 1, 1, 1);
                                         fireball.setPosition(
                                                                         entityplayer.posX + look.xCoord * 1.6,
                                                                         entityplayer.posY + 1,
                                                                         entityplayer.posZ + look.zCoord * 1.6);
                                         fireball.accelerationX = look.xCoord * 0.1;
                                         fireball.accelerationY = look.yCoord * 0.1;
                                         fireball.accelerationZ = look.zCoord * 0.1;
                                         world.spawnEntityInWorld(fireball);
        	}
        }
        return itemstack;
        }
}