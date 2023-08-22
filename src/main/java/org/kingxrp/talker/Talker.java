package org.kingxrp.talker;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.plugin.java.JavaPlugin;

import org.kingxrp.external.DataBase;

public final class Talker extends JavaPlugin {
    private DataBase dataBase;

    @Override
    public void onEnable() {
        // Mensaje en la consola al encender el plugin
        getComponentLogger().info(Component.text("Plugin Talker se ha encendido correctamente", NamedTextColor.GREEN));
        this.startDataBase();
    }

    @Override
    public void onDisable() {
		// Mensaje en la consola al encender el plugin
        getComponentLogger().info(Component.text("Plugin Talker se ha apagado correctamente", NamedTextColor.RED));
        this.stopDataBase();
    }

    private void startDataBase() {
        this.dataBase = new DataBase(
                "host",
                100,
                "database",
                "username",
                "password"
        );
        getLogger().info("Se conectó la db");
    }

    private void stopDataBase() {
        this.dataBase.disconnect();
        getLogger().info("Se desconectó la db");
    }


}
