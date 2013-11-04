package meloncraft.src;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet18Animation;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovementInput;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class EntityMelonwoolSoldier extends EntityCreature
{
		private String color="";
		private MovementInput movementInput;
		private int stickStuff=0;
		private int armortypeHead=0;
		private int armortypeChest=0;
		private int armortypeLegs=0;
		private int armortypeBoots=0;
		private int colorInt=0;
		private boolean neutral;
		private boolean hostileToPlayers;
		private String[] colors = {"rr", "rg", "rb", "gr", "gg", "gb", "br", "bg", "bb", "rw", "gw", "bw", "wr", "wg", "wb", "ww"};
        public EntityMelonwoolSoldier(World world)
        {
                super(world);
                System.out.println("YAY, MELONWOOLSOLDIER");
        }
        
        public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
        {
            super.readEntityFromNBT(par1NBTTagCompound);
            this.stickStuff=par1NBTTagCompound.getInteger("Item");
            this.setColor(par1NBTTagCompound.getInteger("Color"));
            this.neutral=par1NBTTagCompound.getBoolean("Neutral");
            this.hostileToPlayers=par1NBTTagCompound.getBoolean("HostileToPlayers");
            this.armortypeHead=par1NBTTagCompound.getInteger("ArmorHead");
            this.armortypeChest=par1NBTTagCompound.getInteger("ArmorChest");
            this.armortypeLegs=par1NBTTagCompound.getInteger("ArmorLegs");
            this.armortypeBoots=par1NBTTagCompound.getInteger("ArmorBoots");
        }

        /**
         * (abstract) Protected helper method to write subclass entity data to NBT.
         */
        public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
        {
            super.writeEntityToNBT(par1NBTTagCompound);
            par1NBTTagCompound.setInteger("Item", this.dataWatcher.getWatchableObjectInt(15));
            par1NBTTagCompound.setInteger("ArmorHead", this.dataWatcher.getWatchableObjectInt(23));
            par1NBTTagCompound.setInteger("ArmorChest", this.dataWatcher.getWatchableObjectInt(22));
            par1NBTTagCompound.setInteger("ArmorLegs", this.dataWatcher.getWatchableObjectInt(21));
            par1NBTTagCompound.setInteger("ArmorBoots", this.dataWatcher.getWatchableObjectInt(20));
            par1NBTTagCompound.setBoolean("Neutral", this.neutral);
            par1NBTTagCompound.setBoolean("HostileToPlayers", this.hostileToPlayers);
            par1NBTTagCompound.setInteger("Color", this.getColor());
        }


        protected int getDropItemId()
        {
        		return 0;
        }
        
        protected void dropFewItems(boolean par1, int par2)
        {
        	if(this.getColor()==0)
                this.dropItem(MelonCraft.rrmws.itemID, 1);
                else if(this.getColor()==1)
                this.dropItem(MelonCraft.rgmws.itemID, 1);
                else if(this.getColor()==2)
                this.dropItem(MelonCraft.rbmws.itemID, 1);
                else if(this.getColor()==3)
                this.dropItem(MelonCraft.grmws.itemID, 1);
                else if(this.getColor()==4)
                this.dropItem(MelonCraft.ggmws.itemID, 1);
                else if(this.getColor()==5)
                this.dropItem(MelonCraft.gbmws.itemID, 1);
                else if(this.getColor()==6)
                this.dropItem(MelonCraft.brmws.itemID, 1);
                else if(this.getColor()==7)
                this.dropItem(MelonCraft.bgmws.itemID, 1);
                else if(this.getColor()==8)
                this.dropItem(MelonCraft.bbmws.itemID, 1);
                else if(this.getColor()==9)
                this.dropItem(MelonCraft.rwmws.itemID, 1);
                else if(this.getColor()==10)
                this.dropItem(MelonCraft.gwmws.itemID, 1);
                else if(this.getColor()==11)
                this.dropItem(MelonCraft.bwmws.itemID, 1);
                else if(this.getColor()==12)
                this.dropItem(MelonCraft.wrmws.itemID, 1);
                else if(this.getColor()==13)
                this.dropItem(MelonCraft.wgmws.itemID, 1);
                else if(this.getColor()==14)
                this.dropItem(MelonCraft.wbmws.itemID, 1);
                else if(this.getColor()==15)
                this.dropItem(MelonCraft.wwmws.itemID, 1);
        	
        	//Sets it back to the normal MC player on death here.  XD
        	//@SideOnly(Side.CLIENT)
        	{
        	//ModLoader.getMinecraftInstance().renderViewEntity=ModLoader.getMinecraftInstance().thePlayer;
        	}
        	
        	//Drops the item this MWS is holding, if it has one.
        	ItemStack[] lastItems = this.getLastActiveItems();
        	if(lastItems[0]!=null)
        	this.dropItem(lastItems[0], lastItems[0].stackSize);
        	if(lastItems[1]!=null)
        	this.dropItem(lastItems[1], lastItems[1].stackSize);
        	if(lastItems[2]!=null)
        	this.dropItem(lastItems[2], lastItems[2].stackSize);
        	if(lastItems[3]!=null)
        	this.dropItem(lastItems[3], lastItems[3].stackSize);
        	if(lastItems[4]!=null)
        	this.dropItem(lastItems[4], lastItems[4].stackSize);
        	//Drop armor types!
        }
        
        public void onUpdate()
        {
            super.onUpdate();
            //if(this.dataWatcher.getWatchableObjectInt(16)==1)
            //{
            //	this.setCurrentItemOrArmor(4, new ItemStack(MelonCraft.NMWH));
            //	this.setCurrentItemOrArmor(3, new ItemStack(MelonCraft.NMWC));
            //	this.setCurrentItemOrArmor(2, new ItemStack(MelonCraft.NMWL));
            //	this.setCurrentItemOrArmor(1, new ItemStack(MelonCraft.NMWB));
            //}
            /*if(this.dataWatcher.getWatchableObjectInt(15)!=0)
            this.setCurrentItemOrArmor(0, new ItemStack(this.stickStuff, 1, 0));
            if(this.dataWatcher.getWatchableObjectInt(23)!=0)
            this.setCurrentItemOrArmor(4, new ItemStack(this.armortypeHead, 1, 0));
            if(this.dataWatcher.getWatchableObjectInt(22)!=0)
            this.setCurrentItemOrArmor(3, new ItemStack(this.armortypeChest, 1, 0));
            if(this.dataWatcher.getWatchableObjectInt(21)!=0)
            this.setCurrentItemOrArmor(2, new ItemStack(this.armortypeLegs, 1, 0));
            if(this.dataWatcher.getWatchableObjectInt(20)!=0)
            this.setCurrentItemOrArmor(1, new ItemStack(this.armortypeBoots, 1, 0));
            if(this.dataWatcher.getWatchableObjectInt(15)==0)
            this.setCurrentItemOrArmor(0, null);
            if(this.dataWatcher.getWatchableObjectInt(23)==0)
            this.setCurrentItemOrArmor(4, null);
            if(this.dataWatcher.getWatchableObjectInt(22)==0)
            this.setCurrentItemOrArmor(3, null);
            if(this.dataWatcher.getWatchableObjectInt(21)==0)
            this.setCurrentItemOrArmor(2, null);
            if(this.dataWatcher.getWatchableObjectInt(20)==0)
            this.setCurrentItemOrArmor(1, null);*/
            EntityMelonwoolSoldier var1 = (EntityMelonwoolSoldier) this.worldObj.findNearestEntityWithinAABB(EntityMelonwoolSoldier.class, this.boundingBox.expand(16.0D, 8.0D, 16.0D), this);
            if(var1!=null && this.neutral==false)
            {
            if(var1.getColor()!=this.getColor())
            this.entityToAttack=var1;
            }
            EntityPlayerMP var2 = (EntityPlayerMP) this.worldObj.findNearestEntityWithinAABB(EntityPlayerMP.class, this.boundingBox.expand(16.0D, 8.0D, 16.0D), this);
            if(var2!=null && this.hostileToPlayers==true)
            {
            if(var2.capabilities.isCreativeMode==false)
            this.entityToAttack=var2;
            }
            EntityMiniMelonwoolSoldier var3 = (EntityMiniMelonwoolSoldier) this.worldObj.findNearestEntityWithinAABB(EntityMiniMelonwoolSoldier.class, this.boundingBox.expand(16.0D, 8.0D, 16.0D), this);
            if(var3!=null && this.getColor()!=var3.getColor())
            {
            this.entityToAttack=var3;
            }
            if(this.movementInput!=null)
            {
                this.moveStrafing = this.movementInput.moveStrafe;
                this.moveForward = this.movementInput.moveForward;
                this.isJumping = this.movementInput.jump;
            }
            this.doClientStuff();
        }
        
        public String getTexture()
        {	    	
	    	return "/meloncraft/texes/"+this.colors[this.dataWatcher.getWatchableObjectInt(18)]+"mws.png";
        }
        
        private void doClientStuff()
        {
        	//System.out.println("My color is:"+this.getColor());
		}

		protected void attackEntity(Entity par1Entity, float par2)
        {
            if (this.attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY)
            {
                this.attackTime = 20;
                this.attackEntityAsMob(par1Entity);
            }
        }
        
        public boolean attackEntityAsMob(Entity par1Entity)
        {
            this.setLastAttackingEntity(par1Entity);
            par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), this.getAttackStrength(par1Entity));
            this.swingItem();
            return false;
        }
        
        private int getArmSwingAnimationEnd()
        {
            return this.isPotionActive(Potion.digSpeed) ? 6 - (1 + this.getActivePotionEffect(Potion.digSpeed).getAmplifier()) * 1 : (this.isPotionActive(Potion.digSlowdown) ? 6 + (1 + this.getActivePotionEffect(Potion.digSlowdown).getAmplifier()) * 2 : 6)*2;
        }
        
        public void swingItem()
        {
        	//System.out.println("SwingItem()");
            if (!this.isSwingInProgress || this.swingProgressInt >= this.getArmSwingAnimationEnd() / 2 || this.swingProgressInt < 0)
            {
            	//System.out.println("SWINGING HAND");
                this.swingProgressInt = -2;
                this.isSwingInProgress = true;

                if (this.worldObj instanceof WorldServer)
                {
                	//System.out.println("SWINGING HAND-2");
                    ((WorldServer)this.worldObj).getEntityTracker().sendPacketToAllPlayersTrackingEntity(this, new Packet18Animation(this, 1));
                }
            }
        }
        
        protected void updateArmSwingProgress()
        {
        	//System.out.println("Updating armSwingProgress");
            int var1 = this.getArmSwingAnimationEnd();

            if (this.isSwingInProgress)
            {
                ++this.swingProgressInt;

                if (this.swingProgressInt >= var1)
                {
                    this.swingProgressInt = 0;
                    this.isSwingInProgress = false;
                    //System.out.println("Swing finished.");
                }
            }
            else
            {
                this.swingProgressInt = 0;
            }

            this.swingProgress = (float)this.swingProgressInt / (float)var1;
        }
        
        public boolean interact(EntityPlayer par1EntityPlayer)
        {
        	ItemStack[] lastItems = this.getLastActiveItems();
        	if(par1EntityPlayer.getHeldItem()!= null)
        	{
        	if(par1EntityPlayer.getHeldItem().getItem().itemID==MelonCraft.magDust.itemID)
        	{
        		this.neutral=true;
        		this.entityToAttack=null;
        	}
        	}
        	if(par1EntityPlayer.getHeldItem()!= null)
        	{
        	if(par1EntityPlayer.getHeldItem().getItem().itemID==MelonCraft.redMD.itemID)
        	{
        		this.hostileToPlayers=true;
        	}
        	}
        	if(this.armortypeHead==0)
        	{
        		if(par1EntityPlayer.getHeldItem()!= null)
            	{
            	if(par1EntityPlayer.getHeldItem().getItem() instanceof ItemArmor)
            	{
            		ItemArmor armoritem = (ItemArmor)par1EntityPlayer.getHeldItem().getItem();
            		if(armoritem.armorType==0)
            		{
            		this.armortypeHead=par1EntityPlayer.getHeldItem().itemID;
            		this.setCurrentItemOrArmor(4, par1EntityPlayer.getHeldItem());
            		this.removeItem(par1EntityPlayer);
            		return true;
            		}
            	}
            	}
        	}
        	else
        	{
        		if(par1EntityPlayer.getHeldItem()==null)
        		{
        		this.dropItem(lastItems[4], 1);
        		this.armortypeHead=0;
        		this.setCurrentItemOrArmor(4, null);
        		}
        	}
        	if(this.armortypeChest==0)
        	{
        		if(par1EntityPlayer.getHeldItem()!= null)
            	{
            	if(par1EntityPlayer.getHeldItem().getItem() instanceof ItemArmor)
            	{
            		ItemArmor armoritem = (ItemArmor)par1EntityPlayer.getHeldItem().getItem();
            		if(armoritem.armorType==1)
            		{
            		this.armortypeChest=par1EntityPlayer.getHeldItem().itemID;
            		this.setCurrentItemOrArmor(3, par1EntityPlayer.getHeldItem());
            		this.removeItem(par1EntityPlayer);
            		return true;
            		}
            	}
            	}
        	}
        	else
        	{
        		if(par1EntityPlayer.getHeldItem()==null)
        		{
        		this.dropItem(lastItems[3], 1);
        		this.armortypeChest=0;
        		this.setCurrentItemOrArmor(3, par1EntityPlayer.getHeldItem());
        		}
        	}
        	if(this.armortypeLegs==0)
        	{
        		if(par1EntityPlayer.getHeldItem()!= null)
            	{
            	if(par1EntityPlayer.getHeldItem().getItem() instanceof ItemArmor)
            	{
            		ItemArmor armoritem = (ItemArmor)par1EntityPlayer.getHeldItem().getItem();
            		if(armoritem.armorType==2)
            		{
            		this.armortypeLegs=par1EntityPlayer.getHeldItem().itemID;
            		this.setCurrentItemOrArmor(2, par1EntityPlayer.getHeldItem());
            		this.removeItem(par1EntityPlayer);
            		return true;
            		}
            	}
            	}
        	}
        	else
        	{
        		if(par1EntityPlayer.getHeldItem()==null)
        		{
        		this.dropItem(lastItems[2], 1);
        		this.armortypeLegs=0;
        		this.setCurrentItemOrArmor(2, null);
        		}
        	}
        	if(this.armortypeBoots==0)
        	{
        		if(par1EntityPlayer.getHeldItem()!= null)
            	{
            	if(par1EntityPlayer.getHeldItem().getItem() instanceof ItemArmor)
            	{
            		ItemArmor armoritem = (ItemArmor)par1EntityPlayer.getHeldItem().getItem();
            		if(armoritem.armorType==3)
            		{
            		this.armortypeBoots=par1EntityPlayer.getHeldItem().itemID;
            		this.setCurrentItemOrArmor(1, par1EntityPlayer.getHeldItem());
            		this.removeItem(par1EntityPlayer);
            		return true;
            		}
            	}
            	}
        	}
        	else
        	{
        		if(par1EntityPlayer.getHeldItem()==null)
        		{
        		this.dropItem(lastItems[1], 1);
        		this.armortypeBoots=0;
        		this.setCurrentItemOrArmor(1, null);
        		}
        	}
        	if(this.stickStuff==0)
        	{
        	if(par1EntityPlayer.getHeldItem()!=null)
        	{
        		this.stickStuff=par1EntityPlayer.getHeldItem().itemID;
        		this.setCurrentItemOrArmor(0, par1EntityPlayer.getHeldItem());
        		this.removeItem(par1EntityPlayer);
        		return true;
        	}
        	}
        	else
        	{
        	if(par1EntityPlayer.getHeldItem()==null)
        	{
        		this.dropItem(lastItems[0], 1);
        		this.stickStuff=0;
        		this.setCurrentItemOrArmor(0, null);
        	}
        	}
        	return true;
        }
        
        /**
         * Returns the amount of damage a mob should deal.
         */
        public int getAttackStrength(Entity par1Entity)
        {
        	ItemStack thisHeldItem = this.getLastActiveItems()[0];
        	if(thisHeldItem!=null)
        	return thisHeldItem.getDamageVsEntity(par1Entity);
        	else
        	return 1;
        }


		@Override
		public int getMaxHealth()
		{
			return 20;
		}

		public int getColor() {
			return colorInt;
		}
		
		public void setColorInt(int clr)
		{
			this.colorInt=clr;
		}

		public void setColor(int color) {
			this.colorInt = color;
			this.dataWatcher.updateObject(18, this.colorInt);
		}
		
		@Override
	    protected boolean canDespawn()
	    {
	        return false;
	    }

	    protected void entityInit()
	    {
	        super.entityInit();
	        this.dataWatcher.addObject(18, 0);
	        this.dataWatcher.addObject(15, 0);
	        this.dataWatcher.addObject(20, 0);
	        this.dataWatcher.addObject(21, 0);
	        this.dataWatcher.addObject(22, 0);
	        this.dataWatcher.addObject(23, 0);
	    }
	    
	    @SideOnly(Side.CLIENT)
	    public void onEntityUpdate()
	    {
	    	super.onEntityUpdate();
	    	this.updateArmSwingProgress();
	    }
	    
	    public void removeItem(EntityPlayer par1EntityPlayer)
	    {
	    	if(par1EntityPlayer.capabilities.isCreativeMode==false)
    		{
    		if(par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem].stackSize>1)
    		par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem].stackSize--;
    		else
    			par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem]=null;
    		}
	    }
	    
	    /**
	     * Drops an item stack at the entity's position. Args: itemID, count
	     */
	    public EntityItem dropItem(ItemStack par1, int par2)
	    {
	    	if(par1!=null && !this.worldObj.isRemote)
	        return this.dropItemWithOffset(par1, par2, 0.0F);
	    	else
	    	return null;
	    }
	    
	    public EntityItem dropItemWithOffset(ItemStack par1, int par2, float par3)
	    {
	        return this.entityDropItem(par1, par3);
	    }
}