package questions;

import utilities.Couple;

import java.util.ArrayList;


public class Question11 {

    public static void main(String[] args) {
        Question11 q = new Question11();
        ArrayList<ArrayList<Integer>> numberGrid = q.parseNumberGrid(q.getGrid(), 20, 20);
        int result = q.findLargestProductInGrid(numberGrid);
        System.out.println(result);
    }

    private int findLargestProductInGrid(ArrayList<ArrayList<Integer>> numberGrid) {
        int largestHorizontalProduct = calculateLargestHorizontalProduct(numberGrid);
        int largestVerticalProduct = calculateLargestVerticalProduct(numberGrid);
        int largestForwardDiagonalProduct = calculateLargestForwardDiagonalProduct(numberGrid);
//        int largestBackwardDiagonalProduct = calculateLargestBackwardDiagonalProduct(numberGrid);
        return findLargestInteger(largestHorizontalProduct,
                largestVerticalProduct, largestForwardDiagonalProduct);
    }

    private int calculateLargestForwardDiagonalProduct(ArrayList<ArrayList<Integer>> numberGrid) {
        int largestInFirstHalf = firstHalf(numberGrid, new Couple<>(0, 0));
        int largestInSecondHalf = secondHalf(numberGrid, new Couple<>(19, 0));
        return findLargestInteger(largestInFirstHalf, largestInSecondHalf);
    }

    private int firstHalf(ArrayList<ArrayList<Integer>> numberGrid, Couple<Integer, Integer> base) {
        int largestInGrid = 0;
        for (int columnPosition = 0; columnPosition < numberGrid.get(0).size(); columnPosition++) {
            base.set(columnPosition, 0);
            while (areFourForwardDiagonalNumbersAvailable(numberGrid, base)) {
                int product = getForwardDiagonalProduct(numberGrid, base);
                if (product > largestInGrid)
                    largestInGrid = product;
                base.set(base.getX() - 1, base.getY() + 1);
            }
        }
        return largestInGrid;
    }

    private int secondHalf(ArrayList<ArrayList<Integer>> numberGrid, Couple<Integer, Integer> base) {
        int largestInGrid = 0;
        for (int rowPosition = 1; rowPosition < numberGrid.size(); rowPosition++) {
            base.set(19, rowPosition);
            while (areFourForwardDiagonalNumbersAvailable(numberGrid, base)) {
                int product = getForwardDiagonalProduct(numberGrid, base);
                if (product > largestInGrid)
                    largestInGrid = product;
                base.set(base.getX() - 1, base.getY() + 1);
            }
        }
        return largestInGrid;
    }

    private int getForwardDiagonalProduct(ArrayList<ArrayList<Integer>> numberGrid, Couple<Integer, Integer> base) {
        int product = numberGrid.get(base.getY()).get(base.getX());
        product *= numberGrid.get(base.getY() + 1).get(base.getX() - 1);
        product *= numberGrid.get(base.getY() + 2).get(base.getX() - 2);
        product *= numberGrid.get(base.getY() + 3).get(base.getX() - 3);
        return product;
    }

    private boolean areFourForwardDiagonalNumbersAvailable(ArrayList<ArrayList<Integer>> numberGrid, Couple<Integer, Integer> base) {
        try {
            numberGrid.get(base.getY() + 3).get(base.getX() - 3);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    private int calculateLargestVerticalProduct(ArrayList<ArrayList<Integer>> numberGrid) {
        ArrayList<ArrayList<Integer>> invertedNumberGrid = invertRowsAndColumns(numberGrid);
        int largestInGrid = 0;
        for (ArrayList<Integer> column : invertedNumberGrid) {
            int largestInColumn = calculateLargestFourIntegerProduct(column);
            if (largestInColumn > largestInGrid) {
                largestInGrid = largestInColumn;
            }
        }
        return largestInGrid;
    }

    private ArrayList<ArrayList<Integer>> invertRowsAndColumns(ArrayList<ArrayList<Integer>> grid) {
        ArrayList<ArrayList<Integer>> invertedGrid = new ArrayList<>();
        for (int columnIndex = 0; columnIndex < grid.get(0).size(); columnIndex++) {
            ArrayList<Integer> column = new ArrayList<>();
            for (ArrayList<Integer> row : grid) {
                column.add(row.get(columnIndex));
            }
            invertedGrid.add(column);
        }
        return invertedGrid;
    }

    private int calculateLargestHorizontalProduct(ArrayList<ArrayList<Integer>> numberGrid) {
        int largestInGrid = 0;
        for (ArrayList<Integer> row : numberGrid) {
            int largestInRow = calculateLargestFourIntegerProduct(row);
            if (largestInRow > largestInGrid) {
                largestInGrid = largestInRow;
            }
        }
        return largestInGrid;
    }

    private int calculateLargestFourIntegerProduct(ArrayList<Integer> row) {
        int cellPosition = 0, largest = 0;
        for (Integer cell : row) {
            int product = cell *
                    row.get(cellPosition + 1) *
                    row.get(cellPosition + 2) *
                    row.get(cellPosition + 3);
            if (product > largest)
                largest = product;
            if (cellPosition >= row.size() - 4)
                break;
            else
                cellPosition++;
        }
        return largest;
    }

    private int findLargestInteger(int ... numbers) {
        int largest = numbers[0];
        for (Integer num : numbers)
            if (num > largest)
                largest = num;
        return largest;
    }


    public ArrayList<ArrayList<Integer>> parseNumberGrid(String numberGrid, int length, int height) {
        ArrayList<ArrayList<Integer>> numbers2D = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            numbers2D.add(new ArrayList<>());
            for (int j = 0; j < length; j++) {
                numbers2D.get(i).add(Integer.parseInt(numberGrid.substring(0, 2)));
                if (numberGrid.length() < 3)
                    return numbers2D;
                numberGrid = numberGrid.substring(3);
            }
        }
        return numbers2D;
    }

    private String getGrid() {
        return "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08\n" +
                "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00\n" +
                "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65\n" +
                "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91\n" +
                "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80\n" +
                "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50\n" +
                "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70\n" +
                "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21\n" +
                "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72\n" +
                "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95\n" +
                "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92\n" +
                "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57\n" +
                "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58\n" +
                "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40\n" +
                "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66\n" +
                "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69\n" +
                "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36\n" +
                "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16\n" +
                "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54\n" +
                "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48\n";
    }
}