import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class tcsFact {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc =new Scanner(System.in);
        int[] arr = new int[5];
        for(int i=0;i<5;i++){
            arr[i] = sc.nextInt();
        }
        int[] brr = {1,1,1,1,1};
        int l=0;
        for(int i=0;i<5;i++){
            int k=1;
            for(int j=0;j<arr[i];j++){
                brr[l]*=k++;
            }
            l++;
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(brr[i]);
        }
        
    }
    
   
}
