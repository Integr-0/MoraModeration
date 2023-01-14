package erikr.mora;

import erikr.mora.commands.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mora extends JavaPlugin {

    public FileConfiguration config = getConfig();
    public static String version = "v1.2.15";

    @Override
    public void onEnable() {
        //Configuration
        //config.addDefault(PATH, VALUE);

        //Saving Config
        //config.options().copyDefaults(true);
        //saveConfig();

        //Registering Events
        getServer().getPluginManager().registerEvents(new freeze(), this);

        //Registering Commands
        this.getCommand("ec").setExecutor(new ec());
        this.getCommand("av").setExecutor(new av());
        this.getCommand("bfn").setExecutor(new bfn());
        this.getCommand("cr").setExecutor(new cr());
        this.getCommand("et").setExecutor(new et());
        this.getCommand("ffn").setExecutor(new ffn());
        this.getCommand("fn").setExecutor(new fn());
        this.getCommand("gs").setExecutor(new gs());
        this.getCommand("iv").setExecutor(new iv());
        this.getCommand("lm").setExecutor(new lm());
        this.getCommand("sc").setExecutor(new sc());
        this.getCommand("st").setExecutor(new st());
        this.getCommand("mora").setExecutor(new mora());
        this.getCommand("freeze").setExecutor(new freeze());
        this.getCommand("unfreeze").setExecutor(new unfreeze());
    }

    @Override
    public void onDisable() {

    }
}
