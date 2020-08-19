import java.util.ArrayList;

public class SchoolLunchApp {

	public static void main(String[] args) {
		ArrayList<Bill> billList = new ArrayList<Bill>();
		billList.add(new Bill("John",30, "July 1st"));
		int option = 0;
		
		
		
		while (option != 4) {
			SchoolLunchApp.menu();
			option = Helper.readInt("Enter an option > ");
		
		if(option == 1) {
			// Create Bill
			Helper.line(20, "-");
	        System.out.println("Create Bill");
	        Helper.line(20, "-");
	     
	      Bill bl = inputBill();
	      SchoolLunchApp.addBill(billList, bl);
			
		}else if (option == 2) {
			// Delete Bill
		      Helper.line(20, "-");
		      System.out.println("Delete Bill");
		      Helper.line(20, "-");
		    
		     String payeeName = Helper.readString("Enter Payee's Name > ");
			
	
			}else if(option ==3) {
				  //View Bill
      Helper.line(20, "-");
      System.out.println("VIEW ALL BILL");
      Helper.line(20, "-");
      SchoolLunchApp.ViewAllBill(billList);
		
		
		
		
		
      
		}else if(option ==4) {
			System.out.println("Bye");
		}else {
			System.out.println("Invalid Option");
		}
	}

      
      
      
	
      
    
      
      
      
	
	}
	
	
	// Delete Bill Main methods
	
	
	
	
	// Create Bill main methods
  public static Bill inputBill() {
	   String payee = Helper.readString("Enter Payee's name > ");
       double totalAmount = Helper.readDouble("Enter total amount > ");
       String dueDate = Helper.readString("Enter due date >");

		Bill bl= new Bill(payee, totalAmount, dueDate);
		return bl;
		
	}
	public static void addBill(ArrayList<Bill> billList, Bill bl) {
		
		billList.add(bl);
		System.out.println("Bill Added");
	}
		
		
	// View All Bill main methods
			 public static String retrieveAllBill(ArrayList<Bill> billList) {
				 String output = "";
			   
			    for (int i = 0; i < billList.size(); i++) {

					output += String.format("%-10s %-30s %-10s\n", billList.get(i).getPayee(), billList.get(i).getTotalAmount(), billList.get(i).getDueDate()); 
				}
				return output;
				}
			 
			 public static void ViewAllBill(ArrayList<Bill> billList) {
				 System.out.println("BILL LIST");
				 String output = String.format("%-10s %-30s %-10s\n", "PAYEE", "TOTAL AMOUNT",
							"DUE DATE");
					 output += retrieveAllBill(billList);	
					System.out.println(output);
				 
			 }
			 
			 private static void menu() {
					// TODO Auto-generated method stub
				 System.out.println("1. Create Bills");
				 System.out.println("2. Delete Bills");
				 System.out.println("3. View All Bills");
				 System.out.println("4. Quit");
					Helper.line(80, "-");
				}
		

		
		
		
		

}
