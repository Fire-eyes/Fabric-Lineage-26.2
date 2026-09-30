package net.fire_eyes.lineagemod.networking;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fire_eyes.lineagemod.networking.packet.TestPayloadC2S;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityTypes;

// HERE WE ARE ON THE SERVER
public class ServerboundPackets {
    public static void handleTestPayload(TestPayloadC2S testPayloadC2S, ServerPlayNetworking.Context context) {
        EntityTypes.COW.spawn(context.player().level(), context.player().getOnPos(), EntitySpawnReason.TRIGGERED);
    }
}
