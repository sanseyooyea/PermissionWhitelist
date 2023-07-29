package work.microhand.permissionwhitelist.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import work.microhand.permissionwhitelist.PermissionWhitelist;

/**
 * @author SanseYooyea
 */
public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("permissionwhitelist.bypass")) {
            return;
        }

        event.disallow(PlayerLoginEvent.Result.KICK_WHITELIST,
                PermissionWhitelist.getInstance().getRefuseReason().replaceAll("%player_name%", player.getName()));
    }
}
