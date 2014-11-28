/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.grzegorz2047.testapi;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
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
    boolean allowWhitelist = false;
    
    @Override
    public void onEnable(){
        System.out.print(this.getName()+" juz dziala <3");
        this.getServer().getPluginManager().registerEvents(new OnJoin(this), this);
        this.saveDefaultConfig();
        this.lista = this.getConfig().getStringList("lista");
        this.allowWhitelist  = this.getConfig().getBoolean("includePlayersFromWhitelist");
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

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("lista") && (sender.isOp() || sender.hasPermission("spectator.lista"))){
            if(args.length<2){
                sender.sendMessage("/lista dodaj nickgracza");
            }else{
                if(args[0].equals("dodaj")){
                    Player p = Bukkit.getPlayer(args[1]);
                    if(p != null){
                        p.setGameMode(GameMode.SURVIVAL);
                        p.setHealth(0.0);
                        p.sendMessage("Zostales dodany do listy grajacych na serwerze!");
                        this.lista.add(args[1]);
                        sender.sendMessage("Dodano gracza "+args[1]+ " do listy grajacych!");
                    }else{
                        sender.sendMessage("Aby dodac gracza, gracz musi byc na serwerze!");
                    }

                }else if(args[0].equals("wyrzuc") || args[0].equals("usun") ){
                    this.lista.remove(args[1]);
                    sender.sendMessage("Wyrzucono gracza "+args[1]+ " z listy grajacych!");
                    Player p = Bukkit.getPlayer(args[1]);
                    if(p != null){
                        p.setGameMode(GameMode.SPECTATOR);
                    }
                }else{
                    sender.sendMessage("Poprawne uzycie: /lista dodaj/usun nickgracza");
                }
            }
        }
        return true;
    }
    
}
