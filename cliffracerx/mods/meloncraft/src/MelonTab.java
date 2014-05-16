package cliffracerx.mods.meloncraft.src;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MelonTab extends CreativeTabs
{
    // Main constructor, nothing to see here.
    public MelonTab(String label)
    {
        super(label);
    }
    
    // This sets the item/block seen as the creative tab's icon. :D
    // We set it to our custom block.
    @Override
    public ItemStack getIconItemStack()
    {
        return new ItemStack(MelonCraft.melonDirt);
    }
}
