package meloncraft.src;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet18Animation;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovementInput;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.ForgeHooks;

public class EntityMiniMelonwoolSoldier extends EntityCreature
{
		private String color="";
		//private EntityPlayer theOldPlayer = ModLoader.getMinecraftInstance().thePlayer;
		private MovementInput movementInput;
		private int stickStuff=0;
		private int atk=1;
		int armortypeHead=0;
		private boolean doonce=false;
		private int colorInt;
		private boolean neutral;
		private boolean hostileToPlayers;
		private String[] colors = {"rr", "rg", "rb", "gr", "gg", "gb", "br", "bg", "bb", "rw", "gw", "bw", "wr", "wg", "wb", "ww"};
		String[] armortypes = {"NMW", "RMW", "GMW", "BMW"};
		public int armortype;
		
        public EntityMiniMelonwoolSoldier(World world)
        {
                super(world);
                this.setSize(0.4F, 0.8F);
                System.out.println("YAY, MELONWOOLSOLDIER");
        }
        
        public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
        {
            super.readEntityFromNBT(par1NBTTagCompound);
            this.setStickStuff(par1NBTTagCompound.getInteger("Item"));
            this.atk=par1NBTTagCompound.getInteger("Attack");
            this.setColor(par1NBTTagCompound.getInteger("Color"));
            this.neutral=par1NBTTagCompound.getBoolean("Neutral");
            this.hostileToPlayers=par1NBTTagCompound.getBoolean("HostileToPlayers");
            this.setArmor(par1NBTTagCompound.getInteger("ArmorHead"));
            this.armortype=par1NBTTagCompound.getInteger("Armor");
            //this.dataWatcher.updateObject(20, par1NBTTagCompound.getInteger("Armor"));
        }

