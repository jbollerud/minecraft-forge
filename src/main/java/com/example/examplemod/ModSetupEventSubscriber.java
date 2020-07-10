package com.example.examplemod;

import com.example.examplemod.item.ModItemGroups;
import com.example.examplemod.item.gear.ModSwordItem;
import com.example.examplemod.item.gear.ModToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetupEventSubscriber {
    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                setup(new Item(getModItemProperties()), "epic_ingot"));

                setup(new ModSwordItem(ModToolMaterial.EPIC, getModItemProperties()), "epic_sword");

    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
        return setup(entry, new ResourceLocation(Main.MODID, name));
    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
        entry.setRegistryName(registryName);
        return entry;
    }

    public static Item.Properties getModItemProperties() {
        return new Item.Properties().group(ModItemGroups.EPIC_ITEM_GROUP);
    }
}



