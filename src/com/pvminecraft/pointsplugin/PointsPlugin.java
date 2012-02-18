package com.pvminecraft.pointsplugin;

import com.pvminecraft.points.PointsService;
import com.pvminecraft.points.warps.OwnedWarp;
import com.pvminecraft.points.warps.PlayerWarpManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PointsPlugin extends JavaPlugin {
    private PointsService points;

    @Override
    public void onEnable() {
        System.out.println("[PointsPlugin] Loading...");
        if(!(getPoints())) {
            System.err.println("[PointsPlugin] Couldn't find Points!");
            this.setEnabled(false);
        } else {
            System.out.println("[PointsPlugin] Found Points. Ready to go!");
            PlayerWarpManager pl = points.getPlayerManager();
            OwnedWarp warp = OwnedWarp.createWarp(getServer().getWorld("world").getSpawnLocation(), "s0lder", "s0lder");
            pl.addWarp(warp);
        }
    }

    @Override
    public void onDisable() {}
    
    private boolean getPoints() {
        ServicesManager sm = getServer().getServicesManager();
        points = sm.load(PointsService.class);
        return points != null;
    }
    
}
