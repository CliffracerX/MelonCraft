package cliffracerx.mods.meloncraft.src;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MelonBlockNormal extends Block
{
    private String tex;
    
    public MelonBlockNormal(int id, Material material, String texture)
    {
        super(id, material);
        this.tex = texture;
        setTextureName("MelonCraft:" + texture);
    }
}
