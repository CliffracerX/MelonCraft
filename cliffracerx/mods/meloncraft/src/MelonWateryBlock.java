package cliffracerx.mods.meloncraft.src;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MelonWateryBlock extends Block {
        String tex;
        boolean lavaType;
        public MelonWateryBlock (int id, Material material, String texture, boolean lavaLike) {
                super(id, material);
                this.tex=texture;
                setTextureName("MelonCraft:" + texture);
                this.lavaType=lavaLike;
                this.setTickRandomly(true);
                System.out.println(this.getTickRandomly());
                if(material==Material.ground)
                {
                    //material=Material.water;
                }
        }
        
        public int tickRate(World par1World)
        {
            return 1;
        }
        
        /**
         * Ticks the block if it's been scheduled
         */
        public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
        {
            if(!par1World.isRemote)
            {
            //System.out.println("Ticking Watery Block!");
            int XorY = par5Random.nextInt(1);
            int AddOrSubtract = par5Random.nextInt(1);
            if(par1World.getBlockId(par2, par3-1, par4)==0)
            {
                par1World.setBlock(par2, par3, par4, 0);
                par1World.setBlock(par2, par3-1, par4, this.blockID);
            }
            else
            {
                if(XorY==0 && AddOrSubtract==0)
                {
                    if(par1World.getBlockId(par2+1, par3, par4)==0 && par5Random.nextInt(1)==0)
                    {
                        par1World.setBlock(par2, par3, par4, 0);
                        par1World.setBlock(par2+1, par3, par4, this.blockID);
                    }
                }
                else if(XorY==0 && AddOrSubtract==1)
                {
                    if(par1World.getBlockId(par2-1, par3, par4)==0 && par5Random.nextInt(1)==0)
                    {
                        par1World.setBlock(par2, par3, par4, 0);
                        par1World.setBlock(par2-1, par3, par4, this.blockID);
                    }
                }
                else if(XorY==1 && AddOrSubtract==0)
                {
                    if(par1World.getBlockId(par2, par3, par4+1)==0 && par5Random.nextInt(1)==0)
                    {
                        par1World.setBlock(par2, par3, par4, 0);
                        par1World.setBlock(par2, par3, par4+1, this.blockID);
                    }
                }
                else if(XorY==1 && AddOrSubtract==1)
                {
                    if(par1World.getBlockId(par2, par3, par4-1)==0 && par5Random.nextInt(1)==0)
                    {
                        par1World.setBlock(par2, par3, par4, 0);
                        par1World.setBlock(par2, par3, par4-1, this.blockID);
                    }
                }
            }
            }
        }
        
        public boolean isOpaqueCube()
        {
            return false;
        }

        public boolean renderAsNormalBlock()
        {
            return false;
        }
        
        public int getRenderBlockPass()
        {
            return 1;
        }
        
        public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
        {
            return null;
        }
        
        boolean localFlag=false;
        
        
        public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
        {
            int i1 = par1IBlockAccess.getBlockId(par2, par3, par4);
            return !this.localFlag && i1 == this.blockID ? false : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
        }
        
        public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
        {
            if(par5Entity instanceof EntityPlayer)
            {
                par5Entity.fallDistance=0;
                par5Entity.motionY=0.085;
                par5Entity.onGround=true;
                EntityPlayer playerEntity = (EntityPlayer)par5Entity;
                //if(playerEntity.isJumping)
                //par5Entity.motionY=0.085;
                if(playerEntity.isSneaking())
                par5Entity.motionY=-0.25;
                if(new Random().nextInt(64)==0)
                {
                    if(this.lavaType==false)
                    par1World.playSound((double)par5Entity.posX, (double)par5Entity.posY, (double)par5Entity.posZ, "liquid.swim", 0.5F, new Random().nextFloat() * 0.4F + 0.8F, true);
                    else if(this.lavaType==true)
                    par1World.playSound((double)par5Entity.posX, (double)par5Entity.posY, (double)par5Entity.posZ, "liquid.lavapop", 0.5F, new Random().nextFloat() * 0.4F + 0.8F, true);
                }
            }
            else if(par5Entity instanceof EntityLiving)
            {
                par5Entity.fallDistance=0;
                par5Entity.motionY=0.085;
                par5Entity.onGround=true;
                EntityLiving playerEntity = (EntityLiving)par5Entity;
                if(new Random().nextInt(5)==0)
                par5Entity.motionY=-0.25;
                else
                par5Entity.motionY=0.25;
                if(new Random().nextInt(64)==0)
                {
                    if(this.lavaType==false)
                    par1World.playSound((double)par5Entity.posX, (double)par5Entity.posY, (double)par5Entity.posZ, "liquid.swim", 0.5F, new Random().nextFloat() * 0.4F + 0.8F, true);
                    else if(this.lavaType==true)
                    par1World.playSound((double)par5Entity.posX, (double)par5Entity.posY, (double)par5Entity.posZ, "liquid.lavapop", 0.5F, new Random().nextFloat() * 0.4F + 0.8F, true);
                }
            }
            /*else if(this.mot>0)
            {
                par5Entity.motionY=this.mot;
                par5Entity.fallDistance=0;
            }*/
        }
}