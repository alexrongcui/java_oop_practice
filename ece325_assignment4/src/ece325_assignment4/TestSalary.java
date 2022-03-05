// Developer name: Ronggang Cui
// ID: 1617665
// Update Date: Dec 1
// This program test the pay method in Salary class. 
// The details about this program is included in the test plan pdf.

package ece325_assignment4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class TestSalary {
	
	Salary mySalary;
	
	@BeforeEach
	void newSalary() {
		mySalary = new Salary();
	}

	@Test
	void testBasicCorrectness() {
		// some common cases of using pay method
		assertEquals(5.5, mySalary.pay(10.0, 5.0, 5), 0.001);
		assertEquals(18.0, mySalary.pay(20.0, 3.0, 5), 0.001);
	}
	
	@Test
	void testEdgeCasesInRange() {
		// test bonus
		assertEquals(5.0, mySalary.pay(10.0, 5.0, 0), 0.001);
		assertEquals(6.0, mySalary.pay(10.0, 5.0, 10), 0.001);
		// test snackAmount
		assertEquals(10.5, mySalary.pay(10.0, 0.0, 5), 0.001);
		assertEquals(0.0, mySalary.pay(10.0, 10.5, 5), 0.001);
		// test base salary
		assertEquals(1045.0, mySalary.pay(1000.0, 5.0, 5), 0.001);
		assertEquals(0.0, mySalary.pay(0.0, 0.0, 5), 0.001);
	}
	
	@Test
	void testNullValues() {
		assertThrows(IllegalArgumentException.class, () -> { 
			mySalary.pay(10.0, 5.0, null );
		});
		assertThrows(IllegalArgumentException.class, () -> { 
			mySalary.pay(10.0, null, 10 );
		});
		assertThrows(IllegalArgumentException.class, () -> { 
			mySalary.pay(null, 5.0, 10 );
		});
	}

	@Test
	void testEdgeCasesOutOfRange() {
		// test bonus
		assertThrows(IllegalArgumentException.class, () -> { 
			mySalary.pay(10.0, 5.0, -1);
		});
		assertThrows(IllegalArgumentException.class, () -> { 
			mySalary.pay(10.0, 5.0, 11);
		});
		// test snackAmount
		assertThrows(IllegalArgumentException.class, () -> { 
			mySalary.pay(10.0, -0.01, 5);
		});
		assertThrows(IllegalArgumentException.class, () -> { 
			mySalary.pay(10.0, 10.6, 5);
		});
		// test base salary
		assertThrows(IllegalArgumentException.class, () -> { 
			mySalary.pay(-0.01, 5.0, 5);
		});
		assertThrows(IllegalArgumentException.class, () -> { 
			mySalary.pay(1000.01, 5.0, 5);
		});
	}
	
	@Test
	void testNegativeValues() {
		assertThrows(IllegalArgumentException.class, () -> { 
			mySalary.pay(-10.0, 5.0, 10);
		});
		assertThrows(IllegalArgumentException.class, () -> { 
			mySalary.pay(10.0, -5.0, 10);
		});
		assertThrows(IllegalArgumentException.class, () -> { 
			mySalary.pay(10.0, 5.0, -10);
		});	
	}
	
	@Test
	void testBigValues() {
		assertThrows(IllegalArgumentException.class, () -> { 
			mySalary.pay(Double.MAX_VALUE, 5.0, 10);
		});
		assertThrows(IllegalArgumentException.class, () -> { 
			mySalary.pay(10.0, Double.MAX_VALUE, 10);
		});
		assertThrows(IllegalArgumentException.class, () -> { 
			mySalary.pay(10.0, 5.0, Integer.MAX_VALUE);
		});
	}

}
