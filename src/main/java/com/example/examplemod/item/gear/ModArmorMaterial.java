package com.example.examplemod.item.gear;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import com.example.examplemod.Main;
import com.example.examplemod.item.ModItems;

import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {
    EPIC("epic", 50, new int[]{4, 7, 9, 4}, 3.0F, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> {
        return Ingredient.fromItems(ModItems.EPIC_INGOT);
    });

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final int durabilityFactor;
    private final int[] damageReductionAmount;
    private final float toughness;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final LazyValue<Ingredient> repairMaterial;
    private final String name;

    ModArmorMaterial(String name, int durabilityFactor, int[] damageReductionAmount, float toughness, int enchantability, SoundEvent soundEvent, Supplier<Ingredient> repairMaterial) {
        this.name = Main.MODID + ":" + name;
        this.durabilityFactor = durabilityFactor;
        this.damageReductionAmount = damageReductionAmount;
        this.toughness = toughness;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.repairMaterial = new LazyValue<>(repairMaterial);
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * durabilityFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return damageReductionAmount[slotIn.getIndex()];
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.getValue();
    }

    @Override
    public String getName() {
        return name;
    }
}