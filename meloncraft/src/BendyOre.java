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

public class BendyOre extends Block {
		String tex;
		float hard;
		boolean overwrite;
		int tr;
        public BendyOre (int id, Material material, String texture, float hrd, boolean b, int tier) {
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
        	//if(this.tr==0)
        	{
            if(player.getHeldItem().getItem() instanceof MelonPick)
            {
            	MelonPick pick =(MelonPick) player.getHeldItem().getItem();
            	if(pick.tier>=this.tr)
            	this.setHardness(this.hard);
            }
            else
            this.setBlockUnbreakable();
        	}
        	}
        	else
                this.setBlockUnbreakable();
        }
        
        public int idDropped(int par1, Random par2Random, int par3)
        {
            return MelonCraft.bendybarBlob.itemID;
        }
        
        public int quantityDropped(Random par1Random)
        {
            return 4+par1Random.nextInt(2);
        }
}