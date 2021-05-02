package net.lazackna.morefluids.setup;

import net.lazackna.morefluids.objects.fluids.FluidMilk;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.tags.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;

import java.util.List;

public class FluidSetup {



    public static final FluidMilk milk = null;
    public static final FluidMilk milk_flowing = null;



    public static void register () {

        milk = Registration.FLUIDS.register("milk_still", () -> );



    }

}
