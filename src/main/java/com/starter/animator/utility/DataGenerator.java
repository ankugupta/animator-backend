package com.starter.animator.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class DataGenerator {

	public static void main(String[] args) throws IOException {
		String bookId = "Prozo_B_Phonics";
		String bookTitle = "My Book of Phonics, Level B";
		String publisher = "Prozo";
		String publisherId = "Pub0004_Prozo";
		Integer pageStart = 4;
		Integer pageEnd = 12;

		String schoolClass = "Level B";
		String subject = "English";
		String noOfVideos = "7";
		String noOfActivities = "0";
		String resourceUrl = "https://s3.ap-south-1.amazonaws.com/book-animator";

		Path bookDir = Paths.get("D:\\work\\mobileapps\\zz\\queries\\" + bookId);
		Files.createDirectories(bookDir);
		System.out.println("Created directory for book... now writing book insertion query");

		try (PrintWriter pw = new PrintWriter(new File(
				"D:\\work\\mobileapps\\zz\\queries\\" + bookId + "\\" + bookId + "_Book_Query.txt"))) {
			pw.println("use animator");
			pw.println("db.book.insertMany([");
			pw.println("{");
			pw.print("\t");
			pw.println("\"bookId\" : \"" + bookId + "\",");
			pw.print("\t");
			pw.println("\"title\" : \"" + bookTitle + "\",");
			pw.print("\t");
			pw.println("\"imageUrl\" : \"/prod/publishers/" + publisherId + "/books/" + bookId + "/" + bookId
					+ "_P1_Thumb.jpg" + "\",");
			pw.print("\t");
			pw.println("\"publisherId\" : \"" + publisherId + "\",");
			pw.print("\t");
			pw.println("\"publisherName\" : \"" + publisher + "\",");
			pw.print("\t");
			pw.println("\"schoolClass\" : \"" + schoolClass + "\",");
			pw.print("\t");
			pw.println("\"subject\" : \"" + subject + "\",");
			pw.print("\t");
			pw.println("\"targetDATUrl\" : \"/prod/publishers/" + publisherId + "/books/" + bookId + "/" + bookId
					+ "_Target.dat" + "\",");
			pw.print("\t");
			pw.println("\"targetXMLUrl\" : \"/prod/publishers/" + publisherId + "/books/" + bookId + "/" + bookId
					+ "_Target.xml" + "\",");
			pw.print("\t");
			pw.println("\"noOfVideos\" : " + noOfVideos + ",");
			pw.print("\t");
			pw.println("\"noOfActivities\" : " + noOfActivities + ",");
			pw.print("\t");
			pw.println("\"resourceUrl\" : \"" + resourceUrl + "\"");
			pw.print("}");
			pw.println();

			pw.println("])");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("now writing pages insertion query......");
		
		List<Integer> activityAt = Arrays.asList();
		
		List<Integer> skipAt = Arrays.asList(5,7);
		
		try (PrintWriter pw = new PrintWriter(new File(
				"D:\\work\\mobileapps\\zz\\queries\\" + bookId + "\\" + bookId + "_Page_Query.txt"))) {
			pw.println("use animator");
			pw.println("db.page.insertMany([");
			for (int i = pageStart; i <= pageEnd; i++) {
				if(skipAt.contains(i)){
					continue;
				}
				/*String contentUrl = "_Activity.html";
				String contentType = "activity";
				if(activityAt.contains(i)){
					contentUrl = "_Video.mp4";
					contentType = "video";
				}*/
				String contentUrl = "_Video.mp4";
				String contentType = "video";
				if(activityAt.contains(i)){
					contentUrl = "_Activity.html";
					contentType = "activity";
				}
				pw.println("{");
				pw.print("\t");
				String pageId = bookId + "_P" + i;
				pw.println("\"pageId\" : \"" + pageId + "\",");
				pw.print("\t");
				pw.println("\"bookId\" : \"" + bookId + "\",");
				pw.print("\t");
				pw.println("\"pageNoInBook\" : \"" + i + "\",");
				pw.print("\t");
				pw.println("\"imageUrl\" : \"/prod/publishers/" + publisherId + "/books/" + bookId + "/pages/" + pageId
						+ "/" + pageId + "_Thumb.jpg" + "\",");
				pw.print("\t");
				pw.println("\"contentType\" : \"" + contentType + "\",");
				pw.print("\t");
				pw.println("\"contentUrl\" : \"/prod/publishers/" + publisherId + "/books/" + bookId + "/pages/" + pageId
						+ "/" + pageId + contentUrl + "\"");
				pw.print("}");
				if (i < pageEnd) {
					pw.print(",");
				}
				pw.println();
			}

			pw.println("])");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
