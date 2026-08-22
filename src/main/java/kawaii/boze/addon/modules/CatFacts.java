package kawaii.boze.addon.modules;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.boze.api.addon.AddonModule;
import dev.boze.api.event.EventTick;
import dev.boze.api.option.SliderOption;
import meteordevelopment.orbit.EventHandler;
import org.apache.commons.io.IOUtils;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static kawaii.boze.addon.util.mc.mc;

public class CatFacts extends AddonModule {

    public CatFacts() {
        super("cat-facts", "cat fact :3");
    }

    public final SliderOption delay = new SliderOption(this, "delay", "delay :3", 200, 200, 10000, 1);

    private Double timer = 0.0;

    @Override
    public void onDisable() {
        super.onDisable();
        timer = (double) 0;
    }

    @EventHandler
    private void onTick(EventTick.Post event) {
        if (timer <= 0) {
            sendFact();
            timer = (double) delay.getValue();
        } else {
            timer--;
        }
    }

    @SuppressWarnings({"CallToPrintStackTrace", "deprecation"})
    private void sendFact() {
        new Thread(() -> {
            String url = "https://catfact.ninja/fact?max_length=";
            try {
                String jsonResponse = IOUtils.toString(new URL(url), StandardCharsets.UTF_8);
                JsonObject jsonObject = new JsonParser().parse(jsonResponse).getAsJsonObject();
                String fact = jsonObject.get("fact").getAsString();
                mc.execute(() -> {
                    if (mc.player != null) {
                        mc.player.connection.sendChat(fact);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}