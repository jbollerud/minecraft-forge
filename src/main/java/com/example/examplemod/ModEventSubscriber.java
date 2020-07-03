package com.example.examplemod;

import net.minecraft.entity.Entity;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ModEventSubscriber {
    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        Entity entity = event.getEntity();
        World world = entity.getEntityWorld();
        world.createExplosion(entity,entity.getPosX(), entity.getPosY(), entity.getPosZ(), 30, Explosion.Mode.DESTROY);
    }
}
