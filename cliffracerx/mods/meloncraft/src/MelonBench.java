package cliffracerx.mods.meloncraft.src;

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
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class MelonBench extends Block {
        String tex;
        private Icon field_94385_a;
        private Icon field_94384_b;
        public MelonBench (int id, Material material, String texture) {
                super(id, material);
                this.tex=texture;
        }
        
        public void registerIcons(IconRegister iconRegister)
        {
                 this.blockIcon = iconRegister.registerIcon("MelonCraft:"+this.tex+"Side2");
                 this.field_94385_a = iconRegister.registerIcon("MelonCraft:"+this.tex);
                 this.field_94384_b = iconRegister.registerIcon("MelonCraft:"+this.tex+"Side1");
        }
        
        public boolean isGenMineableReplaceable(World world, int x, int y, int z)
        {
            return true;
        }
        
        public boolean isOpaqueCube()
        {
            return true;
        }

        public boolean renderAsNormalBlock()
        {
            return true;
        }
        
        public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
        {
            if (par1World.isRemote)
            {
                System.out.println("Is remote.");
                return true;
            }
            else
            {
                System.out.println("Yay!  Isn't remote!");
                MelonCraft.openCustomGui(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9, 0);
                return true;
            }
        }
        
        public Icon getIcon(int par1, int par2)
        {
            return par1 == 1 ? this.field_94385_a : (par1 == 0 ? MelonCraft.melonplanks.getBlockTextureFromSide(par1) : (par1 != 2 && par1 != 4 ? this.blockIcon : this.field_94384_b));
        }
}