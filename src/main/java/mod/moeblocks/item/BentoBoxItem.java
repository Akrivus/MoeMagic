package mod.moeblocks.item;

import mod.moeblocks.register.ItemsMoe;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class BentoBoxItem extends Item {
    public static final Food FOOD = new Food.Builder().hunger(11).saturation(1.9F).build();

    public BentoBoxItem() {
        super(new Properties().group(ItemsMoe.Group.INSTANCE).food(FOOD));
    }
}
