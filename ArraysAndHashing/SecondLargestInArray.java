package ArraysAndHashing;

public class SecondLargestInArray {

    public int secondLargestElement(int[] nums) {
        int large = nums[0], seclarge = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > large) {
                seclarge = large;
                large = nums[i];
            } else if (nums[i] < large && nums[i] > seclarge) {
                seclarge = nums[i];
            }
        }
        return seclarge;
    }

    public static void main(String[] args) {
        SecondLargestInArray sol = new SecondLargestInArray();

        // Test case 1: Standard case
        int[] nums1 = { 1, 3, 2, 5, 4 };
        System.out.println("nums1: " + java.util.Arrays.toString(nums1));
        System.out.println("Second largest: " + sol.secondLargestElement(nums1)); // 4
        System.out.println();

        // Test case 2: Duplicates
        int[] nums2 = { 5, 5, 4, 3, 2 };
        System.out.println("nums2: " + java.util.Arrays.toString(nums2));
        System.out.println("Second largest: " + sol.secondLargestElement(nums2)); // 4
        System.out.println();

        // Test case 3: All same elements
        int[] nums3 = { 1, 1, 1, 1 };
        System.out.println("nums3: " + java.util.Arrays.toString(nums3));
        System.out.println("Second largest: " + sol.secondLargestElement(nums3)); // Integer.MIN_VALUE
        System.out.println();

        // Test case 4: Only 2 elements
        int[] nums4 = { 10, 5 };
        System.out.println("nums4: " + java.util.Arrays.toString(nums4));
        System.out.println("Second largest: " + sol.secondLargestElement(nums4)); // 5
    }

}
