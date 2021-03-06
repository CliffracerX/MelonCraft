// Date: 5/30/2013 11:26:54 Pm o'clock.
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package meloncraft.src;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.src.ModLoader;
import net.minecraft.util.MathHelper;

public class ModelMiniMWS extends ModelBiped
{
	  //fields
    ModelRenderer stick;
    ModelRenderer bipedBody2;
    
  public ModelMiniMWS()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      stick = new ModelRenderer(this, 16, 16);
      stick.addBox(-0.5F, 4.5F, -6F, 1, 1, 6);
      stick.setRotationPoint(-5F, 10F, 0F);
      stick.setTextureSize(32, 32);
      setRotation(stick, 0F, 0F, 0F);
      bipedBody = new ModelRenderer(this, 0, 0);
      bipedBody.addBox(-4F, -8F, -4F, 8, 8, 8);
      bipedBody.setRotationPoint(0F, 16F, 0F);
      bipedBody.setTextureSize(32, 32);
      bipedBody2 = new ModelRenderer(this, 0, 0);
      bipedBody2.addBox(-4F, -8F, -4F, 8, 8, 8);
      bipedBody2.setRotationPoint(0F, 16F, 0F);
      bipedBody2.setTextureSize(32, 32);
      setRotation(bipedBody, 0F, 0F, 0F);
      //bipedBodywear = new ModelRenderer(this, 0, 0);
      //bipedBodywear.addBox(-4F, -8F, -4F, 8, 8, 8);
      //bipedBodywear.setRotationPoint(0F, 16F, 0F);
      //bipedBodywear.setTextureSize(32, 32);
      //setRotation(bipedBodywear, 0F, 0F, 0F);
      bipedLeftLeg = new ModelRenderer(this, 0, 16);
      bipedLeftLeg.addBox(-1F, 4F, -1F, 2, 8, 2);
      bipedLeftLeg.setRotationPoint(3F, 16F, 0F);
      bipedLeftLeg.setTextureSize(32, 32);
      setRotation(bipedLeftLeg, 0F, 0F, 0F);
      bipedRightLeg = new ModelRenderer(this, 8, 16);
      bipedRightLeg.addBox(-1F, 4F, -1F, 2, 8, 2);
      bipedRightLeg.setRotationPoint(-3F, 16F, 0F);
      bipedRightLeg.setTextureSize(32, 32);
      bipedRightLeg.mirror = true;
      setRotation(bipedRightLeg, 0F, 0F, 0F);
      bipedRightArm = new ModelRenderer(this, 24, 0);
      bipedRightArm.addBox(-1F, 0F, -1F, 2, 6, 2);
      bipedRightArm.setRotationPoint(-5F, 10F, 0F);
      bipedRightArm.setTextureSize(32, 32);
      bipedRightArm.mirror = true;
      setRotation(bipedRightArm, 0F, 0F, 0F);
      bipedLeftArm = new ModelRenderer(this, 0, 0);
      bipedLeftArm.addBox(-1F, 0F, -1F, 2, 6, 2);
      bipedLeftArm.setRotationPoint(5F, 10F, 0F);
      bipedLeftArm.setTextureSize(32, 32);
      setRotation(bipedLeftArm, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
	EntityMiniMelonwoolSoldier soldier = (EntityMiniMelonwoolSoldier)entity;
    //super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    //bipedBody.render(f5);
    bipedBody.render(f5);
    bipedRightArm.render(f5);
    bipedLeftArm.render(f5);
    bipedRightLeg.render(f5);
    bipedLeftLeg.render(f5);
    if(soldier.getStickStuff()==1)
    {
    	stick.render(f5);
    }
    if(soldier.getArmor()>0)
    {
    	ModLoader.getMinecraftInstance().renderEngine.func_98187_b("/meloncraft/texes/bodArm1"+soldier.armortypes[soldier.getArmor()-1]+".png");
    	GL11.glScalef(1.05F, 1.05F, 1.05F);
    	GL11.glTranslatef(0, -0.05F, 0);
    	bipedBody.render(f5);
    }
    //moonstonemaceend.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  /**
   * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
   * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
   * "far" arms and legs can swing at most.
   */
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
  {
      //this.bipedBody.rotateAngleY = par4 / (180F / (float)Math.PI);
      //this.bipedBody.rotateAngleX = par5 / (180F / (float)Math.PI);
      //this.bipedBodywear.rotateAngleY = this.bipedBody.rotateAngleY;
      //this.bipedBodywear.rotateAngleX = this.bipedBody.rotateAngleX;
      this.bipedRightArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
      this.bipedLeftArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
      this.bipedRightArm.rotateAngleZ = 0.0F;
      this.bipedLeftArm.rotateAngleZ = 0.0F;
      this.bipedRightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
      this.bipedLeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
      this.bipedRightLeg.rotateAngleY = 0.0F;
      this.bipedLeftLeg.rotateAngleY = 0.0F;

      if (this.isRiding)
      {
          this.bipedRightArm.rotateAngleX += -((float)Math.PI / 5F);
          this.bipedLeftArm.rotateAngleX += -((float)Math.PI / 5F);
          this.bipedRightLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
          this.bipedLeftLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
          this.bipedRightLeg.rotateAngleY = ((float)Math.PI / 10F);
          this.bipedLeftLeg.rotateAngleY = -((float)Math.PI / 10F);
      }

      if (this.heldItemLeft != 0)
      {
          this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)this.heldItemLeft;
      }

      if (this.heldItemRight != 0)
      {
          this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)this.heldItemRight;
      }

