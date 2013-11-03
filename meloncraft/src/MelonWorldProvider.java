package meloncraft.src;

import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class MelonWorldProvider extends WorldProvider
{
    /**
     * creates a new world chunk manager for WorldProvider
     */
    public void registerWorldChunkManager()
    {
        this.worldChunkMgr = new WorldChunkManagerHell(MelonCraft.biome, 0.5F, 0.0F);
        this.dimensionId = -2;
        
    }
    
    @Override
    public double getHorizon()
    {
    	return 0.0D;
    }

    /**
     * Returns the chunk provider back for the world provider
     */
    @Override
    public IChunkProvider createChunkGenerator()
    {
        return new MelonChunkProvider(this.worldObj, this.worldObj.getSeed());
    }

    /*@Override
    public float calculateCelestialAngle(long par1, float par3)
    {
        /*int var4 = (int)(par1 % 100000L);
        float var5 = ((float)var4 + par3) / 100000.0F - 0.4F;

        if (var5 < 0.0F)
        {
            ++var5;
        }

        if (var5 > 0.2F)
        {
            --var5;
        }

        float var6 = var5;
        var5 = 2.0F - (float)((Math.cos((double)var5 * Math.PI) + 0.2D) / 0.2D);
        var5 = var6 + (var5 - var6) / 0.2F;
        return var5;*/
    	/*return 0.0F;
    }*/
    /**
     * True if the player can respawn in this dimension (true = overworld, false = nether).
     */
    @Override
    public boolean canRespawnHere()
    {
        return true;
    }

    /**
     * Will check if the x, z position specified is alright to be set as the map spawn point
     */
    @Override
    public boolean canCoordinateBeSpawn(int par1, int par2)
    {
        int var3 = this.worldObj.getFirstUncoveredBlock(par1, par2);
        return var3 == 0 ? false : Block.blocksList[var3].blockMaterial.blocksMovement();
    }

	@Override
    public int getAverageGroundLevel()
    {
        return 256;
    }

    @Override
    public String getSaveFolder()
    {
        return "Melondim_real";
    }

    @Override
    public String getWelcomeMessage()
    {
        return "Welcome to the melondimension.";
    }

    @Override
    public String getDepartMessage()
    {
        return "Come back to the melondimension soon!";
    }

	@Override
	public String getDimensionName() {
		return "Melondim";
	}
	

	@Override
    public Vec3 getFogColor(float f, float f1)
    {
        int i = 0x8080a0;
        float f2 = MathHelper.cos(f * 3.141593F * 2.0F) * 2.0F + 0.5F;
        if(f2 < 0.0F)
        {
            f2 = 0.0F;
        }
        if(f2 > 1.0F)
        {
            f2 = 1.0F;
        }
        float f3 = (float)(i >> 16 & 0xff) / 255F;
        float f4 = (float)(i >> 8 & 0xff) / 255F;
        float f5 = (float)(i & 0xff) / 255F;
        f3 *= f2 * 0.94F + 0.06F;
        f4 *= f2 * 0.94F + 0.06F;
        f5 *= f2 * 0.91F + 0.09F;
        return this.worldObj.getWorldVec3Pool().getVecFromPool((double)f3, (double)f4, (double)f5);
    }

	@Override
    public float getCloudHeight()
    {
        return 8F;
    }
}
