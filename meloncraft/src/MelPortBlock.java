package meloncraft.src;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.src.ModLoader;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
public class MelPortBlock extends BlockBreakable
{
	public MelPortBlock(int par1)
	{
		super(par1, "MelonCraft:portal", Material.portal, true);
		this.setTickRandomly(true);
		this.setHardness(-1.0F);
		this.setStepSound(soundGlassFootstep);
		this.setLightValue(0.75F);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		super.updateTick(par1World, par2, par3, par4, par5Random);
		/*if (par1World.provider.isSurfaceWorld() && par5Random.nextInt(2000) < par1World.difficultySetting)
		{
			int l;
			for (l = par3; !par1World.doesBlockHaveSolidTopSurface(par2, l, par4) && l > 0; --l)
			{
				;
			}
			if (l > 0 && !par1World.isBlockNormalCube(par2, l + 1, par4))
			{
				Entity entity = ItemMonsterPlacer.spawnCreature(par1World, 57, (double)par2 + 0.5D, (double)l + 1.1D, (double)par4 + 0.5D);
				if (entity != null)
				{
					entity.timeUntilPortal = entity.getPortalCooldown();
				}
			}
		}*/
	}
	
	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
	 * cleared to be reused)
	 */
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
		return null;
	}
	
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
	 * Updates the blocks bounds based on its current state. Args: world, par2, par3, par4
	 */
	public void setBlockAndMetadataWithNotifyBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	{
		float f;
		float f1;
		if (par1IBlockAccess.getBlockId(par2 - 1, par3, par4) != this.blockID && par1IBlockAccess.getBlockId(par2 + 1, par3, par4) != this.blockID)
		{
			f = 0.125F;
			f1 = 0.5F;
			//this.setBlockAndMetadataWithNotifyBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
		}
		else
		{
			f = 0.5F;
			f1 = 0.125F;
			//this.setBlockAndMetadataWithNotifyBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
		}
	}
	
	/**
	 * Is this block (a) opaque and (B) a full 1m cube? This determines whether or not to render the shared face of two
	 * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	/**
	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	 */
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	/**
	 * Checks to see if this location is valid to create a portal and will return True if it does. Args: world, par2, par3, par4
	 */
	public boolean tryToCreatePortal(World par1World, int par2, int par3, int par4)
	{
		/*byte b0 = 0;
		byte b1 = 0;
		if (par1World.getBlockId(par2 - 1, par3, par4) == Block.melon.blockID || par1World.getBlockId(par2 + 1, par3, par4) == Block.melon.blockID)
		{
			b0 = 1;
		}
		if (par1World.getBlockId(par2, par3, par4 - 1) == Block.melon.blockID || par1World.getBlockId(par2, par3, par4 + 1) == Block.melon.blockID)
		{
			b1 = 1;
		}
		if (b0 == b1)
		{
			return false;
		}
		else
		{
			if (par1World.getBlockId(par2 - b0, par3, par4 - b1) == 0)
			{
				par2 -= b0;
				par4 -= b1;
			}
			int l;
			int i1;
			for (l = -1; l <= 2; ++l)
			{
				for (i1 = -1; i1 <= 3; ++i1)
				{
					boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;
					if (l != -1 && l != 2 || i1 != -1 && i1 != 3)
					{
						int j1 = par1World.getBlockId(par2 + b0 * l, par3 + i1, par4 + b1 * l);
						if (flag)
						{
							if (j1 != Block.melon.blockID)
							{
								return false;
							}
						}
						else if (j1 != 0 && j1 != Block.fenceIron.blockID)
						{
							return false;
						}
					}
				}
			}
			for (l = 0; l < 2; ++l)
			{
				for (i1 = 0; i1 < 3; ++i1)
				{
					par1World.setBlockAndMetadataWithNotify(par2 + b0 * l, par3 + i1, par4 + b1 * l, MelonCraft.melonportal.blockID, 0, 2);
				}
			}*/
			return true;
		//}
	}
	
	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
	 * their own) Args: x, par3, par4, neighbor blockID
	 */
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	{
		/*byte b0 = 0;
		byte b1 = 1;
		if (par1World.getBlockId(par2 - 1, par3, par4) == this.blockID || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID)
		{
			b0 = 1;
			b1 = 0;
		}
		int i1;
		for (i1 = par3; par1World.getBlockId(par2, i1 - 1, par4) == this.blockID; --i1)
		{
			;
		}
		if (par1World.getBlockId(par2, i1 - 1, par4) != Block.melon.blockID)
		{
			par1World.func_94571_i(par2, par3, par4);
		}
		else
		{
			int j1;
			for (j1 = 1; j1 < 4 && par1World.getBlockId(par2, i1 + j1, par4) == this.blockID; ++j1)
			{
				;
			}
			if (j1 == 3 && par1World.getBlockId(par2, i1 + j1, par4) == Block.melon.blockID)
			{
				boolean flag = par1World.getBlockId(par2 - 1, par3, par4) == this.blockID || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID;
				boolean flag1 = par1World.getBlockId(par2, par3, par4 - 1) == this.blockID || par1World.getBlockId(par2, par3, par4 + 1) == this.blockID;
				if (flag && flag1)
				{
					par1World.func_94571_i(par2, par3, par4);
				}
				else
				{
					if ((par1World.getBlockId(par2 + b0, par3, par4 + b1) != Block.melon.blockID || par1World.getBlockId(par2 - b0, par3, par4 - b1) != this.blockID) && (par1World.getBlockId(par2 - b0, par3, par4 - b1) != Block.melon.blockID || par1World.getBlockId(par2 + b0, par3, par4 + b1) != this.blockID))
					{
						par1World.func_94571_i(par2, par3, par4);
					}
				}
			}
			else
			{
				par1World.func_94571_i(par2, par3, par4);
			}
		}*/
	}
	
	@SideOnly(Side.CLIENT)
	/**
	 * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
	 * coordinates. Args: blockAccess, par2, par3, par4, side
	 */
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		if (par1IBlockAccess.getBlockId(par2, par3, par4) == this.blockID)
		{
			return false;
		}
		else
		{
			boolean flag = par1IBlockAccess.getBlockId(par2 - 1, par3, par4) == this.blockID && par1IBlockAccess.getBlockId(par2 - 2, par3, par4) != this.blockID;
			boolean flag1 = par1IBlockAccess.getBlockId(par2 + 1, par3, par4) == this.blockID && par1IBlockAccess.getBlockId(par2 + 2, par3, par4) != this.blockID;
			boolean flag2 = par1IBlockAccess.getBlockId(par2, par3, par4 - 1) == this.blockID && par1IBlockAccess.getBlockId(par2, par3, par4 - 2) != this.blockID;
			boolean flag3 = par1IBlockAccess.getBlockId(par2, par3, par4 + 1) == this.blockID && par1IBlockAccess.getBlockId(par2, par3, par4 + 2) != this.blockID;
			boolean flag4 = flag || flag1;
			boolean flag5 = flag2 || flag3;
			return flag4 && par5 == 4 ? true : (flag4 && par5 == 5 ? true : (flag5 && par5 == 2 ? true : flag5 && par5 == 3));
		}
	}
	
	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random par1Random)
	{
		return 0;
	}
	
	/**
	 * Triggered whenever an entity collides with this block (enters into the block). Args: world, par2, par3, par4, entity
	 */
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		if ((par5Entity.ridingEntity == null) && (par5Entity.riddenByEntity == null) && ((par5Entity instanceof EntityPlayerMP)))
		{
			EntityPlayerMP thePlayer = (EntityPlayerMP)par5Entity;
			if (thePlayer.timeUntilPortal > 0)
			{
				thePlayer.timeUntilPortal = 10;
			}
			else if (thePlayer.dimension != -2)
			{
				thePlayer.timeUntilPortal = 10;
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, -2, new TeleporterSky(thePlayer.mcServer.worldServerForDimension(-2)));
			}
			else {
				thePlayer.timeUntilPortal = 10;
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new TeleporterSky(thePlayer.mcServer.worldServerForDimension(0)));
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	/**
	 * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
	 */
	public int getRenderBlockPass()
	{
		return 1;
	}
	
	@SideOnly(Side.CLIENT)
	/**
	 * A randomly called display update to be able to add particles or other items for display
	 */
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (par5Random.nextInt(100) == 0)
		{
			par1World.playSound((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "portal.portal", 0.5F, par5Random.nextFloat() * 0.4F + 0.8F, false);
		}
		for (int l = 0; l < 4; ++l)
		{
			double d0 = (double)((float)par2 + par5Random.nextFloat());
			double d1 = (double)((float)par3 + par5Random.nextFloat());
			double d2 = (double)((float)par4 + par5Random.nextFloat());
			double d3 = 0.0D;
			double d4 = 0.0D;
			double d5 = 0.0D;
			int i1 = par5Random.nextInt(2) * 2 - 1;
			d3 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
			d4 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
			d5 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
			if (par1World.getBlockId(par2 - 1, par3, par4) != this.blockID && par1World.getBlockId(par2 + 1, par3, par4) != this.blockID)
			{
				d0 = (double)par2 + 0.5D + 0.25D * (double)i1;
				d3 = (double)(par5Random.nextFloat() * 2.0F * (float)i1);
			}
			else
			{
				d2 = (double)par4 + 0.5D + 0.25D * (double)i1;
				d5 = (double)(par5Random.nextFloat() * 2.0F * (float)i1);
			}
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
	}
	
	@SideOnly(Side.CLIENT)
	/**
	 * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
	 */
	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		return 0;
	}
}