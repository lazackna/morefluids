package net.lazackna.morefluids.setup;

import net.lazackna.morefluids.objects.fluids.FluidMilk;
import net.lazackna.morefluids.objects.fluids.Test;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.*;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.tags.*;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;

import java.util.List;

public class FluidList {



    public static final RegistryObject<FlowingFluid> MILK_SOURCE = Registration.FLUIDS.register("milk_still", FluidMilk.Source::new);
    public static final RegistryObject<FlowingFluid> MILK_FLOWING = Registration.FLUIDS.register("milk_flowing", FluidMilk.Flowing::new);
    public static final FlowingFluidBlock MILK = new FlowingFluidBlock(FluidList.MILK_SOURCE, AbstractBlock.Properties.of(new Material.Builder(MaterialColor.WATER).noCollider().nonSolid().replaceable().liquid().build()));

    public static void register () {

        Registration.BLOCKS.register("milk", () -> MILK);

//        milk = Registration.FLUIDS.register("milk_still", () -> );




    }


}
