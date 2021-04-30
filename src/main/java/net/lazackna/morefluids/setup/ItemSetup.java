package net.lazackna.morefluids.setup;

import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ItemSetup {

    public static RegistryObject<Item> SILVER_INGOT;
    public static RegistryObject<Item> MILK_BUCKET;

    static void register () {
        SILVER_INGOT = Registration.ITEMS.register("silver_ingot", () ->
                new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
        MILK_BUCKET = Registration.ITEMS.register("milk_bucket", () ->
                new BucketItem(() -> FluidSetup.milk, new Item.Properties().tab(ItemGroup.TAB_MISC).stacksTo(1)));

    }


}
