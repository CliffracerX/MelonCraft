package cliffracerx.mods.meloncraft.src;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.COAL;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.DIAMOND;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.DIRT;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.GOLD;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.GRAVEL;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.IRON;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.LAPIS;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.REDSTONE;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenSpikes;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class MelonBiomeDecor extends BiomeDecorator
{
    protected WorldGenerator[] gens = new WorldGenerator[13];
    private WorldGenerator blahGen;

    public MelonBiomeDecor(BiomeGenBase par1BiomeGenBase)
    {
        super(par1BiomeGenBase);
        System.out.println("MelonBiomeDecor is GO!");
        /*this.dirtGen = new MelonOreGen(MelonCraft.melonDirt.blockID, 32);
        this.gravelGen = new WorldGenMinable(Block.gravel.blockID, 32);
        this.coalGen = new WorldGenMinable(Block.oreCoal.blockID, 16);
        //this.ironGen = new MelonOreGen(MelonCraft.moonstoneOre.blockID, 8);
        //this.goldGen = new WorldGenMinable(MelonCraft.plazmaOre.blockID, 4);
        this.redstoneGen = new WorldGenMinable(Block.oreRedstone.blockID, 7);
        this.diamondGen = new WorldGenMinable(Block.oreDiamond.blockID, 7);
        this.lapisGen = new WorldGenMinable(Block.oreLapis.blockID, 6);*/
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
        this.generateOres();
        /*this.gens[0]=new WorldGenMelTree(true);
        this.gens[1]=new WorldGenLakes(MelonCraft.melonjuice.blockID);
        this.gens[2]=new WorldGenLakes(MelonCraft.magilava.blockID);
        this.gens[3]=new MelonOreGen(MelonCraft.melonDirt.blockID, 32);
        this.gens[4]=new MagistoneGen();
        this.gens[5]=new WorldGenDyeTree(true);
        this.gens[6]=new WorldGenLakes(MelonCraft.redML.blockID);
        this.gens[7]=new WorldGenLakes(MelonCraft.greenMJ.blockID);
        this.gens[8]=new WorldGenLakes(MelonCraft.greenML.blockID);
        this.gens[9]=new WorldGenLakes(MelonCraft.blueMJ.blockID);
        this.gens[10]=new WorldGenLakes(MelonCraft.blueML.blockID);
        this.gens[11]=new MelonOreGen(MelonCraft.moonstoneOre.blockID, 32);
        this.gens[12]=new BiomeGen(MelonCraft.frostyGrass.blockID, 128);
        MelonCaveGen cave = new MelonCaveGen();*/
        int i = 5;
        int j = 0;
        int k = 0;
        int l = 0;
        boolean doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, TREE);
        for (j = 0; doGen && j < i; ++j)
        {
            k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            l = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;/*
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
            else if(worldgenerator==this.gens[5])
            {
            if(this.randomGenerator.nextInt(4)==0)
            worldgenerator.generate(this.currentWorld, this.randomGenerator, k, this.currentWorld.getHeightValue(k, l), l);
            }
            else if(worldgenerator==this.gens[11])
            {
            if(this.randomGenerator.nextInt(6)==0)
            worldgenerator.generate(this.currentWorld, this.randomGenerator, k, this.currentWorld.getHeightValue(k, l), l);
            }
            else if(worldgenerator==this.gens[12])
            {
            if(this.randomGenerator.nextInt(99)==0)
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
    
    protected void generateOres()
    {
        /*//MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Pre(currentWorld, randomGenerator, chunk_X, chunk_Z));
        if (TerrainGen.generateOre(currentWorld, randomGenerator, dirtGen, chunk_X, chunk_Z, DIRT))
        this.genStandardOre1(20, this.dirtGen, 0, 128);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, gravelGen, chunk_X, chunk_Z, GRAVEL))
        this.genStandardOre1(10, this.gravelGen, 0, 128);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, coalGen, chunk_X, chunk_Z, COAL))
        this.genStandardOre1(20, this.coalGen, 0, 128);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, ironGen, chunk_X, chunk_Z, IRON))
        {
        this.genStandardOre1(20, this.ironGen, 0, 64);
        this.blahGen = new MelonOreGen(MelonCraft.plazmaOre.blockID, 7);
        this.genStandardOre1(1, this.blahGen, 0, 64);
        this.blahGen = new MelonOreGen(MelonCraft.bendyOre.blockID, 7);
        this.genStandardOre1(8, this.blahGen, 0, 64);
        }
        if (TerrainGen.generateOre(currentWorld, randomGenerator, goldGen, chunk_X, chunk_Z, GOLD))
        this.genStandardOre1(20, this.goldGen, 0, 64);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, redstoneGen, chunk_X, chunk_Z, REDSTONE))
        this.genStandardOre1(8, this.redstoneGen, 0, 16);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, diamondGen, chunk_X, chunk_Z, DIAMOND))
        this.genStandardOre1(1, this.diamondGen, 0, 16);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, lapisGen, chunk_X, chunk_Z, LAPIS))
        this.genStandardOre2(1, this.lapisGen, 16, 16);
        //MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Post(currentWorld, randomGenerator, chunk_X, chunk_Z));*/
    }
}
