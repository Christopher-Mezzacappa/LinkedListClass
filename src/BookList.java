import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.management.BadAttributeValueExpException;

/**
 * BookList Class Linked Linked-List data structure 
 * @author christopher
 *
 */
public class BookList {

	/**
	 * Inner Class Node 
	 * @author christopher
	 *
	 */
	
		/**
		 * Attributes for Inner class Node 
		 * @author christopher
		 *
		 */
		private class Node {
		private Book b;
		private Node next;
		
		
		/**
		 * Node Constructor 
		 */
		public Node() {
			
		}
		/**
		 * Node Param Constructor 
		 * @param b1 is a book
		 * @param n1 is a node it points to 
		 */
		public Node(Book b1,Node n1) {
			this.b = b1;
			this.next = n1;
		}
		
	}
	
	
	protected Node head;
	
	/**
	 * Book Lit constructor that sets head to null
	 */
	public BookList() {
		head =null;
	}
	
	/**
	 * Adds a book to the beginging of the linked list 
	 * @param b
	 */
	public void addToStart(Book b) {
		
		
		head = new Node(b,head);
		Node t = head;
		
		if(t.next==null) {
			t.next = head;
			return;
		}
		
		t = head.next;
		while(t.next!=head.next) {
			t=t.next;
		}
		t.next=head;
		
		
	}
	
	/**
	 * Stores the records in a text file based on the inputed year 
	 * @param year
	 */
	public void storeRecords(int year) {
		PrintWriter writer = null;
		
		try {
			Node t = head;
			writer = new PrintWriter(new FileOutputStream(year+".txt"));
			
			do{
				if(t.b.getYear()==year) {
					writer.println(t.b);
				}
				
				t = t.next;
				
				
				
			}
			while(t!=head); 
				
		}
		catch(Exception e) {
			System.out.println("Error from Store Records");
		}
		finally {
			writer.close();
		}
		
	
		
		
	}

	/**
	 * Inserts before a given isbn 
	 * @param isbn
	 * @param b
	 * @return
	 */
	public boolean insertBefore(long isbn,Book b) {
		
		Node t = head;
		Node n = new Node(b,null);
		do{
		
			if(t.next.b.getIsbn()==isbn) {
				n.next=t.next;
				t.next = n;
				return true;
			}
			t = t.next;
		}
		while(t!=head);
		
		
		
		
		return false;
	}

	/**
	 * Inserts between two isbns given
	 * @param isbn1
	 * @param isbn2
	 * @param b
	 * @return
	 */
	public boolean insertBetween(long isbn1,long isbn2,Book b) {
		
		Node t = head;
		Node n = new Node(b,null);
		do {
			if(t.b.getIsbn()==isbn1 && t.next.b.getIsbn()==isbn2) {
				n.next = t.next;
				t.next = n;
				return true;
			}
			t = t.next;
		}
		while(t!=head);
		
		return false;
	}
	
	/**
	 * Displays content of the linked list 
	 */
	public void displayContent() {
		
		Node t = head;
		
		do {
			
			System.out.println(t.b+"  ==>");
			t = t.next;
		}
		while(t!=head);
		

		if(t==head) {
			System.out.println("head==>");
		}
	}

	/**
	 * Deletes two of the same books next to eachother 
	 */
	public boolean delConsecutiveRepeatedRecords() {
		
		Node t1 = head;
		Node t2 = t1.next;
		
		do {
			
			while(t1.b.equals(t2.b)) {
				
					if(t1.next.equals(head)) {

						if(t1.b.equals(t2.b)) {
							Node t3 = t2.next;
							t2.next= null;
							head = t3;
							t1.next = head;
						}
						break;
					}
				
					Node t3 = t2.next;
					t1.next = t3;
					t2 = t3;
			}
			t1 = t1.next;
			t2 = t2.next;
			
			
		}
		while(t1!=head);
		
		
		return false;
	}
	
	/**
	 * Creates a linked list of a specific author and returns the list 
	 * @param aut
	 * @return
	 */
	public BookList extractAuthList(String aut) {
		
		BookList bookList = new BookList();
		
		Node t = head;
		
		do {
			if(t.b.getAuthor().equals(aut)) {
				Book temp = new Book(t.b);
				bookList.addToStart(temp);
			}
			t = t.next;
		}
		while(t!=head);
		
		return bookList;
		
		
		
	}
	
	/**
	 * Swaps two books in the list based on their isbn number 
	 * @param isbn1
	 * @param isbn2
	 * @return
	 */
	public boolean swap(long isbn1,long isbn2) {
		
		Node t1 = head;
		Node t2 = head;
		
		do {
			if(t1.next.b.getIsbn()==isbn1) {
				
				do {
					if(t2.next.b.getIsbn()==isbn2) {
						
						Node t3 = t1.next;
						Node t4 = t2.next;
						Node t5 = t2.next.next;

						t1.next = t4;
						t4.next = t3.next;
						t2.next = t3;
						t3.next = t5;
						System.out.println("Books have been swaped");
						return true;
					}
					else {
						t2 = t2.next;
					}
				}
				while(t2!=head);
					
			}
			else {
				t1 = t1.next;
			}
			
			
		}
		while(t1!=head);
		
		
		
		return false;
	}

	
	/**
	 * Writes the linked list into a file that finalizes it
	 */
	public void commit() {
		
		PrintWriter writer =null;
		
		try {
			writer = new PrintWriter(new FileOutputStream("Updated_Books.txt"));
			
			Node t = head;
			
			do {
				writer.println(t.b);
				t = t.next;
			}
			while(t!=head); {
				
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			
			System.out.println("File not found");
			
		}
		finally {
			writer.close();
		}
		
	
		
		
	}
	
	
	
}
