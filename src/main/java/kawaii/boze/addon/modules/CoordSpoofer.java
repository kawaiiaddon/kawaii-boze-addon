package kawaii.boze.addon.modules;

import dev.boze.api.addon.AddonModule;
import dev.boze.api.option.ModeOption;
import dev.boze.api.option.SliderOption;

public class CoordSpoofer extends AddonModule {


    public final ModeOption<mode> SpoofMode = new ModeOption<>(this, "mode", "", mode.Static);

    public final SliderOption seed = new SliderOption(this, "seed", "Seed used to offset coordinates.", 1000, -1000000, 1000000, 1);


    public enum mode {
        Static, Random
    }

    public CoordSpoofer() {
        super("coord-spoofer", "Spoofs coordinates in the debug screen.");
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
