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

public class unfreeze implements CommandExecutor, Listener {

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
                        if (input != null) {
                            if (input.getOpenInventory().getTitle().equals("You are Frozen!")) {
                                sender.sendMessage(ChatColor.GOLD + "[MORA]" + ChatColor.GRAY + " Unfreezing!");
                                input.sendMessage(ChatColor.GOLD + "[MORA]" + ChatColor.GRAY + " You Have been Unfrozen!");
                                freeze.allowclose = true;
                                input.getOpenInventory().close();
                                freeze.allowclose = false;
                            } else sender.sendMessage(ChatColor.GOLD + "[MORA]" + ChatColor.GRAY + " The Player is not frozen!");
                        }
                    }
                } else sender.sendMessage(ChatColor.GOLD + "[MORA]" + ChatColor.GRAY + " Wrong Arguments!");
            } else sender.sendMessage(ChatColor.GOLD + "[MORA]" + ChatColor.GRAY + " No Permission!");
        }
        return true;
    }
}

