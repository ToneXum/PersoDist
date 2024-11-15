package org.tonexum.persodist;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersodistCompleter implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender,
                                                @NotNull Command command, @NotNull String label,
                                                @NotNull String[] argv) {
        switch (argv.length) {
            case 1: {
                return List.of("get", "set");
            }
            case 2: {
                return List.of("view", "sim");
            }
            case 3: {
                Collection<? extends Player> coll = Bukkit.getOnlinePlayers();
                ArrayList<String> names = new ArrayList<>();
                for (Player player : coll) {
                    names.add(player.getName());
                }
                return names;
            }
            case 4: {
                return List.of("(number)");
            }
            default: {
                return List.of("");
            }
        }
    }
}
