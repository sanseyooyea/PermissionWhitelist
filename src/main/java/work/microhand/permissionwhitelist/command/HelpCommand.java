package work.microhand.permissionwhitelist.command;

import org.bukkit.command.CommandSender;

/**
 * @author SanseYooyea
 */
public class HelpCommand {
    public static void sendHelpMessage(CommandSender sender, String[] args) {
        if (!sender.hasPermission("permissionwhitelist.command.help")) {
            sender.sendMessage("§c| §4你没有权限执行此命令！");
            return;
        }

        if (args.length != 0 && args.length != 1) {
            sender.sendMessage("§c| §4命令格式错误！");
            sender.sendMessage("§a| §2正确格式：/pw help");
            return;
        }

        sender.sendMessage("§a| §2PermissionWhitelist §a插件帮助");
        sender.sendMessage("§a| §2/pw help §a查看帮助");
        sender.sendMessage("§a| §2/pw reload §a重载配置文件");
    }
}
