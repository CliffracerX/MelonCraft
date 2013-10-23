package meloncraft.src;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderZombie;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy
{
	@SideOnly(Side.CLIENT)
    public static void registerRenderInformation()
    {
		System.out.println("AAAHafgbpijaghon *boom*");
    
    	RenderingRegistry.instance().registerEntityRenderingHandler(EntityMelonwoolSoldier.class, new RenderBiped(new ModelBiped(), 1F));
    	RenderingRegistry.instance().registerEntityRenderingHandler(EntityMiniMelonwoolSoldier.class, new RenderMiniMWS(new ModelMiniMWS(), 1F));
    	RenderingRegistry.instance().registerEntityRenderingHandler(MelonZombie.class, new NewRenderZombie());
    	RenderingRegistry.instance().registerEntityRenderingHandler(MelonSheep.class, new RenderSheep(new ModelSheep2(), new ModelSheep1(), 1F));
    }
	
	@SideOnly(Side.CLIENT)
	public static int addArmour(String armour)
	{
		 return RenderingRegistry.addNewArmourRendererPrefix(armour);
	}
}