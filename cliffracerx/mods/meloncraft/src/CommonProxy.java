package cliffracerx.mods.meloncraft.src;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler
{
    public static void registerRenderers()
    {
        
    }
    
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        //MelonFurnaceTileEnt melFurnTile=(MelonFurnaceTileEnt) world.getBlockTileEntity(x, y, z);
        if(ID==0)
        return new MelCraftingContain(player.inventory, world, x, y, z);
        /*else if(ID==1)
        {
        if(melFurnTile!=null)
        return new MelFurnContain(player.inventory, melFurnTile);
        else
        return null;
        }*/
        else
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        //MelonFurnaceTileEnt melFurnTile=(MelonFurnaceTileEnt) world.getBlockTileEntity(x, y, z);
        if(ID==0)
        return new MelCraftingGui(player.inventory, world, x, y, z);
        /*else if(ID==1)
        {
        if(melFurnTile!=null)
        return new GuiMelFurn(player.inventory, melFurnTile);
        else
        return null;
        }*/
        else
        return null;
    }
}
