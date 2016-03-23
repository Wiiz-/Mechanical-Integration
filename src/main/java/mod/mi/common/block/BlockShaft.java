package mod.mi.common.block;

import mod.mi.common.tile.TileShaft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockShaft extends BlockContainer
{

	public BlockShaft()
	{
		super(Material.wood);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("mi_blockShaft");
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (!worldIn.isRemote)
			return false;

		if (worldIn.getTileEntity(pos) instanceof TileShaft)
			((TileShaft) worldIn.getTileEntity(pos)).onBlockActivated();

		return true;
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		if (worldIn.getTileEntity(pos) instanceof TileShaft)
			((TileShaft) worldIn.getTileEntity(pos)).onBlockPlaced((EntityPlayer) placer);
	}

	@Override
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
	{
		if (worldIn.getTileEntity(pos) instanceof TileShaft)
			((TileShaft) worldIn.getTileEntity(pos)).onNeighborChange();
	}

	@Override
	public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos)
	{
		return this.getActualState(state, world, pos);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	@Override
	public boolean isFullBlock(IBlockState state)
	{
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileShaft();
	}

}
