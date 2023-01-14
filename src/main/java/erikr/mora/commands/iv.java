package erikr.mora.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;

public class iv implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("mora.iv")) {
                int length = args.length;
                Player input;
                Collection<? extends Player> players = Bukkit.getOnlinePlayers();

                if (length == 0) {
                    sender.sendMessage(ChatColor.GOLD + "[MORA]" + ChatColor.GRAY + " Opening!");
                    ((Player) sender).openInventory(((Player) sender).getInventory());
                } else if (length == 1) {
                    input = Bukkit.getPlayer(args[0]);
                    if (players.contains(input)) {
                        if (input != null) {
                            sender.sendMessage(ChatColor.GOLD + "[MORA]" + ChatColor.GRAY + " Opening!");
                            ((Player) sender).openInventory(input.getInventory());
                        }
                    }
                } else sender.sendMessage(ChatColor.GOLD + "[MORA]" + ChatColor.GRAY + " Too many Arguments!");
            } else sender.sendMessage(ChatColor.GOLD + "[MORA]" + ChatColor.GRAY + " No Permission!");
        }
        return true;
    }
}
