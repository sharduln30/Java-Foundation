import java.util.Arrays;
import java.util.Scanner;

public class countBinaryStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[2][n+1];
        dp[0][1]=1;
        dp[1][1]=1;
        
        for (int j = 2; j < n+1; j++) {
            dp[0][j]=dp[1][j-1];
            dp[1][j]=dp[0][j-1]+dp[1][j-1];        
        }
        System.out.println(dp[0][n]+dp[1][n]);
        // for(int[] i:dp)
        //     System.out.println(Arrays.toString(i));

    }
}