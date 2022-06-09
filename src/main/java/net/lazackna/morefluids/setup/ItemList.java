package net.lazackna.morefluids.setup;

import net.lazackna.morefluids.objects.fluids.Test;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ItemList {

    public static RegistryObject<Item> SILVER_INGOT;
    public static RegistryObject<Item> MILK_BUCKET;

    public static RegistryObject<Item> MILK_BUCKET_CRAFTABLE;


    static void register () {
        WaterFluid
        SILVER_INGOT = Registration.ITEMS.register("silver_ingot", () ->
                new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
        MILK_BUCKET = Registration.ITEMS.register("milk_bucket_craftable", () ->
                new BucketItem(() -> FluidList.MILK_SOURCE.get(), new Item.Properties().tab(ItemGroup.TAB_MISC).stacksTo(1)));
//        MILK_BUCKET_CRAFTABLE = Registration.ITEMS.register("milk_bucket_craftable", () ->
//                new Item(new Item.Properties().tab(ItemGroup.TAB_MISC).stacksTo(1)));
        //AAA = Registration.BLOCKS.register("aaa", () -> new Test(() -> FluidList.MILK.getFluid(), AbstractBlock.Properties.of(Material.WATER)));

    }


}
