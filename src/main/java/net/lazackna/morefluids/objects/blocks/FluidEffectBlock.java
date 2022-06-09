package net.lazackna.morefluids.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class FluidEffectBlock extends FlowingFluidBlock {
    public FluidEffectBlock(Supplier<? extends FlowingFluid> supplier, Properties p_i48368_1_) {
        super(supplier, p_i48368_1_);
    }

    @Override
    public void entityInside(BlockState p_196262_1_, World p_196262_2_, BlockPos p_196262_3_, Entity p_196262_4_) {
        Block b = p_196262_1_.getBlock();
        FluidState state = p_196262_1_.getFluidState();
        if(state != null) {
            state.isEntityInside(p_196262_2_, p_196262_3_, p_196262_4_, p_196262_3_.getY() , null, false);
        }

        super.entityInside(p_196262_1_, p_196262_2_, p_196262_3_, p_196262_4_);
    }
}
