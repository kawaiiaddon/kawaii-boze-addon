package kawaii.boze.addon.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import dev.boze.api.addon.AddonCommand;
//import kawaii.addon.v2.real.modules.Troll;
import kawaii.boze.addon.KawaiiAddon;
import kawaii.boze.addon.util.PlayerPosition;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.SharedSuggestionProvider;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;
import static kawaii.boze.addon.util.mc.mc;

public class Cuddle extends AddonCommand {

    public Cuddle() {
        super("cuddler", "Sends ur coords in public chat :D");
    }

    @Override
    public void build(LiteralArgumentBuilder<SharedSuggestionProvider> builder) {
        builder.executes(_ -> {
            Minecraft client = Minecraft.getInstance();
            PlayerPosition pos = new PlayerPosition();

            if (client.player != null) {
                //if ur seeing this is for CoOrdLeakerCommand this doesn't execute on its own!
                assert mc.player != null;
                mc.player.connection.sendChat(String.format("Cuddle with me at coords owo: X: %d, Y: %d, Z: %d in the %s", Math.round(pos.getX()), Math.round(pos.getY()), Math.round(pos.getZ()), pos.getDimension()));
                //if (Modules.get().get(Troll.class).isActive()) {
                //    mc.player.setDeltaMovement(0, 9e99, 0);
                //}
            } else {
                KawaiiAddon.LOG.error("skill issue thb.");
            }
            return SINGLE_SUCCESS;
        });
    }
}
