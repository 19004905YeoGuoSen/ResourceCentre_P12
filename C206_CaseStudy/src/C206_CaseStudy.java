import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 5; // Extract Constant

	public static void main(String[] args) {
		// ArrayLists
		ArrayList<Order> orderList = new ArrayList<Order>();
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();

		int option = 0;
		while (option != OPTION_QUIT) {
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

	//=============================================ViewAllOrder====================================
	private static void viewAllOrder(ArrayList<Order> orderList) {
		// TODO Auto-generated method stub
		String output = String.format("%-15s %-20s %-30s\n", "STUDENT ID", "ORDER DATE", "ITEMS");
		
		for (int i = 0; i < orderList.size(); i++) {
			output += String.format("%-84s\n", orderList.get(i).toString());
		}
		System.out.println(output);
	}
	
	//=============================================addAllOrder====================================
	public static Order inputOrder() {
		String studentid = Helper.readString("Enter Student ID > ");	
		String orderdate = Helper.readString("Enter Order Date > ");
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();

		Order order1= new Order(studentid, orderdate, items);
		return order1;
		
	}
	
	public static void addAllOrder(ArrayList<Order> orderList,  Order order1) {
		orderList.add(order1);
		System.out.println("Order added");
	}

	//=============================================deleteAllOrder====================================
	private static void deleteAllOrder(ArrayList<Order> orderList) {
		// TODO Auto-generated method stub
		System.out.println("1. Student ID");
		System.out.println("2. Order Date");
		
		int num = Helper.readInt("Enter option to search > ");
		
		ArrayList<Order> find = new ArrayList<Order>(); 
		
		if (num == 1) {
			String studentid = Helper.readString("Enter Student ID > ");
			for (Order od : orderList) {
				if (od.getStudentId().equalsIgnoreCase(studentid)) {
					find.add(od);
				}
			}
		} else if (num == 2) {
			String orderdate = Helper.readString("Enter order date > ");
			for (Order od : orderList) {
				if (od.getOrderDate().equalsIgnoreCase(orderdate)) {
					find.add(od);
				}
			}
		}

	}

	private static void order() {
		// TODO Auto-generated method stub
		System.out.println("1. View orders");
		System.out.println("2. Add orders");
		System.out.println("3. Delete orders");
		System.out.println("4. Update orders");
	}
	
		//===================================================MenuItem=========================================================
		private static void viewAllMenuItem(ArrayList<MenuItem> menuItemList) {
			// TODO Auto-generated method stub
			System.out.println("Menu Item");
			Helper.line(80, "-");
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
				System.out.println(String.format("Index %-20s %-30s %-15s %-10s", "Category", "Name", "Healthy Choice", "Price"));
				for (int i = 0; i < findMenuItemList.size(); i++) {
					System.out.println(String.format("%-5d %s", i+1, findMenuItemList.get(i).toString()));
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
						if (menuItemList.get(x).getName().equals(name) && menuItemList.get(x).getCategory().equals(category) && menuItemList.get(x).isHealthyChoice() == healthyChoice && menuItemList.get(x).getPrice() == price)
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
	
		//===================================================optionmenu()=========================================================
		private static void menu() {
			// TODO Auto-generated method stub
			C206_CaseStudy.setHeader("SCHOOL LUNCH APP");
			System.out.println("1. Orders");
			System.out.println("2. User Account");
			System.out.println("3. Menu Items");
			System.out.println("4. Bills");
			System.out.println("5. Quit");
			Helper.line(80, "-");
		}

		private static void setHeader(String header) {
			Helper.line(80, "-");
			System.out.println(header);
			Helper.line(80, "-");
		}

}
