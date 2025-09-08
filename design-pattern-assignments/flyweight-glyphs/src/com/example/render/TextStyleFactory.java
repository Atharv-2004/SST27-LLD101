package com.example.render;

import java.util.HashMap;
import java.util.Map;

public class TextStyleFactory {
	private static final Map<String, TextStyle> cache = new HashMap<>();

	public static TextStyle get(String font, int size, boolean bold) {
		String key = font + "|" + size + "|" + (bold ? "B" : "N");
		TextStyle s = cache.get(key);
		if (s == null) {
			s = new TextStyle(font, size, bold);
			cache.put(key, s);
		}
		return s;
	}
}


