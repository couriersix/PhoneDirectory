package main;

import java.util.*;
import java.io.*;

// TODO: Auto-generated Javadoc
/**
 * The Class PhoneDirectory.
 */
public class PhoneDirectory{
	
	/** The properties. */
	static Properties properties = new Properties();

	/**
	 * Instantiates a new phone directory.
	 */
	public PhoneDirectory(){
		try (InputStream in = new FileInputStream("src/main/resources/phone.properties")) {
			Properties prop = new Properties();
			prop.load(in);
			for (String property : prop.stringPropertyNames()) {
				String value = prop.getProperty(property);
				addEntry(property, value);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * Adds the entry.
	 *Adds an entry into the Phone Directory.
	 * @param name the name of person that is being added
	 * @param number the phone number of the person that is being added
	 */
	public void addEntry(String name, String number){
		try{
			OutputStream out = new FileOutputStream("src/main/resources/phone.properties");
		properties.setProperty(name, number);
		properties.store(out, "Phone Directory");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Delete entry.
	 * Deletes an entry in the phone directory.
	 * @param name Searches for name in directory, then deletes the name and number.
	 */
	public void deleteEntry(String name){
		try{
			OutputStream out = new FileOutputStream("src/main/resources/phone.properties");
		   properties.remove(name);
		   properties.store(out, "Phone Directory");
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	/**
	 * Gets the number.
	 *Displays the number associated with the name searched.
	 * @param name Name that is associated with the number
	 * @return the number The number associated with the name that was searched
	 */
	public String getNumber(String name){
		return properties.getProperty(name);
	}

	/**
	 * Change entry.
	 * Updates the entry in the directory with user inputed information
	 * @param name The name the original name gets changed to. 
	 * @param number The number the original number gets changed to.
	 */
	public void changeEntry(String name, String number){
		addEntry(name,number);	
	 }
	
	/**
	 * Prints the phone directory in it's entirety 
	 */
	public void print(){
		System.out.printf("%-15s%-15s","Name","Number");
		System.out.println();
		for (String property : properties.stringPropertyNames()) {
			String value = properties.getProperty(property);
			System.out.printf("%-15s%-15s",property, value);
			System.out.println();
		}
	}
}
