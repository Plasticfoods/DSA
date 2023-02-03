class g2 {

    public long makeIntegerBeautiful(long n, int target) {
        long x = 0l;

        while(true) {
            int sum = (int)sumOfDigit(n + x);
            if(sum <= target) return x;
            x++;
        }
    }

    private long sumOfDigit(long n) {
        if(n <= 10) return n;

        long sum = 0;
        while(n != 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}