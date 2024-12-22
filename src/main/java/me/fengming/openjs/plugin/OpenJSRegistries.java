package me.fengming.openjs.plugin;

import me.fengming.openjs.event.OpenJSEvent;
import me.fengming.openjs.script.Binding;

public class OpenJSRegistries {
    public static final SimpleRegistry<Binding> BINDINGS = new SimpleRegistry<>("binding");
    public static final SimpleRegistry<OpenJSEvent> EVENTS = new SimpleRegistry<>("event");
}
