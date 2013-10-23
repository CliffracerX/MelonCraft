package meloncraft.src;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class MelonFurnace extends BlockContainer
{
    /**
     * Is the random generator used by melonFurnace to drop the inventory contents in random directions.
     */
    private final Random melonFurnaceRand = new Random();

    /** True if this is an active melonFurnace, false if idle */
    private final boolean isActive;

    /**
     * This flag is used to prevent the melonFurnace inventory to be dropped upon block removal, is used internally when the
     * melonFurnace block changes from idle to active and vice-versa.
     */
    private static boolean keepFurnaceInventory = false;
    @SideOnly(Side.CLIENT)
    private Icon field_94458_cO;
    @SideOnly(Side.CLIENT)
    private Icon field_94459_cP;
    private float hard;

    protected MelonFurnace(int par1, boolean par2, float hrd)
    {
        super(par1, Material.ground);
        this.hard=hrd;
        this.isActive = par2;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return MelonCraft.melonFurnaceIdle.blockID;
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
    }

    /**
     * set a blocks direction
     */
    private void setDefaultDirection(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            int l = par1World.getBlockId(par2, par3, par4 - 1);
            int i1 = par1World.getBlockId(par2, par3, par4 + 1);
            int j1 = par1World.getBlockId(par2 - 1, par3, par4);
            int k1 = par1World.getBlockId(par2 + 1, par3, par4);
            byte b0 = 3;

            if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
            {
                b0 = 3;
            }

            if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
            {
                b0 = 2;
            }

            if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
            {
                b0 = 5;
            }

            if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
            {
                b0 = 4;
            }

            par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        return par1 == 1 ? this.field_94458_cO : (par1 == 0 ? this.field_94458_cO : (par1 != par2 ? this.field_94336_cN : this.field_94459_cP));
    }

    @SideOnly(Side.CLIENT)
    public void func_94332_a(IconRegister par1IconRegister)
    {
        this.field_94336_cN = par1IconRegister.func_94245_a("MelonCraft:"+"melonFurnaceSide");
        this.field_94459_cP = par1IconRegister.func_94245_a("MelonCraft:"+(this.isActive ? "melonFurnaceFrontOn" : "melonFurnaceFront"));
        this.field_94458_cO = par1IconRegister.func_94245_a("MelonCraft:"+"melonFurnaceTop");
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
        {
            return true;
        }
        else
        {
            MelonFurnaceTileEnt MelonFurnaceTileEnt = (MelonFurnaceTileEnt)par1World.getBlockTileEntity(par2, par3, par4);

            if (MelonFurnaceTileEnt != null)
            {
                MelonCraft.openCustomGui(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9, 1);
            }

            return true;
        }
    }

    /**
     * Update which block ID the melonFurnace is using depending on whether or not it is burning
     */
    public static void updateFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        TileEntity tileentity = par1World.getBlockTileEntity(par2, par3, par4);
        keepFurnaceInventory = true;

        if (par0)
        {
            par1World.func_94575_c(par2, par3, par4, MelonCraft.melonFurnaceLit.blockID);
        }
        else
        {
            par1World.func_94575_c(par2, par3, par4, MelonCraft.melonFurnaceIdle.blockID);
        }

        keepFurnaceInventory = false;
        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);

        if (tileentity != null)
        {
            tileentity.validate();
            par1World.setBlockTileEntity(par2, par3, par4, tileentity);
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (this.isActive)
        {
            int l = par1World.getBlockMetadata(par2, par3, par4);
            float f = (float)par2 + 0.5F;
            float f1 = (float)par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
            float f2 = (float)par4 + 0.5F;
            float f3 = 0.52F;
            float f4 = par5Random.nextFloat() * 0.6F - 0.3F;

            if (l == 4)
            {
                par1World.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 5)
            {
                par1World.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 2)
            {
                par1World.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 3)
            {
                par1World.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World par1World)
    {
        return new MelonFurnaceTileEnt();
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (l == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        }

        if (l == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }

        if (l == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
        }

        if (par6ItemStack.hasDisplayName())
        {
            ((MelonFurnaceTileEnt)par1World.getBlockTileEntity(par2, par3, par4)).func_94129_a(par6ItemStack.getDisplayName());
        }
    }

    /**
     * ejects contained items into the world, and notifies neighbours of an update, as appropriate
     */
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        if (!keepFurnaceInventory)
        {
            MelonFurnaceTileEnt MelonFurnaceTileEnt = (MelonFurnaceTileEnt)par1World.getBlockTileEntity(par2, par3, par4);

            if (MelonFurnaceTileEnt != null)
            {
                for (int j1 = 0; j1 < MelonFurnaceTileEnt.getSizeInventory(); ++j1)
                {
                    ItemStack itemstack = MelonFurnaceTileEnt.getStackInSlot(j1);

                    if (itemstack != null)
                    {
                        float f = this.melonFurnaceRand.nextFloat() * 0.8F + 0.1F;
                        float f1 = this.melonFurnaceRand.nextFloat() * 0.8F + 0.1F;
                        float f2 = this.melonFurnaceRand.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0)
                        {
                            int k1 = this.melonFurnaceRand.nextInt(21) + 10;

                            if (k1 > itemstack.stackSize)
                            {
                                k1 = itemstack.stackSize;
                            }

                            itemstack.stackSize -= k1;
                            EntityItem entityitem = new EntityItem(par1World, (double)((float)par2 + f), (double)((float)par3 + f1), (double)((float)par4 + f2), new ItemStack(itemstack.itemID, k1, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound())
                            {
                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }

                            float f3 = 0.05F;
                            entityitem.motionX = (double)((float)this.melonFurnaceRand.nextGaussian() * f3);
                            entityitem.motionY = (double)((float)this.melonFurnaceRand.nextGaussian() * f3 + 0.2F);
                            entityitem.motionZ = (double)((float)this.melonFurnaceRand.nextGaussian() * f3);
                            par1World.spawnEntityInWorld(entityitem);
                        }
                    }
                }
            }
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }

    public boolean func_96468_q_()
    {
        return true;
    }

    public int func_94328_b_(World par1World, int par2, int par3, int par4, int par5)
    {
        return Container.func_94526_b((IInventory)par1World.getBlockTileEntity(par2, par3, par4));
    }
    
    public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
    {
    	if(par5EntityPlayer.getHeldItem()!=null)
    	{
        if(par5EntityPlayer.getHeldItem().getItem() == MelonCraft.melWoodPick || par5EntityPlayer.getHeldItem().getItem() == MelonCraft.melStonePick || par5EntityPlayer.getHeldItem().getItem() == MelonCraft.moonStonePick || par5EntityPlayer.getHeldItem().getItem() == MelonCraft.plazPick)
        {
        	this.setHardness(this.hard);
        }
        else
        this.setBlockUnbreakable();
    	}
        else
        this.setBlockUnbreakable();
    }
}
