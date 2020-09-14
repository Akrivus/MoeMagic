package moe.blocks.mod.data.dating;

import moe.blocks.mod.data.conversation.Reactions;

public enum Interactions {
    HEADPAT(2.0F, 6000, Reactions.RELAX),
    NEUTRAL_GIFT(3.0F, 8000, Reactions.NONE),
    GOOD_GIFT(4.0F, 18000, Reactions.NONE),
    SAVED_LIFE(5.0F, 24000, Reactions.NONE);

    public final Reactions reaction;
    private final float affection;
    private final int cooldown;

    Interactions(float affection, int cooldown, Reactions reaction) {
        this.affection = affection;
        this.cooldown = cooldown;
        this.reaction = reaction;
    }

    public float getAffection() {
        return this.affection;
    }

    public int getCooldown() {
        return this.cooldown;
    }
}