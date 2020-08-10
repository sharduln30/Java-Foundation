import java.util.Scanner;

public class arrangeBuildings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] dp = new long[2][n+1];
        dp[0][1]=1;
        dp[1][1]=1;
        
        for (int j = 2; j < n+1; j++) {
            dp[0][j]=dp[1][j-1];
            dp[1][j]=dp[0][j-1]+dp[1][j-1];        
        }
        long ans = dp[0][n]+dp[1][n];
        System.out.println(ans*ans);
    }
   
}