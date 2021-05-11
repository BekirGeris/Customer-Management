package customerManagement;

public abstract class Customer{
	
	private int id;
	private String customerNumber;
	
	public Customer(int id, String customerNumber) {
		super();
		this.id = id;
		this.customerNumber = customerNumber;
	}
	
	public abstract String getData();
	
	public int getId() {
		return id;
	}
	
	public String getCustomerNumber() {
		return customerNumber;
	}
	
	public String getCompanyName() {
		return null;
	}
	
	public String getFirstName() {
		return null;
	}
	
	public String getLastName() {
		return null;
	}
	
	public String getTaxNumber() {
		return null;
	}
	
	public String getNationalIdentity() {
		return null;
	}
	
}
