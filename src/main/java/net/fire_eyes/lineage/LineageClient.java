package net.fire_eyes.lineage;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fire_eyes.lineage.keymapping.ModKeyMappings;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public class LineageClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModKeyMappings.register();

        ClientTickEvents.END_CLIENT_TICK.register(LineageClient::onEndTick);
    }

    public static void onEndTick(Minecraft client) {
        while(ModKeyMappings.PRIMARY_ACTIVE_ABILITY.consumeClick()) {
            assert client.player != null;
            client.player.sendSystemMessage(Component.literal("I just pressed the Primary Key (Default: Z)"));
        }
        while(ModKeyMappings.SECONDARY_ACTIVE_ABILITY.consumeClick()) {
            assert client.player != null;
            client.player.sendSystemMessage(Component.literal("I just pressed the Secondary Key (Default: G)"));
        }
    }
}
