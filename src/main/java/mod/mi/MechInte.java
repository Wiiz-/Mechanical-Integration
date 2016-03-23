package mod.mi;

import mod.mi.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(name = MechInte.MOD_NAME, modid = MechInte.MOD_ID, version = MechInte.MOD_VER)
public class MechInte
{

    public static final String MOD_NAME = "Mechanical Integration";
    public static final String MOD_ID = "mi";
    public static final String MOD_VER = "0.0.1";

    public static final String COMMON_PROXY = "mod.mi.common.CommonProxy";
    public static final String CLIENT_PROXY = "mod.mi.client.ClientProxy";

    @Instance(MOD_ID)
    public static MechInte instance;

    @SidedProxy(serverSide = COMMON_PROXY, clientSide = CLIENT_PROXY)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.registerBlocks();
        proxy.registerRenders();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
}
