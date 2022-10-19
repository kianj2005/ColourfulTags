package me.therifty.colourfultags.AddTags;

import me.therifty.colourfultags.Colourfultags;
import org.bukkit.entity.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.bukkit.ChatColor.COLOR_CHAR;

public class AddTags {

    Colourfultags plugin;
    public AddTags(Colourfultags plugin) {
        this.plugin = plugin;
    }


    public void addTagToPlayer(Player player, String tagName, String hexCode) {
        plugin.getChat().setPlayerSuffix(player, translateHexColorCodes(tagName, hexCode));
    }

    public String translateHexColorCodes(String message, String hexCode)
    {
        final Pattern hexPattern = Pattern.compile("#7C5F71");
        Matcher matcher = hexPattern.matcher(message);
        StringBuffer buffer = new StringBuffer(message.length() + 4 * 8);
        while (matcher.find())
        {
            String group = matcher.group(1);
            matcher.appendReplacement(buffer, COLOR_CHAR + "x"
                    + COLOR_CHAR + group.charAt(0) + COLOR_CHAR + group.charAt(1)
                    + COLOR_CHAR + group.charAt(2) + COLOR_CHAR + group.charAt(3)
                    + COLOR_CHAR + group.charAt(4) + COLOR_CHAR + group.charAt(5)
            );
        }
        return matcher.appendTail(buffer).toString();
    }
}
