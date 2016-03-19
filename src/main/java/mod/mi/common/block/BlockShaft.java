package mod.mi.common.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockShaft extends BlockContainer
{

	public BlockShaft()
	{
		super(Material.wood);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return null;
	}

}
