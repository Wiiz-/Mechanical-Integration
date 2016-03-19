package mod.mi.common.mechanical;

import mod.mi.common.network.PacketHandler;
import mod.mi.common.network.packet.PacketSyncTileMechanical;
import mod.mi.common.tile.TileMechanical;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;

/**
 * 
 * Controls each mechanical node on network - we special case shafts as they act
 * differently to other nodes as they work along axis's
 *
 */
public class MechanicalNode
{

	public TileMechanical tile;
	// Connected sides - shafts can only have opposite connections
	public EnumFacing[] conns = new EnumFacing[6];
	private MechanicalNetwork network;

	private boolean isShaft = false;
	private boolean firstTick = true;

	public MechanicalNode(TileMechanical tile)
	{
		this(tile, false);
	}

	public MechanicalNode(TileMechanical tile, boolean isShaft)
	{
		this.tile = tile;
		this.isShaft = isShaft;
	}

	public void update()
	{
		if (firstTick)
		{
			// --Network--
			firstTick = false;
		}
	}

	public void writeNBT(NBTTagCompound nbt)
	{
	}

	public void readNBT(NBTTagCompound nbt)
	{
	}

	public void sync()
	{
		PacketHandler.sendToAll(new PacketSyncTileMechanical(this.tile));
	}

	public MechanicalNetwork getNetwork()
	{
		return this.network;
	}

	public void setNetwork(MechanicalNetwork network)
	{
		this.network = network;
	}

	public boolean isShaft()
	{
		return this.isShaft;
	}

}
