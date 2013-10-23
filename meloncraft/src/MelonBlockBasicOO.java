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

public class MelonBlockBasicOO extends Block {
		String tex;
        public MelonBlockBasicOO (int id, Material material, String texture) {
                super(id, material);
                this.tex=texture;
        }
        
        public void func_94332_a(IconRegister iconRegister)
        {
                 this.field_94336_cN = iconRegister.func_94245_a("MelonCraft:"+this.tex);
        }
        
        public boolean isGenMineableReplaceable(World world, int x, int y, int z)
        {
            return false;
        }
        
        public boolean isOpaqueCube()
        {
            return true;
        }

        public boolean renderAsNormalBlock()
        {
            return true;
        }
}