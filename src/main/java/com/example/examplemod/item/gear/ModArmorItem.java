package com.example.examplemod.item.gear;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class ModArmorItem extends ArmorItem {
    public ModArmorItem(ModArmorMaterial materialIn, EquipmentSlotType slot, Properties properties) {
        super(materialIn, slot, properties);
    }
}
