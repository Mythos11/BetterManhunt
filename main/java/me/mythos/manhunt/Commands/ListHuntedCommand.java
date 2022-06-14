package me.mythos.manhunt.Commands;

import me.mythos.manhunt.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ListHuntedCommand implements CommandExecutor {

    private Main plugin;

    public ListHuntedCommand(Main plugin)
    {
        this.plugin = plugin;
        plugin.getCommand("listhunted").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args)
    {
        for (Player huntedPlayer : plugin.huntedTeam)
        {
            sender.sendMessage(ChatColor.YELLOW + "Current Hunted: " + ChatColor.AQUA + huntedPlayer.getName());
        }

        if (plugin.huntedTeam.isEmpty())
        {
            sender.sendMessage(ChatColor.YELLOW + "No hunted players");
        }

        return true;
    }
}
