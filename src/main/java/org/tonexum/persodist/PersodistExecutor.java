package org.tonexum.persodist;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PersodistExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
                             @NotNull String label, @NotNull String[] argv) {
        if (argv.length < 3) {
            sender.sendPlainMessage("Usage: /persodist (mode) (type) (player) [distance]");
            return true;
        }
        Player player = Bukkit.getPlayer(argv[2]);
        if (player == null) {
            sender.sendPlainMessage("This player does not exist");
            return true;
        }
        switch (argv[0]) {
            case "get": {
                switch (argv[1]) {
                    case "view": {
                        sender.sendPlainMessage(player.getName() + " can see §3"
                                + player.getViewDistance() + "§r chunks far");
                        return true;
                    }
                    case "sim": {
                        sender.sendPlainMessage(player.getName() + " simulates §3"
                                + player.getSimulationDistance() +"§r chunks far");
                        return true;
                    }
                    default: {
                        sender.sendPlainMessage("Type must either be 'view' for view distance or " +
                                "'sim' for simulation distance");
                        return true;
                    }
                }
            }
            case "set": {
                if (argv.length < 4) {
                    sender.sendPlainMessage("Not enough arguments");
                    return true;
                }
                int dist;
                try {
                    dist = Integer.parseInt(argv[3]);
                } catch (NumberFormatException e) {
                    sender.sendPlainMessage("No valid number was provided");
                    return true;
                }
                switch (argv[1]) {
                    case "view": {
                        if (dist < 2 || dist > 32) {
                            sender.sendPlainMessage("The distance must be between 2, 32 or any " +
                                    "value between");
                            return true;
                        }
                        player.setViewDistance(dist);
                        return true;
                    }
                    case "sim": {
                        if (dist < 2 || dist > 32) {
                            sender.sendPlainMessage("The distance must be between 2, 32 or any " +
                                    "value between");
                            return true;
                        }
                        player.setSimulationDistance(dist);
                        return true;
                    }
                    default: {
                        sender.sendPlainMessage("Type must either be 'view' for view distance or " +
                                "'sim' for simulation distance");
                        return true;
                    }
                }
            }
            default: {
                sender.sendPlainMessage("Mode must either be 'set' to set a value or 'get' to get" +
                        " one");
                return true;
            }
        }
    }
}
