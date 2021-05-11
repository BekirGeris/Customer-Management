package customerManagement;

import java.util.ArrayList;

public class CustomerManager {

	private ArrayList<Customer> customersList = new ArrayList<Customer>();

	public CustomerManager() {
		super();
	}

	// Overloading
	public void add(Customer customer) {
		boolean flag = true;
		for (Customer customer2 : customersList) {
			try {
				if (customer2.getNationalIdentity().equals(customer.getNationalIdentity())) {
					flag = false;
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				if (customer2.getTaxNumber().equals(customer.getTaxNumber())) {
					flag = false;
					break;
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (flag) {
			customersList.add(customer);
			System.out.println("Customer is adding: " + customer.getData());
		} else {
			System.out.println("There cannot be more than one customer with the same identification number or the same tax number.");
		}
	}

	// Overloading
	public void add(Customer[] customers) {
		for (Customer customer : customers) {
			add(customer);
		}
	}

	// Overloading
	public void delete(Customer customer) {
		customersList.remove(customer);
		System.out.println("Customer removed: " + customer.getData());
	}

	// Overloading
	public void delete(Customer[] customers) {
		for (Customer customer : customers) {
			delete(customer);
		}
	}

	// Overloading
	public void delete(String companyName) {
		boolean flag = false;
		Customer temp = null;
		for (Customer customer : customersList) {
			try {
				if (customer.getCompanyName().toUpperCase().equals(companyName.toUpperCase())) {
					flag = true;
					temp = customer;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (flag && temp != null) {
			delete(temp);
		} else {
			System.out.println(companyName + " There is no customer with this name.");
		}
	}

	// Overloading
	public void delete(String firstName, String lastName) {
		boolean flag = false;
		Customer temp = null;
		for (Customer customer : customersList) {
			try {
				if (customer.getFirstName().toUpperCase().equals(firstName.toUpperCase())
						&& customer.getLastName().toUpperCase().equals(lastName.toUpperCase())) {
					flag = true;
					temp = customer;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (flag && temp != null) {
			delete(temp);
		} else {
			System.out.println(firstName + " " + lastName + " There is no customer with this name.");
		}
	}

	public void find(Customer customer) {
		if (customersList.contains(customer)) {
			System.out.println("Customer Found :\n" + customer.getData());
		}
	}

	public void find(String companyName) {
		boolean flag = false;
		Customer temp = null;
		for (Customer customer : customersList) {
			try {
				if (customer.getCompanyName().toUpperCase().equals(companyName.toUpperCase())) {
					flag = true;
					temp = customer;
				}
			} catch (Exception e) {
				
			}
		}
		if (flag && temp != null) {
			find(temp);
		} else {
			System.out.println(companyName + " There is no customer with this name.");
		}
	}

	public void find(String firstName, String lastName) {
		boolean flag = false;
		Customer temp = null;
		for (Customer customer : customersList) {
			try {
				if (customer.getFirstName().toUpperCase().equals(firstName.toUpperCase())
						&& customer.getLastName().toUpperCase().equals(lastName.toUpperCase())) {
					flag = true;
					temp = customer;
				}
			} catch (Exception e) {
				
			}
		}
		if (flag && temp != null) {
			find(temp);
		} else {
			System.out.println(firstName + " " + lastName + " There is no customer with this name.");
		}
	}

	public void toCustomerList() {
		for (Customer customer : customersList) {
			System.out.println(customer.getData());
		}
	}

	public ArrayList<Customer> getCustomerList() {
		return customersList;
	}
}
