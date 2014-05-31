package cliffracerx.mods.meloncraft.src;

import com.google.common.collect.Multimap;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MelonWand extends Item
{
    private String texture;
    int manastorage;
    String coretype;
    String captype;
    String focustype;
    int rechargeSpeed;
    double damageToDo;

    public MelonWand(int id, String tex, int storage, String coretype, String captype, String focustype, int rSpeed, double damageToDo)
    {
        super(id);
        this.setUnlocalizedName(tex);
        this.setTextureName("MelonCraft:"+tex);
        this.texture=tex;
        this.damageToDo=damageToDo;
        this.manastorage=storage;
        this.coretype=coretype;
        this.captype=captype;
        this.focustype=focustype;
        this.setMaxDamage(this.manastorage+2);
        this.setMaxStackSize(1);
        this.rechargeSpeed=rSpeed;
    }

    @Override
    public CreativeTabs getCreativeTab()
    {
        return MelonCraft.tab;
    }
    
    @SideOnly(Side.CLIENT)

    /**
     * Returns True is the item is renderer in full 3D when held.
     */
    public boolean isFull3D()
    {
        return true;
    }
    
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        //super.onItemUse(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10);
        par2EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        int i1 = par3World.getBlockId(par4, par5, par6);
        if((i1==MelonCraft.magistoneID || i1==MelonCraft.redMGSTID || i1==MelonCraft.orangeMGSTID || i1==MelonCraft.yellowMGSTID || i1==MelonCraft.limeMGSTID || i1==MelonCraft.greenMGSTID || i1==MelonCraft.cyanMGSTID || i1==MelonCraft.blueMGSTID || i1==MelonCraft.purpleMGSTID) && par1ItemStack.getItemDamage()>1)
        {
            par1ItemStack.setItemDamage(par1ItemStack.getItemDamage()-rechargeSpeed);
            par3World.playSoundAtEntity(par2EntityPlayer, "meloncraft:items.wandcharge", 0.5F, 1f);
            if(par1ItemStack.getItemDamage()<1)
                par1ItemStack.setItemDamage(1);
            return false;
        }
        else
        {
            if(par1ItemStack.getItemDamage()<this.manastorage+1 && focustype=="ice" && i1==MelonCraft.melonleavesID)
            {
                par3World.setBlockToAir(par4, par5, par6);
                par2EntityPlayer.inventory.addItemStackToInventory(new ItemStack(MelonCraft.melonleaves));
            }
            if(par1ItemStack.getItemDamage()<this.manastorage+1 && focustype=="fire")
            {
                if (par7 == 0)
                {
                    --par5;
                }

                if (par7 == 1)
                {
                    ++par5;
                }

                if (par7 == 2)
                {
                    --par6;
                }

                if (par7 == 3)
                {
                    ++par6;
                }

                if (par7 == 4)
                {
                    --par4;
                }

                if (par7 == 5)
                {
                    ++par4;
                }

                if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
                {
                    return false;
                }
                else
                {
                    if (par3World.isAirBlock(par4, par5, par6))
                    {
                        par3World.playSoundAtEntity(par2EntityPlayer, "meloncraft:items.firefocus", 0.5F, 1f);
                        par3World.setBlock(par4, par5, par6, Block.fire.blockID);
                        par1ItemStack.damageItem(1, par2EntityPlayer);
                    }
                    return true;
                }
            }
            return false;
        }
    }
    
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        if(this.focustype=="fire" && par1ItemStack.getItemDamage()<this.manastorage+1)
        {
        par1ItemStack.damageItem(1, par3EntityLivingBase);
        par2EntityLivingBase.setFire(5);
        par2EntityLivingBase.attackEntityFrom(DamageSource.onFire, 2);
        }
        else if(this.focustype=="ice" && par1ItemStack.getItemDamage()<this.manastorage+1)
        {
        par1ItemStack.damageItem(1, par3EntityLivingBase);
        par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.confusion.id, 5000, 1, true));
        par2EntityLivingBase.attackEntityFrom(MelonCraft.freezeSource, 2);
        }
        return true;
    }
    
    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        return par1ItemStack;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }
    
    public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.damageToDo, 0));
        return multimap;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.bow;
    }
    
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {               
    //super.onItemRightClick(itemstack, world, entityplayer);
    entityplayer.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
    //if (!world.isRemote)
    {
        if(entityplayer.isSneaking() && focustype=="fire")
        {
            itemstack.itemID-=1;
            entityplayer.inventory.addItemStackToInventory(new ItemStack(MelonCraft.fireFocus));
        }
        else if(entityplayer.isSneaking() && focustype=="ice")
        {
            itemstack.itemID-=2;
            entityplayer.inventory.addItemStackToInventory(new ItemStack(MelonCraft.iceFocus));
        }
        else if(entityplayer.isSneaking() && focustype=="blank")
        {
            for(int i = 0; i<8; i++)
            {
            ItemStack item = entityplayer.inventory.getStackInSlot(i);
                if(item!=null)
                {
                    if(item.getItem()==MelonCraft.fireFocus)
                    {
                        entityplayer.inventory.consumeInventoryItem(MelonCraft.fireFocus.itemID);
                        itemstack.itemID+=1;
                        return itemstack;
                    }
                    else if(item.getItem()==MelonCraft.iceFocus)
                    {
                        entityplayer.inventory.consumeInventoryItem(MelonCraft.iceFocus.itemID);
                        itemstack.itemID+=2;
                        return itemstack;
                    }
                }
            }
        }
        if(itemstack.getItemDamage()<this.manastorage+1 && focustype=="fire" && entityplayer.isSneaking()==false && !world.isRemote)
        {
            Vec3 look = entityplayer.getLookVec();
           EntityFireball fireball = new EntitySmallFireball(world, entityplayer, 1, 1, 1);
           fireball.setPosition(
                                           entityplayer.posX + look.xCoord * 1.6,
                                           entityplayer.posY + 1,
                                           entityplayer.posZ + look.zCoord * 1.6);
           fireball.accelerationX = look.xCoord * 0.1;
           fireball.accelerationY = look.yCoord * 0.1;
           fireball.accelerationZ = look.zCoord * 0.1;
           world.spawnEntityInWorld(fireball);
           world.playSoundAtEntity(entityplayer, "meloncraft:items.firefocus", 0.5F, 1f);
           itemstack.damageItem(1, entityplayer);
        }
        else if(itemstack.getItemDamage()<this.manastorage+1 && focustype=="ice" && entityplayer.isSneaking()==false && !world.isRemote)
        {
            if (!world.isRemote)
            {
                EntitySnowball snowball = new EntitySnowball(world, entityplayer);
                world.spawnEntityInWorld(snowball);
            }
            world.playSoundAtEntity(entityplayer, "meloncraft:items.icefocus", 0.5F, 1f);
            itemstack.damageItem(1, entityplayer);
        }
    }
    return itemstack;
    }
}