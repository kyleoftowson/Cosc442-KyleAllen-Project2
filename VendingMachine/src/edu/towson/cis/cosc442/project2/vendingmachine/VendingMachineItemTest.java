package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineItemTest {
	VendingMachineItem item;
	VendingMachineItem item4;
	VendingMachineItem item3;
	VendingMachineItem item2;
	VendingMachineItem item1;

	@Before
	public void setUp() throws Exception {

		item = new VendingMachineItem("chips", 89.00);
		item1 = new VendingMachineItem("cookies", 32);
		item2 = new VendingMachineItem("1", 9);
		item3 = new VendingMachineItem("", 90.64);
		item4 = new VendingMachineItem("1.0", 0.00);
	}

	@After
	
	public void tearDown() throws Exception {
		item = null;
		item4 = null;
		item3 = null;
		item2 = null;
		item1 = null;
	}
/**
 * This tests that the method works coreectly as well as if it recieves a negative number
 */
	@Test
	public void testVendingMachineItem() {
		assertTrue(item.getName().equals("chips") && item.getPrice() == 89);
		try {
			item2 = new VendingMachineItem("", -8);
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("Price cannot be less than zero"));
		}
	}
/**
 * It makes sure the name is what it was entered as. 
 */
	@Test
	public void testGetName() {
		assertTrue(item.getName().equals("chips"));
		assertTrue(item1.getName().equals("cookies"));
		assertTrue(item2.getName().equals("1"));
		assertTrue(item3.getName().equals(""));
		assertTrue(item4.getName().equals("1.0"));
	}

	@Test
/**
 * This tests that the price is what it was when it was entered. It also tests what happens when the price is negative when entered.
 */
	public void testGetPrice() {
		assertTrue(item.getPrice() == 89);
		assertTrue(item1.getPrice() == 32);
		assertTrue(item2.getPrice() == 9);
		assertTrue(item3.getPrice() == 90.64);
		assertTrue(item4.getPrice() == 0);
		VendingMachineItem item9 = null;
		try {
			item9 = new VendingMachineItem(" ", -8);
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("Price cannot be less than zero"));
		}
		
		
		
	}

}
