package customerManagement;

import java.util.ArrayList;

public class DataBaseLogger implements Logger {

	@Override
	public void log(Customer customer) {
		System.out.println("Saved to the database:" + customer.getData());
		/**
		 * Normally, there should be registration codes in the database here. Since I do
		 * not know a sufficient level database, this will remain as a simulation for
		 * now. Developments can be made and can be written here.
		 */
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
