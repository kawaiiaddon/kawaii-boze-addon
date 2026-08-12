package kawaii.boze.addon.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import dev.boze.api.addon.AddonCommand;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.SharedSuggestionProvider;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class CrashOut extends AddonCommand {

    public CrashOut() {
        super("crashout", "No more ragebait.");
    }

    @Override
    public void build(LiteralArgumentBuilder<SharedSuggestionProvider> builder) {
        builder.executes(_ -> {
            Minecraft.getInstance().stop();
            return SINGLE_SUCCESS;
        });
    }
}

class BigRatString {
    //you found the Easter egg lol in the source code, congrats
    String d =  "⠀⠀⠀⠀⠀⠀⠀⠀          ⢀⣴⠖⣤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀           ";
    String d1 = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡎⡇⠀⢘⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀            ";
    String d3 = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡂⠘⠀⠚⠘⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀            ";
    String d5 = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢳⠀⠀⠰⠄⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀            ";
    String d4 = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⢸⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀            ";
    String d6 = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢡⠀⠀⠀⡀⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀            ";
    String d8 = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⢀⡀⠀⠀⠀⠀⠈⢇⠀⠀⠉⠀⡟⠓⢦⠀⠀⠀⠀⠀⠀⠀⠀           ";
    String d7 = "⠀⠀⠀⠀⣀⡤⡀⠀⠀⢠⢋⠔⠀⠈⢦⠀⠀⠀⠀⠘⡄⠀⠀⠀⢱⠀⠀⢳⣤⣀⠀⠀⠀⠀⠀          ";
    String d9 = "⠀⠀⠀⠸⠁⠘⡌⢦⠀⡇⡎⠀⠀⠀⢨⠀⢰⠒⠉⠉⠱⢄⠀⠀⢠⠳⠀⢤⣹⡀⠑⢤⣀⠀⠀         ";
    String e1  = "⠀⠀⠀⠸⡀⢀⡧⢖⡉⠁⠁⠀⠀⣀⣼⠖⠓⠢⠀⠀⠲⠆⠀⠀⠀⢣⠀⠀⠀⢇⢠⠀⠙⢷⠀          ";
    String e2  = "⠀⠀⠀⢠⠟⠁⠀⠈⠁⠀⠀⠀⠀⠀⢷⠀⠀⠹⠀⠀⠀⡆⠀⠀⠀⢸⠀⠀⠀⠸⡇⠀⠀⠈⡇            ";
    String e3  = "⢀⡠⠚⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢏⢇⠀⠀⠀⠀⠀⠸⠀⠀⠀⠸⠀⠀⠀⠀⡇⠀⠀⢠⡀             ";
    String e4  = "⠉⠚⠒⠤⢀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⠀⠀⠀⠀⠀⠀⢇⠀⠀⠀⠃⠀⠀⠀⠁⠀⠀⡜⠀             ";
    String e5  = "⠀⠀⠀⠀⠀⠀⠉⢢⠀⠀⠀⠀⠀⠀⠀⠀⢇⠀⠀⠀⠸⡄⠘⠆⠀⠀⠀⠀⠀⠀⠀⠀⢠⠃⠀              ";
    String e6  = "⠀⠀⠀⠀⠀⠀⠀⢀⠀⡀⠀⠀⠀⠀⠀⠀⠘⣆⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠎⠀⠀               ";
    String e7  = "⠀⠀⠀⠀⠀⠀⠀⢸⠀⠹⡄⢸⠀⠀⠀⠀⠀⠘⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⠋⠀⠀⠀               ";
    String e8  = "⠀⠀⠀⠀⠀⠀⠀⠀⢇⠀⠙⣼⡆⠀⠀⠀⠀⠀⠘⢦⣀⠀⠀⠀⠀⠀⠀⠀⢀⠜⠁⠀⠀⠀⠀               ";
    String e9  = "⠀⠀⠀⠀⠀⠀⠀⠀⠈⠓⢼⡏⠧⣄⠠⠄⠀⠀⠀⠀⠈⢯⠒⠒⠂⠤⠐⠒⠁⠀⠀⠀⠀⠀⠀             ";
    String f  = "⠀⠀⠀⠀⠀⢀⢀⣀⡠⠶⣀⠑⠟⠉⠒⣤⡀⠀⠀⠀⠀⠘⣄⠀⠀⠀⠀⢀⢀⠀⠀⠀⠀⠀⠀             ";
    String e  = "⠀⠀⠀⠀⠀⠈⠛⠒⠒⠒⠛⠛⠃⠀⠀⠀⠉⠒⢤⣀⣠⣞⠻⢭⣗⡖⠤⢬⣉⣙⣻⣷⡆⠀⠀           ";
    String y  = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠯⣉⠀⠙⠢⣀⠈⠉⠐⠓⠚⠂⠉⠁⠀⠀              ";
    String h  = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠑⢦⣦⣶⠷⠒⠀⠀⠀⠀⠀⠀⠀⠀                ";
}
