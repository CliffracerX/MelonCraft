package cliffracerx.mods.meloncraft.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

public class MelCraftinMan
{
    /** The static instance of this class */
    private static final MelCraftinMan instance = new MelCraftinMan();

    /** A list of all the recipes added */
    private List recipes = new ArrayList();

    /**
     * Returns the static instance of this class
     */
    public static final MelCraftinMan getInstance()
    {
        return instance;
    }

    private MelCraftinMan()
    {
        //(new MelonArmorRecipes()).addRecipes(this);
        this.addRecipe(new ItemStack(MelonCraft.melonstick, 4), new Object[] {"#", "#", '#', MelonCraft.melonplanks});
        //this.addRecipe(new ItemStack(MelonCraft.melonFurnaceIdle, 1), new Object[] {"###", "# #", "###", '#', MelonCraft.meloncobble});
        //this.addRecipe(new ItemStack(MelonCraft.magTorch, 4), new Object[] {"#", "X", '#', MelonCraft.melonstick, 'X', MelonCraft.magidust});
        this.addRecipe(new ItemStack(MelonCraft.melonplanks, 4), new Object[] {"#", '#', MelonCraft.melonlog});
        this.addRecipe(new ItemStack(MelonCraft.melonDirt, 6), new Object[] {"X#", "##", '#', MelonCraft.melonplanks, 'X', MelonCraft.melonsapling});
        this.addRecipe(new ItemStack(MelonCraft.melonStone, 3), new Object[] {"X#", "##", '#', MelonCraft.melonplanks, 'X', MelonCraft.melonStone});
        this.addRecipe(new ItemStack(MelonCraft.magistone, 3), new Object[] {"X#", "##", '#', MelonCraft.melonStone, 'X', MelonCraft.magistone});
        this.addRecipe(new ItemStack(MelonCraft.melonjuice, 3), new Object[] {"X#", '#', MelonCraft.magistone, 'X', MelonCraft.melonjuice});
        this.addRecipe(new ItemStack(MelonCraft.magilava, 2), new Object[] {"X#", '#', MelonCraft.magistone, 'X', MelonCraft.magilava});
        this.addRecipe(new ItemStack(MelonCraft.magistone, 1), new Object[] {"#", '#', MelonCraft.magilava});
        //this.addRecipe(new ItemStack(MelonCraft.magistone, 1), new Object[] {"##", "##", '#', MelonCraft.magidust});
        //this.addRecipe(new ItemStack(MelonCraft.magidust, 4), new Object[] {"#", '#', MelonCraft.magistone});
        this.addRecipe(new ItemStack(MelonCraft.melonStone, 1), new Object[] {"##", "##", '#', MelonCraft.meloncobble});
        this.addRecipe(new ItemStack(MelonCraft.meloncobble, 4), new Object[] {"#", '#', MelonCraft.melonStone});
        this.addRecipe(new ItemStack(MelonCraft.melonBench, 1), new Object[] {"##", "##", '#', MelonCraft.melonplanks});
        this.addRecipe(new ItemStack(MelonCraft.melonwoodpick, 1), new Object[] {"XXX", " # ", " # ", '#', MelonCraft.melonstick, 'X', MelonCraft.melonplanks});
        this.addRecipe(new ItemStack(MelonCraft.melonstonepick, 1), new Object[] {"XXX", " # ", " # ", '#', MelonCraft.melonstick, 'X', MelonCraft.meloncobble});
        this.addRecipe(new ItemStack(MelonCraft.moonstonepick, 1), new Object[] {"XXX", " # ", " # ", '#', MelonCraft.melonstick, 'X', MelonCraft.moonstoneIngot});
        /*this.addRecipe(new ItemStack(MelonCraft.melonwoodsword, 1), new Object[] {"X", "X", "#", '#', MelonCraft.melonstick, 'X', MelonCraft.melonplanks});
        this.addRecipe(new ItemStack(MelonCraft.melonstonesword, 1), new Object[] {"X", "X", "#", '#', MelonCraft.melonstick, 'X', MelonCraft.meloncobble});
        this.addRecipe(new ItemStack(MelonCraft.moonstonesword, 1), new Object[] {"X", "X", "#", '#', MelonCraft.melonstick, 'X', MelonCraft.moonstoneIngot});
        this.addRecipe(new ItemStack(MelonCraft.wwmws, 1), new Object[] {"X#X", "###", "# #", '#', MelonCraft.normalMW, 'X', MelonCraft.magidust});
        this.addRecipe(new ItemStack(MelonCraft.wrmws, 1), new Object[] {"X#X", "###", "# #", '#', MelonCraft.normalMW, 'X', MelonCraft.redMD});
        this.addRecipe(new ItemStack(MelonCraft.wgmws, 1), new Object[] {"X#X", "###", "# #", '#', MelonCraft.normalMW, 'X', MelonCraft.greenMD});
        this.addRecipe(new ItemStack(MelonCraft.wbmws, 1), new Object[] {"X#X", "###", "# #", '#', MelonCraft.normalMW, 'X', MelonCraft.blueMD});
        this.addRecipe(new ItemStack(MelonCraft.rwmws, 1), new Object[] {"X#X", "###", "# #", '#', MelonCraft.redMW, 'X', MelonCraft.magidust});
        this.addRecipe(new ItemStack(MelonCraft.rrmws, 1), new Object[] {"X#X", "###", "# #", '#', MelonCraft.redMW, 'X', MelonCraft.redMD});
        this.addRecipe(new ItemStack(MelonCraft.rgmws, 1), new Object[] {"X#X", "###", "# #", '#', MelonCraft.redMW, 'X', MelonCraft.greenMD});
        this.addRecipe(new ItemStack(MelonCraft.rbmws, 1), new Object[] {"X#X", "###", "# #", '#', MelonCraft.redMW, 'X', MelonCraft.blueMD});
        this.addRecipe(new ItemStack(MelonCraft.gwmws, 1), new Object[] {"X#X", "###", "# #", '#', MelonCraft.greenMW, 'X', MelonCraft.magidust});
        this.addRecipe(new ItemStack(MelonCraft.grmws, 1), new Object[] {"X#X", "###", "# #", '#', MelonCraft.greenMW, 'X', MelonCraft.redMD});
        this.addRecipe(new ItemStack(MelonCraft.ggmws, 1), new Object[] {"X#X", "###", "# #", '#', MelonCraft.greenMW, 'X', MelonCraft.greenMD});
        this.addRecipe(new ItemStack(MelonCraft.gbmws, 1), new Object[] {"X#X", "###", "# #", '#', MelonCraft.greenMW, 'X', MelonCraft.blueMD});
        this.addRecipe(new ItemStack(MelonCraft.bwmws, 1), new Object[] {"X#X", "###", "# #", '#', MelonCraft.blueMW, 'X', MelonCraft.magidust});
        this.addRecipe(new ItemStack(MelonCraft.brmws, 1), new Object[] {"X#X", "###", "# #", '#', MelonCraft.blueMW, 'X', MelonCraft.redMD});
        this.addRecipe(new ItemStack(MelonCraft.bgmws, 1), new Object[] {"X#X", "###", "# #", '#', MelonCraft.blueMW, 'X', MelonCraft.greenMD});
        this.addRecipe(new ItemStack(MelonCraft.bbmws, 1), new Object[] {"X#X", "###", "# #", '#', MelonCraft.blueMW, 'X', MelonCraft.blueMD});
        this.addRecipe(new ItemStack(MelonCraft.melonStone, 1), new Object[] {"###", "###", "###", '#', MelonCraft.melStnShrd});
        this.addRecipe(new ItemStack(MelonCraft.PLZH, 1), new Object[] {"X#", '#', MelonCraft.MSTH, 'X', MelonCraft.plasmaGem});
        this.addRecipe(new ItemStack(MelonCraft.PLZC, 1), new Object[] {"X#X", '#', MelonCraft.MSTC, 'X', MelonCraft.plasmaGem});
        this.addRecipe(new ItemStack(MelonCraft.PLZL, 1), new Object[] {"X#X", '#', MelonCraft.MSTL, 'X', MelonCraft.plasmaGem});
        this.addRecipe(new ItemStack(MelonCraft.PLZB, 1), new Object[] {"X#", '#', MelonCraft.MSTB, 'X', MelonCraft.plasmaGem});
        this.addRecipe(new ItemStack(MelonCraft.plasmapick, 1), new Object[] {"XXX", " # ", " # ", '#', MelonCraft.melonstick, 'X', MelonCraft.plasmaGem});
        this.addRecipe(new ItemStack(MelonCraft.plasmasword, 1), new Object[] {"X", "X", "#", '#', MelonCraft.melonstick, 'X', MelonCraft.plasmaGem});
        this.addRecipe(new ItemStack(MelonCraft.melonSeedBlock, 1), new Object[] {"###", "###", "###", '#', Item.melonSeeds});*/
        this.addRecipe(new ItemStack(MelonCraft.moonstoneBlock, 1), new Object[] {"###", "###", "###", '#', MelonCraft.moonstoneIngot});
        this.addRecipe(new ItemStack(MelonCraft.normalMW, 8), new Object[] {"###", "###", "###", '#', MelonCraft.melonleaves});
        this.addRecipe(new ItemStack(MelonCraft.moonstoneIngot, 9), new Object[] {"#", '#', MelonCraft.moonstoneBlock});
        this.addRecipe(new ItemStack(MelonCraft.moonstonecap, 1), new Object[] {"###", "# #", "   ", '#', MelonCraft.moonstoneIngot});
        this.addRecipe(new ItemStack(MelonCraft.melonwoodwandcore, 1), new Object[] {" $ ", "$#$", " $ ", '#', MelonCraft.melonplanks, '$', MelonCraft.melonstick});
        this.addRecipe(new ItemStack(MelonCraft.fireFocus, 1), new Object[] {" $ ", "$#$", " $ ", '#', MelonCraft.magilava, '$', MelonCraft.moonstoneIngot});
        this.addRecipe(new ItemStack(MelonCraft.iceFocus, 1), new Object[] {" $ ", "$#$", " $ ", '#', MelonCraft.moonstoneBlock, '$', MelonCraft.moonstoneIngot});
        this.addRecipe(new ItemStack(MelonCraft.moonstoneCappedWoodenWand, 1, 101), new Object[] {"$  ", " # ", "  $", '#', MelonCraft.melonwoodwandcore, '$', MelonCraft.moonstonecap});
        this.addRecipe(new ItemStack(MelonCraft.redmagicappedChargedWand, 1, 451), new Object[] {"$@ ", "@#@", " @$", '#', MelonCraft.moonstoneBlock, '$', MelonCraft.redMGST, '@', MelonCraft.magistone});
        this.addRecipe(new ItemStack(MelonCraft.orangemagicappedChargedWand, 1, 451), new Object[] {"$@ ", "@#@", " @$", '#', MelonCraft.moonstoneBlock, '$', MelonCraft.orangeMGST, '@', MelonCraft.magistone});
        this.addRecipe(new ItemStack(MelonCraft.yellowmagicappedChargedWand, 1, 451), new Object[] {"$@ ", "@#@", " @$", '#', MelonCraft.moonstoneBlock, '$', MelonCraft.yellowMGST, '@', MelonCraft.magistone});
        this.addRecipe(new ItemStack(MelonCraft.limemagicappedChargedWand, 1, 451), new Object[] {"$@ ", "@#@", " @$", '#', MelonCraft.moonstoneBlock, '$', MelonCraft.limeMGST, '@', MelonCraft.magistone});
        this.addRecipe(new ItemStack(MelonCraft.greenmagicappedChargedWand, 1, 451), new Object[] {"$@ ", "@#@", " @$", '#', MelonCraft.moonstoneBlock, '$', MelonCraft.greenMGST, '@', MelonCraft.magistone});
        this.addRecipe(new ItemStack(MelonCraft.cyanmagicappedChargedWand, 1, 451), new Object[] {"$@ ", "@#@", " @$", '#', MelonCraft.moonstoneBlock, '$', MelonCraft.cyanMGST, '@', MelonCraft.magistone});
        this.addRecipe(new ItemStack(MelonCraft.bluemagicappedChargedWand, 1, 451), new Object[] {"$@ ", "@#@", " @$", '#', MelonCraft.moonstoneBlock, '$', MelonCraft.blueMGST, '@', MelonCraft.magistone});
        this.addRecipe(new ItemStack(MelonCraft.purplemagicappedChargedWand, 1, 451), new Object[] {"$@ ", "@#@", " @$", '#', MelonCraft.moonstoneBlock, '$', MelonCraft.purpleMGST, '@', MelonCraft.magistone});
        this.addRecipe(new ItemStack(Block.melon, 1), new Object[] {"###", "###", "###", '#', Item.melon});
        /*this.addRecipe(new ItemStack(MelonCraft.wwminimws, 1), new Object[] {"X##", '#', MelonCraft.normalMW, 'X', MelonCraft.magidust});
        this.addRecipe(new ItemStack(MelonCraft.wrminimws, 1), new Object[] {"X##", '#', MelonCraft.normalMW, 'X', MelonCraft.redMD});
        this.addRecipe(new ItemStack(MelonCraft.wgminimws, 1), new Object[] {"X##", '#', MelonCraft.normalMW, 'X', MelonCraft.greenMD});
        this.addRecipe(new ItemStack(MelonCraft.wbminimws, 1), new Object[] {"X##", '#', MelonCraft.normalMW, 'X', MelonCraft.blueMD});
        this.addRecipe(new ItemStack(MelonCraft.rwminimws, 1), new Object[] {"X##", '#', MelonCraft.redMW, 'X', MelonCraft.magidust});
        this.addRecipe(new ItemStack(MelonCraft.rrminimws, 1), new Object[] {"X##", '#', MelonCraft.redMW, 'X', MelonCraft.redMD});
        this.addRecipe(new ItemStack(MelonCraft.rgminimws, 1), new Object[] {"X##", '#', MelonCraft.redMW, 'X', MelonCraft.greenMD});
        this.addRecipe(new ItemStack(MelonCraft.rbminimws, 1), new Object[] {"X##", '#', MelonCraft.redMW, 'X', MelonCraft.blueMD});
        this.addRecipe(new ItemStack(MelonCraft.gwminimws, 1), new Object[] {"X##", '#', MelonCraft.greenMW, 'X', MelonCraft.magidust});
        this.addRecipe(new ItemStack(MelonCraft.grminimws, 1), new Object[] {"X##", '#', MelonCraft.greenMW, 'X', MelonCraft.redMD});
        this.addRecipe(new ItemStack(MelonCraft.ggminimws, 1), new Object[] {"X##", '#', MelonCraft.greenMW, 'X', MelonCraft.greenMD});
        this.addRecipe(new ItemStack(MelonCraft.gbminimws, 1), new Object[] {"X##", '#', MelonCraft.greenMW, 'X', MelonCraft.blueMD});
        this.addRecipe(new ItemStack(MelonCraft.bwminimws, 1), new Object[] {"X##", '#', MelonCraft.blueMW, 'X', MelonCraft.magidust});
        this.addRecipe(new ItemStack(MelonCraft.brminimws, 1), new Object[] {"X##", '#', MelonCraft.blueMW, 'X', MelonCraft.redMD});
        this.addRecipe(new ItemStack(MelonCraft.bgminimws, 1), new Object[] {"X##", '#', MelonCraft.blueMW, 'X', MelonCraft.greenMD});
        this.addRecipe(new ItemStack(MelonCraft.bbminimws, 1), new Object[] {"X##", '#', MelonCraft.blueMW, 'X', MelonCraft.blueMD});*/
        this.addRecipe(new ItemStack(MelonCraft.melonwoodshovel, 1), new Object[] {"X", "#", "#", '#', MelonCraft.melonstick, 'X', MelonCraft.melonplanks});
        this.addRecipe(new ItemStack(MelonCraft.melonstoneshovel, 1), new Object[] {"X", "#", "#", '#', MelonCraft.melonstick, 'X', MelonCraft.meloncobble});
        this.addRecipe(new ItemStack(MelonCraft.moonstoneshovel, 1), new Object[] {"X", "#", "#", '#', MelonCraft.melonstick, 'X', MelonCraft.moonstoneIngot});
        //this.addRecipe(new ItemStack(MelonCraft.plasmashovel, 1), new Object[] {"X", "#", "#", '#', MelonCraft.melonstick, 'X', MelonCraft.plasmaGem});
        this.addRecipe(new ItemStack(MelonCraft.melonwoodaxe, 1), new Object[] {"XX", "X#", " #", '#', MelonCraft.melonstick, 'X', MelonCraft.melonplanks});
        this.addRecipe(new ItemStack(MelonCraft.melonstoneaxe, 1), new Object[] {"XX", "X#", " #", '#', MelonCraft.melonstick, 'X', MelonCraft.meloncobble});
        this.addRecipe(new ItemStack(MelonCraft.moonstoneaxe, 1), new Object[] {"XX", "X#", " #", '#', MelonCraft.melonstick, 'X', MelonCraft.moonstoneIngot});
        /*this.addRecipe(new ItemStack(MelonCraft.plasmaAxe, 1), new Object[] {"XX", "X#", " #", '#', MelonCraft.melonstick, 'X', MelonCraft.plasmaGem});
        this.addRecipe(new ItemStack(MelonCraft.bendyIngot, 1), new Object[] {"###", "###", '#', MelonCraft.bendybarBlob});
        this.addRecipe(new ItemStack(MelonCraft.bendyblock, 1), new Object[] {"###", "###", "###", '#', MelonCraft.bendyIngot});
        this.addRecipe(new ItemStack(MelonCraft.bendyIngot, 9), new Object[] {"#", '#', MelonCraft.bendyblock});
        this.addRecipe(new ItemStack(MelonCraft.rDyepot, 1), new Object[] {"X#X", "X#X", " # ", '#', MelonCraft.rDye, 'X', MelonCraft.melonplanks});
        this.addRecipe(new ItemStack(MelonCraft.gDyepot, 1), new Object[] {"X#X", "X#X", " # ", '#', MelonCraft.gDye, 'X', MelonCraft.melonplanks});
        this.addRecipe(new ItemStack(MelonCraft.bDyepot, 1), new Object[] {"X#X", "X#X", " # ", '#', MelonCraft.bDye, 'X', MelonCraft.melonplanks});*/
        Collections.sort(this.recipes, new MelRecSort(this));
        System.out.println(this.recipes.size() + " recipes");
    }

