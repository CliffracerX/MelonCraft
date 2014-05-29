package cliffracerx.mods.meloncraft.src;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
    //@Override
    public static void registerRenderers()
    {
        MinecraftForgeClient.registerItemRenderer(MelonCraft.moonstoneCappedWoodenWandID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.moonstoneCappedWoodenWandFireFocusID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.moonstoneCappedWoodenWandIceFocusID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.limemagicappedChargedWandID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.limemagicappedChargedWandFireFocusID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.limemagicappedChargedWandIceFocusID+256, new MelonWandRenderer());
    }
}
