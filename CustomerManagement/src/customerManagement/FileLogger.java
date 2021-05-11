package customerManagement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileLogger implements Logger{
	
	private File file;
	
	public FileLogger() {
		file = new File("FileStore.txt");

		if (file.exists() == false) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(file.exists());
		}

	}
	
	@Override
	public void log(Customer customer) {
		System.out.println("Saved to file:" + customer.getData());
		
		try (
				PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(file.getPath(), true)));
			) {
				output.println(customer.getData());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	}

	@Override
	public void log(Customer[] customer) {
		for (Customer customer2 : customer) {
			log(customer2);
		}
		
	}

	@Override
	public void log(ArrayList<Customer> customerList) {
		for (Customer customer : customerList) {
			log(customer);
		}
	}
	
}
