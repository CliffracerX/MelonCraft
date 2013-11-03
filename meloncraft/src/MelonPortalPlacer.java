package meloncraft.src;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
public class MelonPortalPlacer extends Item
{
public MelonPortalPlacer(int par1)
{
super(par1);
setCreativeTab(MelonCraft.MelonTab);
this.maxStackSize=1;
}
public void func_94581_a(IconRegister iconRegister)
{
         iconIndex = iconRegister.func_94245_a("MelonCraft:melonStickMoonTip:");
}
public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int X, int Y, int Z, int par7, float par8, float par9, float par10)
{
if (!par3World.isRemote)
{
//int direction = MathHelper.floor_double(par2EntityPlayer.rotationYaw * 4.0F / 360.0F + 0.5D) & 0x3;
//if ((direction == 1) || (direction == 3))
{
for (int y = 1; y < 5; y++)
{
         for (int z = -1; z < 2; z++)
         {
         if (par3World.getBlockId(X, Y + y, Z + z) != 0)
         {
         par2EntityPlayer.addChatMessage("No room for a portal.");
                 return false;
         }
         }
}
//par3World.func_94575_c(X, Y + 1, Z, Block.fenceIron.blockID);
//par3World.func_94575_c(X + 1, Y + 1, Z, Block.fenceIron.blockID);
par3World.func_94575_c(X, Y + 1, Z, Block.melon.blockID);
par3World.func_94575_c(X + 1, Y + 1, Z, Block.melon.blockID);
par3World.func_94575_c(X + 2, Y + 1, Z, Block.melon.blockID);
par3World.func_94575_c(X - 1, Y + 1, Z, Block.melon.blockID);
//par3World.func_94575_c(X + 3, Y + 3, Z, Block.fenceIron.blockID);
//par3World.func_94575_c(X - 2, Y + 3, Z, Block.fenceIron.blockID);
par3World.func_94575_c(X + 2, Y + 2, Z, Block.melon.blockID);
par3World.func_94575_c(X - 1, Y + 2, Z, Block.melon.blockID);
//par3World.func_94575_c(X + 3, Y + 4, Z, Block.melon.blockID);
//par3World.func_94575_c(X - 2, Y + 4, Z, Block.melon.blockID);
par3World.func_94575_c(X + 2, Y + 3, Z, Block.melon.blockID);
par3World.func_94575_c(X - 1, Y + 3, Z, Block.melon.blockID);
//par3World.func_94575_c(X + 3, Y + 5, Z, Block.melon.blockID);
//par3World.func_94575_c(X - 2, Y + 5, Z, Block.melon.blockID);
par3World.func_94575_c(X + 2, Y + 4, Z, Block.melon.blockID);
par3World.func_94575_c(X - 1, Y + 4, Z, Block.melon.blockID);
par3World.func_94575_c(X + 2, Y + 5, Z, Block.melon.blockID);
par3World.func_94575_c(X - 1, Y + 5, Z, Block.melon.blockID);
//par3World.func_94575_c(X, Y + 7, Z, Block.fenceIron.blockID);
//par3World.func_94575_c(X + 1, Y + 7, Z, Block.fenceIron.blockID);
par3World.func_94575_c(X, Y + 5, Z, Block.melon.blockID);
par3World.func_94575_c(X + 1, Y + 5, Z, Block.melon.blockID);
par3World.func_94575_c(X, Y + 2, Z, MelonCraft.melonportal.blockID);
par3World.func_94575_c(X, Y + 3, Z, MelonCraft.melonportal.blockID);
par3World.func_94575_c(X, Y + 4, Z, MelonCraft.melonportal.blockID);
par3World.func_94575_c(X + 1, Y + 2, Z, MelonCraft.melonportal.blockID);
par3World.func_94575_c(X + 1, Y + 3, Z, MelonCraft.melonportal.blockID);
par3World.func_94575_c(X + 1, Y + 4, Z, MelonCraft.melonportal.blockID);
//if(par1ItemStack.stackSize==1)
//{
//}
//else
//par1ItemStack.stackSize--;
--par1ItemStack.stackSize;
}
return true;
}
return true;
}
}