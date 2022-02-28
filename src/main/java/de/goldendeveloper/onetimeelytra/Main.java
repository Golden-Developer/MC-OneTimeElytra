package de.goldendeveloper.onetimeelytra;

import de.goldendeveloper.onetimeelytra.listener.ElyAction;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;
        Elytra.elytra();
        Bukkit.getPluginManager().registerEvents(new ElyAction(), this);

        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§8--------------------------");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§6Plugin erfolgreich gestartet!");
        Bukkit.getConsoleSender().sendMessage("§bDeveloped by Golden-Developer");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§8--------------------------");
        Bukkit.getConsoleSender().sendMessage("");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§8--------------------------");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§6Plugin erfolgreich gestoppt!");
        Bukkit.getConsoleSender().sendMessage("§bDeveloped by Golden-Developer");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§8--------------------------");
        Bukkit.getConsoleSender().sendMessage("");
    }

    public static Main getPlugin() {
        return plugin;
    }
}
