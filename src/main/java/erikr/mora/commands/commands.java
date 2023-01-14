package erikr.mora.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;

public class commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            int length = args.length;
            if (length == 0) {
                sender.sendMessage(ChatColor.GOLD + "[MORA]" + ChatColor.GRAY + " Commands you have access to:");
                if (sender.hasPermission("mora.av")) {
                    sender.sendMessage(ChatColor.GRAY + "/av - Opens an Anvil");
                }
                if (sender.hasPermission("mora.bfn")) {
                    sender.sendMessage(ChatColor.GRAY + "/bfn - Opens a Blast Furnace");
                }
                if (sender.hasPermission("mora.cr")) {
                    sender.sendMessage(ChatColor.GRAY + "/cr - Opens a Crafting Table");
                }
                if (sender.hasPermission("mora.ec")) {
                    sender.sendMessage(ChatColor.GRAY + "/ec - Opens someones Enderchest");
                }
                if (sender.hasPermission("mora.et")) {
                    sender.sendMessage(ChatColor.GRAY + "/et - Opens an Enchanting Table");
                }
                if (sender.hasPermission("mora.ffn")) {
                    sender.sendMessage(ChatColor.GRAY + "/ffn - Opens a Smoker");
                }
                if (sender.hasPermission("mora.fn")) {
                    sender.sendMessage(ChatColor.GRAY + "/fn - Opens a Furnace");
                }
                if (sender.hasPermission("mora.gs")) {
                    sender.sendMessage(ChatColor.GRAY + "/gs - Opens a Grindstone");
                }
                if (sender.hasPermission("mora.iv")) {
                    sender.sendMessage(ChatColor.GRAY + "/av - Opens someones Inventory");
                }
                if (sender.hasPermission("mora.lm")) {
                    sender.sendMessage(ChatColor.GRAY + "/lm - Opens a Loom");
                }
                if (sender.hasPermission("mora.sc")) {
                    sender.sendMessage(ChatColor.GRAY + "/av - Opens a Stonecutter");
                }
                if (sender.hasPermission("mora.st")) {
                    sender.sendMessage(ChatColor.GRAY + "/av - Opens a Smithing Table");
                }
            } else sender.sendMessage(ChatColor.GOLD + "[MORA]" + ChatColor.GRAY + " Too many Arguments!");
        }
        return true;
    }
}
