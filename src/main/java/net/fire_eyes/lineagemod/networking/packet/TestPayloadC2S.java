package net.fire_eyes.lineagemod.networking.packet;

import net.fire_eyes.lineagemod.LineageMod;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record TestPayloadC2S(String name, int value) implements CustomPacketPayload {

    public static final Type<TestPayloadC2S> TYPE = new Type<>(
            Identifier.fromNamespaceAndPath(LineageMod.MOD_ID, "test_payload"));

    //LESSON: # Networking: Codec Crash Course #
    public static final StreamCodec<RegistryFriendlyByteBuf, TestPayloadC2S> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8,
            TestPayloadC2S::name,

            ByteBufCodecs.VAR_INT,
            TestPayloadC2S::value,

            //Constructor
            TestPayloadC2S::new);



    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
