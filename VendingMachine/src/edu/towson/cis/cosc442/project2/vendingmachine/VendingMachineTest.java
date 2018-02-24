/**
 * 
 */
package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Kyle
 *
 */
public class VendingMachineTest {

	/**
	 * @throws java.lang.Exception
	 */
	VendingMachine vm;
	VendingMachine vm1;
	VendingMachine vm2;
	VendingMachine vm3;
	VendingMachine vm4;
	VendingMachineItem item;
	VendingMachineItem item1;
	VendingMachineItem item2;
	VendingMachineItem item3;

	@Before
	public void setUp() throws Exception {
		vm = new VendingMachine();
		vm1 = new VendingMachine();
		vm2 = new VendingMachine();
		vm3 = new VendingMachine();
		vm4 = new VendingMachine();
		item = new VendingMachineItem(null, 50);
		item1 = new VendingMachineItem(null, 1000);
		item2 = new VendingMachineItem(null, 300);
		item3 = new VendingMachineItem(null, 5);

	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		item = null;
		item1 = null;
		item2 = null;
		item3 = null;
		vm = null;
		vm4 = null;
		vm3 = null;
		vm2 = null;
		vm1 = null;
	}
/**
 * This tests if an invalid code is entered, and that it works normally as well.
 */
	@Test
	public void testAddItem() {

		// * Postcondition: The item is now at the slot specified by the code
		vm.addItem(item, "A");
		assertTrue(vm.getItem("A").equals(item));
		// Precondition: The slot specified by the code must be empty
		// * 1. If you add an item to a slot that is already occupied.
		vm1.addItem(item1, "B");
		try {
			vm1.addItem(item2, "B");
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("Slot " + "B" + " already occupied"));
		}

		// * 2. If you add an item with an invalid code
		try {
			vm3.addItem(item3, "R");
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("Invalid code for vending machine item"));
		}

	}
/**
 * This tests when the item is removed with the wrong code, and the right code
 * It tests if something is occupying the slot also.
 */
	@Test
	public void testRemoveItem() {
		// * Removes an item from the vending machine given its code.

		vm.addItem(item, "C");
		vm.removeItem("C");
		try {
			vm.getItem("C");
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("Invalid code for vending machine item"));

		}
		// * @return The item occupying the slot with the given code.
		vm1.addItem(item2, "D");
		assertTrue(vm1.removeItem("D").equals(item2));
		// If the slot at the specified code is empty
		try {
			vm2.removeItem("A");
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("Slot " + "A" + " is empty -- cannot remove item"));
		}
		// * @throws VendingMachineException and if the code is invalid

		try {
			vm3.removeItem("Z");
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("Invalid code for vending machine item"));
		}

	}
	/**
	 * This tests when the money inserted is 0, when the balence is negative, and that it works corectly
	 */
	@Test
	public void testInsertMoney() {
		vm.balance = 0;
		vm.insertMoney(30);
		assertTrue(vm.balance == 30);
		vm1.balance = 40;
		vm1.insertMoney(70);
		assertTrue(vm1.getBalance() == 110);
		vm3.balance = -40;
		try {
			vm3.insertMoney(4);

		} catch (Exception e) {
			assertTrue(e.getMessage().equals("Invalid amount.  Amount must be >= 0"));
		}
		vm4.balance = 70;
		vm4.insertMoney(0);
		assertTrue(vm4.balance == 70);

	}
/**
 * Thiis tests when the balence is greater, equal to and lower than 0 before method starts
 * 
 * It also tests that the balence is what it was before
 */
	@Test
	public void testGetBalance() {
		// pre >
		vm.balance = 90;
		assertTrue(vm.getBalance() == 90);
		// pre=
		vm1.balance = 0;
		assertTrue(vm1.getBalance() == 0);
		// post=
		assertTrue(vm1.balance == 0);
		// post>
		vm4.balance = 89;
		vm4.getBalance();
		assertTrue(vm4.balance == 89);
		// pre<
		vm3.balance = -5;
		assertTrue(vm3.getBalance() == 0);
		assertTrue(vm3.balance == 0);
	}
/**
 * This tests if the code returns false if not enough money and if it is an empty slot. It tests
 *  if it returns true for if there is enough money. It tests if the amount of money is subtracted from the balence. It also tests that the 
 *  the method works.. 
 */
	@Test
	public void testMakePurchase() {

		// Also returns false if the code is for an empty slot.
		assertFalse(vm.makePurchase("C"));
		// Returns false if not enough money is put
		// * into the vending machine to make the purchase.
		vm3.balance = 999;
		vm3.addItem(item1, "C");
		assertFalse(vm3.makePurchase("C"));
		// * @return Returns true if there is enough money to make the purchase.

		vm1.balance = 10;
		vm1.addItem(item3, "D");
		assertTrue(vm1.makePurchase("D"));

		// Postcondition: The amount of the item is subtracted from the balance
		assertTrue(vm1.balance == 5);
		// Precondition: balance >= 0
		vm4.balance = -50;
		vm4.addItem(item3, "B");
		assertFalse(vm4.makePurchase("B"));
		vm.balance = 0;
		vm.addItem(item3, "B");
		assertFalse(vm.makePurchase("B"));
		vm2.balance = 1010;
		vm2.addItem(item3, "B");
		assertTrue(vm2.makePurchase("B"));

	}

	@Test
	/**
	 * This test tests if return change works if the balence is negative, zero or positive. It also tests if the balence
	 * is zero afterwards.
	 */
	public void testReturnChange() {
		// =0
		assertTrue(vm.returnChange() == 0);
		vm1.insertMoney(20);
		// >0
		assertTrue(vm1.returnChange() == 20);
		vm2.balance = -20;
		// <0
		assertTrue(vm2.returnChange() == -20);
		// post=0
		assertTrue(vm1.balance == 0);

	}

}
