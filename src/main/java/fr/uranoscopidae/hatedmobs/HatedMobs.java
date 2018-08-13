package fr.uranoscopidae.hatedmobs;

import fr.uranoscopidae.hatedmobs.common.*;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.apache.logging.log4j.Logger;

@Mod(modid = HatedMobs.MODID, name = "Hated Mobs", version = "1.0", acceptedMinecraftVersions = "1.12.2")
public class HatedMobs
{
    public static final String MODID = "hatedmobs";
    @Mod.Instance(HatedMobs.MODID)
    public static HatedMobs instance;
    @SidedProxy(clientSide = "fr.uranoscopidae.hatedmobs.client.MosquitoClientProxy", serverSide = "fr.uranoscopidae.hatedmobs.server.MosquitoServerProxy")
    public static MosquitoCommonProxy proxy;
    public static Logger logger;
    public static final CreativeTabs TAB = new CreativeTabs(MODID)
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(SWATTER);
        }
    };

    public static final Block NET = new BlockNet();
    public static final Item SWATTER = new ItemSwatter();
    public static final Block WEB_BLOCK = new BlockWeb();
    public static final Block EGG_SACK = new BlockEggSack();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new RegistryHandler());
        logger = event.getModLog();
        proxy.preInit(event.getSuggestedConfigurationFile());
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
    }
}