package com.arkaitzgarro.rest.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;

public abstract class UriMatcher {
	// Patrones de URL
	public static String ALL_ROWS = "ALL_ROWS";
	public static String ONE_ROW = "ONE_ROW";

	private static int id;

	private static Map<Pattern, String> patterns;

	private static void load() {
		if (patterns == null) {
			patterns = new HashMap<Pattern, String>();

			patterns.put(Pattern.compile(".*/film$"), ALL_ROWS);
			patterns.put(Pattern.compile(".*/film/([0-9]+)$"), ONE_ROW);
		}
	}

	public static String getType(String uriPattern) throws ServletException {
		load();

		// URI matcher
		Matcher matcher;

		Set<Pattern> keys = patterns.keySet();

		for (Pattern pattern : keys) {
			matcher = pattern.matcher(uriPattern);

			if (matcher.find()) {
				if (patterns.get(pattern) == ONE_ROW) {
					id = Integer.parseInt(matcher.group(1));
				}

				return patterns.get(pattern);
			}
		}

		throw new ServletException("Invalid URI: " + uriPattern);
	}

	public static int getId() {
		return id;
	}
}
