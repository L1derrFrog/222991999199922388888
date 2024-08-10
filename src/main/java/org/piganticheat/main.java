package com.L1derrFrog.PigAntiCheat;

import org.bukkit.plugin.java.JavaPlugin;
import com.L1derrFrog.PigAntiCheat.events.*;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new VehicleSpeedLimitListener(), this);
        getServer().getPluginManager().registerEvents(new MultiHitPreventionListener(), this);
        getServer().getPluginManager().registerEvents(new InvulnerabilityPreventionListener(), this);
        getServer().getPluginManager().registerEvents(new InteractionSpamPreventionListener(), this);
        getServer().getPluginManager().registerEvents(new BlockPlacePreventionListener(), this);
        getServer().getPluginManager().registerEvents(new SpamKickListener(), this);

        getLogger().info("Successfully enabled PigAntiCheat");
    }

    @Override
    public void onDisable() {
        getLogger().info("Successfully disabled PigAntiCheat");
    }
}
