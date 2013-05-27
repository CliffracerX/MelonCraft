package meloncraft.src;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

public class FallSnowPart extends EntityFX
{
    float smokeParticleScale;

    public FallSnowPart(World par1World, double par2, double par4, double par6, double par8, double par10, double par12)
    {
        this(par1World, par2, par4, par6, par8, par10, par12, 1.0F);
    }

    public FallSnowPart(World par1World, double par2, double par4, double par6, double par8, double par10, double par12, float par14)
    {
        super(par1World, par2, par4, par6, 0.0D, 0.0D, 0.0D);
        this.motionX *= 0.10000000149011612D;
        this.motionY *= 0.10000000149011612D;
        this.motionZ *= 0.10000000149011612D;
        this.motionX += par8;
        double temp = par12 / 2;
        this.motionY += -0.05 + temp;
        /*this.motionZ += par12;*/
        this.particleRed = 1.0F;
        this.particleGreen = 0.75F;
        this.particleBlue = 0.5F;
        this.particleScale *= 0.75F;
        this.particleScale *= par14;
        this.smokeParticleScale = this.particleScale;
        this.particleMaxAge = (int)(2048.0D  / (Math.random() * 0.8D + 0.2D));
        //this.particleMaxAge = (int)((float)this.particleMaxAge * par14);
        this.noClip = false;
    }

    public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        /*float var8 = ((float)this.particleAge + par2) / (float)this.particleMaxAge * 32.0F;

        if (var8 < 0.0F)
        {
            var8 = 0.0F;
        }

        if (var8 > 1.0F)
        {
            var8 = 1.0F;
        }*/
        float var8 = 0.35F;
        this.particleScale = this.smokeParticleScale * var8;
        super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6, par7);
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        //System.out.println("MaxAge:"+this.particleMaxAge);
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            System.out.println("setDead()");
            this.setDead();
        }

        this.setParticleTextureIndex(7 - this.particleAge * 8 / 8192 * 4);
        //this.setParticleTextureIndex(0);
        //this.motionY -= 0.005D;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        
        if(this.onGround==true)
        {
        	this.motionX=0;
        	this.motionY=0;
        	this.motionZ=0;
        }
    }
}
