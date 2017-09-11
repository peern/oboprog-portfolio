/**
 * Basic calculator class. This class contains basic 
 * mathematical operations realized based on simple
 * bit manipulations (in the method plusOne and negate).
 * 
 * The arithmetic operations shall only be based on the 
 * operations defined herein including plusOne/negate. 
 * Using any other operation 
 * (i.e., a -, + or whatever) will mean -1 point per usage!
 * 
 * The methods can be used whenever the builtin functions  
 * from Java are way too fast.
 * 
 * Please note: it is strictly forbidden to use any of the 
 * internal Java functions for arithmethics!
 */
public class Calculator {

    /**
     * Please take this method for granted (no need for testing). 
     * It will add a single 1 to the number (a) passed.
     */
    private int plusOne(int a) {
        int carry = a & 1;
        int result = a ^ 1;
        while(carry != 0) {
            int shiftedcarry = carry << 1;
            carry = result & shiftedcarry;
            result ^= shiftedcarry;
        }
        return result;
    }

    /**
     * Please take this method for granted (no need for testing). 
     * It will negate the passed number (a), i.e., -a will be +a and vice versa.
     */
    private int negate (int a) {
        return plusOne(~a);
    }

    /**
     * Adds the value of b to the value of a
     * @param a factor from "Z"
     * @param b factor from "Z"
     * @return returns the result of a + b
     */
    public int plus (int a, int b) {
        int result = a;
        int counter = b;
        boolean negateResult = false;
        if(b < 0) {
            result = negate(a);
            counter = negate(b);
            negateResult = true;
        }

        for (int i = 0; i < counter; i = plusOne(i)) {
            result = plusOne(result);
        }

        return (negateResult ? negate(result) : result);
    }

    /**
     * Multiplies two values a and b (a * b)
     * @param a factor from "Z"
     * @param b factor from "Z"
     * @return returns the result of a * b
     */
    public int multi (int a, int b) {
        int result = 0;
        boolean negateMultiResult = false;
        if(b < 0) {
            b = negate(b);
            negateMultiResult = true;
        }
        for (int i = 1; i <= b; i = plusOne(i)) {
            result = plus(result, a);
        }
        return (negateMultiResult ? negate(result) : result);
    }

    /**
     * Raise a number (a) to a given power (b).
     * @param a a number from "N0" 
     * @param b a number from "N0"
     * @return a^b or -1 if an error occured
     */
    public int pow (int a, int b) {
        int result = 1;

        if(!areN0(a, b)) {
            return negate(1);
        }

        for (int i = 1; i <= b; i = plusOne (i)) {
            result = multi (result, a);

        }
        return result;
    }

    /**
     * Divides a number a by b.
     * @param a a number from "N" 
     * @param b a number from "N"
     * @return a / b or -1 if an error occured
     */
    public int div (int a, int b) {
        int result = 0;

        if(!areN(a, b)) {
            return negate(1);
        }

        while(a >= b) {
            result = plusOne(result);
            a = plus(a, negate(b));
        }

        return result;
    }

    /**
     * Divides a number a by b and returns the rest.
     * @param a a number from "N" 
     * @param b a number from "N"
     * @return a % b or -1 if an error occured
     */
    public int mod (int a, int b) {
        int integerQuotient = 0;

        if(!areN(a, b)) {
            return negate(1);
        }

        while(multi(b, plusOne(integerQuotient)) <= a) {
            integerQuotient = plusOne(integerQuotient);
        }

        return plus(a, negate(multi(integerQuotient, b)));
    }

    /**
     * Checks whether a number is prime
     * @param a a number from "N2" 
     * @return true if number is prime, false if number is not prime or not from N2
     */
    public boolean isPrime(int a) {
        if(a == 2) {
            return true;
        }
        
        if(!isN2(a) || mod(a, 2) == 0) {
            return false;
        }

        for(int i = 3; i < a; i = plusOne(i)) {
            if(multi(div(a, i), i) == a) {
                return false;
            }
        }
        
        return true;
    }

    /**
     * Checks whether two numbers are from "N0"
     */
    private boolean areN0(int num1, int num2) {
        return (num1 >= 0 && num2 >= 0);
    }

    /**
     * Checks whether two numbers are from "N"
     */
    private boolean areN(int num1, int num2) {
        return (num1 >= 1 && num2 >= 1);
    }

    /**
     * Checks whether a number is from "N2"
     */
    private boolean isN2(int number) {
        return number >= 2;
    }
}