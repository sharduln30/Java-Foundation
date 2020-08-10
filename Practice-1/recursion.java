import java.util.*;

class recursion{

    static void rec_desc(int n){
        if(n==0){
            return;
        }
        System.out.print(n+" ");
        rec_desc(n-1);
        
    }
    static int rec_sumtilln(int n){
        if(n==1) 
            return n;
        int sum=rec_sumtilln(n-1);    
        return n+sum;
    }
    
    static int rec_power(int n,int p){
        if(p==1)
            return n;
        int pow=rec_power(n,p-1);
        return pow*n;


    }
    static int[] repeat_index(int[] arr,int i,int val,int c){
        if(i==arr.length-1){
            int[] brr=new int[c];
            return brr;
        }
        if(val==arr[i]){
            c++;
        }
        int[] ans = repeat_index(arr,i+1,val,c);
        if(val==arr[i]){
        ans[c-1]=i;
        }
        return ans;
    }

    static void subsequence(){

    }

    public static void main(String[] args){

        // Scanner sc = new Scanner(System.in);
        // int n=sc.nextInt();
        // rec_desc(n);
        // System.out.println(rec_sumtilln(5));
        // System.out.println(rec_power(2,3));
        // int[] arr= {10,11,12,65,12,12,14,15,12};
        // int[] brr =repeat_index(arr,0,10,0);
        // System.out.println(Arrays.toString(brr));
        subsequence();
        }   
    }



