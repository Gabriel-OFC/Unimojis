package me.gabrielv.emojis.emojis;

import lombok.Getter;
import me.gabrielv.emojis.emojis.emoji.service.UnimojiService;
import me.gabrielv.emojis.emojis.listener.PlayerChat;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class Emojis extends JavaPlugin {

    public UnimojiService unimojiService;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        this.loadEmojis();
        this.loadListeners();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void loadEmojis() {
        this.unimojiService = new UnimojiService(this);
    }

    private void loadListeners() {
        new PlayerChat(this);
    }

}
