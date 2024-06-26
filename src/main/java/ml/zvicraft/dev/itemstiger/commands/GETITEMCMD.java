package ml.zvicraft.dev.itemstiger.commands;

import ml.zvicraft.dev.itemstiger.Listeners.items;
import ml.zvicraft.dev.itemstiger.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class GETITEMCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
            Player player = (Player) sender;
            PlayerInventory inventory = player.getInventory();
            if (command.getName().equals("getitems")){
                if (player.hasPermission("get.items")) {


                    inventory.addItem(items.createItem());

                    return true;
            }else {
                    player.sendMessage(Utils.chat("&cסליחה, אבל אין לך גישה לפקודה הזאת."));
                }
            }
    return true;
    }

}
