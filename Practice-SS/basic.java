import java.util.*;

class basic{
static Scanner sc=new Scanner(System.in);

  static void maxin3(){
     // Scanner sc=new Scanner(System.in);
      int n1=sc.nextInt();
      int n2=sc.nextInt();
      int n3=sc.nextInt();

      if(n1>n2 && n1>n3)
        System.out.println(n1);
      else if(n2>n1 && n2>n3)
        System.out.println(n2);
      else 
        System.out.println(n3);
  }
// =============================================
   static void evenodd(){
      int n=5;
      if(n%2==0)
      System.out.println("Even");
      else 
      System.out.println("Odd");
   }

// =============================================
    static void prime(){
        int n=69;
        int c=0;
        for(int i=2;i*i<=n;i++){
            if(n%i==0)
                c++;
        }
        if(c==0)
        System.out.println("Prime");
        else 
        System.out.println("Not Prime");
        
    }
// =============================================
    static void primetilln(){
        int n=100;
        for(int i=2;i<=n;i++){
            int c=0;
            for(int j=2;j*j<=i;j++){
                if(i%j==0) c++;}
            if(c==0) System.out.println(i);
                
        }
    }
// =============================================
    static void fibonacci(){
        int n=10;
        int s=0;
        int a=0,b=1;
        System.out.print(a+" ");
        System.out.print(b+" ");
        for(int i=2;i<=n;i++){
            b=a;
            a=s;
            s=a+b;
            System.out.print(s+" ");
        }
    }
// =============================================
    static int countdigit(int n){
        //int n=6574;
        int c=0;
        while(n>0){
            c++;
            n/=10;
        }
        //System.out.println(c);
        return c;
    }  
// =============================================
    static void reverseno(){
        int n=6574;
        int rev=0;
        int r=0;
        while(n>0){
            r=n%10;
            rev=rev*10+r;
            n/=10;
        }
        System.out.println(rev);
    }
// =============================================
    static void rotation(){
        int num=12345;
        int r=100;
        int size=countdigit(num);
        int div=1;
        int mul=1;
        if(r<0)
            r=(r%size)+size;
        else
            r=r%size;
        for(int i=1;i<=size;i++){
            if(i<=r)
                mul*=10;
            else
                div*=10;
        }
        int rotate=(num%div)*mul+(num/div);
        System.out.println(rotate);


    }
// =============================================
   static void gcd(){
       int a=22,b=14;
       int n1=a;
       int n2=b;
        int r=0;
        //    System.out.println(a%b);
       while(a!=0){
           r=b%a;
           b=a;
           a=r;

       }  
       System.out.println("GCD"+b);
       int lcm=(n1*n2)/b;
       System.out.println("LCM"+lcm);
       
   }

// =============================================

    static void pythgoras_triplet(){
        
        int a=24,b=26,c=10;
       if(a*a+b*b==c*c)
        System.out .println("Triplet found");
        else if(b*b+c*c==a*a) 
        System.out .println("Triplet found");
         else if(a*a+c*c==b*b) 
        System.out .println("Triplet found");
        else
        System.out .println("Not Triplet found");
        
        

        }

// =============================================

    static void bulb(){
        int n=20;
        for(int i=1;i*i<=n;i++){
            System.out.println(i*i+" ");
        }
    }

// =============================================

static void array(){
    int[] arr = {1,2,3,4,5,98,7,8,9,10};//user deefine
    
//    System.out.println("Enter the size of array");
//     int n=sc.nextInt();
//     int[] arr=new int[n];

    // for(int i=0;i<arr.length;i++){
    //     arr[i]=sc.nextInt();
    // }
    //foreach loop
    int n=81;
    int c=0;
    for(int i:arr){
        if(i==n)
        c=1;
    }
    if(c==1)
    System.out.println("Found");
    else 
    System.out.println("Not Found");
    int max=Integer.MIN_VALUE;
    for(int i:arr){
        if(i>max)
            max=i;
    }
    System.out.println("Max="+max);
    int min=Integer.MAX_VALUE;
    for(int i:arr){
        if(i<min)
            min=i;
    }
    System.out.println("Min="+min);
    
}

// =============================================

    static void array_inverse(){

        int[] arr={2,3,0,1,6,4,5};
        for(int i=0;i<arr.length;i++){
            int temp=arr[i];
            arr[i]=arr[arr[i]];
            arr[arr[i]]=temp;
        }
        for(int i:arr){
            System.out.print(arr[i]+" ");
        }
    }
// =============================================

    static int  max_arr(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int i:arr){
        if(i>max)
            max=i;
    }
    return max;
    }

    static void bargraph(){
        int[] arr = {2,0,3,12,4,1};
        int max=max_arr(arr);
    
        int temp=max;
        for(int i=1;i<=temp;i++){
            for(int j=0;j<=arr.length-1;j++){
               if(max<=arr[j]){
                   System.out.print(" * ");
               }
               else{
                  System.out.print("   ");
               }
               
           }
               max--;
            System.out.println();
    }
    }
// =============================================

static void ceil_floor(){
    int n=80;
    int[] arr={1,2,5,85,80,81,90};

    int max=Integer.MAX_VALUE;
    int min=Integer.MIN_VALUE;
  //  int ceil,floor;
    for(int i=0;i<arr.length;i++){
        if(arr[i]>n && arr[i]<max){
            max=arr[i];
            
        }
        if(arr[i]<n && arr[i]>min){
            min=arr[i];
        }
       
    }
     System.out.println(max+"  "+min);

}
static void array_rotation(){
    int[] arr = {1,2,3,4,5};
    int n=-2;
    if(n<0){
        n=n%arr.length+arr.length;
    }
    else
        n=n%arr.length;

    for(int i=0,j=n-1;i<j;i++,j--){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    System.out.println(Arrays.toString(arr));
    for(int i=n,j=arr.length-1;i<j;i++,j--){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    System.out.println(Arrays.toString(arr));


    for(int i=0,j=arr.length-1;i<j;i++,j--){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
 System.out.println(Arrays.toString(arr));
    }



// =============================================
    public static void main(String[] args){
        //maxin3();
        //evenodd();
        //prime();
        //primetilln();
        //fibonacci();
        //countdigit(int n);
        //reverseno();
        //rotation();
        //gcd();
        //pythgoras_triplet();
        //bulb();
       // array();
      // ceil_floor();
       array_rotation();
       //array_reverse(); NOT DONE
       //array_inverse();NOT DONE
    //    bargraph();
    }
}
