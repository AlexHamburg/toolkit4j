package de.trunov.toolkit4j.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Helper / Utils methods for IO operations.
 */
public class IOUtils {
	
	/**
	 * Utils shouldn't be created.
	 */
	private IOUtils() {
		throw new UnsupportedOperationException("It is not allowed to create an instance of a utility class");
	}

	/**
	 * Return files names from the current dir.
	 * 
	 * @param pathToDir Path to directory with files.
	 */
	public static List<String> getFileNamesInDir(final String pathToDir) {
		final File dir = new File(pathToDir);
		final File[] directoryListing = dir.listFiles();
		final List<String> filesNames = new ArrayList<>();
		if (directoryListing != null && directoryListing.length > 0) {
			for (final File child : directoryListing) {
				filesNames.add(child.getName());
			}
		}
		return filesNames;
	}
	
	/**
	 * Return files from the current dir.
	 * 
	 * @param pathToDir Path to directory with files.
	 */
	public static List<File> getFilesInDir(final String pathToDir) {
		final File dir = new File(pathToDir);
		final File[] directoryListing = dir.listFiles();
		final List<File> files = new ArrayList<>();
		if (directoryListing != null && directoryListing.length > 0) {
			for (final File child : directoryListing) {
				files.add(child);
			}
		}
		return files;
	}
	
	/**
	 * Read JSON from file and convert into String.
	 * 
	 * @param urlToJsonFile URL to JSON File.
	 * @return String representation of the JSON.
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static String getTimetableAsJsonStringFromUrl(final URL urlToJsonFile) throws IOException {
		final Scanner s = new Scanner(urlToJsonFile.openStream()).useDelimiter("\\A");
		String result = s.hasNext() ? s.next() : "";
		return result;
	}
}
