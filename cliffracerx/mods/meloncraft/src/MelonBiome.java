package cliffracerx.mods.meloncraft.src;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class MelonBiome extends BiomeGenBase
{
    public MelonBiome(int par1)
    {
        super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        //this.spawnableMonsterList.add(new SpawnListEntry(MelonZombie.class, 1, 1, 4));
        //this.spawnableCreatureList.add(new SpawnListEntry(MelonSheep.class, 4, 1, 2));
        /*this.topBlock = (byte)Block.dirt.blockID;
        this.fillerBlock = (byte)Block.dirt.blockID;
        this.theBiomeDecorator = new BiomeEndDecorator(this);*/
        this.theBiomeDecorator = new MelonBiomeDecor(this);
    }

    @SideOnly(Side.CLIENT)

    /**
     * takes temperature, returns color
     */
    public int getSkyColorByTemp(float par1)
    {
        return 0x86dd5a;
    }
}
