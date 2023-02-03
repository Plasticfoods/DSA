public static int lis(int[] arr) {
    //     int n = arr.length;
    //     if(n==0 || n==1)
    //         return n;

    //     int[] lisCount = new int[n];
    //     for(int i=0 ; i<n ; i++){
    //         int lis = 0;
    //         for(int j=i-1 ; j>=0 ; j--){
    //             if(arr[i] > arr[j] && lis < lisCount[j])
    //                 lis = lisCount[j];
    //         }
    //         lisCount[i] = lis + 1;
    //     }

    //     int maxlis = 1;
    //     for(int i=0 ; i<n ; i++){
    //         if(maxlis < lisCount[i])
    //             maxlis = lisCount[i];
    //     }
    //     return maxlis;
    // }