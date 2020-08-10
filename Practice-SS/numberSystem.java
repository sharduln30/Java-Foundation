import java.util.*;
class numberSystem{

    static void decToAny(int n, int b){
        
        int[] arr = new int[10];
        int i=0;
        while(n>=1){
            arr[i++]=n%b;
            n/=b;
        }
        for(i=arr.length-1;i>=0;i--){
            System.out.print(arr[i]);
        }
    }
    static void anyToDecimal(int n,int b){
        int i=0,r=0,dec=0;
        while(n>0){
            r=n%10;
            dec+=Math.pow(b,i++)*r;
            n/=10;
        }
        System.out.print(dec);
    }
    public static void main(String [] args){
       Scanner sc = new Scanner(System.in); 
       int n= sc.nextInt();
       int b=sc.nextInt();
      decToAny(n,b);
      System.out.println(Integer.toOctalString(n));
       anyToDecimal(n,b);

    }
}