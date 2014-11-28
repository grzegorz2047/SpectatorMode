/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.grzegorz2047.testapi;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Grzegorz
 */
public class Test extends JavaPlugin implements Listener{

    List<String> lista = new ArrayList<String>();
    
    @Override
    public void onEnable(){
        System.out.print(this.getName()+" juz dziala <3");
        this.getServer().getPluginManager().registerEvents(this, this);
        this.saveDefaultConfig();
        this.lista = this.getConfig().getStringList("lista");
    }
    
    @EventHandler
    void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        p.setGameMode(GameMode.SPECTATOR);
        p.sendMessage("Jestes spectatorem na serwerze! Popros administratora serwera o mozlowsci gry na serwerze!");
        
    }
   /* @EventHandler
    void onLeave(PlayerQuitEvent e){
        Player p = e.getPlayer();
        
        Entity entity = p.getPassenger();
        if(entity != null){
            p.setPassenger(null);
            entity.remove();
        }
    }*/
    
}
