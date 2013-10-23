package meloncraft.src;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class MelonBlockStoneSmoking extends Block {
		String tex;
		float hard;
		boolean overwrite;
		int tr;
        public MelonBlockStoneSmoking (int id, Material material, String texture, float hrd, boolean b, int tier) {
                super(id, material);
                this.tex=texture;
                this.hard=hrd;
                this.overwrite=b;
                this.tr=tier;
        }
        
        public void func_94332_a(IconRegister iconRegister)
        {
                 this.field_94336_cN = iconRegister.func_94245_a("MelonCraft:"+this.tex);
        }
        
        @SideOnly(Side.CLIENT)
        public void randomDisplayTick(World world, int x, int y, int z, Random random)
        {
            int l = world.getBlockMetadata(x, y, z);
            double d0 = (double)((float)x + 0.5F);
            double d1 = (double)((float)y + 0.7F);
            double d2 = (double)((float)z + 0.5F);
            double d3 = 0.2199999988079071D;
            double d4 = 0.27000001072883606D;

            if (l == 1)
            {
                world.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
                //par1World.spawnParticle("flame", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
            }
            else if (l == 2)
            {
                world.spawnParticle("smoke", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
                //par1World.spawnParticle("flame", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
            }
            else if (l == 3)
            {
                world.spawnParticle("smoke", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
                //par1World.spawnParticle("flame", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
            }
            else if (l == 4)
            {
                world.spawnParticle("smoke", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
                //par1World.spawnParticle("flame", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
            }
            else
            {
                world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
                //par1World.spawnParticle("flame", d0, d1, d2, 0.0D, 0.0D, 0.0D);
            }
        }
        
        public boolean isGenMineableReplaceable(World world, int x, int y, int z)
        {
            return this.overwrite;
        }
        
        public boolean isOpaqueCube()
        {
            return true;
        }

        public boolean renderAsNormalBlock()
        {
            return true;
        }
        
        public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
        {
        	if(player.getHeldItem()!=null)
        	{
        	if(this.tr==0)
        	{
            if(player.getHeldItem().getItem() == MelonCraft.melWoodPick || player.getHeldItem().getItem() == MelonCraft.melStonePick || player.getHeldItem().getItem() == MelonCraft.moonStonePick || player.getHeldItem().getItem() == MelonCraft.plazPick)
            {
            	this.setHardness(this.hard);
            }
            else
            this.setBlockUnbreakable();
        	}
        	else if(this.tr==1)
        	{
                if(player.getHeldItem().getItem() == MelonCraft.melStonePick || player.getHeldItem().getItem() == MelonCraft.moonStonePick || player.getHeldItem().getItem() == MelonCraft.plazPick)
                {
                	this.setHardness(this.hard);
                }
                else
                this.setBlockUnbreakable();
            }
        	else if(this.tr==2)
        	{
                if(player.getHeldItem().getItem() == MelonCraft.moonStonePick || player.getHeldItem().getItem() == MelonCraft.plazPick)
                {
                	this.setHardness(this.hard);
                }
                else
                this.setBlockUnbreakable();
            }
        	else if(this.tr==3)
        	{
                if(player.getHeldItem().getItem() == MelonCraft.plazPick)
                {
                	this.setHardness(this.hard);
                }
                else
                this.setBlockUnbreakable();
            }
            else
            this.setBlockUnbreakable();
        	}
            else
            this.setBlockUnbreakable();
        }
}