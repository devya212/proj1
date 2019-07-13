package inheritance;

public class Student {

	String studentID, name,courseID,sex;
	String phoneNumber;
	Student(String studentID,String name,String courseID,String sex,String phoneNumber)
	{
		this.studentID=studentID;
		this.name=name;
		this.courseID=courseID;
		this.sex=sex;
		this.phoneNumber=phoneNumber;
	}
	
}
class Hosteller extends Student
{
	String hostelName;
	int roomNumber;
	Hosteller(String hostelName,int roomNumber)
	{
		super("101","bhavya","c012","F","9452294943");
		this.hostelName=hostelName;
		this.roomNumber=roomNumber;
	}
	void display()
	{
		System.out.println("student id is"+studentID);
		System.out.println("student name is"+name);
		System.out.println("course id is"+courseID);
		System.out.println("sex is "+sex);
		System.out.println("hostel name is"+hostelName);
		System.out.println("room number is"+roomNumber);
		
	}
	public static void main(String args[])
	{
		Hosteller hosteller=new Hosteller("Sai Girls Hostel",101);
		hosteller.display();
	}
}