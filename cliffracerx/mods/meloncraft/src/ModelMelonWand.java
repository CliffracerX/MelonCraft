package cliffracerx.mods.meloncraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ModelMelonWand extends ModelBase
{
  //fields
    ModelRenderer Core;
    ModelRenderer TopCap;
    ModelRenderer BottomCap;
    ModelRenderer WandFocus;
  
  public ModelMelonWand()
  {
    textureWidth = 24;
    textureHeight = 18;
    
      Core = new ModelRenderer(this, 0, 0);
      Core.addBox(-1F, -8F, -1F, 2, 16, 2);
      Core.setRotationPoint(0F, 14F, 0F);
      Core.setTextureSize(24, 18);
      Core.mirror = true;
      setRotation(Core, 0F, 0F, 0F);
      TopCap = new ModelRenderer(this, 8, 0);
      TopCap.addBox(-1.5F, -2F, -1.5F, 3, 2, 3);
      TopCap.setRotationPoint(0F, 6F, 0F);
      TopCap.setTextureSize(24, 18);
      TopCap.mirror = true;
      setRotation(TopCap, 0F, 0F, 0F);
      BottomCap = new ModelRenderer(this, 8, 5);
      BottomCap.addBox(-1.5F, 0F, -1.5F, 3, 2, 3);
      BottomCap.setRotationPoint(0F, 22F, 0F);
      BottomCap.setTextureSize(24, 18);
      BottomCap.mirror = true;
      setRotation(BottomCap, 0F, 0F, 0F);
      WandFocus = new ModelRenderer(this, 8, 10);
      WandFocus.addBox(-2F, -4F, -2F, 4, 4, 4);
      WandFocus.setRotationPoint(0F, 6F, 0F);
      WandFocus.setTextureSize(24, 18);
      WandFocus.mirror = true;
      setRotation(WandFocus, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, Minecraft mc, MelonWand wandItem)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    mc.renderEngine.bindTexture(new ResourceLocation(
            "meloncraft:textures/models/wands/"+wandItem.coretype+"core.png"));
    Core.render(f5);
    mc.renderEngine.bindTexture(new ResourceLocation(
            "meloncraft:textures/models/wands/"+wandItem.captype+"cap.png"));
    TopCap.render(f5);
    BottomCap.render(f5);
    mc.renderEngine.bindTexture(new ResourceLocation(
            "meloncraft:textures/models/wands/"+wandItem.focustype+"focus.png"));
    WandFocus.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
  }

}
