package moeblocks.client.animation;

import moeblocks.entity.AbstractNPCEntity;

public abstract class ActionAnimationState extends AnimationState {
    protected int timeUntilComplete;

    @Override
    public boolean canApply(AbstractNPCEntity applicant) {
        return true;
    }

    @Override
    public void apply(AbstractNPCEntity applicant) {
        this.timeUntilComplete = this.getInterval();
    }

    @Override
    public boolean canClear(AbstractNPCEntity applicant) {
        return --this.timeUntilComplete < 0;
    }

    @Override
    public void clear(AbstractNPCEntity applicant) {

    }

    public abstract int getInterval();
}
