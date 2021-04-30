package net.lazackna.morefluids;

import net.lazackna.morefluids.setup.Registration;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.MilkBucketItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Main.MOD_ID)
public class Main
{
    public static Main instance;
    public static final String MOD_ID = "morefluids";
    public static final Logger LOGGER = LogManager.getLogger();

    public Main() {

        Registration.register();
        instance = this;

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onServerStarting);

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup (final FMLCommonSetupEvent event) {

    }

    private void clientSetup (final FMLClientSetupEvent event) {

    }

    private void onServerStarting (final FMLServerStartingEvent event) {

    }


}
