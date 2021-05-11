package customerManagement;

import java.io.IOException;
import java.util.Scanner;

public class CustomerManagementMain {

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);

		// admin info
		String userName = "BekirGeris";
		String password = "1234";

		CustomerManager customerManager = new CustomerManager();
		FileLogger fileLogger = new FileLogger();
		DataBaseLogger dataBaseLogger = new DataBaseLogger();
		
		int key = -1;
		while (key != 10) {
			switch (key) {
			case -1:

				System.out.println("Kullanýcý adýný ve þifresini giriniz...");
				String userNameE = input.next();
				String passwordE = input.next();
				if (userName.equals(userNameE) && password.equals(passwordE)) {
					key = 0;
				}
				
				break;
			case 0:
				System.out.println(userName + " Welcome");
				System.out.println("Enter 1 to add customer.");
				System.out.println("Enter 2 to remove a customer.");
				System.out.println("Enter 3 to save added customers.");
				System.out.println("Enter 4 to find a customer.");
				System.out.println("Enter 5 to see the entire client list.");
				System.out.println("Enter 6 to exit.");
				key = input.nextInt();

				break;
			case 1:

				System.out.println("Enter 1 to add a corporate customer and 2 for an individual customer.");
				customerAdd(input.nextInt(), customerManager);
				key = 7;
				
				break;
			case 2:

				System.out.println("Enter 1 to remove a corporate customer and enter 2 for an individual customer.");
				customerDelete(input.nextInt(), customerManager);
				key = 7;

				break;
			case 3:
				
				System.out.println("Enter 1 to save to file, 2 to save to database.");
				log(input.nextInt(), fileLogger, dataBaseLogger, customerManager);
				key = 7;
				
				break;
			case 4:

				find(customerManager);
				key = 7;
				
				break;
			case 5:
				customerManager.toCustomerList();
				key = 7;
				
				break;
			case 6:
				key = -1;
				
				break;
			case 7:
				System.out.println("Enter 0 to return to the main menu.");
				key = input.nextInt();
				
				break;
			default:
				System.out.println("Something went wrong, choose again.");
				key = 0;
				
				break;
			}
		}

		// CUSTOMERS CREATED
		Customer[] customers = { new IndividualCustomer(0, "1125485", "Bekir", "GERIS", "11122233344"),
				new CorparateCustomer(1, "2563585", "GOOGLE", "1111"),
				new IndividualCustomer(2, "1256854", "Ahmet", "AKIL", "111222233345"),
				new CorparateCustomer(3, "5395742", "BEGERS", "2222"),
				new CorparateCustomer(4, "6354789", "HEPSI BURADA", "3333"),
				new IndividualCustomer(5, "3256751", "Safak", "SECGIN", "11122233346"),
				new IndividualCustomer(6, "3266854", "Mehmet", "ALBAY", "11122233347"),
				new CorparateCustomer(7, "8943854", "TREDYOL", "4444"),
				new IndividualCustomer(8, "8354854", "Cevdet", "SULU", "11122233348"),
				new CorparateCustomer(9, "7845854", "GETIR", "5555"),
				new CorparateCustomer(10, "8569854", "ASUS", "6666"),
				new IndividualCustomer(11, "4585454", "Talha", "ERTEK", "11122233349") };

		customerManager.add(customers);
		customerManager.add(new CorparateCustomer(12, "45869578", "Beko", "7777"));
		customerManager.delete(customers);

		customerManager.toCustomerList();

		Logger loggerFile = new FileLogger();
		loggerFile.log(customerManager.getCustomerList());

		Logger loggerDataBase = new DataBaseLogger();
		loggerDataBase.log(customerManager.getCustomerList());

		customerManager.toCustomerList();
	}

	private static void customerAdd(int key, CustomerManager customerManager) {

		Scanner in = new Scanner(System.in);
		if (key == 1) {
			System.out.println("Enter corporate customers information. For example; 10 1122334 Google 1111");
			int id = in.nextInt();
			String customerNumber = in.next();
			String companyName = in.next();
			String taxNumber = in.next();
			customerManager.add(new CorparateCustomer(id, customerNumber, companyName, taxNumber));
		} else if (key == 2) {
			System.out.println("Enter individual customer information. For example; 11 2255447 Bekir Geris 11122233344");
			int id = in.nextInt();
			String customerNumber = in.next();
			String firstName = in.next();
			String lastName = in.next();
			String nationalIdentity = in.next();
			customerManager.add(new IndividualCustomer(id, customerNumber, firstName, lastName, nationalIdentity));
		}
	}

	private static void customerDelete(int key, CustomerManager customerManager) {

		Scanner in = new Scanner(System.in);
		if (key == 1) {
			System.out.println("Enter the name of your corporate customers. For example; Google");
			String companyName = in.next();
			customerManager.delete(companyName);
		} else if (key == 2) {
			System.out.println("Enter the name of your individual customer. For example; Bekir Geris");
			String firstName = in.next();
			String lastName = in.next();
			customerManager.delete(firstName, lastName);
		}
	}
	
	private static void log(int key, FileLogger fileLogger, DataBaseLogger dataBaseLogger, CustomerManager customerManager) {
		if (key == 1) {
			fileLogger.log(customerManager.getCustomerList());
		} else if (key == 2) {
			dataBaseLogger.log(customerManager.getCustomerList());
		}
	}
	
	private static void find(CustomerManager customerManager) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the name of the customer you want to find. For example; Google ya da Bekir Geris");
		String str = in.nextLine();
		String[] strs = str.split(" ");
		
		if (strs.length < 2) {
			customerManager.find(strs[0]);
		} else {
			customerManager.find(strs[0], strs[1]);
		}
	}

}
