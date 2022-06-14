package me.mythos.manhunt.Commands;

import me.mythos.manhunt.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HuntedCommand implements CommandExecutor {

    private Main plugin;

    public HuntedCommand(Main plugin)
    {
        this.plugin = plugin;
        plugin.getCommand("hunted").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args)
    {
        Player target = Bukkit.getPlayerExact(args[0]);

        this.plugin.huntedTeam.add(target);

        sender.sendMessage(ChatColor.AQUA + args[0] + ChatColor.YELLOW + " is now hunted");

        target.sendMessage(ChatColor.YELLOW + "You are now hunted");

        return true;
    }
}
