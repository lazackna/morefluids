package net.lazackna.morefluids.objects.fluids;

import net.lazackna.morefluids.setup.FluidSetup;
import net.lazackna.morefluids.setup.ItemSetup;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.Item;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.Tag;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class FluidMilk extends FlowingFluid {


    @Override
    public Fluid getFlowing() {
        return FluidSetup.milk_flowing;
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
    protected void beforeDestroyingBlock(IWorld world, BlockPos pos, BlockState state) {
        TileEntity tileentity = state.hasTileEntity() ? world.getBlockEntity(pos) : null;
        Block.dropResources(state, world, pos, tileentity);
    }

    @Override
    protected int getSlopeFindDistance(IWorldReader p_185698_1_) {
        return 4;
    }

    @Override
    protected int getDropOff(IWorldReader p_204528_1_) {
        return 1;
    }

    @Override
    public Item getBucket() {
        return ItemSetup.MILK_BUCKET.get();
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state, IBlockReader blockReader, BlockPos pos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN && !fluid.is(FluidTags.WATER);
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

    @Override
    public Fluid getFluid() {
        return null;
    }

    @Override
    public boolean isEntityInside(FluidState state, IWorldReader world, BlockPos pos, Entity entity, double yToTest, Tag<Fluid> tag, boolean testingHead) {
        return false;
    }
}
