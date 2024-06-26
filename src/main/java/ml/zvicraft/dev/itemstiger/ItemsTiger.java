package ml.zvicraft.dev.itemstiger;


import ml.zvicraft.dev.itemstiger.commands.GETITEMCMD;
import ml.zvicraft.dev.itemstiger.utils.Utils;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;


import java.util.HashMap;
import java.util.Objects;

import static org.bukkit.Bukkit.*;

public final class ItemsTiger extends JavaPlugin implements Listener {
    public static ItemsTiger plugin;
    public CoolDownManager cooldown;

    HashMap<String, Integer> cooldown1;

    @Override
    public void onEnable() {
        plugin = this;
        getConsoleSender().sendMessage(Utils.chat(this.getConfig().getString("prefix") + "&athe plugin is enabled"));
        this.getConfig().options().copyDefaults(false);
        this.saveDefaultConfig();

//
//           boolean NoteBlockAPI = true;
//           if (!Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")) {
//               getLogger().severe("*** NoteBlockAPI is not installed or not enabled. ***");
//               NoteBlockAPI = false;
//               return;
//           }

        cooldown1 = new HashMap<String, Integer>();

        getCommand("getitems").setExecutor(new GETITEMCMD());
        // Plugin startup logic

        this.getServer().getPluginManager().registerEvents(this, this);

        BukkitTask Cooldown = new CoolDownManager(this).runTaskTimer(this, 30, 30);
        cooldown1 = new HashMap<String, Integer>();

    }


        //Any number you put after the = sign is how much seconds the cooldown lasts
    @EventHandler

        public void ckkEVENT(PlayerInteractEvent e) {
    try {


        Action action = e.getAction();
        Player player = e.getPlayer();

        if (e.getItem() != null) {
            if (e.getItem().getItemMeta() != null){
                if (e.getItem().getItemMeta().getDisplayName() != null){
                    if (Objects.requireNonNull(player.getItemInHand().getItemMeta()).getDisplayName().equals(Utils.chat("&eטאקו"))){
                        if(action.equals(Action.LEFT_CLICK_AIR)){

                            if (plugin.cooldown1.get(player.getName()) <= 0) {

                                plugin.cooldown1.put(player.getName(), 30);

                                //This is were all the stuff happens that you want too, Here is some examples:
                //Do stuff here! Like spawn lightning: player.strickLightning(location);
                                player.playSound(player.getLocation(), "soundsplay:music.taco", 1, 1);
                                plugin.cooldown1.put(player.getName(), 30);


                            }
                        else{
                            player.sendMessage(ChatColor.RED + "אתה חייב לחכות " + ChatColor.BLUE + plugin.cooldown1.get(player.getName()) + ChatColor.RED + " שניות לשימוש חוזר בפריט זה!");


                        }
                        }
                    }
                }
            }
        }}catch (Exception a){

    }
        }





            //e.getPlayer().playSound(e.getPlayer().getLocation(), "music.taco", 1.0f, 1.0f);
            //      Preloaded son
//        Song s = NBSDecoder.parse(new File(getDataFolder(), "songs/test.nbs"));
//        SongPlayer sp = new RadioSongPlayer(s);
//        sp.setAutoDestroy(true);
//        sp.addPlayer(e.getPlayer());
//        sp.setPlaying(true);



    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

