package kawaii.boze.addon;

import com.mojang.logging.LogUtils;
import dev.boze.api.BozeInstance;
import dev.boze.api.addon.Addon;
import dev.boze.api.render.ClientColor;
import dev.boze.api.render.ColorMaker;
import kawaii.boze.addon.commands.*;
import kawaii.boze.addon.modules.*;
import org.slf4j.Logger;

public class KawaiiAddon extends Addon {
    public static final Logger LOG = LogUtils.getLogger();

    //boze client api stuff
    public static final String ID = "kawaii-boze-addon";
    public static final String NAME = "KawaiiBoze Addon";
    public static final String DESCRIPTION = "A Boze Client addon that displays catgirl images + more, adding some kawaii flair to your client!.";
    public static final String VERSION = "1.0";
    public static final String BRAND = "Kawaii";
    public static final ClientColor BRAND_COLOR = ColorMaker.staticColor(245, 99, 250);

    public KawaiiAddon() {
        super(ID, NAME, DESCRIPTION, VERSION);
    }

    public static ActionBarCensor action;
    public static CoordSpoofer spoofer;

    @Override
    public boolean initialize() {
        LOG.info("Loading kawaii-boze-addon...");

        //modules
        action = new ActionBarCensor();
        modules.add(action);
        spoofer = new CoordSpoofer();
        modules.add(spoofer);

        //commands
        dispatcher.registerCommand(new Cuddle());
        dispatcher.registerCommand(new CrashOut());
        dispatcher.registerCommand(new Dupe());
        dispatcher.registerCommand(new Rat());

        //hud
        //soon...

        //load stuff
        createCategory("Kawaii");
        BozeInstance.INSTANCE.registerPackage("kawaii.boze.addon");
        return true;
    }
}
