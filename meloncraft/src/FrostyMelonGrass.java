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
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class FrostyMelonGrass extends Block {
		String tex;
		@SideOnly(Side.CLIENT)
	    private Icon field_94437_a;
        public FrostyMelonGrass (int id, Material material, String texture) {
                super(id, material);
                this.setTickRandomly(true);
                this.tex=texture;
        }
        
        //public void func_94332_a(IconRegister iconRegister)
        //{
                 //this.field_94336_cN = iconRegister.func_94245_a("MelonCraft:"+this.tex);
        //}
        @SideOnly(Side.CLIENT)
        public void func_94332_a(IconRegister par1IconRegister)
        {
            this.field_94336_cN = par1IconRegister.func_94245_a("MelonCraft:"+this.tex+"_side");
            this.field_94437_a = par1IconRegister.func_94245_a("MelonCraft:"+this.tex+"_top");
        }
        @SideOnly(Side.CLIENT)
        public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
        {
            return par1 == 1 ? this.field_94437_a : (par1 == 0 ? MelonCraft.melonDirt.getBlockTextureFromSide(par1) : this.field_94336_cN);
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
        
        public int idDropped(int par1, Random par2Random, int par3)
        {
            return MelonCraft.melonDirt.idDropped(0, par2Random, par3);
        }
        
        public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
        {
            if (!par1World.isRemote)
            {
                if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 4 && par1World.getBlockLightOpacity(par2, par3 + 1, par4) > 2)
                {
                    par1World.func_94575_c(par2, par3, par4, MelonCraft.melonDirt.blockID);
                }
                else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
                {
                    for (int l = 0; l < 4; ++l)
                    {
                        int i1 = par2 + par5Random.nextInt(3) - 1;
                        int j1 = par3 + par5Random.nextInt(5) - 3;
                        int k1 = par4 + par5Random.nextInt(3) - 1;
                        int l1 = par1World.getBlockId(i1, j1 + 1, k1);

                        if (par1World.getBlockId(i1, j1, k1) == MelonCraft.melonDirt.blockID && par1World.getBlockLightValue(i1, j1 + 1, k1) >= 4 && par1World.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
                        {
                            par1World.func_94575_c(i1, j1, k1, this.blockID);
                        }
                    }
                }
            }
        }
        
        @SideOnly(Side.CLIENT)
        public void randomDisplayTick(World world, int x, int y, int z, Random random)
        {
        	if(y>63);
        	if(ModLoader.getMinecraftInstance().gameSettings.particleSetting!=2)
            if (random.nextInt(24) == 0)
                if (world.getBlockLightValue(x, y + 1, z) == 15)
                {
                    ModLoader.getMinecraftInstance().effectRenderer.addEffect((EntityFX)new FallSnowPart(world, x + 0.2, y + 3, z + 0.3, 000000000.0D, -0.1D, 0.0D));
                    ModLoader.getMinecraftInstance().effectRenderer.addEffect((EntityFX)new FallSnowPart(world, x + 0.5, y + 5, z + 0.1, 000000000.0D, -0.2D, 0.0D));
                    ModLoader.getMinecraftInstance().effectRenderer.addEffect((EntityFX)new FallSnowPart(world, x + 0.2, y + 8, z + 0.3, 000000000.0D, -0.1D, 0.0D));
                    ModLoader.getMinecraftInstance().effectRenderer.addEffect((EntityFX)new FallSnowPart(world, x + 0.3, y + 11, z + 0.7, 000000000.0D, -0.2D, 0.0D));
                    ModLoader.getMinecraftInstance().effectRenderer.addEffect((EntityFX)new FallSnowPart(world, x + 0.3, y + 15, z + 0.7, 000000000.0D, -0.2D, 0.0D));
                    ModLoader.getMinecraftInstance().effectRenderer.addEffect((EntityFX)new FallSnowPart(world, x + 0.2, y + 17, z + 0.3, 000000000.0D, -0.1D, 0.0D));
                    ModLoader.getMinecraftInstance().effectRenderer.addEffect((EntityFX)new FallSnowPart(world, x + 0.5, y + 18, z + 0.1, 000000000.0D, -0.2D, 0.0D));
                    ModLoader.getMinecraftInstance().effectRenderer.addEffect((EntityFX)new FallSnowPart(world, x + 0.3, y + 20, z + 0.7, 000000000.0D, -0.2D, 0.0D));
                }
        }
}