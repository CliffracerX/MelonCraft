package cliffracerx.mods.meloncraft.src;

import sanandreasp.mods.ClaySoldiersMod.registry.SoldierTeams;
import morph.common.ability.AbilityHandler;
import morph.common.ability.AbilityStep;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.BlockStationary;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;
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
    public static Block melonDirt;
    public static Block melonStone;
    public static Block melonGrass;
    public static Block portal;
    public static Block magistone;
    public static Block melonlog;
    public static Block melonplanks;
    public static Block melonleaves;
    public static Block melonsapling;
    
    @Instance("MelonCraft")
    public static MelonCraft instance;
    
    @SidedProxy(clientSide = "cliffracerx.mods.meloncraft.src.ClientProxy",
            serverSide = "cliffracerx.mods.meloncraft.src.CommonProxy")
    public static CommonProxy proxy;
    public static final BiomeGenBase biome = new MelonBiome(30);
    
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
        // saving the configuration to its file
        config.save();
    }
    
    @EventHandler
    @SideOnly(Side.CLIENT)
    public void load(FMLInitializationEvent event)
    {
        ClientProxy.registerRenderers();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        //Registering the MelonDimension
        DimensionManager.registerProviderType(-2, MelonWorldProvider.class, true);
        DimensionManager.registerDimension(-2, -2);
        //Actually initializing the blocks
        melonDirt = new MelonBlockNormal(melonDirtID,
                Material.ground, "melonDirt").setHardness(0.25F)
                .setStepSound(Block.soundGravelFootstep)
                .setUnlocalizedName("melonDirt").setCreativeTab(tab);
        melonStone = new MelonBlockNormal(melonStoneID,
                Material.ground, "melonStone").setHardness(0.75F)
                .setStepSound(Block.soundStoneFootstep)
                .setUnlocalizedName("melonStone").setCreativeTab(tab);
        melonGrass = new MelonBlockGrass(melonGrassID,
                Material.ground, "melonGrass").setHardness(0.5F)
                .setStepSound(Block.soundGrassFootstep)
                .setUnlocalizedName("melonGrass").setCreativeTab(tab);
        portal = new MelonBlockPortal(portalID).setHardness(-1F)
                .setStepSound(Block.soundGlassFootstep)
                .setUnlocalizedName("melonportal").setCreativeTab(tab);
        magistone = new MelonBlockNormal(magistoneID,
                Material.ground, "magistone").setHardness(0.75F)
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
        //Add crafting
        GameRegistry.addRecipe(new ItemStack(melonplanks, 4), "#", '#', melonlog);
    }
}
