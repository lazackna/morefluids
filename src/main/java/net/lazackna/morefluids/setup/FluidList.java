package net.lazackna.morefluids.setup;

import net.lazackna.morefluids.objects.blocks.FluidMilkBlock;
import net.lazackna.morefluids.objects.fluids.FluidMilk;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.potion.Effect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;


public class FluidList {

    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static RegistryObject<FluidMilk.Source> MILK_SOURCE;
    public static RegistryObject<FluidMilk.Flowing> MILK_FLOWING;
    public static RegistryObject<FluidMilkBlock> MILK_BLOCK;

    public static ForgeFlowingFluid.Properties OIL_PROPERTIES;


    public static void register () {
        Biomes
        // The color is in hex.

        for(Effect e : ForgeRegistries.POTIONS.getValues()) {
            int color = e.getColor();
        }
        OIL_PROPERTIES = new ForgeFlowingFluid.Properties(
                () -> MILK_SOURCE.get(), () -> MILK_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
                .density(15).luminosity(2).viscosity(5).sound(SoundEvents.HONEY_DRINK).overlay(WATER_OVERLAY_RL)
                .color(0xbffed0d0)).slopeFindDistance(2).levelDecreasePerBlock(2)
                .block(() -> FluidList.MILK_BLOCK.get()).bucket(() -> ItemList.MILK_BUCKET.get());

        MILK_SOURCE = Registration.FLUIDS.register("milk_still", () -> new FluidMilk.Source(OIL_PROPERTIES));
        MILK_FLOWING = Registration.FLUIDS.register("milk_flowing", () -> new FluidMilk.Flowing(OIL_PROPERTIES));
        MILK_BLOCK = Registration.BLOCKS.register("milk",
                () -> new FluidMilkBlock(() ->FluidList.MILK_SOURCE.get(), AbstractBlock.Properties.of(Material.WATER).noCollission().noDrops()
                ));
    }
}
