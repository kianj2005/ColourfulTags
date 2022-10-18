package me.therifty.colourfultags;

import me.therifty.colourfultags.AddTags.AddTags;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class Colourfultags extends JavaPlugin {


    private static Chat chat = null;

    public AddTags addTags;

    @Override
    public void onEnable() {
        // Plugin startup logic
        addTags = new AddTags(this);


        setupChat();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }
    public static Chat getChat() {
        return chat;
    }
}
