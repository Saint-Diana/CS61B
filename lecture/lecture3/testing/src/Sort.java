import java.util.Arrays;

public class Sort {
    /** Bubble sort */
    public static void sort(String[] input) {
        for (int i = 0; i < input.length - 1; ++i) {
            for (int j = 0; j < input.length - i - 1; ++j) {
                if (isBiggerThan(input[j], input[j + 1])) {
                    String temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }
    }

    /** selection sort */
    public static void selectionSort(String[] input) {
        selectionSort(input, 0);

        // My code 2:
/*
        // base case: not need to sort
        if (input.length == 1)
            return;

        // Find the index of the smallest item
        int smallestIndex = findSmallest(input);

        // Move it to the front
        swap(input, 0, smallestIndex);

        // Selection sort the rest(using recursion)
        String[] temp = new String[input.length - 1];
        System.arraycopy(input, 1, temp, 0, input.length - 1);
        selectionSort(temp);
        System.arraycopy(temp, 0, input, 1, input.length - 1);
*/


        // My code 1:
/*        for (int i = 0; i < input.length - 1; ++i) {
            String min = "";
            int index = -1;
            for (int j = i; j < input.length; ++j) {
                if (min.isEmpty() || isBiggerThan(min, input[j])) {
                    min = input[j];
                    index = j;
                }
            }
            String temp = input[i];
            input[i] = input[index];
            input[index] = temp;
        }
*/
    }

    private static void selectionSort(String[] x, int start) {
        if (start == x.length)
            return;
        int smallestIndex = findSmallest(x, start);
        swap(x, start, smallestIndex);
        selectionSort(x, start + 1);
    }

    private static int findSmallest(String[] x) {
        int smallestIndex = 0;
        for (int i = 0; i < x.length; i += 1) {
            if (x[smallestIndex].compareTo(x[i]) > 0)
                smallestIndex = i;
        }
        return smallestIndex;
    }

    private static int findSmallest(String[] x, int start) {
        int smallestIndex = start;
        for (int i = start + 1; i < x.length; i += 1) {
            if (x[smallestIndex].compareTo(x[i]) > 0)
                smallestIndex = i;
        }
        return smallestIndex;
    }

    private static void swap(String[] x, int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

    public static boolean isBiggerThan(String first, String second) {
        int i = 0, j = 0;
        while (i < first.length() && j < second.length()) {
            int a = (int) (first.charAt(i)), b = (int) (second.charAt(i));
            if (a == b) {
                ++i;
                ++j;
            } else {
                return a > b;
            }
        }
        return first.length() > second.length();
    }
}
