package mod.mi.common.asm;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

@IFMLLoadingPlugin.TransformerExclusions({"mod.mi.common.asm.", "mod.mi.common.asm.CoreLoader"})
@IFMLLoadingPlugin.SortingIndex(Integer.MAX_VALUE)
@IFMLLoadingPlugin.MCVersion("1.9")
public class CoreLoader implements IFMLLoadingPlugin
{
    @Override public String[] getASMTransformerClass()
    {
        return new String[] {RenderingTransformer.class.getName()};
    }

    @Override public String getModContainerClass()
    {
        return null;
    }

    @Override public String getSetupClass()
    {
        return null;
    }

    @Override public void injectData(Map<String, Object> data)
    {

    }

    @Override public String getAccessTransformerClass()
    {
        return null;
    }
}
