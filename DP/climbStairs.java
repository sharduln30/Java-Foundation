import java.util.Scanner;

class climbStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[0]=1;
        if(n==0) {
            System.out.println(dp[0]);
            return;
        }
        dp[1]=1;
            if(n==1) {
                System.out.println(dp[1]);
                return;
            }
        dp[2]=2;
        for (int i = 3; i < dp.length; i++) {
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        System.out.println(dp[n]);
    }
}