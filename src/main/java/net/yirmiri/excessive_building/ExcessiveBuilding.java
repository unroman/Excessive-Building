package net.yirmiri.excessive_building;

import com.google.common.collect.ImmutableMap;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.yirmiri.excessive_building.block.EBBlocks;
import net.yirmiri.excessive_building.compat.CompatHandler;
import net.yirmiri.excessive_building.compat.aether.AetherIntegration;
import net.yirmiri.excessive_building.item.EBCreativeTabs;
import net.yirmiri.excessive_building.item.EBItems;

@Mod(ExcessiveBuilding.MOD_ID)
public class ExcessiveBuilding {
    public static final String MOD_ID = "excessive_building";

    public ExcessiveBuilding() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        EBBlocks.register(modEventBus);
        EBItems.register(modEventBus);
        EBCreativeTabs.register(modEventBus);

        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::onClientSetup);

        CompatHandler.register();

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onClientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(EBBlocks.FIERY_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(EBBlocks.AMETHYST_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(EBBlocks.PRISMARINE_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(EBBlocks.FIERY_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(EBBlocks.AMETHYST_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(EBBlocks.PRISMARINE_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(EBBlocks.RAINBOW_STAINED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(EBBlocks.RAINBOW_STAINED_GLASS_PANE.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(EBBlocks.FIERY_CLUSTER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(EBBlocks.KYANITE_CLUSTER.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(EBBlocks.COPPER_GRATE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(EBBlocks.EXPOSED_COPPER_GRATE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(EBBlocks.WEATHERED_COPPER_GRATE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(EBBlocks.OXIDIZED_COPPER_GRATE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(EBBlocks.WAXED_EXPOSED_COPPER_GRATE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(EBBlocks.WAXED_WEATHERED_COPPER_GRATE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(EBBlocks.WAXED_OXIDIZED_COPPER_GRATE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(EBBlocks.WAXED_COPPER_GRATE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(EBBlocks.GOLD_GRATE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(EBBlocks.IRON_GRATE.get(), RenderType.cutoutMipped());
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            AxeItem.STRIPPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPPABLES)
                    .build();
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == EBCreativeTabs.EXCESSIVE_BUILDING.get()) {
            event.accept(EBBlocks.CHISELED_OAK);
            event.accept(EBBlocks.OAK_MOSAIC);
            event.accept(EBBlocks.OAK_MOSAIC_STAIRS);
            event.accept(EBBlocks.OAK_MOSAIC_VERTICAL_STAIRS);
            event.accept(EBBlocks.OAK_MOSAIC_SLAB);
            event.accept(EBBlocks.CHISELED_SPRUCE);
            event.accept(EBBlocks.SPRUCE_MOSAIC);
            event.accept(EBBlocks.SPRUCE_MOSAIC_STAIRS);
            event.accept(EBBlocks.SPRUCE_MOSAIC_VERTICAL_STAIRS);
            event.accept(EBBlocks.SPRUCE_MOSAIC_SLAB);
            event.accept(EBBlocks.CHISELED_BIRCH);
            event.accept(EBBlocks.BIRCH_MOSAIC);
            event.accept(EBBlocks.BIRCH_MOSAIC_STAIRS);
            event.accept(EBBlocks.BIRCH_MOSAIC_VERTICAL_STAIRS);
            event.accept(EBBlocks.BIRCH_MOSAIC_SLAB);
            event.accept(EBBlocks.CHISELED_JUNGLE);
            event.accept(EBBlocks.JUNGLE_MOSAIC);
            event.accept(EBBlocks.JUNGLE_MOSAIC_STAIRS);
            event.accept(EBBlocks.JUNGLE_MOSAIC_VERTICAL_STAIRS);
            event.accept(EBBlocks.JUNGLE_MOSAIC_SLAB);
            event.accept(EBBlocks.CHISELED_ACACIA);
            event.accept(EBBlocks.ACACIA_MOSAIC);
            event.accept(EBBlocks.ACACIA_MOSAIC_STAIRS);
            event.accept(EBBlocks.ACACIA_MOSAIC_VERTICAL_STAIRS);
            event.accept(EBBlocks.ACACIA_MOSAIC_SLAB);
            event.accept(EBBlocks.CHISELED_DARK_OAK);
            event.accept(EBBlocks.DARK_OAK_MOSAIC);
            event.accept(EBBlocks.DARK_OAK_MOSAIC_STAIRS);
            event.accept(EBBlocks.DARK_OAK_MOSAIC_VERTICAL_STAIRS);
            event.accept(EBBlocks.DARK_OAK_MOSAIC_SLAB);
            event.accept(EBBlocks.CHISELED_MANGROVE);
            event.accept(EBBlocks.MANGROVE_MOSAIC);
            event.accept(EBBlocks.MANGROVE_MOSAIC_STAIRS);
            event.accept(EBBlocks.MANGROVE_MOSAIC_VERTICAL_STAIRS);
            event.accept(EBBlocks.MANGROVE_MOSAIC_SLAB);
            event.accept(EBBlocks.CHISELED_CHERRY);
            event.accept(EBBlocks.CHERRY_MOSAIC);
            event.accept(EBBlocks.CHERRY_MOSAIC_STAIRS);
            event.accept(EBBlocks.CHERRY_MOSAIC_VERTICAL_STAIRS);
            event.accept(EBBlocks.CHERRY_MOSAIC_SLAB);
            event.accept(EBBlocks.CHISELED_BAMBOO);
            event.accept(EBBlocks.CHISELED_CRIMSON);
            event.accept(EBBlocks.CRIMSON_MOSAIC);
            event.accept(EBBlocks.CRIMSON_MOSAIC_STAIRS);
            event.accept(EBBlocks.CRIMSON_MOSAIC_VERTICAL_STAIRS);
            event.accept(EBBlocks.CRIMSON_MOSAIC_SLAB);
            event.accept(EBBlocks.CHISELED_WARPED);
            event.accept(EBBlocks.WARPED_MOSAIC);
            event.accept(EBBlocks.WARPED_MOSAIC_STAIRS);
            event.accept(EBBlocks.WARPED_MOSAIC_VERTICAL_STAIRS);
            event.accept(EBBlocks.WARPED_MOSAIC_SLAB);
            event.accept(EBBlocks.COBBLESTONE_BRICKS);
            event.accept(EBBlocks.CRACKED_COBBLESTONE_BRICKS);
            event.accept(EBBlocks.COBBLESTONE_BRICK_STAIRS);
            event.accept(EBBlocks.COBBLESTONE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.COBBLESTONE_BRICK_SLAB);
            event.accept(EBBlocks.COBBLESTONE_BRICK_WALL);
            event.accept(EBBlocks.MOSSY_COBBLESTONE_BRICKS);
            event.accept(EBBlocks.MOSSY_COBBLESTONE_BRICK_STAIRS);
            event.accept(EBBlocks.MOSSY_COBBLESTONE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.MOSSY_COBBLESTONE_BRICK_SLAB);
            event.accept(EBBlocks.MOSSY_COBBLESTONE_BRICK_WALL);
            event.accept(EBBlocks.SMOOTH_STONE_BRICKS);
            event.accept(EBBlocks.SMOOTH_STONE_BRICK_STAIRS);
            event.accept(EBBlocks.SMOOTH_STONE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.SMOOTH_STONE_BRICK_SLAB);
            event.accept(EBBlocks.SMOOTH_STONE_BRICK_WALL);
            event.accept(EBBlocks.SMOOTH_STONE_TILES);
            event.accept(EBBlocks.SMOOTH_STONE_TILE_STAIRS);
            event.accept(EBBlocks.SMOOTH_STONE_TILE_VERTICAL_STAIRS);
            event.accept(EBBlocks.SMOOTH_STONE_TILE_SLAB);
            event.accept(EBBlocks.SMOOTH_STONE_TILE_WALL);
            event.accept(EBBlocks.COBBLED_GRANITE);
            event.accept(EBBlocks.COBBLED_GRANITE_STAIRS);
            event.accept(EBBlocks.COBBLED_GRANITE_VERTICAL_STAIRS);
            event.accept(EBBlocks.COBBLED_GRANITE_SLAB);
            event.accept(EBBlocks.COBBLED_GRANITE_WALL);
            event.accept(EBBlocks.COBBLED_GRANITE_BRICKS);
            event.accept(EBBlocks.CRACKED_COBBLED_GRANITE_BRICKS);
            event.accept(EBBlocks.COBBLED_GRANITE_BRICK_STAIRS);
            event.accept(EBBlocks.COBBLED_GRANITE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.COBBLED_GRANITE_BRICK_SLAB);
            event.accept(EBBlocks.COBBLED_GRANITE_BRICK_WALL);
            event.accept(EBBlocks.POLISHED_GRANITE_BRICKS);
            event.accept(EBBlocks.POLISHED_GRANITE_BRICK_STAIRS);
            event.accept(EBBlocks.POLISHED_GRANITE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.POLISHED_GRANITE_BRICK_SLAB);
            event.accept(EBBlocks.POLISHED_GRANITE_BRICK_WALL);
            event.accept(EBBlocks.COBBLED_DIORITE);
            event.accept(EBBlocks.COBBLED_DIORITE_STAIRS);
            event.accept(EBBlocks.COBBLED_DIORITE_VERTICAL_STAIRS);
            event.accept(EBBlocks.COBBLED_DIORITE_SLAB);
            event.accept(EBBlocks.COBBLED_DIORITE_WALL);
            event.accept(EBBlocks.COBBLED_DIORITE_BRICKS);
            event.accept(EBBlocks.CRACKED_COBBLED_DIORITE_BRICKS);
            event.accept(EBBlocks.COBBLED_DIORITE_BRICK_STAIRS);
            event.accept(EBBlocks.COBBLED_DIORITE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.COBBLED_DIORITE_BRICK_SLAB);
            event.accept(EBBlocks.COBBLED_DIORITE_BRICK_WALL);
            event.accept(EBBlocks.POLISHED_DIORITE_BRICKS);
            event.accept(EBBlocks.POLISHED_DIORITE_BRICK_STAIRS);
            event.accept(EBBlocks.POLISHED_DIORITE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.POLISHED_DIORITE_BRICK_SLAB);
            event.accept(EBBlocks.POLISHED_DIORITE_BRICK_WALL);
            event.accept(EBBlocks.COBBLED_ANDESITE);
            event.accept(EBBlocks.COBBLED_ANDESITE_STAIRS);
            event.accept(EBBlocks.COBBLED_ANDESITE_VERTICAL_STAIRS);
            event.accept(EBBlocks.COBBLED_ANDESITE_SLAB);
            event.accept(EBBlocks.COBBLED_ANDESITE_WALL);
            event.accept(EBBlocks.COBBLED_ANDESITE_BRICKS);
            event.accept(EBBlocks.CRACKED_COBBLED_ANDESITE_BRICKS);
            event.accept(EBBlocks.COBBLED_ANDESITE_BRICK_STAIRS);
            event.accept(EBBlocks.COBBLED_ANDESITE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.COBBLED_ANDESITE_BRICK_SLAB);
            event.accept(EBBlocks.COBBLED_ANDESITE_BRICK_WALL);
            event.accept(EBBlocks.POLISHED_ANDESITE_BRICKS);
            event.accept(EBBlocks.POLISHED_ANDESITE_BRICK_STAIRS);
            event.accept(EBBlocks.POLISHED_ANDESITE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.POLISHED_ANDESITE_BRICK_SLAB);
            event.accept(EBBlocks.POLISHED_ANDESITE_BRICK_WALL);
            event.accept(EBBlocks.CALCITE_BRICKS);
            event.accept(EBBlocks.CRACKED_CALCITE_BRICKS);
            event.accept(EBBlocks.CALCITE_BRICK_STAIRS);
            event.accept(EBBlocks.CALCITE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.CALCITE_BRICK_SLAB);
            event.accept(EBBlocks.CALCITE_BRICK_WALL);
            event.accept(EBBlocks.CALCITE_TILES);
            event.accept(EBBlocks.CALCITE_TILE_STAIRS);
            event.accept(EBBlocks.CALCITE_TILE_VERTICAL_STAIRS);
            event.accept(EBBlocks.CALCITE_TILE_SLAB);
            event.accept(EBBlocks.CALCITE_TILE_WALL);
            event.accept(EBBlocks.TUFF_STAIRS);
            event.accept(EBBlocks.TUFF_VERTICAL_STAIRS);
            event.accept(EBBlocks.TUFF_SLAB);
            event.accept(EBBlocks.TUFF_WALL);
            event.accept(EBBlocks.POLISHED_TUFF);
            event.accept(EBBlocks.CHISELED_POLISHED_TUFF);
            event.accept(EBBlocks.POLISHED_TUFF_STAIRS);
            event.accept(EBBlocks.POLISHED_TUFF_VERTICAL_STAIRS);
            event.accept(EBBlocks.POLISHED_TUFF_SLAB);
            event.accept(EBBlocks.POLISHED_TUFF_WALL);
            event.accept(EBBlocks.TUFF_BRICKS);
            event.accept(EBBlocks.CHISELED_TUFF_BRICKS);
            event.accept(EBBlocks.TUFF_BRICK_STAIRS);
            event.accept(EBBlocks.TUFF_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.TUFF_BRICK_SLAB);
            event.accept(EBBlocks.TUFF_BRICK_WALL);
            event.accept(EBBlocks.TUFF_TILES);
            event.accept(EBBlocks.TUFF_TILE_STAIRS);
            event.accept(EBBlocks.TUFF_TILE_VERTICAL_STAIRS);
            event.accept(EBBlocks.TUFF_TILE_SLAB);
            event.accept(EBBlocks.TUFF_TILE_WALL);
            event.accept(EBBlocks.DRIPSTONE_BRICKS);
            event.accept(EBBlocks.DRIPSTONE_BRICK_STAIRS);
            event.accept(EBBlocks.DRIPSTONE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.DRIPSTONE_BRICK_SLAB);
            event.accept(EBBlocks.DRIPSTONE_BRICK_WALL);
            event.accept(EBBlocks.DRIPSTONE_TILES);
            event.accept(EBBlocks.DRIPSTONE_TILE_STAIRS);
            event.accept(EBBlocks.DRIPSTONE_TILE_VERTICAL_STAIRS);
            event.accept(EBBlocks.DRIPSTONE_TILE_SLAB);
            event.accept(EBBlocks.DRIPSTONE_TILE_WALL);
            event.accept(EBBlocks.COBBLED_DEEPSLATE_BRICKS);
            event.accept(EBBlocks.CRACKED_COBBLED_DEEPSLATE_BRICKS);
            event.accept(EBBlocks.COBBLED_DEEPSLATE_BRICK_STAIRS);
            event.accept(EBBlocks.COBBLED_DEEPSLATE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.COBBLED_DEEPSLATE_BRICK_SLAB);
            event.accept(EBBlocks.COBBLED_DEEPSLATE_BRICK_WALL);
            event.accept(EBBlocks.MOSSY_COBBLED_DEEPSLATE_BRICKS);
            event.accept(EBBlocks.MOSSY_COBBLED_DEEPSLATE_BRICK_STAIRS);
            event.accept(EBBlocks.MOSSY_COBBLED_DEEPSLATE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.MOSSY_COBBLED_DEEPSLATE_BRICK_SLAB);
            event.accept(EBBlocks.MOSSY_COBBLED_DEEPSLATE_BRICK_WALL);
            event.accept(EBBlocks.MOSSY_DEEPSLATE_BRICKS);
            event.accept(EBBlocks.MOSSY_DEEPSLATE_BRICK_STAIRS);
            event.accept(EBBlocks.MOSSY_DEEPSLATE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.MOSSY_DEEPSLATE_BRICK_SLAB);
            event.accept(EBBlocks.MOSSY_DEEPSLATE_BRICK_WALL);
            event.accept(EBBlocks.SMOOTH_BRICKS);
            event.accept(EBBlocks.CRACKED_SMOOTH_BRICKS);
            event.accept(EBBlocks.SMOOTH_BRICK_STAIRS);
            event.accept(EBBlocks.SMOOTH_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.SMOOTH_BRICK_SLAB);
            event.accept(EBBlocks.SMOOTH_BRICK_WALL);
            event.accept(EBBlocks.MUD_TILES);
            event.accept(EBBlocks.MUD_TILE_STAIRS);
            event.accept(EBBlocks.MUD_TILE_VERTICAL_STAIRS);
            event.accept(EBBlocks.MUD_TILE_SLAB);
            event.accept(EBBlocks.SNOW_BRICKS);
            event.accept(EBBlocks.SNOW_BRICK_STAIRS);
            event.accept(EBBlocks.SNOW_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.SNOW_BRICK_SLAB);
            event.accept(EBBlocks.SANDSTONE_BRICKS);
            event.accept(EBBlocks.SANDSTONE_BRICK_STAIRS);
            event.accept(EBBlocks.SANDSTONE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.SANDSTONE_BRICK_SLAB);
            event.accept(EBBlocks.SANDSTONE_BRICK_WALL);
            event.accept(EBBlocks.CHISELED_SANDSTONE_BRICKS);
            event.accept(EBBlocks.RED_SANDSTONE_BRICKS);
            event.accept(EBBlocks.RED_SANDSTONE_BRICK_STAIRS);
            event.accept(EBBlocks.RED_SANDSTONE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.RED_SANDSTONE_BRICK_SLAB);
            event.accept(EBBlocks.RED_SANDSTONE_BRICK_WALL);
            event.accept(EBBlocks.CHISELED_RED_SANDSTONE_BRICKS);
            event.accept(EBBlocks.SOUL_SANDSTONE);
            event.accept(EBBlocks.SOUL_SANDSTONE_STAIRS);
            event.accept(EBBlocks.SOUL_SANDSTONE_VERTICAL_STAIRS);
            event.accept(EBBlocks.SOUL_SANDSTONE_SLAB);
            event.accept(EBBlocks.SOUL_SANDSTONE_WALL);
            event.accept(EBBlocks.SOUL_SANDSTONE_BRICKS);
            event.accept(EBBlocks.SOUL_SANDSTONE_BRICK_STAIRS);
            event.accept(EBBlocks.SOUL_SANDSTONE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.SOUL_SANDSTONE_BRICK_SLAB);
            event.accept(EBBlocks.SOUL_SANDSTONE_BRICK_WALL);
            event.accept(EBBlocks.CHISELED_SOUL_SANDSTONE_BRICKS);
            event.accept(EBBlocks.CHISELED_SOUL_SANDSTONE);
            event.accept(EBBlocks.SMOOTH_SOUL_SANDSTONE);
            event.accept(EBBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS);
            event.accept(EBBlocks.SMOOTH_SOUL_SANDSTONE_VERTICAL_STAIRS);
            event.accept(EBBlocks.SMOOTH_SOUL_SANDSTONE_SLAB);
            event.accept(EBBlocks.CUT_SOUL_SANDSTONE);
            event.accept(EBBlocks.CUT_SOUL_SANDSTONE_SLAB);
            event.accept(EBBlocks.BRIMSTONE);
            event.accept(EBBlocks.BRIMSTONE_STAIRS);
            event.accept(EBBlocks.BRIMSTONE_VERTICAL_STAIRS);
            event.accept(EBBlocks.BRIMSTONE_SLAB);
            event.accept(EBBlocks.POLISHED_BRIMSTONE);
            event.accept(EBBlocks.POLISHED_BRIMSTONE_PILLAR);
            event.accept(EBBlocks.POLISHED_BRIMSTONE_STAIRS);
            event.accept(EBBlocks.POLISHED_BRIMSTONE_VERTICAL_STAIRS);
            event.accept(EBBlocks.POLISHED_BRIMSTONE_SLAB);
            event.accept(EBBlocks.POLISHED_BRIMSTONE_WALL);
            event.accept(EBBlocks.POLISHED_BRIMSTONE_BRICKS);
            event.accept(EBBlocks.POLISHED_BRIMSTONE_BRICK_STAIRS);
            event.accept(EBBlocks.POLISHED_BRIMSTONE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.POLISHED_BRIMSTONE_BRICK_SLAB);
            event.accept(EBBlocks.POLISHED_BRIMSTONE_BRICK_WALL);
            event.accept(EBBlocks.CRACKED_POLISHED_BRIMSTONE_BRICKS);
            event.accept(EBBlocks.CRACKED_POLISHED_BRIMSTONE_BRICK_STAIRS);
            event.accept(EBBlocks.CRACKED_POLISHED_BRIMSTONE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.CRACKED_POLISHED_BRIMSTONE_BRICK_SLAB);
            event.accept(EBBlocks.CRACKED_POLISHED_BRIMSTONE_BRICK_WALL);
            event.accept(EBBlocks.POLISHED_BRIMSTONE_TILES);
            event.accept(EBBlocks.POLISHED_BRIMSTONE_TILE_STAIRS);
            event.accept(EBBlocks.POLISHED_BRIMSTONE_TILE_VERTICAL_STAIRS);
            event.accept(EBBlocks.POLISHED_BRIMSTONE_TILE_SLAB);
            event.accept(EBBlocks.POLISHED_BRIMSTONE_TILE_WALL);
            event.accept(EBBlocks.SULFURIC_BRIMSTONE);
            event.accept(EBBlocks.SULFURIC_BRIMSTONE_STAIRS);
            event.accept(EBBlocks.SULFURIC_BRIMSTONE_VERTICAL_STAIRS);
            event.accept(EBBlocks.SULFURIC_BRIMSTONE_SLAB);
            event.accept(EBBlocks.POLISHED_SULFURIC_BRIMSTONE);
            event.accept(EBBlocks.POLISHED_SULFURIC_BRIMSTONE_STAIRS);
            event.accept(EBBlocks.POLISHED_SULFURIC_BRIMSTONE_SLAB);
            event.accept(EBBlocks.POLISHED_SULFURIC_BRIMSTONE_WALL);
            event.accept(EBBlocks.POLISHED_SULFURIC_BRIMSTONE_BRICKS);
            event.accept(EBBlocks.POLISHED_SULFURIC_BRIMSTONE_BRICK_STAIRS);
            event.accept(EBBlocks.POLISHED_SULFURIC_BRIMSTONE_BRICK_SLAB);
            event.accept(EBBlocks.POLISHED_SULFURIC_BRIMSTONE_BRICK_WALL);
            event.accept(EBBlocks.POLISHED_SULFURIC_BRIMSTONE_TILES);
            event.accept(EBBlocks.POLISHED_SULFURIC_BRIMSTONE_TILE_STAIRS);
            event.accept(EBBlocks.POLISHED_SULFURIC_BRIMSTONE_TILE_SLAB);
            event.accept(EBBlocks.POLISHED_SULFURIC_BRIMSTONE_TILE_WALL);
            event.accept(EBBlocks.BRIMSTONE_WINDOW);
            event.accept(EBBlocks.BRIMSTONE_LANTERN);
            event.accept(EBBlocks.NETHER_TILES);
            event.accept(EBBlocks.NETHER_TILE_STAIRS);
            event.accept(EBBlocks.NETHER_TILE_VERTICAL_STAIRS);
            event.accept(EBBlocks.NETHER_TILE_SLAB);
            event.accept(EBBlocks.NETHER_TILE_WALL);
            event.accept(EBBlocks.RED_NETHER_TILES);
            event.accept(EBBlocks.RED_NETHER_TILE_STAIRS);
            event.accept(EBBlocks.RED_NETHER_TILE_VERTICAL_STAIRS);
            event.accept(EBBlocks.RED_NETHER_TILE_SLAB);
            event.accept(EBBlocks.RED_NETHER_TILE_WALL);
            event.accept(EBBlocks.BLUE_NETHER_BRICKS);
            event.accept(EBBlocks.BLUE_NETHER_BRICK_STAIRS);
            event.accept(EBBlocks.BLUE_NETHER_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.BLUE_NETHER_BRICK_SLAB);
            event.accept(EBBlocks.BLUE_NETHER_BRICK_WALL);
            event.accept(EBBlocks.BLUE_NETHER_TILES);
            event.accept(EBBlocks.BLUE_NETHER_TILE_STAIRS);
            event.accept(EBBlocks.BLUE_NETHER_TILE_VERTICAL_STAIRS);
            event.accept(EBBlocks.BLUE_NETHER_TILE_SLAB);
            event.accept(EBBlocks.BLUE_NETHER_TILE_WALL);
            event.accept(EBBlocks.CRIMSON_MOSSY_POLISHED_BLACKSTONE_BRICKS);
            event.accept(EBBlocks.CRIMSON_MOSSY_POLISHED_BLACKSTONE_BRICK_STAIRS);
            event.accept(EBBlocks.CRIMSON_MOSSY_POLISHED_BLACKSTONE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.CRIMSON_MOSSY_POLISHED_BLACKSTONE_BRICK_SLAB);
            event.accept(EBBlocks.CRIMSON_MOSSY_POLISHED_BLACKSTONE_BRICK_WALL);
            event.accept(EBBlocks.WARPED_MOSSY_POLISHED_BLACKSTONE_BRICKS);
            event.accept(EBBlocks.WARPED_MOSSY_POLISHED_BLACKSTONE_BRICK_STAIRS);
            event.accept(EBBlocks.WARPED_MOSSY_POLISHED_BLACKSTONE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.WARPED_MOSSY_POLISHED_BLACKSTONE_BRICK_SLAB);
            event.accept(EBBlocks.WARPED_MOSSY_POLISHED_BLACKSTONE_BRICK_WALL);
            event.accept(EBBlocks.POLISHED_BLACKSTONE_TILES);
            event.accept(EBBlocks.CRACKED_POLISHED_BLACKSTONE_TILES);
            event.accept(EBBlocks.POLISHED_BLACKSTONE_TILE_STAIRS);
            event.accept(EBBlocks.POLISHED_BLACKSTONE_TILE_VERTICAL_STAIRS);
            event.accept(EBBlocks.POLISHED_BLACKSTONE_TILE_SLAB);
            event.accept(EBBlocks.POLISHED_BLACKSTONE_TILE_WALL);
            event.accept(EBBlocks.BLACKSTONE_BRICKS);
            event.accept(EBBlocks.CRACKED_BLACKSTONE_BRICKS);
            event.accept(EBBlocks.BLACKSTONE_BRICK_STAIRS);
            event.accept(EBBlocks.BLACKSTONE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.BLACKSTONE_BRICK_SLAB);
            event.accept(EBBlocks.BLACKSTONE_BRICK_WALL);
            event.accept(EBBlocks.CRIMSON_MOSSY_BLACKSTONE_BRICKS);
            event.accept(EBBlocks.CRIMSON_MOSSY_BLACKSTONE_BRICK_STAIRS);
            event.accept(EBBlocks.CRIMSON_MOSSY_BLACKSTONE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.CRIMSON_MOSSY_BLACKSTONE_BRICK_SLAB);
            event.accept(EBBlocks.CRIMSON_MOSSY_BLACKSTONE_BRICK_WALL);
            event.accept(EBBlocks.WARPED_MOSSY_BLACKSTONE_BRICKS);
            event.accept(EBBlocks.WARPED_MOSSY_BLACKSTONE_BRICK_STAIRS);
            event.accept(EBBlocks.WARPED_MOSSY_BLACKSTONE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.WARPED_MOSSY_BLACKSTONE_BRICK_SLAB);
            event.accept(EBBlocks.WARPED_MOSSY_BLACKSTONE_BRICK_WALL);
            event.accept(EBBlocks.OBSIDIAN_BRICKS);
            event.accept(EBBlocks.CRACKED_OBSIDIAN_BRICKS);
            event.accept(EBBlocks.OBSIDIAN_BRICK_STAIRS);
            event.accept(EBBlocks.OBSIDIAN_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.OBSIDIAN_BRICK_SLAB);
            event.accept(EBBlocks.OBSIDIAN_TILES);
            event.accept(EBBlocks.OBSIDIAN_TILE_STAIRS);
            event.accept(EBBlocks.OBSIDIAN_TILE_VERTICAL_STAIRS);
            event.accept(EBBlocks.OBSIDIAN_TILE_SLAB);
            event.accept(EBBlocks.IRON_BRICKS);
            event.accept(EBBlocks.IRON_BRICK_STAIRS);
            event.accept(EBBlocks.IRON_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.IRON_BRICK_SLAB);
            event.accept(EBBlocks.IRON_GRATE);
            event.accept(EBBlocks.GOLDEN_BRICKS);
            event.accept(EBBlocks.GOLDEN_BRICK_STAIRS);
            event.accept(EBBlocks.GOLDEN_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.GOLDEN_BRICK_SLAB);
            event.accept(EBBlocks.GOLD_GRATE);
            event.accept(EBBlocks.LAPIS_LAZULI_BRICKS);
            event.accept(EBBlocks.LAPIS_LAZULI_BRICK_STAIRS);
            event.accept(EBBlocks.LAPIS_LAZULI_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.LAPIS_LAZULI_BRICK_SLAB);
            event.accept(EBBlocks.DIAMOND_BRICKS);
            event.accept(EBBlocks.DIAMOND_BRICK_STAIRS);
            event.accept(EBBlocks.DIAMOND_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.DIAMOND_BRICK_SLAB);
            event.accept(EBBlocks.NETHERITE_BRICKS);
            event.accept(EBBlocks.NETHERITE_BRICK_STAIRS);
            event.accept(EBBlocks.NETHERITE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.NETHERITE_BRICK_SLAB);
            event.accept(EBBlocks.QUARTZ_ORE);
            event.accept(EBBlocks.DEEPSLATE_QUARTZ_ORE);
            event.accept(EBBlocks.QUARTZ_BRICK_STAIRS);
            event.accept(EBBlocks.QUARTZ_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.QUARTZ_BRICK_SLAB);
            event.accept(EBBlocks.QUARTZ_TILES);
            event.accept(EBBlocks.QUARTZ_TILE_STAIRS);
            event.accept(EBBlocks.QUARTZ_TILE_VERTICAL_STAIRS);
            event.accept(EBBlocks.QUARTZ_TILE_SLAB);
            event.accept(EBBlocks.TERRACOTTA_TILES);
            event.accept(EBBlocks.TERRACOTTA_TILE_STAIRS);
            event.accept(EBBlocks.TERRACOTTA_TILE_SLAB);
            event.accept(EBBlocks.RAINBOW_TERRACOTTA_TILES);
            event.accept(EBBlocks.RAINBOW_TERRACOTTA_TILE_STAIRS);
            event.accept(EBBlocks.RAINBOW_TERRACOTTA_TILE_SLAB);
            event.accept(EBBlocks.WHITE_TERRACOTTA_TILES);
            event.accept(EBBlocks.WHITE_TERRACOTTA_TILE_STAIRS);
            event.accept(EBBlocks.WHITE_TERRACOTTA_TILE_SLAB);
            event.accept(EBBlocks.LIGHT_GRAY_TERRACOTTA_TILES);
            event.accept(EBBlocks.LIGHT_GRAY_TERRACOTTA_TILE_STAIRS);
            event.accept(EBBlocks.LIGHT_GRAY_TERRACOTTA_TILE_SLAB);
            event.accept(EBBlocks.GRAY_TERRACOTTA_TILES);
            event.accept(EBBlocks.GRAY_TERRACOTTA_TILE_STAIRS);
            event.accept(EBBlocks.GRAY_TERRACOTTA_TILE_SLAB);
            event.accept(EBBlocks.BLACK_TERRACOTTA_TILES);
            event.accept(EBBlocks.BLACK_TERRACOTTA_TILE_STAIRS);
            event.accept(EBBlocks.BLACK_TERRACOTTA_TILE_SLAB);
            event.accept(EBBlocks.BROWN_TERRACOTTA_TILES);
            event.accept(EBBlocks.BROWN_TERRACOTTA_TILE_STAIRS);
            event.accept(EBBlocks.BROWN_TERRACOTTA_TILE_SLAB);
            event.accept(EBBlocks.RED_TERRACOTTA_TILES);
            event.accept(EBBlocks.RED_TERRACOTTA_TILE_STAIRS);
            event.accept(EBBlocks.RED_TERRACOTTA_TILE_SLAB);
            event.accept(EBBlocks.ORANGE_TERRACOTTA_TILES);
            event.accept(EBBlocks.ORANGE_TERRACOTTA_TILE_STAIRS);
            event.accept(EBBlocks.ORANGE_TERRACOTTA_TILE_SLAB);
            event.accept(EBBlocks.YELLOW_TERRACOTTA_TILES);
            event.accept(EBBlocks.YELLOW_TERRACOTTA_TILE_STAIRS);
            event.accept(EBBlocks.YELLOW_TERRACOTTA_TILE_SLAB);
            event.accept(EBBlocks.LIME_TERRACOTTA_TILES);
            event.accept(EBBlocks.LIME_TERRACOTTA_TILE_STAIRS);
            event.accept(EBBlocks.LIME_TERRACOTTA_TILE_SLAB);
            event.accept(EBBlocks.GREEN_TERRACOTTA_TILES);
            event.accept(EBBlocks.GREEN_TERRACOTTA_TILE_STAIRS);
            event.accept(EBBlocks.GREEN_TERRACOTTA_TILE_SLAB);
            event.accept(EBBlocks.CYAN_TERRACOTTA_TILES);
            event.accept(EBBlocks.CYAN_TERRACOTTA_TILE_STAIRS);
            event.accept(EBBlocks.CYAN_TERRACOTTA_TILE_SLAB);
            event.accept(EBBlocks.LIGHT_BLUE_TERRACOTTA_TILES);
            event.accept(EBBlocks.LIGHT_BLUE_TERRACOTTA_TILE_STAIRS);
            event.accept(EBBlocks.LIGHT_BLUE_TERRACOTTA_TILE_SLAB);
            event.accept(EBBlocks.BLUE_TERRACOTTA_TILES);
            event.accept(EBBlocks.BLUE_TERRACOTTA_TILE_STAIRS);
            event.accept(EBBlocks.BLUE_TERRACOTTA_TILE_SLAB);
            event.accept(EBBlocks.PURPLE_TERRACOTTA_TILES);
            event.accept(EBBlocks.PURPLE_TERRACOTTA_TILE_STAIRS);
            event.accept(EBBlocks.PURPLE_TERRACOTTA_TILE_SLAB);
            event.accept(EBBlocks.MAGENTA_TERRACOTTA_TILES);
            event.accept(EBBlocks.MAGENTA_TERRACOTTA_TILE_STAIRS);
            event.accept(EBBlocks.MAGENTA_TERRACOTTA_TILE_SLAB);
            event.accept(EBBlocks.PINK_TERRACOTTA_TILES);
            event.accept(EBBlocks.PINK_TERRACOTTA_TILE_STAIRS);
            event.accept(EBBlocks.PINK_TERRACOTTA_TILE_SLAB);
            event.accept(EBBlocks.SOUL_MAGMA_BLOCK);
            event.accept(EBBlocks.AMETHYST_LANTERN);
            event.accept(EBBlocks.AMETHYST_GLASS);
            event.accept(EBBlocks.AMETHYST_GLASS_PANE);
            event.accept(EBBlocks.PRISMARINE_CRYSTAL_BLOCK);
            event.accept(EBBlocks.PRISMARINE_GLASS);
            event.accept(EBBlocks.PRISMARINE_GLASS_PANE);
            event.accept(EBBlocks.FIERY_BLOCK);
            event.accept(EBBlocks.FIERY_LANTERN);
            event.accept(EBBlocks.FIERY_GLASS);
            event.accept(EBBlocks.FIERY_GLASS_PANE);
            event.accept(EBBlocks.FIERY_CLUSTER);
            event.accept(EBItems.FIERY_SHARDS);
            event.accept(EBBlocks.KYANITE_BLOCK);
            event.accept(EBBlocks.KYANITE_CLUSTER);
            event.accept(EBItems.KYANITE_SHARDS);
            event.accept(EBBlocks.CHISELED_COPPER);
            event.accept(EBBlocks.EXPOSED_CHISELED_COPPER);
            event.accept(EBBlocks.WEATHERED_CHISELED_COPPER);
            event.accept(EBBlocks.OXIDIZED_CHISELED_COPPER);
            event.accept(EBBlocks.WAXED_CHISELED_COPPER);
            event.accept(EBBlocks.WAXED_EXPOSED_CHISELED_COPPER);
            event.accept(EBBlocks.WAXED_WEATHERED_CHISELED_COPPER);
            event.accept(EBBlocks.WAXED_OXIDIZED_CHISELED_COPPER);
            event.accept(EBBlocks.COPPER_GRATE);
            event.accept(EBBlocks.EXPOSED_COPPER_GRATE);
            event.accept(EBBlocks.WEATHERED_COPPER_GRATE);
            event.accept(EBBlocks.OXIDIZED_COPPER_GRATE);
            event.accept(EBBlocks.WAXED_COPPER_GRATE);
            event.accept(EBBlocks.WAXED_EXPOSED_COPPER_GRATE);
            event.accept(EBBlocks.WAXED_WEATHERED_COPPER_GRATE);
            event.accept(EBBlocks.WAXED_OXIDIZED_COPPER_GRATE);
            event.accept(EBBlocks.COPPER_BULB);
            event.accept(EBBlocks.EXPOSED_COPPER_BULB);
            event.accept(EBBlocks.WEATHERED_COPPER_BULB);
            event.accept(EBBlocks.OXIDIZED_COPPER_BULB);
            event.accept(EBBlocks.WAXED_COPPER_BULB);
            event.accept(EBBlocks.WAXED_EXPOSED_COPPER_BULB);
            event.accept(EBBlocks.WAXED_WEATHERED_COPPER_BULB);
            event.accept(EBBlocks.WAXED_OXIDIZED_COPPER_BULB);
            event.accept(EBBlocks.ASPHALT);
            event.accept(EBBlocks.EMPTY_SHELF);
            event.accept(EBBlocks.EMPTY_POTION_SHELF);
            event.accept(EBBlocks.WATER_POTION_SHELF);
            event.accept(EBBlocks.POTION_SHELF);
            event.accept(EBBlocks.ALCHEMIST_SHELF);
            event.accept(EBBlocks.OAK_CRAFTING_TABLE);
            event.accept(EBBlocks.SPRUCE_CRAFTING_TABLE);
            event.accept(EBBlocks.COLORED_SPRUCE_CRAFTING_TABLE);
            event.accept(EBBlocks.BIRCH_CRAFTING_TABLE);
            event.accept(EBBlocks.COLORED_BIRCH_CRAFTING_TABLE);
            event.accept(EBBlocks.JUNGLE_CRAFTING_TABLE);
            event.accept(EBBlocks.COLORED_JUNGLE_CRAFTING_TABLE);
            event.accept(EBBlocks.ACACIA_CRAFTING_TABLE);
            event.accept(EBBlocks.COLORED_ACACIA_CRAFTING_TABLE);
            event.accept(EBBlocks.DARK_OAK_CRAFTING_TABLE);
            event.accept(EBBlocks.COLORED_DARK_OAK_CRAFTING_TABLE);
            event.accept(EBBlocks.MANGROVE_CRAFTING_TABLE);
            event.accept(EBBlocks.COLORED_MANGROVE_CRAFTING_TABLE);
            event.accept(EBBlocks.BAMBOO_CRAFTING_TABLE);
            event.accept(EBBlocks.CHERRY_CRAFTING_TABLE);
            event.accept(EBBlocks.COLORED_CHERRY_CRAFTING_TABLE);
            event.accept(EBBlocks.CRIMSON_CRAFTING_TABLE);
            event.accept(EBBlocks.COLORED_CRIMSON_CRAFTING_TABLE);
            event.accept(EBBlocks.WARPED_CRAFTING_TABLE);
            event.accept(EBBlocks.COLORED_WARPED_CRAFTING_TABLE);
            event.accept(EBBlocks.CONSTRUCTION_TABLE);
            event.accept(EBBlocks.OAK_VERTICAL_STAIRS);
            event.accept(EBBlocks.SPRUCE_VERTICAL_STAIRS);
            event.accept(EBBlocks.BIRCH_VERTICAL_STAIRS);
            event.accept(EBBlocks.JUNGLE_VERTICAL_STAIRS);
            event.accept(EBBlocks.ACACIA_VERTICAL_STAIRS);
            event.accept(EBBlocks.DARK_OAK_VERTICAL_STAIRS);
            event.accept(EBBlocks.MANGROVE_VERTICAL_STAIRS);
            event.accept(EBBlocks.CHERRY_VERTICAL_STAIRS);
            event.accept(EBBlocks.BAMBOO_VERTICAL_STAIRS);
            event.accept(EBBlocks.BAMBOO_MOSAIC_VERTICAL_STAIRS);
            event.accept(EBBlocks.CRIMSON_VERTICAL_STAIRS);
            event.accept(EBBlocks.WARPED_VERTICAL_STAIRS);
            event.accept(EBBlocks.STONE_VERTICAL_STAIRS);
            event.accept(EBBlocks.COBBLESTONE_VERTICAL_STAIRS);
            event.accept(EBBlocks.MOSSY_COBBLESTONE_VERTICAL_STAIRS);
            event.accept(EBBlocks.STONE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.MOSSY_STONE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.GRANITE_VERTICAL_STAIRS);
            event.accept(EBBlocks.POLISHED_GRANITE_VERTICAL_STAIRS);
            event.accept(EBBlocks.DIORITE_VERTICAL_STAIRS);
            event.accept(EBBlocks.POLISHED_DIORITE_VERTICAL_STAIRS);
            event.accept(EBBlocks.ANDESITE_VERTICAL_STAIRS);
            event.accept(EBBlocks.POLISHED_ANDESITE_VERTICAL_STAIRS);
            event.accept(EBBlocks.COBBLED_DEEPSLATE_VERTICAL_STAIRS);
            event.accept(EBBlocks.POLISHED_DEEPSLATE_VERTICAL_STAIRS);
            event.accept(EBBlocks.DEEPSLATE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.DEEPSLATE_TILE_VERTICAL_STAIRS);
            event.accept(EBBlocks.BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.MUD_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.SANDSTONE_VERTICAL_STAIRS);
            event.accept(EBBlocks.SMOOTH_SANDSTONE_VERTICAL_STAIRS);
            event.accept(EBBlocks.RED_SANDSTONE_VERTICAL_STAIRS);
            event.accept(EBBlocks.SMOOTH_RED_SANDSTONE_VERTICAL_STAIRS);
            event.accept(EBBlocks.PRISMARINE_VERTICAL_STAIRS);
            event.accept(EBBlocks.PRISMARINE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.DARK_PRISMARINE_VERTICAL_STAIRS);
            event.accept(EBBlocks.NETHER_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.RED_NETHER_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.BLACKSTONE_VERTICAL_STAIRS);
            event.accept(EBBlocks.POLISHED_BLACKSTONE_VERTICAL_STAIRS);
            event.accept(EBBlocks.POLISHED_BLACKSTONE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.END_STONE_BRICK_VERTICAL_STAIRS);
            event.accept(EBBlocks.PURPUR_VERTICAL_STAIRS);
            event.accept(EBBlocks.QUARTZ_VERTICAL_STAIRS);
            event.accept(EBBlocks.SMOOTH_QUARTZ_VERTICAL_STAIRS);
        }

        if (event.getTab() == EBCreativeTabs.EXCESSIVE_BUILDING.get() && (aether)) {
            event.accept(AetherIntegration.CHISELED_SKYROOT.get());
            event.accept(AetherIntegration.SKYROOT_MOSAIC.get());
            event.accept(AetherIntegration.SKYROOT_MOSAIC_STAIRS.get());
            event.accept(AetherIntegration.SKYROOT_MOSAIC_SLAB.get());
            event.accept(AetherIntegration.AMBROSIUM_BRICKS.get());
            event.accept(AetherIntegration.AMBROSIUM_BRICK_STAIRS.get());
            event.accept(AetherIntegration.AMBROSIUM_BRICK_SLAB.get());
            event.accept(AetherIntegration.ZANITE_BRICKS.get());
            event.accept(AetherIntegration.ZANITE_BRICK_STAIRS.get());
            event.accept(AetherIntegration.ZANITE_BRICK_SLAB.get());
            event.accept(AetherIntegration.ENCHANTED_GRAVITITE_BRICKS.get());
            event.accept(AetherIntegration.ENCHANTED_GRAVITITE_BRICK_STAIRS.get());
            event.accept(AetherIntegration.ENCHANTED_GRAVITITE_BRICK_SLAB.get());
        }
    }
    public static final boolean aether;

    static {
        ModList mods = ModList.get();
        aether = mods.isLoaded("aether");
    }
}