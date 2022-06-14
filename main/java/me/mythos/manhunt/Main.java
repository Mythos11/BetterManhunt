package me.mythos.manhunt;

import me.mythos.manhunt.Commands.ClearHuntedCommand;
import me.mythos.manhunt.Commands.HuntedCommand;
import me.mythos.manhunt.Commands.ListHuntedCommand;
import me.mythos.manhunt.Commands.RemoveHuntedCommand;
import me.mythos.manhunt.Listeners.CompassListener;
import me.mythos.manhunt.Listeners.HuntedLeaveEvent;
import me.mythos.manhunt.Listeners.RespawnEvent;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Main extends JavaPlugin {

    public ArrayList<Player> huntedTeam = new ArrayList<>();

    @Override
    public void onEnable()
    {
        // Plugin startup logic
        new HuntedCommand(this);
        new RespawnEvent(this);
        new CompassListener(this);
        new RemoveHuntedCommand(this);
        new ClearHuntedCommand(this);
        new HuntedLeaveEvent(this);
        new ListHuntedCommand(this);
    }

    @Override
    public void onDisable()
    {
        // Plugin shutdown logic
    }
}
