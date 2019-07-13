package inheritance;

public class Vehicle {
String vehicleNo,model,manufacturer,color;
Vehicle(){
	vehicleNo="up 32 2456";
	model="mahendra";
	manufacturer="tata motors";
	color="white";
	
}

}
class Truck extends Vehicle
{
	int loadingCapacity;
	Truck()
	{
		super();
		loadingCapacity=1000;
	}
	public void modify()
	{
		color="black";
		loadingCapacity=2000;
	}
	public void display()
	{
		System.out.println("vehicle no is"+vehicleNo);
		System.out.println("vehicle model is"+model);
		System.out.println("manufacturer is "+manufacturer);
		System.out.println("color is "+color);
		System.out.println("loading capacity in tonns is"+loadingCapacity);
	}
	public static void main(String[] args) {
		Truck truck=new Truck();
		truck.display();
		System.out.println("after updation details are as follows: ");
		truck.modify();
		truck.display();
	}
}
