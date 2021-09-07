package edu.ncsu.csc326.coffeemaker;

import org.junit.Before;
import org.junit.Test;


public class MainTest {

	@Test
	public void testWaitingState() {
		Main main = new Main();

		main.mainMenu();
	}

}
