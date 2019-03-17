package com.starter.animator.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ContentGenerator {

	public static void main(String[] args) {
		// [publisher-name]\books\[book-id]\pages\
		// \Harish\books\Harish_Sr_Kg_Rhyme\pages\Harish_Sr_Kg_Rhyme_P4

		String publisher = "Harish";
		String bookId = "Harish_Sr_Kg_Rhyme";
		Integer pageStart = 4;
		Integer pageEnd = 10;

		// create main directories

		String ROOT_DIR = "C:\\Aristocrat\\work\\mobileapps\\zz\\generatedContent\\";
		String BOOK_DIR = publisher + "\\books\\" + bookId + "\\pages";

		Path newPath = Paths.get(ROOT_DIR + BOOK_DIR);

		try {
			Files.createDirectories(newPath);
		} catch (IOException e) {
			// fail to create directory
			e.printStackTrace();
		}

		
		Path rawFilesDirPath = Paths.get("C:\\Aristocrat\\work\\mobileapps\\zz\\sourceContent");

		Path thumbnailsPath = rawFilesDirPath.resolve("Thumbnails");
		Path contentPath = rawFilesDirPath.resolve("Contents");

		boolean copyThumbs = Files.exists(thumbnailsPath);
		boolean copyContents = Files.exists(contentPath);
		
		System.out.println("Copying thumbnails: " + copyThumbs);
		System.out.println("Copying content: " + copyContents);
		//Files.cop
		// create all page directories
		try {
			for (int pageIndex = pageStart; pageIndex <= pageEnd; pageIndex++) {
				Path pageDir = newPath.resolve(bookId + "_P" + pageIndex);
				Files.createDirectory(pageDir);
				if(copyThumbs) {
					Path pageThumb = thumbnailsPath.resolve(bookId + "_P" + pageIndex + ".jpg");
					Files.copy(pageThumb, pageDir.resolve(pageThumb.getFileName().toString() + "_Thumb"));
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
