/*Johnathan Curry
 * 
 */
package main;

import main.PhoneDirectory;
import java.util.Scanner;
public class Driver extends PhoneDirectory{
	public static void main(String[] s) {
		//create a instance of a phone book
	   PhoneDirectory book = new PhoneDirectory();
	   
	   System.out.println("PHONE DIRECTORY: ");
	   //prints the current phone directory
	   book.print();
	   
	   int choice = 0;
	   Scanner in = new Scanner(System.in);
	   String name, number;
	  
	   do{ 
		   
		   System.out.println("Welcome to the Directory!");
		   System.out.println("Press 1 to ADD ENTRY");
		   System.out.println("Press 2 to DELETE ENTRY");
		   System.out.println("Press 3 to CHANGE ENTRY");
		   System.out.println("Press 4 to FIND A NUMBER");
		   System.out.println("Press 5 to SHOW UPDATED DIRECTORY");
		   System.out.println("Press 0 to EXIT PROGRAM");
		   
		   choice = in.nextInt();
		   in.nextLine();
		   switch(choice){
		   case 1: //add
		   
			   System.out.println("Enter the NAME: ");
			   name = in.nextLine();
			   name.trim();
			   System.out.println("Enter the NUMBER: ");
			   number = in.nextLine();
			   book.addEntry(name, number);
			   break;
	   
		   case 2: //delete
			  
			   System.out.println("Enter the NAME to DELETE: ");
			   name = in.nextLine();
			   name.trim();
			   book.deleteEntry(name);
			   break;
			   
		   case 3: //change
			  
			   System.out.println("Enter the NAME you want to CHANGE: ");
			   name = in.nextLine();
			   name.trim();
			   System.out.println("Enter the NUMBER you want to CHANGE:  ");
			   number = in.nextLine();
			   book.changeEntry(name,number);
			   break;
			   
		   case 4: //get number
			 
			   System.out.println("Enter the NAME you wish to RETRIEVE: ");
			   name = in.nextLine();
			   name.trim();
			   System.out.println(book.getNumber(name));
			   break;
			   
		   case 5: //print new directory
			   
			   book.print();
			   break;
		   default:
			   break;
	   }
	   }while(choice != 0);	   
	   
	   in.close();
	}
}

