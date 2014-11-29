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

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 *
 * @author Grzegorz
 */
public class OnChat implements Listener {
    
    Test plugin;
    
    public OnChat(Test plugin){
        this.plugin = plugin;
    }
    
    @EventHandler
    void onChatListener(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        if(!this.plugin.allowSpecChat){
            if((p.isWhitelisted() && this.plugin.allowWhitelist) || (this.plugin.lista.contains(p.getName()))){
                return;
            }else{
                p.sendMessage("Nie mozesz pisac na czacie jezeli jestes obserwatorem!");
                e.setCancelled(true);
            }
        }
    }
    
}
