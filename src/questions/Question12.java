package questions;

/**
 * Created by Camilo Moreno on 7/12/2016.
 */
public class Question12 {

    public static void main(String[] args) {
        Incrementer inc = new Incrementer();
        int triangularNumber = 0;
        boolean notFound = true;
        while (notFound) {
            triangularNumber += inc.getNextInt();
            notFound = printDivisors(triangularNumber);
        }
        System.out.print(triangularNumber);
    }

    private static boolean printDivisors(int triangularNumber) {
        int divisorCount = 0, max = 0;
        if (triangularNumber % 2 == 0)
            max = triangularNumber / 2;
        else if (triangularNumber % 3 == 0)
            max = triangularNumber / 3;
        else if (triangularNumber % 5 == 0)
            max = triangularNumber / 5;
        else if (triangularNumber % 7 == 0)
            max = triangularNumber / 7;
        else if (triangularNumber % 11 == 0)
            max = triangularNumber / 11;
        else if (triangularNumber % 13 == 0)
            max = triangularNumber / 13;
        else if (triangularNumber % 17 == 0)
            max = triangularNumber / 17;
        else if (triangularNumber % 19 == 0)
            max = triangularNumber / 19;
        else if (triangularNumber % 23 == 0)
            max = triangularNumber / 23;
        else if (triangularNumber % 29 == 0)
            max = triangularNumber / 29;
        else if (triangularNumber % 31 == 0)
            max = triangularNumber / 31;
        else if (triangularNumber % 37 == 0)
            max = triangularNumber / 37;

        for (int i = 1; i <= max; i++) {
            if (triangularNumber % i == 0) {
                divisorCount++;
            }
        }
        return divisorCount < 500;
    }

    private static class Incrementer {
        private int count;

        Incrementer() {
            count = 0;
        }

        public int getNextInt() {
            return ++count;
        }
    }
}
