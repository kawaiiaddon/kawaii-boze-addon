package kawaii.boze.addon.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import dev.boze.api.addon.AddonCommand;
import dev.boze.api.utility.ChatHelper;
import net.minecraft.commands.SharedSuggestionProvider;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class Dupe extends AddonCommand {

    public Dupe() {
        super("dupe", "Client-side fake dupe command");
    }

    @Override
    public void build(LiteralArgumentBuilder<SharedSuggestionProvider> builder) {
        builder.executes(_ -> {
            ChatHelper.sendMsg("Get baited Dumb Ass!");
            return SINGLE_SUCCESS;
        });
    }
}
