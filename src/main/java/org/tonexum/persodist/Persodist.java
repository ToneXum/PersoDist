package org.tonexum.persodist;

import org.bukkit.Server;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Persodist extends JavaPlugin {
    PluginManager pm;
    Server svr;
    Logger lgr;

    @Override
    public void onEnable() {
        svr = getServer();
        pm = svr.getPluginManager();
        lgr = getLogger();

        PluginCommand persoDist = getCommand("persodist");
        assert persoDist != null;
        persoDist.setExecutor(new PersodistExecutor());
        persoDist.setTabCompleter(new PersodistCompleter());
    }

    @Override
    public void onDisable() {
        /* Nothing... */
    }
}
