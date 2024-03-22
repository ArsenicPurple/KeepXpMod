package com.basin.keepxp;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayerEventListener {
    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event) {
        if (!event.isWasDeath()) { return; }
        event.getEntity().giveExperienceLevels(event.getOriginal().experienceLevel);
    }
    @SubscribeEvent
    public void onPlayerDropExperience(LivingExperienceDropEvent event) {
        if (event.getEntity() instanceof Player) {
            event.setCanceled(true);
        }
    }
}
