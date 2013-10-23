package meloncraft.src;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class Dyepot extends Block
{
	private String color;
	private String texture;
	private Icon field_94385_a;
    public Dyepot(int i, String clr, String tex)
    {
        super(i, Material.ground);
        this.color=clr;
        this.texture=tex;
        setCreativeTab(MelonCraft.MelonTab);
    }
    
    public void func_94332_a(IconRegister iconRegister)
    {
             this.field_94385_a = iconRegister.func_94245_a("MelonCraft:"+this.texture);
    }
    
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    	if (par1World.isRemote)
    	{
    		return true;
    	}
    	else
    	{
    		if(par5EntityPlayer.getHeldItem()!=null)
    		{
    		int temp = par5EntityPlayer.getHeldItem().stackSize;
    		if(par5EntityPlayer.getHeldItem().itemID==MelonCraft.magStone.blockID || par5EntityPlayer.getHeldItem().itemID==MelonCraft.redMGST.blockID || par5EntityPlayer.getHeldItem().itemID==MelonCraft.greenMGST.blockID || par5EntityPlayer.getHeldItem().itemID==MelonCraft.blueMGST.blockID)
    		{
    			System.out.println("Is magistone!");
    			if(this.color=="red")
    			{
    				par5EntityPlayer.inventory.mainInventory[par5EntityPlayer.inventory.currentItem] = new ItemStack(MelonCraft.redMGST, temp);
    			}
    			else if(this.color=="green")
    			{
    				par5EntityPlayer.inventory.mainInventory[par5EntityPlayer.inventory.currentItem] = new ItemStack(MelonCraft.greenMGST, temp);
    			}
    			else if(this.color=="blue")
    			{
    				par5EntityPlayer.inventory.mainInventory[par5EntityPlayer.inventory.currentItem] = new ItemStack(MelonCraft.blueMGST, temp);
    			}
    		}
    		else if(par5EntityPlayer.getHeldItem().itemID==MelonCraft.normalMW.blockID || par5EntityPlayer.getHeldItem().itemID==MelonCraft.redMW.blockID || par5EntityPlayer.getHeldItem().itemID==MelonCraft.greenMW.blockID || par5EntityPlayer.getHeldItem().itemID==MelonCraft.blueMW.blockID)
    		{
    			System.out.println("Is melonwool!");
    			if(this.color=="red")
    			{
    				par5EntityPlayer.inventory.mainInventory[par5EntityPlayer.inventory.currentItem] = new ItemStack(MelonCraft.redMW, temp);
    			}
    			else if(this.color=="green")
    			{
    				par5EntityPlayer.inventory.mainInventory[par5EntityPlayer.inventory.currentItem] = new ItemStack(MelonCraft.greenMW, temp);
    			}
    			else if(this.color=="blue")
    			{
    				par5EntityPlayer.inventory.mainInventory[par5EntityPlayer.inventory.currentItem] = new ItemStack(MelonCraft.blueMW, temp);
    			}
    		}
    		else if(par5EntityPlayer.getHeldItem().itemID==MelonCraft.melonjuice.blockID || par5EntityPlayer.getHeldItem().itemID==MelonCraft.redMJ.blockID || par5EntityPlayer.getHeldItem().itemID==MelonCraft.greenMJ.blockID || par5EntityPlayer.getHeldItem().itemID==MelonCraft.blueMJ.blockID)
    		{
    			System.out.println("Is melonjuice!");
    			if(this.color=="red")
    			{
    				par5EntityPlayer.inventory.mainInventory[par5EntityPlayer.inventory.currentItem] = new ItemStack(MelonCraft.redMJ, temp);
    			}
    			else if(this.color=="green")
    			{
    				par5EntityPlayer.inventory.mainInventory[par5EntityPlayer.inventory.currentItem] = new ItemStack(MelonCraft.greenMJ, temp);
    			}
    			else if(this.color=="blue")
    			{
    				par5EntityPlayer.inventory.mainInventory[par5EntityPlayer.inventory.currentItem] = new ItemStack(MelonCraft.blueMJ, temp);
    			}
    		}
    		else if(par5EntityPlayer.getHeldItem().itemID==MelonCraft.magilava.blockID || par5EntityPlayer.getHeldItem().itemID==MelonCraft.redML.blockID || par5EntityPlayer.getHeldItem().itemID==MelonCraft.greenML.blockID || par5EntityPlayer.getHeldItem().itemID==MelonCraft.blueML.blockID)
    		{
    			System.out.println("Is magilava!");
    			if(this.color=="red")
    			{
    				par5EntityPlayer.inventory.mainInventory[par5EntityPlayer.inventory.currentItem] = new ItemStack(MelonCraft.redML, temp);
    			}
    			else if(this.color=="green")
    			{
    				par5EntityPlayer.inventory.mainInventory[par5EntityPlayer.inventory.currentItem] = new ItemStack(MelonCraft.greenML, temp);
    			}
    			else if(this.color=="blue")
    			{
    				par5EntityPlayer.inventory.mainInventory[par5EntityPlayer.inventory.currentItem] = new ItemStack(MelonCraft.blueML, temp);
    			}
    		}
    		}
    		return true;
    	}
    }
    
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        return par1 == 1 ? this.field_94385_a : MelonCraft.melonPlanks.getBlockTextureFromSide(par1);
    }
}