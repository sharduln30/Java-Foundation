import java.util.*;
class Kadane {
    public static void main(String[] args){

        int[] arr= {2, -1, 2, 3, 4,-5};

        int gmax = Integer.MIN_VALUE;
         int[] subarr = new int[arr.length];
        int pos=0;
         int k=0; 
        subarr[0] = arr[0];
        for (int i = 1; i < arr.length ; i++) {
            subarr[i] = Math.max(arr[i], arr[i] + subarr[i - 1]);
            gmax = Math.max(subarr[i], gmax);
             pos=i;
            k++;
            System.out.println(Arrays.toString(subarr));
        } 

        
        int i=0;
        int[] brr = new int[k];
        // while (subarr [pos]>0) {
        //     brr[i++]=subarr[pos--];
        // }
        System.out.println(gmax);
    }
}