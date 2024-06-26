package ml.zvicraft.dev.itemstiger;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;


public class CoolDownManager extends BukkitRunnable {

    public ItemsTiger plugin;

    public CoolDownManager(ItemsTiger plugin){
        this.plugin = plugin;
    }

    public void run() {

        for(Player player : Bukkit.getServer().getOnlinePlayers()) {

            try{
                plugin.cooldown1.put(player.getName(), plugin.cooldown1.get(player.getName()) - 1);
            }catch(Exception e){
                plugin.cooldown1.put(player.getName(), 0);
            }
        }
    }
}