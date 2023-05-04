import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

//-----------------------------------------------------
//Assignment (4)
//Part: (1)
//Written by: (Christopher Mezzacappa, 40249451)
//-----------------------------------------------------

/*
 * This program is a program that helps incorporates the data structure of linked-lists,
 * We created several methods that manipulate the linked the list and then displayed them,
 * in the driver. 
 */

/**
 * 
 * @author christopher
 * Driver class 
 */
public class Driver {

	/**
	 * Main Method 
	 * @param args
	 */
	public static void main(String[] args) {

		
		boolean commit = false; 
		
		Scanner keyIn = new Scanner(System.in);

		BookList list = new BookList();

		ArrayList<Book> arrList = new ArrayList<Book>();

		PrintWriter writer = null;
		Scanner reader = null;

		try {
			reader = new Scanner(new FileInputStream("books.txt"));
			writer = new PrintWriter(new FileOutputStream("YearError.txt"));
			while (reader.hasNextLine()) {

				String info = reader.nextLine();
				String[] infoSplit = info.split(",");

				Book b = new Book(infoSplit[0], infoSplit[1], Double.valueOf(infoSplit[2]), Long.valueOf(infoSplit[3]),
						infoSplit[4], Integer.valueOf(infoSplit[5]));

				if (b.getYear() > 2023) {
					arrList.add(b);
					writer.println(b);
				} else {
					list.addToStart(b);
				}
			}
		} catch (Exception e) {
			System.out.println("error from main");
		} finally {
			reader.close();
			writer.close();
			System.out.println("Your Error file has been created!");
		}

		System.out.println("Here are the contents of the List: ");
		System.out.println("===================================");
		list.displayContent();

		boolean truth = true;

		while (truth) {
			System.out.println("Tell me what you want to do? Let's chat since this is trending now:");
			System.out.println(
					"\t1) Give me a year # and I will extract all the records of that year and store them into a file");
			System.out.println("\t2) Ask me to delete consecutive records");
			System.out.println("\t3) Give me an author and I will create a file with all books that author has writen");
			System.out.println("\t4) Insert before an ISBN number you give me");
			System.out.println("\t5) Insert a book between 2 isbn numbers");
			System.out.println("\t6) Swap 2 books by giving 2 ISBN numbers");
			System.out.println(
					"\t7) Tell me COMMIT! Your wish is my command and I will create a file called Updated_Books.txt with all the books in the linked-list");
			System.out.println("\t8) Tell me to stop walking. If you do not tell me to commit You shall not leave");

			System.out.print("Tell me your choice: ");

			
			int input = Integer.parseInt(keyIn.next());

			if (input == 1) {
				System.out.print("Give me a year: ");
				
			
				
				int year = Integer.parseInt(keyIn.next());

				list.storeRecords(year);

			}

			if (input == 2) {

				list.delConsecutiveRepeatedRecords();

			}

			if (input == 3) {
				System.out.println("Give me an author name: ");

				String junk = keyIn.nextLine();
				String author = keyIn.nextLine();

				BookList temp = list.extractAuthList(author);

				temp.displayContent();

			}
			
			if(input ==4) {
				
				Book b1 = arrList.get(0); // Gunsmoke - A Complete History
				
				System.out.println("Enter isbn you would like to enter before: ");
				long isbnInput = keyIn.nextLong();
				
				list.insertBefore(isbnInput,b1); // Inserting before The 2nd Zimbalist 1574670000
				
			}
			
			if(input ==5) {
				System.out.println("Please enter the two ibsn numbers that you want to insert between (followed by a space");
				Long isbn1 = keyIn.nextLong();
				Long isbn2 = keyIn.nextLong();
				
				Book b1 = arrList.get(0);
				
				// 9780786400942 1574670000
				
				list.insertBetween(isbn1,isbn2,b1);
				
				
				
			}
			
			if(input ==6) {
				System.out.println("Please enter the isbn numbers (seperated by a space) that you want to swap");
				Long isbn1 = keyIn.nextLong();
				Long isbn2 = keyIn.nextLong();
				
				list.swap(isbn1,isbn2);  // 1574670000 1574670913
				
				
				
				
			}
			
			if(input ==7) {
				list.commit();
				commit = true;
				
			}
			
			if(input ==8) {
				
				if(commit) {
					System.out.println("\nPlease give me 10/10");
					System.exit(0);
				}
				else {
					System.out.println("You did not commit!");
				}
				
				
			}

			System.out.println("\n");
			list.displayContent();
		}

	}

}
