package me.mythos.manhunt.Commands;

import me.mythos.manhunt.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ClearHuntedCommand implements CommandExecutor {

   private Main plugin;

   public ClearHuntedCommand(Main plugin)
   {
       this.plugin = plugin;
       plugin.getCommand("clearhunted").setExecutor(this);
   }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args)
    {
        if (plugin.huntedTeam.isEmpty())
        {
            sender.sendMessage(ChatColor.RED + "No Players are being hunted");
        } else
        {
            plugin.huntedTeam.clear();
            sender.sendMessage(ChatColor.GREEN + "Players no longer hunted");
        }
        return true;
    }
}
