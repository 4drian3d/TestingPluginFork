package talker;

import org.bukkit.plugin.java.JavaPlugin;

import external.Color;
import external.DataBase;

public class Talker extends JavaPlugin
{

    //Information variables
    private static Talker instance;

    public static Talker getInstance()
	{
        return instance;
    }

    @Override
    public void onEnable()
	{
        instance = this;

        // Mensaje en la consola al encender el plugin
        String mensaje = Color.color("GREEN", "Plugin Talker se ha encendido correctamente");
        getLogger().info(mensaje);
        this.startDataBase();
    }

    @Override
    public void onDisable()
	{

		// Mensaje en la consola al encender el plugin
        String mensaje = Color.color("RED", "Plugin Talker se ha apagado correctamente");
        getLogger().info(mensaje);
        this.stopDataBase();
    }

    private void startDataBase()
    {
        DataBase db = new DataBase();
        db.setDatabase("railway");
        db.setHost("containers-us-west-157.railway.app");
        db.setPassword("sgj3B3wzpdMPqu9e0Ca2");
        db.setPort(6896);
        db.setUsername("root");
        db.connect();
        getLogger().info("Se conectó la db");
    }

    private void stopDataBase()
    {
        DataBase db = new DataBase();
        db.disconnect();
        getLogger().info("Se desconectó la db");
    }


}
