package BinarySearch;

public class BSearch {
    public static void main(String[] args) {
        int arr[] = {3,6,7,11,14};
        int x=6;

        System.out.println(search(arr, x));
    }

    public static int search(int arr[], int x) {
        int s=0, e=arr.length-1;

        while(s<=e){
            int m = s + (e-s)/2;

            if(x>arr[m])
                s=m+1;

            else if(x<arr[m])
                e=m-1;

            else
                return m;
        }

        return -1;
    }


}
