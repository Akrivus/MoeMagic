package moe.blocks.mod.entity.ai.goal;

import moe.blocks.mod.entity.StudentEntity;
import moe.blocks.mod.init.MoeTags;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class MineGoal extends BreakGoal {

    public MineGoal(StudentEntity entity) {
        super(entity, 3);
    }

    @Override
    public boolean shouldExecute() {
        if (this.entity.isMiner()) {
            return super.shouldExecute();
        }
        return false;
    }

    @Override
    protected boolean canBreakBlock(BlockPos pos, BlockState state) {
        return state.getBlock().isIn(MoeTags.ORES);
    }
}
