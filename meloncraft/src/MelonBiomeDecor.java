package meloncraft.src;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenSpikes;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class MelonBiomeDecor extends BiomeDecorator
{
    protected WorldGenerator[] gens = new WorldGenerator[5];

    public MelonBiomeDecor(BiomeGenBase par1BiomeGenBase)
    {
        super(par1BiomeGenBase);
        System.out.println("MelonBiomeDecor is GO!");
    }
    
    public void decorate(World par1World, Random par2Random, int par3, int par4)
    {
    	if(this.currentWorld!=null)
    	{
    		System.out.println("ALERT: CurrentWorld exists.");
    	}
    	else
        {
            this.currentWorld = par1World;
            this.randomGenerator = par2Random;
            this.chunk_X = par3;
            this.chunk_Z = par4;
            this.decorate();
            this.currentWorld = null;
            this.randomGenerator = null;
        }
    }

    /**
     * The method that does the work of actually decorating chunks
     */
    public void decorate()
    {
    	byte abyte0[] = new byte[32768];
        //this.generateOres();
    	this.gens[0]=new WorldGenMelTree(true);
    	this.gens[1]=new WorldGenLakes(MelonCraft.melonjuice.blockID);
    	this.gens[2]=new WorldGenLakes(MelonCraft.magilava.blockID);
    	this.gens[3]=new MelonOreGen(MelonCraft.melonDirt.blockID, 32);
    	this.gens[4]=new MagistoneGen();
    	MelonCaveGen cave = new MelonCaveGen();
    	int i = 5;
    	int j = 0;
    	int k = 0;
    	int l = 0;
    	boolean doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, TREE);
        for (j = 0; doGen && j < i; ++j)
        {
            k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            l = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            WorldGenerator worldgenerator = this.gens[this.randomGenerator.nextInt(this.gens.length)];
            worldgenerator.setScale(1.0D, 1.0D, 1.0D);
            if(worldgenerator==this.gens[0])
            {
            worldgenerator.generate(this.currentWorld, this.randomGenerator, k, this.currentWorld.getHeightValue(k, l), l);
            }
            else if(worldgenerator==this.gens[1])
            {
            if(this.randomGenerator.nextInt(32)==0)
            worldgenerator.generate(this.currentWorld, this.randomGenerator, k, this.currentWorld.getHeightValue(k, l), l);
            }
            else if(worldgenerator==this.gens[2])
            {
            if(this.randomGenerator.nextInt(48)==0)
            worldgenerator.generate(this.currentWorld, this.randomGenerator, k, this.currentWorld.getHeightValue(k, l), l);
            }
            else if(worldgenerator==this.gens[3])
            {
            if(this.randomGenerator.nextInt(4)==0)
            worldgenerator.generate(this.currentWorld, this.randomGenerator, k, this.currentWorld.getHeightValue(k, l), l);
            }
            else if(worldgenerator==this.gens[4])
            {
            if(this.randomGenerator.nextInt(8)==0)
            worldgenerator.generate(this.currentWorld, this.randomGenerator, k, this.currentWorld.getHeightValue(k, l), l);
            }
            //if(this.randomGenerator.nextInt(32)==0)
        	{
        		//cave.generate(currentWorld, k, l, abyte0);
        	}
            /*if (this.randomGenerator.nextInt(2) == 0 && doGen)
            {
                int i1 = k + this.randomGenerator.nextInt(16) + 8;
                this.currentWorld.getClass();
                int l4 = this.randomGenerator.nextInt(128);
                int i8 = l + this.randomGenerator.nextInt(16) + 8;
                (new WorldGenLakes(MelonCraft.melonjuice.blockID)).generate(this.currentWorld, this.randomGenerator, i1, l4, i8);
            }

            if (this.randomGenerator.nextInt(4) == 0 && doGen)
            {
                int i1 = k + this.randomGenerator.nextInt(16) + 8;
                this.currentWorld.getClass();
                int l4 = this.randomGenerator.nextInt(128);
                int i8 = l + this.randomGenerator.nextInt(16) + 8;
                (new WorldGenLakes(MelonCraft.magilava.blockID)).generate(this.currentWorld, this.randomGenerator, i1, l4, i8);
            }*/
        }

//        if (this.chunk_X == 0 && this.chunk_Z == 0)
        {
//            EntityDragon entitydragon = new EntityDragon(this.currentWorld);
//            entitydragon.setLocationAndAngles(0.0D, 128.0D, 0.0D, this.randomGenerator.nextFloat() * 360.0F, 0.0F);
//            this.currentWorld.spawnEntityInWorld(entitydragon);
        }
    }
}
