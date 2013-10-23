package meloncraft.src;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MelonArmorRecipes
{
    private String[][] recipePatterns = new String[][] {{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
    private Object[][] recipeMelonCrafts;

    public MelonArmorRecipes()
    {
        this.recipeMelonCrafts = new Object[][] {{MelonCraft.normalMW, MelonCraft.redMW, MelonCraft.greenMW, MelonCraft.blueMW, MelonCraft.moonstoneIngot/*, MelonCraft.IZC*/}, {MelonCraft.NMWH, MelonCraft.RMWH, MelonCraft.GMWH, MelonCraft.BMWH, MelonCraft.MSTH/*, MelonCraft.MSTH*/}, {MelonCraft.NMWC, MelonCraft.RMWC, MelonCraft.GMWC, MelonCraft.BMWC, MelonCraft.MSTC/*, MelonCraft.MSTC*/}, {MelonCraft.NMWL, MelonCraft.RMWL, MelonCraft.GMWL, MelonCraft.BMWL, MelonCraft.MSTL/*, MelonCraft.MSTL*/}, {MelonCraft.NMWB, MelonCraft.RMWB, MelonCraft.GMWB, MelonCraft.BMWB, MelonCraft.MSTB/*, MelonCraft.MSTB*/}};
    }

    /**
     * Adds the armor recipes to the CraftingManager.
     */
    public void addRecipes(MelCraftinMan par1CraftingManager)
    {
        for (int var2 = 0; var2 < this.recipeMelonCrafts[0].length; ++var2)
        {
            Object var3 = this.recipeMelonCrafts[0][var2];

            for (int var4 = 0; var4 < this.recipeMelonCrafts.length - 1; ++var4)
            {
                Item var5 = (Item)this.recipeMelonCrafts[var4 + 1][var2];
                par1CraftingManager.addRecipe(new ItemStack(var5), new Object[] {this.recipePatterns[var4], 'X', var3});
            }
        }
    }
}
