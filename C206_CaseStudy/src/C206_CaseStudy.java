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
			


	}

}

//----------------------------------------------menu()---------------------------------------------------------------
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
