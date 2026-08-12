package kawaii.boze.addon.mixin;

import kawaii.boze.addon.KawaiiAddon;
import kawaii.boze.addon.modules.ActionBarCensor;
import net.minecraft.client.gui.Gui;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public class InGameHudMixin {

    @Inject(method = "setOverlayMessage", at = @At("HEAD"), cancellable = true)
    private void kawaii$filterActionBar(Component string, boolean animate, CallbackInfo ci) {
        ActionBarCensor module =  KawaiiAddon.action;
        if (module != null && module.shouldHide(string.getString())) {
            ci.cancel();
        }
    }
}
