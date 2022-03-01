package de.goldendeveloper.onetimeelytra.listener;

import de.goldendeveloper.onetimeelytra.Elytra;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Objects;

public class ElyAction implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void noClick(InventoryClickEvent event) {
        try {
            if (event.getCurrentItem().getItemMeta().hasDisplayName()) {
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(Elytra.ely().getItemMeta().getDisplayName())) {
                    event.setCancelled(true);
                    event.getWhoClicked().sendMessage("§cDu darfst deine Einwegelytra nicht droppen!");
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            if (event.getCursor().getItemMeta().getDisplayName().equals(Elytra.ely().getItemMeta().getDisplayName())) {
                event.setCancelled(true);
                event.getWhoClicked().sendMessage("§cDu darfst deine EinwegElytra nicht droppen!");
            }
        } catch (NullPointerException e) {
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDrop(PlayerDropItemEvent e) {
        if (Objects.equals(e.getItemDrop().getItemStack().getItemMeta(), Elytra.ely().getItemMeta())) {
            e.getPlayer().sendMessage("§cDu darfst deine EinwegElytra nicht droppen!");
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (!Elytra.elytraLocation(p)) {
            Location loc = p.getLocation();
            Block blockunder = p.getWorld().getBlockAt(loc.getBlockX(), loc.getBlockY() - 1, loc.getBlockZ());
            if (!p.isGliding() && !blockunder.getBlockData().getMaterial().equals(Material.AIR)) {
                try {
                    if (p.getInventory().getChestplate().getItemMeta().getDisplayName().equals(Elytra.ely().getItemMeta().getDisplayName())) {
                        p.getInventory().setChestplate(null);
                    }
                } catch (NullPointerException error) {
                }
            }
        }
    }
}
