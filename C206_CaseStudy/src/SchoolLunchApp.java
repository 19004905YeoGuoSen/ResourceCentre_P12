import java.util.ArrayList;

public class SchoolLunchApp {

	public static void main(String[] args) {
		ArrayList<Bill> billList = new ArrayList<Bill>();
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		ArrayList<Order> orderList = new ArrayList<Order>();

		billList.add(new Bill("John", 30, "July 1st"));
		int option = 0;
		while (option != 5) {
			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				order();
				int orders = Helper.readInt("Enter option to select > ");

				if (orders == 1) {
					viewAllOrder(orderList);
				} else if (orders == 2) {
					Order order1 = inputOrder();
					addAllOrder(orderList, order1);
				} else if (orders == 3) {
					deleteAllOrder(orderList);
				} else if (orders == 4) {
					updateAllOrder(orderList);
				} else if (orders == 5) {
					searchOrderByStudentID(orderList);
				}

			} else if (option == 3) {
				menuItem();
				int menuChoice = Helper.readInt("Enter option to select > ");

				if (menuChoice == 1)
					viewAllMenuItem(menuItemList);
				else if (menuChoice == 2)
					addMenuItem(menuItemList);
				else if (menuChoice == 3) {
					MenuItem menuItemChoice = narrowingMenuItemList(menuItemList);
					deleteMenuItem(menuItemList, menuItemChoice);
				}else if (menuChoice == 4) {
					MenuItem menuItemChoice = narrowingMenuItemList(menuItemList);
					updateMenuItem(menuItemList, menuItemChoice);
				}else if (menuChoice == 5)
					findMenuItem(menuItemList);
				else
					System.out.println("Invalid Input!");

			} else if (option == 4) {
				SchoolLunchApp.billMenu();
				option = Helper.readInt("Enter an option > ");

				if (option == 1) {
					// Create Bill
					Helper.line(20, "-");
					System.out.println("Create Bill");
					Helper.line(20, "-");

					Bill bl = inputBill();
					SchoolLunchApp.addBill(billList, bl);

				} else if (option == 2) {
					// Delete Bill
					Helper.line(20, "-");
					System.out.println("Delete Bill");
					Helper.line(20, "-");

					String payeeName = Helper.readString("Enter Payee's Name > ");

				} else if (option == 3) {
					// View Bill
					Helper.line(20, "-");
					System.out.println("VIEW ALL BILL");
					Helper.line(20, "-");
					SchoolLunchApp.ViewAllBill(billList);

				} else {
					System.out.println("Invalid Option");
				}
			}

		}

	}

	private static void menu() {
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

	// =============================================ViewAllOrder============================================================
	private static void viewAllOrder(ArrayList<Order> orderList) {
		// TODO Auto-generated method stub
		Helper.line(80, "-");
		System.out.println("VIEW ALL ORDERS");
		Helper.line(80, "-");
		String output = String.format("%-15s %-20s %-30s\n", "STUDENT ID", "ORDER DATE", "ITEMS");

		output += retrieveAllOrder(orderList);
		System.out.println(output);
	}

	public static String retrieveAllOrder(ArrayList<Order> orderList) {
		String output = "";

		for (int i = 0; i < orderList.size(); i++) {
			output += String.format("%-84s\n", orderList.get(i).toString());
		}
		return output;
	}

	// =============================================addAllOrder==============================================================
	public static Order inputOrder() {
		Helper.line(80, "-");
		System.out.println("ADD ORDER");
		Helper.line(80, "-");
<<<<<<< HEAD

=======
		
>>>>>>> branch 'master' of https://github.com/19004905YeoGuoSen/ResourceCentre_P12.git
		String studentid = Helper.readString("Enter Student ID > ");
		String orderdate = Helper.readString("Enter Order Date > ");
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();

		Order order1 = new Order(studentid, orderdate, items);
		return order1;

	}

	public static void addAllOrder(ArrayList<Order> orderList, Order order1) {
		orderList.add(order1);
		System.out.println("New Order added");
	}

	// =============================================deleteAllOrder==========================================================
	private static void deleteAllOrder(ArrayList<Order> orderList) {
		// TODO Auto-generated method stub
		Helper.line(80, "-");
		System.out.println("DELETE ORDER");
		Helper.line(80, "-");
<<<<<<< HEAD

=======
		
>>>>>>> branch 'master' of https://github.com/19004905YeoGuoSen/ResourceCentre_P12.git
		System.out.println("1. Student ID");
		System.out.println("2. Order Date");

		int num = Helper.readInt("Enter option to search > ");

		ArrayList<Order> findList = new ArrayList<Order>();

		if (num == 1) {
			String studentid = Helper.readString("Enter Student ID > ");
			for (Order od : orderList) {
				if (od.getStudentId().equalsIgnoreCase(studentid)) {
					findList.add(od);
				}
			}
		} else if (num == 2) {
			String orderdate = Helper.readString("Enter order date > ");
			for (Order od : orderList) {
				if (od.getOrderDate().equalsIgnoreCase(orderdate)) {
					findList.add(od);
				}
			}
		}

		if (findList.size() == 0) {
			System.out.println("Nothing is found!");
		} else {
			System.out.println(String.format("%-15s %-20s %-30s", "STUDENT ID", "ORDER DATE", "ITEMS"));
			for (int i = 0; i < findList.size(); i++) {
				System.out.println(String.format("%s", findList.get(i).toString()));
			}

			int choice = Helper.readInt("Enter the choice to delete > ");
			if (choice <= 0 || choice > findList.size()) {
				System.out.println("Invalid input!");
			} else {
				String studentid = findList.get(choice - 1).getStudentId();
				String oderdate = findList.get(choice - 1).getOrderDate();

				for (int x = 0; x < orderList.size(); x++) {
					if (orderList.get(x).getStudentId().equals(studentid)
							&& orderList.get(x).getOrderDate().equals(oderdate))
						;
					orderList.remove(x);
				}

				System.out.println("Order deleted");
			}
		}
	}

	// =============================================updateAllOrder==========================================================
	private static void updateAllOrder(ArrayList<Order> orderList) {
		Helper.line(80, "-");
		System.out.println("UPDATE ORDERS");
		Helper.line(80, "-");

		String studentid = Helper.readString("Enter Student ID > ");

		boolean isUpdated = false;

		for (int i = 0; i < orderList.size(); i++) {
			if (studentid.equalsIgnoreCase(orderList.get(i).getStudentId())) {
				String orderdate = Helper.readString("Enter order date to update > ");

				if (orderdate.equals(orderList.get(i).getOrderDate())) {
					String neworderdate = Helper.readString("Enter new order date > ");
					orderList.get(i).setOrderDate(neworderdate);
					System.out.println("Order date updated");
				} else {
					System.out.println("The order date is incorrect");
				}
				isUpdated = true;
				break;
			}

		}

		if (isUpdated == false) {
			System.out.println("***Invalid order date");
		}

	}

<<<<<<< HEAD
	// =========================search order by student
	// ID=============================================================
=======
	// =========================search order by student ID=============================================================
>>>>>>> branch 'master' of https://github.com/19004905YeoGuoSen/ResourceCentre_P12.git
	private static void searchOrderByStudentID(ArrayList<Order> orderList) {
		Helper.line(80, "-");
		System.out.println("SEARCH ORDERS BY STUDENT ID");
		Helper.line(80, "-");

		String SearchId = Helper.readString("Enter studetn id to search > ");
		boolean isIdFound = false;

		String output = String.format("%-15s %-20s %-30s\n", "STUDENT ID", "ORDER DATE", "ITEMS");

		for (int i = 0; i < orderList.size(); i++) {
			if (orderList.get(i).getStudentId().contains(SearchId)) {
				output += String.format("%-15s %-20s %-30s\n", orderList.get(i).getStudentId(),
						orderList.get(i).getOrderDate(), orderList.get(i).getItems());
				isIdFound = true;
			}
		}
		if (isIdFound = true) {
			System.out.println(output);
		} else {
			System.out.println("The order date does not exists");
		}
	}

	// submenu for order
	private static void order() {
		// TODO Auto-generated method stub
		System.out.println("1. View orders");
		System.out.println("2. Add orders");
		System.out.println("3. Delete orders");
		System.out.println("4. Update orders");
		System.out.println("5. Search orders by student ID");
	}

	// ===================================================viewAllMenuItem===================================================
	private static void viewAllMenuItem(ArrayList<MenuItem> menuItemList) {
		// TODO Auto-generated method stub
		ArrayList<String> allCategoryName = new ArrayList<String>();

		for (MenuItem mi : menuItemList) {
			String catName = mi.getCategory().toLowerCase();

			boolean uniqueName = true;
			for (String s : allCategoryName) {
				if (s.equals(catName))
					uniqueName = false;
			}

			if (uniqueName)
				allCategoryName.add(catName);
		}

		System.out.println("Menu Item");
		Helper.line(80, "-");
		if (menuItemList.size() > 0)
			System.out.println(String.format("%-20s %-30s %-15s %-10s", "Category", "Name", "Healthy Choice", "Price"));

		ArrayList<MenuItem> tempMenuItemList = new ArrayList<MenuItem>();
		for (MenuItem mi : menuItemList) {
			tempMenuItemList.add(mi);
		}

		while (tempMenuItemList.size() != 0) {
			for (int i = 0; i < tempMenuItemList.size(); i++) {
				if (tempMenuItemList.get(i).getCategory().toLowerCase().equalsIgnoreCase(allCategoryName.get(0))) {
					System.out.println(tempMenuItemList.get(i).toString());
					tempMenuItemList.remove(i);
				}
			}

			allCategoryName.remove(0);
		}
	}

	// ===================================================addMenuItem=======================================================
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
		double price = -1.0;
		while (price <= 0) {
			price = Helper.readDouble("Enter Menu Item Price > ");
			if (price <= 0)
				System.out.println("Please enter a value more than 0!");
		}
		menuItemList.add(new MenuItem(category, name, healthyChoice, price));
		System.out.println("New menu item added!");
	}

	// ===================================================deleteMenuItem====================================================
	private static void deleteMenuItem(ArrayList<MenuItem> menuItemList, MenuItem m) {
		String name = m.getName();
		String category = m.getCategory();
		boolean healthyChoice = m.isHealthyChoice();
		double price = m.getPrice();

		for (int x = 0; x < menuItemList.size(); x++) {
			if (menuItemList.get(x).getName().equals(name) && menuItemList.get(x).getCategory().equals(category)
					&& menuItemList.get(x).isHealthyChoice() == healthyChoice
					&& menuItemList.get(x).getPrice() == price)
				menuItemList.remove(x);
		}

		System.out.println(name + " is removed!");
	}
	
	private static MenuItem narrowingMenuItemList(ArrayList<MenuItem> menuItemList) {
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
			double bottomPrice = Helper.readDouble("From: $");
			double topPrice = Helper.readDouble("To: $");
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
							&& menuItemList.get(x).getPrice() == price) {
						return menuItemList.get(x);
					}
				}
			}
		}
		return null;
	}

	// ===================================================updateMenuItem====================================================

	static void updateMenuItem(ArrayList<MenuItem> menuItemList, MenuItem m) {

		boolean moreChanges = true;
		while (moreChanges) {
			Helper.line(60, "-");
			System.out.println(m.toString());

			System.out.println("1. Category");
			System.out.println("2. Name");
			System.out.println("3. Healthy Choice");
			System.out.println("4. Price");
			int changeNum = Helper.readInt("What do you wish to change? > ");

			if (changeNum == 1) {
				m.setCategory(Helper.readString("Enter new Category Name > "));

			} else if (changeNum == 2) {
				m.setName(Helper.readString("Enter new Menu Item Name > "));

			} else if (changeNum == 3) {
				boolean acceptedAns = false;
				boolean newHealthy = false;

				while (!acceptedAns) {
					char healthyReader = Helper.readChar("Update Menu Item healthy choice (y/n)> ");
					if (Character.toLowerCase(healthyReader) == 'y' || Character.toLowerCase(healthyReader) == 'n') {
						acceptedAns = true;
						if (Character.toLowerCase(healthyReader) == 'y')
							newHealthy = true;
					} else {
						System.out.println("Invalid input! Please enter only either y or n");
					}
				}

				m.setHealthyChoice(newHealthy);

			} else if (changeNum == 4) {
				double newPrice = -1;
				while (newPrice <= 0) {
					newPrice = Helper.readDouble("Enter new Price > ");
					if (newPrice <= 0)
						System.out.println("Enter a price that is higher than 0!");
				}

				m.setPrice(newPrice);

			} else {
				System.out.println("Invalid Input!");
			}

			boolean acceptedAns = false;

			while (!acceptedAns) {
				char healthyReader = Helper.readChar("Any more update to make on " + m.getName() + " (y/n)> ");
				if (Character.toLowerCase(healthyReader) == 'y' || Character.toLowerCase(healthyReader) == 'n') {
					acceptedAns = true;
					if (Character.toLowerCase(healthyReader) == 'n')
						moreChanges = false;
				} else {
					System.out.println("Invalid input! Please enter only either y or n");
				}
			}

		}
	}

	// ===================================================findMenuItem====================================================

	private static void findMenuItem(ArrayList<MenuItem> menuItemList) {
		String finderName = Helper.readString("Enter name to search > ");

		ArrayList<MenuItem> finderList = new ArrayList<MenuItem>();

		for (MenuItem mi : menuItemList) {
			if (mi.getName().toLowerCase().contains(finderName.toLowerCase()))
				finderList.add(mi);
		}

		if (finderList.size() == 0) {
			System.out.println("No Result");
		} else {
			System.out.println(String.format("%-20s %-30s %-15s %-10s", "Category", "Name", "Healthy Choice", "Price"));
			for (MenuItem mi : menuItemList) {
				System.out.println(mi.toString());
			}
		}
	}

	// Submenu for menuItem
	private static void menuItem() {
		// TODO Auto-generated method stub
		System.out.println("1. View Menu Item");
		System.out.println("2. Add Menu Item");
		System.out.println("3. Delete Menu Item");
		System.out.println("4. Update Menu Item");
		System.out.println("5. Find Menu Item");
	}

	// ===================================================DeleteBill=========================================================

	// ===================================================AddBill===========================================================
	public static Bill inputBill() {
		String payee = Helper.readString("Enter Payee's name > ");
		double totalAmount = Helper.readDouble("Enter total amount > ");
		String dueDate = Helper.readString("Enter due date >");

		Bill bl = new Bill(payee, totalAmount, dueDate);
		return bl;

	}

	public static void addBill(ArrayList<Bill> billList, Bill bl) {

		billList.add(bl);
		System.out.println("Bill Added");
	}

	// ===================================================ViewAllBill=========================================================
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

	// Submenu for bill
	private static void billMenu() {
		// TODO Auto-generated method stub
		System.out.println("1. Create Bills");
		System.out.println("2. Delete Bills");
		System.out.println("3. View All Bills");
		Helper.line(80, "-");
	}

}