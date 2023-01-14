package erikr.mora.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Collection;

public class ec implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("mora.ec")) {
                int length = args.length;
                Player input;
                Collection<? extends Player> players = Bukkit.getOnlinePlayers();

                if (length == 0) {
                    ((Player) sender).openInventory(((Player) sender).getEnderChest());
                } else if (length == 1) {
                    input = Bukkit.getPlayer(args[0]);
                    if (players.contains(input)) {
                        if (input != null) {
                            input.openInventory(input.getEnderChest());
                        }
                    }
                } else sender.sendMessage(ChatColor.GOLD + "[MORA]" + ChatColor.GRAY + " Too many Arguments!");
            } else sender.sendMessage(ChatColor.GOLD + "[MORA]" + ChatColor.GRAY + " No Permission!");
        }
        return true;
    }
}
