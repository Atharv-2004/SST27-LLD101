package com.example.render;

import java.util.List;

public class App {
    public static void main(String[] args) {
        TextStyleFactory factory = new TextStyleFactory();
        Renderer renderer = new Renderer(factory);

        List<Glyph> a = renderer.layout("HELLO", "Inter", 14, true);
        List<Glyph> b = renderer.layout("WORLD", "Inter", 14, true);

        // Demonstrate style sharing (same instance reused for identical configs)
        TextStyle style1 = a.get(0).getStyle();
        TextStyle style2 = b.get(0).getStyle();
        System.out.println("Shared style instance? " + (style1 == style2));
        System.out.println("Style key: " + style1);
        System.out.println("Glyph count: " + (a.size() + b.size()));
    }
}
