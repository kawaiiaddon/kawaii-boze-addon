package kawaii.boze.addon.mixin;

import dev.boze.api.BozeInstance;
import kawaii.boze.addon.KawaiiAddon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfig;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraftClient {
    @Inject(method = "<init>", at = @At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;instance:Lnet/minecraft/client/Minecraft;", opcode = Opcodes.PUTSTATIC))
    private void onInit$setInstance(GameConfig gameConfig, CallbackInfo ci) {
        BozeInstance.INSTANCE.registerAddon(new KawaiiAddon());
    }
}