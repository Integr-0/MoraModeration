package erikr.mora.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;

public class lm implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("mora.lm")) {
                int length = args.length;

                if (length == 0) {
                    sender.sendMessage(ChatColor.GOLD + "[MORA]" + ChatColor.GRAY + " Opening!");
                    ((Player) sender).openInventory(Bukkit.createInventory(null, InventoryType.LOOM));
                } else sender.sendMessage(ChatColor.GOLD + "[MORA]" + ChatColor.GRAY + " Too many Arguments!");
            } else sender.sendMessage(ChatColor.GOLD + "[MORA]" + ChatColor.GRAY + " No Permission!");
        }
        return true;
    }
}
