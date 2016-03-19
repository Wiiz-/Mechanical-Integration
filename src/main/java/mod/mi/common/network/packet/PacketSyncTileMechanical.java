package mod.mi.common.network.packet;

import io.netty.buffer.ByteBuf;
import mod.mi.common.tile.TileMechanical;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PacketSyncTileMechanical implements IMessage, IMessageHandler<PacketSyncTileMechanical, IMessage>
{
	private BlockPos pos;
	private NBTTagCompound nbt;

	public PacketSyncTileMechanical()
	{
	}

	public PacketSyncTileMechanical(TileEntity tile)
	{
		this.nbt = tile.getTileData();
		this.pos = tile.getPos();
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		int x = buf.readInt();
		int y = buf.readInt();
		int z = buf.readInt();
		this.pos = new BlockPos(x, y, z);
		this.nbt = ByteBufUtils.readTag(buf);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(this.pos.getX());
		buf.writeInt(this.pos.getY());
		buf.writeInt(this.pos.getZ());
		ByteBufUtils.writeTag(buf, this.nbt);
	}

	@Override
	public IMessage onMessage(final PacketSyncTileMechanical message, final MessageContext ctx)
	{
		if (ctx.side == Side.CLIENT)
		{
			IThreadListener thread = Minecraft.getMinecraft();
			thread.addScheduledTask(new Runnable()
			{
				@Override
				public void run()
				{
					World world = Minecraft.getMinecraft().theWorld;
					if (world.getTileEntity(message.pos) instanceof TileMechanical)
					{
						((TileMechanical) world.getTileEntity(message.pos)).readFromNBT(message.nbt);
					}
				}
			});
		}
		else if (ctx.side == Side.SERVER)
		{
			IThreadListener thread = (WorldServer) ctx.getServerHandler().playerEntity.worldObj;
			thread.addScheduledTask(new Runnable()
			{
				@Override
				public void run()
				{
					World world = ctx.getServerHandler().playerEntity.worldObj;
					if (world.getTileEntity(message.pos) instanceof TileMechanical)
					{
						((TileMechanical) world.getTileEntity(message.pos)).readFromNBT(message.nbt);
					}
				}
			});
		}

		return null;
	}

}
