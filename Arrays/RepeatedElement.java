import java.util.Scanner;

// finds the repeated element in array with 0(1) space complexity-> cycle detection method
public class RepeatedElement {

    public int find(int[] nums) {
        if(nums.length <= 1) return -1;

        int slow=0, fast=0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        slow = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        //int[] nums = {1,2,3,4,5,6,3,9};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        System.out.print("Enter array elements: ");
        int[] nums = new int[n];
        for(int i=0 ; i<n ; i++) {
            nums[i] = sc.nextInt();
        }

        RepeatedElement obj = new RepeatedElement();
        System.out.println(obj.find(nums));
    }
}