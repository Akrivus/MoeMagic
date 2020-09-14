package moe.blocks.mod.data.yearbook;

import moe.blocks.mod.data.dating.Relationship;
import moe.blocks.mod.entity.MoeEntity;
import moe.blocks.mod.entity.SenpaiEntity;
import moe.blocks.mod.entity.ai.BloodTypes;
import moe.blocks.mod.entity.ai.automata.state.Emotions;
import moe.blocks.mod.entity.partial.CharacterEntity;
import moe.blocks.mod.init.MoeEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.UUID;

public class Page {
    private final CompoundNBT character;
    private final float affection;
    private final float trust;
    private final UUID uuid;

    public Page(UUID uuid, INBT compound) {
        this.character = (CompoundNBT) compound;
        this.affection = this.character.getFloat("Affection");
        this.trust = this.character.getFloat("Trust");
        this.uuid = uuid;
    }

    public Page(CharacterEntity entity, Relationship relationship) {
        entity.writeWithoutSync(this.character = new CompoundNBT());
        this.affection = relationship.getAffection();
        this.trust = relationship.getTrust();
        this.uuid = entity.getUniqueID();
    }

    public CompoundNBT write() {
        CompoundNBT compound = this.character;
        compound.putFloat("Affection", this.affection);
        compound.putFloat("Trust", this.trust);
        return compound;
    }

    public CharacterEntity getCharacter(World world) {
        EntityType type = this.character.contains("BlockData") ? MoeEntities.MOE.get() : MoeEntities.SENPAI.get();
        CharacterEntity character = (CharacterEntity) type.create(world);
        character.isInYearbook = true;
        character.read(this.character);
        return character;
    }

    public float getAffection() {
        return this.affection;
    }

    public float getTrust() {
        return this.trust;
    }

    public UUID getUUID() {
        return this.uuid;
    }
}
