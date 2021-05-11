package customerManagement;

import java.util.ArrayList;

public interface Logger{
	
	// Overloading
	void log(Customer customer);
	
	// Overloading 
	void log(Customer[] customer);
	
	// Overloading 
	void log(ArrayList<Customer> customerList);
}
