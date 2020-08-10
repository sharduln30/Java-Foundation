import java.io.*;
import java.util.*;

public class Asc {

    static void asc(int[] arr,int [] brr, int m,int n){
        int[] ans = new int[m+n];
        for(int i=0;i<m;i++){
            ans[i]=arr[i];
        }
        int k=0;
       
        for(int i=m;i<m+n;i++){
            ans[i]=brr[k++];
        }
        // System.out.print(Arrays.toString(ans));
        
        for(int i=0;i<m+n;i++){
            for(int j=1;j<m+n-i;j++){
                if(ans[j-1]>ans[j]){
                    int temp=ans[j-1];
                    ans[j-1]=ans[j];
                    ans[j] =temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(brr));
        System.out.println(Arrays.toString(ans));
    }

    public static void main(String[] args) throws Exception {
       
        Scanner sc = new Scanner(System.in);
        
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[] arr = new int[m];
        for(int i=0;i<m;i++){
            arr[i]=sc.nextInt();
        }
        int[] brr = new int[n];
        for(int i=0;i<n;i++){
            brr[i]=sc.nextInt();
        }
        
        asc(arr,brr,m,n);
        
        
       
    }

}
