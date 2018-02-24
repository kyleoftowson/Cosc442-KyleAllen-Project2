package edu.towson.cis.cosc442.project2.vendingmachine;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/**
 * Suite that has both junit classes in it
 * so they can run together
 * @author Kyle
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ VendingMachineItemTest.class, VendingMachineTest.class })
public class VendingMachineTests {

}
