package meloncraft.src;


import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy
{
	@SideOnly(Side.CLIENT)
    public static void registerRenderInformation()
    {
		System.out.println("AAAHafgbpijaghon *boom*");
    
    	//RenderingRegistry.instance().registerEntityRenderingHandler(Kingdomcraftian.class, new RenderBiped(new ModelBiped(), 1F));
    }
}