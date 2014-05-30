package cliffracerx.mods.meloncraft.src;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;

public class MelonDamageSource extends DamageSource
{
    private String deathMessageBase;

    public MelonDamageSource(String par1Str, String par2Str)
    {
        super(par1Str);
        this.deathMessageBase=par2Str;
    }
}
