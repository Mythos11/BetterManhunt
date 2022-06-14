package me.mythos.manhunt.Listeners;

import me.mythos.manhunt.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Random;

public class CompassListener implements Listener {

    // for huntedPlayer var if the getPlayer doesn't work
    //Bukkit.getPlayerExact(String.valueOf(this.plugin.huntedTeam));

    private Main plugin;

    public CompassListener(Main plugin)
    {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    private void CompassClick(PlayerInteractEvent e)
    {

        Player player = e.getPlayer();
        Material itemHeld = e.getItem().getType();
        Action action = e.getAction();

        if (!(plugin.huntedTeam.contains(player.getName())) && itemHeld == Material.COMPASS && ( action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK ))
        {
            Random r = new Random();
            Player huntedPlayers = plugin.huntedTeam.get(r.nextInt(plugin.huntedTeam.size() + 0));

            player.setCompassTarget(huntedPlayers.getLocation());

            for (Player huntedPlayer : plugin.huntedTeam)
            {
                player.sendMessage(ChatColor.YELLOW + "Now tracking: " + ChatColor.AQUA + huntedPlayer.getName());
            }
        }
    }

}
