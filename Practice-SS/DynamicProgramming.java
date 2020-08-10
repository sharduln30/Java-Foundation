import java.util.*;
class DynamicProgramming{

    static int rec_fibo(int n){
        if(n==0 || n==1) return n;
        int sum = rec_fibo(n-1)+rec_fibo(n-2);
        return sum;
    }

    static int fibomemo(int n,int[] arr){
        if(n==0 || n==1){
            return n;
        }
        if(arr[n-2]!=0){
            return arr[n];
        }

        int n1=fibomemo(n-1,arr);
        int n2=fibomemo(n-2,arr);
        int sum=n1+n2;
        arr[n]=sum;
        return sum;
    }

    static int tabu(int n){
       int[] arr=new int[n+1];
       
       arr[0]=0;
       arr[1]=1;
       for(int i=2;i<=n;i++){
           arr[i]=arr[i-1]+arr[i-2];
       }

       System.out.println(Arrays.toString(arr));
       return arr[n];

    }

    static void fibonacci(int n){
//    System.out.println( rec_fibo(n));
   
     int[] arr=new int[n+1];
     System.out.println(fibomemo(n,arr));

   // System.out.println(tabu(n));
    }


    static void JumpStairs(int n){
       int arr[] = new int[n+3];
       arr[1]=0;
       arr[0]=0;
       arr[2]=0;
        
       for(int i=3;i<arr.length;i++){
            int min=Math.min(arr[i-1],Math.min(arr[i-2],arr[i-3]));
            arr[i]=min+1;
       }    
       System.out.println(Arrays.toString(arr));     
       System.out.println(arr[n+2]);     
        

    }
    static void MultiJumpStair(){
        int arr[] ={4,2,0,0,2,4,6,3,1,0,1,2,3,1,1};
        int ans[] = new int[arr.length];
        ans[ans.length-1]=1;
        for(int i=arr.length-2;i>=0;i--){
            int sum=0;
            for(int j=1;j<=arr[i];j++){
                if(i+j<=arr.length-1){
                    sum+=ans[i+j];
                } 
            }
            ans[i]=sum;
        }
        System.out.println(Arrays.toString(ans));
        System.out.println(ans[0]);
    }
    static void min_MultiJumpStair(){
        int arr[] ={4,2,0,0,2,4,6,3,1,0,1,2,3,1,1};
        int ans[] = new int[arr.length];
        ans[ans.length-1]=0;
       
        for(int i=arr.length-2;i>=0;i--){
            int min=arr.length;
            for(int j=i+1;j<=i+arr[i] && j<arr.length;j++){
                if(ans[j]<min){
                    min=ans[j];
                    ans[i]=min+1;
                } 
                min=arr.length;
            }
        }
        System.out.println(Arrays.toString(ans));
        System.out.println(ans[0]);
    }
    
    static void minpath(){
        int[][] arr = {{2,7,3,8,0,3,1},
                        {4,0,1,2,4,3,4},
                        {3,8,5,9,0,8,1},
                        {1,6,0,4,5,5,2},
                        {6,2,9,5,7,0,6},
                        {0,8,7,9,6,3,0},
                        {1,3,5,0,5,1,0}};
        int[][] ans = new int[arr.length][arr[0].length];
        for(int i=arr.length-2;i>=0;i--){
            ans[i][arr.length-1]=arr[i][arr.length-1]+ans[i+1][ans.length-1];
    }
        for(int j=arr[0].length-2;j>=0;j--){
            ans[arr[0].length-1][j]=arr[arr[0].length-1][j]+ans[ans[0].length-1][j+1];
        }
        for(int i=arr.length-2;i>=0;i--){
            for(int j=arr[0].length-2;j>=0;j--){
                int min=Math.min(ans[i][j+1],ans[i+1][j]);
                ans[i][j]=min+arr[i][j];
            }
        }
        for(int[] i:ans)
          System.out.println(Arrays.toString(i));  
        
       
    }

