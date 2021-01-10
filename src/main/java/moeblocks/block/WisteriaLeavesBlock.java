package moeblocks.block;

import moeblocks.init.MoeBlocks;
import moeblocks.init.MoeParticles;
import moeblocks.init.MoeTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.BlockVoxelShape;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class WisteriaLeavesBlock extends LeavesBlock {
    public WisteriaLeavesBlock(Properties properties) {
        super(properties.setLightLevel((state) -> 2).setAllowsSpawn((state, reader, pos, entity) -> false).setSuffocates((state, reader, pos) -> false).setBlocksVision((state, reader, pos) -> false));
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (super.ticksRandomly(state)) {
            super.randomTick(state, world, pos, random);
        } else if (world.isAirBlock(pos.down())) {
            world.setBlockState(pos.down(), MoeBlocks.WISTERIA_VINE_TIP.get().getDefaultState());
        }
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return true;
    }
}
