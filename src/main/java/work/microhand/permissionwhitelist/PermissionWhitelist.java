package work.microhand.permissionwhitelist;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import work.microhand.permissionwhitelist.command.PluginCommand;
import work.microhand.permissionwhitelist.listener.PlayerJoinListener;

import java.util.Objects;

/**
 * @author SanseYooyea
 */
public final class PermissionWhitelist extends JavaPlugin {

    private static PermissionWhitelist instance;
    private String refuseReason;

    public PermissionWhitelist() {
        instance = this;
    }

    public static PermissionWhitelist getInstance() {
        return instance;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    @Override
    public void onEnable() {
        getLogger().info("§a| §2PermissionWhitelist §a插件启动中...");
        getLogger().info("§a| 作者：§2SanseYooyea");
        getLogger().info("§a| QQ：§21187586838");

        loadConfig();
        registerCommand();
        registerListener();
    }

    @Override
    public void onDisable() {
        getLogger().info("§a| §2PermissionWhitelist §a插件关闭中...");
        getLogger().info("§a| 作者：§2SanseYooyea");
        getLogger().info("§a| QQ：§21187586838");
    }

    public void loadConfig() {
        saveDefaultConfig();
        reloadConfig();
        refuseReason = getConfig().getString("refuse-reason");
    }

    private void registerCommand() {
        Objects.requireNonNull(getCommand("pw")).setExecutor(new PluginCommand());
    }

    private void registerListener() {
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }
}
