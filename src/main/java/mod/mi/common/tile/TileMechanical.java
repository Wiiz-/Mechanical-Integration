package mod.mi.common.tile;

import mod.mi.common.mechanical.IMechanical;
import mod.mi.common.mechanical.MechanicalNode;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public abstract class TileMechanical extends TileEntity implements ITickable, IMechanical
{

	public MechanicalNode node;

	/**
	 * Called both client and server side
	 */
	@Override
	public abstract void update();

	public abstract void writeNBT(NBTTagCompound nbt);

	public abstract void readNBT(NBTTagCompound nbt);
	
	public abstract void createNode();

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		writeNBT(compound);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		readNBT(compound);
	}

	@Override
	public MechanicalNode getNode()
	{
		return this.node;
	}

	@Override
	public void setNode(MechanicalNode node)
	{
		this.node = node;
	}

	// Network
	@Override
	public Packet<?> getDescriptionPacket()
	{
		NBTTagCompound nbt = new NBTTagCompound();
		writeToNBT(nbt);
		return new SPacketUpdateTileEntity(this.pos, -1, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt)
	{
		readFromNBT(pkt.getNbtCompound());
	}

}
