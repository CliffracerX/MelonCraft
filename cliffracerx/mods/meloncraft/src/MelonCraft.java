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
    public static StepSound soundWaterFootstep = new MelonStepSound("liquid.swim", 1, 1);
    public static StepSound soundLavaFootstep = new MelonStepSound("liquid.lavapop", 1, 1);
    public static StepSound soundMachineFootstep = new MelonStepSoundMining("meloncraft:blocks.machine", 1, 1);
    
    @Instance("MelonCraft")
    public static MelonCraft instance;
    
    @SidedProxy(clientSide = "cliffracerx.mods.meloncraft.src.ClientProxy",
            serverSide = "cliffracerx.mods.meloncraft.src.CommonProxy")
    public static CommonProxy proxy;
    public static BiomeGenBase biome;
    
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
        moonstoneCappedWoodenWand = new MelonWand(moonstoneCappedWoodenWandID, "moonstoneCappedWoodenWand", 100, "wood", "moonstone", "blank", 1);
        moonstoneCappedWoodenWandFireFocus = new MelonWand(moonstoneCappedWoodenWandFireFocusID, "moonstoneCappedWoodenWandFireFocus", 100, "wood", "moonstone", "fire", 1);
        moonstoneCappedWoodenWandIceFocus = new MelonWand(moonstoneCappedWoodenWandIceFocusID, "moonstoneCappedWoodenWandIceFocus", 100, "wood", "moonstone", "ice", 1);
        limemagicappedChargedWand = new MelonWand(limemagicappedChargedWandID, "limemagicappedChargedWand", 450, "chargedmoonstone", "limemagi", "blank", 5);
        limemagicappedChargedWandFireFocus = new MelonWand(limemagicappedChargedWandFireFocusID, "limemagicappedChargedWandFireFocus", 450, "chargedmoonstone", "limemagi", "fire", 5);
        limemagicappedChargedWandIceFocus = new MelonWand(limemagicappedChargedWandIceFocusID, "limemagicappedChargedWandIceFocus", 450, "chargedmoonstone", "limemagi", "ice", 5);
        fireFocus = new GenericMelonItem(fireFocusID, "fireFocus");
        melonwoodwandcore = new GenericMelonItem(melonwoodwandcoreID, "melonwoodwandcore");
        moonstonecap = new GenericMelonItem(moonstonecapID, "moonstonecap");
        iceFocus = new GenericMelonItem(iceFocusID, "iceFocus");
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
