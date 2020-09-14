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

public class DataGeneratorVer2 {

	public static void main(String[] args) throws IOException {
		String bookId = "HPI_MRT_MUL8";
		String bookTitle = "MAULI 8";
		String publisher = "HPI";
		String publisherId = "Pub0003_HPI";
		Integer pageStart = 1;
		Integer pageEnd = 200;

		String schoolClass = "Class 8";
		String subject = "MARATHI";
		String noOfVideos = "36";
		String noOfActivities = "0";
		String resourceUrl = "https://cdn.harbourpress.com";
		
		List<Integer> activityAt = Arrays.asList();
		
		List<Integer> skipAt = Arrays.asList();
		
		List<Integer> includePages = Arrays.asList(7, 11, 12, 13, 17, 18, 19, 22, 23, 26, 27, 30, 31, 32, 33, 34, 37, 38, 39, 43, 44, 45,
				46, 49, 52, 53, 54, 57, 58, 59, 60, 63, 64, 70, 71, 74);

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
			pw.println("\"imageUrl\" : \"/PROD/PUBLISHERS/" + publisher + "/BOOKS/" + bookId + "/"+ bookId
					+ "_P1_THUMB.jpg" + "\",");
			pw.print("\t");
			pw.println("\"publisherId\" : \"" + publisherId + "\",");
			pw.print("\t");
			pw.println("\"publisherName\" : \"" + publisher + "\",");
			pw.print("\t");
			pw.println("\"schoolClass\" : \"" + schoolClass + "\",");
			pw.print("\t");
			pw.println("\"subject\" : \"" + subject + "\",");
			pw.print("\t");
			pw.println("\"targetDATUrl\" : \"/PROD/PUBLISHERS/" + publisher + "/BOOKS/" + bookId + "/" + bookId
					+ "_TARGET.dat" + "\",");
			pw.print("\t");
			pw.println("\"targetXMLUrl\" : \"/PROD/PUBLISHERS/" + publisher + "/BOOKS/" + bookId + "/" + bookId
					+ "_TARGET.xml" + "\",");
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
		
		
		
		try (PrintWriter pw = new PrintWriter(new File(
				"D:\\work\\mobileapps\\zz\\queries\\" + bookId + "\\" + bookId + "_Page_Query.txt"))) {
			pw.println("use animator");
			pw.println("db.page.insertMany([");
			for (int i = pageStart; i <= pageEnd; i++) {
				if(includePages.contains(i)) {
					/*String contentUrl = "_Activity.html";
					String contentType = "activity";
					if(activityAt.contains(i)){
						contentUrl = "_Video.mp4";
						contentType = "video";
					}*/
					String contentUrl = "_VIDEO.mp4";
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
					pw.println("\"imageUrl\" : \"/PROD/PUBLISHERS/" + publisher + "/BOOKS/" + bookId + "/PAGE/" + pageId
							+ "/" + pageId + "_THUMB.jpg" + "\",");
					pw.print("\t");
					pw.println("\"contentType\" : \"" + contentType + "\",");
					pw.print("\t");
					pw.println("\"contentUrl\" : \"/PROD/PUBLISHERS/" + publisher + "/BOOKS/" + bookId + "/PAGE/" + pageId
							+ "/" + pageId + contentUrl + "\"");
					/*if(first) {
					pw.println("\"contentUrl\" : \"/prod/publishers/" + publisher + "/books/" + bookId + "/pages/" + pageId
							+ "/" + pageId + "_P" + (i+1) + "_Video.mp4" + "\"");
					}
					/*else {
						pw.println("\"contentUrl\" : \"/prod/publishers/" + publisher + "/books/" + bookId + "/pages/" + pageId
								+ "/" + bookId + "_P" + (i-1) + "_P" + i + "_Video.mp4" + "\"");	
					}
					first = !first;*/
					pw.print("}");
					if (i < pageEnd) {
						pw.print(",");
					}
					pw.println();
				}
			}

			pw.println("])");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
