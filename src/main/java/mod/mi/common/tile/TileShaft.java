package mod.mi.common.tile;

import mod.mi.common.mechanical.MechanicalNode;
import net.minecraft.nbt.NBTTagCompound;

public class TileShaft extends TileMechanical
{

	@Override
	public void update()
	{
		this.node.update();
	}

	@Override
	public void createNode()
	{
		if (this.node == null)
			this.node = new MechanicalNode(this);
	}

	@Override
	public void writeNBT(NBTTagCompound nbt)
	{
		this.node.writeNBT(nbt);
	}

	@Override
	public void readNBT(NBTTagCompound nbt)
	{
		this.node.readNBT(nbt);
	}

}
