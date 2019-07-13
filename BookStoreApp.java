package assignment;

import java.util.Scanner;

public class BookStoreApp {

	public static int size=5;
	
	public static void main(String[] args) {
		Book books[]=new Book[100];
		Scanner scanner=new Scanner(System.in);
		for(int i=0;i<size;i++)
		{
			System.out.println("enter the book title");
			String bookTitle=scanner.next();
			System.out.println("enter the author name");
			String author=scanner.next();
			System.out.println("enter the isbn number");
			String ISBN=scanner.next();
			System.out.println("enter the no of copies");
			int numOfCopies=scanner.nextInt();
			books[i]=new Book(bookTitle,author,ISBN,numOfCopies);
		}
		BookStore bookstore=new BookStore(books);
		System.out.println("welcome to book store app");
 String ch1;
  do
  {
	  System.out.println("enter your choice what you want to do?");
	  System.out.println("press 1 for display of books");
	  System.out.println("press 2 for the order of books");
	  System.out.println("press 3 for sell of books");
	  System.out.println("press 0 to exit the system");
	  int ch=scanner.nextInt();
	  String choice;
	  switch(ch)
	  {
	  case 1:
		   for(int i=0;i<size;i++)
		   {
			   books[i].display();
			   
		   }
		   break;
	  case 2:
		  do
		  {
			  System.out.println("enter the isbn number of the book for ordering");
			  String isbn=scanner.next();
			  System.out.println("enter the number of copies of the book");
			  int noOfCopies=scanner.nextInt();
			  bookstore.order(isbn,noOfCopies);
			  System.out.println("do you want to order other book yes/no?");
			  choice=scanner.next();
		  }
		  while(choice.equalsIgnoreCase("yes"));
		  break;
	  case 3:
		  do
		  {
			  System.out.println("enter the title of the book for selling");
			  String bookTitle=scanner.next();
			  System.out.println("enter the number of copies of the book");
			  int noOfCopies=scanner.nextInt();
			  bookstore.sell(bookTitle,noOfCopies);
			  System.out.println("do you want to sell other book yes/no?");
			  choice=scanner.next();
		  }
		  while(choice.equalsIgnoreCase("yes"));
		  break;
	  case 0:
		  System.exit(ch);
		  break;
	  default:
			  System.out.println("please enter correct details");
	  }
	  System.out.println("want to enter more choices yes/no");
	  ch1=scanner.next();
      }
  while(ch1.equalsIgnoreCase("yes"));
	}

}
class Book
{
	String bookTitle,author,ISBN;
	int numOfCopies;
	Book(String bookTitle,String author,String ISBN,int numOfCopies)
	{
		this.bookTitle=bookTitle;
		this.author=author;
		this.ISBN=ISBN;
		this.numOfCopies=numOfCopies;
		
	}
	void display()
	{
		System.out.println("title of book is-->"+bookTitle+" "+"author of book is-->"+author+" "+"ISBN number is-->"+ISBN+""+"No of copies-->"+numOfCopies);
	}
	
}
class BookStore
{
	Book books[];
	BookStoreApp bk=new BookStoreApp();
	BookStore(Book books[])
	{
		this.books=books;
		
	}
	void sell(String bookTitle,int noOfCopies)
	{
		int pos=-1;
		for(int i=0;i<BookStoreApp.size;i++)
		{
			if(books[i].bookTitle.equalsIgnoreCase(bookTitle) && noOfCopies<=books[i].numOfCopies && books[i].numOfCopies!=0)
			{
				pos=i;
				break;
			}
		}
		if(pos==-1)
		{
			System.out.println("book not found or no of copies are less in stock as per demand");
		}
		else
		{
			System.out.println("book found");
			books[pos].numOfCopies=books[pos].numOfCopies-noOfCopies;
			if(books[pos].numOfCopies==0)
			{
				for(int j=pos;j<BookStoreApp.size-1;j++)
				{
					books[j].bookTitle=books[j+1].bookTitle;
					books[j].author=books[j+1].author;
					books[j].ISBN=books[j+1].ISBN;
					books[j].numOfCopies=books[j+1].numOfCopies;
				}
				BookStoreApp.size=BookStoreApp.size-1;
			}
		}
	}
	void order(String isbn,int noOfCopies)
	{
		int pos=-1;
		for(int i=0;i<BookStoreApp.size;i++)
		{
			if(books[i].ISBN.equalsIgnoreCase(isbn))
			{
				pos=i;
				break;
			}
		}
		if(pos==-1)
		{
			Scanner scanner1=new Scanner(System.in);
			System.out.println("book not found");
			System.out.println("enter the title of book which has not been found");
			String title=scanner1.next();
			System.out.println("enter the name of author whose book title has not been already found in books array");
			String author=scanner1.next();
			books[BookStoreApp.size]=new Book(title,author,isbn,noOfCopies);
			BookStoreApp.size=BookStoreApp.size+1;
		}
		else
		{
			System.out.println("book found");
			books[pos].numOfCopies=books[pos].numOfCopies+noOfCopies;
		}
	}
	void display()
	{
		for(int i=0;i<BookStoreApp.size;i++)
		{
			books[i].display();
		}
	}
	
}