package BinarySearch;

public class Floor {
    public static void main(String[] args) {
        int arr[] = {2, 4, 4, 4, 5, 8, 11};
        int x=4;

        System.out.println(floor(arr, x));
    }

    public static int floor(int arr[], int x) {
        int s=0, e=arr.length-1;

        while(s<=e){
            int m = s + (e-s)/2;

            if(x>arr[m])
                s=m+1;

            else
                e=m-1;
        }

        return s;
    }

}
