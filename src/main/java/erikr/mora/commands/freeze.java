package erikr.mora.commands;

import erikr.mora.Mora;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class freeze implements CommandExecutor, Listener {
    public Inventory freezeinventory = Bukkit.createInventory(null, 45, "You are Frozen!");
    public ItemStack fillerItem = createGuiItem(Material.ORANGE_STAINED_GLASS_PANE, " ", true);
    public ItemStack infoItem = createGuiItem(Material.ORANGE_CANDLE, ChatColor.GOLD + "You are Frozen! Don't exit this Inventory!", true);
    public static boolean allowclose;


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("mora.freeze")) {
                int length = args.length;
                Player input;
                Collection<? extends Player> players = Bukkit.getOnlinePlayers();
                if (length == 1) {
                    input = Bukkit.getPlayer(args[0]);
                    if (players.contains(input)) {
                        if (input != null && !input.hasPermission("mora.freeze.bypass")) {
                            sender.sendMessage(ChatColor.GOLD + "[MORA]" + ChatColor.GRAY + " Freezing!");
                            input.sendMessage(ChatColor.GOLD + "[MORA]" + ChatColor.GRAY + " You Have been Frozen! Don't exit the window or you will be killed!");
                            openFreezeInventory(input);
                        } else sender.sendMessage(ChatColor.GOLD + "[MORA]" + ChatColor.GRAY + " Player is immune to Freezing!");
                    }
                } else sender.sendMessage(ChatColor.GOLD + "[MORA]" + ChatColor.GRAY + " Wrong Arguments!");
            } else sender.sendMessage(ChatColor.GOLD + "[MORA]" + ChatColor.GRAY + " No Permission!");
        }
        return true;
    }

    public ItemStack createGuiItem(final Material material, final String name, final boolean enchanted) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        if (enchanted) {
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        meta.setDisplayName(name);

        item.setItemMeta(meta);

        return item;
    }

    public void openFreezeInventory(Player player) {
        player.openInventory(freezeinventory);

        freezeinventory.setItem(0, fillerItem);
        freezeinventory.setItem(1, fillerItem);
        freezeinventory.setItem(2, fillerItem);
        freezeinventory.setItem(3, fillerItem);
        freezeinventory.setItem(4, fillerItem);
        freezeinventory.setItem(5, fillerItem);
        freezeinventory.setItem(6, fillerItem);
        freezeinventory.setItem(7, fillerItem);
        freezeinventory.setItem(8, fillerItem);

        freezeinventory.setItem(9, fillerItem);
        freezeinventory.setItem(10, fillerItem);
        freezeinventory.setItem(11, fillerItem);
        freezeinventory.setItem(12, fillerItem);
        freezeinventory.setItem(13, fillerItem);
        freezeinventory.setItem(14, fillerItem);
        freezeinventory.setItem(15, fillerItem);
        freezeinventory.setItem(16, fillerItem);
        freezeinventory.setItem(17, fillerItem);

        freezeinventory.setItem(18, fillerItem);
        freezeinventory.setItem(19, fillerItem);
        freezeinventory.setItem(20, fillerItem);
        freezeinventory.setItem(21, fillerItem);
        freezeinventory.setItem(22, infoItem);
        freezeinventory.setItem(23, fillerItem);
        freezeinventory.setItem(24, fillerItem);
        freezeinventory.setItem(25, fillerItem);
        freezeinventory.setItem(26, fillerItem);

        freezeinventory.setItem(27, fillerItem);
        freezeinventory.setItem(28, fillerItem);
        freezeinventory.setItem(29, fillerItem);
        freezeinventory.setItem(30, fillerItem);
        freezeinventory.setItem(31, fillerItem);
        freezeinventory.setItem(32, fillerItem);
        freezeinventory.setItem(33, fillerItem);
        freezeinventory.setItem(34, fillerItem);
        freezeinventory.setItem(35, fillerItem);

        freezeinventory.setItem(36, fillerItem);
        freezeinventory.setItem(37, fillerItem);
        freezeinventory.setItem(38, fillerItem);
        freezeinventory.setItem(39, fillerItem);
        freezeinventory.setItem(40, fillerItem);
        freezeinventory.setItem(41, fillerItem);
        freezeinventory.setItem(42, fillerItem);
        freezeinventory.setItem(43, fillerItem);
        freezeinventory.setItem(44, fillerItem);
    }

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent inventoryClickEvent) {
        if (inventoryClickEvent.getView().getTitle().equals("You are Frozen!")) {
            inventoryClickEvent.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent closeEvent) {
        if (closeEvent.getView().getTitle().equals("You are Frozen!") && closeEvent.getPlayer() instanceof Player player && !allowclose) {
            if (!player.isDead()) {
                player.setHealth(0);
            }
            player.kickPlayer(ChatColor.GOLD + "[MORA]" + ChatColor.GRAY + " You were kicked and killed because you closed the Freeze Window!");
        }
    }
}

