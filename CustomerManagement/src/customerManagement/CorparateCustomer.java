package customerManagement;


public class CorparateCustomer extends Customer{
	
	private String companyName;
	private String taxNumber;
	
	public CorparateCustomer(int id, String customerNumber, String companyName, String taxNumber) {
		super(id, customerNumber);
		this.companyName = companyName;
		this.taxNumber = taxNumber;
	}

	@Override
	public String getData() {
		return "Corparate Customer " + companyName + "-" + taxNumber;
	}
	
	@Override
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}
	
}
