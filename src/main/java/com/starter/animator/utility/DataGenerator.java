package com.starter.animator.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataGenerator {

	public static void main(String[] args) throws IOException {
		String bookId = "PL_BB_Nursery_Story_Book";
		String bookTitle = "My First Book of Stories";
		String publisher = "Pelican";
		String publisherId = "Pub0001_Harish";
		Integer pageStart = 3;
		Integer pageEnd = 35;

		String schoolClass = "Nursery";
		String subject = "English";
		String noOfVideos = "4";
		String noOfActivities = "0";
		String resourceUrl = "https://s3.ap-south-1.amazonaws.com/book-animator";

		Path bookDir = Paths.get("C:\\Aristocrat\\work\\mobileapps\\zz\\queries\\" + bookId);
		Files.createDirectories(bookDir);
		System.out.println("Created directory for book... now writing book insertion query");

		try (PrintWriter pw = new PrintWriter(new File(
				"C:\\Aristocrat\\work\\mobileapps\\zz\\queries\\" + bookId + "\\" + bookId + "_Book_Query.txt"))) {
			pw.println("use animator");
			pw.println("db.book.insertMany([");
			pw.println("{");
			pw.print("\t");
			pw.println("\"bookId\" : \"" + bookId + "\",");
			pw.print("\t");
			pw.println("\"title\" : \"" + bookTitle + "\",");
			pw.print("\t");
			pw.println("\"imageUrl\" : \"/prod/publishers/" + publisher + "/books/" + bookId + "/" + bookId
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
			pw.println("\"targetDATUrl\" : \"/prod/publishers/" + publisher + "/books/" + bookId + "/" + bookId
					+ "_Target.dat" + "\",");
			pw.print("\t");
			pw.println("\"targetXMLUrl\" : \"/prod/publishers/" + publisher + "/books/" + bookId + "/" + bookId
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
		boolean first = true;
		try (PrintWriter pw = new PrintWriter(new File(
				"C:\\Aristocrat\\work\\mobileapps\\zz\\queries\\" + bookId + "\\" + bookId + "_Page_Query.txt"))) {
			pw.println("use animator");
			pw.println("db.page.insertMany([");
			for (int i = pageStart; i <= pageEnd; i++) {
				pw.println("{");
				pw.print("\t");
				String pageId = bookId + "_P" + i;
				pw.println("\"pageId\" : \"" + pageId + "\",");
				pw.print("\t");
				pw.println("\"bookId\" : \"" + bookId + "\",");
				pw.print("\t");
				pw.println("\"pageNoInBook\" : \"" + i + "\",");
				pw.print("\t");
				pw.println("\"imageUrl\" : \"/prod/publishers/" + publisher + "/books/" + bookId + "/pages/" + pageId
						+ "/" + pageId + "_Thumb.jpg" + "\",");
				pw.print("\t");
				pw.println("\"contentType\" : \"" + "video" + "\",");
				pw.print("\t");
				pw.println("\"contentUrl\" : \"/prod/publishers/" + publisher + "/books/" + bookId + "/pages/" + pageId
						+ "/" + pageId + "_Video.mp4" + "\"");
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

			pw.println("])");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
