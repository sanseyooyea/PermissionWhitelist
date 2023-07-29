package work.microhand.permissionwhitelist.command;

import org.bukkit.command.CommandSender;
import work.microhand.permissionwhitelist.PermissionWhitelist;

/**
 * @author SanseYooyea
 */
public class ReloadCommand {
    public static void reloadConfig(CommandSender sender, String[] args) {
        if (sender.hasPermission("permissionwhitelist.command.reload")) {
            sender.sendMessage("§c| §4你没有权限执行此命令！");
            return;
        }

        if (args.length != 1) {
            sender.sendMessage("§c| §4命令格式错误！");
            sender.sendMessage("§a| §2正确格式：/pw reload");
            return;
        }

        sender.sendMessage("§a| §2PermissionWhitelist §a插件重载中...");
        PermissionWhitelist.getInstance().loadConfig();
        sender.sendMessage("§a| §2PermissionWhitelist §a插件重载完成！");
    }
}
