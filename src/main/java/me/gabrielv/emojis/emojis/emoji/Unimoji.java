package me.gabrielv.emojis.emojis.emoji;

import lombok.Data;
import me.gabrielv.emojis.emojis.Emojis;

@Data
public class Unimoji {

    private final Emojis plugin;
    private final String identifier;
    private final String unicode;
    private final String term;

    public Unimoji(final Emojis plugin, final String identifier, final String unicode, final String term) {
        this.plugin = plugin;
        this.identifier = identifier;
        this.unicode = unicode;
        this.term = term;
    }

    public Unimoji(final Emojis plugin, final String identifier) {
        this.plugin = plugin;
        this.identifier = identifier;
        this.unicode = plugin.getConfig().getString("Emojis." + this.identifier + ".Unicode");
        this.term = plugin.getConfig().getString("Emojis." + this.identifier + ".Term");
    }
}