      this.bipedRightArm.rotateAngleY = 0.0F;
      this.bipedLeftArm.rotateAngleY = 0.0F;
      float f6;
      float f7;

      if (this.onGround > -9990.0F)
      {
          f6 = this.onGround;
          this.bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * (float)Math.PI * 2.0F) * 0.2F;
          this.bipedRightArm.rotationPointZ = MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
          this.bipedRightArm.rotationPointX = -MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
          this.bipedLeftArm.rotationPointZ = -MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
          this.bipedLeftArm.rotationPointX = MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
          this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY;
          this.bipedLeftArm.rotateAngleY += this.bipedBody.rotateAngleY;
          this.bipedLeftArm.rotateAngleX += this.bipedBody.rotateAngleY;
          f6 = 1.0F - this.onGround;
          f6 *= f6;
          f6 *= f6;
          f6 = 1.0F - f6;
          f7 = MathHelper.sin(f6 * (float)Math.PI);
          float f8 = MathHelper.sin(this.onGround * (float)Math.PI) * -(this.bipedBody.rotateAngleX - 0.7F) * 0.75F;
          this.bipedRightArm.rotateAngleX = (float)((double)this.bipedRightArm.rotateAngleX - ((double)f7 * 1.2D + (double)f8));
          this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY * 2.0F;
          this.bipedRightArm.rotateAngleZ = MathHelper.sin(this.onGround * (float)Math.PI) * -0.4F;
      }

      if (this.isSneak)
      {
          this.bipedBody.rotateAngleX = 0.5F;
          this.bipedRightArm.rotateAngleX += 0.4F;
          this.bipedLeftArm.rotateAngleX += 0.4F;
          this.bipedRightLeg.rotationPointZ = 4.0F;
          this.bipedLeftLeg.rotationPointZ = 4.0F;
          this.bipedRightLeg.rotationPointY = 9.0F;
          this.bipedLeftLeg.rotationPointY = 9.0F;
          //this.bipedBody.rotationPointY = 1.0F;
          //this.bipedBodywear.rotationPointY = 1.0F;
      }
      else
      {
          this.bipedBody.rotateAngleX = 0.0F;
          this.bipedRightLeg.rotationPointZ = 0.1F;
          this.bipedLeftLeg.rotationPointZ = 0.1F;
          this.bipedRightLeg.rotationPointY = 12.0F;
          this.bipedLeftLeg.rotationPointY = 12.0F;
          //this.bipedBody.rotationPointY = 0.0F;
          //this.bipedBodywear.rotationPointY = 0.0F;
      }

      this.bipedRightArm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
      this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
      this.bipedRightArm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
      this.bipedLeftArm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;

      if (this.aimedBow)
      {
          f6 = 0.0F;
          f7 = 0.0F;
          this.bipedRightArm.rotateAngleZ = 0.0F;
          this.bipedLeftArm.rotateAngleZ = 0.0F;
          this.bipedRightArm.rotateAngleY = -(0.1F - f6 * 0.6F) + this.bipedBody.rotateAngleY;
          this.bipedLeftArm.rotateAngleY = 0.1F - f6 * 0.6F + this.bipedBody.rotateAngleY + 0.4F;
          this.bipedRightArm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedBody.rotateAngleX;
          this.bipedLeftArm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedBody.rotateAngleX;
          this.bipedRightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
          this.bipedLeftArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
          this.bipedRightArm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
          this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
          this.bipedRightArm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
          this.bipedLeftArm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;
          //this.moonstonemaceend.rotateAngleX=this.bipedRightArm.rotateAngleX;
          //this.moonstonemaceend.rotateAngleY=this.bipedRightArm.rotateAngleY;
          //this.moonstonemaceend.rotateAngleZ=this.bipedRightArm.rotateAngleZ;
      }
      this.stick.rotateAngleX=this.bipedRightArm.rotateAngleX;
      this.stick.rotateAngleY=this.bipedRightArm.rotateAngleY;
      this.stick.rotateAngleZ=this.bipedRightArm.rotateAngleZ;
      this.bipedBody2.rotateAngleX=this.bipedBody.rotateAngleX;
      this.bipedBody2.rotateAngleY=this.bipedBody.rotateAngleY;
      this.bipedBody2.rotateAngleZ=this.bipedBody.rotateAngleZ;
  }

  /**
   * renders the ears (specifically, deadmau5's)
   */
  public void renderEars(float par1)
  {
      this.bipedEars.rotateAngleY = this.bipedBody.rotateAngleY;
      this.bipedEars.rotateAngleX = this.bipedBody.rotateAngleX;
      this.bipedEars.rotationPointX = 0.0F;
      this.bipedEars.rotationPointY = 0.0F;
      this.bipedEars.render(par1);
  }

  /**
   * Renders the cloak of the current biped (in most cases, it's a player)
   */
  public void renderCloak(float par1)
  {
      this.bipedCloak.render(par1);
  }
}
