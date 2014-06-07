package cliffracerx.mods.meloncraft.src;

import java.util.Arrays;
import morph.common.ability.AbilityHandler;
import morph.common.ability.AbilityStep;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.BlockStationary;
import net.minecraft.block.StepSound;
import net.minecraft.client.gui.GuiFlatPresets;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.FlatLayerInfo;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.common.event.FMLInterModComms;

@Mod(modid = "MelonCraft", name = "MelonCraft",
        version = "Initial Commit (1.6 update)")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MelonCraft
{
    public final static CreativeTabs tab = new MelonTab("meloncraftLoot");
    public static int melonDirtID = 232;
    public static int melonStoneID = 233;
    public static int melonGrassID = 234;
    public static int portalID = 235;
    public static int magistoneID = 1836;
    public static int melonlogID = 1837;
    public static int melonplanksID = 1838;
    public static int melonleavesID = 1839;
    public static int melonsaplingID = 1840;
    public static int meloncobbleID = 1841;
    public static int melonjuiceID = 1842;
    public static int magilavaID = 1843;
    public static int melonBenchID = 1844;
    public static int moonstoneOreID = 1845;
    public static int moonstoneBlockID = 1846;
    public static int redMGSTID = 1847;
    public static int orangeMGSTID = 1848;
    public static int yellowMGSTID = 1849;
    public static int limeMGSTID = 1850;
    public static int greenMGSTID = 1851;
    public static int cyanMGSTID = 1852;
    public static int blueMGSTID = 1853;
    public static int purpleMGSTID = 1854;
    public static int redMWID = 1855;
    public static int orangeMWID = 1856;
    public static int yellowMWID = 1857;
    public static int limeMWID = 1858;
    public static int greenMWID = 1859;
    public static int cyanMWID = 1860;
    public static int blueMWID = 1861;
    public static int purpleMWID = 1862;
    public static int greyMWID = 1863;
    public static int normalMWID = 1864;
    public static Block melonDirt;
    public static Block melonStone;
    public static Block melonGrass;
    public static Block portal;
    public static Block magistone;
    public static Block melonlog;
    public static Block melonplanks;
    public static Block melonleaves;
    public static Block melonsapling;
    public static Block meloncobble;
    public static Block melonjuice;
    public static Block magilava;
    public static Block melonBench;
    public static Block moonstoneOre;
    public static Block moonstoneBlock;
    public static Block redMGST;
    public static Block orangeMGST;
    public static Block yellowMGST;
    public static Block limeMGST;
    public static Block greenMGST;
    public static Block cyanMGST;
    public static Block blueMGST;
    public static Block purpleMGST;
    public static Block redMW;
    public static Block orangeMW;
    public static Block yellowMW;
    public static Block limeMW;
    public static Block greenMW;
    public static Block cyanMW;
    public static Block blueMW;
    public static Block purpleMW;
    public static Block greyMW;
    public static Block normalMW;
    public static int melonstickID = 9801;
    public static int melonwoodpickID = 9802;
    public static int melonstonepickID = 9803;
    public static int melonwoodaxeID = 9804;
    public static int melonstoneaxeID = 9805;
    public static int melonwoodshovelID = 9806;
    public static int melonstoneshovelID = 9807;
    public static int magiDustID = 9808;
    public static int moonstoneIngotID = 9809;
    public static int moonstoneshovelID = 9810;
    public static int moonstoneaxeID = 9811;
    public static int moonstonepickID = 9812;
    public static int moonstoneCappedWoodenWandID = 9813;
    public static int moonstoneCappedWoodenWandFireFocusID = 9814;
    public static int moonstoneCappedWoodenWandIceFocusID = 9815;
    public static int limemagicappedChargedWandID = 9816;
    public static int limemagicappedChargedWandFireFocusID = 9817;
    public static int limemagicappedChargedWandIceFocusID = 9818;
    public static int fireFocusID = 9819;
    public static int melonwoodwandcoreID = 9820;
    public static int moonstonecapID = 9821;
    public static int iceFocusID = 9822;
    public static int redmagicappedChargedWandID = 9823;
    public static int redmagicappedChargedWandFireFocusID = 9824;
    public static int redmagicappedChargedWandIceFocusID = 9825;
    public static int orangemagicappedChargedWandID = 9826;
    public static int orangemagicappedChargedWandFireFocusID = 9827;
    public static int orangemagicappedChargedWandIceFocusID = 9828;
    public static int yellowmagicappedChargedWandID = 9829;
    public static int yellowmagicappedChargedWandFireFocusID = 9830;
    public static int yellowmagicappedChargedWandIceFocusID = 9831;
    public static int greenmagicappedChargedWandID = 9832;
    public static int greenmagicappedChargedWandFireFocusID = 9833;
    public static int greenmagicappedChargedWandIceFocusID = 9834;
    public static int cyanmagicappedChargedWandID = 9835;
    public static int cyanmagicappedChargedWandFireFocusID = 9836;
    public static int cyanmagicappedChargedWandIceFocusID = 9837;
    public static int bluemagicappedChargedWandID = 9838;
    public static int bluemagicappedChargedWandFireFocusID = 9839;
    public static int bluemagicappedChargedWandIceFocusID = 9840;
    public static int purplemagicappedChargedWandID = 9841;
    public static int purplemagicappedChargedWandFireFocusID = 9842;
    public static int purplemagicappedChargedWandIceFocusID = 9843;
    public static Item melonstick;
    public static Item melonwoodpick;
    public static Item melonstonepick;
    public static Item melonwoodaxe;
    public static Item melonstoneaxe;
    public static Item melonwoodshovel;
    public static Item melonstoneshovel;
    public static Item magiDust;
    public static Item moonstoneIngot;
    public static Item moonstoneshovel;
    public static Item moonstoneaxe;
    public static Item moonstonepick;
    public static Item moonstoneCappedWoodenWand;
    public static Item moonstoneCappedWoodenWandFireFocus;
    public static Item moonstoneCappedWoodenWandIceFocus;
    public static Item limemagicappedChargedWand;
    public static Item limemagicappedChargedWandFireFocus;
    public static Item limemagicappedChargedWandIceFocus;
    public static Item fireFocus;
    public static Item melonwoodwandcore;
    public static Item moonstonecap;
    public static Item iceFocus;
    public static Item redmagicappedChargedWand;
    public static Item redmagicappedChargedWandFireFocus;
    public static Item redmagicappedChargedWandIceFocus;
    public static Item orangemagicappedChargedWand;
    public static Item orangemagicappedChargedWandFireFocus;
    public static Item orangemagicappedChargedWandIceFocus;
    public static Item yellowmagicappedChargedWand;
    public static Item yellowmagicappedChargedWandFireFocus;
    public static Item yellowmagicappedChargedWandIceFocus;
    public static Item greenmagicappedChargedWand;
    public static Item greenmagicappedChargedWandFireFocus;
    public static Item greenmagicappedChargedWandIceFocus;
    public static Item cyanmagicappedChargedWand;
    public static Item cyanmagicappedChargedWandFireFocus;
    public static Item cyanmagicappedChargedWandIceFocus;
    public static Item bluemagicappedChargedWand;
    public static Item bluemagicappedChargedWandFireFocus;
    public static Item bluemagicappedChargedWandIceFocus;
    public static Item purplemagicappedChargedWand;
    public static Item purplemagicappedChargedWandFireFocus;
    public static Item purplemagicappedChargedWandIceFocus;
    public static StepSound soundWaterFootstep = new MelonStepSound("liquid.swim", 1, 1);
    public static StepSound soundLavaFootstep = new MelonStepSound("liquid.lavapop", 1, 1);
    public static StepSound soundMachineFootstep = new MelonStepSoundMining("meloncraft:blocks.machine", 1, 1);
    
    @Instance("MelonCraft")
    public static MelonCraft instance;
    
    @SidedProxy(clientSide = "cliffracerx.mods.meloncraft.src.ClientProxy",
            serverSide = "cliffracerx.mods.meloncraft.src.CommonProxy")
    public static CommonProxy proxy;
    public static BiomeGenBase biome;
    public static DamageSource freezeSource = new MelonDamageSource("icewand", "was turned into an ice cube");
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        FMLInterModComms.sendMessage("MelonCraft", "donateUrl", "http://cliffracerx.github.io/MelonCraft/donate.html");
      //Config.
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        melonDirtID = config.get(Configuration.CATEGORY_BLOCK, "Melondirt BlockID", 232).getInt(232);
        melonStoneID = config.get(Configuration.CATEGORY_BLOCK, "Melonstone BlockID", 233).getInt(233);
        melonGrassID = config.get(Configuration.CATEGORY_BLOCK, "Melongrass BlockID", 234).getInt(234);
        portalID = config.get(Configuration.CATEGORY_BLOCK, "Melonportal BlockID", 235).getInt(235);
        magistoneID = config.get(Configuration.CATEGORY_BLOCK, "Magistone BlockID", 1836).getInt(1836);
        melonlogID = config.get(Configuration.CATEGORY_BLOCK, "Melonlog BlockID", 1837).getInt(1837);
        melonplanksID = config.get(Configuration.CATEGORY_BLOCK, "Melonplanks BlockID", 1838).getInt(1838);
        melonleavesID = config.get(Configuration.CATEGORY_BLOCK, "Melonleaves BlockID", 1839).getInt(1839);
        melonsaplingID = config.get(Configuration.CATEGORY_BLOCK, "Melonsapling BlockID", 1840).getInt(1840);
        meloncobbleID = config.get(Configuration.CATEGORY_BLOCK, "Meloncobble BlockID", 1841).getInt(1841);
        melonjuiceID = config.get(Configuration.CATEGORY_BLOCK, "Melonjuice BlockID", 1842).getInt(1842);
        magilavaID = config.get(Configuration.CATEGORY_BLOCK, "Magilava BlockID", 1843).getInt(1843);
        melonBenchID = config.get(Configuration.CATEGORY_BLOCK, "Melonbench BlockID", 1844).getInt(1844);
        moonstoneOreID = config.get(Configuration.CATEGORY_BLOCK, "Moonstone ore BlockID", 1845).getInt(1845);
        moonstoneBlockID = config.get(Configuration.CATEGORY_BLOCK, "Moonstone block BlockID", 1846).getInt(1846);
        redMGSTID = config.get(Configuration.CATEGORY_BLOCK, "Red magistone BlockID", 1847).getInt(1847);
        orangeMGSTID = config.get(Configuration.CATEGORY_BLOCK, "Orange magistone BlockID", 1848).getInt(1848);
        yellowMGSTID = config.get(Configuration.CATEGORY_BLOCK, "Yellow magistone BlockID", 1849).getInt(1849);
        limeMGSTID = config.get(Configuration.CATEGORY_BLOCK, "Lime magistone BlockID", 1850).getInt(1850);
        greenMGSTID = config.get(Configuration.CATEGORY_BLOCK, "Green magistone BlockID", 1851).getInt(1851);
        cyanMGSTID = config.get(Configuration.CATEGORY_BLOCK, "Cyan magistone BlockID", 1852).getInt(1852);
        blueMGSTID = config.get(Configuration.CATEGORY_BLOCK, "Blue magistone BlockID", 1853).getInt(1853);
        purpleMGSTID = config.get(Configuration.CATEGORY_BLOCK, "Purple magistone BlockID", 1854).getInt(1854);
        redMWID = config.get(Configuration.CATEGORY_BLOCK, "Red melonwool BlockID", 1855).getInt(1855);
        orangeMWID = config.get(Configuration.CATEGORY_BLOCK, "Orange melonwool BlockID", 1856).getInt(1856);
        yellowMWID = config.get(Configuration.CATEGORY_BLOCK, "Yellow melonwool BlockID", 1857).getInt(1857);
        limeMWID = config.get(Configuration.CATEGORY_BLOCK, "Lime melonwool BlockID", 1858).getInt(1858);
        greenMWID = config.get(Configuration.CATEGORY_BLOCK, "Green melonwool BlockID", 1859).getInt(1859);
        cyanMWID = config.get(Configuration.CATEGORY_BLOCK, "Cyan melonwool BlockID", 1860).getInt(1860);
        blueMWID = config.get(Configuration.CATEGORY_BLOCK, "Blue melonwool BlockID", 1861).getInt(1861);
        purpleMWID = config.get(Configuration.CATEGORY_BLOCK, "Purple melonwool BlockID", 1862).getInt(1862);
        greyMWID = config.get(Configuration.CATEGORY_BLOCK, "Grey melonwool BlockID", 1863).getInt(1863);
        normalMWID = config.get(Configuration.CATEGORY_BLOCK, "Melonwool BlockID", 1864).getInt(1864);
        melonstickID = config.get(Configuration.CATEGORY_ITEM, "Melonstick ItemID", 9801).getInt(9801);
        melonwoodpickID = config.get(Configuration.CATEGORY_ITEM, "Melonwood pickaxe ItemID", 9802).getInt(9802);
        melonstonepickID = config.get(Configuration.CATEGORY_ITEM, "Melonstone pickaxe ItemID", 9803).getInt(9803);
        melonwoodaxeID = config.get(Configuration.CATEGORY_ITEM, "Melonwood axe ItemID", 9804).getInt(9804);
        melonstoneaxeID = config.get(Configuration.CATEGORY_ITEM, "Melonstone axe ItemID", 9805).getInt(9805);
        melonwoodshovelID = config.get(Configuration.CATEGORY_ITEM, "Melonwood shovel ItemID", 9806).getInt(9806);
        melonstoneshovelID = config.get(Configuration.CATEGORY_ITEM, "Melonstone shovel ItemID", 9807).getInt(9807);
        magiDustID = config.get(Configuration.CATEGORY_ITEM, "Magidust ItemID", 9808).getInt(9808);
        moonstoneIngotID = config.get(Configuration.CATEGORY_ITEM, "Moonstone ingot ItemID", 9809).getInt(9809);
        moonstoneshovelID = config.get(Configuration.CATEGORY_ITEM, "Moonstone shovel ItemID", 9810).getInt(9810);
        moonstoneaxeID = config.get(Configuration.CATEGORY_ITEM, "Moonstone axe ItemID", 9811).getInt(9811);
        moonstonepickID = config.get(Configuration.CATEGORY_ITEM, "Moonstone pick ItemID", 9812).getInt(9812);
        moonstoneCappedWoodenWandID = config.get(Configuration.CATEGORY_ITEM, "Moonstone capped melonwood wand ItemID", 9813).getInt(9813);
        moonstoneCappedWoodenWandFireFocusID = config.get(Configuration.CATEGORY_ITEM, "Moonstone capped melonwood wand with a fire focus ItemID", 9814).getInt(9814);
        moonstoneCappedWoodenWandIceFocusID = config.get(Configuration.CATEGORY_ITEM, "Moonstone capped melonwood wand with a ice focus ItemID", 9815).getInt(9815);
        limemagicappedChargedWandID = config.get(Configuration.CATEGORY_ITEM, "Lime magi-capped charged moonstone wand ItemID", 9816).getInt(9816);
        limemagicappedChargedWandFireFocusID = config.get(Configuration.CATEGORY_ITEM, "Lime magi-capped charged moonstone wand with a fire focus ItemID", 9817).getInt(9817);
        limemagicappedChargedWandIceFocusID = config.get(Configuration.CATEGORY_ITEM, "Lime magi-capped charged moonstone wand with a ice focus ItemID", 9818).getInt(9818);
        fireFocusID = config.get(Configuration.CATEGORY_ITEM, "Fire Focus ItemID", 9819).getInt(9819);
        melonwoodwandcoreID = config.get(Configuration.CATEGORY_ITEM, "Melonwood wand core ItemID", 9820).getInt(9820);
        moonstonecapID = config.get(Configuration.CATEGORY_ITEM, "Moonstone wand cap ItemID", 9821).getInt(9821);
        iceFocusID = config.get(Configuration.CATEGORY_ITEM, "Ice Focus ItemID", 9822).getInt(9822);
        redmagicappedChargedWandID = config.get(Configuration.CATEGORY_ITEM, "Red magi-capped charged moonstone wand ItemID", 9823).getInt(9823);
        redmagicappedChargedWandFireFocusID = config.get(Configuration.CATEGORY_ITEM, "Red magi-capped charged moonstone wand with a fire focus ItemID", 9824).getInt(9824);
        redmagicappedChargedWandIceFocusID = config.get(Configuration.CATEGORY_ITEM, "Red magi-capped charged moonstone wand with a ice focus ItemID", 9825).getInt(9825);
        orangemagicappedChargedWandID = config.get(Configuration.CATEGORY_ITEM, "Orange magi-capped charged moonstone wand ItemID", 9826).getInt(9826);
        orangemagicappedChargedWandFireFocusID = config.get(Configuration.CATEGORY_ITEM, "Orange magi-capped charged moonstone wand with a fire focus ItemID", 9827).getInt(9827);
        orangemagicappedChargedWandIceFocusID = config.get(Configuration.CATEGORY_ITEM, "Orange magi-capped charged moonstone wand with a ice focus ItemID", 9828).getInt(9828);
        yellowmagicappedChargedWandID = config.get(Configuration.CATEGORY_ITEM, "Yellow magi-capped charged moonstone wand ItemID", 9829).getInt(9829);
        yellowmagicappedChargedWandFireFocusID = config.get(Configuration.CATEGORY_ITEM, "Yellow magi-capped charged moonstone wand with a fire focus ItemID", 9830).getInt(9830);
        yellowmagicappedChargedWandIceFocusID = config.get(Configuration.CATEGORY_ITEM, "Yellow magi-capped charged moonstone wand with a ice focus ItemID", 9831).getInt(9831);
        greenmagicappedChargedWandID = config.get(Configuration.CATEGORY_ITEM, "Green magi-capped charged moonstone wand ItemID", 9832).getInt(9832);
        greenmagicappedChargedWandFireFocusID = config.get(Configuration.CATEGORY_ITEM, "Green magi-capped charged moonstone wand with a fire focus ItemID", 9833).getInt(9833);
        greenmagicappedChargedWandIceFocusID = config.get(Configuration.CATEGORY_ITEM, "Green magi-capped charged moonstone wand with a ice focus ItemID", 9834).getInt(9834);
        cyanmagicappedChargedWandID = config.get(Configuration.CATEGORY_ITEM, "Cyan magi-capped charged moonstone wand ItemID", 9835).getInt(9835);
        cyanmagicappedChargedWandFireFocusID = config.get(Configuration.CATEGORY_ITEM, "Cyan magi-capped charged moonstone wand with a fire focus ItemID", 9836).getInt(9836);
        cyanmagicappedChargedWandIceFocusID = config.get(Configuration.CATEGORY_ITEM, "Cyan magi-capped charged moonstone wand with a ice focus ItemID", 9837).getInt(9837);
        bluemagicappedChargedWandID = config.get(Configuration.CATEGORY_ITEM, "Blue magi-capped charged moonstone wand ItemID", 9838).getInt(9838);
        bluemagicappedChargedWandFireFocusID = config.get(Configuration.CATEGORY_ITEM, "Blue magi-capped charged moonstone wand with a fire focus ItemID", 9839).getInt(9839);
        bluemagicappedChargedWandIceFocusID = config.get(Configuration.CATEGORY_ITEM, "Blue magi-capped charged moonstone wand with a ice focus ItemID", 9840).getInt(9840);
        purplemagicappedChargedWandID = config.get(Configuration.CATEGORY_ITEM, "Purple magi-capped charged moonstone wand ItemID", 9841).getInt(9841);
        purplemagicappedChargedWandFireFocusID = config.get(Configuration.CATEGORY_ITEM, "Purple magi-capped charged moonstone wand with a fire focus ItemID", 9842).getInt(9842);
        purplemagicappedChargedWandIceFocusID = config.get(Configuration.CATEGORY_ITEM, "Purple magi-capped charged moonstone wand with a ice focus ItemID", 9843).getInt(9843);
        // saving the configuration to its file
        config.save();
    }
    //public void load(FMLInitializationEvent event)
    @EventHandler
    @SideOnly(Side.CLIENT)
    public void postInit(FMLPostInitializationEvent event)
    {
        ClientProxy.registerRenderers();
        GuiFlatPresets.addPreset("Melondimension Superflat", melonGrass.blockID, biome, Arrays.asList(new String[] {"decoration"}), new FlatLayerInfo[] {new FlatLayerInfo(1, melonGrass.blockID), new FlatLayerInfo(2, melonDirt.blockID), new FlatLayerInfo(60, melonStone.blockID), new FlatLayerInfo(1, Block.bedrock.blockID)});
        GuiFlatPresets.addPreset("Melondimension Superflat Doomworld", magistone.blockID, biome, Arrays.asList(new String[] {"decoration"}), new FlatLayerInfo[] {new FlatLayerInfo(1, melonGrass.blockID), new FlatLayerInfo(2, melonDirt.blockID), new FlatLayerInfo(26, melonStone.blockID), new FlatLayerInfo(8, 0), new FlatLayerInfo(26, melonStone.blockID), new FlatLayerInfo(1, Block.bedrock.blockID)});
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        //Registering various thingermabobs.
        DimensionManager.registerProviderType(-2, MelonWorldProvider.class, true);
        DimensionManager.registerDimension(-2, -2);
        NetworkRegistry.instance().registerGuiHandler(this, new CommonProxy());
        //Actually initializing the blocks
        melonDirt = new MelonBlockNormal(melonDirtID,
                Material.ground, "melonDirt").setHardness(0.25F)
                .setStepSound(Block.soundGravelFootstep)
                .setUnlocalizedName("melonDirt").setCreativeTab(tab);
        melonStone = new MelonBlockStone(melonStoneID,
                Material.ground, "melonStone", 0, 0.75f).setHardness(0.75F)
                .setStepSound(Block.soundStoneFootstep)
                .setUnlocalizedName("melonStone").setCreativeTab(tab);
        melonGrass = new MelonBlockGrass(melonGrassID,
                Material.ground, "melonGrass").setHardness(0.5F)
                .setStepSound(Block.soundGrassFootstep)
                .setUnlocalizedName("melonGrass").setCreativeTab(tab);
        portal = new MelonBlockPortal(portalID).setHardness(-1F)
                .setStepSound(Block.soundGlassFootstep)
                .setUnlocalizedName("melonportal").setCreativeTab(tab);
        magistone = new MelonBlockStone(magistoneID,
                Material.ground, "magistone", 1, 0.75f).setHardness(0.75F)
                .setStepSound(Block.soundGlassFootstep)
                .setUnlocalizedName("magistone").setCreativeTab(tab).setLightValue(1.0f);
        melonlog = new MelonBlockNormal(melonlogID,
                Material.ground, "melonLog").setHardness(0.75F)
                .setStepSound(Block.soundWoodFootstep)
                .setUnlocalizedName("melonlog").setCreativeTab(tab);
        melonplanks = new MelonBlockNormal(melonplanksID,
                Material.ground, "melonPlanks").setHardness(0.5F)
                .setStepSound(Block.soundWoodFootstep)
                .setUnlocalizedName("melonplanks").setCreativeTab(tab);
        melonleaves = new MelonBlockLeaves(melonleavesID,
                Material.ground, "melonLeaves", melonsaplingID, melonlog.blockID).setHardness(0.125F)
                .setStepSound(Block.soundGrassFootstep)
                .setUnlocalizedName("melonleaves").setCreativeTab(tab);
        melonsapling = new MelonBlockSapling(melonsaplingID,
                Material.ground, "melonSapling", melonlog.blockID, melonleaves.blockID).setHardness(0.0F)
                .setStepSound(Block.soundGrassFootstep)
                .setUnlocalizedName("melonsapling").setCreativeTab(tab);
        meloncobble = new MelonBlockStone(meloncobbleID,
                Material.ground, "melonCobble", 0, 0.75f).setHardness(0.5F)
                .setStepSound(Block.soundStoneFootstep)
                .setUnlocalizedName("meloncobble").setCreativeTab(tab);
        melonjuice = new MelonWateryBlock(melonjuiceID,
                Material.ground, "melonjuice", false).setHardness(0.5F)
                .setStepSound(soundWaterFootstep)
                .setUnlocalizedName("melonjuice").setCreativeTab(tab);
        magilava = new MelonWateryBlock(magilavaID,
                Material.ground, "magilava", true).setHardness(0.5F)
                .setStepSound(soundLavaFootstep)
                .setUnlocalizedName("magilava").setCreativeTab(tab).setLightValue(1.0f);
        melonBench = new MelonBench(melonBenchID,
                Material.ground, "melonTable").setHardness(0.5F)
                .setStepSound(Block.soundWoodFootstep)
                .setUnlocalizedName("melonbench").setCreativeTab(tab);
        moonstoneOre = new MelonBlockStone(moonstoneOreID,
                Material.ground, "moonstoneOre", 1, 1.5f).setHardness(1.5F)
                .setStepSound(Block.soundStoneFootstep)
                .setUnlocalizedName("moonstoneOre").setCreativeTab(tab);
        moonstoneBlock = new MelonBlockStone(moonstoneBlockID,
                Material.ground, "moonstoneBricks", 1, 1.5f).setHardness(1.5F)
                .setStepSound(soundMachineFootstep)
                .setUnlocalizedName("moonstoneBlock").setCreativeTab(tab);
        redMGST = new MelonBlockStone(redMGSTID,
                Material.ground, "redMGST", 1, 0.75f).setHardness(0.75F)
                .setStepSound(Block.soundGlassFootstep)
                .setUnlocalizedName("redMGST").setCreativeTab(tab).setLightValue(1.0f);
        orangeMGST = new MelonBlockStone(orangeMGSTID,
                Material.ground, "orangeMGST", 1, 0.75f).setHardness(0.75F)
                .setStepSound(Block.soundGlassFootstep)
                .setUnlocalizedName("orangeMGST").setCreativeTab(tab).setLightValue(1.0f);
        yellowMGST = new MelonBlockStone(yellowMGSTID,
                Material.ground, "yellowMGST", 1, 0.75f).setHardness(0.75F)
                .setStepSound(Block.soundGlassFootstep)
                .setUnlocalizedName("yellowMGST").setCreativeTab(tab).setLightValue(1.0f);
        limeMGST = new MelonBlockStone(limeMGSTID,
                Material.ground, "limeMGST", 1, 0.75f).setHardness(0.75F)
                .setStepSound(Block.soundGlassFootstep)
                .setUnlocalizedName("limeMGST").setCreativeTab(tab).setLightValue(1.0f);
        greenMGST = new MelonBlockStone(greenMGSTID,
                Material.ground, "greenMGST", 1, 0.75f).setHardness(0.75F)
                .setStepSound(Block.soundGlassFootstep)
                .setUnlocalizedName("greenMGST").setCreativeTab(tab).setLightValue(1.0f);
        cyanMGST = new MelonBlockStone(cyanMGSTID,
                Material.ground, "cyanMGST", 1, 0.75f).setHardness(0.75F)
                .setStepSound(Block.soundGlassFootstep)
                .setUnlocalizedName("cyanMGST").setCreativeTab(tab).setLightValue(1.0f);
        blueMGST = new MelonBlockStone(blueMGSTID,
                Material.ground, "blueMGST", 1, 0.75f).setHardness(0.75F)
                .setStepSound(Block.soundGlassFootstep)
                .setUnlocalizedName("blueMGST").setCreativeTab(tab).setLightValue(1.0f);
        purpleMGST = new MelonBlockStone(purpleMGSTID,
                Material.ground, "purpleMGST", 1, 0.75f).setHardness(0.75F)
                .setStepSound(Block.soundGlassFootstep)
                .setUnlocalizedName("purpleMGST").setCreativeTab(tab).setLightValue(1.0f);
        redMW = new MelonBlockNormal(redMWID,
                Material.ground, "redMW").setHardness(0.25f)
                .setStepSound(Block.soundSnowFootstep)
                .setUnlocalizedName("redMW").setCreativeTab(tab);
        orangeMW = new MelonBlockNormal(orangeMWID,
                Material.ground, "orangeMW").setHardness(0.25f)
                .setStepSound(Block.soundSnowFootstep)
                .setUnlocalizedName("orangeMW").setCreativeTab(tab);
        yellowMW = new MelonBlockNormal(yellowMWID,
                Material.ground, "yellowMW").setHardness(0.25f)
                .setStepSound(Block.soundSnowFootstep)
                .setUnlocalizedName("yellowMW").setCreativeTab(tab);
        limeMW = new MelonBlockNormal(limeMWID,
                Material.ground, "limeMW").setHardness(0.25f)
                .setStepSound(Block.soundSnowFootstep)
                .setUnlocalizedName("limeMW").setCreativeTab(tab);
        greenMW = new MelonBlockNormal(greenMWID,
                Material.ground, "greenMW").setHardness(0.25f)
                .setStepSound(Block.soundSnowFootstep)
                .setUnlocalizedName("greenMW").setCreativeTab(tab);
        cyanMW = new MelonBlockNormal(cyanMWID,
                Material.ground, "cyanMW").setHardness(0.25f)
                .setStepSound(Block.soundSnowFootstep)
                .setUnlocalizedName("cyanMW").setCreativeTab(tab);
        blueMW = new MelonBlockNormal(blueMWID,
                Material.ground, "blueMW").setHardness(0.25f)
                .setStepSound(Block.soundSnowFootstep)
                .setUnlocalizedName("blueMW").setCreativeTab(tab);
        purpleMW = new MelonBlockNormal(purpleMWID,
                Material.ground, "purpleMW").setHardness(0.25f)
                .setStepSound(Block.soundSnowFootstep)
                .setUnlocalizedName("purpleMW").setCreativeTab(tab);
        greyMW = new MelonBlockNormal(greyMWID,
                Material.ground, "greyMW").setHardness(0.25f)
                .setStepSound(Block.soundSnowFootstep)
                .setUnlocalizedName("greyMW").setCreativeTab(tab);
        normalMW = new MelonBlockNormal(normalMWID,
                Material.ground, "normalMW").setHardness(0.25f)
                .setStepSound(Block.soundSnowFootstep)
                .setUnlocalizedName("normalMW").setCreativeTab(tab);
        //Items
        melonstick = new GenericMelonItem(melonstickID, "melonStick");
        melonwoodpick = new MelonPickaxe(melonwoodpickID, "melonwoodPick", 0, 63, 1.5f);
        melonstonepick = new MelonPickaxe(melonstonepickID, "melonstonePick", 1, 127, 3f);
        melonwoodaxe = new MelonAxe(melonwoodaxeID, "woodAxe", 0, 63, 1.5f);
        melonstoneaxe = new MelonAxe(melonstoneaxeID, "stoneAxe", 1, 127, 3f);
        melonwoodshovel = new MelonShovel(melonwoodshovelID, "woodShov", 0, 63, 1.5f);
        melonstoneshovel = new MelonShovel(melonstoneshovelID, "stoneShov", 1, 127, 3f);
        magiDust = new GenericMelonItem(magiDustID, "magiDust");
        moonstoneIngot = new GenericMelonItem(moonstoneIngotID, "moonstoneIngot");
        moonstoneshovel = new MelonShovel(moonstoneshovelID, "moonShov", 2, 255, 4.5f);
        moonstoneaxe = new MelonAxe(moonstoneaxeID, "moonAxe", 2, 255, 4.5f);
        moonstonepick = new MelonPickaxe(moonstonepickID, "moonstonePick", 2, 255, 4.5f);
        moonstoneCappedWoodenWand = new MelonWand(moonstoneCappedWoodenWandID, "moonstoneCappedWoodenWand", 100, "wood", "moonstone", "blank", 1, 2);
        moonstoneCappedWoodenWandFireFocus = new MelonWand(moonstoneCappedWoodenWandFireFocusID, "moonstoneCappedWoodenWandFireFocus", 100, "wood", "moonstone", "fire", 1, 2);
        moonstoneCappedWoodenWandIceFocus = new MelonWand(moonstoneCappedWoodenWandIceFocusID, "moonstoneCappedWoodenWandIceFocus", 100, "wood", "moonstone", "ice", 1, 2);
        limemagicappedChargedWand = new MelonWand(limemagicappedChargedWandID, "limemagicappedChargedWand", 450, "chargedmoonstone", "limemagi", "blank", 5, 5);
        limemagicappedChargedWandFireFocus = new MelonWand(limemagicappedChargedWandFireFocusID, "limemagicappedChargedWandFireFocus", 450, "chargedmoonstone", "limemagi", "fire", 5, 5);
        limemagicappedChargedWandIceFocus = new MelonWand(limemagicappedChargedWandIceFocusID, "limemagicappedChargedWandIceFocus", 450, "chargedmoonstone", "limemagi", "ice", 5, 5);
        fireFocus = new GenericMelonItem(fireFocusID, "fireFocus");
        melonwoodwandcore = new GenericMelonItem(melonwoodwandcoreID, "melonwoodwandcore");
        moonstonecap = new GenericMelonItem(moonstonecapID, "moonstonecap");
        iceFocus = new GenericMelonItem(iceFocusID, "iceFocus");
        redmagicappedChargedWand = new MelonWand(redmagicappedChargedWandID, "redmagicappedChargedWand", 450, "chargedmoonstone", "redmagi", "blank", 5, 5);
        redmagicappedChargedWandFireFocus = new MelonWand(redmagicappedChargedWandFireFocusID, "redmagicappedChargedWandFireFocus", 450, "chargedmoonstone", "redmagi", "fire", 5, 5);
        redmagicappedChargedWandIceFocus = new MelonWand(redmagicappedChargedWandIceFocusID, "redmagicappedChargedWandIceFocus", 450, "chargedmoonstone", "redmagi", "ice", 5, 5);
        orangemagicappedChargedWand = new MelonWand(orangemagicappedChargedWandID, "orangemagicappedChargedWand", 450, "chargedmoonstone", "orangemagi", "blank", 5, 5);
        orangemagicappedChargedWandFireFocus = new MelonWand(orangemagicappedChargedWandFireFocusID, "orangemagicappedChargedWandFireFocus", 450, "chargedmoonstone", "orangemagi", "fire", 5, 5);
        orangemagicappedChargedWandIceFocus = new MelonWand(orangemagicappedChargedWandIceFocusID, "orangemagicappedChargedWandIceFocus", 450, "chargedmoonstone", "orangemagi", "ice", 5, 5);
        yellowmagicappedChargedWand = new MelonWand(yellowmagicappedChargedWandID, "yellowmagicappedChargedWand", 450, "chargedmoonstone", "yellowmagi", "blank", 5, 5);
        yellowmagicappedChargedWandFireFocus = new MelonWand(yellowmagicappedChargedWandFireFocusID, "yellowmagicappedChargedWandFireFocus", 450, "chargedmoonstone", "yellowmagi", "fire", 5, 5);
        yellowmagicappedChargedWandIceFocus = new MelonWand(yellowmagicappedChargedWandIceFocusID, "yellowmagicappedChargedWandIceFocus", 450, "chargedmoonstone", "yellowmagi", "ice", 5, 5);
        greenmagicappedChargedWand = new MelonWand(greenmagicappedChargedWandID, "greenmagicappedChargedWand", 450, "chargedmoonstone", "greenmagi", "blank", 5, 5);
        greenmagicappedChargedWandFireFocus = new MelonWand(greenmagicappedChargedWandFireFocusID, "greenmagicappedChargedWandFireFocus", 450, "chargedmoonstone", "greenmagi", "fire", 5, 5);
        greenmagicappedChargedWandIceFocus = new MelonWand(greenmagicappedChargedWandIceFocusID, "greenmagicappedChargedWandIceFocus", 450, "chargedmoonstone", "greenmagi", "ice", 5, 5);
        cyanmagicappedChargedWand = new MelonWand(cyanmagicappedChargedWandID, "cyanmagicappedChargedWand", 450, "chargedmoonstone", "cyanmagi", "blank", 5, 5);
        cyanmagicappedChargedWandFireFocus = new MelonWand(cyanmagicappedChargedWandFireFocusID, "cyanmagicappedChargedWandFireFocus", 450, "chargedmoonstone", "cyanmagi", "fire", 5, 5);
        cyanmagicappedChargedWandIceFocus = new MelonWand(cyanmagicappedChargedWandIceFocusID, "cyanmagicappedChargedWandIceFocus", 450, "chargedmoonstone", "cyanmagi", "ice", 5, 5);
        bluemagicappedChargedWand = new MelonWand(bluemagicappedChargedWandID, "bluemagicappedChargedWand", 450, "chargedmoonstone", "bluemagi", "blank", 5, 5);
        bluemagicappedChargedWandFireFocus = new MelonWand(bluemagicappedChargedWandFireFocusID, "bluemagicappedChargedWandFireFocus", 450, "chargedmoonstone", "bluemagi", "fire", 5, 5);
        bluemagicappedChargedWandIceFocus = new MelonWand(bluemagicappedChargedWandIceFocusID, "bluemagicappedChargedWandIceFocus", 450, "chargedmoonstone", "bluemagi", "ice", 5, 5);
        purplemagicappedChargedWand = new MelonWand(purplemagicappedChargedWandID, "purplemagicappedChargedWand", 450, "chargedmoonstone", "purplemagi", "blank", 5, 5);
        purplemagicappedChargedWandFireFocus = new MelonWand(purplemagicappedChargedWandFireFocusID, "purplemagicappedChargedWandFireFocus", 450, "chargedmoonstone", "purplemagi", "fire", 5, 5);
        purplemagicappedChargedWandIceFocus = new MelonWand(purplemagicappedChargedWandIceFocusID, "purplemagicappedChargedWandIceFocus", 450, "chargedmoonstone", "purplemagi", "ice", 5, 5);
        //Block naming and registering
        LanguageRegistry.addName(melonDirt, "Melon Dirt");
        GameRegistry.registerBlock(melonDirt, "melonDirt");
        LanguageRegistry.addName(melonStone, "Melon Stone");
        GameRegistry.registerBlock(melonStone, "melonStone");
        LanguageRegistry.addName(melonGrass, "Melon Grass");
        GameRegistry.registerBlock(melonGrass, "melonGrass");
        LanguageRegistry.addName(portal, "Melon Portal Block");
        GameRegistry.registerBlock(portal, "melonPortal");
        LanguageRegistry.addName(magistone, "Magistone");
        GameRegistry.registerBlock(magistone, "magistone");
        LanguageRegistry.addName(melonlog, "Melon Log");
        GameRegistry.registerBlock(melonlog, "melonlog");
        LanguageRegistry.addName(melonplanks, "Melon Planks");
        GameRegistry.registerBlock(melonplanks, "melonplanks");
        LanguageRegistry.addName(melonleaves, "Melon Leaves");
        GameRegistry.registerBlock(melonleaves, "melonleaves");
        LanguageRegistry.addName(melonsapling, "Melon Sapling");
        GameRegistry.registerBlock(melonsapling, "melonsapling");
        LanguageRegistry.addName(meloncobble, "Melon Cobblestone");
        GameRegistry.registerBlock(meloncobble, "meloncobble");
        LanguageRegistry.addName(melonjuice, "Melon Juice");
        GameRegistry.registerBlock(melonjuice, "melonjuice");
        LanguageRegistry.addName(magilava, "Magilava");
        GameRegistry.registerBlock(magilava, "magilava");
        LanguageRegistry.addName(melonBench, "Melonbench");
        GameRegistry.registerBlock(melonBench, "melonBench");
        LanguageRegistry.addName(moonstoneOre, "Moonstone Ore");
        GameRegistry.registerBlock(moonstoneOre, "moonstoneOre");
        LanguageRegistry.addName(moonstoneBlock, "Moonstone Bricks");
        GameRegistry.registerBlock(moonstoneBlock, "moonstoneblock");
        LanguageRegistry.addName(redMGST, "Magistone - dyed red");
        GameRegistry.registerBlock(redMGST, "redMGST");
        LanguageRegistry.addName(orangeMGST, "Magistone - dyed orange");
        GameRegistry.registerBlock(orangeMGST, "orangeMGST");
        LanguageRegistry.addName(yellowMGST, "Magistone - dyed yellow");
        GameRegistry.registerBlock(yellowMGST, "yellowMGST");
        LanguageRegistry.addName(limeMGST, "Magistone - dyed lime");
        GameRegistry.registerBlock(limeMGST, "limeMGST");
        LanguageRegistry.addName(greenMGST, "Magistone - dyed green");
        GameRegistry.registerBlock(greenMGST, "greenMGST");
        LanguageRegistry.addName(cyanMGST, "Magistone - dyed cyan");
        GameRegistry.registerBlock(cyanMGST, "cyanMGST");
        LanguageRegistry.addName(blueMGST, "Magistone - dyed blue");
        GameRegistry.registerBlock(blueMGST, "blueMGST");
        LanguageRegistry.addName(purpleMGST, "Magistone - dyed purple");
        GameRegistry.registerBlock(purpleMGST, "purpleMGST");
        LanguageRegistry.addName(redMW, "Melonwool - dyed red");
        GameRegistry.registerBlock(redMW, "redMW");
        LanguageRegistry.addName(orangeMW, "Melonwool - dyed orange");
        GameRegistry.registerBlock(orangeMW, "orangeMW");
        LanguageRegistry.addName(yellowMW, "Melonwool - dyed yellow");
        GameRegistry.registerBlock(yellowMW, "yellowMW");
        LanguageRegistry.addName(limeMW, "Melonwool - dyed lime");
        GameRegistry.registerBlock(limeMW, "limeMW");
        LanguageRegistry.addName(greenMW, "Melonwool - dyed green");
        GameRegistry.registerBlock(greenMW, "greenMW");
        LanguageRegistry.addName(cyanMW, "Melonwool - dyed cyan");
        GameRegistry.registerBlock(cyanMW, "cyanMW");
        LanguageRegistry.addName(blueMW, "Melonwool - dyed blue");
        GameRegistry.registerBlock(blueMW, "blueMW");
        LanguageRegistry.addName(purpleMW, "Melonwool - dyed purple");
        GameRegistry.registerBlock(purpleMW, "purpleMW");
        LanguageRegistry.addName(greyMW, "Melonwool - dyed grey");
        GameRegistry.registerBlock(greyMW, "greyMW");
        LanguageRegistry.addName(normalMW, "Melonwool");
        GameRegistry.registerBlock(normalMW, "normalMW");
        //Item naming
        LanguageRegistry.addName(melonstick, "Melonwood stick");
        LanguageRegistry.addName(melonwoodpick, "Melon-wood pick");
        LanguageRegistry.addName(melonstonepick, "Melon-stone pick");
        LanguageRegistry.addName(melonwoodaxe, "Melon-wood axe");
        LanguageRegistry.addName(melonstoneaxe, "Melon-stone axe");
        LanguageRegistry.addName(melonwoodshovel, "Melon-wood shovel");
        LanguageRegistry.addName(melonstoneshovel, "Melon-stone shovel");
        LanguageRegistry.addName(magiDust, "Magidust");
        LanguageRegistry.addName(moonstoneIngot, "Moonstone Ingot");
        LanguageRegistry.addName(moonstoneshovel, "Moonstone shovel");
        LanguageRegistry.addName(moonstoneaxe, "Moonstone axe");
        LanguageRegistry.addName(moonstonepick, "Moonstone pick");
        LanguageRegistry.addName(moonstoneCappedWoodenWand, "Moonstone-capped wooden wand");
        LanguageRegistry.addName(moonstoneCappedWoodenWandFireFocus, "Moonstone-capped wooden wand + Fire Foci");
        LanguageRegistry.addName(moonstoneCappedWoodenWandIceFocus, "Moonstone-capped wooden wand + Ice Foci");
        LanguageRegistry.addName(limemagicappedChargedWand, "Lime Magi-capped charged moonstone wand");
        LanguageRegistry.addName(limemagicappedChargedWandFireFocus, "Lime Magi-capped charged moonstone wand + Fire Foci");
        LanguageRegistry.addName(limemagicappedChargedWandIceFocus, "Lime Magi-capped charged moonstone wand + Ice Foci");
        LanguageRegistry.addName(fireFocus, "Fire wand focus");
        LanguageRegistry.addName(iceFocus, "Ice wand focus");
        LanguageRegistry.addName(moonstonecap, "Moonstone wand cap");
        LanguageRegistry.addName(melonwoodwandcore, "Melonwood wand core");
        LanguageRegistry.addName(redmagicappedChargedWand, "Red Magi-capped charged moonstone wand");
        LanguageRegistry.addName(redmagicappedChargedWandFireFocus, "Red Magi-capped charged moonstone wand + Fire Foci");
        LanguageRegistry.addName(redmagicappedChargedWandIceFocus, "Red Magi-capped charged moonstone wand + Ice Foci");
        LanguageRegistry.addName(orangemagicappedChargedWand, "Orange Magi-capped charged moonstone wand");
        LanguageRegistry.addName(orangemagicappedChargedWandFireFocus, "Orange Magi-capped charged moonstone wand + Fire Foci");
        LanguageRegistry.addName(orangemagicappedChargedWandIceFocus, "Orange Magi-capped charged moonstone wand + Ice Foci");
        LanguageRegistry.addName(yellowmagicappedChargedWand, "Yellow Magi-capped charged moonstone wand");
        LanguageRegistry.addName(yellowmagicappedChargedWandFireFocus, "Yellow Magi-capped charged moonstone wand + Fire Foci");
        LanguageRegistry.addName(yellowmagicappedChargedWandIceFocus, "Yellow Magi-capped charged moonstone wand + Ice Foci");
        LanguageRegistry.addName(greenmagicappedChargedWand, "Green Magi-capped charged moonstone wand");
        LanguageRegistry.addName(greenmagicappedChargedWandFireFocus, "Green Magi-capped charged moonstone wand + Fire Foci");
        LanguageRegistry.addName(greenmagicappedChargedWandIceFocus, "Green Magi-capped charged moonstone wand + Ice Foci");
        LanguageRegistry.addName(cyanmagicappedChargedWand, "Cyan Magi-capped charged moonstone wand");
        LanguageRegistry.addName(cyanmagicappedChargedWandFireFocus, "Cyan Magi-capped charged moonstone wand + Fire Foci");
        LanguageRegistry.addName(cyanmagicappedChargedWandIceFocus, "Cyan Magi-capped charged moonstone wand + Ice Foci");
        LanguageRegistry.addName(bluemagicappedChargedWand, "Blue Magi-capped charged moonstone wand");
        LanguageRegistry.addName(bluemagicappedChargedWandFireFocus, "Blue Magi-capped charged moonstone wand + Fire Foci");
        LanguageRegistry.addName(bluemagicappedChargedWandIceFocus, "Blue Magi-capped charged moonstone wand + Ice Foci");
        LanguageRegistry.addName(purplemagicappedChargedWand, "Purple Magi-capped charged moonstone wand");
        LanguageRegistry.addName(purplemagicappedChargedWandFireFocus, "Purple Magi-capped charged moonstone wand + Fire Foci");
        LanguageRegistry.addName(purplemagicappedChargedWandIceFocus, "Purple Magi-capped charged moonstone wand + Ice Foci");
        //Add crafting
        GameRegistry.addRecipe(new ItemStack(melonplanks, 4), "#", '#', melonlog);
        GameRegistry.addRecipe(new ItemStack(melonstick, 4), "#", "#", '#', melonplanks);
        GameRegistry.addRecipe(new ItemStack(meloncobble, 4), "#", '#', melonStone);
        GameRegistry.addRecipe(new ItemStack(melonStone, 1), "##", "##", '#', meloncobble);
        GameRegistry.addRecipe(new ItemStack(melonBench, 1), "##", "##", '#', melonplanks);
        GameRegistry.addRecipe(new ItemStack(magistone, 1), "#", '#', magilava);
        GameRegistry.addRecipe(new ItemStack(magiDust, 4), "#", '#', magistone);
        GameRegistry.addRecipe(new ItemStack(magistone, 1), "##", "##", '#', magiDust);
        GameRegistry.addRecipe(new ItemStack(magilava, 2), "#$", '#', magilava, '$', magistone);
        GameRegistry.addRecipe(new ItemStack(moonstoneIngot, 1), "#", '#', moonstoneOre);
        GameRegistry.addRecipe(new ItemStack(portal, 2), "###", "#$#", "###", '#', Block.melon, '$', Item.ingotIron);
        GameRegistry.addRecipe(new ItemStack(redMGST, 2), "##", '#', magistone);
        GameRegistry.addRecipe(new ItemStack(orangeMGST, 2), "##", '#', redMGST);
        GameRegistry.addRecipe(new ItemStack(yellowMGST, 2), "##", '#', orangeMGST);
        GameRegistry.addRecipe(new ItemStack(limeMGST, 2), "##", '#', yellowMGST);
        GameRegistry.addRecipe(new ItemStack(greenMGST, 2), "##", '#', limeMGST);
        GameRegistry.addRecipe(new ItemStack(cyanMGST, 2), "##", '#', greenMGST);
        GameRegistry.addRecipe(new ItemStack(blueMGST, 2), "##", '#', cyanMGST);
        GameRegistry.addRecipe(new ItemStack(purpleMGST, 2), "##", '#', blueMGST);
        GameRegistry.addRecipe(new ItemStack(magistone, 2), "##", '#', purpleMGST);
        GameRegistry.addRecipe(new ItemStack(redMW, 2), "##", '#', normalMW);
        GameRegistry.addRecipe(new ItemStack(orangeMW, 2), "##", '#', redMW);
        GameRegistry.addRecipe(new ItemStack(yellowMW, 2), "##", '#', orangeMW);
        GameRegistry.addRecipe(new ItemStack(limeMW, 2), "##", '#', yellowMW);
        GameRegistry.addRecipe(new ItemStack(greenMW, 2), "##", '#', limeMW);
        GameRegistry.addRecipe(new ItemStack(cyanMW, 2), "##", '#', greenMW);
        GameRegistry.addRecipe(new ItemStack(blueMW, 2), "##", '#', cyanMW);
        GameRegistry.addRecipe(new ItemStack(purpleMW, 2), "##", '#', blueMW);
        GameRegistry.addRecipe(new ItemStack(greyMW, 2), "##", '#', purpleMW);
        GameRegistry.addRecipe(new ItemStack(normalMW, 2), "##", '#', greyMW);
        //Add biome
        biome = new MelonBiome(30);
        //Event handler
        MinecraftForge.EVENT_BUS.register(new MelonEventHandler());
    }

    public static boolean openCustomGui(World par1World, int par2, int par3,
            int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
            float par8, float par9, int id) {
        par5EntityPlayer.openGui(MelonCraft.instance, id, par1World, par2, par3, par4);
        return true;
    }
}
