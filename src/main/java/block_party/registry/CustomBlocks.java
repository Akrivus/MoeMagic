package block_party.registry;

import block_party.BlockParty;
import block_party.blocks.*;
import block_party.blocks.grower.GinkgoTreeGrower;
import block_party.blocks.grower.SakuraTreeGrower;
import block_party.blocks.grower.WhiteSakuraTreeGrower;
import block_party.blocks.grower.WisteriaTreeGrower;
import block_party.scene.SceneObservation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CustomBlocks {
    public static final Supplier<Block> BLANK_HANGING_SCROLL = BlockParty.BLOCKS.register("blank_hanging_scroll", () -> new HangingScrollBlock(Prop.SHOJI.get(), SceneObservation.NEVER));
    public static final Supplier<Block> BLACK_PAPER_LANTERN = BlockParty.BLOCKS.register("black_paper_lantern", () -> new PaperLanternBlock(Prop.SHOJI.get(), MapColor.COLOR_BLACK));
    public static final Supplier<Block> DAWN_HANGING_SCROLL = BlockParty.BLOCKS.register("dawn_hanging_scroll", () -> new HangingScrollBlock(Prop.SHOJI.get(), SceneObservation.DAWN));
    public static final Supplier<Block> EVENING_HANGING_SCROLL = BlockParty.BLOCKS.register("evening_hanging_scroll", () -> new HangingScrollBlock(Prop.SHOJI.get(), SceneObservation.EVENING));
    public static final Supplier<Block> MIDNIGHT_HANGING_SCROLL = BlockParty.BLOCKS.register("midnight_hanging_scroll", () -> new HangingScrollBlock(Prop.SHOJI.get(), SceneObservation.MIDNIGHT));
    public static final Supplier<Block> MORNING_HANGING_SCROLL = BlockParty.BLOCKS.register("morning_hanging_scroll", () -> new HangingScrollBlock(Prop.SHOJI.get(), SceneObservation.MORNING));
    public static final Supplier<Block> NIGHT_HANGING_SCROLL = BlockParty.BLOCKS.register("night_hanging_scroll", () -> new HangingScrollBlock(Prop.SHOJI.get(), SceneObservation.NIGHT));
    public static final Supplier<Block> NOON_HANGING_SCROLL = BlockParty.BLOCKS.register("noon_hanging_scroll", () -> new HangingScrollBlock(Prop.SHOJI.get(), SceneObservation.NOON));
    public static final Supplier<Block> BLUE_PAPER_LANTERN = BlockParty.BLOCKS.register("blue_paper_lantern", () -> new PaperLanternBlock(Prop.SHOJI.get(), MapColor.TERRACOTTA_BLUE));
    public static final Supplier<Block> BROWN_PAPER_LANTERN = BlockParty.BLOCKS.register("brown_paper_lantern", () -> new PaperLanternBlock(Prop.SHOJI.get(), MapColor.TERRACOTTA_BROWN));
    public static final Supplier<Block> CYAN_PAPER_LANTERN = BlockParty.BLOCKS.register("cyan_paper_lantern", () -> new PaperLanternBlock(Prop.SHOJI.get(), MapColor.TERRACOTTA_CYAN));
    public static final Supplier<Block> GARDEN_LANTERN = BlockParty.BLOCKS.register("garden_lantern", () -> new GardenLanternBlock(Prop.STONE.get()));
    public static final Supplier<Block> GRAY_PAPER_LANTERN = BlockParty.BLOCKS.register("gray_paper_lantern", () -> new PaperLanternBlock(Prop.SHOJI.get(), MapColor.TERRACOTTA_GRAY));
    public static final Supplier<Block> GINKGO_BUTTON = BlockParty.BLOCKS.register("ginkgo_button", () -> new ButtonBlock(BlockSetType.OAK, 20, Prop.NONSOLID_GINKGO.get()));
    public static final Supplier<Block> GINKGO_FENCE = BlockParty.BLOCKS.register("ginkgo_fence", () -> new FenceBlock(Prop.NONSOLID_GINKGO.get()));
    public static final Supplier<Block> GINKGO_FENCE_GATE = BlockParty.BLOCKS.register("ginkgo_fence_gate", () -> new FenceGateBlock(WoodType.OAK, Prop.NONSOLID_GINKGO.get()));
    public static final Supplier<Block> GINKGO_LEAVES = BlockParty.BLOCKS.register("ginkgo_leaves", () -> new GinkgoLeavesBlock(CustomParticles.GINKGO, Prop.GINKGO_LEAVES.get()));
    public static final Supplier<Block> GINKGO_LOG = BlockParty.BLOCKS.register("ginkgo_log", () -> new RotatedPillarBlock(Prop.GINKGO.get()));
    public static final Supplier<Block> GINKGO_PLANKS = BlockParty.BLOCKS.register("ginkgo_planks", () -> new Block(Prop.GINKGO.get()));
    public static final Supplier<Block> GINKGO_PRESSURE_PLATE = BlockParty.BLOCKS.register("ginkgo_pressure_plate", () -> new PressurePlateBlock(BlockSetType.OAK, Prop.NONSOLID_GINKGO.get()));
    public static final Supplier<Block> GINKGO_SAPLING = BlockParty.BLOCKS.register("ginkgo_sapling", () -> new SaplingBlock(new GinkgoTreeGrower(), Prop.GINKGO_LEAVES.get()));
    public static final Supplier<Block> GINKGO_SLAB = BlockParty.BLOCKS.register("ginkgo_slab", () -> new SlabBlock(Prop.NONSOLID_GINKGO.get()));
    public static final Supplier<Block> GINKGO_STAIRS = BlockParty.BLOCKS.register("ginkgo_stairs", () -> new StairBlock(() -> GINKGO_PLANKS.get().defaultBlockState(), Prop.NONSOLID_GINKGO.get()));
    public static final Supplier<Block> GINKGO_WOOD = BlockParty.BLOCKS.register("ginkgo_wood", () -> new RotatedPillarBlock(Prop.GINKGO.get()));
    public static final Supplier<Block> GREEN_PAPER_LANTERN = BlockParty.BLOCKS.register("green_paper_lantern", () -> new PaperLanternBlock(Prop.SHOJI.get(), MapColor.TERRACOTTA_GREEN));
    public static final Supplier<Block> LIGHT_BLUE_PAPER_LANTERN = BlockParty.BLOCKS.register("light_blue_paper_lantern", () -> new PaperLanternBlock(Prop.SHOJI.get(), MapColor.TERRACOTTA_LIGHT_BLUE));
    public static final Supplier<Block> LIGHT_GRAY_PAPER_LANTERN = BlockParty.BLOCKS.register("light_gray_paper_lantern", () -> new PaperLanternBlock(Prop.SHOJI.get(), MapColor.TERRACOTTA_LIGHT_GRAY));
    public static final Supplier<Block> LIME_PAPER_LANTERN = BlockParty.BLOCKS.register("lime_paper_lantern", () -> new PaperLanternBlock(Prop.SHOJI.get(), MapColor.TERRACOTTA_LIGHT_GREEN));
    public static final Supplier<Block> MAGENTA_PAPER_LANTERN = BlockParty.BLOCKS.register("magenta_paper_lantern", () -> new PaperLanternBlock(Prop.SHOJI.get(), MapColor.TERRACOTTA_MAGENTA));
    public static final Supplier<Block> ORANGE_PAPER_LANTERN = BlockParty.BLOCKS.register("orange_paper_lantern", () -> new PaperLanternBlock(Prop.SHOJI.get(), MapColor.TERRACOTTA_ORANGE));
    public static final Supplier<Block> PINK_PAPER_LANTERN = BlockParty.BLOCKS.register("pink_paper_lantern", () -> new PaperLanternBlock(Prop.SHOJI.get(), MapColor.TERRACOTTA_PINK));
    public static final Supplier<Block> PURPLE_PAPER_LANTERN = BlockParty.BLOCKS.register("purple_paper_lantern", () -> new PaperLanternBlock(Prop.SHOJI.get(), MapColor.TERRACOTTA_PURPLE));
    public static final Supplier<Block> RED_PAPER_LANTERN = BlockParty.BLOCKS.register("red_paper_lantern", () -> new PaperLanternBlock(Prop.SHOJI.get(), MapColor.TERRACOTTA_RED));
    public static final Supplier<Block> SAKURA_BLOSSOMS = BlockParty.BLOCKS.register("sakura_blossoms", () -> new SakuraBlossomsBlock(CustomParticles.SAKURA, Prop.LEAVES.get()));
    public static final Supplier<Block> SAKURA_BUTTON = BlockParty.BLOCKS.register("sakura_button", () -> new ButtonBlock(BlockSetType.OAK, 20, Prop.NONSOLID.get()));
    public static final Supplier<Block> SAKURA_FENCE = BlockParty.BLOCKS.register("sakura_fence", () -> new FenceBlock(Prop.NONSOLID.get()));
    public static final Supplier<Block> SAKURA_FENCE_GATE = BlockParty.BLOCKS.register("sakura_fence_gate", () -> new FenceGateBlock(WoodType.OAK, Prop.NONSOLID.get()));
    public static final Supplier<Block> SAKURA_LOG = BlockParty.BLOCKS.register("sakura_log", () -> new RotatedPillarBlock(Prop.SOLID.get()));
    public static final Supplier<Block> SAKURA_PLANKS = BlockParty.BLOCKS.register("sakura_planks", () -> new Block(Prop.SOLID.get()));
    public static final Supplier<Block> SAKURA_PRESSURE_PLATE = BlockParty.BLOCKS.register("sakura_pressure_plate", () -> new PressurePlateBlock(BlockSetType.OAK, Prop.NONSOLID.get()));
    public static final Supplier<Block> SAKURA_SAPLING = BlockParty.BLOCKS.register("sakura_sapling", () -> new SaplingBlock(new SakuraTreeGrower(), Prop.PLANT.get()));
    public static final Supplier<Block> SAKURA_SLAB = BlockParty.BLOCKS.register("sakura_slab", () -> new SlabBlock(Prop.NONSOLID.get()));
    public static final Supplier<Block> SAKURA_STAIRS = BlockParty.BLOCKS.register("sakura_stairs", () -> new StairBlock(() -> SAKURA_PLANKS.get().defaultBlockState(), Prop.NONSOLID.get()));
    public static final Supplier<Block> SAKURA_WOOD = BlockParty.BLOCKS.register("sakura_wood", () -> new RotatedPillarBlock(Prop.SOLID.get()));
    public static final Supplier<Block> SHOJI_BLOCK = BlockParty.BLOCKS.register("shoji_block", () -> new Block(Prop.SHOJI.get()));
    public static final Supplier<Block> SHIMENAWA = BlockParty.BLOCKS.register("shimenawa", () -> new ShimenawaBlock(Prop.TRANSPARENT.get()));
    public static final Supplier<Block> SHOJI_LANTERN = BlockParty.BLOCKS.register("shoji_lantern", () -> new ShojiLanternBlock(Prop.SHOJI.get()));
    public static final Supplier<Block> SHOJI_PANEL = BlockParty.BLOCKS.register("shoji_panel", () -> new TrapDoorBlock(BlockSetType.OAK, Prop.SHOJI.get()));
    public static final Supplier<Block> SHOJI_SCREEN = BlockParty.BLOCKS.register("shoji_screen", () -> new ShojiScreenBlock(Prop.SHOJI.get()));
    public static final Supplier<Block> STRIPPED_GINKGO_LOG = BlockParty.BLOCKS.register("stripped_ginkgo_log", () -> new RotatedPillarBlock(Prop.SOLID.get()));
    public static final Supplier<Block> STRIPPED_GINKGO_WOOD = BlockParty.BLOCKS.register("stripped_ginkgo_wood", () -> new RotatedPillarBlock(Prop.SOLID.get()));
    public static final Supplier<Block> STRIPPED_SAKURA_LOG = BlockParty.BLOCKS.register("stripped_sakura_log", () -> new RotatedPillarBlock(Prop.SOLID.get()));
    public static final Supplier<Block> STRIPPED_SAKURA_WOOD = BlockParty.BLOCKS.register("stripped_sakura_wood", () -> new RotatedPillarBlock(Prop.SOLID.get()));
    public static final Supplier<Block> TATAMI_MAT = BlockParty.BLOCKS.register("tatami_mat", () -> new RotatedPillarBlock(Prop.SOLID.get()));
    public static final Supplier<Block> SHRINE_TABLET = BlockParty.BLOCKS.register("shrine_tablet", () -> new ShrineTabletBlock(Prop.TRANSPARENT.get()));
    public static final Supplier<Block> WHITE_PAPER_LANTERN = BlockParty.BLOCKS.register("white_paper_lantern", () -> new PaperLanternBlock(Prop.SHOJI.get(), MapColor.TERRACOTTA_WHITE));
    public static final Supplier<Block> WHITE_SAKURA_BLOSSOMS = BlockParty.BLOCKS.register("white_sakura_blossoms", () -> new SakuraBlossomsBlock(CustomParticles.WHITE_SAKURA, Prop.LEAVES.get()));
    public static final Supplier<Block> WHITE_SAKURA_SAPLING = BlockParty.BLOCKS.register("white_sakura_sapling", () -> new SaplingBlock(new WhiteSakuraTreeGrower(), Prop.PLANT.get()));
    public static final Supplier<Block> WIND_CHIMES = BlockParty.BLOCKS.register("wind_chimes", () -> new WindChimesBlock(Prop.STONE.get()));
    public static final Supplier<Block> WISTERIA_BINE = BlockParty.BLOCKS.register("wisteria_bine", () -> new RotatedPillarBlock(Prop.NONSOLID.get()));
    public static final Supplier<Block> WISTERIA_LEAVES = BlockParty.BLOCKS.register("wisteria_leaves", () -> new WisteriaLeavesBlock(Prop.LEAVES.get()));
    public static final Supplier<Block> WISTERIA_SAPLING = BlockParty.BLOCKS.register("wisteria_sapling", () -> new SaplingBlock(new WisteriaTreeGrower(), Prop.PLANT.get()));
    public static final Supplier<Block> WISTERIA_VINE_BODY = BlockParty.BLOCKS.register("wisteria_vine_body", () -> new WisteriaVineBodyBlock(Prop.PLANT.get()));
    public static final Supplier<Block> WISTERIA_VINE_TIP = BlockParty.BLOCKS.register("wisteria_vine_tip", () -> new WisteriaVineTipBlock(Prop.PLANT.get()));
    public static final Supplier<Block> WRITING_TABLE = BlockParty.BLOCKS.register("writing_table", () -> new WritingTableBlock(Prop.SOLID.get()));
    public static final Supplier<Block> YELLOW_PAPER_LANTERN = BlockParty.BLOCKS.register("yellow_paper_lantern", () -> new PaperLanternBlock(Prop.SHOJI.get(), MapColor.TERRACOTTA_YELLOW));
    public static final Supplier<Block> POTTED_GINKGO_SAPLING = BlockParty.BLOCKS.register("potted_ginkgo_sapling", () -> new FlowerPotBlock(CustomBlocks::flowerPot, GINKGO_SAPLING, BlockBehaviour.Properties.ofFullCopy(flowerPot())));
    public static final Supplier<Block> POTTED_SAKURA_SAPLING = BlockParty.BLOCKS.register("potted_sakura_sapling", () -> new FlowerPotBlock(CustomBlocks::flowerPot, SAKURA_SAPLING, BlockBehaviour.Properties.ofFullCopy(flowerPot())));
    public static final Supplier<Block> POTTED_WHITE_SAKURA_SAPLING = BlockParty.BLOCKS.register("potted_white_sakura_sapling", () -> new FlowerPotBlock(CustomBlocks::flowerPot, WHITE_SAKURA_SAPLING, BlockBehaviour.Properties.ofFullCopy(flowerPot())));
    public static final Supplier<Block> POTTED_WISTERIA_SAPLING = BlockParty.BLOCKS.register("potted_wisteria_sapling", () -> new FlowerPotBlock(CustomBlocks::flowerPot, WISTERIA_SAPLING, BlockBehaviour.Properties.ofFullCopy(flowerPot())));

    public static void add(DeferredRegister<Block> registry, IEventBus bus) {
        bus.addListener(CustomBlocks::registerRenderTypes);
        bus.addListener(CustomBlocks::registerPottedPlants);
        registry.register(bus);
    }

    private static void registerRenderTypes(FMLClientSetupEvent e) {
        /*
        ItemBlockRenderTypes.setRenderLayer(BLANK_HANGING_SCROLL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BLACK_PAPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DAWN_HANGING_SCROLL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(EVENING_HANGING_SCROLL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MIDNIGHT_HANGING_SCROLL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MORNING_HANGING_SCROLL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(NIGHT_HANGING_SCROLL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(NOON_HANGING_SCROLL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BLUE_PAPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BROWN_PAPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CYAN_PAPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(GARDEN_LANTERN.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(GINKGO_LEAVES.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(GINKGO_SAPLING.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(GRAY_PAPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(GREEN_PAPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LIGHT_BLUE_PAPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LIGHT_GRAY_PAPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LIME_PAPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MAGENTA_PAPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ORANGE_PAPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(PINK_PAPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SAKURA_BLOSSOMS.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(SAKURA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(POTTED_GINKGO_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(POTTED_SAKURA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(POTTED_WHITE_SAKURA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(POTTED_WISTERIA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(PURPLE_PAPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RED_PAPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SHIMENAWA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SHOJI_PANEL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SHOJI_SCREEN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SHRINE_TABLET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(WHITE_PAPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(WHITE_SAKURA_BLOSSOMS.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(WHITE_SAKURA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(WISTERIA_LEAVES.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(WISTERIA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(WISTERIA_VINE_BODY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(WISTERIA_VINE_TIP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(YELLOW_PAPER_LANTERN.get(), RenderType.cutout());
        */
    }

    private static void registerPottedPlants(FMLCommonSetupEvent e) {
        flowerPot().addPlant(BlockParty.source("ginkgo_sapling"), CustomBlocks.POTTED_GINKGO_SAPLING);
        flowerPot().addPlant(BlockParty.source("sakura_sapling"), CustomBlocks.POTTED_SAKURA_SAPLING);
        flowerPot().addPlant(BlockParty.source("white_sakura_sapling"), CustomBlocks.POTTED_WHITE_SAKURA_SAPLING);
        flowerPot().addPlant(BlockParty.source("wisteria_sapling"), CustomBlocks.POTTED_WISTERIA_SAPLING);
    }

    private static FlowerPotBlock flowerPot() {
        return ((FlowerPotBlock) Blocks.FLOWER_POT);
    }

    public class Prop {
        public static final Supplier<BlockBehaviour.Properties> SOLID = () -> BlockBehaviour.Properties.of().sound(SoundType.WOOD).mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(3.0F);
        public static final Supplier<BlockBehaviour.Properties> STONE = () -> BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE).sound(SoundType.STONE).strength(6.0F);
        public static final Supplier<BlockBehaviour.Properties> SHOJI = () -> BlockBehaviour.Properties.of().sound(SoundType.WOOD).mapColor(MapColor.COLOR_PINK).sound(SoundType.CROP).strength(0.5F).noOcclusion();
        public static final Supplier<BlockBehaviour.Properties> PLANT = () -> BlockBehaviour.Properties.of().sound(SoundType.CROP).strength(0.2F).randomTicks().noOcclusion();
        public static final Supplier<BlockBehaviour.Properties> LEAVES = () -> BlockBehaviour.Properties.of().sound(SoundType.CROP).strength(0.2F).randomTicks().noOcclusion();
        public static final Supplier<BlockBehaviour.Properties> NONSOLID = () -> SOLID.get().noOcclusion();
        public static final Supplier<BlockBehaviour.Properties> TRANSPARENT = () -> NONSOLID.get().isRedstoneConductor((state, reader, pos) -> false);
        public static final Supplier<BlockBehaviour.Properties> GINKGO = () -> BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.WOOD).strength(36.0F);
        public static final Supplier<BlockBehaviour.Properties> GINKGO_LEAVES = () -> GINKGO.get().sound(SoundType.CROP).strength(18.0F).randomTicks().noOcclusion();
        public static final Supplier<BlockBehaviour.Properties> NONSOLID_GINKGO = () -> GINKGO.get().noOcclusion();
    }
}
