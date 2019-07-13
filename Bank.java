package assignment;

import java.util.Random;
import java.util.Scanner;

public class Bank {

	public static void main(String[] args) 
	{
		double balance1 = 0,balance2=0,amount=0,maxl=0;
		int tradeno=0;
		String accountNumber = null;
		Savings savings=new Savings();
		Current current=new Current();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Welcome to bank");
		
		System.out.println("enter the account holder's name");
		String memberName=scanner.next();
		System.out.println("what type of account you want?\n 1.press 's' for savings account\n 2.press 'c' for current account");
		String ch1=scanner.next();
		System.out.println("enter the initial balance for opening account");
		double initialBalance=scanner.nextDouble();
		if(ch1.equalsIgnoreCase("s"))
		{
		
		 accountNumber=savings.createAccount();
		 savings.memberName=memberName;
		 savings.deposit(initialBalance);
		 System.out.println("enter the maximum withdrwal limit");
		 maxl=scanner.nextDouble();
		}
		else if(ch1.equalsIgnoreCase("c"))
		{
			 
			accountNumber=current.createAccount();
			current.memberName=memberName;
			current.deposit(initialBalance);
			System.out.println("enter the trading license number");
			tradeno=scanner.nextInt();
		}
		savings.maxWithdrawLimit=maxl;
		current.tradeLicenseNumber=tradeno;
		System.out.println("successful account creation");
		System.out.println("your account number is"+accountNumber);
		String ch5;
		do {
		System.out.println("enter your choice");
		System.out.println("1.enter 1 for depositing money\n 2. enter 2 for withdrawal of money\n 3.enter 3 for displaying the balance\n press 0 to exit");
		int ch=scanner.nextInt();
		
		switch(ch)
		{
		case 1:
			
			 System.out.println("enter the amount which you want to deposit");
			  amount=scanner.nextDouble();
			 if(ch1.equalsIgnoreCase("s"))
			 {
			  balance1=savings.getBalance();
			 savings.deposit(amount);
			 savings.interestCalculation();
			  balance2=savings.getBalance();
			 }
			 else if(ch1.equalsIgnoreCase("c"))
			 {
				 balance1=current.getBalance();
				 current.deposit(amount);
				  balance2=current.getBalance(); 
			 }
			 System.out.println("do you want to see the balance yes/no?");
			 String ch3=scanner.next();
			 if(ch3.equalsIgnoreCase("yes"))
			 {
				 System.out.println("balance before deposit is"+balance1+"\n balance after deposit is "+balance2);
			 }
			 break;
		case 2:
			System.out.println("enter the amount which you want to withdraw");
			amount=scanner.nextDouble();
			if(ch1.equalsIgnoreCase("s"))
			 {
			  balance1=savings.getBalance();
			 savings.withdraw(amount);
			  balance2=savings.getBalance();
			 }
			 else if(ch1.equalsIgnoreCase("c"))
			 {
				 balance1=current.getBalance();
				 current.withdraw(amount);
				  balance2=current.getBalance(); 
			 }
			 System.out.println("do you want to see the balance yes/no?");
			 String ch4=scanner.next();
			 if(ch4.equalsIgnoreCase("yes"))
			 {
				 System.out.println("balance before withdrawal is"+balance1+"\n balance after withdrawal is "+balance2);
			 }
			 break;
		case 3:
			if(ch1.equalsIgnoreCase("s"))
			 {
			  balance1=savings.getBalance();
			 
			 }
			 else if(ch1.equalsIgnoreCase("c"))
			 {
				 balance1=current.getBalance();
				
			 }
			System.out.println("balance is "+balance1);
			break;
		case 0:
			System.exit(ch);
			break;
		default:
			System.out.println("enter correct choice");
		}
			
		System.out.println("want to enter more choices yes/no?");	
			ch5=scanner.next();
		
		}while(ch5.equalsIgnoreCase("yes"));
		
		
		
	}

}
class Account
{
	String memberName;
	String accountNumber;
	double accountBalance;
	
	public void deposit(double amount)
	{
		accountBalance+=amount;
	}
	public String createAccount()
	{
		Random rand=new Random();
	 accountNumber=""+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10);
	 return accountNumber;
		
	}
	
}
class Savings extends Account
{
	double interest;
	double maxWithdrawLimit;
	Savings()
	{
		interest=5;
		
	}
	public double getBalance()
	{
		
		return accountBalance;
	}
	public void interestCalculation()
	{
		accountBalance+=((accountBalance*interest)/100);
	}
	public void withdraw(double amount)
	{
		double balance=getBalance();
		if(amount<balance)
		{
			System.out.println("balance is less than amount demanded");
	   }
		else if(amount>maxWithdrawLimit)
		{
			System.out.println("cant withdraw amount is exceeded by the limit");
		}
		else
		{
			accountBalance=balance-amount;
			
		}
	}
}
class Current extends Account
{
	int tradeLicenseNumber;
	Current()
	{
		tradeLicenseNumber=0;
	}
	public double getBalance()
	{
		return accountBalance;
	}
	public void withdraw(double amount)
	{
		double balance=getBalance();
		if(amount<=balance)
		{
			accountBalance=balance-amount;
		}
		else
		{
			System.out.println("balance is too low cannot withdraw");
		}
		
	}
}
