package questions;

import java.util.Date;

public class Question15 {

    public static final long GRID_SIZE = 20;

    public static void main(String[] args) {
        Date start = new Date();
        System.out.println(findPaths(0, 0, 0));
        long timeEllapsed = new Date().getTime() - start.getTime();
        System.out.println("timeEllapsed: " + timeEllapsed);
    }

    private static long findPaths(long pathCount, long x, long y) {
//        printGrid(x, y);
        if (x != GRID_SIZE) {
            pathCount += findPaths(0, x + 1, y);
        }
        if (y != GRID_SIZE) {
            pathCount += findPaths(0, x, y + 1);
        }
        if (x == GRID_SIZE && y == GRID_SIZE)
            return 1;
        return pathCount;
    }

    private static void printGrid(long x, long y) {
        for (long i = 0; i <= GRID_SIZE; i++) {
            for (long j = 0; j <= GRID_SIZE; j++) {
                if (j == x && i == y)
                    System.out.print(" O");
                else
                    System.out.print(" _");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}