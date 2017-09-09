
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
        while(carry != 0)
        {
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
        int loopCount;
        int result;
        boolean negateResult = false;
        
        if(a < 0 && b < 0) {
            result = negate(a);
            loopCount = negate(b);
            negateResult = true;
        } else if(b < 0) {
            loopCount = a;
            result = b;
        } else {
            loopCount = b;
            result = a;
        }

        for (int i = 1; i <= loopCount; i = plusOne(i)) {
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
        int result = 1;
        for (int i = 1; i < b; i = plus (i, 1)) {
            result = plus (result, a);
        }
        return result;
    }

    /**
     * Raise a number (a) to a given power (b).
     * @param a a number from "N0" 
     * @param b a number from "N0"
     * @return a^b or -1 if an error occured
     */
    public int pow (int a, int b) {
        int result = 1;
        for (int i = 1; i < b; i = plus (i, 1)) {
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
        while (a > 0) {
            a = plus (a, negate(b));
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
        int times = div (b, a);
        return plus (a, negate (multi (times, b)));
    }

    private boolean areN(int num1, int num2) {
        return (num1 > 0 && num2 > 0);
    }
    
    private boolean areN0(int num1, int num2) {
        return (num1 >= 0 && num2 >= 0);
    }
}