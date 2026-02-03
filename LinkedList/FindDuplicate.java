package LinkedList;

import java.util.Scanner;

public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int slow = 0, mid = 0, fast = 0;
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) {
                break;
            }
        }
        while(true) {
            slow = nums[slow];
            mid = nums[mid];
            if(slow == mid) {
                return slow;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        FindDuplicate findDuplicate = new FindDuplicate();
        System.out.println(findDuplicate.findDuplicate(arr));
    }
}
