package com.starter.animator.utility;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ContentGenerator {

	public static void main(String[] args) {
		// [publisher-name]\books\[book-id]\pages\
		// \Harish\books\Harish_Sr_Kg_Rhyme\pages\Harish_Sr_Kg_Rhyme_P4

		String publisher = "Barry Garden";
		String bookId = "HP_BG_Nursery_Balgeet_A";
		Integer pageStart = 5;
		Integer pageEnd = 24;

		// create main directories

		String ROOT_DIR = "C:\\Aristocrat\\work\\mobileapps\\zz\\tool\\generatedContent\\";
		String BOOK_DIR = publisher + "\\books\\" + bookId + "\\pages";

		Path newPath = Paths.get(ROOT_DIR + BOOK_DIR);

		try {
			Files.createDirectories(newPath);
		} catch (IOException e) {
			// fail to create directory
			e.printStackTrace();
		}

		Path rawFilesDirPath = Paths.get("C:\\Aristocrat\\work\\mobileapps\\zz\\tool\\sourceContent\\" + bookId);

		Path thumbnailsSourcePath = rawFilesDirPath.resolve("Thumbnails");
		Path contentSourcePath = rawFilesDirPath.resolve("Contents");

		boolean copyThumbs = Files.exists(thumbnailsSourcePath);
		boolean copyContents = Files.exists(contentSourcePath);

		System.out.println("Copying thumbnails: " + copyThumbs);
		System.out.println("Copying content: " + copyContents);
		// Files.cop
		// create all page directories
		try {
			for (int pageIndex = pageStart; pageIndex <= pageEnd; pageIndex++) {
				Path pageTargetDir = newPath.resolve(bookId + "_P" + pageIndex);
				try {
					Files.createDirectory(pageTargetDir);

					if (copyThumbs) {
						Path pageSourceThumb = thumbnailsSourcePath.resolve(bookId + "_P" + pageIndex + ".jpg");
						if (Files.exists(pageSourceThumb)) {
							String sourceFullName = pageSourceThumb.getFileName().toString();
							String sourceName = pageSourceThumb.getFileName().toString().substring(0,
									sourceFullName.lastIndexOf("."));
							String sourceExtension = sourceFullName.substring(sourceFullName.lastIndexOf("."));
							System.out.println("page source thumb full name: " + sourceFullName);
							System.out.println("page source thumb name: " + sourceName);
							System.out.println("page source thumb extension: " + sourceExtension);
							String pageTargetThumbName = sourceName + "_Thumb" + sourceExtension;
							Files.copy(pageSourceThumb, pageTargetDir.resolve(pageTargetThumbName));
						} else {
							System.out.println("ERROR: Copying thumbnail of pageIndex: " + pageIndex);
						}
					}

					if (copyContents) {
						Path pageSourceContent = contentSourcePath.resolve(bookId + "_P" + pageIndex + ".mp4");
						if (Files.exists(pageSourceContent)) {
							String sourceFullName = pageSourceContent.getFileName().toString();
							String sourceName = pageSourceContent.getFileName().toString().substring(0,
									sourceFullName.lastIndexOf("."));
							String sourceExtension = sourceFullName.substring(sourceFullName.lastIndexOf("."));
							System.out.println("page source content full name: " + sourceFullName);
							System.out.println("page source content name: " + sourceName);
							System.out.println("page source content extension: " + sourceExtension);
							String pageTargetContentName = sourceName + "_Video" + sourceExtension;
							Files.copy(pageSourceContent, pageTargetDir.resolve(pageTargetContentName));
						} else {
							System.out.println("ERROR: Copying content of pageIndex: " + pageIndex);
						}
					}
				} catch (FileAlreadyExistsException e) {
					// ignore
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
