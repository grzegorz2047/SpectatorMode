/*
 * Copyright 2014 Grzegorz.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.grzegorz2047.testapi;

import org.bukkit.GameMode;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 *
 * @author Grzegorz
 */
public class OnJoin implements Listener{
    
    Test plugin;
    
    public OnJoin(Test plugin_){
        this.plugin = plugin_;
    }
    
    
    @EventHandler
    void onJoinListener(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(!plugin.lista.contains(p.getName())){
            p.setGameMode(GameMode.SPECTATOR);
            Utils.sendTitle(p, 50, 50, 20, "Hej", "spectatorze!");
            p.sendMessage("Jestes spectatorem na serwerze! Popros administratora serwera o mozlowsci gry na serwerze!");
        }else if(p.isWhitelisted() && plugin.allowWhitelist){
            p.setGameMode(GameMode.SURVIVAL);
        }else{
            p.setGameMode(GameMode.SURVIVAL);
        }
        Utils.sendActionBar(p, "Is it on the top of the screen?");
        Utils.sendTabTitle(p, "Super serwer", "Nice one!");
    }
    
}
