package com.pranay.codSoftInternship;
import java.util.Scanner;

interface ATMinterface{
	void checkBalance();
	void ATMdeposit();
	void ATMwithdraw();
}

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double rupees) {
        if (rupees > 0) {
            balance += rupees;
            System.out.println("Your Deposited Amount : " + rupees);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double rupees) {
    	if(rupees>20000) {
    		System.out.println("Transaction Failed1\nPlease try again");
    		return true;
    	}
        if (rupees > 0 && rupees <= balance) {
            balance = balance- rupees;
            System.out.println("Your Withdrawn Amount : " + rupees);
            return true;
        } else {
            System.out.println("Insufficient balance");
            return false;
        }
    }
}

class ATM implements ATMinterface{
    private BankAccount bankAccount;
    private Scanner scanner;
    
    public ATM(BankAccount account) {
        bankAccount = account;
        scanner = new Scanner(System.in);
    }
    
    public void checkBalance() {
    	System.out.println("Current Balance: " + bankAccount.getBalance());
    	feedback();
    }
    public void ATMdeposit() {
    	System.out.print("Enter deposit amount: ");
        double depositAmount = scanner.nextDouble();
        bankAccount.deposit(depositAmount);
        showBalance();
    }
    public void ATMwithdraw() {
        System.out.print("Enter withdrawal amount: ");
        double withdrawalAmount = scanner.nextDouble();
        bankAccount.withdraw(withdrawalAmount);
        showBalance();
    }
    
    public void showBalance() {
    	System.out.println("Want to Show your Balace ?\n1. Yes	2. No");
    	int x=scanner.nextInt();
    	if(x==1) {
    		System.out.println("Your current updated balance : "+bankAccount.getBalance());
    	}
    	else if(x==2) {
    		System.out.println("Okay");
    	}
    	else {System.out.println("Invalid Choice");}
    	feedback();
    }
    private void feedback() {
    	System.out.println("Thank you for using the ATM!");
    }
    
    public void display() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Balance Enquiry");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void start() {
        int choice;
        do {
            display();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                	checkBalance();
                    break;
                case 2:
                	ATMdeposit();
                    break;
                case 3:
                    ATMwithdraw();
                	break;
                case 4:
                    feedback();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice <1 && choice >4);
    }
}

public class ATMmachine {
    public static void main(String[] args) {
    	System.out.print("Choose your initial Account Balance : ");
    	Scanner sc=new Scanner(System.in);
    	double amount=sc.nextDouble();
    	System.out.println();
        BankAccount userAccount = new BankAccount(amount);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}