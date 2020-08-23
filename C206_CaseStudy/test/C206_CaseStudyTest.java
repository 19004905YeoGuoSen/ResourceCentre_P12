import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Order order1;
	private Order order2;
	private MenuItem menuItem1;
	private MenuItem menuItem2;
	
	
	private ArrayList<Order> orderList;
	private ArrayList<MenuItem> menuItemList;

	@Before
	public void setUp() throws Exception {
		order1 = new Order("19002451", "11/06/2020", new ArrayList<MenuItem>());
		order2 = new Order("19036051", "20/08/2020", new ArrayList<MenuItem>());
		menuItem1 = new MenuItem ("Japanese", "Sushi", true, 5.5);
		menuItem2 = new MenuItem ("Western", "Steak", false, 15);
	}

	@After
	public void tearDown() throws Exception {
		order1 = null;
		order2 = null;
		menuItem1 = null;
		menuItem2 = null;
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	//===============================================Order=============================================================
	public void addAllOrderTest() {
		//Order list is not null
		assertNotNull("Check if there is valid order arrylist to add to", orderList);
		
		//After adding 1 order, the order stored in the list is the same as the order being added
		SchoolLunchApp.addAllOrder(orderList, order1);
		assertEquals("Check if the Order arrayList size is 1?", 1, orderList.size());
		assertSame("Check that the order is added", order1, orderList.get(0));
		
		//After adding another order. the arraylist size is 2 and the second order in the list is the order added 
		SchoolLunchApp.addAllOrder(orderList, order2);
		assertEquals("Test that Order arrayList size is 2?", 2, orderList.size());
		assertSame("Check that the order is added", order2, orderList.get(1));
	}
	
	public void viewAllOrderTest() {
		// Test if Item list is not null but empty, so that can add a new order
		assertNotNull("Test if there is valid Order arraylist to add to", orderList);
		
		//Test if the list of orders retrieved from the SourceCentre is empty
		String allOrder = SchoolLunchApp.retrieveAllOrder(orderList);
		String testOutput = "";
		assertEquals("Check that ViewAllOrderlist", testOutput, allOrder);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		SchoolLunchApp.addAllOrder(orderList, order1);
		SchoolLunchApp.addAllOrder(orderList, order2);
		assertEquals("Test if that Order arraylist size is 2?", 2, orderList.size());
		
		//Test if the expected output string same as the list of order retrieved from the SourceCentre
		allOrder= SchoolLunchApp.retrieveAllOrder(orderList);
		
		testOutput = String.format("%-15s %-20s %-30s\n", "19002451", "11/06/2020", new ArrayList<MenuItem>());
		
		assertEquals("Check that ViewAllOrderList", testOutput, allOrder);
	}
	
	public void updateAllOrderTest() {
		//Order list is not null
		assertNotNull("Check of there is valid order arraylist to add to", orderList);
		
		//After updating 1 order, the order stored in the list is the same as the order being updated
		SchoolLunchApp.updateAllOrder(orderList, order1);
		assertEquals("Check if the order arrayList is 1?", 1, orderList.size());
		assertSame("Check that the order is updated", order1, orderList.get(0));
		
		//After updating another order. the arraylist size is 2 and the second order in the list is the order updated 
		SchoolLunchApp.updateAllOrder(orderList, order2);
		assertEquals("Check if the order arrayList size is 2", 2, orderList.size());
		assertSame("Check that the order is updated", order2, orderList.get(1));
	}
	
	public void deleteOrderTest() {
		//Test that the list is not empty
		assertNotNull("Check if there is a orderList to retrieve items", orderList);
		
		//Test that 2 items can be removed and the arraylist is empty
		SchoolLunchApp.addAllOrder(orderList, order1);
		SchoolLunchApp.addAllOrder(orderList, order2);
		assertEquals("Check that the size of orderList is 2", 2, orderList.size());
		orderList.remove(1);
		assertEquals("Check that the size of orderList is 1", 1, orderList.size());
		orderList.remove(0);
		assertEquals("Check that the size of orderList is 0", 0, orderList.size());
	}
	
	//===============================================MenuItem=============================================================
	
	public void addAllMenuItemTest() {
		assertNotNull("Check if there is valid MenuItem arraylist to add to", menuItemList);
		
		SchoolLunchApp.addMenuItem(menuItemList, menuItem1);
		assertEquals("Check that MenuItem arraylist size is 1", 1, menuItemList.size());
		assertSame("Check that MenuItem is added", menuItem1, menuItemList.get(0));
		
		SchoolLunchApp.addMenuItem(menuItemList, menuItem2);
		assertEquals("Check that MenuItem arraylist size is 2", 2, menuItemList.size());
		assertSame("Check that MenuItem is added", menuItem2, menuItemList.get(1));
		
	}
	
	public void viewMenuItemOutputTest() {
		assertNotNull("Test if there is valid MenuItem arraylist to retrieve item from", menuItemList);
		
		SchoolLunchApp.addMenuItem(menuItemList, menuItem1);
		
		String healthyChoicePrinter = "no";
		if (menuItem1.isHealthyChoice())
			healthyChoicePrinter = "yes";
		String testOutput = String.format("%-20s %-30s %-15s %-10.2f", menuItem1.getCategory(), menuItem1.getName(), healthyChoicePrinter, menuItem1.getPrice());
		assertEquals("Check that MenuItem arraylist first item output is the same", menuItemList.get(0).toString(), testOutput);
		
		SchoolLunchApp.addMenuItem(menuItemList, menuItem2);
		
		healthyChoicePrinter = "no";
		if (menuItem2.isHealthyChoice())
			healthyChoicePrinter = "yes";
		testOutput = String.format("%-20s %-30s %-15s %-10.2f", menuItem2.getCategory(), menuItem2.getName(), healthyChoicePrinter, menuItem2.getPrice());
		assertEquals("Check that MenuItem arraylist second item output is the same", menuItemList.get(1).toString(), testOutput);
	}
	
	public void deleteMenuItemTest() {
		assertNotNull("Test if there is valid MenuItem arraylist to retrieve item from", menuItemList);
		SchoolLunchApp.addMenuItem(menuItemList, menuItem1);
		SchoolLunchApp.addMenuItem(menuItemList, menuItem2);
		
		assertEquals("Check that MenuItem arraylist size is 2", 2, menuItemList.size());
		
		SchoolLunchApp.deleteMenuItem(menuItemList, menuItem1);
		assertEquals("Check that MenuItem arraylist size is 1", 1, menuItemList.size());
		assertSame("Check that MenuItem1 is removed", menuItem2, menuItemList.get(0));
		
		SchoolLunchApp.deleteMenuItem(menuItemList, menuItem2);
		assertEquals("Check that MenuItem arraylist size is 0", 0, menuItemList.size());
	}
	
	
	
	
	
	
}
