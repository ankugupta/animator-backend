package com.starter.animator.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DataGenerator {

	public static void main(String[] args) {
		String bookId = "Harish_Sr_Kg_Rhyme";
		String publisher = "Harish";
		Integer pageStart = 4;
		Integer pageEnd = 40;

		try (PrintWriter pw = new PrintWriter(
				new File("C:\\Aristocrat\\work\\mobileapps\\zz\\queries\\" + bookId + "_Page_Query.txt"))) {
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
				pw.println("\"imageUrl\" : \"/prod/publishers/" + publisher + "/books/" + bookId + "/pages/" + pageId + "/" + pageId + "_Thumb.jpg" + "\",");
				pw.print("\t");
				pw.println("\"contentType\" : \"" + "video" + "\",");
				pw.print("\t");
				pw.println("\"contentUrl\" : \"/prod/publishers/" + publisher + "/books/" + bookId + "/pages/" + pageId + "/" + pageId + "_Video.mp4" + "\"");
				pw.print("}");
				if(i < pageEnd) {
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
