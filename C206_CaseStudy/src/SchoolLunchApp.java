import java.util.ArrayList;

public class SchoolLunchApp {
	
	public static void main(String[] args) {
		ArrayList<Bill> billList = new ArrayList<Bill>();
		
		billList.add(new Bill("John", 30, "July 1st"));
		// Create Bill
		Helper.line(20, "-");
		System.out.println("Create Bill");
		Helper.line(20, "-");

		Bill bl = inputBill();
		SchoolLunchApp.addBill(billList, bl);

		// Delete Bill
//      Helper.line(20, "-");
//      System.out.println("Delete Bill");
//      Helper.line(20, "-");
//      
//      String payeeName = Helper.readString("Enter Payee's Name > ");

		// View Bill
		Helper.line(20, "-");
		System.out.println("VIEW ALL BILL");
		Helper.line(20, "-");
		SchoolLunchApp.ViewAllBill(billList);

	}
	
	private void optionMenu() {
		// TODO Auto-generated method stub
		Helper.line(80, "-");
		System.out.println("SCHOOL LUNCH APP");
		Helper.line(80, "-");
	
		System.out.println("1. Orders");
		System.out.println("2. User Account");
		System.out.println("3. Menu Items");
		System.out.println("4. Bills");
		System.out.println("5. Quit");
		Helper.line(80, "-");
	}
	
	public void userTypeMenu() {
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		ArrayList<Order> orderList = new ArrayList<Order>();
		
		final int OPTION_QUIT = 5;
		
		int option = 0;
		while (option != OPTION_QUIT) {
			optionMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				order();
				int orders = Helper.readInt("Enter option to select > ");

				if (orders == 1) {
					viewAllOrder(orderList);
				} else if (orders == 2) {
					addAllOrder(orderList);
				} else if (orders == 3) {
					deleteAllOrder(orderList);
				}

			} else if (option == 3) {
				menuItem();
				int menuChoice = Helper.readInt("Enter option to select > ");

				if (menuChoice == 1)
					viewAllMenuItem(menuItemList);
				else if (menuChoice == 2)
					addMenuItem(menuItemList);
				else if (menuChoice == 3)
					deleteMenuItem(menuItemList);

			}

		}
	}
	