    public ShapedRecipes addRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (par2ArrayOfObj[i] instanceof String[])
        {
            String[] astring = (String[])((String[])par2ArrayOfObj[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        else
        {
            while (par2ArrayOfObj[i] instanceof String)
            {
                String s2 = (String)par2ArrayOfObj[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < par2ArrayOfObj.length; i += 2)
        {
            Character character = (Character)par2ArrayOfObj[i];
            ItemStack itemstack1 = null;

            if (par2ArrayOfObj[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item)par2ArrayOfObj[i + 1]);
            }
            else if (par2ArrayOfObj[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block)par2ArrayOfObj[i + 1], 1, 32767);
            }
            else if (par2ArrayOfObj[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack)par2ArrayOfObj[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
            }
            else
            {
                aitemstack[i1] = null;
            }
        }

        ShapedRecipes shapedrecipes = new ShapedRecipes(j, k, aitemstack, par1ItemStack);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }

    public void addShapelessRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        ArrayList arraylist = new ArrayList();
        Object[] aobject = par2ArrayOfObj;
        int i = par2ArrayOfObj.length;

        for (int j = 0; j < i; ++j)
        {
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack)
            {
                arraylist.add(((ItemStack)object1).copy());
            }
            else if (object1 instanceof Item)
            {
                arraylist.add(new ItemStack((Item)object1));
            }
            else
            {
                if (!(object1 instanceof Block))
                {
                    throw new RuntimeException("Invalid shapeless recipy!");
                }

                arraylist.add(new ItemStack((Block)object1));
            }
        }

        this.recipes.add(new ShapelessRecipes(par1ItemStack, arraylist));
    }

    public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World)
    {
        int i = 0;
        ItemStack itemstack = null;
        ItemStack itemstack1 = null;
        int j;

        for (j = 0; j < par1InventoryCrafting.getSizeInventory(); ++j)
        {
            ItemStack itemstack2 = par1InventoryCrafting.getStackInSlot(j);

            if (itemstack2 != null)
            {
                if (i == 0)
                {
                    itemstack = itemstack2;
                }

                if (i == 1)
                {
                    itemstack1 = itemstack2;
                }

                ++i;
            }
        }

        if (i == 2 && itemstack.itemID == itemstack1.itemID && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && Item.itemsList[itemstack.itemID].isRepairable())
        {
            Item item = Item.itemsList[itemstack.itemID];
            int k = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
            int l = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
            int i1 = k + l + item.getMaxDamage() * 5 / 100;
            int j1 = item.getMaxDamage() - i1;

            if (j1 < 0)
            {
                j1 = 0;
            }

            return new ItemStack(itemstack.itemID, 1, j1);
        }
        else
        {
            for (j = 0; j < this.recipes.size(); ++j)
            {
                IRecipe irecipe = (IRecipe)this.recipes.get(j);

                if (irecipe.matches(par1InventoryCrafting, par2World))
                {
                    return irecipe.getCraftingResult(par1InventoryCrafting);
                }
            }

            return null;
        }
    }

    /**
     * returns the List<> of all recipes
     */
    public List getRecipeList()
    {
        return this.recipes;
    }
}