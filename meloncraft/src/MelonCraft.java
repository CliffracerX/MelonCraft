package meloncraft.src;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
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
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="MelonMod", name="MelonCraft", version="0.1 (1.5.1)")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class MelonCraft {
        
        
        @Instance("MelonMod")
        public static MelonCraft instance;
        public static final BiomeGenBase biome = new MelonBiome(30);
        public static CreativeTabs MelonTab = new MelTab("MelonTab1");
        public final static Block melonDirt = new MelonBlockBasicOO(200, Material.ground, "melonDirt").setHardness(0.25F).setStepSound(Block.soundGravelFootstep).setCreativeTab(MelonCraft.MelonTab);
        public final static Block melonStone = new MelonBlockStone(201, Material.ground, "melonStone", 0.75F).setHardness(0.75F).setStepSound(Block.soundStoneFootstep).setCreativeTab(MelonCraft.MelonTab);
        public final static Block melonGrass = new MelonBlockGrass(202, Material.grass, "melonGrass").setHardness(0.5F).setStepSound(Block.soundGrassFootstep).setCreativeTab(MelonCraft.MelonTab);
        public final static Block melonCobble = new MelonBlockBasicOO(203, Material.ground, "melonCobble").setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setCreativeTab(MelonCraft.MelonTab);
        public final static Block magilava = new MelonWateryBlock(204, Material.ground, "magilava", true).setHardness(0.25F).setStepSound(Block.soundClothFootstep).setCreativeTab(MelonCraft.MelonTab).setLightValue(1.0F);
        public final static Block melonjuice = new MelonWateryBlock(205, Material.ground, "melonjuice", false).setHardness(0.25F).setStepSound(Block.soundClothFootstep).setCreativeTab(MelonCraft.MelonTab);
        public final static Block melonportal = new MelPortBlock(206, Material.ground, "portal").setHardness(0.25F).setStepSound(Block.soundGlassFootstep).setCreativeTab(MelonCraft.MelonTab).setLightValue(1.0F);
        public final static Block melonPlanks = new MelonBlockBasicOO(1600, Material.ground, "melonPlanks").setHardness(0.25F).setStepSound(Block.soundWoodFootstep).setCreativeTab(MelonCraft.MelonTab);
        public final static Block melonLog = new MelonBlockBasicOO(1601, Material.ground, "melonLog").setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setCreativeTab(MelonCraft.MelonTab);
        public final static Block melonLeaves = new MelonLeaves(1602, "melonLeaves").setHardness(0.125F).setStepSound(Block.soundGrassFootstep).setCreativeTab(MelonCraft.MelonTab);
        public final static Block melSap = new MelonSapling(1603, "melonSapling").setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setCreativeTab(MelonCraft.MelonTab);
        public final static Block magStone = new MelonBlockBasicOO(1604, Material.ground, "magistone").setHardness(0.5F).setStepSound(Block.soundGlassFootstep).setCreativeTab(MelonCraft.MelonTab).setLightValue(1.0F);
        public final static Block magTorch = new Magitorch(1605, "magitorch").setHardness(0.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(MelonCraft.MelonTab).setLightValue(1.0F);
        public final static Block melCraftTable = new MelonBench(1606, Material.ground, "melonTable").setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setCreativeTab(MelonCraft.MelonTab);
        public final static Item magDust = new MelonItem(2537, "magiDust", 64).setUnlocalizedName("magDust");
        public final static Item melStick = new MelonItem(2538, "melonStick", 64).setUnlocalizedName("melStick");
        public final static Item melWoodPick = new MelonPick(2539, "melonWoodPick", 63, 2.0F).setUnlocalizedName("melWoodPick");
        public final static Item melStonePick = new MelonPick(2540, "melonStonePick", 127, 4.0F).setUnlocalizedName("melStonePick");

        @SidedProxy(clientSide="meloncraft.src.ClientProxy",
                        serverSide="meloncraft.src.CommonProxy")
        public static CommonProxy proxy;
        
        @PreInit
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Method
        }
        
        @Init
        public void load(FMLInitializationEvent event) {
        	//Register certain things
            NetworkRegistry.instance().registerGuiHandler(this, new CommonProxy());
                //Dimension registers
        	DimensionManager.registerProviderType(16, MelonWorldProvider.class, true);
            DimensionManager.registerDimension(16, 16);
            //Misc. names
        	LanguageRegistry.instance().addStringLocalization("itemGroup.MelonTab1", "en_US", "Meloncraft loot");
        	//Block names, registerBlocks
                LanguageRegistry.addName(melonDirt, EnumChatFormatting.GREEN + "Melon Dirt");
                GameRegistry.registerBlock(melonDirt, "melonDirt");
                LanguageRegistry.addName(melonGrass, EnumChatFormatting.GREEN + "Melon Grass");
                GameRegistry.registerBlock(melonGrass, "melonGrass");
                LanguageRegistry.addName(melonStone, EnumChatFormatting.GREEN + "Melon Stone");
                GameRegistry.registerBlock(melonStone, "melonStone");
                LanguageRegistry.addName(melonCobble, EnumChatFormatting.GREEN + "Melon Cobblestone");
                GameRegistry.registerBlock(melonCobble, "melonCobble");
                LanguageRegistry.addName(melonjuice, EnumChatFormatting.GREEN + "MelonJuice (normal)");
                GameRegistry.registerBlock(melonjuice, "melonJuice");
                LanguageRegistry.addName(magilava, EnumChatFormatting.GREEN + "MagiLava (normal)");
                GameRegistry.registerBlock(magilava, "magilava");
                LanguageRegistry.addName(melonportal, EnumChatFormatting.GREEN + "Melonportal");
                GameRegistry.registerBlock(melonportal, "melonportal");
                LanguageRegistry.addName(magStone, EnumChatFormatting.GREEN + "MagiStone");
                GameRegistry.registerBlock(magStone, "magStone");
                LanguageRegistry.addName(melonPlanks, EnumChatFormatting.GREEN + "Melon Planks");
                GameRegistry.registerBlock(melonPlanks, "melonPlanks");
                LanguageRegistry.addName(melonLog, EnumChatFormatting.GREEN + "Melon Log");
                GameRegistry.registerBlock(melonLog, "melonLog");
                LanguageRegistry.addName(melonLeaves, EnumChatFormatting.GREEN + "Melon Leaves");
                GameRegistry.registerBlock(melonLeaves, "melonLeaves");
                LanguageRegistry.addName(melSap, EnumChatFormatting.GREEN + "Melon Sapling");
                GameRegistry.registerBlock(melSap, "melonSapling");
                LanguageRegistry.addName(magTorch, EnumChatFormatting.GREEN + "Magi Torch");
                GameRegistry.registerBlock(magTorch, "magTorch");
                LanguageRegistry.addName(melCraftTable, EnumChatFormatting.GREEN + "MelonTable");
                GameRegistry.registerBlock(melCraftTable, "melCraftTable");
                //Item names
                LanguageRegistry.addName(magDust, EnumChatFormatting.LIGHT_PURPLE + "MagiDust");
                LanguageRegistry.addName(melStick, EnumChatFormatting.GREEN + "MelonStick");
                LanguageRegistry.addName(melWoodPick, EnumChatFormatting.YELLOW + "MelonWood pickaxe");
                LanguageRegistry.addName(melStonePick, EnumChatFormatting.GOLD + "MelonStone pickaxe");
                //Crafting
                GameRegistry.addRecipe(new ItemStack(melonCobble, 4), "X", 'X', MelonCraft.melonStone);
                GameRegistry.addRecipe(new ItemStack(melonStone, 1), "XX", "XX", 'X', MelonCraft.melonCobble);
                GameRegistry.addRecipe(new ItemStack(magDust, 4), "X", 'X', MelonCraft.magStone);
                GameRegistry.addRecipe(new ItemStack(melStick, 4), "X", "X", 'X', MelonCraft.melonPlanks);
                GameRegistry.addRecipe(new ItemStack(magStone, 1), "XX", "XX", 'X', MelonCraft.magDust);
                GameRegistry.addRecipe(new ItemStack(melonPlanks, 4), "X", 'X', MelonCraft.melonLog);
                GameRegistry.addRecipe(new ItemStack(melonDirt, 6), "XX", "#X", 'X', MelonCraft.melonPlanks, '#', MelonCraft.melSap);
                GameRegistry.addRecipe(new ItemStack(melonStone, 3), "XX", "#X", 'X', MelonCraft.melonPlanks, '#', MelonCraft.melonStone);
                GameRegistry.addRecipe(new ItemStack(magStone, 3), "XX", "#X", 'X', MelonCraft.melonStone, '#', MelonCraft.magStone);
                GameRegistry.addRecipe(new ItemStack(melonjuice, 3), "X#", 'X', MelonCraft.magStone, '#', MelonCraft.melonjuice);
                GameRegistry.addRecipe(new ItemStack(magilava, 2), "X#", 'X', MelonCraft.magStone, '#', MelonCraft.magilava);
                GameRegistry.addRecipe(new ItemStack(magStone, 1), "#", '#', MelonCraft.magilava);
                GameRegistry.addRecipe(new ItemStack(magTorch, 4), "#", "X", 'X', MelonCraft.melStick, '#', MelonCraft.magDust);
                GameRegistry.addRecipe(new ItemStack(melCraftTable, 1), "XX", "XX", 'X', MelonCraft.melonPlanks);
        }
        
        @PostInit
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
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