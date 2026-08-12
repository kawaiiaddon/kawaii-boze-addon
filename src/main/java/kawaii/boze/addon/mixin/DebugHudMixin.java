package kawaii.boze.addon.mixin;

import kawaii.boze.addon.KawaiiAddon;
import kawaii.boze.addon.modules.CoordSpoofer;
import kawaii.boze.addon.util.MathSecret;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.DebugScreenOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;



import java.util.List;
import java.util.Locale;

@Mixin(DebugScreenOverlay.class)
public class DebugHudMixin {

    @Unique
    private float spoof(float num, float multiplier) {
        CoordSpoofer mod = KawaiiAddon.spoofer;

        if (mod == null) return num;

        Double seed = mod.seed.getValue();

        CoordSpoofer spoofer = KawaiiAddon.spoofer;

        float offset = 0;

        if (spoofer != null) {
            if (spoofer.SpoofMode.getValue() == CoordSpoofer.mode.Static) {
                offset = MathSecret.transform(seed, multiplier);
            } else if (spoofer.SpoofMode.getValue() == CoordSpoofer.mode.Random) {
                offset = MathSecret.RandomTransform(seed);
            }
        }

        return seed >= 0 ? num + offset : num - offset;
    }

    @Inject(method = "extractLines", at = @At("HEAD"))
    private void spoofCoordLines(GuiGraphicsExtractor graphics, List<String> lines, boolean alignLeft, CallbackInfo ci) {
        CoordSpoofer mod = KawaiiAddon.spoofer;

        if (mod == null || !mod.isModuleEnabled) return;

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);

            if (line.contains("XYZ: ")) {
                String coords = line.substring(line.indexOf("XYZ: ") + 5);
                String[] pos = coords.split(" / ");

                if (pos.length >= 3) {
                    try {
                        float x = Float.parseFloat(pos[0]);
                        float y = Float.parseFloat(pos[1]);
                        float z = Float.parseFloat(pos[2]);

                        lines.set(i, String.format(
                            Locale.ROOT,
                            "XYZ: %.3f / %.5f / %.3f",
                            spoof(x, 0.75f),
                            y,
                            spoof(z, 1.25f)
                        ));
                    } catch (NumberFormatException ignored) {}
                }
            }
        }
    }
}
