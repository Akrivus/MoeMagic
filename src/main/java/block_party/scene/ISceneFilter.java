package block_party.scene;

import block_party.entities.BlockPartyNPC;
import block_party.registry.SceneFilters;
import block_party.utils.JsonUtils;
import com.google.common.collect.ImmutableList;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public interface ISceneFilter {
    boolean verify(BlockPartyNPC npc);

    static List<ISceneFilter> parseArray(JsonArray array) {
        ImmutableList.Builder<ISceneFilter> filters = ImmutableList.builder();
        for (int i = 0; i < array.size(); ++i) {
            JsonElement member = array.get(i);
            ResourceLocation location = null;
            if (member.isJsonObject()) { location = JsonUtils.getAsResourceLocation(member.getAsJsonObject(), "type"); }
            if (member.isJsonPrimitive()) { location = new ResourceLocation(member.getAsString()); }
            if (location == null) { continue; }
            ISceneFilter filter = JsonUtils.<SceneFilters.Builder>getAs(JsonUtils.SCENE_FILTER, location).build();
            if (member.isJsonObject()) { filter.parse(member.getAsJsonObject().getAsJsonObject("filter")); }
            filters.add(filter);
        }
        return filters.build();
    }

    default void parse(JsonObject json) { }
}
