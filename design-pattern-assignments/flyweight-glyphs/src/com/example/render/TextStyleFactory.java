package com.example.render;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/** Factory that returns shared TextStyle instances (flyweights). */
public class TextStyleFactory {
    private final Map<String, TextStyle> cache = new ConcurrentHashMap<>();

    public TextStyle get(String font, int size, boolean bold) {
        Objects.requireNonNull(font, "font");
        String key = key(font, size, bold);
        return cache.computeIfAbsent(key, k -> new TextStyle(font, size, bold));
    }

    static String key(String font, int size, boolean bold) {
        return font + "|" + size + "|" + (bold ? "B" : "N");
    }
}

