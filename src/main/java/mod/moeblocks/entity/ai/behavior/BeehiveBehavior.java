package mod.moeblocks.entity.ai.behavior;

import mod.moeblocks.entity.MoeEntity;
import mod.moeblocks.entity.util.Behaviors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.util.DamageSource;

import java.util.ArrayList;
import java.util.List;

public class BeehiveBehavior extends BasicBehavior {
    protected AttackGoal attackGoalBees;

    @Override
    public void start() {
        this.attackGoalBees = new AttackGoal(this.moe);
        this.moe.goalSelector.addGoal(2, this.attackGoalBees);
        this.moe.goalSelector.removeGoal(this.moe.attackGoal);
    }

    @Override
    public void stop() {
        this.moe.goalSelector.removeGoal(this.attackGoalBees);
        this.moe.goalSelector.addGoal(2, this.moe.attackGoal);
    }

    @Override
    public boolean isArmed() {
        return true;
    }

    @Override
    public Behaviors getKey() {
        return Behaviors.BEEHIVE;
    }

    static class AttackGoal extends Goal {
        private final MoeEntity moe;
        private final List<BeeEntity> bees = new ArrayList<>();

        public AttackGoal(MoeEntity moe) {
            super();
            this.moe = moe;
        }

        @Override
        public boolean shouldExecute() {
            return this.moe.canBeTarget(this.moe.getAttackTarget());
        }

        @Override
        public void startExecuting() {
            int totalBees = this.getBeeCountFrom(this.moe.getAttackTarget());
            for (int i = 0; i < totalBees; ++i) {
                this.bees.add(this.spawnBeeFrom(this.moe));
            }
        }

        public BeeEntity spawnBeeFrom(MobEntity entity) {
            BeeEntity bee = new BeeEntity(EntityType.BEE, entity.world);
            bee.setPositionAndRotation(entity.getPosX(), entity.getPosYEye(), entity.getPosZ(), entity.rotationYaw, entity.rotationPitch);
            entity.world.addEntity(bee);
            this.setToAttack(bee, entity.getAttackTarget());
            return bee;
        }

        public void setToAttack(BeeEntity bee, LivingEntity entity) {
            bee.setAngerTarget(entity.getUniqueID());
            bee.setAttackTarget(entity);
        }

        public int getBeeCountFrom(LivingEntity entity) {
            return (int) (Math.min(entity.getHealth() / 3 * (1.0F + this.moe.world.rand.nextFloat()), 30));
        }

        @Override
        public void resetTask() {
            this.bees.forEach(bee -> bee.attackEntityFrom(DamageSource.OUT_OF_WORLD, bee.getHealth()));
            this.bees.clear();
        }

        @Override
        public void tick() {
            ArrayList<BeeEntity> bees = new ArrayList<>();
            int adjustedBeeCount = Math.max(this.getBeeCountFrom(this.moe.getAttackTarget()) - this.bees.size(), 0);
            for (int i = 0; i < adjustedBeeCount; ++i) {
                bees.add(this.spawnBeeFrom(this.moe));
            }
            this.bees.forEach(bee -> {
                if (bee.hasStung() && bee.isAlive()) {
                    this.moe.heal(bee.getHealth());
                    bees.add(this.spawnBeeFrom(bee));
                    bee.remove();
                } else {
                    this.setToAttack(bee, this.moe.getAttackTarget());
                }
            });
            bees.forEach(bee -> this.bees.add(bee));
            bees.clear();
        }
    }
}
