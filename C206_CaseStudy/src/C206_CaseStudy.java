import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 5; //Extract Constant


	public static void main(String[] args) {
		// ArrayLists
		ArrayList<Order> orderList = new ArrayList<Order>();
		
		int option = 0;
		while(option != OPTION_QUIT) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");
			
			if(option == 1) {
				order();
				int orders = Helper.readInt("Enter option to select > ");
				
				if(orders == 1) {
					C206_CaseStudy.viewAllOrder(orderList);
				} else if (orders == 2) {
					C206_CaseStudy.addAllOrder(orderList);
				} else if (orders == 3) {
					C206_CaseStudy.deleteAllOrder(orderList);
				}
			
			} 

	}

}


//===================================================Order=========================================================
	private static void viewAllOrder(ArrayList<Order> orderList) {
		// TODO Auto-generated method stub
		
	}


	private static void addAllOrder(ArrayList<Order> orderList) {
		// TODO Auto-generated method stub
		
	}

	private static void deleteAllOrder(ArrayList<Order> orderList) {
		// TODO Auto-generated method stub
		
	}


	private static void order() {
		// TODO Auto-generated method stub
		System.out.println("1. View orders");
		System.out.println("2. Add orders");
		System.out.println("3. Delete orders");
	}

//===================================================menu()=========================================================
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
