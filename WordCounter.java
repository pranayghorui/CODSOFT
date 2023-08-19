package com.pranay.codSoftInternship;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int input=0;
		String text="";
		
		do {
			System.out.println("Press 1 for input text\nPress 2 for input file");
			input=Integer.parseInt(sc.nextLine());
			switch(input) {
			case 1:
				System.out.println("Enter Your Text");
				text=sc.nextLine();
				break;
			case 2:
				System.out.println("Enter Your File Path:");
				String path=sc.nextLine();
				StringBuilder content = new StringBuilder();
				try (BufferedReader br=new BufferedReader(new FileReader(path))){
					String str;
					while((str=br.readLine())!=null) {
						content.append(str).append("\n");
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				text=content.toString();
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}while((input!=2) && (input!=1));
		
		int wordCount=0;
		System.out.println(text);
		String[] words=text.split("\\s+|\\{Punct}+|'+");
		for(String s: words) {
			wordCount++;
		}
		System.out.println("Total no of words is = "+wordCount);
	}
}
//	C:\Users\Pranay\OneDrive\Desktop\Main Folders\000.txt