package com.example.examplemod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collection;

@Mod.EventBusSubscriber(modid = Main.MODID)
public class ModEventSubscriber {
    @SubscribeEvent
//    public static void onEntityDeath(LivingDeathEvent event) {
//        Entity entity = event.getEntity();
//        World world = entity.getEntityWorld();
//        world.createExplosion(entity,entity.getPosX(), entity.getPosY(), entity.getPosZ(), 10, Explosion.Mode.DESTROY);
//    }

    @SubscribeEvent
    public static void onEntityDropItems(LivingDropsEvent event) {
        Collection<ItemEntity> entityDrops = event.getDrops();
        for (ItemEntity itemEntity : entityDrops) {
            ItemStack stack = itemEntity.getItem();
            stack.setCount(stack.getCount() * 4);
            itemEntity.setItem(stack);
        }
    }
}