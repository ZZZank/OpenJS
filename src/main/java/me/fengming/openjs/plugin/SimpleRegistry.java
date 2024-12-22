package me.fengming.openjs.plugin;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class SimpleRegistry<T extends IRegistration> {
    protected Set<T> set = new HashSet<>();
    protected String id;

    public SimpleRegistry(String id) {
        this.id = id;
    }

    public String getRegistryId() {
        return id;
    }

    public T register(T registration) {
        set.add(registration);
        return registration;
    }

    public void apply(Consumer<T> consumer) {
        set.forEach(consumer);
    }
}
