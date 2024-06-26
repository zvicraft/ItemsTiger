package ml.zvicraft.dev.itemstiger.Listeners;

import ml.zvicraft.dev.itemstiger.ItemsTiger;
import ml.zvicraft.dev.itemstiger.utils.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static ml.zvicraft.dev.itemstiger.ItemsTiger.plugin;

public class items {

    public static ItemStack createItem() {
        List<String> lore = new ArrayList();
        ItemStack item = new ItemStack(Material.getMaterial(plugin.getConfig().getString("MATIRIALS")), 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Utils.chat("&eטאקו"));
        lore.add(Utils.chat(Utils.chat("&cלחיצה שמאלית לסוד")));
        meta.setLore(lore);
        lore.add(Utils.chat(Utils.chat("&7#&bנדיר")));
        meta.setLore(lore);
        meta.setCustomModelData(ItemsTiger.plugin.getConfig().getInt("custom_model_data"));
        item.setItemMeta(meta);
        return item;
    }
}
