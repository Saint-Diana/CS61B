/**
 * Test the Sort class.
 */
public class TestSort {
    /** Test the Sort.sort method */
    public static void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"}; /* the expected output of Sort.sort(input) */
        Sort.selectionSort(input);

        org.junit.Assert.assertArrayEquals(expected, input);

//        if (!isEqual(input, expected)) { /* equals to '!java.util.Arrays.equals(input, expected)' */
//            System.out.println("Error! There seems to be a problem with Sort.sort.");
//        }
    }

    private static boolean isEqual(String[] first, String[] second) {
        if (first.length != second.length)
            return false;
        for (int i = 0; i < first.length; ++i) {
            if (!first[i].equals(second[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        testSort();
    }
}
