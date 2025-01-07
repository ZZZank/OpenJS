package me.fengming.openjs;

import me.fengming.openjs.binding.PackMode;
import me.fengming.openjs.plugin.IOpenJSPlugin;

public class OpenJSBuiltinPlugin implements IOpenJSPlugin {
    @Override
    public void load() {
        registerBinding("System", System.class);
        registerBinding("PackMode", PackMode.class);
    }
}