    static void goldmine(){
        int[][] arr = {{1,5,1,0,3},
                        {1,4,0,2,3},
                        {4,0,1,3,2},
                        {2,4,0,4,1},
                        {1,2,3,2,0}};
        int[][] ans = new int[arr.length][arr[0].length];

        for(int i=0;i<arr.length-1;i++){
            ans[i][arr[0].length-1]=arr[i][arr[0].length-1];
    }
        
        
            for(int j=arr[0].length-2;j>=0;j--){
        for(int i=0;i<=arr.length-1;i++){
                if(i==0){
                   int max = Math.max(ans[i][j+1],ans[i+1][j+1]);
                   ans[i][j]=arr[i][j]+max;
                }
                else if(i==arr.length-1){
                    int max = Math.max(ans[i][j+1],ans[i-1][j+1]);
                     ans[i][j]=arr[i][j]+max;
                }
                else{
                int max = Math.max(ans[i+1][j+1],Math.max(ans[i][j+1],ans[i-1][j+1]));
                     ans[i][j]=arr[i][j]+max;    
                }
            
            
        }
         }
                for(int[] k:ans){
            System.out.println(Arrays.toString(k));
                }
         int max=Integer.MIN_VALUE;
         for(int i=0;i<ans.length;i++){
             if(max<ans[i][0]){
                 max=ans[i][0];
             }
         }

         System.out.println(max);
    
        
    }
    static void TargetCoin(){
        // int[] arr = {2,1,6,5,9};
        // int target = 8;
         int[] arr = {10,3,2,5,8};
        int target = 9;
        boolean[][] ans = new boolean[arr.length][target+1]; 
        for(int i=0;i<arr.length;i++){
            ans[i][0]=true;
        }
        for(int j=0;j<=target;j++){
            if(arr[0]==j)
                ans[0][j]=true;
        }

        for(int i=1;i<=arr.length-1;i++){
            for(int j=1;j<=target;j++){
                if(ans[i-1][j]) {
                    ans[i][j]=true;
                }
                else if(j-arr[i]<0)
                    ans[i][j]=false;
                else{
                    if(ans[i-1][j-arr[i]])
                        ans[i][j]=true;
                    else
                        ans[i][j]=false;
                }
            }
        }
          for(boolean[] i:ans)
            System.out.println(Arrays.toString(i));
        System.out.println(ans[arr.length][target+1]);
    }

    static void CoinChangePermutation(){
        int[] coin = {2,3,5,6};
        int sum = 7;
        int[] ans=new int[sum+1];
        ans[0] = 1;
        for(int i=1;i<ans.length;i++){
            for(int j=0;j<coin.length;j++){
                if(i-coin[j]>=0){
                    ans[i]+=ans[i-coin[j]];
                }
            }
        }
       

      for(int i:ans)
            System.out.print(i+" ");

    }
    static void CoinChangeCombination(){
        int[] coin = {2,3,5,6};
        int sum = 7;
        int[] ans=new int[sum+1];
        ans[0] = 1;
        for(int j=0;j<coin.length;j++){
        for(int i=1;i<ans.length;i++){
                if(i-coin[j]>=0){
                    ans[i]+=ans[i-coin[j]];
                }
            }
        }
       

      for(int i:ans)
            System.out.print(i+" ");

    }
    static void min_path(int[][] ans,int i,int j){
        System.out.print(ans[i][j]+" -> ");
        if(i==ans.length-1 && j==ans[0].length-1){ 
            return;
        }
        if(i==ans.length-1 && j!=ans[0].length-1){
             min_path(ans,i,j+1);
        }
        else if(j==ans[0].length-1 && i!=ans.length-1) {
             
             min_path(ans,i+1,j);
        }

        else if(Math.min(ans[i+1][j],ans[i][j+1])==ans[i+1][j]){
             
            min_path(ans,i+1,j);
        }
        else{
            min_path(ans,i,j+1);
        }

    }
    static void min_shortestpath(){
        int[][] arr = {{2,7,3,8,0,3,1},
                        {4,0,1,2,4,3,4},
                        {3,8,5,9,0,8,1},
                        {1,6,0,4,5,5,2},
                        {6,2,9,5,7,0,6},
                        {0,8,7,9,6,3,0},
                        {1,3,5,0,5,1,0}};
        int[][] ans = new int[arr.length][arr[0].length];
        for(int i=arr.length-2;i>=0;i--){
            ans[i][arr.length-1]=arr[i][arr.length-1]+ans[i+1][ans.length-1];
    }
        for(int j=arr[0].length-2;j>=0;j--){
            ans[arr[0].length-1][j]=arr[arr[0].length-1][j]+ans[ans[0].length-1][j+1];
        }
        for(int i=arr.length-2;i>=0;i--){
            for(int j=arr[0].length-2;j>=0;j--){
                int min=Math.min(ans[i][j+1],ans[i+1][j]);
                ans[i][j]=min+arr[i][j];
            }
        }
           for(int[] i:ans)
          System.out.println(Arrays.toString(i));  
            min_path(ans,0,0);
        }  
        
       
    static void knapsack01() {
        int[] wt = {2,5,1,3,4};
        int[] profit = {15,14,10,45,30};
        int capacity=7;
        int[][] ans = new int[wt.length][capacity+1];

        for(int j=1;j<capacity+1;j++){
            if(j>=wt[0])
                ans[0][j]=profit[0];
        }


        for(int i=1;i<wt.length;i++){
            for(int j=1;j<capacity+1;j++){

                ans[i][j]=ans[i-1][j];
                if(j-wt[i]>=0){
                    int factor=profit[i]+ans[i-1][j-wt[i]];
                    if(ans[i][j]<factor){
                        ans[i][j]=factor;
                    }                
            }
            }
        }
        for(int[] i:ans){
            System.out.println(Arrays.toString(i));
        }


    }

