package mod.mi.common;

import mod.mi.common.block.BlockShaft;
import mod.mi.common.tile.TileShaft;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy
{

	public Block blockShaft;
	
	public void registerBlocks()
	{
		blockShaft = new BlockShaft();
		
		GameRegistry.registerBlock(blockShaft, "mi_blockShaft");
		
		GameRegistry.registerTileEntity(TileShaft.class, "mi_tileShaft");
	}

	//Client proxy only
	public void registerRenders()
	{

	}

}
