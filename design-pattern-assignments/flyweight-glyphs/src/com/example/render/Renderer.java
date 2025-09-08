package com.example.render;

import java.util.ArrayList;
import java.util.List;

/**
 * Renders text using shared TextStyle instances via the factory.
 * This is a minimal demo of Flyweight composition.
 */
public class Renderer {
    private final TextStyleFactory factory;

    public Renderer(TextStyleFactory factory) {
        this.factory = factory;
    }

    public List<Glyph> layout(String text, String font, int size, boolean bold) {
        TextStyle style = factory.get(font, size, bold);
        List<Glyph> glyphs = new ArrayList<>(text.length());
        for (int i = 0; i < text.length(); i++) {
            glyphs.add(new Glyph(text.charAt(i), style));
        }
        return glyphs;
    }
}

