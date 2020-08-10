import java.util.Arrays;
import java.util.Scanner;

class climbStairsWithVariableJumps {
    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n =sc.nextInt();
        final int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        final int[] dp = new int[n];
        dp[n-1]=1;
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<=i+arr[i] && j<arr.length;j++){
                dp[i]+=dp[j];
            }
           
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[0]);
    }
}