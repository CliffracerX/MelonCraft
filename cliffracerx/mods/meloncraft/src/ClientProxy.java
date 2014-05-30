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
        MinecraftForgeClient.registerItemRenderer(MelonCraft.redmagicappedChargedWandID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.redmagicappedChargedWandFireFocusID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.redmagicappedChargedWandIceFocusID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.orangemagicappedChargedWandID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.orangemagicappedChargedWandFireFocusID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.orangemagicappedChargedWandIceFocusID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.yellowmagicappedChargedWandID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.yellowmagicappedChargedWandFireFocusID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.yellowmagicappedChargedWandIceFocusID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.greenmagicappedChargedWandID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.greenmagicappedChargedWandFireFocusID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.greenmagicappedChargedWandIceFocusID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.cyanmagicappedChargedWandID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.cyanmagicappedChargedWandFireFocusID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.cyanmagicappedChargedWandIceFocusID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.bluemagicappedChargedWandID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.bluemagicappedChargedWandFireFocusID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.bluemagicappedChargedWandIceFocusID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.purplemagicappedChargedWandID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.purplemagicappedChargedWandFireFocusID+256, new MelonWandRenderer());
        MinecraftForgeClient.registerItemRenderer(MelonCraft.purplemagicappedChargedWandIceFocusID+256, new MelonWandRenderer());
    }
}
