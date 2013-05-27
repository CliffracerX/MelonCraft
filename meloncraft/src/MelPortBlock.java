package meloncraft.src;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.ModLoader;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MelPortBlock extends Block {
		String tex;
        public MelPortBlock (int id, Material material, String texture) {
                super(id, material);
                this.tex=texture;
        }
        
        public void func_94332_a(IconRegister iconRegister)
        {
                 this.field_94336_cN = iconRegister.func_94245_a("MelonCraft:"+this.tex);
        }
        
        public boolean isGenMineableReplaceable(World world, int x, int y, int z)
        {
            return true;
        }
        
        public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
        {
            return this.onBlockActivatedC(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
            //return true;
        }

        public boolean onBlockActivatedC(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
        {
            if (par1World.isRemote)
            {
                return true;
            }
            else
            {
                //getConfigurationManager().transferPlayerToDimension(this, var5);
                //ModLoader.getMinecraftInstance().usePortal(5, new SkyTeleporter());
                if(par5EntityPlayer.dimension!=16)
                {
                	ModLoader.getMinecraftServerInstance().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)par5EntityPlayer, 16, new TeleporterSky(MinecraftServer.getServer().worldServers[par5EntityPlayer.dimension]));
                }
                else
                {
                	ModLoader.getMinecraftServerInstance().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)par5EntityPlayer, 0, new TeleporterSky(MinecraftServer.getServer().worldServers[0]));
                }
                return true;
            }
        }
        
        /**
         * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
         * cleared to be reused)
         */
        public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
        {
            return null;
        }

        /**
         * Updates the blocks bounds based on its current state. Args: world, x, y, z
         */
        public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
        {
            float var5;
            float var6;

            if (par1IBlockAccess.getBlockId(par2 - 1, par3, par4) != this.blockID && par1IBlockAccess.getBlockId(par2 + 1, par3, par4) != this.blockID)
            {
                var5 = 0.125F;
                var6 = 0.5F;
                this.setBlockBounds(0.5F - var5, 0.0F, 0.5F - var6, 0.5F + var5, 1.0F, 0.5F + var6);
            }
            else
            {
                var5 = 0.5F;
                var6 = 0.125F;
                this.setBlockBounds(0.5F - var5, 0.0F, 0.5F - var6, 0.5F + var5, 1.0F, 0.5F + var6);
            }
        }

        /**
         * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
         * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
         */
        public boolean isOpaqueCube()
        {
            return false;
        }

        /**
         * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
         */
        public boolean renderAsNormalBlock()
        {
            return false;
        }
        
        /**
         * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
         */
        public int getRenderBlockPass()
        {
            return 1;
        }

}
