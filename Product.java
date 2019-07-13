package inheritance;

public class Product {
		String productId,productName,categoryID,unitPrice;
		Product()
		{
			productId="p101";
			productName="bulb";
			categoryID="lights";
			unitPrice="45";
		}

}
class ElectricalProduct extends Product
{
	float voltageRange,wattage;
	ElectricalProduct()
	{
		voltageRange=100;
		wattage=50;
	}
	public void modify()
	{
		voltageRange=voltageRange-10;
		wattage=voltageRange*10;
		unitPrice=unitPrice+10;
	}
	public void display()
	{
		
		System.out.println("product id is "+productId);
		System.out.println("product name is "+productName);
		System.out.println("category id is "+categoryID);
		System.out.println("unit price is"+unitPrice);
		System.out.println("voltage range is"+voltageRange);
		System.out.println("wattage is "+wattage);
		
	}
	public static void main(String args[])
	{
		ElectricalProduct ep=new ElectricalProduct();
		ep.display();
		ep.modify();
		System.out.println("after updating the details");
		ep.display();
		
		
	}
}
