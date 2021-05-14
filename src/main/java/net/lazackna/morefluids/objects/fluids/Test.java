package net.lazackna.morefluids.objects.fluids;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.Food;
import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraft.tags.Tag;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.util.function.Supplier;

public class Test extends ForgeFlowingFluid {


    protected Test(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isSource(FluidState p_207193_1_) {
        return false;
    }

    @Override
    public int getAmount(FluidState p_207192_1_) {
        return 0;
    }

    @Override
    public Fluid getFluid() {
        return null;
    }

    @Override
    public boolean isEntityInside(FluidState state, IWorldReader world, BlockPos pos, Entity entity, double yToTest, Tag<Fluid> tag, boolean testingHead) {
        return false;
    }

    @Nullable
    @Override
    public Boolean isAABBInsideMaterial(FluidState state, IWorldReader world, BlockPos pos, AxisAlignedBB boundingBox, Material materialIn) {
        return null;
    }

    @Nullable
    @Override
    public Boolean isAABBInsideLiquid(FluidState state, IWorldReader world, BlockPos pos, AxisAlignedBB boundingBox) {
        return null;
    }

    @Override
    public float getExplosionResistance(FluidState state, IBlockReader world, BlockPos pos, Explosion explosion) {
        return 0;
    }
}
