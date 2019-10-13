package com.fun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CasinoPlay {

    /**
     * Construct a rectangle road
     * * first row and first column is : play round
     * * the inside number are the value from [row] to [column]
     * <p>
     * example : we have : 2, -3, 5, -1, -2, -3, 6
     * <p>
     * 1  2  3  4  5  6  7
     * 1 2 -1
     * 2   -3  2  1
     * 3       5
     * 4         -1 -3 -6
     * 5            -2
     * 6               -3
     * 7                   6
     * <p>
     * result : -6 from [4]th round to [6]th round
     */

    public int beatMe(Integer[] input) {

    final List<Integer> readInput = Arrays.asList(input);

        Integer[][] metric = new Integer[readInput.size()][readInput.size()];

        for (int row = 0; row < readInput.size(); row++) {
            metric[row][row] = readInput.get(row);
        }


        LinkedList<Integer> rowToCalculate = new LinkedList<>();

        rowToCalculate.add(0);
        Integer result = metric[0][0] < 0 ? metric[0][0] : Integer.MAX_VALUE;
        int minRow = 0;
        int minColumn = 0;

        for (int column = 1; column < readInput.size(); column++) {
            //
            Integer min = metric[column][column];

            if (result > min) {
                result = min;
                minRow = column;
                minColumn = column;
            }
            while (rowToCalculate.size() != 0) {
                final Integer calculRow = rowToCalculate.poll();

                if (calculRow != column) {
                    // do calculation
                    final int value = metric[calculRow][column - 1] + metric[column][column];
                    metric[calculRow][column] = value;
                    if (min > value) {
                        min = value;
                        if (result > min) {
                            result = value;
                            minRow = calculRow;
                            minColumn = column;
                        }
                    }
                }
            }

            for (int row = 0; row <= column; row++) {
                if (metric[row][column] != null && metric[row][column] <= min) {
                    rowToCalculate.add(row);
                }
            }

        }

        System.out.println("row : " + minRow);
        System.out.println("column : " + minColumn);

        return result > 0 ? 0 : result;
    }
}
