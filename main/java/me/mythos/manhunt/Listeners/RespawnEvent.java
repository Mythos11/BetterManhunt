package me.mythos.manhunt.Listeners;

import me.mythos.manhunt.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class RespawnEvent implements Listener {

    private Main plugin;

    public RespawnEvent(Main plugin)
    {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    private void PlayerRespawnEvent(PlayerRespawnEvent e)
    {
        Player player = e.getPlayer();

        if (!(this.plugin.huntedTeam.contains(player.getName())))
        {
            player.getInventory().addItem(new ItemStack(Material.COMPASS));
        }
        else
        {
            player.sendMessage(ChatColor.RED + "You are hunted so no compass");
        }
    }

}
