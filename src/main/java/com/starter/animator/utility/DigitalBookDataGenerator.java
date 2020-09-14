package com.starter.animator.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class DigitalBookDataGenerator {

	public static void main(String[] args) {
		/*String bookId = "Prozo_C_Literacy";
		String bookTitle = "My Book of Literacy, Level C";
		String publisherId = "Pub0004_Prozo";
		String publisherName = "";
		String schoolClass = "";
		String subject = "";
		String resourceUrl = "https://s3.ap-south-1.amazonaws.com/book-animator";
		
		List<Integer> activityAt = Arrays.asList(6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19, 20, 21, 23, 24, 25, 26, 27, 28, 31, 32, 35, 36, 39, 40, 43, 44, 47, 48, 50, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 68, 71, 74, 78, 83, 84,85, 88, 94, 95, 97, 98, 99, 100, 101, 102, 104, 106, 107, 108, 109, 111, 125, 127, 128, 129, 130, 131, 132, 133, 134, 139, 140);
		//List<Integer> include = Arrays.asList(5, 6, 8, 9, 10, 11, 12 ,7, 13, 21, 33, 44, 53);
		
		List<Integer> skipAt = Arrays.asList();
		
		Path bookDir = Paths.get("D:\\work\\mobileapps\\zz\\queries\\" + bookId);
		Files.createDirectories(bookDir);
		System.out.println("Created directory for book... now writing book insertion query");
		
		try (PrintWriter pw = new PrintWriter(
				new File("D:\\work\\mobileapps\\zz\\queries\\" + bookId + "\\" + bookId + "_Book_Query.txt"))) {
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
		
		try (PrintWriter pw = new PrintWriter(
				new File("D:\\work\\mobileapps\\zz\\queries\\" + bookId + "\\" + bookId + "_Page_Query.txt"))) {
			pw.println("use animator");
			pw.println("db.page.insertMany([");
			for (int i = pageStart; i <= pageEnd; i++) {
				if (skipAt.contains(i)) {
					continue;
				}
				String contentUrl = "_Activity.html";
				String contentType = "activity";
				if(activityAt.contains(i)){
					contentUrl = "_Video.mp4";
					contentType = "video";
				}
				String contentUrl = "_Video.mp4";
				String contentType = "video";
				if (activityAt.contains(i)) {
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
				pw.println("\"contentUrl\" : \"/prod/publishers/" + publisherId + "/books/" + bookId + "/pages/"
						+ pageId + "/" + pageId + contentUrl + "\"");
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
		*/
	}
}
