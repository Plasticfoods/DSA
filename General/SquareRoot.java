class SquareRoot {

    public static int squareRootFloot(int num) {
        if(num <= 0) return -1;
        if(num == 1) return 1;

        int low = 1, high = num;
        int ans = -1;

        while(low <= high) {
            int mid = low + (high-low)/2;
            
            if(mid == num/mid) return mid;
            if(mid < num/mid) {
                high = mid-1;
                ans = mid;
            }
            else {
                low = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int num = 2147483647;
        System.out.println(squareRootFloot(num));
    }
}