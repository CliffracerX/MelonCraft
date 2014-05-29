package cliffracerx.mods.meloncraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.relauncher.Side;

@SideOnly(Side.CLIENT)
public class MelonWandRenderer implements IItemRenderer {
	ModelMelonWand wandmodel;

	public MelonWandRenderer() {
		wandmodel = new ModelMelonWand();
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
	    Minecraft mc = Minecraft.getMinecraft();
	    float scale;
	    Item tempItm = item.getItem();
	    float temp = 1.85f;
	    MelonWand wand = (MelonWand)tempItm;
		switch (type) {

		case EQUIPPED: // render in third person
			GL11.glPushMatrix(); //start gl rendering for this section
			scale = 0.85F;
            GL11.glScalef(scale, scale, scale);
			GL11.glRotatef(0F, 1.0f, 0.0f, 0.0f);
			GL11.glRotatef(-5F, 0.0f, 1.0f, 0.0f);
			GL11.glRotatef(-150F, 0.0f, 0.0f, 1.0f);
			GL11.glTranslatef(-0.8F, 0.9F-temp, -0.1F);	//translate model to fit in the hand of the player
			wandmodel.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
					0.0625F, mc, wand);
			GL11.glPopMatrix(); //Stop gl rendering for this section
			break;

		case EQUIPPED_FIRST_PERSON:

//first person render
			GL11.glPushMatrix();
			scale = 0.85F;
            GL11.glScalef(scale, scale, scale);
			GL11.glRotatef(0F, 1.0f, 0.0f, 0.0f);
			GL11.glRotatef(-5F, 0.0f, 1.0f, 0.0f);
			GL11.glRotatef(-150F, 0.0f, 0.0f, 1.0f);
			GL11.glTranslatef(-0.8F, 0.9F-temp, -0.1F);
			wandmodel.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
					0.0625F, mc, wand);
			GL11.glPopMatrix();
			break;

		case ENTITY: //render as a item on the ground
			GL11.glPushMatrix();
			scale = 0.85F;
			GL11.glScalef(scale, scale, scale);
			GL11.glRotatef(90F, 1.0f, 0.0f, 0.0f);
			GL11.glRotatef(0F, 0.0f, 1.0f, 0.0f);
			GL11.glRotatef(45F, 0.0f, 0.0f, 1.0f);
			GL11.glTranslatef(-0.2F, 1F-temp, 0F);
			wandmodel.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
					0.0625F, mc, wand);
			GL11.glPopMatrix();
			break;

		case INVENTORY: //render in the inventory
			GL11.glPushMatrix();
			scale = 0.85F;
			GL11.glScalef(scale, scale, scale);

			GL11.glRotatef(200F, 1.0f, 0.0f, 0.0f);
			GL11.glRotatef(-80F, 0.0f, 1.0f, 0.0f);
			GL11.glTranslatef(0.0F, 1.2F-temp, 0F);
			wandmodel.render((Entity) mc.thePlayer, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
                    0.0625F, mc, wand);
			GL11.glPopMatrix();
			break;

		default:
			break;
		}
	}
@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {

		switch (type) {
		case INVENTORY:
			return true;
		default:
			break;
		}
		return false;

	}

}
