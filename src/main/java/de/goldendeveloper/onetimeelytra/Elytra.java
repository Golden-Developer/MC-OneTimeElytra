package de.goldendeveloper.onetimeelytra;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Elytra {

    public static void elytra() {
        int id = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (elytraLocation(p)) {
                    try {
                        if (!Objects.equals(p.getInventory().getChestplate(), ely())) {
                            p.sendMessage("Du hast eine Elytra bekommen!");
                            if (p.getInventory().getChestplate() != null && !Objects.equals(p.getInventory().getChestplate().getItemMeta(), ely().getItemMeta())) {
                                if (p.getInventory().firstEmpty() == -1) {
                                    p.getWorld().dropItemNaturally(p.getLocation(), p.getInventory().getChestplate());
                                    p.sendMessage("<------ OneTimeElytra ------>");
                                    p.sendMessage("§4Vergiss nicht deine Brustplatte, sie wurde gedroppt!");
                                    p.sendMessage("<--------------------------->");
                                } else {
                                    p.getInventory().addItem(p.getInventory().getChestplate());
                                }
                            }
                        }
                    } catch (NullPointerException e) {
                    }
                    p.getInventory().setChestplate(ely());
                }
            }
        }, 0L, 20L);
    }

    public static boolean elytraLocation(Player p) {
        Location loc = p.getLocation();
        boolean el = false;
        int DisX = 6;
        int DisY = 6;
        int DisZ = 6;
        int maxDisX = p.getWorld().getSpawnLocation().getBlockX() + DisX;
        int minDisX = p.getWorld().getSpawnLocation().getBlockX() - DisX;
        int maxDisY = p.getWorld().getSpawnLocation().getBlockY() + DisY;
        int minDisY = p.getWorld().getSpawnLocation().getBlockY() - DisY;
        int maxDisZ = p.getWorld().getSpawnLocation().getBlockZ() + DisZ;
        int minDisZ = p.getWorld().getSpawnLocation().getBlockZ() - DisZ;
        int locX = loc.getBlockX();
        int locY = loc.getBlockY();
        int locZ = loc.getBlockZ();
        if (locX < maxDisX && locX > minDisX && locY < maxDisY && locY > minDisY && locZ < maxDisZ && locZ > minDisZ)
            el = true;
        return el;
    }

    public static ItemStack ely() {
        ItemStack ely = new ItemStack(Material.ELYTRA);
        ItemMeta elyMeta = ely.getItemMeta();
        elyMeta.setDisplayName(ChatColor.YELLOW + "EinwegElytra");
        elyMeta.setUnbreakable(true);
        List<String> Lore = new ArrayList<>();
        Lore.add(" ");
        Lore.add("EinwegElytra");
        Lore.add("Überlege dir gut wo du landest!");
        Lore.add(" ");
        elyMeta.setLore(Lore);
        elyMeta.addEnchant(Enchantment.LUCK, 1, true);
        ely.setItemMeta(elyMeta);
        return ely;
    }
}
