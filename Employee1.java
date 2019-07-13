package inheritance;

public class Employee1 {
	String employeeName;
	float salary;
	Employee1()
	{
		employeeName="Devyani";
		salary=10000;
	}

}
class Manager extends Employee1
{
	String department;
	Manager()
	{
		department="CS";
	}
	public String toString()
	{
		
		return employeeName+" "+salary+" "+department;
		
	}
	
}
class Executive extends Manager
{
	public String toString()
	{
		System.out.println("executive");
		System.out.println(super.toString());
		        return null;
		
	}
	public static void main(String[] args) {
		Employee1 executive=new Executive();
		executive.toString();
		
	}
}