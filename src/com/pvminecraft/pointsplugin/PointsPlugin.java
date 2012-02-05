package com.pvminecraft.pointsplugin;

import com.pvminecraft.points.PointsService;
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
