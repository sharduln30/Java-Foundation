import java.util.Arrays;
import java.util.Scanner;

public class targetSumSubset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int t = sc.nextInt();

        boolean[][] dp = new boolean[n + 1][t + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < t+1; j++) {
                if(dp[i-1][j]){
                    dp[i][j]=true;
                }
                else if(j-arr[i-1]>=0 && dp[i-1][j-arr[i-1]]){
                    dp[i][j]=true;
                }
            }
            
        }

        // for (boolean[] i : dp)
        // System.out.println(Arrays.toString(i));
    
    System.out.println(dp[n][t]);
    }
}