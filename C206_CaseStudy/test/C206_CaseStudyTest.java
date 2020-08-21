import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Order order1;
	private Order order2;
	
	private ArrayList<Order> orderList;

	@Before
	public void setUp() throws Exception {
		order1 = new Order("19002451", "11/06/2020", new ArrayList<MenuItem>());
		order2 = new Order("19036051", "20/08/2020", new ArrayList<MenuItem>());
	}

	@After
	public void tearDown() throws Exception {
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
		
		//After adding 1 item, the item stored in the list is the same as the item being added
		SchoolLunchApp.addAllOrder(orderList, order1);
		assertEquals("Check if the Order arrayList size is 1?", 1, orderList.size());
		assertSame("Check that the order is added", order1, orderList.get(0));
		
		//After adding another item. the arraylist size is 2 and the second item in the list is the item added 
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
		
		//test if the expected output string same as the list of order retrieved from the SourceCentre
		allOrder= SchoolLunchApp.retrieveAllOrder(orderList);
		
		testOutput = String.format("%-15s %-20s %-30s\n", "19002451", "11/06/2020", new ArrayList<MenuItem>());
		
		assertEquals("Check that ViewAllOrderList", testOutput, allOrder);
	}
	
//	public void updateAllOrderTest() {
//		Boolean ok = SchoolLunchApp.deleteAllOrder(orderList, "19002451");
//	}
	
	
	
	
	
	
	
	
	
	
	
	
}
