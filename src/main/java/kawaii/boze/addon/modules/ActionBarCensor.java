package kawaii.boze.addon.modules;

import dev.boze.api.addon.AddonModule;

public class ActionBarCensor extends AddonModule {

    public ActionBarCensor() {
        super("actionbar-censor", "Hides the 2b2t.org message.");
    }

    String filter = "";

    public boolean shouldHide(String text) {
        return text.contains(filter);
    }


    @Override
    public void onDisable() {
        super.onDisable();
        return;
    }
}
