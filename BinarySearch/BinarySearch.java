
class BinarySearch {

    public static int getFloor(int[] nums, int target) {
        if(nums == null) return -1;

        int res = -1;
        int lo=0, hi=nums.length-1;
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(target == nums[mid]) return mid;
            if(target < nums[mid]) {
                hi = mid-1;
                res = mid;
            }
            else {
                lo = mid+1;
            }
        }

        if(res == -1) {
            return nums.length;
        }
        else {
            return res;
        }
    }   

    public int getCeil(int[] nums, int target) {
        if(nums == null) return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,7,8,11,12,14};
        int target = 6;
        System.out.println(getFloor(nums, target));
    }
}
