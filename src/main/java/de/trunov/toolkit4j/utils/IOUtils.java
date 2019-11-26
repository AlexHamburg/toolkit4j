package de.trunov.toolkit4j.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Helper / Utils methods for IO operations.
 */
public class IOUtils {

	/**
	 * Return files names from the current dir.
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
}
