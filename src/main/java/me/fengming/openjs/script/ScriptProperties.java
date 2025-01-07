package me.fengming.openjs.script;

import me.fengming.openjs.utils.Cast;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author ZZZank
 */
public final class ScriptProperties {
    /**
     * TODO: make {@link ScriptProperty#ordinal} an {@code int}, then use Int2ObjectMap here
     */
    private final Map<Integer, Object> internal = new HashMap<>();

    public <T> void put(ScriptProperty<T> property, T value) {
        if (value != null) {
            internal.put(property.ordinal, value);
        }
    }

    public <T> Optional<T> get(ScriptProperty<T> property) {
        return Optional.ofNullable(Cast.to(internal.get(property.ordinal)));
    }

    public <T> T getOrDefault(ScriptProperty<T> property) {
        T got = Cast.to(internal.get(property.ordinal));
        return got == null ? property.defaultValue : got;
    }

    public Map<Integer, Object> getInternal() {
        return Collections.unmodifiableMap(internal);
    }
}
