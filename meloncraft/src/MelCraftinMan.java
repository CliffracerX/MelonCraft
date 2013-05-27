package meloncraft.src;

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
        this.addRecipe(new ItemStack(MelonCraft.melStick, 4), new Object[] {"#", "#", '#', MelonCraft.melonPlanks});
        this.addRecipe(new ItemStack(MelonCraft.magTorch, 4), new Object[] {"#", "X", '#', MelonCraft.melStick, 'X', MelonCraft.magDust});
        this.addRecipe(new ItemStack(MelonCraft.melonPlanks, 4), new Object[] {"#", '#', MelonCraft.melonLog});
        this.addRecipe(new ItemStack(MelonCraft.melonDirt, 6), new Object[] {"X#", "##", '#', MelonCraft.melonPlanks, 'X', MelonCraft.melSap});
        this.addRecipe(new ItemStack(MelonCraft.melonStone, 3), new Object[] {"X#", "##", '#', MelonCraft.melonPlanks, 'X', MelonCraft.melonStone});
        this.addRecipe(new ItemStack(MelonCraft.magStone, 3), new Object[] {"X#", "##", '#', MelonCraft.melonStone, 'X', MelonCraft.magStone});
        this.addRecipe(new ItemStack(MelonCraft.melonjuice, 3), new Object[] {"X#", '#', MelonCraft.magStone, 'X', MelonCraft.melonjuice});
        this.addRecipe(new ItemStack(MelonCraft.magilava, 2), new Object[] {"X#", '#', MelonCraft.magStone, 'X', MelonCraft.magilava});
        this.addRecipe(new ItemStack(MelonCraft.magStone, 1), new Object[] {"#", '#', MelonCraft.magilava});
        this.addRecipe(new ItemStack(MelonCraft.magStone, 1), new Object[] {"##", "##", '#', MelonCraft.magDust});
        this.addRecipe(new ItemStack(MelonCraft.magDust, 4), new Object[] {"#", '#', MelonCraft.magStone});
        this.addRecipe(new ItemStack(MelonCraft.melonStone, 1), new Object[] {"##", "##", '#', MelonCraft.melonCobble});
        this.addRecipe(new ItemStack(MelonCraft.melonCobble, 4), new Object[] {"#", '#', MelonCraft.melonStone});
        this.addRecipe(new ItemStack(MelonCraft.melCraftTable, 1), new Object[] {"##", "##", '#', MelonCraft.melonPlanks});
        this.addRecipe(new ItemStack(MelonCraft.melWoodPick, 1), new Object[] {"XXX", " # ", " # ", '#', MelonCraft.melStick, 'X', MelonCraft.melonPlanks});
        this.addRecipe(new ItemStack(MelonCraft.melStonePick, 1), new Object[] {"XXX", " # ", " # ", '#', MelonCraft.melStick, 'X', MelonCraft.melonCobble});
        Collections.sort(this.recipes, new RecipeSorter(this));
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
