package com.example.render;

import java.util.Objects;

/**
 * Glyph holds extrinsic state (character) and intrinsic shared state (TextStyle).
 */
public class Glyph {
    private final char glyph;
    private final TextStyle style;

    public Glyph(char glyph, TextStyle style) {
        this.glyph = glyph;
        this.style = Objects.requireNonNull(style, "style");
    }

    public char getGlyph() { return glyph; }
    public TextStyle getStyle() { return style; }
}

