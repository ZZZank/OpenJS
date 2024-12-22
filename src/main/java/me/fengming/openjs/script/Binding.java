package me.fengming.openjs.script.bindings;

import me.fengming.openjs.plugin.IRegistration;

import java.util.Objects;
import java.util.Set;

public record Binding(Set<String> alias, Object value) implements IRegistration {

    public Binding(String name, Object value) {
        this(Set.of(name), value);
    }

    public void addAlias(String alias) {
        this.alias.add(alias);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Binding binding = (Binding) o;
        return Objects.equals(value, binding.value) && Objects.equals(alias, binding.alias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alias, value);
    }
}
