package ArraysAndHashing;

public class CheckIfArrayIsSorted {

    public boolean isSorted(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckIfArrayIsSorted sol = new CheckIfArrayIsSorted();

        // Test case 1: Sorted ascending
        int[] arr1 = { 1, 2, 3, 4, 5 };
        System.out.println("arr1: " + java.util.Arrays.toString(arr1));
        System.out.println("Is sorted: " + sol.isSorted(arr1, arr1.length)); // true
        System.out.println();

        // Test case 2: Not sorted
        int[] arr2 = { 1, 3, 2, 4, 5 };
        System.out.println("arr2: " + java.util.Arrays.toString(arr2));
        System.out.println("Is sorted: " + sol.isSorted(arr2, arr2.length)); // false
        System.out.println();

        // Test case 3: Duplicates (still sorted)
        int[] arr3 = { 1, 1, 1, 2, 2 };
        System.out.println("arr3: " + java.util.Arrays.toString(arr3));
        System.out.println("Is sorted: " + sol.isSorted(arr3, arr3.length)); // true
        System.out.println();

        // Test case 4: Single element
        int[] arr4 = { 42 };
        System.out.println("arr4: " + java.util.Arrays.toString(arr4));
        System.out.println("Is sorted: " + sol.isSorted(arr4, arr4.length)); // true
        System.out.println();

        // Test case 5: Reverse sorted
        int[] arr5 = { 5, 4, 3, 2, 1 };
        System.out.println("arr5: " + java.util.Arrays.toString(arr5));
        System.out.println("Is sorted: " + sol.isSorted(arr5, arr5.length)); // false
    }
}