    static void unboundedKnapSack(){
      
        int[] wt = {2,5,1,3,4};
        int[] profit = {15,14,10,45,30};
        int capacity=7;
        int[] ans = new int[capacity+1];
        
        for(int i=1;i<ans.length;i++){
            int max=0;
            for(int j=0;j<wt.length;j++){
                if(i-wt[j]>=0){
                    int fact = profit[j]+ans[i-wt[j]];
                if(max<fact)
                    max=fact;
                }
                
            }
            ans[i]=max;
        }

        System.out.println(ans.length);
         for(int i:ans){
            System.out.print(i+" ");
        }

}
    static void longestIncreasingSubSequence(){
        int[] arr ={10,21,9,33,22,50,41,60,80,1};
        int[] ans = new int[arr.length];
        ans[0]=1;

        int temp=-1;
        for(int i=1;i<arr.length;i++){
        int max=0;

            for(int j=i-1;j>=0;j--){
                if(arr[i]>arr[j]){
                    if(max<ans[j]){
                    
                         max=ans[j];
                    }
                }
            }
             ans[i]=max+1;
             if(temp<max) temp=ans[i];
        }

        System.out.println(Arrays.toString(ans)); 
        System.out.print(temp+" "); 
    }
    static void longestBitonySubsequence(){
        int[] arr = {10,21,4,33,22,50,41,60,80,1};
        int[] inc = new int[arr.length];
        int[] dec = new int[arr.length];
        int[] ans = new int[arr.length];
        inc[0]=1;

        for(int i=1;i<arr.length;i++){
           int max=0;

            for(int j=i-1;j>=0;j--){
                if(arr[i]>arr[j]){
                    if(max<inc[j]){
                        
                         max=inc[j];
                    }
                }
            }
             inc[i]=max+1;
             
        }

        dec[arr.length-1]=1;
         for(int i=arr.length-2;i>=0;i--){
           int max=0;

            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    if(max<dec[j]){
                        
                         max=dec[j];
                    }
                }
            }
             dec[i]=max+1;
             
        }

        System.out.println(Arrays.toString(inc));
        System.out.println(Arrays.toString(dec));
        
        int lb=-1;

        for(int i=0;i<ans.length;i++){
            ans[i]=inc[i]+dec[i]-1;
            if(lb<ans[i]){
                lb=ans[i];
            }
        }
        System.out.println(Arrays.toString(ans));
        System.out.println(lb);
        
    }
    static void rodCutting(){
        int[] cut = {1,2,3,4,5,6,7,8};
        int[] cost = {3,5,6,15,10,25,12,24};

        int[] ans = new int[cut.length+1];
        ans[0] = 0;
       
        for(int i=1;i<ans.length;i++){
            int max=-1;
            ans[i]=cost[i-1];
            for(int j=1;j<=i/2;j++){
                if(ans[i]<ans[i-j]+ans[j]){
                    ans[i]=ans[i-j]+ans[j];
                }
            }
                   // System.out.print(max+" ");

        }
        System.out.println(Arrays.toString(ans)); 
         System.out.println(ans[ans.length-1]); 
    }

    static void maxSquare(){
        int[][] arr = {{1,0,0,1,0,0,1,0},
                        {1,1,1,1,1,1,1,1},
                        {1,1,0,1,1,1,1,1},
                        {1,0,1,1,1,1,1,0},
                        {0,1,1,1,1,1,1,1},
                        {1,0,1,0,1,1,0,1},
                        {1,0,0,1,1,1,1,1}};
        int max=0;
        int[][] ans = new int[arr.length][arr[0].length];

        for(int i=0;i<arr.length;i++){
            ans[i][arr[0].length-1]=arr[i][arr[0].length-1];
        }
        for(int j=0;j<arr[0].length;j++){
            ans[arr.length-1][j]=arr[arr.length-1][j];
        }
        for(int i=arr.length-2;i>=0;i--){
            for(int j=arr[0].length-2;j>=0;j--){
                if(arr[i][j]==0) continue;
                if(arr[i+1][j]==0 || arr[i+1][j+1]==0 || arr[i][j+1]==0){
                    ans[i][j]=1;
                    
                }
                else{
                ans[i][j]=Math.min(ans[i+1][j],Math.min(ans[i][j+1],ans[i+1][j+1]))+1;
                max=Math.max(max,ans[i][j]);
                }
            }
        }
        for(int[] i:arr)
            System.out.println(Arrays.toString(i));
            System.out.println();

        for(int[] i:ans)
            System.out.println(Arrays.toString(i));
        System.out.println(max);

    }
    static void longestCommonSubsequence(){
        String str1="abed";
        String str2="abcd";
        int[][] arr = new int[str1.length()+1][str2.length()+1];

        int i=0,j=0;
        for(i=1;i<=str2.length();i++){
            for(j=1;j<=str1.length();j++){
                if(str1.charAt(j-1)==str2.charAt(i-1)){
                    arr[i][j]=arr[i-1][j-1]+1;
                }
                else{

                    arr[i][j]=Math.max(arr[i-1][j],arr[i][j-1]);
                }
            }
        }
        System.out.println(arr[i-1][j-1]);
        
        for(int[] k:arr)
        System.out.println(Arrays.toString(k));
        System.out.println(arr[i-1][j-1]);
        




    }

    static void longestpallimsubseq(){

        String str="abckycbc";
        int[][] ans= new int[str.length()][str.length()];

    for(int g=0;g<ans.length;g++){
        for(int i=0;i<ans.length-g;i++){
                int j=i+g;
                if(g==0){
                    ans[i][j]=1;
                }
                else{
                    if(str.charAt(i)==str.charAt(j)){
                        ans[i][j]=ans[i+1][j-1]+2;
                    }else{
                        ans[i][j]=Math.max(ans[i][j-1],ans[i+1][j]);
                    }
                }
               

            }
           
        }
        
        // for(int[] i:ans){
        //     System.out.println(Arrays.toString(i));
        // }

        System.out.println(ans[0][ans.length-1]);
    
    }
    static void noOflongestpallimsubseq(){
    
        String str="abckycbc";
        int[][] ans= new int[str.length()][str.length()];

        for(int g=0;g<ans.length;g++){
            for(int i=0;i<ans.length-g;i++){
                    int j=i+g;
                    if(g==0){
                        ans[i][j]=1;
                    }
                    else{
                        if(str.charAt(i)==str.charAt(j)){
                            ans[i][j]=ans[i][j-1]+ans[i+1][j]+1;
                        }else{
                            ans[i][j]=ans[i][j-1]+ans[i+1][j]-ans[i+1][j-1];
                        }
                    }
                

                }
            
        }
        
        for(int[] i:ans){
            System.out.println(Arrays.toString(i));
        }

        System.out.println(ans[0][ans.length-1]);
    

    }

    static void longestPallinSubstring(){
    
        String str="abccbc";
        boolean[][] ans= new boolean[str.length()][str.length()];

        for(int g=0;g<ans.length;g++){
            for(int i=0;i<ans.length-g;i++){
                    int j=i+g;
                    if(g==0){
                        ans[i][j]=true;;
                    }
                    else if(g==1){
                        if(str.charAt(i)==str.charAt(j)){
                            ans[i][j]=true;
                        }
                        else ans[i][j]=false;
                    }
                    else{
                        if(str.charAt(i)!=str.charAt(j)){
                            ans[i][j]=false;
                        }else{
                            if(ans[i+1][j-1])
                                ans[i][j]=true;
                            else
                                ans[i][j]=false;
                        }
                    }
                

                }
            
        }
        
        for(boolean[] i:ans){
            System.out.println(Arrays.toString(i));
        }    

    }

    static void minPallindromicCut(){
    
        String str="abccbc";
        int[][] ans= new int[str.length()][str.length()];

    
        for(int g=0;g<ans.length;g++){
            for(int i=0;i<ans.length-g;i++){
                    int j=i+g;
                    if(g==0){
                        ans[i][j]=0;
                    }
                    else if(g==1){
                        if(str.charAt(i)==str.charAt(j)){
                            ans[i][j]=0;
                        }
                        else ans[i][j]=1;
                    }
                    else{
                        if(str.charAt(i)==str.charAt(j) && ans[i+1][j-1]==0){
                            ans[i][j]=ans[i+1][j-1];
                        }else{
                           
                            int min=str.length();
                            for(int k=0;k<g;k++){
                            int left=ans[i][i+k];
                            int right=ans[i+k+1][j];
                            if(left+right<min){
                               min=left+right;
                            }
                        }
                        ans[i][j]=min+1;
                        }
                    }
                

                }
            
        }
        
        for(int[] i:ans){
            System.out.println(Arrays.toString(i));
        }    

    }

    static void MatrixChainMultiplication(){
     int[]  dim={10, 20, 30, 40, 50, 60};

        int[][] ans= new int[dim.length-1][dim.length-1];

    
        for(int g=0;g<ans.length;g++){
            for(int i=0;i<ans.length-g;i++){
                    int j=i+g;
                    if(g==0){
                        ans[i][j]=0;
                    }
                    else if(g==1){
                        ans[i][j]=dim[i]*dim[i+1]*dim[i+2];
                    }
                    else{
                       
                           
                            int min=Integer.MAX_VALUE;
                            for(int k=0;k<g;k++){
                            int left=ans[i][i+k];
                            int right=ans[i+k+1][j];
                            int sum=left+right+(dim[i]*dim[i+k+1]*dim[j+1]);
                            if(sum<min){
                               min=sum;
                            }
                        }
                        ans[i][j]=min;
                        
                    }
                

                }
            
        }
        
        for(int[] i:ans){
            System.out.println(Arrays.toString(i));
        }    

    }

    // ============================gfg matrix chain=================
     static void MatrixChainOrdergfg() 
    { 
     int[]  p={10, 20, 30, 40, 30};
     int n=5;
        
        int m[][] = new int[n][n]; 
  
        int i, j, k, L, q; 
  
      
  
       
        for (i = 1; i < n; i++) 
            m[i][i] = 0; 
  
        // L is chain length. 
        for (L=2; L<n; L++) 
        { 
            for (i=1; i<n-L+1; i++) 
            { 
                j = i+L-1; 
                if(j == n) continue; 
                m[i][j] = Integer.MAX_VALUE; 
                for (k=i; k<=j-1; k++) 
                { 
                    // q = cost/scalar multiplications 
                    q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j]; 
                    if (q < m[i][j]) 
                        m[i][j] = q; 
                } 
            } 
        } 
        
         for(int[] ii:m){
            System.out.println(Arrays.toString(ii));
        }
        
    } 

    // ============================gfg matrix chain=================
    

    public static void main(String[] args){
      //  long st=System.currentTimeMillis();
        int n=5;
        //fibonacci(n);
        //JumpStairs(n);
        // long et=System.currentTimeMillis();
        // long dur=et-st;
      //  System.out.println(dur);
     // MultiJumpStair();
     //min_MultiJumpStair();
    // minpath();
    // goldmine();
 //   TargetCoin(); //or TargetSum;
    //CoinChangePermutation();
   // CoinChangeCombination();
  // min_shortestpath();
  //knapsack01();
    //unboundedKnapSack();
   // longestIncreasingSubSequence();
    // longestBitonySubsequence();
    //rodCutting();
    //maxSquare();
    // longestCommonSubsequence();
    //longestpallimsubseq();
    //noOflongestpallimsubseq();
    //longestPallinSubstring();
   // minPallindromicCut();
   MatrixChainMultiplication();
   System.out.println("====================");
     MatrixChainOrdergfg();
    }
}