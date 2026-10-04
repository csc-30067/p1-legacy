/* **********************
 * CSC-30067 2026/27     
 * Working with legacy code
 * 
 * Note that this code relies on the library provided by the jar file:
 * legacypayroll-1.0.0.jar
 * **********************/
package uk.ac.keele.csc30067;

import uk.ac.keele.csc30067.legacy.HourlyEmployee;

/**
 * A new concrete implementation of the Employee class, based on an employee
 * who's paid by the hour, on minimum wage.
 * The wage will be determined based on the age of the employee.
 * 
 * Note that this implementation is INCOMPLETE and you will need to fix it as
 * part of the practical.
 * 
 * For the purpose of this exercise, we'll refer to the National Living Wage
 * rates set by the government for 2023.
 * Age 23 or over: £10.42
 * Age 21 to 22: £10.18
 * Age 18 to 20: £7.49
 * Under 18: £5.28 (but we won't consider this as our company doesn't hire under
 * 18s)
 */
public class MinimumWageEmployee extends HourlyEmployee {
    // TODO: add private attributes as needed
    private int age;

    /**
     * Constructor for the class representing an employee with a minimum wage
     * contract.
     * The wage will be determined based on the age of the employee.
     * Note that - unlike the parent class - the wage is not passed as a parameter.
     * 
     * @param firstName            first name of the employee
     * @param lastName             last name of the employee
     * @param socialSecurityNumber the SSN (a sequence of digits in the form
     *                             ddd-dddd-ddd)
     * @param age                  the age of the employee, for the purpose of
     *                             calculating the wage
     *                             (must be greater than 18)
     * @param hours                the worked hours per week
     */
    public MinimumWageEmployee(String firstName, String lastName, String socialSecurityNumber, int age, double hours) {
        super(firstName, lastName, socialSecurityNumber, 0.0, hours);

        this.age = age;
        this.setWage(age);
    }

    /**
     * Note that this method is not an overriden version of the methdd in the parent
     * class.
     * Rather, it overloads the original method, to allow to set the wage based on
     * the age
     * of the employee (see National Living Wage rates). This implements a form of
     * polymorphism.
     * 
     * @param age the age of the employee, for the purpose of calculating the wage
     *            (must be greater than 18)
     */
    public void setWage(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be greater than 18");
        }
        double wage = 0.0;
        
        // TODO: compute the wage as per requirements (based on the age)
        if (age <= 20) {
            wage = 7.49;
        } else if (age <= 22) {
            wage = 10.18;
        } else {
            wage = 10.42;
        }
       
        super.setWage(wage);
    }

    /**
     * There is usually no need for documenting obvious getters and setters.
     * For completeness, we document them here.
     * This sets the age of the employee, for the purpose of calculating the wage.
     * 
     * @param age the age of the employee, for the purpose of calculating the wage
     *            (must be greater than 18)
     */
    public void setAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be greater than 18");
        }
        this.setWage(age);
    }

    /**
     * There is usually no need for documenting obvious getters and setters.
     * For completeness, we document them here.
     * This returns the age of the employee.
     * 
     * @return the age of the employee
     */
    public int getAge() {
        // TODO: fix as appropriate
        return age;
    }

    /**
     * It's usually a good idea to override the toString() method
     * to provide a more meaningful representation of the object when
     * it is printed.
     * 
     * @return a String representation of the CommissionEmployee object (printout of
     *         the main attributes)
     */
    @Override
    public String toString() {
        return String.format("minimum wage %s",
                super.toString());
    }
}
