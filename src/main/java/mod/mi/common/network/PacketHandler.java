package mod.mi.common.network;

import mod.mi.MechInte;
import mod.mi.common.network.packet.PacketSyncTileMechanical;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler
{

	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(MechInte.MOD_ID);

	public static void init()
	{
		INSTANCE.registerMessage(PacketSyncTileMechanical.class, PacketSyncTileMechanical.class, 0, Side.CLIENT);
		INSTANCE.registerMessage(PacketSyncTileMechanical.class, PacketSyncTileMechanical.class, 1, Side.SERVER);
	}

	public static void sendToAll(IMessage message)
	{
		INSTANCE.sendToAll(message);
	}

	public static void sendToServer(IMessage message)
	{
		INSTANCE.sendToServer(message);
	}

}
