package kawaii.boze.addon.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import dev.boze.api.addon.AddonCommand;
import net.minecraft.commands.SharedSuggestionProvider;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;
import static kawaii.boze.addon.util.mc.mc;

public class Rat extends AddonCommand {

    public Rat() {
        super("RatArt", "type a rat in ASCII art in chat.");
    }

    //this doesn't rat you, it's a joke it shows ASCII art of a rat, the ASCII art source is in Class BigRatString.
    @Override
    public void build(LiteralArgumentBuilder<SharedSuggestionProvider> builder) {
        builder.executes(_ -> {
            BigRatString rat = new BigRatString();
            String[] lines = {
                rat.d,  rat.d1, rat.d3, rat.d5, rat.d4, rat.d6,
                rat.d8, rat.d7, rat.d9, rat.e1, rat.e2, rat.e3,
                rat.e4, rat.e5, rat.e6, rat.e7, rat.e8, rat.e9,
                rat.f,  rat.e,  rat.y,  rat.h
            };
            for (String line : lines) {
                assert mc.player != null;
                mc.player.connection.sendChat(line);
            }
            return SINGLE_SUCCESS;
        });
    }
}
