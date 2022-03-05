// Developer name: Ronggang Cui
// ID: 1617665
// Update Date: Dec 1
// This program generate the payment for employees.


package ece325_assignment4;

public class Salary {
	
	/**
	 * Returns the amount of pay a band member will get (in dollars). This amount is computed by adding the bonus (if any)
	 * to the base salary and then deducting the amount spent on snacks. So, if a band member earned 100 dollars, spent 50 on snacks,
	 * and earned a bonus of 10 (%), their pay will be 60 dollars. 
	 * 
	 * Note: The current implementation of this method is extremely buggy and can easily be abused by anyone.
	 * 
	 * @param salary The base salary earned by this band member during this salary period (in dollars).
	 * @param snacksAmount The total amount spent by this band member on snacks during this salary period (in dollars).
	 * @param bonus The bonus percentage that the band member earned this salary period (in percentage).   
	 * @return the amount of pay a band member will get (in dollars)
	 */
	public Double pay(Double salary, Double snacksAmount, Integer bonus) {
		
		// checking if any variable is null
		if (salary == null) {
			throw new IllegalArgumentException("Incorrect payment, base salary is null");
		}else
		if (snacksAmount == null) {
			throw new IllegalArgumentException("Incorrect payment, snacks amount is null");
		}else
		if (bonus == null) {
			throw new IllegalArgumentException("Incorrect payment, bonus is null");
		}else
			
		// checking if any variable is not in the expected range
		if (salary > 1000 || salary < 0) {
			throw new IllegalArgumentException("Incorrect payment, base salary out of range");
		} else
		if (bonus > 10 || bonus < 0){
			throw new IllegalArgumentException("Incorrect payment, bonus out of range");
		} 
		
		Double grossIncome = salary*(bonus+100.0)/100.0;
		
		if (snacksAmount > grossIncome || snacksAmount < 0){
			throw new IllegalArgumentException("Incorrect payment, snack amount out of range");
		}
		
		return grossIncome - snacksAmount;
	}
}
