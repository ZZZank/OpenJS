package me.fengming.openjs.plugin;

import me.fengming.openjs.script.Binding;

public interface IOpenJSPlugin {

    void load();

    default void registerBinding(String name, Object value) {
        OpenJSRegistries.BINDINGS.register(new Binding(name, value));
    }
}
