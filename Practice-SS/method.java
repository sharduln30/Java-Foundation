import java.util.*;
class method{

    static void add(int a, int b){
        int sum=a+b;
        System.out.println("Sum="+sum);
    }
    
    static void sub(int a, int b){
        int sub=a-b;
        System.out.println("Sub="+sub);
    }
    
    static void mul(int a, int b){
        int mul=a*b;
        System.out.println("Mul="+mul);
    }
    
    static void div(int a, int b){
        int div=a/b;
        System.out.println("Div="+div);
    }
    static int[] input(){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr =new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        return arr;
    }
    static int sum1(){
        int a=9, b=12;
        return a+b;
    }
    
    static int sub1(){
        int a=9, b=12;
        return a-b;
    }
    
    static int mul1(){
        int a=9, b=12;
        return a*b;
    }
    
    static int div1(){
        int a=9, b=12;
        return a/b;
    }
    static int sumArr(int[] arr){
        int sum=0;
      for(int i=0;i<arr.length;i++){
          sum+=arr[i];
      }
      return sum;
    }
    public static void main(String[] args){
       
        //int a=8,b=10;
        //add(a,b);
        //sub(a,b);
        //mul(a,b);
        //div(a,b);
         int[] arr =input();
         for(int i:arr){
             System.out.print(i+" ");
         }
        int sum= sumArr(arr);
        System.out.println("\nSum="+sum);
        // int sum=sum1();
        // int sub=sub1();
        // int mul=mul1();
        // int div=div1();
    }
}