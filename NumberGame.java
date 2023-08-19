package com.pranay.codSoftInternship;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
	
static Scanner scan=new Scanner(System.in);

	public static void main(String[] args) throws Exception{
		String input="";
		do{
			System.out.println("To start the Game : press 'Y' \nTo exit : press 'Q'");
			input=scan.nextLine();
			if(input.equalsIgnoreCase("y")) {
				gameStart();
			}
			else if(input.equalsIgnoreCase("q")) {
				System.out.println("Visit Again");
			}
			else {
				System.out.println("Inavild Choice");
			}
		}while(!(input.equalsIgnoreCase("q")) && !(input.equalsIgnoreCase("y")) );
	}
	
	public static int round=1;
	public static int win=0;
	
	public static void gameStart() {
		System.out.println("...Game Started - Round "+round+" ...\n");
		Random rand=new Random();
		int num= rand.nextInt(1, 100);
		System.out.println("Guess the number b/w 1 to 100");
		int score;
		for(int i=10;i>0;i--) {

			System.out.println("You have "+i+" attempts: Enter the number");
			int guess=Integer.parseInt(scan.nextLine());
			if(num==guess) {
				System.out.println("Congrats! You guessed the number\nRound "+round+" Score is : "+i+"/10");
				win++;
				System.out.println("You have won Round : "+win+" out of "+round+"\n");
				round++;
				break;
			}
			else if(num<guess) {
				System.out.println("your number is High\n");
			}
			else {
				System.out.println("your number is Low\n");
			}
			if(i==1) {
				System.out.println("Sorry! You failed");
				System.out.println("You have won Round : "+win+" out of "+round+"\n");
				round++;
			}
		}

		String input2="";
		do{
			System.out.println("Play Again ?\nYes : Y | Exit : Q");
			input2=scan.nextLine();
			if(input2.equalsIgnoreCase("y")) {
				gameStart();
			}
			else if(input2.equalsIgnoreCase("q")) {
				System.out.println("Visit Again");
			}
			else {
				System.out.println("Inavild Choice, Try Again");
			}
		}while(!(input2.equalsIgnoreCase("q")) && !(input2.equalsIgnoreCase("y")) );
	}
}
