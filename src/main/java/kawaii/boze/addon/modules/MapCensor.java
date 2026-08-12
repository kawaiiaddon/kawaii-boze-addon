package kawaii.boze.addon.modules;

import dev.boze.api.addon.AddonModule;
import dev.boze.api.option.ModeOption;
import net.minecraft.resources.Identifier;

public class MapCensor extends AddonModule {

    public MapCensor() {
        super("map-censor", "Replaces maps with a picture.");
    }

    public final ModeOption<Mode> mode = new ModeOption<>(this, "picture", "Which image to display on the map.", Mode.pileton);


    public enum Mode {
        Rem, rip, punkalopi, pileton, catgirl, smoke
    }

    public Identifier getTexture() {
        return switch (mode.getValue()) { //todo: fix path
            case catgirl -> Identifier.fromNamespaceAndPath("kawaii-addon", "censor/catgirl.png");
            case pileton -> Identifier.fromNamespaceAndPath("kawaii-addon", "censor/pileton.png");
            case punkalopi -> Identifier.fromNamespaceAndPath("kawaii-addon", "censor/punkalopi.png");
            case rip -> Identifier.fromNamespaceAndPath("kawaii-addon", "censor/rip.png");
            case Rem -> Identifier.fromNamespaceAndPath("kawaii-addon", "censor/rem.png");
            case smoke -> Identifier.fromNamespaceAndPath("kawaii-addon", "censor/smoke.png");
        };
    }

    public boolean isModuleEnabled = false;

    @Override
    public void onEnable() {
        super.onEnable();
        isModuleEnabled = true;
    }

    @Override
    public void onDisable() {
        super.onDisable();
        isModuleEnabled = false;
    }
}
