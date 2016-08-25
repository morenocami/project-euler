package questions;

import java.math.BigInteger;

/**
 * Created by Camilo Moreno on 7/13/2016.
 */
public class Question14 {
    public static void main(String[] args) {
        int startingNum = 1;
        int longestCollatzLength = 0;
        while (startingNum < 1000000) {
            int collatzLength = getCollatz(BigInteger.valueOf(startingNum));
            if (collatzLength > longestCollatzLength) {
                longestCollatzLength = collatzLength;
                System.out.println(startingNum);
            }
            startingNum++;
        }
        System.out.println(startingNum);
    }

    private static int getCollatz(BigInteger startingNum) {
        int collatzLength = 0;
        while (startingNum.compareTo(BigInteger.valueOf(1)) != 0) {
            if (startingNum.mod(BigInteger.valueOf(2)).compareTo(BigInteger.valueOf(0)) == 0) {
                startingNum = startingNum.divide(BigInteger.valueOf(2));
                collatzLength++;
            } else {
                startingNum = startingNum.multiply(BigInteger.valueOf(3)).add(BigInteger.valueOf(1));
                collatzLength++;
            }
        }
        return collatzLength;
    }
}
