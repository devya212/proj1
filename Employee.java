package inheritance;

import java.util.Scanner;

public class Employee {
	String empID,empName,designation,projectID;
	int phoneNumber;
	

}
class PracticeHead extends Employee
{
	String practiceName;
	int noOfCustomers;
	PracticeHead(String empID,String empName,String designation,String projectID,int phoneNumber,String practiceName,int noOfCustomers)
	{
		this.empID=empID;
		this.empName=empName;
		this.designation=designation;
		this.projectID=projectID;
		this.phoneNumber=phoneNumber;
		this.practiceName=practiceName;
		this.noOfCustomers=noOfCustomers;
	}
	public void display()
	{
		System.out.println("employee id is "+empID);
		System.out.println("employee name is "+empName);
		System.out.println("designation is "+designation);
		System.out.println("project id is "+projectID);
		System.out.println("phone number is "+phoneNumber);
		
		System.out.println("practice name is "+practiceName);
		System.out.println("no of customers is "+noOfCustomers);
	}
	public static void main(String args[])
	{
		String empID,empName,designation,projectID,practiceName;
		int phoneNumber,noOfCustomers;
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the employee id");
		empID=scanner.next();
		System.out.println("enter the employee name");
		empName=scanner.next();
		System.out.println("enter the employee designation");
		designation=scanner.next();
		System.out.println("enter the project id");
		projectID=scanner.next();
		System.out.println("enter the phone number");
		phoneNumber=scanner.nextInt();
		System.out.println("enter the practice name");
		practiceName=scanner.next();
		System.out.println("enter the no of customers");
		noOfCustomers=scanner.nextInt();
		PracticeHead practicehead=new PracticeHead(empID, empName, designation, projectID, phoneNumber, practiceName, noOfCustomers);
		practicehead.display();
		scanner.close();
	}
}
