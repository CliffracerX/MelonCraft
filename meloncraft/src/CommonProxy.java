package meloncraft.src;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler
{
    public static void registerRenderInformation()
    {
        
    }
    
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
    	if(ID==0)
        return new MelCraftingContain(player.inventory, world, x, y, z);
    	else
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
    	if(ID==0)
        return new MelCraftingGui(player.inventory, world, x, y, z);
    	else
        return null;
    }
}