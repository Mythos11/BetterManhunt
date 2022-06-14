package me.mythos.manhunt.Listeners;

import me.mythos.manhunt.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class HuntedLeaveEvent implements Listener {

    private Main plugin;

    public HuntedLeaveEvent(Main plugin)
    {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    private void HuntedLeave(PlayerQuitEvent e)
    {
        Player hunterLeft = e.getPlayer();

        plugin.huntedTeam.remove(hunterLeft);
    }

}
