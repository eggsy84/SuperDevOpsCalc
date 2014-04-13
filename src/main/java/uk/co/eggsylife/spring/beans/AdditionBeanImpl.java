package uk.co.eggsylife.spring.beans;

import org.springframework.stereotype.Service;

@Service
public class AdditionBeanImpl implements AdditionBean {

	/* (non-Javadoc)
	 * @see uk.co.eggsylife.spring.beans.AdditionBean#addTwoNumbers(int, int)
	 */
	@Override
	public int addTwoNumbers(int numberOne, int numberTwo) {
		return numberOne+numberTwo;
	}
}
