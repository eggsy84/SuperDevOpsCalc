package uk.co.eggsylife.testing.unit;

import org.junit.Assert;
import org.junit.Test;

import uk.co.eggsylife.spring.beans.AdditionBeanImpl;

public class AdditionUnitTest {
	
	/**
	 * Probably shouldn't do this for unit testing and should be mocking
	 * but it illustrates the point of unit/integration separation
	 */
	public AdditionBeanImpl additionBeanImpl = new AdditionBeanImpl();
	
	
	@Test
	public void testBasicAddition() {
		int numberOne = 1;
		int numberTwo = 2;
		
		int result = additionBeanImpl.addTwoNumbers(numberOne, numberTwo);
		Assert.assertEquals(3, result);
	}
	
	@Test
	public void testAdditionWithNegativeNumbers() {
		int numberOne = -1;
		int numberTwo = 2;
		
		int result = additionBeanImpl.addTwoNumbers(numberOne, numberTwo);
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void testAdditionWithZero() {
		int numberOne = 0;
		int numberTwo = 2;
		
		int result = additionBeanImpl.addTwoNumbers(numberOne, numberTwo);
		Assert.assertEquals(2, result);
	}

}
