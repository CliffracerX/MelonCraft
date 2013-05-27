package meloncraft.src;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MelTab extends CreativeTabs
{
	
	public MelTab(String label)
	{
	    super(label);
	}
	
	
	@Override
	public ItemStack getIconItemStack()
	{
	    return new ItemStack(MelonCraft.melonDirt);
	}
}
