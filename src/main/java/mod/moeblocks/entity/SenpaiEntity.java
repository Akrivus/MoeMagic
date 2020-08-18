package mod.moeblocks.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class SenpaiEntity extends StateEntity {
    public SenpaiEntity(EntityType<? extends CreatureEntity> type, World world) {
        super(type, world);
    }

    @Override
    public ITextComponent getCustomName() {
        String translation = String.format("entity.moeblocks.senpai.%s", this.getDere().toString().toLowerCase());
        TranslationTextComponent component = new TranslationTextComponent(translation);
        return component;
    }
}
