package me.fengming.openjs.plugin;

import java.util.Set;
import java.util.function.Consumer;

public interface IRegistry<T extends IRegistration> {

    Set<IRegistration> set = Set.of();

    String getRegistryId();
    default T register(T registration) {
        set.add(registration);
        return registration;
    }
    void apply(Consumer<T> consumer);
}
