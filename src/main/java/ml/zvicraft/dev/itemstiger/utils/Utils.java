package ml.zvicraft.dev.itemstiger.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;

import static ml.zvicraft.dev.itemstiger.ItemsTiger.plugin;


public class Utils {

//colors
public static String chat (String s){
    //colors
    return ChatColor.translateAlternateColorCodes('&',s);
}
//inventorys


    public static ItemStack Material(Material material, Inventory inv, int amount, int invSlot, String displayName, String... loreString){
        ItemStack item;
        List<String> lore = new ArrayList<String>();

        item = new ItemStack(material, amount);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(chat(displayName));

        for (String s: loreString){
            lore.add(chat(s));
        }
        meta.setLore(lore);
        item.setItemMeta(meta);

        inv.setItem(invSlot, item);
        return item;
    }
    //conect servers
    public static void sendServer(Player p, String msg) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DataOutputStream b= new DataOutputStream(out);
        try{
            b.writeUTF("Connect");
            b.writeUTF(msg);
        }catch (Exception e){
            e.printStackTrace();
        }

        p.sendMessage(chat("&cמתחבר לשרת..."));
        p.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
    }

}

