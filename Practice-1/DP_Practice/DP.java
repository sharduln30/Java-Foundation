import java.util.*;

class DP {

    static int fib_memoization(int n, int[] arr) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        int fib1 = fib_memoization(n - 1, arr);
        int fib2 = fib_memoization(n - 2, arr);

        int sum = fib1 + fib2;
        arr[n] = sum;
        return sum;
    }

    static void fib_tabulation(int n, int[] arr) {
        if (n == 0) {
            System.out.print(n);
            return;
        }
        if (n == 1) {
            System.out.print(n);
            return;
        }
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = arr[i - 1] + arr[i - 2];
            arr[i] = sum;
        }
        System.out.print(arr[n]);
    }

    static void stairpath(int n, int[] arr) {

        if (n == 0 || n == 1) {
            System.out.print(1);
            return;
        }
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = arr[i - 1] + arr[i - 2];
            arr[i] = sum;
        }
        System.out.print(arr[n]);
    }

    static void minpath(int n, int[] arr) {
        if (n == 0 || n == 1) {
            System.out.print(1);
            return;
        }
        arr[0] = 1;
        arr[1] = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            int min = Math.min(arr[i - 1], arr[i - 2]);
            arr[i] = min + 1;

        }
        System.out.print(arr[n]);
    }

    static void mincount(int[] jump, int[] arr) {

        arr[jump.length - 1] = 1;
        arr[jump.length - 2] = 1;

        for (int i = jump.length - 3; i >= 0; i--) {
            if (jump[i] + i >= jump.length) {
                return;
            }
            int sum = 0;
            for (int j = 1; j <= jump[i]; j++) {
                if (i + j > arr.length) {
                    return;
                }
                sum = sum + arr[i + j];
            }
            arr[i] = sum;
        }
        System.out.println(Arrays.toString(jump));
        System.out.println(Arrays.toString(arr));
    }

    static void minjump(int[] jump, int[] arr) {

        arr[jump.length - 1] = 0;
        arr[jump.length - 2] = 1;

        for (int i = jump.length - 3; i >= 0; i--) {
            if (jump[i] + i >= jump.length) {
                return;
            }
            if (jump[i] == 0) {
                arr[i] = jump[i];
                continue;
            }
            int min = Math.min(arr[i + 1], arr[i + 2]);
            for (int j = 2; j <= jump[i]; j++) {
                if (i + j > arr.length) {
                    return;
                }

                min = Math.min(min, arr[i + j]) + 1;
            }
            arr[i] = min;
        }
        System.out.println(Arrays.toString(jump));
        System.out.println(Arrays.toString(arr));
    }




    static void minpathrec(int[][] ans, int i, int j, int rdes, int cdes, String res) {
        if (i == rdes-1 && j == cdes-1) {
            if(ans[i][j+1]<ans[i+1][j])
                System.out.println(res+" H  V ");
                else
                System.out.println(res+" V  H ");
                return;
        }
       
       
        
        if (ans[i + 1][j] < ans[i][j+1]) {
            minpathrec(ans,i+1,j,rdes,cdes,res+" V ");
        }
        else if (ans[i][j+1] < ans[i+1][j]) {
            minpathrec(ans,i,j+1,rdes,cdes,res+" H ");
        }
    }

    static void minpath(int[][] arr) {

        int[][] ans = new int[arr.length][arr[0].length];
        for (int i = arr.length - 2; i >= 0; i--) {

            ans[i][ans[0].length - 1] = ans[i + 1][ans[0].length - 1] + arr[i][ans[0].length - 1];
        }
        for (int j = arr[0].length - 2; j >= 0; j--) {
            ans[ans.length - 1][j] = ans[ans.length - 1][j + 1] + arr[ans.length - 1][j];
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = arr[0].length - 2; j >= 0; j--) {
                ans[i][j] = arr[i][j] + Math.min(ans[i + 1][j], ans[i][j + 1]);
            }
        }

        for (int[] i : ans) {
            System.out.println(Arrays.toString(i));
        }

        minpathrec(ans, 0, 0, ans.length - 1, ans[0].length - 1, "");
    }

    static void goldmine(int[][] arr){

        int[][] cost = new int[arr.length][arr[0].length];
        for(int i=arr.length-2;i>=0;i--){
            cost[i][arr[0].length-1] = arr[i][arr[0].length-1];
        }

        for(int j=arr[0].length-2;j>=0;j--){

            for(int i=arr.length-1;i>=0;i--){
                if(i==arr.length-1){
                    cost[i][j] = arr[i][j]+ Math.max(cost[i-1][j+1],cost[i][j+1]);
                }
                else if(i==0){
                    cost[i][j] = arr[i][j]+Math.max(cost[i][j+1],cost[i+1][j+1]);
                 } 
                 else{
                     cost[i][j] = arr[i][j]+Math.max(Math.max(cost[i-1][j+1],cost[i][j+1]),cost[i+1][j+1]);
                 } 
              }
            }

        for(int[] i:cost){
            System.out.println(Arrays.toString(i));
        }   
        int max=Integer.MIN_VALUE;
        for(int i=0;i<cost.length;i++){
            if(cost[i][0]>max){
                max=cost[i][0];
            }
        }
        System.out.println(max);
    }
   
    static int targetSumrec(int i,int[] arr,int target,String asf){
        if(target<=0 || i==arr.length){
          if(target==0){
              System.out.println(asf);
                 return 1;
          }

          return 0;
           
        }
        
        int sum=0;
        sum += targetSumrec(i+1,arr,target-arr[i],asf+arr[i]);
        
        sum+=targetSumrec(i+1,arr,target,asf);
        
        return sum;
    }

    static void targetSumdp(int[] arr,int target){

    
        boolean[][] isTarget = new boolean[arr.length][target+1];
        for(int i=0;i<arr.length;i++){
                isTarget[i][0]=true;
        }
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<target+1;j++){
                if(i==0){
                    if(arr[i]==j){
                        isTarget[i][j]=true;
                    }
                }
                else{
                    if(!isTarget[i-1][j]){
                        if(j-arr[i]>=0){
                        isTarget[i][j] = isTarget[i-1][j-arr[i]];
                        }
                        else{}
                    }
                    else{
                        isTarget[i][j] = isTarget[i-1][j];
                    }
                }
            }
        }
        for(boolean[] i:isTarget){
            System.out.println(Arrays.toString(i));
        }
    }


    static void coinChangePermutationDP(int[] arr, int sum){

        int[] ans = new int[sum+1];
        ans[0]=1;
        for(int j=0;j<arr.length;j++){
        for(int i=1;i<ans.length;i++){
                if(i-arr[j]>=0){
                    ans[i]+=ans[i-arr[j]];
                }
            }
        }
        System.out.print(Arrays.toString(ans));
    }

    static void coinChangePermutationRec(int[] arr, int sum,String ans){
        
        if(sum<=0){
            if(sum==0)
                System.out.println(ans);
           return; 
        }

        for(int j=0;j<arr.length;j++){
            coinChangePermutationRec(arr,sum-arr[j],ans+" "+arr[j]);
        }
    }

    static void coinChangeCombinationRec(int idx,int[] arr, int sum , String asf){
        if(sum<=0){
            if(sum==0)
                System.out.println(asf);
            return;
        }

        for(int i=idx;i<arr.length;i++){
            coinChangeCombinationRec(i,arr,sum-arr[i],asf+arr[i]);
        }
       
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int[] arr = new int[n + 1];
        // System.out.print(fib_memoization(n,arr));//O(2^n)
        // fib_tabulation(n,arr);//O(n)
        // stairpath(n,arr);
        // minpath(n, arr);
        // int[] jump = { 6, 3, 3, 0, 0, 2, 2, 3 };
        // int[] arr1 = new int[jump.length];
        // mincount(jump, arr1);// min count stairs
        // minjump(jump,arr1);
        // int[][] twoD = { { 2, 7, 3, 8, 0, 3, 1 }, { 4, 0, 1, 2, 4, 3, 4 }, { 3, 8, 5, 9, 0, 8, 1 },
        //         { 1, 6, 0, 4, 5, 5, 2 }, { 6, 2, 9, 5, 7, 0, 6 }, { 0, 8, 7, 9, 6, 3, 0 }, { 1, 3, 5, 0, 5, 0, 0 } };
        // minpath(twoD);
        // int[][] gold = {{1,5,1,0,3},
        //                 {1,4,0,2,3},
        //                 {4,0,1,3,2},
        //                 {2,4,0,4,1},
        //                 {1,2,3,2,0}};
        // goldmine(gold);
        // int[] arr = {2,1,6,5,9};
        // int target = 8;
        // System.out.println(targetSumrec(0,arr, target,""));
        // targetSumdp(arr,target);
        int[] arr = {2,3,5,6};
        int sum=7;
        // coinChangePermutationRec(arr,sum,"");
        // coinChangePermutationDP(arr,sum);
        coinChangeCombinationRec(0,arr,sum,"");

    }
}