        /**
         * (abstract) Protected helper method to write subclass entity data to NBT.
         */
        public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
        {
            super.writeEntityToNBT(par1NBTTagCompound);
            par1NBTTagCompound.setInteger("Item", this.getStickStuff());
            par1NBTTagCompound.setInteger("Attack", this.atk);
            par1NBTTagCompound.setInteger("ArmorHead", this.getArmor());
            par1NBTTagCompound.setInteger("Armor", this.armortype);
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
            this.dropItem(MelonCraft.rrminimws.itemID, 1);
            else if(this.getColor()==1)
            this.dropItem(MelonCraft.rgminimws.itemID, 1);
            else if(this.getColor()==2)
            this.dropItem(MelonCraft.rbminimws.itemID, 1);
            else if(this.getColor()==3)
            this.dropItem(MelonCraft.grminimws.itemID, 1);
            else if(this.getColor()==4)
            this.dropItem(MelonCraft.ggminimws.itemID, 1);
            else if(this.getColor()==5)
            this.dropItem(MelonCraft.gbminimws.itemID, 1);
            else if(this.getColor()==6)
            this.dropItem(MelonCraft.brminimws.itemID, 1);
            else if(this.getColor()==7)
            this.dropItem(MelonCraft.bgminimws.itemID, 1);
            else if(this.getColor()==8)
            this.dropItem(MelonCraft.bbminimws.itemID, 1);
            else if(this.getColor()==9)
            this.dropItem(MelonCraft.rwminimws.itemID, 1);
            else if(this.getColor()==10)
            this.dropItem(MelonCraft.gwminimws.itemID, 1);
            else if(this.getColor()==11)
            this.dropItem(MelonCraft.bwminimws.itemID, 1);
            else if(this.getColor()==12)
            this.dropItem(MelonCraft.wrminimws.itemID, 1);
            else if(this.getColor()==13)
            this.dropItem(MelonCraft.wgminimws.itemID, 1);
            else if(this.getColor()==14)
            this.dropItem(MelonCraft.wbminimws.itemID, 1);
            else if(this.getColor()==15)
            this.dropItem(MelonCraft.wwminimws.itemID, 1);
        	
        	//Sets it back to the normal MC player on death here.  XD
        	//@SideOnly(Side.CLIENT)
        	{
        	//ModLoader.getMinecraftInstance().renderViewEntity=ModLoader.getMinecraftInstance().thePlayer;
        	}
        	
        	//Drops the item this MWS is holding, if it has one.
        	if(this.getStickStuff()==1)
        	{
        		this.dropItem(MelonCraft.melStick.itemID, 1);
        	}
        	if(this.getArmor()==1)
        	{
        		this.dropItem(MelonCraft.NMWH.itemID, 1);
        	}
        	if(this.getArmor()==2)
        	{
        		this.dropItem(MelonCraft.RMWH.itemID, 1);
        	}
        	if(this.getArmor()==3)
        	{
        		this.dropItem(MelonCraft.GMWH.itemID, 1);
        	}
        	if(this.getArmor()==4)
        	{
        		this.dropItem(MelonCraft.BMWH.itemID, 1);
        	}
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
            //this.dataWatcher.updateObject(15, this.getStickStuff());
            //if(this.dataWatcher.getWatchableObjectInt(15)==1)
            //this.setCurrentItemOrArmor(0, new ItemStack(MelonCraft.melWoodPick));
            //if(this.dataWatcher.getWatchableObjectInt(15)==2)
            //this.setCurrentItemOrArmor(0, new ItemStack(MelonCraft.melStonePick));
            //if(this.dataWatcher.getWatchableObjectInt(15)==3)
            //this.setCurrentItemOrArmor(0, new ItemStack(MelonCraft.melWoodSword));
            //if(this.dataWatcher.getWatchableObjectInt(15)==4)
            //this.setCurrentItemOrArmor(0, new ItemStack(MelonCraft.melStoneSword));
            //if(this.dataWatcher.getWatchableObjectInt(15)==5)
            //this.setCurrentItemOrArmor(0, new ItemStack(MelonCraft.moonStonePick));
            //if(this.dataWatcher.getWatchableObjectInt(15)==6)
            //this.setCurrentItemOrArmor(0, new ItemStack(MelonCraft.moonStoneSword));
            //if(this.dataWatcher.getWatchableObjectInt(20)!=0)
            //this.setCurrentItemOrArmor(4, new ItemStack(this.armortypeHead, 1, 0));
            EntityMiniMelonwoolSoldier var1 = (EntityMiniMelonwoolSoldier) this.worldObj.findNearestEntityWithinAABB(EntityMiniMelonwoolSoldier.class, this.boundingBox.expand(16.0D, 8.0D, 16.0D), this);
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
            EntityMelonwoolSoldier var3 = (EntityMelonwoolSoldier) this.worldObj.findNearestEntityWithinAABB(EntityMelonwoolSoldier.class, this.boundingBox.expand(16.0D, 8.0D, 16.0D), this);
            if(var3!=null && this.neutral==false)
            {
            if(var3.getColor()!=this.getColor())
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
	    	return "/meloncraft/texes/mini"+this.colors[this.dataWatcher.getWatchableObjectInt(18)]+"mws.png";
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
        	if(par1EntityPlayer.getHeldItem()==null && !this.worldObj.isRemote)
        	{
        		if(this.getStickStuff()==1)
        		{
        		this.dropItem(MelonCraft.melStick.itemID, 1);
        		this.setStickStuff(0);
        		}
        		if(this.getArmor()==1)
        		{
            	this.dropItem(MelonCraft.NMWH.itemID, 1);
            	this.setArmor(0);
        		}
            	if(this.getArmor()==2)
            	{
               	this.dropItem(MelonCraft.RMWH.itemID, 1);
               	this.setArmor(0);
            	}
                if(this.getArmor()==3)
                {
                this.dropItem(MelonCraft.GMWH.itemID, 1);
               	this.setArmor(0);
                }
                if(this.getArmor()==4)
                {
                this.dropItem(MelonCraft.BMWH.itemID, 1);
               	this.setArmor(0);
                }
        	}
        	if(par1EntityPlayer.getHeldItem()!= null)
        	{
        	if(par1EntityPlayer.getHeldItem().getItem()==MelonCraft.magDust)
        	{
        		this.neutral=true;
        		this.entityToAttack=null;
        	}
        	}
        	if(par1EntityPlayer.getHeldItem()!= null)
        	{
        	if(par1EntityPlayer.getHeldItem().getItem()==MelonCraft.redMD)
        	{
        		this.hostileToPlayers=true;
        	}
        	}
        	if(this.getStickStuff()==0)
        	{
        	if(par1EntityPlayer.getHeldItem()!= null)
        	{
        	if(par1EntityPlayer.getHeldItem().getItem()==MelonCraft.melStick)
        	{
        		this.setStickStuff(1);
        		this.atk=2;
        		if(par1EntityPlayer.capabilities.isCreativeMode==false)
        		{
        		if(par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem].stackSize>1)
        		par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem].stackSize--;
        		else
        		par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem]=null;
        		}
        	}
        	}
        	this.dataWatcher.updateObject(15, this.getStickStuff());
        	}
        	if(this.getArmor()==0)
        	{
        		if(par1EntityPlayer.getHeldItem()!= null)
            	{
            	if(par1EntityPlayer.getHeldItem().getItem()==MelonCraft.NMWH)
            	{
            		this.setArmor(1);
            		//this.armortype=1;
            		if(par1EntityPlayer.capabilities.isCreativeMode==false)
            		{
            		if(par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem].stackSize>1)
            		par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem].stackSize--;
            		else
            		par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem]=null;
            		}
            	}
            	}
        		if(par1EntityPlayer.getHeldItem()!= null)
            	{
            	if(par1EntityPlayer.getHeldItem().getItem()==MelonCraft.RMWH)
            	{
            		this.setArmor(2);
            		//this.armortype=1;
            		if(par1EntityPlayer.capabilities.isCreativeMode==false)
            		{
            		if(par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem].stackSize>1)
            		par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem].stackSize--;
            		else
            		par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem]=null;
            		}
            	}
            	}
        		if(par1EntityPlayer.getHeldItem()!= null)
            	{
            	if(par1EntityPlayer.getHeldItem().getItem()==MelonCraft.GMWH)
            	{
            		this.setArmor(3);
            		//this.armortype=1;
            		if(par1EntityPlayer.capabilities.isCreativeMode==false)
            		{
            		if(par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem].stackSize>1)
            		par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem].stackSize--;
            		else
            		par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem]=null;
            		}
            	}
            	}
        		if(par1EntityPlayer.getHeldItem()!= null)
            	{
            	if(par1EntityPlayer.getHeldItem().getItem()==MelonCraft.BMWH)
            	{
            		this.setArmor(4);
            		//this.armortype=1;
            		if(par1EntityPlayer.capabilities.isCreativeMode==false)
            		{
            		if(par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem].stackSize>1)
            		par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem].stackSize--;
            		else
            		par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem]=null;
            		}
            	}
            	}
        	}
        	return true;
        }

		/**
         * Returns the amount of damage a mob should deal.
         */
        public int getAttackStrength(Entity par1Entity)
        {
        	return this.atk;
        }


		@Override
		public int getMaxHealth()
		{
			return 8;
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
	        //this.dataWatcher.addObject(21, 0);
	        //this.dataWatcher.addObject(22, 0);
	        //this.dataWatcher.addObject(23, 0);
	    }
	    
	    @SideOnly(Side.CLIENT)
	    public void onEntityUpdate()
	    {
	    	super.onEntityUpdate();
	    	this.updateArmSwingProgress();
	    }

		public int getStickStuff() {
			return this.dataWatcher.getWatchableObjectInt(15);
		}

		public void setStickStuff(int stickStuff) {
			this.dataWatcher.updateObject(15, stickStuff);
			this.stickStuff = stickStuff;
		}
		
		public int getArmor() {
			return this.dataWatcher.getWatchableObjectInt(20);
		}

		public void setArmor(int armor) {
			this.dataWatcher.updateObject(20, armor);
			this.armortypeHead = armor;
		}
		
		public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	    {
	        if (ForgeHooks.onLivingAttack(this, par1DamageSource, par2))
	        {
	            return false;
	        }

	        if (this.isEntityInvulnerable())
	        {
	            return false;
	        }
	        else if (this.worldObj.isRemote)
	        {
	            return false;
	        }
	        else
	        {
	            this.entityAge = 0;

	            if (this.health <= 0)
	            {
	                return false;
	            }
	            else if (par1DamageSource.isFireDamage() && this.isPotionActive(Potion.fireResistance))
	            {
	                return false;
	            }
	            else
	            {
	                if (this.getArmor()>0)
	                {
	                    //this.getCurrentItemOrArmor(4).damageItem(par2 * 4 + this.rand.nextInt(par2 * 2), this);
	                    par2-=1;
	                }

	                this.limbYaw = 1.5F;
	                boolean flag = true;

	                if ((float)this.hurtResistantTime > (float)this.maxHurtResistantTime / 2.0F)
	                {
	                    if (par2 <= this.lastDamage)
	                    {
	                        return false;
	                    }

	                    this.damageEntity(par1DamageSource, par2 - this.lastDamage);
	                    this.lastDamage = par2;
	                    flag = false;
	                }
	                else
	                {
	                    this.lastDamage = par2;
	                    this.prevHealth = this.health;
	                    this.hurtResistantTime = this.maxHurtResistantTime;
	                    this.damageEntity(par1DamageSource, par2);
	                    this.hurtTime = this.maxHurtTime = 10;
	                }

	                this.attackedAtYaw = 0.0F;
	                Entity entity = par1DamageSource.getEntity();

	                if (entity != null)
	                {
	                    if (entity instanceof EntityLiving)
	                    {
	                        this.setRevengeTarget((EntityLiving)entity);
	                    }

	                    if (entity instanceof EntityPlayer)
	                    {
	                        this.recentlyHit = 100;
	                        this.attackingPlayer = (EntityPlayer)entity;
	                    }
	                    else if (entity instanceof EntityWolf)
	                    {
	                        EntityWolf entitywolf = (EntityWolf)entity;

	                        if (entitywolf.isTamed())
	                        {
	                            this.recentlyHit = 100;
	                            this.attackingPlayer = null;
	                        }
	                    }
	                }

	                if (flag)
	                {
	                    this.worldObj.setEntityState(this, (byte)2);

	                    if (par1DamageSource != DamageSource.drown)
	                    {
	                        this.setBeenAttacked();
	                    }

	                    if (entity != null)
	                    {
	                        double d0 = entity.posX - this.posX;
	                        double d1;

	                        for (d1 = entity.posZ - this.posZ; d0 * d0 + d1 * d1 < 1.0E-4D; d1 = (Math.random() - Math.random()) * 0.01D)
	                        {
	                            d0 = (Math.random() - Math.random()) * 0.01D;
	                        }

	                        this.attackedAtYaw = (float)(Math.atan2(d1, d0) * 180.0D / Math.PI) - this.rotationYaw;
	                        this.knockBack(entity, par2, d0, d1);
	                    }
	                    else
	                    {
	                        this.attackedAtYaw = (float)((int)(Math.random() * 2.0D) * 180);
	                    }
	                }

	                if (this.health <= 0)
	                {
	                    if (flag)
	                    {
	                        this.playSound(this.getDeathSound(), this.getSoundVolume(), this.getSoundPitch());
	                    }

	                    this.onDeath(par1DamageSource);
	                }
	                else if (flag)
	                {
	                    this.playSound(this.getHurtSound(), this.getSoundVolume(), this.getSoundPitch());
	                }

	                return true;
	            }
	        }
	    }
		
	    /**
	     * Drops an item stack at the entity's position. Args: itemID, count
	     */
	    public EntityItem dropItem(ItemStack par1, int par2)
	    {
	    	if(par1!=null && !this.worldObj.isRemote)
	        return this.dropItemWithOffset(par1.itemID, par2, 0.0F);
	    	else
	    	return null;
	    }
}