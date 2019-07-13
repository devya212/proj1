package inheritance;

public class Person {
	String name;
	int year;
	

}
class Instructor extends Person
{
	float salary;
	Instructor()
	{
		this.name="Raghav";
		this.year=2001;
		this.salary=10000;
	}
	public void display()
	{
		System.out.println("Name of instructor is "+name);
		System.out.println("year of birth is "+year);
		System.out.println("salary is "+salary);
	}
	
	
}
class Student1 extends Person
{
	String majorSubject;
	Student1()
	{
		this.name="Raj";
		this.year=2012;
		this.majorSubject="Computers";
	}
	public void display()
	{
		System.out.println("name of student is "+name);
		System.out.println("year of birth is"+year);
		System.out.println("Major subject is "+majorSubject);
	}
	
}
class Application1 
{
	public static void main(String[] args) {
		
		Student1 st1=new Student1();
		st1.display();
		Instructor ins=new Instructor();
		ins.display();
	}
}
