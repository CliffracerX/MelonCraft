package cliffracerx.mods.meloncraft.src;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MelonBlockStone extends Block
{
    private String tex;
    private int tr;
    private float hard;
    
    public MelonBlockStone(int id, Material material, String texture, int tier, float hard)
    {
        super(id, material);
        this.tex = texture;
        this.tr=tier;
        this.hard=hard;
        setTextureName("MelonCraft:" + texture);
    }
    
    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
    {
        if(player.getHeldItem()!=null)
        {
        //if(this.tr==0)
        {
        if(player.getHeldItem().getItem() instanceof MelonPickaxe)
        {
            MelonPickaxe pick =(MelonPickaxe) player.getHeldItem().getItem();
            if(pick.tier>=this.tr)
            this.setHardness(this.hard);
            else
            this.setBlockUnbreakable();
        }
        else
        this.setBlockUnbreakable();
        }
        }
        else
            this.setBlockUnbreakable();
    }
}
