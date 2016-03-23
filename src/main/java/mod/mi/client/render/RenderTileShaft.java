package mod.mi.client.render;

import mod.mi.common.tile.TileShaft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.animation.FastTESR;

public class RenderTileShaft extends FastTESR<TileShaft>
{

	public static final ResourceLocation tex = new ResourceLocation("mi", "textures/blocks/blockShaft.png");

	private void renderShaft(VertexBuffer buff)
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(tex);
		float scale = 1F / 16.0F;

		buff.pos(0.3125, 0, 0.3125).tex(scale * 0, scale * 0).endVertex();
		buff.pos(0.6875, 0, 0.3125).tex(scale * 5, scale * 0).endVertex();
		buff.pos(0.6875, 1, 0.3125).tex(scale * 5, scale * 16).endVertex();
		buff.pos(0.3125, 1, 0.3125).tex(scale * 0, scale * 16).endVertex();

		buff.pos(0.3125, 0, 0.6875).tex(scale * 0, scale * 0).endVertex();
		buff.pos(0.6875, 0, 0.6875).tex(scale * 5, scale * 0).endVertex();
		buff.pos(0.6875, 1, 0.6875).tex(scale * 5, scale * 16).endVertex();
		buff.pos(0.3125, 1, 0.6875).tex(scale * 0, scale * 16).endVertex();

		buff.pos(0.3125, 0, 0.3125).tex(scale * 0, scale * 0).endVertex();
		buff.pos(0.3125, 0, 0.6875).tex(scale * 5, scale * 0).endVertex();
		buff.pos(0.3125, 1, 0.6875).tex(scale * 5, scale * 16).endVertex();
		buff.pos(0.3125, 1, 0.3125).tex(scale * 0, scale * 16).endVertex();

		buff.pos(0.6875, 0, 0.3125).tex(scale * 0, scale * 0).endVertex();
		buff.pos(0.6875, 0, 0.6875).tex(scale * 5, scale * 0).endVertex();
		buff.pos(0.6875, 1, 0.6875).tex(scale * 5, scale * 16).endVertex();
		buff.pos(0.6875, 1, 0.3125).tex(scale * 0, scale * 16).endVertex();

		buff.pos(0.6875, 0, 0.3125).tex(scale * 5, scale * 0).endVertex();
		buff.pos(0.6875, 0, 0.6875).tex(scale * 10, scale * 0).endVertex();
		buff.pos(0.3125, 0, 0.6875).tex(scale * 10, scale * 5).endVertex();
		buff.pos(0.3125, 0, 0.3125).tex(scale * 5, scale * 5).endVertex();

		buff.pos(0.6875, 1, 0.3125).tex(scale * 5, scale * 0).endVertex();
		buff.pos(0.6875, 1, 0.6875).tex(scale * 10, scale * 0).endVertex();
		buff.pos(0.3125, 1, 0.6875).tex(scale * 10, scale * 5).endVertex();
		buff.pos(0.3125, 1, 0.3125).tex(scale * 5, scale * 5).endVertex();

	}

	@Override
	public void renderTileEntityFast(TileShaft te, double x, double y, double z, float partialTicks, int destroyStage, VertexBuffer vertexBuffer)
	{
		GlStateManager.pushMatrix();
		//GlStateManager.translate(x, y, z);
		renderShaft(vertexBuffer);
		GlStateManager.popMatrix();
	}

}
