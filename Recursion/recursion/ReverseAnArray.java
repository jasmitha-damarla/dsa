package recursion;

public class ReverseAnArray {

    private void swap(int[] arr, int x, int y) {
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }

    private void reverseAnArray(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, l, r);
            reverseAnArray(arr, l + 1, r - 1);
        }
    }

    public static void main(String[] args) {
        ReverseAnArray reverseAnArray = new ReverseAnArray();
        int[] arr = new int[] { 1, 2, 3, 4 };
        reverseAnArray.reverseAnArray(arr, 0, 3);
        for (int num : arr) {
            System.out.println(num);
        }
    }
}