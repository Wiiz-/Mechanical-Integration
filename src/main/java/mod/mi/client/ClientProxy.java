package mod.mi.client;

import mod.mi.client.render.RenderTileShaft;
import mod.mi.common.CommonProxy;
import mod.mi.common.tile.TileShaft;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy
{

	@Override
	public void registerRenders()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileShaft.class, new RenderTileShaft());
	}
	
}
