package com.example.imports;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class CsvProfileImporter implements ProfileImporter {
	private final NaiveCsvReader reader;
	private final ProfileService service;

	public CsvProfileImporter(NaiveCsvReader reader, ProfileService service) {
		this.reader = Objects.requireNonNull(reader, "reader");
		this.service = Objects.requireNonNull(service, "service");
	}

	@Override
	public int importFrom(Path csvFile) {
		Objects.requireNonNull(csvFile, "csvFile");
		List<String[]> rows = reader.read(csvFile);
		int count = 0;
		for (String[] row : rows) {
			if (row.length < 3) {
				System.out.println("Skipping row: not enough columns");
				continue;
			}
			String id = nullSafe(row[0]);
			String email = nullSafe(row[1]);
			String display = row[2];
			if (id.isEmpty() || email.isEmpty() || !email.contains("@")) {
				System.out.println("Skipping row: invalid id/email");
				continue;
			}
			try {
				service.createProfile(id, email, display);
				count++;
			} catch (RuntimeException ex) {
				System.out.println("Skipping row: " + ex.getMessage());
			}
		}
		return count;
	}

	private String nullSafe(String s) { return s == null ? "" : s.trim(); }
}


