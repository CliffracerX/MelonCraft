package meloncraft.src;

import java.util.Arrays;

import net.minecraftforge.common.EnumHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.GuiFlatPresets;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.FlatLayerInfo;
import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.common.Mod;
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

@Mod(modid="MelonMod", name="MelonCraft", version="The Readding Update")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class MelonCraft {
        
        
        @Instance("MelonMod")
        public static MelonCraft instance;
        public static CreativeTabs MelonTab = new MelTab("MelonTab1");
        public static EnumArmorMaterial melonWool = EnumHelper.addArmorMaterial("MW", 5, new int[]{1, 3, 2, 1}, 15);
        public static EnumArmorMaterial moonStone = EnumHelper.addArmorMaterial("MS", 15, new int[]{2, 6, 5, 2}, 9);
        public static EnumArmorMaterial plazma = EnumHelper.addArmorMaterial("PLZ", 33, new int[]{3, 8, 6, 3}, 10);
        public static int NMWIndex;
        public static int RMWIndex;
        public static int GMWIndex;
        public static int BMWIndex;
        public static int MSTIndex;
        public static int PLZIndex;
        public final static Block melonDirt = new MelonBlockBasicOO(200, Material.ground, "melonDirt").setHardness(0.25F).setStepSound(Block.soundGravelFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("melDirt");
        public final static Block melonStone = new MelonBlockStone(201, Material.ground, "melonStone", 0.75F, true, 0).setHardness(0.75F).setStepSound(Block.soundStoneFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("melStone");
        public final static Block melonGrass = new MelonBlockGrass(202, Material.grass, "melonGrass").setHardness(0.5F).setStepSound(Block.soundGrassFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("melGrass");
        public final static Block melonCobble = new MelonBlockStone(203, Material.ground, "melonCobble", 0.5F, true, 0).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("melCobble");
        public final static Block magilava = new MelonWateryBlock(204, Material.ground, "magilava", true).setHardness(0.25F).setStepSound(Block.soundClothFootstep).setCreativeTab(MelonCraft.MelonTab).setLightValue(1.0F).setUnlocalizedName("maglava");
        public final static Block melonjuice = new MelonWateryBlock(205, Material.ground, "melonjuice", false).setHardness(0.25F).setStepSound(Block.soundClothFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("meljuice");
        public final static Block melonportal = new MelPortBlock(206).setHardness(0.25F).setStepSound(Block.soundGlassFootstep).setCreativeTab(MelonCraft.MelonTab).setLightValue(1.0F).setUnlocalizedName("melPortal");
        public final static Block melonPlanks = new MelonBlockBasicOO(1600, Material.ground, "melonPlanks").setHardness(0.25F).setStepSound(Block.soundWoodFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("melPlanks");
        public final static Block melonLog = new MelonBlockBasicOO(1601, Material.ground, "melonLog").setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("melLog");
        public final static Block melonLeaves = new MelonLeaves(1602, "melonLeaves").setHardness(0.125F).setStepSound(Block.soundGrassFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("melLeaves");
        public final static Block melSap = new MelonSapling(1603, "melonSapling").setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("melSap");
        public final static Block magStone = new MelonBlockStone(1604, Material.ground, "magistone", 0.5F, false, 0).setHardness(0.5F).setStepSound(Block.soundGlassFootstep).setCreativeTab(MelonCraft.MelonTab).setLightValue(1.0F).setUnlocalizedName("magStone");
        public final static Block magTorch = new Magitorch(1605, "magitorch").setHardness(0.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(MelonCraft.MelonTab).setLightValue(1.0F).setUnlocalizedName("magTorch");
        public final static Block melCraftTable = new MelonBench(1606, Material.ground, "melonTable").setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("melCT");
        public final static Block normalMW = new MelonBlockBasicOO(2607, Material.ground, "normalMW").setHardness(0.5F).setStepSound(Block.soundSnowFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("melWool");
        public final static Block redMW = new MelonBlockBasicOO(2608, Material.ground, "redMW").setHardness(0.5F).setStepSound(Block.soundSnowFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("rMelWool");
        public final static Block greenMW = new MelonBlockBasicOO(2609, Material.ground, "greenMW").setHardness(0.5F).setStepSound(Block.soundSnowFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("gMelWool");
        public final static Block blueMW = new MelonBlockBasicOO(2610, Material.ground, "blueMW").setHardness(0.5F).setStepSound(Block.soundSnowFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("bMelWool");
        public final static Block redMGTC = new Magitorch(1611, "redMGTC").setHardness(0.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(MelonCraft.MelonTab).setLightValue(1.0F).setUnlocalizedName("rMagTrch");
        public final static Block greenMGTC = new Magitorch(1612, "greenMGTC").setHardness(0.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(MelonCraft.MelonTab).setLightValue(1.0F).setUnlocalizedName("gMagTrch");
        public final static Block blueMGTC = new Magitorch(1613, "blueMGTC").setHardness(0.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(MelonCraft.MelonTab).setLightValue(1.0F).setUnlocalizedName("bMagTrch");
        public final static Block redMGST = new MelonBlockStone(1614, Material.ground, "redMGST", 0.5F, false, 0).setHardness(0.5F).setStepSound(Block.soundGlassFootstep).setCreativeTab(MelonCraft.MelonTab).setLightValue(1.0F).setUnlocalizedName("rMagStn");
        public final static Block greenMGST = new MelonBlockStone(1615, Material.ground, "greenMGST", 0.5F, false, 0).setHardness(0.5F).setStepSound(Block.soundGlassFootstep).setCreativeTab(MelonCraft.MelonTab).setLightValue(1.0F).setUnlocalizedName("gMagStn");
        public final static Block blueMGST = new MelonBlockStone(1616, Material.ground, "blueMGST", 0.5F, false, 0).setHardness(0.5F).setStepSound(Block.soundGlassFootstep).setCreativeTab(MelonCraft.MelonTab).setLightValue(1.0F).setUnlocalizedName("bMagStn");
        public final static Block redML = new MelonWateryBlock(1617, Material.ground, "redML", true).setHardness(0.25F).setStepSound(Block.soundClothFootstep).setCreativeTab(MelonCraft.MelonTab).setLightValue(1.0F).setUnlocalizedName("rML");
        public final static Block redMJ = new MelonWateryBlock(1618, Material.ground, "redMJ", false).setHardness(0.25F).setStepSound(Block.soundClothFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("rMJ");
        public final static Block greenML = new MelonWateryBlock(1619, Material.ground, "greenML", true).setHardness(0.25F).setStepSound(Block.soundClothFootstep).setCreativeTab(MelonCraft.MelonTab).setLightValue(1.0F).setUnlocalizedName("gML");
        public final static Block greenMJ = new MelonWateryBlock(1620, Material.ground, "greenMJ", false).setHardness(0.25F).setStepSound(Block.soundClothFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("gMJ");
        public final static Block blueML = new MelonWateryBlock(1621, Material.ground, "blueML", true).setHardness(0.25F).setStepSound(Block.soundClothFootstep).setCreativeTab(MelonCraft.MelonTab).setLightValue(1.0F).setUnlocalizedName("bML");
        public final static Block blueMJ = new MelonWateryBlock(1622, Material.ground, "blueMJ", false).setHardness(0.25F).setStepSound(Block.soundClothFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("bMJ");
        public final static Block moonstoneOre = new MelonBlockStone(1623, Material.ground, "moonstoneOre", 1.5F, false, 1).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setCreativeTab(MelonCraft.MelonTab).setLightValue(0.5F).setUnlocalizedName("moonOre");
        public final static Block melonFurnaceLit = new MelonFurnace(1624, true, 0.5F).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setCreativeTab(MelonCraft.MelonTab).setLightValue(0.5F).setUnlocalizedName("melFurnLit");
        public final static Block melonFurnaceIdle = new MelonFurnace(1625, false, 0.5F).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("melFurnUnlit");
        public final static Block melonGlass = new MelonBlockTransparent(1626, Material.ground, "melonGlass").setHardness(0.5F).setStepSound(Block.soundGlassFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("melGlass");
        public final static Block plazmaOre = new MelonBlockStone(1627, Material.ground, "plazCrystOre", 1.5F, false, 2).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setCreativeTab(MelonCraft.MelonTab).setLightValue(0.5F).setUnlocalizedName("plazOre");
        public final static Block melonSeedBlock = new MelonBlockBasicOO(1628, Material.ground, "melonSeedsBlock").setHardness(0.25F).setStepSound(Block.soundSandFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("melSeedblock");
        public final static Block moonstoneBricks = new MelonBlockStone(1629, Material.ground, "moonstoneBricks", 2F, true, 1).setHardness(0.75F).setStepSound(Block.soundStoneFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("moonBricks");
        public final static Block drainedMagstone = new MelonBlockStoneSmoking(1630, Material.ground, "drainedMS", 0.5F, false, 0).setHardness(0.5F).setStepSound(Block.soundGlassFootstep).setCreativeTab(MelonCraft.MelonTab).setLightValue(0.5F).setUnlocalizedName("drainedMS");
        public final static Block frostyGrass = new FrostyMelonGrass(1631, Material.grass, "frostygrass").setHardness(0.5F).setStepSound(Block.soundGrassFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("frostGrass");
        public final static Block bendyOre = new BendyOre(1632, Material.ground, "bendyOre", 1.5F, false, 2).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("bendyOre");
        public final static Block bendyblock = new Bendyblock(1633, Material.ground, "bendyblock").setHardness(0.5F).setStepSound(Block.soundSnowFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("bendyblock");
        public final static Block rDyepot = new Dyepot(1634, "red", "rDyepot").setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("rDyepot");
        public final static Block gDyepot = new Dyepot(1635, "green", "gDyepot").setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("gDyepot");
        public final static Block bDyepot = new Dyepot(1636, "blue", "bDyepot").setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("bDyepot");
        public final static Block dyeLog = new MelonBlockBasicOO(1637, Material.ground, "dyeLog").setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("dyeLog");
        public final static Block dyeLeaf = new MelonLeavesDye(1638, "dyeLeaf").setHardness(0.125F).setStepSound(Block.soundGrassFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("dyeLeaves");
        public final static Block dyeSap = new MelonSaplingDye(1639, "dyeSap").setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setCreativeTab(MelonCraft.MelonTab).setUnlocalizedName("dyeSap");
        public final static Item magDust = new MelonItem(2537, "magiDust", 64).setUnlocalizedName("magDust");
        public final static Item melStick = new MelonItem(2538, "melonStick", 64).setUnlocalizedName("melStick");
        public final static Item melWoodPick = new MelonPick(2539, "melonwoodPick", 63, 2.0F, 0).setUnlocalizedName("melWoodPick");
        public final static Item melStonePick = new MelonPick(2540, "melonstonePick", 127, 4.0F, 1).setUnlocalizedName("melStonePick");
        public final static Item rrmws = new ItemMelonwoolSoldier(2541, "rrmwsI", 0).setUnlocalizedName("rrmws");
        public final static Item rgmws = new ItemMelonwoolSoldier(2542, "rgmwsI", 1).setUnlocalizedName("rgmws");
        public final static Item rbmws = new ItemMelonwoolSoldier(2543, "rbmwsI", 2).setUnlocalizedName("rbmws");
        public final static Item grmws = new ItemMelonwoolSoldier(2544, "grmwsI", 3).setUnlocalizedName("grmws");
        public final static Item ggmws = new ItemMelonwoolSoldier(2545, "ggmwsI", 4).setUnlocalizedName("ggmws");
        public final static Item gbmws = new ItemMelonwoolSoldier(2546, "gbmwsI", 5).setUnlocalizedName("gbmws");
        public final static Item brmws = new ItemMelonwoolSoldier(2547, "brmwsI", 6).setUnlocalizedName("brmws");
        public final static Item bgmws = new ItemMelonwoolSoldier(2548, "bgmwsI", 7).setUnlocalizedName("bgmws");
        public final static Item bbmws = new ItemMelonwoolSoldier(2549, "bbmwsI", 8).setUnlocalizedName("bbmws");
        public final static Item rwmws = new ItemMelonwoolSoldier(2550, "rwmwsI", 9).setUnlocalizedName("rwmws");
        public final static Item gwmws = new ItemMelonwoolSoldier(2551, "gwmwsI", 10).setUnlocalizedName("gwmws");
        public final static Item bwmws = new ItemMelonwoolSoldier(2552, "bwmwsI", 11).setUnlocalizedName("bwmws");
        public final static Item wrmws = new ItemMelonwoolSoldier(2553, "wrmwsI", 12).setUnlocalizedName("wrmws");
        public final static Item wgmws = new ItemMelonwoolSoldier(2554, "wgmwsI", 13).setUnlocalizedName("wgmws");
        public final static Item wbmws = new ItemMelonwoolSoldier(2555, "wbmwsI", 14).setUnlocalizedName("wbmws");
        public final static Item wwmws = new ItemMelonwoolSoldier(2556, "wwmwsI", 15).setUnlocalizedName("wwmws");
        public final static Item melWoodSword = new MelonSword(2557, "melonwoodSword", 63, 5).setUnlocalizedName("melWoodSword");
        public final static Item melStoneSword = new MelonSword(2558, "melonstoneSword", 127, 6).setUnlocalizedName("melStoneSword");
        public final static Item NMWH = new MelonArmor(2559, melonWool, NMWIndex, 0, "NMWH", "NMW").setUnlocalizedName("NMWH");
        public final static Item NMWC = new MelonArmor(2560, melonWool, NMWIndex, 1, "NMWC", "NMW").setUnlocalizedName("NMWC");
        public final static Item NMWL = new MelonArmor(2561, melonWool, NMWIndex, 2, "NMWL", "NMW").setUnlocalizedName("NMWL");
        public final static Item NMWB = new MelonArmor(2562, melonWool, NMWIndex, 3, "NMWB", "NMW").setUnlocalizedName("NMWB");
        public final static Item RMWH = new MelonArmor(2563, melonWool, RMWIndex, 0, "RMWH", "RMW").setUnlocalizedName("RMWH");
        public final static Item RMWC = new MelonArmor(2564, melonWool, RMWIndex, 1, "RMWC", "RMW").setUnlocalizedName("RMWC");
        public final static Item RMWL = new MelonArmor(2565, melonWool, RMWIndex, 2, "RMWL", "RMW").setUnlocalizedName("RMWL");
        public final static Item RMWB = new MelonArmor(2566, melonWool, RMWIndex, 3, "RMWB", "RMW").setUnlocalizedName("RMWB");
        public final static Item GMWH = new MelonArmor(2567, melonWool, GMWIndex, 0, "GMWH", "GMW").setUnlocalizedName("GMWH");
        public final static Item GMWC = new MelonArmor(2568, melonWool, GMWIndex, 1, "GMWC", "GMW").setUnlocalizedName("GMWC");
        public final static Item GMWL = new MelonArmor(2569, melonWool, GMWIndex, 2, "GMWL", "GMW").setUnlocalizedName("GMWL");
        public final static Item GMWB = new MelonArmor(2570, melonWool, GMWIndex, 3, "GMWB", "GMW").setUnlocalizedName("GMWB");
        public final static Item BMWH = new MelonArmor(2571, melonWool, BMWIndex, 0, "BMWH", "BMW").setUnlocalizedName("BMWH");
        public final static Item BMWC = new MelonArmor(2572, melonWool, BMWIndex, 1, "BMWC", "BMW").setUnlocalizedName("BMWC");
        public final static Item BMWL = new MelonArmor(2573, melonWool, BMWIndex, 2, "BMWL", "BMW").setUnlocalizedName("BMWL");
        public final static Item BMWB = new MelonArmor(2574, melonWool, BMWIndex, 3, "BMWB", "BMW").setUnlocalizedName("BMWB");
        public final static Item redMD = new MelonItem(2575, "redMD", 64).setUnlocalizedName("redMD");
        public final static Item greenMD = new MelonItem(2576, "greenMD", 64).setUnlocalizedName("greenMD");
        public final static Item blueMD = new MelonItem(2577, "blueMD", 64).setUnlocalizedName("blueMD");
        public final static Item moonStonePick = new MelonPick(2580, "moonstonePick", 767, 8.0F, 2).setUnlocalizedName("moonStonePick");
        public final static Item moonStoneSword = new MelonSword(2581, "moonstoneSword", 767, 7).setUnlocalizedName("melStoneSword");
        public final static Item moonstoneIngot = new MelonItem(2582, "moonstoneIngot", 64).setUnlocalizedName("blueMD");
        public final static Item MSTH = new MelonArmor(2583, moonStone, MSTIndex, 0, "moonstoneHelm", "MST").setUnlocalizedName("MSTH");
        public final static Item MSTC = new MelonArmor(2584, moonStone, MSTIndex, 1, "moonstoneChestplate", "MST").setUnlocalizedName("MSTC");
        public final static Item MSTL = new MelonArmor(2585, moonStone, MSTIndex, 2, "moonstoneLegs", "MST").setUnlocalizedName("MSTL");
        public final static Item MSTB = new MelonArmor(2586, moonStone, MSTIndex, 3, "moonstoneBoots", "MST").setUnlocalizedName("MSTB");
        public final static Item emptyMelBot = new MelonBottle(2587, "emptyMelBot", 64, 1, 0).setUnlocalizedName("emptyMelBot");
        public final static Item melBotNMJ = new MelonBottle(2588, "melBotPlainMJ", 64, 10, 1).setUnlocalizedName("melBotPlainMJ");
        public final static Item melBotRMJ = new MelonBottle(2589, "melBotRedMJ", 64, 5, 1).setUnlocalizedName("melBotRedMJ");
        public final static Item melBotGMJ = new MelonBottle(2590, "melBotGreenMJ", 64, 3, 1).setUnlocalizedName("melBotGreenMJ");
        public final static Item melBotBMJ = new MelonBottle(2591, "melBotBlueMJ", 64, 1, 1).setUnlocalizedName("melBotBlueMJ");
        public final static Item melStnShrd = new MelonItem(2592, "melStnShrd", 64).setUnlocalizedName("melStnShrd");
        public final static Item rrminimws = new ItemMiniMWS(2593, "rrmwsI", 0).setUnlocalizedName("rrminimws");
        public final static Item rgminimws = new ItemMiniMWS(2594, "rgmwsI", 1).setUnlocalizedName("rgminimws");
        public final static Item rbminimws = new ItemMiniMWS(2595, "rbmwsI", 2).setUnlocalizedName("rbminimws");
        public final static Item grminimws = new ItemMiniMWS(2596, "grmwsI", 3).setUnlocalizedName("grminimws");
        public final static Item ggminimws = new ItemMiniMWS(2597, "ggmwsI", 4).setUnlocalizedName("ggminimws");
        public final static Item gbminimws = new ItemMiniMWS(2598, "gbmwsI", 5).setUnlocalizedName("gbminimws");
        public final static Item brminimws = new ItemMiniMWS(2599, "brmwsI", 6).setUnlocalizedName("brminimws");
        public final static Item bgminimws = new ItemMiniMWS(2600, "bgmwsI", 7).setUnlocalizedName("bgminimws");
        public final static Item bbminimws = new ItemMiniMWS(2601, "bbmwsI", 8).setUnlocalizedName("bbminimws");
        public final static Item rwminimws = new ItemMiniMWS(2602, "rwmwsI", 9).setUnlocalizedName("rwminimws");
        public final static Item gwminimws = new ItemMiniMWS(2603, "gwmwsI", 10).setUnlocalizedName("gwminimws");
        public final static Item bwminimws = new ItemMiniMWS(2604, "bwmwsI", 11).setUnlocalizedName("bwminimws");
        public final static Item wrminimws = new ItemMiniMWS(2605, "wrmwsI", 12).setUnlocalizedName("wrminimws");
        public final static Item wgminimws = new ItemMiniMWS(2606, "wgmwsI", 13).setUnlocalizedName("wgminimws");
        public final static Item wbminimws = new ItemMiniMWS(2607, "wbmwsI", 14).setUnlocalizedName("wbminimws");
        public final static Item wwminimws = new ItemMiniMWS(2608, "wwmwsI", 15).setUnlocalizedName("wwminimws");
        public final static Item PLZH = new MelonArmor(2609, plazma, PLZIndex, 0, "plazHelm", "PLZ").setUnlocalizedName("PLZH");
        public final static Item PLZC = new MelonArmor(2610, plazma, PLZIndex, 1, "plazChest", "PLZ").setUnlocalizedName("PLZC");
        public final static Item PLZL = new MelonArmor(2611, plazma, PLZIndex, 2, "plazLegs", "PLZ").setUnlocalizedName("PLZL");
        public final static Item PLZB = new MelonArmor(2612, plazma, PLZIndex, 3, "plazBoots", "PLZ").setUnlocalizedName("PLZB");
        public final static Item plazPick = new MelonPick(2613, "plazPick", 1536, 12.0F, 3).setUnlocalizedName("plazPick");
        public final static Item plazSword = new MelonSword(2614, "plazSword", 1536, 10).setUnlocalizedName("plazSword");
        public final static Item plazmaGem = new MelonItem(2615, "plazmaCrystal", 64).setUnlocalizedName("plazmaGem");
        public final static Item roastMelon = new MelonItem(2616, "roastMelon", 64).setUnlocalizedName("roastMelon");
        public final static Item bendybarBlob = new MelonItem(2617, "bendybarBlob", 64).setUnlocalizedName("bendybarBlob");
        public final static Item drainedMagidust = new MelonItem(2618, "drainedMD", 64).setUnlocalizedName("drainedMD");
        public final static Item melzombSpawnegg = new Spawnegg(2619, "mzSE", 0).setUnlocalizedName("melzombSpawnegg");
        public final static Item woodShov = new MelonShovel(2620, "woodShov", 63, 2.0F).setUnlocalizedName("woodShov");
        public final static Item stoneShov = new MelonShovel(2621, "stoneShov", 127, 4.0F).setUnlocalizedName("stoneShov");
        public final static Item moonShov = new MelonShovel(2622, "moonShov", 767, 8.0F).setUnlocalizedName("moonShov");
        public final static Item plazShov = new MelonShovel(2623, "plazShov", 1536, 12.0F).setUnlocalizedName("plazShov");
        public final static Item woodAxe = new MelonAxe(2624, "woodAxe", 63, 2.0F).setUnlocalizedName("woodAxe");
        public final static Item stoneAxe = new MelonAxe(2625, "stoneAxe", 127, 4.0F).setUnlocalizedName("stoneAxe");
        public final static Item moonAxe = new MelonAxe(2626, "moonAxe", 767, 8.0F).setUnlocalizedName("moonAxe");
        public final static Item plazAxe = new MelonAxe(2627, "plazAxe", 1536, 12.0F).setUnlocalizedName("plazAxe");
        public final static Item bendyIngot = new MelonItem(2628, "bendyIngot", 64).setUnlocalizedName("bendyIngot");
        public final static Item moonShears = new MelonItem(2629, "moonShears", 1).setUnlocalizedName("moonShears");
        public final static Item rDye = new MelonItem(2630, "rDye", 64).setUnlocalizedName("rDye");
        public final static Item gDye = new MelonItem(2631, "gDye", 64).setUnlocalizedName("gDye");
        public final static Item bDye = new MelonItem(2632, "bDye", 64).setUnlocalizedName("bDye");
        public final static Item melSheepSpawner = new Spawnegg(2633, "mzSE", 1).setUnlocalizedName("melSheepSpawner");
        public final static Item portPlace = new MelonPortalPlacer(2634).setUnlocalizedName("portPlace");
        public static final BiomeGenBase biome = new MelonBiome(30);

        @SidedProxy(clientSide="meloncraft.src.ClientProxy",
                        serverSide="meloncraft.src.CommonProxy")
        public static CommonProxy proxy;
        
        @PreInit
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Method
        }
        
        @Init
        public void load(FMLInitializationEvent event) {
        	//Client proxy stuff
        	ClientProxy.registerRenderInformation();
        	//Register certain things
        	EntityRegistry.registerModEntity(EntityMelonwoolSoldier.class, "Melonwool Soldier", 256, this, 64, 1, true);
        	EntityRegistry.registerModEntity(EntityMiniMelonwoolSoldier.class, "Mini Melonwool Soldier", 257, this, 64, 1, true);
        	EntityRegistry.registerModEntity(MelonZombie.class, "Melonzombie", 258, this, 64, 1, true);
        	EntityRegistry.registerModEntity(MelonSheep.class, "MelonSheep", 259, this, 64, 1, true);
            NetworkRegistry.instance().registerGuiHandler(this, new CommonProxy());
                //Dimension registers
        	DimensionManager.registerProviderType(-2, MelonWorldProvider.class, true);
            DimensionManager.registerDimension(-2, -2);
            //Misc. names
        	LanguageRegistry.instance().addStringLocalization("itemGroup.MelonTab1", "en_US", "Meloncraft loot");
        	//Block names, registerBlocks
                LanguageRegistry.addName(melonDirt, "Melon Dirt");
                GameRegistry.registerBlock(melonDirt, "melonDirt");
                LanguageRegistry.addName(melonGrass, "Melon Grass");
                GameRegistry.registerBlock(melonGrass, "melonGrass");
                LanguageRegistry.addName(melonStone, "Melon Stone");
                GameRegistry.registerBlock(melonStone, "melonStone");
                LanguageRegistry.addName(melonCobble, "Melon Cobblestone");
                GameRegistry.registerBlock(melonCobble, "melonCobble");
                LanguageRegistry.addName(melonjuice, "MelonJuice (normal)");
                GameRegistry.registerBlock(melonjuice, "melonJuice");
                LanguageRegistry.addName(magilava, "MagiLava (normal)");
                GameRegistry.registerBlock(magilava, "magilava");
                LanguageRegistry.addName(melonportal, "Melonportal");
                GameRegistry.registerBlock(melonportal, "melonportal");
                LanguageRegistry.addName(magStone, "MagiStone");
                GameRegistry.registerBlock(magStone, "magStone");
                LanguageRegistry.addName(melonPlanks, "Melon Planks");
                GameRegistry.registerBlock(melonPlanks, "melonPlanks");
                LanguageRegistry.addName(melonLog, "Melon Log");
                GameRegistry.registerBlock(melonLog, "melonLog");
                LanguageRegistry.addName(melonLeaves, "Melon Leaves");
                GameRegistry.registerBlock(melonLeaves, "melonLeaves");
                LanguageRegistry.addName(melSap, "Melon Sapling");
                GameRegistry.registerBlock(melSap, "melonSapling");
                LanguageRegistry.addName(magTorch, "Magi Torch");
                GameRegistry.registerBlock(magTorch, "magTorch");
                LanguageRegistry.addName(melCraftTable, "MelonTable");
                GameRegistry.registerBlock(melCraftTable, "melCraftTable");
                LanguageRegistry.addName(normalMW, "Normal Melonwool");
                GameRegistry.registerBlock(normalMW, "normalMW");
                LanguageRegistry.addName(redMW, "Red Melonwool");
                GameRegistry.registerBlock(redMW, "redMW");
                LanguageRegistry.addName(greenMW, "Green Melonwool");
                GameRegistry.registerBlock(greenMW, "greenMW");
                LanguageRegistry.addName(blueMW, "Blue Melonwool");
                GameRegistry.registerBlock(blueMW, "blueMW");
                LanguageRegistry.addName(redMGST, "Red Magistone");
                GameRegistry.registerBlock(redMGST, "redMGST");
                LanguageRegistry.addName(redMGTC, "Red Magitorch");
                GameRegistry.registerBlock(redMGTC, "redMGTC");
                LanguageRegistry.addName(greenMGST, "Green Magistone");
                GameRegistry.registerBlock(greenMGST, "greenMGST");
                LanguageRegistry.addName(greenMGTC, "Green Magitorch");
                GameRegistry.registerBlock(greenMGTC, "greenMGTC");
                LanguageRegistry.addName(blueMGST, "Blue Magistone");
                GameRegistry.registerBlock(blueMGST, "blueMGST");
                LanguageRegistry.addName(blueMGTC, "Blue Magitorch");
                GameRegistry.registerBlock(blueMGTC, "blueMGTC");
                LanguageRegistry.addName(redMJ, "Red Melonjuice");
                GameRegistry.registerBlock(redMJ, "redMJ");
                LanguageRegistry.addName(redML, "Red Magilava");
                GameRegistry.registerBlock(redML, "redML");
                LanguageRegistry.addName(greenMJ, "Green Melonjuice");
                GameRegistry.registerBlock(greenMJ, "greenMJ");
                LanguageRegistry.addName(greenML, "Green Magilava");
                GameRegistry.registerBlock(greenML, "greenML");
                LanguageRegistry.addName(blueMJ, "Blue Melonjuice");
                GameRegistry.registerBlock(blueMJ, "blueMJ");
                LanguageRegistry.addName(blueML, "Blue Magilava");
                GameRegistry.registerBlock(blueML, "blueML");
                LanguageRegistry.addName(moonstoneOre, "Moonstone ore");
                GameRegistry.registerBlock(moonstoneOre, "moonstoneOre");
                LanguageRegistry.addName(melonFurnaceIdle, "Melonfurnace (Idle)");
                GameRegistry.registerBlock(melonFurnaceIdle, "melonFurnaceIdle");
                LanguageRegistry.addName(melonFurnaceLit, "Melonfurnace (Lit)");
                GameRegistry.registerBlock(melonFurnaceLit, "melonFurnaceLit");
                LanguageRegistry.addName(melonGlass, "Melon-Glass");
                GameRegistry.registerBlock(melonGlass, "melonGlass");
                LanguageRegistry.addName(plazmaOre, "Plazma Ore");
                GameRegistry.registerBlock(plazmaOre, "plazmaOre");
                LanguageRegistry.addName(melonSeedBlock, "Melon Seeds Block");
                GameRegistry.registerBlock(melonSeedBlock, "melonSeedBlock");
                LanguageRegistry.addName(moonstoneBricks, "Moonstone bricks");
                GameRegistry.registerBlock(moonstoneBricks, "moonstoneBricks");
                LanguageRegistry.addName(drainedMagstone, "Drained Magistone");
                GameRegistry.registerBlock(drainedMagstone, "drainedMagistone");
                LanguageRegistry.addName(frostyGrass, "Frosty MelonGrass");
                GameRegistry.registerBlock(frostyGrass, "frostyGrass");
                LanguageRegistry.addName(bendyOre, "Bendybar Ore");
                GameRegistry.registerBlock(bendyOre, "bendyOre");
                LanguageRegistry.addName(bendyblock, "Bendybar Block");
                GameRegistry.registerBlock(bendyblock, "bendyblock");
                LanguageRegistry.addName(rDyepot, "Red Dyepot");
                GameRegistry.registerBlock(rDyepot, "rDyepot");
                LanguageRegistry.addName(gDyepot, "Green Dyepot");
                GameRegistry.registerBlock(gDyepot, "gDyepot");
                LanguageRegistry.addName(bDyepot, "Blue Dyepot");
                GameRegistry.registerBlock(bDyepot, "bDyepot");
                LanguageRegistry.addName(dyeLog, "Dyetree Log");
                GameRegistry.registerBlock(dyeLog, "dyeLog");
                LanguageRegistry.addName(dyeLeaf, "Dyetree Leaves");
                GameRegistry.registerBlock(dyeLeaf, "dyeLeaf");
                LanguageRegistry.addName(dyeSap, "Dyetree Sapling");
                GameRegistry.registerBlock(dyeSap, "dyeSap");
                //Item names
                LanguageRegistry.addName(magDust, "MagiDust");
                LanguageRegistry.addName(melStick, "MelonStick");
                LanguageRegistry.addName(melWoodPick, "MelonWood pickaxe");
                LanguageRegistry.addName(melStonePick, "MelonStone pickaxe");
                LanguageRegistry.addName(rrmws, "Red Red Melonwool Soldier");
                LanguageRegistry.addName(rgmws, "Red Green Melonwool Soldier");
                LanguageRegistry.addName(rbmws, "Red Blue Melonwool Soldier");
                LanguageRegistry.addName(rwmws, "Red Plain Melonwool Soldier");
                LanguageRegistry.addName(grmws, "Green Red Melonwool Soldier");
                LanguageRegistry.addName(ggmws, "Green Green Melonwool Soldier");
                LanguageRegistry.addName(gbmws, "Green Blue Melonwool Soldier");
                LanguageRegistry.addName(gwmws, "Green Plain Melonwool Soldier");
                LanguageRegistry.addName(brmws, "Blue Red Melonwool Soldier");
                LanguageRegistry.addName(bgmws, "Blue Green Melonwool Soldier");
                LanguageRegistry.addName(bbmws, "Blue Blue Melonwool Soldier");
                LanguageRegistry.addName(bwmws, "Blue Plain Melonwool Soldier");
                LanguageRegistry.addName(wrmws, "Plain Red Melonwool Soldier");
                LanguageRegistry.addName(wgmws, "Plain Green Melonwool Soldier");
                LanguageRegistry.addName(wbmws, "Plain Blue Melonwool Soldier");
                LanguageRegistry.addName(wwmws, "Plain Plain Melonwool Soldier");
                LanguageRegistry.addName(melWoodSword, "Melonwood Sword");
                LanguageRegistry.addName(melStoneSword, "Melonstone Sword");
                LanguageRegistry.addName(RMWH, "Red Melonwool Hat");
                LanguageRegistry.addName(RMWC, "Red Melonwool Shirt");
                LanguageRegistry.addName(RMWL, "Red Melonwool Pants");
                LanguageRegistry.addName(RMWB, "Red Melonwool Shoes");
                LanguageRegistry.addName(GMWH, "Green Melonwool Hat");
                LanguageRegistry.addName(GMWC, "Green Melonwool Shirt");
                LanguageRegistry.addName(GMWL, "Green Melonwool Pants");
                LanguageRegistry.addName(GMWB, "Green Melonwool Shoes");
                LanguageRegistry.addName(BMWH, "Blue Melonwool Hat");
                LanguageRegistry.addName(BMWC, "Blue Melonwool Shirt");
                LanguageRegistry.addName(BMWL, "Blue Melonwool Pants");
                LanguageRegistry.addName(BMWB, "Blue Melonwool Shoes");
                LanguageRegistry.addName(NMWH, "Normal Melonwool Hat");
                LanguageRegistry.addName(NMWC, "Normal Melonwool Shirt");
                LanguageRegistry.addName(NMWL, "Normal Melonwool Pants");
                LanguageRegistry.addName(NMWB, "Normal Melonwool Shoes");
                LanguageRegistry.addName(redMD, "Red Magidust");
                LanguageRegistry.addName(greenMD, "Green Magidust");
                LanguageRegistry.addName(redMD, "Red Magidust");
                LanguageRegistry.addName(moonStonePick, "Moonstone Pick");
                LanguageRegistry.addName(moonStoneSword, "Moonstone Sword");
                LanguageRegistry.addName(moonstoneIngot, "Moonstone Ingot");
                LanguageRegistry.addName(MSTH, "Moonstone Helmet");
                LanguageRegistry.addName(MSTC, "Moonstone Chestplate");
                LanguageRegistry.addName(MSTL, "Moonstone Greaves");
                LanguageRegistry.addName(MSTB, "Moonstone Boots");
                LanguageRegistry.addName(emptyMelBot, "Empty Melonbottle");
                LanguageRegistry.addName(melBotNMJ, "Melonbottle: Normal Melonjuice");
                LanguageRegistry.addName(melBotRMJ, "Melonbottle: Red Melonjuice");
                LanguageRegistry.addName(melBotGMJ, "Melonbottle: Green Melonjuice");
                LanguageRegistry.addName(melBotBMJ, "Melonbottle: Blue Melonjuice");
                LanguageRegistry.addName(melStnShrd, "Melonstone Shard");
                LanguageRegistry.addName(rrminimws, "Red Red Melonwool Being #1 (WIP)");
                LanguageRegistry.addName(rgminimws, "Red Green Melonwool Being #1 (WIP)");
                LanguageRegistry.addName(rbminimws, "Red Blue Melonwool Being #1 (WIP)");
                LanguageRegistry.addName(rwminimws, "Red Plain Melonwool Being #1 (WIP)");
                LanguageRegistry.addName(grminimws, "Green Red Melonwool Being #1 (WIP)");
                LanguageRegistry.addName(ggminimws, "Green Green Melonwool Being #1 (WIP)");
                LanguageRegistry.addName(gbminimws, "Green Blue Melonwool Being #1 (WIP)");
                LanguageRegistry.addName(gwminimws, "Green Plain Melonwool Being #1 (WIP)");
                LanguageRegistry.addName(brminimws, "Blue Red Melonwool Being #1 (WIP)");
                LanguageRegistry.addName(bgminimws, "Blue Green Melonwool Being #1 (WIP)");
                LanguageRegistry.addName(bbminimws, "Blue Blue Melonwool Being #1 (WIP)");
                LanguageRegistry.addName(bwminimws, "Blue Plain Melonwool Being #1 (WIP)");
                LanguageRegistry.addName(wrminimws, "Plain Red Melonwool Being #1 (WIP)");
                LanguageRegistry.addName(wgminimws, "Plain Green Melonwool Being #1 (WIP)");
                LanguageRegistry.addName(wbminimws, "Plain Blue Melonwool Being #1 (WIP)");
                LanguageRegistry.addName(wwminimws, "Plain Plain Melonwool Being #1 (WIP)");
                LanguageRegistry.addName(PLZH, "Plazma/Moonstone Helmet");
                LanguageRegistry.addName(PLZC, "Plazma/Moonstone Chestplate");
                LanguageRegistry.addName(PLZL, "Plazma/Moonstone Greaves");
                LanguageRegistry.addName(PLZB, "Plazma/Moonstone Boots");
                LanguageRegistry.addName(plazPick, "Plazma Pickaxe");
                LanguageRegistry.addName(plazSword, "Plazma Sword");
                LanguageRegistry.addName(plazmaGem, "Plazma Gem");
                LanguageRegistry.addName(roastMelon, "Roasted Melon");
                LanguageRegistry.addName(bendybarBlob, "Bendybar Blob");
                LanguageRegistry.addName(drainedMagidust, "Drained Magidust");
                LanguageRegistry.addName(melzombSpawnegg, "MelonZombie Spawnegg");
                LanguageRegistry.addName(woodShov, "Melonwood Shovel");
                LanguageRegistry.addName(stoneShov, "Melonstone Shovel");
                LanguageRegistry.addName(moonShov, "Moonstone Shovel");
                LanguageRegistry.addName(plazShov, "Plazma Shovel");
                LanguageRegistry.addName(woodAxe, "Melonwood Axe");
                LanguageRegistry.addName(stoneAxe, "Melonstone Axe");
                LanguageRegistry.addName(moonAxe, "Moonstone Axe");
                LanguageRegistry.addName(plazAxe, "Plazma Axe");
                LanguageRegistry.addName(bendyIngot, "Bendybar Ingot");
                LanguageRegistry.addName(moonShears, "Moonstone Shears");
                LanguageRegistry.addName(melSheepSpawner, "MelonSheep Spawnegg");
                LanguageRegistry.addName(rDye, "Red Dye");
                LanguageRegistry.addName(gDye, "Green Dye");
                LanguageRegistry.addName(bDye, "Blue Dye");
                LanguageRegistry.addName(portPlace, "Melonportal Placer");
                //Crafting
                GameRegistry.addRecipe(new ItemStack(melonCobble, 4), "X", 'X', MelonCraft.melonStone);
                GameRegistry.addRecipe(new ItemStack(melonStone, 1), "XX", "XX", 'X', MelonCraft.melonCobble);
                GameRegistry.addRecipe(new ItemStack(magDust, 4), "X", 'X', MelonCraft.magStone);
                GameRegistry.addRecipe(new ItemStack(melStick, 4), "X", "X", 'X', MelonCraft.melonPlanks);
                GameRegistry.addRecipe(new ItemStack(magStone, 1), "XX", "XX", 'X', MelonCraft.magDust);
                GameRegistry.addRecipe(new ItemStack(melonPlanks, 4), "X", 'X', MelonCraft.melonLog);
                GameRegistry.addRecipe(new ItemStack(melonPlanks, 4), "X", 'X', MelonCraft.dyeLog);
                GameRegistry.addRecipe(new ItemStack(melonDirt, 6), "XX", "#X", 'X', MelonCraft.melonPlanks, '#', MelonCraft.melSap);
                GameRegistry.addRecipe(new ItemStack(melonStone, 3), "XX", "#X", 'X', MelonCraft.melonPlanks, '#', MelonCraft.melonStone);
                GameRegistry.addRecipe(new ItemStack(magStone, 3), "XX", "#X", 'X', MelonCraft.melonStone, '#', MelonCraft.magStone);
                GameRegistry.addRecipe(new ItemStack(melonjuice, 3), "X#", 'X', MelonCraft.magStone, '#', MelonCraft.melonjuice);
                GameRegistry.addRecipe(new ItemStack(magilava, 2), "X#", 'X', MelonCraft.magStone, '#', MelonCraft.magilava);
                GameRegistry.addRecipe(new ItemStack(magStone, 1), "#", '#', MelonCraft.magilava);
                GameRegistry.addRecipe(new ItemStack(magTorch, 4), "#", "X", 'X', MelonCraft.melStick, '#', MelonCraft.magDust);
                GameRegistry.addRecipe(new ItemStack(melCraftTable, 1), "XX", "XX", 'X', MelonCraft.melonPlanks);
                GameRegistry.addRecipe(new ItemStack(redMD, 4), "X", 'X', MelonCraft.redMGST);
                GameRegistry.addRecipe(new ItemStack(redMGST, 1), "XX", "XX", 'X', MelonCraft.redMD);
                GameRegistry.addRecipe(new ItemStack(redMGTC, 4), "#", "X", 'X', MelonCraft.melStick, '#', MelonCraft.redMD);
                GameRegistry.addRecipe(new ItemStack(redMGST, 3), "XX", "#X", 'X', MelonCraft.melonStone, '#', MelonCraft.redMGST);
                GameRegistry.addRecipe(new ItemStack(greenMD, 4), "X", 'X', MelonCraft.greenMGST);
                GameRegistry.addRecipe(new ItemStack(greenMGST, 1), "XX", "XX", 'X', MelonCraft.greenMD);
                GameRegistry.addRecipe(new ItemStack(greenMGTC, 4), "#", "X", 'X', MelonCraft.melStick, '#', MelonCraft.greenMD);
                GameRegistry.addRecipe(new ItemStack(greenMGST, 3), "XX", "#X", 'X', MelonCraft.melonStone, '#', MelonCraft.greenMGST);
                GameRegistry.addRecipe(new ItemStack(blueMD, 4), "X", 'X', MelonCraft.blueMGST);
                GameRegistry.addRecipe(new ItemStack(blueMGST, 1), "XX", "XX", 'X', MelonCraft.blueMD);
                GameRegistry.addRecipe(new ItemStack(blueMGTC, 4), "#", "X", 'X', MelonCraft.melStick, '#', MelonCraft.blueMD);
                GameRegistry.addRecipe(new ItemStack(blueMGST, 3), "XX", "#X", 'X', MelonCraft.melonStone, '#', MelonCraft.blueMGST);
                GameRegistry.addRecipe(new ItemStack(redMJ, 3), "X#", 'X', MelonCraft.redMGST, '#', MelonCraft.redMJ);
                GameRegistry.addRecipe(new ItemStack(redML, 2), "X#", 'X', MelonCraft.redMGST, '#', MelonCraft.redML);
                GameRegistry.addRecipe(new ItemStack(redMGST, 1), "#", '#', MelonCraft.redML);
                GameRegistry.addRecipe(new ItemStack(greenMJ, 3), "X#", 'X', MelonCraft.greenMGST, '#', MelonCraft.greenMJ);
                GameRegistry.addRecipe(new ItemStack(greenML, 2), "X#", 'X', MelonCraft.greenMGST, '#', MelonCraft.greenML);
                GameRegistry.addRecipe(new ItemStack(greenMGST, 1), "#", '#', MelonCraft.greenML);
                GameRegistry.addRecipe(new ItemStack(blueMJ, 3), "X#", 'X', MelonCraft.blueMGST, '#', MelonCraft.blueMJ);
                GameRegistry.addRecipe(new ItemStack(blueML, 2), "X#", 'X', MelonCraft.blueMGST, '#', MelonCraft.blueML);
                GameRegistry.addRecipe(new ItemStack(blueMGST, 1), "#", '#', MelonCraft.blueML);
                //GameRegistry.addRecipe(new ItemStack(moonstoneOre, 2), "XX", "#X", 'X', MelonCraft.melonStone, '#', MelonCraft.moonstoneIngot);
                GameRegistry.addRecipe(new ItemStack(drainedMagidust, 4), "X", 'X', MelonCraft.drainedMagstone);
                GameRegistry.addRecipe(new ItemStack(drainedMagstone, 1), "XX", "XX", 'X', MelonCraft.drainedMagidust);
                //GameRegistry.addRecipe(new ItemStack(melonGlass, 4), "X", 'X', MelonCraft.melonCobble);
                //GameRegistry.addRecipe(new ItemStack(melonCobble, 1), "XX", "XX", 'X', MelonCraft.melonGlass);
                GameRegistry.addRecipe(new ItemStack(emptyMelBot, 1), "X", "X", 'X', MelonCraft.melonGlass);
                //GameRegistry.addRecipe(new ItemStack(plazmaOre, 2), "XX", "#X", 'X', MelonCraft.melonStone, '#', MelonCraft.plazmaGem);
                GameRegistry.addRecipe(new ItemStack(moonShears, 1), "X ", " X", 'X', MelonCraft.moonstoneIngot);
                GameRegistry.addRecipe(new ItemStack(portPlace, 1), "XXX", "X#X", "XXX", 'X', Block.melon, '#', Block.fenceIron);
                //Tile entities
                GameRegistry.registerTileEntity(MelonFurnaceTileEnt.class, "MelonFurnace");
        }
        
        @PostInit
        @SideOnly(Side.CLIENT)
        /**
         * Doing Clientside stuff here.
         * @param event
         */
        public void postInit(FMLPostInitializationEvent event)
        {
        	NMWIndex = ClientProxy.addArmour("NMW");
        	RMWIndex = ClientProxy.addArmour("RMW");
        	GMWIndex = ClientProxy.addArmour("GMW");
        	BMWIndex = ClientProxy.addArmour("BMW");
        	MSTIndex = ClientProxy.addArmour("MST");
        	PLZIndex = ClientProxy.addArmour("PLZ");
        	GuiFlatPresets.addPreset("Melondimension Superflat", melonGrass.blockID, biome, Arrays.asList(new String[] {"decoration"}), new FlatLayerInfo[] {new FlatLayerInfo(1, melonGrass.blockID), new FlatLayerInfo(2, melonDirt.blockID), new FlatLayerInfo(60, melonStone.blockID), new FlatLayerInfo(1, Block.bedrock.blockID)});
        	GuiFlatPresets.addPreset("Melondimension Superflat Doomworld", magStone.blockID, biome, Arrays.asList(new String[] {"decoration"}), new FlatLayerInfo[] {new FlatLayerInfo(1, melonGrass.blockID), new FlatLayerInfo(2, melonDirt.blockID), new FlatLayerInfo(26, melonStone.blockID), new FlatLayerInfo(8, 0), new FlatLayerInfo(26, melonStone.blockID), new FlatLayerInfo(1, Block.bedrock.blockID)});
        }

		public static MelonCraft getInstance()
		{
			return instance;
		}
		
		public static boolean openCustomGui(World par1World, int par2, int par3,
				int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
				float par8, float par9, int id) {
	        par5EntityPlayer.openGui(MelonCraft.instance, id, par1World, par2, par3, par4);
			return true;
		}
}