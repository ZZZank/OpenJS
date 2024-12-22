package me.fengming.openjs.utils;

@SuppressWarnings("unchecked")
public interface Cast {
    static <T> T to(Object obj) {
        return (T) obj;
    }
}
