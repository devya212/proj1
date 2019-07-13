package inheritance;

public class Book {
	String bookID,title,author;
	float price;
	public Book(String bookID, String title, String author, float price) {
		super();
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.price = price;
	}
}
class Periodical extends Book
{
	String period;

	public Periodical() {
		super("104","As You Like It","shakespeare",532);
		period = "monthly";
	}
	public void modify()
	{
		price=540;
		period="weekly";
	}
	public void display()
	{
		System.out.println("Book Id is "+bookID);
		System.out.println("book title is "+title);
		System.out.println("author of book is"+author);
		System.out.println("price of book is"+price);
		System.out.println("period is "+period);
	}
	public static void main(String[] args) {
		Periodical p=new Periodical();
		p.display();
		System.out.println("after modification");
		p.modify();
		p.display();	
	}	
}
