package moeblocks.item;

import moeblocks.MoeMod;
import moeblocks.init.MoeMessages;
import moeblocks.init.MoeWorldData;
import moeblocks.message.SOpenCellPhone;
import moeblocks.util.sort.ISortableItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.List;
import java.util.UUID;

public class CellPhoneItem extends Item implements ISortableItem {
    public CellPhoneItem() {
        super(new Properties().group(MoeMod.ITEMS));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        if (world.isRemote()) { return ActionResult.resultPass(player.getHeldItem(hand)); }
        List<UUID> npcs = MoeWorldData.get(player.world).getFrom(player);
        MoeMessages.send(player, new SOpenCellPhone(npcs, hand));
        return ActionResult.resultSuccess(player.getHeldItem(hand));
    }

    @Override
    public int getSortOrder() {
        return 10;
    }
}
