package meloncraft.src;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class Bendyblock extends Block
{
		String tex;
        public Bendyblock (int id, Material material, String texture)
        {
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
        
        public boolean isOpaqueCube()
        {
            return true;
        }

        public boolean renderAsNormalBlock()
        {
            return true;
        }
        
        public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
        {
            float f = 0.125F;
            return AxisAlignedBB.getAABBPool().getAABB((double)par2, (double)par3, (double)par4, (double)(par2 + 1), (double)((float)(par3 + 1) - f), (double)(par4 + 1));
        }
        
        public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
        {
        	par5Entity.motionY=1.5D;
        	par5Entity.fallDistance=0;
        }
}