package cliffracerx.mods.meloncraft.src;
import net.minecraft.util.ChunkCoordinates;
public class MelPortPos extends ChunkCoordinates
{
public long field_85087_d;
final TeleporterMelondim field_85088_e;
public MelPortPos(TeleporterMelondim skyTel, int par2, int par3, int par4, long par5)
{
super(par2, par3, par4);
this.field_85088_e = skyTel;
this.field_85087_d = par5;
}
}