package meloncraft.src;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.src.ModLoader;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class SoundManager
{
    @ForgeSubscribe
    @SideOnly(Side.CLIENT)
    public void onSound(SoundLoadEvent event)
    {
    	System.out.println("BLAAAH  PFFF");
        try 
        {
            event.manager.soundPoolSounds.addSound("melsound/melzomb.ogg", MelonCraft.class.getResource("/melsound/melzomb.ogg"));
            event.manager.soundPoolSounds.addSound("melsound/melzombd.ogg", MelonCraft.class.getResource("/melsound/melzombd.ogg"));
        } 
        catch (Exception e)
        {
            System.err.println("Failed to register one or more sounds.");
        }
    }
}