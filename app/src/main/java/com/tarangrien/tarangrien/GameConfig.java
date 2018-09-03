package com.tarangrien.tarangrien;

import android.content.Context;

import io.t28.shade.annotation.Preferences;
import io.t28.shade.annotation.Property;

@Preferences(name = "game.config.preferences", mode = Context.MODE_PRIVATE)
public abstract class GameConfig {
    @Property(key = "open_first", defValue = "false")
    public abstract boolean chkFirt();

    @Property(key = "list_item", defValue = "null")
    public abstract String list_item();
}
