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

public class MelonBench extends Block {
		String tex;
        public MelonBench (int id, Material material, String texture) {
                super(id, material);
                this.tex=texture;
        }
        
        public void func_94332_a(IconRegister iconRegister)
        {
                 this.field_94336_cN = iconRegister.func_94245_a("MelonCraft:"+this.tex);
        }
        
        @SideOnly(Side.CLIENT)
        public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
        {
        	if(par3>63);
        	if(ModLoader.getMinecraftInstance().gameSettings.particleSetting!=2)
            if (par5Random.nextInt(24) == 0)
                if (par1World.getBlockLightValue(par2, par3 + 1, par4) == 15)
                {
                    ModLoader.getMinecraftInstance().effectRenderer.addEffect((EntityFX)new FallSnowPart(par1World, par2 + 0.2, par3 + 3, par4 + 0.3, 000000000.0D, -0.1D, 0.0D));
                    ModLoader.getMinecraftInstance().effectRenderer.addEffect((EntityFX)new FallSnowPart(par1World, par2 + 0.5, par3 + 5, par4 + 0.1, 000000000.0D, -0.2D, 0.0D));
                    ModLoader.getMinecraftInstance().effectRenderer.addEffect((EntityFX)new FallSnowPart(par1World, par2 + 0.2, par3 + 8, par4 + 0.3, 000000000.0D, -0.1D, 0.0D));
                    ModLoader.getMinecraftInstance().effectRenderer.addEffect((EntityFX)new FallSnowPart(par1World, par2 + 0.3, par3 + 11, par4 + 0.7, 000000000.0D, -0.2D, 0.0D));
                    ModLoader.getMinecraftInstance().effectRenderer.addEffect((EntityFX)new FallSnowPart(par1World, par2 + 0.3, par3 + 15, par4 + 0.7, 000000000.0D, -0.2D, 0.0D));
                    ModLoader.getMinecraftInstance().effectRenderer.addEffect((EntityFX)new FallSnowPart(par1World, par2 + 0.2, par3 + 17, par4 + 0.3, 000000000.0D, -0.1D, 0.0D));
                    ModLoader.getMinecraftInstance().effectRenderer.addEffect((EntityFX)new FallSnowPart(par1World, par2 + 0.5, par3 + 18, par4 + 0.1, 000000000.0D, -0.2D, 0.0D));
                    ModLoader.getMinecraftInstance().effectRenderer.addEffect((EntityFX)new FallSnowPart(par1World, par2 + 0.3, par3 + 20, par4 + 0.7, 000000000.0D, -0.2D, 0.0D));
                }
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
}