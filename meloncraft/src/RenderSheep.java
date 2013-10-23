package meloncraft.src;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLiving;

import org.lwjgl.opengl.GL11;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.relauncher.Side;

@SideOnly(Side.CLIENT)
public class RenderSheep extends RenderLiving
{
    public RenderSheep(ModelBase par1ModelBase, ModelBase par2ModelBase, float par3)
    {
        super(par1ModelBase, par3);
        this.setRenderPassModel(par2ModelBase);
    }

    protected int setWoolColorAndRender(MelonSheep par1Sheep, int par2, float par3)
    {
        if (par2 == 0 && !par1Sheep.getSheared())
        {
            this.loadTexture("/meloncraft/texes/melsheep_fur.png");
            float var4 = 1.0F;
            //int var5 = par1MSH.getFleeceColor();
            //GL11.glColor3f(var4 * MSH.fleeceColorTable[var5][0], var4 * MSH.fleeceColorTable[var5][1], var4 * MSH.fleeceColorTable[var5][2]);
            return 1;
        }
        else
        	return 0;
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
    {
        return this.setWoolColorAndRender((MelonSheep)par1EntityLiving, par2, par3);
    }
}
