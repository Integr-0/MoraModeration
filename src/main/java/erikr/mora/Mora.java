package erikr.mora;

import erikr.mora.commands.ec;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mora extends JavaPlugin {

    public FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        //Configuration
        //config.addDefault(PATH, VALUE);

        //Saving Config
        //config.options().copyDefaults(true);
        //saveConfig();

        //Registering Events
        //getServer().getPluginManager().registerEvents(LISTENER, this);

        //Registering Commands
        this.getCommand("ec").setExecutor(new ec());
    }

    @Override
    public void onDisable() {

    }
}
