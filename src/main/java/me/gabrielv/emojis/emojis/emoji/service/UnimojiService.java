package me.gabrielv.emojis.emojis.emoji.service;

import lombok.Getter;
import me.gabrielv.emojis.emojis.Emojis;
import me.gabrielv.emojis.emojis.emoji.Unimoji;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UnimojiService {

    private final Emojis plugin;
    private final FileConfiguration config;
    private final List<Unimoji> emojis;

    public UnimojiService(final Emojis plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
        this.emojis = new ArrayList<>();

        this.registerEmojis();
    }

    public void addEmoji(final Unimoji emoji) {
        this.emojis.add(emoji);
    }

    private void registerEmojis() {

        for (final String key : this.config.getConfigurationSection("Emojis").getKeys(false)) {
            this.addEmoji(new Unimoji(
                    this.plugin,
                    key
            ));
        }
    }
}
