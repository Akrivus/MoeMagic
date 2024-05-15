package block_party.blocks;

import block_party.client.particle.SakuraParticle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;
import java.util.function.Supplier;

public class GinkgoLeavesBlock extends LeavesBlock {
    private final Supplier<SimpleParticleType> particle;

    public GinkgoLeavesBlock(Supplier<SimpleParticleType> particle, Properties properties) {
        super(properties.isValidSpawn((state, reader, pos, entity) -> false).isSuffocating((state, reader, pos) -> false).isViewBlocking((state, reader, pos) -> false));
        this.particle = particle;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);
        SakuraParticle.add(this.particle, level, pos, random);
    }
}
