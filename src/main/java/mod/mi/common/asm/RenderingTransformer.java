package mod.mi.common.asm;

import net.minecraft.launchwrapper.IClassTransformer;

import java.util.logging.Logger;

/**
 * Created by TOM-PC on 29/03/2016.
 */
public class RenderingTransformer implements IClassTransformer
{

    public static Logger logger = Logger.getLogger("-MechInte Core-");

    private static final String SRG_CLASS = "net/minecraft/client/renderer/BlockRendererDispatcher";
    private static final String OBF_CLASS = "boc";

    private static final String MCP_METHOD = "renderBlock";
    private static final String SRG_METHOD = "func_175018_a";

    public RenderingTransformer(){
        logger.finest("Rendering Transformer Created...");
    }

    @Override public byte[] transform(String s, String s1, byte[] bytes)
    {
        return new byte[0];
    }
}
