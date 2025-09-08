package com.example.render;

import java.util.Objects;

/**
 * Immutable intrinsic state for glyph styling.
 * Instances are intended to be shared via TextStyleFactory.
 */
public final class TextStyle {
    private final String font;
    private final int size;
    private final boolean bold;

    public TextStyle(String font, int size, boolean bold) {
        this.font = Objects.requireNonNull(font, "font");
        this.size = size;
        this.bold = bold;
    }

    public String getFont() { return font; }
    public int getSize() { return size; }
    public boolean isBold() { return bold; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextStyle)) return false;
        TextStyle that = (TextStyle) o;
        return size == that.size && bold == that.bold && font.equals(that.font);
    }

    @Override
    public int hashCode() { return Objects.hash(font, size, bold); }

    @Override
    public String toString() {
        return font + "|" + size + "|" + (bold ? "B" : "N");
    }
}

