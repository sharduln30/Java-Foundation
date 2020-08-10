import java.io.*;
class recursion{
    static void fun(int n)
    {

        if(n==1){  
            System.out.println(n);
            return;
        }

        System.out.println(n);
        fun(n-1);
        System.out.println(n);
        
    }
    static void table(int n, int i){
    
        if(i>10){
            return;
        }
        
        table( n, i+1);
        System.out.print(n*i+" ");
        

        
    }
    static void tableinrange(int n, int r){
        
        if(r<=0){
            return;
        }
       
        tableinrange( n, r-1);
        System.out.print(n*r+" ");   
        }
    static void odd_even(int n){
        if(n==0) {
            System.out.println();
        return;}

        if(n%2==0) System.out.print(n+" ");
        odd_even(n-1);
        if(n%2!=0) System.out.print(n+" ");
    }
    static void output(int n){
        if(n<=0) return;
        System.out.print("A ");
        output(n-1);
        System.out.print("B ");
        output(n-2);
        System.out.print("C ");
        

    }
    static void output1(int n){
        if(n<=0) return;
        System.out.print("A ");
        output1(n-1);
        System.out.print("B ");
        output1(n-2);
        System.out.print("C ");
        output1(n-3);
        System.out.print("D ");
        

    }
    static int sum_return(int n){
        if(n==1) return n;

       int s= sum_return(n-1);
        return s+n;
    }
    static int factorial(int n){
        if(n==0) return 1;
        if(n<=1) return n;
        int f=factorial(n-1);
        return f*n;
    }
    static int power(int a,int b){
        if(b==1) return a;
        int p=power(a,b-1);
        return p*a; 
    }
    static int[] index_repeat(int[] arr, int i, int f, int c){
        if(i==arr.length-1){
            int[] brr=new int[c];
            return brr;
        }
        if(arr[i]==f){
            c++;
        }
        int[] ans=index_repeat(arr,i+1,f,c);
        if(arr[i]==f){
            ans[c-1]=i;
        }
        return ans;
    }
    public static void main(String[] args){
       
      // int n=2,r=20;
        int[] arr= {10,11,12,65,12,12,14,15,12};
       
      // fun(n);//calling
      // table(n,1);
      // tableinrange(n,r);
      // odd_even(n);
         //output(n);
      //  output1(n);
        // int sum = sum_return(n);
        // System.out.print(sum);
        // int f = factorial(n);
        // System.out.print(f);
        // int p=power(n,4);
        // System.out.print(p);
        int[] brr=index_repeat(arr,0,12,0);
        for(int i:brr){
            System.out.print(i+" ");
        }
    }
}