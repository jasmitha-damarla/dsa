package BinarySearch;

import java.util.Scanner;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n > m) {
            return findMedianSortedArrays(nums2, nums1);
        } 
        int N = n + m;
        int low = 0, high = n;
        int left = (n + m + 1) / 2;
        while(low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if(mid1 < n) {
                r1 = nums1[mid1];
            } 
            if(mid2 < m) {
                r2 = nums2[mid2];
            }
            if(mid1 - 1 >= 0) {
                l1 = nums1[mid1 - 1];
            }
            if(mid2 - 1 >= 0){
                l2 = nums2[mid2 - 1];
            }
            if(l1 <= r2 && l2 <= r1) {
                if(N % 2 == 1) {
                    return Integer.max(l1, l2);
                } 
                return (Integer.max(l1, l2) + Integer.min(r1, r2)) / 2.0;
            } else if(l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        for(int i = 0; i < n1; i++){
            arr1[i] = scanner.nextInt();
        }
        int n2 = scanner.nextInt();
        int[] arr2 = new int[n2];
        for(int i = 0; i < n2; i++) {
            arr2[i] = scanner.nextInt();
        }
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(arr1, arr2));
    }
    
}
