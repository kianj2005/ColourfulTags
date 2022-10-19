package me.therifty.colourfultags;

import lombok.Getter;
import lombok.Setter;
import me.therifty.colourfultags.AddTags.AddTags;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
@Setter
public final class Colourfultags extends JavaPlugin {

    private static Chat chat = null;

    public AddTags addTags;

    @Override
    public void onEnable() {
        // Plugin startup logic
        setupChat();
        addTags = new AddTags(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return true;
    }
    public static Chat getChat() {
        return chat;
    }

}
