package me.mythos.manhunt.Commands;

import me.mythos.manhunt.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RemoveHuntedCommand implements CommandExecutor {

    private Main plugin;

    public  RemoveHuntedCommand(Main plugin)
    {
        this.plugin = plugin;
        plugin.getCommand("unhunt").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args)
    {
        Player target = Bukkit.getPlayerExact(args[0]);
        
        if (target == null){
            sender.sendMessage(ChatColor.RED + args[0] + " is not a valid player");
            return false;
        }

        sender.sendMessage(ChatColor.AQUA + args[0] + ChatColor.GREEN + " is no longer hunted");

        plugin.huntedTeam.remove(args[0]);

        target.sendMessage(ChatColor.YELLOW + "You are no longer hunted");

        return true;
    }
}
