package net.lazackna.morefluids.objects.fluids;

import net.lazackna.morefluids.setup.FluidSetup;
import net.lazackna.morefluids.setup.ItemSetup;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class FluidMilk extends FlowingFluid {
    @Override
    public Fluid getFlowing() {
        return FluidSetup.flowing_milk;
    }

    @Override
    public Fluid getSource() {
        return FluidSetup.milk;
    }

    @Override
    protected boolean canConvertToSource() {
        return false;
    }

    @Override
    protected void beforeDestroyingBlock(IWorld p_205580_1_, BlockPos p_205580_2_, BlockState p_205580_3_) {

    }

    @Override
    protected int getSlopeFindDistance(IWorldReader p_185698_1_) {
        return 4;
    }

    @Override
    protected int getDropOff(IWorldReader p_204528_1_) {
        return 5;
    }

    @Override
    public Item getBucket() {
        return ItemSetup.MILK_BUCKET.get();
    }

    @Override
    protected boolean canBeReplacedWith(FluidState p_215665_1_, IBlockReader p_215665_2_, BlockPos p_215665_3_, Fluid p_215665_4_, Direction p_215665_5_) {
        return false;
    }

    @Override
    public int getTickDelay(IWorldReader p_205569_1_) {
        return 0;
    }

    @Override
    protected float getExplosionResistance() {
        return 0;
    }

    @Override
    protected BlockState createLegacyBlock(FluidState p_204527_1_) {
        return null;
    }

    @Override
    public boolean isSource(FluidState p_207193_1_) {
        return false;
    }

    @Override
    public int getAmount(FluidState p_207192_1_) {
        return 0;
    }
}
