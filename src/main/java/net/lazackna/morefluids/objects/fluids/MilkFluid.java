package net.lazackna.morefluids.objects.fluids;

import net.lazackna.morefluids.setup.FluidList;
import net.lazackna.morefluids.setup.ItemList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.Tag;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import javax.annotation.Nullable;
import java.util.Random;

public class MilkFluid extends ForgeFlowingFluid {
    protected MilkFluid(Properties properties) {
        super(properties);
    }

    public Fluid getFlowing() {
        return FluidList.MILK_FLOWING.get();

    }

    public Fluid getSource() {
        return FluidList.MILK_SOURCE.get();
    }

    public Item getBucket() {
        return ItemList.MILK_BUCKET.get();
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(World p_204522_1_, BlockPos p_204522_2_, FluidState p_204522_3_, Random p_204522_4_) {
        if (!p_204522_3_.isSource() && !p_204522_3_.getValue(FALLING)) {
            if (p_204522_4_.nextInt(64) == 0) {
                p_204522_1_.playLocalSound((double)p_204522_2_.getX() + 0.5D, (double)p_204522_2_.getY() + 0.5D, (double)p_204522_2_.getZ() + 0.5D, SoundEvents.WATER_AMBIENT, SoundCategory.BLOCKS, p_204522_4_.nextFloat() * 0.25F + 0.75F, p_204522_4_.nextFloat() + 0.5F, false);
            }

        } else if (p_204522_4_.nextInt(10) == 0) {
            p_204522_1_.addParticle(ParticleTypes.UNDERWATER, (double)p_204522_2_.getX() + p_204522_4_.nextDouble(), (double)p_204522_2_.getY() + p_204522_4_.nextDouble(), (double)p_204522_2_.getZ() + p_204522_4_.nextDouble(), 0.0D, 0.0D, 0.0D);
        }

    }



    @Nullable
    @OnlyIn(Dist.CLIENT)
    public IParticleData getDripParticle() {
        return ParticleTypes.DRIPPING_WATER;
    }

    protected boolean canConvertToSource() {
        return true;
    }

    protected void beforeDestroyingBlock(IWorld p_205580_1_, BlockPos p_205580_2_, BlockState p_205580_3_) {
        TileEntity tileentity = p_205580_3_.hasTileEntity() ? p_205580_1_.getBlockEntity(p_205580_2_) : null;
        Block.dropResources(p_205580_3_, p_205580_1_, p_205580_2_, tileentity);
    }

    public int getSlopeFindDistance(IWorldReader p_185698_1_) {
        return 4;
    }

    public BlockState createLegacyBlock(FluidState p_204527_1_) {
        //return Blocks.WATER.defaultBlockState().setValue(FlowingFluidBlock.LEVEL, Integer.valueOf(getLegacyLevel(p_204527_1_)));
        return FluidList.MILK_BLOCK.get().defaultBlockState().setValue(FlowingFluidBlock.LEVEL, Integer.valueOf(getLegacyLevel(p_204527_1_)));
    }

    @Override
    public boolean isSource(FluidState p_207193_1_) {
        return false;
    }

    @Override
    public int getAmount(FluidState p_207192_1_) {
        return 1;
    }

    public boolean isSame(Fluid p_207187_1_) {
        return p_207187_1_ == FluidList.MILK_SOURCE.get()|| p_207187_1_ == FluidList.MILK_FLOWING.get();
    }

    public int getDropOff(IWorldReader p_204528_1_) {
        return 1;
    }

    public int getTickDelay(IWorldReader p_205569_1_) {
        return 5;
    }

    public boolean canBeReplacedWith(FluidState p_215665_1_, IBlockReader p_215665_2_, BlockPos p_215665_3_, Fluid p_215665_4_, Direction p_215665_5_) {
        return p_215665_5_ == Direction.DOWN;
    }

    @Override
    public boolean isEntityInside(FluidState state, IWorldReader world, BlockPos pos, Entity entity, double yToTest, Tag<Fluid> tag, boolean testingHead) {
        return false;
    }

    public static class Source extends MilkFluid {
        public Source(Properties properties) {
            super(properties);
        }

        protected void createFluidStateDefinition(StateContainer.Builder<Fluid, FluidState> p_207184_1_) {
            super.createFluidStateDefinition(p_207184_1_);
            p_207184_1_.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState p_207192_1_) {
            return 8;
        }

        @Override
        public boolean isSource(FluidState p_207193_1_) {
            return true;
        }

        @Override
        public Fluid getSource() {
            return super.getSource();
        }
    }
    public static class Flowing extends MilkFluid {
        public Flowing(Properties properties) {
            super(properties);
        }

        protected void createFluidStateDefinition(StateContainer.Builder<Fluid, FluidState> p_207184_1_) {
            super.createFluidStateDefinition(p_207184_1_);
            p_207184_1_.add(LEVEL);
        }

        @Override
        public boolean isSource(FluidState p_207193_1_) {
            return false;
        }

        @Override
        public Fluid getSource() {
            return super.getSource();
        }
    }
}
