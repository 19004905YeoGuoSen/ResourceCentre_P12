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
		//Item list is not null, so that can add a new order 
		assertNotNull("Test if ther is valid order arrylist to add to", orderList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		SchoolLunchApp.addAllOrder(orderList, order1);
		assertEquals("Test if that Order arrayList size is 1?", 1, orderList.size());
		
		//The item just added is same as the first item of the list
		assertSame("test that Order is added same as 1st item of the list?", order1, orderList.get(0));
		
		//Add another item. Test that the size of the list is 2? 
		SchoolLunchApp.addAllOrder(orderList, order2);
		assertEquals("Test that Order arrayList size is 2?", 2, orderList.size());
	}
	
	public void retrieveAllOrderTest() {
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
		
		testOutput = String.format("%-15s %-20s %-30s\n", "Order001", "11/06/2020", new ArrayList<MenuItem>());
		
		assertEquals("Check that ViewAllOrderList", testOutput, allOrder);
	}

}
