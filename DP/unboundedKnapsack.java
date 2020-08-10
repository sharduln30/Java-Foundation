import java.util.Arrays;
import java.util.Scanner;

public class unboundedKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }
        int[] wt = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }
        int cap = sc.nextInt();

        int[] dp = new int[cap+1];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < cap+1; j++) {
                if(j>=wt[i])
                    dp[j]=Math.max(dp[j - wt[i]]+val[i],dp[j]);
            }
        }
        System.out.println(dp[cap]);
    }
}