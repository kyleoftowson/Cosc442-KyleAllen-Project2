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

	@Test
	public void testVendingMachineItem() {
		assertTrue(item.getName().equals("chips") && item.getPrice() == 89);
		try {
			item2 = new VendingMachineItem("", -8);
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("Price cannot be less than zero"));
		}
	}

	@Test
	public void testGetName() {
		assertTrue(item.getName().equals("chips"));
		assertTrue(item1.getName().equals("cookies"));
		assertTrue(item2.getName().equals("1"));
		assertTrue(item3.getName().equals(""));
		assertTrue(item4.getName().equals("1.0"));
	}

	@Test

	public void testGetPrice() {
		assertTrue(item.getPrice() == 89);
		assertTrue(item.getPrice() == 32);
		assertTrue(item.getPrice() == 9);
		assertTrue(item.getPrice() == 90.64);
		assertTrue(item.getPrice() == 0);
		VendingMachineItem item9;
		try {
			item9 = new VendingMachineItem(" ", -8);
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("Price cannot be less than zero"));
		}

	}

}
