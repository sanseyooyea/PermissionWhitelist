package work.microhand.permissionwhitelist.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * @author SanseYooyea
 */
public class PluginCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
			HelpCommand.sendHelpMessage(sender, args);
            return true;
        }

        String flag = args[0].toLowerCase();
        switch (flag) {
            case "help":
                HelpCommand.sendHelpMessage(sender, args);
                break;
            case "reload":
                ReloadCommand.reloadConfig(sender, args);
                break;
            default:
                sender.sendMessage("§c| 未知的参数：" + args[0]);
                break;
        }

        return true;
    }
}