// ===================================================MenuItem=========================================================
	private static void viewAllMenuItem(ArrayList<MenuItem> menuItemList) {
		// TODO Auto-generated method stub
		System.out.println("Menu Item");
		Helper.line(80, "-");
		if (menuItemList.size() > 0)
			System.out.println(String.format("%-20s %-30s %-15s %-10s", "Category", "Name", "Healthy Choice", "Price"));
		for (MenuItem mi : menuItemList) {
			System.out.println(mi.toString());
		}
	}

	private static void addMenuItem(ArrayList<MenuItem> menuItemList) {
		// TODO Auto-generated method stub
		String category = Helper.readString("Enter Menu Item category > ");
		String name = Helper.readString("Enter Menu Item name > ");
		boolean acceptedAns = false;
		boolean healthyChoice = false;
		while (!acceptedAns) {
			char healthyChoiceReader = Helper.readChar("Is the Menu Item a healthy choice (y/n)> ");
			if (Character.toLowerCase(healthyChoiceReader) == 'y'
					|| Character.toLowerCase(healthyChoiceReader) == 'n') {
				acceptedAns = true;
				if (Character.toLowerCase(healthyChoiceReader) == 'y')
					healthyChoice = true;
			} else {
				System.out.println("Invalid input! Please enter only either y or n");
			}

		}
		double price = Helper.readDouble("Enter Menu Item Price > ");
		menuItemList.add(new MenuItem(category, name, healthyChoice, price));
	}

	private static void deleteMenuItem(ArrayList<MenuItem> menuItemList) {
		System.out.println("1. Category");
		System.out.println("2. Name");
		System.out.println("3. Healthy Choice");
		System.out.println("4. Price");
		int finderIndex = Helper.readInt("Which method do you wish to search by? > ");

		ArrayList<MenuItem> findMenuItemList = new ArrayList<MenuItem>();

		if (finderIndex == 1) {
			String categoryName = Helper.readString("Enter Category Name > ");
			for (MenuItem mi : menuItemList) {
				if (mi.getCategory().equalsIgnoreCase(categoryName)) {
					findMenuItemList.add(mi);
				}
			}
		} else if (finderIndex == 2) {
			String name = Helper.readString("Enter name > ");
			for (MenuItem mi : menuItemList) {
				if (mi.getName().contains(name)) {
					findMenuItemList.add(mi);
				}
			}
		} else if (finderIndex == 3) {
			boolean acceptedAns = false;
			boolean healthyChoice = false;
			while (!acceptedAns) {
				char healthyChoiceReader = Helper.readChar("Is the Menu Item a healthy choice (y/n)> ");
				if (Character.toLowerCase(healthyChoiceReader) == 'y'
						|| Character.toLowerCase(healthyChoiceReader) == 'n') {
					acceptedAns = true;
					if (Character.toLowerCase(healthyChoiceReader) == 'y')
						healthyChoice = true;
				} else {
					System.out.println("Invalid input! Please enter only either y or n");
				}
			}

			for (MenuItem mi : menuItemList) {
				if (mi.isHealthyChoice() == healthyChoice) {
					findMenuItemList.add(mi);
				}
			}
		} else if (finderIndex == 4) {
			System.out.println("Enter price range: ");
			double topPrice = Helper.readDouble("From: $");
			double bottomPrice = Helper.readDouble("To: $");
			for (MenuItem mi : menuItemList) {
				if (mi.getPrice() > bottomPrice && mi.getPrice() < topPrice) {
					findMenuItemList.add(mi);
				}
			}
		}

		if (findMenuItemList.size() == 0) {
			System.out.println("Nothing is found!");
		} else {
			System.out.println(
					String.format("Index %-20s %-30s %-15s %-10s", "Category", "Name", "Healthy Choice", "Price"));
			for (int i = 0; i < findMenuItemList.size(); i++) {
				System.out.println(String.format("%-5d %s", i + 1, findMenuItemList.get(i).toString()));
			}

			int choice = Helper.readInt("Enter the index > ");
			if (choice <= 0 || choice > findMenuItemList.size()) {
				System.out.println("Invalid input!");
			} else {
				String name = findMenuItemList.get(choice - 1).getName();
				String category = findMenuItemList.get(choice - 1).getCategory();
				boolean healthyChoice = findMenuItemList.get(choice - 1).isHealthyChoice();
				double price = findMenuItemList.get(choice - 1).getPrice();

				for (int x = 0; x < menuItemList.size(); x++) {
					if (menuItemList.get(x).getName().equals(name) && menuItemList.get(x).getCategory().equals(category)
							&& menuItemList.get(x).isHealthyChoice() == healthyChoice
							&& menuItemList.get(x).getPrice() == price)
						menuItemList.remove(x);
				}

				System.out.println(name + " is removed!");
			}
		}

	}

	
	
	private static void menuItem() {
		// TODO Auto-generated method stub
		System.out.println("1. View Menu Item");
		System.out.println("2. Add Menu Item");
		System.out.println("3. Delete Menu Item");
	}

	// Delete Bill Main methodss

	// Create Bill main methods
	public static void createBill(ArrayList<Bill> billList) {
		Bill bill = new Bill("John", 15.50, null);
		billList.add(bill);

		System.out.println("Bill Created!");
	}

	public static Bill inputBill() {
		String payee = Helper.readString("Enter Payee's name > ");
		double totalAmount = Helper.readDouble("Enter total amount > ");
		String dueDate = Helper.readString("Enter due date >");

		Bill bl = new Bill(payee, totalAmount, dueDate);
		return bl;

	}

	public static void addBill(ArrayList<Bill> billList, Bill bl) {

		billList.add(bl);
		System.out.println("Bill added");
	}

	// View All Bill main methods
	public static String retrieveAllBill(ArrayList<Bill> billList) {
		String output = "";

		for (int i = 0; i < billList.size(); i++) {

			output += String.format("%-10s %-30s %-10s\n", billList.get(i).getPayee(), billList.get(i).getTotalAmount(),
					billList.get(i).getDueDate());
		}
		return output;
	}

	public static void ViewAllBill(ArrayList<Bill> billList) {
		System.out.println("BILL LIST");
		String output = String.format("%-10s %-30s %-10s\n", "PAYEE", "TOTAL AMOUNT", "DUE DATE");
		output += retrieveAllBill(billList);
		System.out.println(output);

	}

}
