package kawaii.boze.addon.modules;

import dev.boze.api.addon.AddonModule;

public class ActionBarCensor extends AddonModule {

    public ActionBarCensor() {
        super("actionbar-censor", "Hides the 2b2t.org message.");
    }

    String filter = "";
    private boolean isModuleEnabled = false;

    public boolean shouldHide(String text) {
        return isModuleEnabled && text.contains(filter);
    }


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
