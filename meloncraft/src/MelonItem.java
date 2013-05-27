package meloncraft.src;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapData;

public class MelonItem extends Item {

        private String itemTexFile;

		public MelonItem(int id, String TF, int stackSize) {
                super(id);
                
                // Constructor Configuration
                maxStackSize = stackSize;
                this.itemTexFile=TF;
                setCreativeTab(MelonCraft.MelonTab);
                setUnlocalizedName("genericItem");
        }
        
        public void func_94581_a(IconRegister iconRegister)
        {
                 iconIndex = iconRegister.func_94245_a("MelonCraft:"+this.itemTexFile);
        }


}